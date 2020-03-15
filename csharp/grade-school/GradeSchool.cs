using System;
using System.Collections;
using System.Collections.Generic;

public class GradeSchool
{
    private List<string> _names = new List<string>();
    private SortedDictionary<int, List<string>> _namesByGrade = new SortedDictionary<int, List<string>>();

    public void Add(string student, int grade)
    {
        //TODO left off - how to get the list of names and add to it when the 'grade' key already exists in the Dictionary?
        
        // map, grade is key, list of names is value
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
        }
    }

    public IEnumerable<string> Roster()
    {
        List<string> allNames = new List<string>();
        foreach (var grade
            in _namesByGrade.Keys)
        {
            _namesByGrade[grade].Sort();                // passes test but sorts each time roster is built
            allNames.AddRange(_namesByGrade[grade]);
        }

        return allNames;
    }

    public IEnumerable<string> Grade(int grade)
    {
        throw new NotImplementedException("You need to implement this function.");
    }
}