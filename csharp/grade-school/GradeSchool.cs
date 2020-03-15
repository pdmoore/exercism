using System;
using System.Collections;
using System.Collections.Generic;

public class GradeSchool
{
    private SortedDictionary<int, List<string>> _namesByGrade = new SortedDictionary<int, List<string>>();

    public void Add(string student, int grade)
    {
        if (_namesByGrade.ContainsKey(grade) == false)
        { 
            List<string> names = new List<string>() { student };
            _namesByGrade.Add(grade, names);
        }
        else
        {
           _namesByGrade[grade].Add(student);
           _namesByGrade[grade].Sort();
        }
    }

    public IEnumerable<string> Roster()
    {
        List<string> allNames = new List<string>();
        foreach (var grade
            in _namesByGrade.Keys)
        {
            allNames.AddRange(_namesByGrade[grade]);
        }

        return allNames;
    }

    public IEnumerable<string> Grade(int grade)
    {
        throw new NotImplementedException("You need to implement this function.");
    }
}