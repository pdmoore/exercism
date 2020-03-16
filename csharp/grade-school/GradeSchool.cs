using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

public class GradeSchool
{
    private readonly SortedDictionary<int, List<string>> _namesByGrade = new SortedDictionary<int, List<string>>();

    public void Add(string student, int grade)
    {
        if (_namesByGrade.ContainsKey(grade) == false)
        {
            _namesByGrade.Add(grade, new List<string>() { student });
        }
        else
        {
           _namesByGrade[grade].Add(student);
           _namesByGrade[grade].Sort();
        }
    }

    public IEnumerable<string> Roster() => _namesByGrade.SelectMany(x => x.Value);

    public IEnumerable<string> Grade(int grade)
    {
        //TODO Left off here - need to provide a default if the key is not present
        // TryGetValue is the right approach, just figuring our the magic incantation 
        // IEnumerable<string> value = null;
        // return _namesByGrade.TryGetValue(grade, out value);
        if (_namesByGrade.ContainsKey(grade)) return _namesByGrade[grade];

        return new List<string>();
    }
}