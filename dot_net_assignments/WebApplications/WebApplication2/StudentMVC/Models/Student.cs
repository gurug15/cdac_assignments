using System;
using System.Collections.Generic;

namespace StudentMVC.Models;

public partial class Student
{
    public int RollNo { get; set; }

    public string Name { get; set; } = null!;

    public virtual ICollection<StudentMark> StudentMarks { get; set; } = new List<StudentMark>();
}
