using System;
using System.Collections;
using System.Collections.Generic;

public class GradeSchool
{
    private List<string> _names = new List<string>();

    public void Add(string student, int grade)
    {
        _names.Add(student);
    }

    public IEnumerable<string> Roster()
    {
        return _names;
    }

    public IEnumerable<string> Grade(int grade)
    {
        throw new NotImplementedException("You need to implement this function.");
    }
}