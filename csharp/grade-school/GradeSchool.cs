using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualBasic;

public class GradeSchool
{
    private readonly SortedDictionary<int, List<string>> _namesByGrade = new SortedDictionary<int, List<string>>();

    public void Add(string student, int grade)
    {
        if (_namesByGrade.TryGetValue(grade, out var students))
        {
            students.Add(student);
            students.Sort();
        }
        else
        {
            _namesByGrade.Add(grade, new List<string>() { student });
        }
    }

    public IEnumerable<string> Roster() => _namesByGrade.SelectMany(grade => grade.Value);

    public IEnumerable<string> Grade(int grade) => _namesByGrade.TryGetValue(grade, out var students) ? students : new List<string>();
}