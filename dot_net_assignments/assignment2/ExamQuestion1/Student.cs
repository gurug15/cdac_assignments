using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamQuestion1
{

    public class Student
    {
        public int RollNo { get; set; }
        private string name;
        public string Name
        {
            get { return name; }
            set
            {
                if (!string.IsNullOrWhiteSpace(value))
                {
                    name = value;
                }
                else
                {
                    throw new ArgumentException("invald Name");
                }
            }
        }

        private Dictionary<string, decimal> subjectNMarks = new Dictionary<string, decimal>();
        public Dictionary<string, decimal> SubjectNMarks
        {
            get { return subjectNMarks; }
            set
            {
                if (value == null || value.Count == 0)
                {
                    throw new ArgumentException("Empty Dictonary");
                }
                foreach (var item in value)
                {
                    if (string.IsNullOrWhiteSpace(item.Key) || item.Value < 0)
                    {
                        throw new ArgumentException("invald Subject or Maeks");
                    }
                }
            }

        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.AppendLine($"Roll No: {RollNo}");
            sb.AppendLine($"Name: {Name}");
            sb.AppendLine("Subjects and Marks:");
            foreach (var subject in SubjectNMarks)
            {
                sb.AppendLine($"{subject.Key}: {subject.Value}");
            }
            return sb.ToString();
        }

    }

    public static class StudentUtil
    {
        static List<Student> students = new List<Student>();   
        
        public static void AddStudent(Student student, String FilePath)
        {
            if (student == null)
            {
                throw new ArgumentNullException(nameof(student), "Student cannot be null");
            }
            if (students.Any(s => s.RollNo == student.RollNo))
            {
                throw new ArgumentException("Student with the same RollNo already exists");
            }
            students.Add(student);
            
            using (StreamWriter writer = new StreamWriter(FilePath, true))
            {
                writer.WriteLine($"{student.RollNo},{student.Name},{string.Join(",", student.SubjectNMarks.Select(kv => $"{kv.Key}:{kv.Value}"))}");
            }
        }
        public static List<Student> GetAllStudents()
        {
            return students;
        }

        public static void ReadFromFile(string filePath)
        {
           
        }
    }

}
