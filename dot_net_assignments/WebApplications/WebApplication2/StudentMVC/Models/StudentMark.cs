using System;
using System.Collections.Generic;

namespace StudentMVC.Models;

public partial class StudentMark
{
    public int Id { get; set; }

    public int StudentId { get; set; }

    public string Subject { get; set; } = null!;

    public int Marks { get; set; }

    public virtual Student? Student { get; set; } = null!;
}
