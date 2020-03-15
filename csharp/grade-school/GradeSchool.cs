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
            List<string> names = new List<string>();
            names.Add(student);
            _namesByGrade.Add(grade, names);
        }
        else
        {
           var lazy = _namesByGrade[grade];
           lazy.Add(student);
           lazy.Sort();
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