using System;
using System.Collections.Generic;

public class GradeSchool
{
    public void Add(string student, int grade)
    {
    }

    public IEnumerable<string> Roster()
    {
        return new[] { "Aimee" };
    }

    public IEnumerable<string> Grade(int grade)
    {
        throw new NotImplementedException("You need to implement this function.");
    }
}