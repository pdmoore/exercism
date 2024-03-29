﻿using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.ConstrainedExecution;

public static class Tournament
{
    private const int TeamNameWidth = 31;
    private const string ColumnSeparator = "|";
    private const string TitleMatchesPlayed = "MP";
    private const string TitleWins = "W";
    private const string TitleDraws = "D";
    private const string TitleLosses = "L";
    private const string TitlePoints = "P";

    private const int TeamName1 = 0;
    private const int TeamName2 = 1;
    private const int MatchResult = 2;

    public static void Tally(Stream inStream, Stream outStream) => OutputStatistics(outStream, TallyStatistics(inStream));

    private static Dictionary<string, TeamStatistic> TallyStatistics(Stream inStream) {
        Dictionary<string, TeamStatistic> teamStatistics = new Dictionary<string, TeamStatistic>();
        if (inStream.Length <= 0)
        {
            return teamStatistics;
        }

        StreamReader sr = new StreamReader(inStream);
        string line;
        while ((line = sr.ReadLine()) != null) {
            var matchElements = line.Split(";");
            var teamStat1 = GetTeamStatisticFor(teamStatistics, matchElements[TeamName1]);
            var teamStat2 = GetTeamStatisticFor(teamStatistics, matchElements[TeamName2]);
            TallyMatch(matchElements[MatchResult], teamStat1, teamStat2);
        }

        return teamStatistics;
    }

    private static void TallyMatch(string matchResult, TeamStatistic team1, TeamStatistic team2) {
        switch (matchResult) {
            case "win":
                team1.AddWin();
                team2.AddLoss();
                break;
            case "loss":
                team1.AddLoss();
                team2.AddWin();
                break;
            default:
                team1.AddDraw();
                team2.AddDraw();
                break;
        }
    }

    private static TeamStatistic GetTeamStatisticFor(Dictionary<string, TeamStatistic> teamStatistics, string teamName) {
        TeamStatistic teamStat1;
        if (teamStatistics.ContainsKey(teamName)) {
            teamStat1 = teamStatistics[teamName];
        }
        else {
            teamStat1 = new TeamStatistic {Name = teamName};
            teamStatistics.Add(teamStat1.Name, teamStat1);
        }

        return teamStat1;
    }

    private static IOrderedEnumerable<KeyValuePair<string, TeamStatistic>> StatsByWinsThenNames(Dictionary<string, TeamStatistic> teamStatistics) =>
        teamStatistics
            .OrderByDescending(i => i.Value.Score())
            .ThenBy(i=> i.Value.Name);

    private static void OutputStatistics(Stream outStream, Dictionary<string, TeamStatistic> teamStatistics) {
        StreamWriter sw = new StreamWriter(outStream);
        AddTableHeader(sw);
        foreach (KeyValuePair<string, TeamStatistic> entry in StatsByWinsThenNames(teamStatistics)) {
            sw.Write("\n");
            var stats = entry.Value;
            sw.Write(
                $"{stats.Name.PadRight(31)}|" +
                $"{stats.MatchesPlayed().ToString().CenterTitle()}|" +
                $"{stats.Wins.ToString().CenterTitle()}|" +
                $"{stats.Draws.ToString().CenterTitle()}|" +
                $"{stats.Losses.ToString().CenterTitle()}|" +
                $"{stats.Score().ToString().PadLeft(3)}");
        }

        sw.Flush();
    }

    private static void AddTableHeader(StreamWriter sw)
    {
        sw.Write("Team".PadRight(TeamNameWidth, ' '));
        sw.Write(CenteredColumnTitle(TitleMatchesPlayed));
        sw.Write(CenteredColumnTitle(TitleWins));
        sw.Write(CenteredColumnTitle(TitleDraws));
        sw.Write(CenteredColumnTitle(TitleLosses));
        sw.Write(ColumnSeparator);
        sw.Write(TitlePoints.PadLeft(3));
    }

    private static string CenteredColumnTitle(string name) => ColumnSeparator + name.CenterTitle();
}

internal class TeamStatistic
{
    public string Name;
    public int Wins;
    public int Losses;
    public int Draws;
    
    public int Score() => (3 * Wins) + Draws;

    public void AddWin() => Wins++;

    public void AddLoss() => Losses++;

    public void AddDraw() => Draws++;

    public int MatchesPlayed() => Wins + Losses + Draws;
}

public static class String
{
    private const int ColumnWidth = 4;
    
    public static string CenterTitle(this string str)
    {
        int padding = ColumnWidth - str.Length;
        int padLeft = padding / 2 + str.Length;
        if (str.Length % 2 != 0)
        {
            padLeft += 1;
        }

        return str.PadLeft(padLeft, ' ').PadRight(ColumnWidth, ' ');
    }
}