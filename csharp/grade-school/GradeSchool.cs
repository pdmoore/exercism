using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

public class GradeSchool
{
    private readonly SortedDictionary<int, List<string>> _namesByGrade = new SortedDictionary<int, List<string>>();

    public void Add(string student, int grade)
    {
        if (_namesByGrade.ContainsKey(grade))
        {
            _namesByGrade[grade].Add(student);
            _namesByGrade[grade].Sort();
        }
        else
        {
            _namesByGrade.Add(grade, new List<string>() { student });
        }
    }

    public IEnumerable<string> Roster() => _namesByGrade.SelectMany(x => x.Value);

    //TODO TryGetValue?
    public IEnumerable<string> Grade(int grade) => _namesByGrade.ContainsKey(grade) ? _namesByGrade[grade] : new List<string>();
}