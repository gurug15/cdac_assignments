using System.Runtime.CompilerServices;

namespace ExamQuestion1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            const string FILEPATH = "C:\\Users\\gurug\\OneDrive\\Desktop\\CDAC\\cdac_assignments\\dot_net_assignments\\assignment2\\ExamQuestion1\\Student.txt";
            Console.WriteLine("---Add-Student---");
             while (true)
            {
                
                const string menu = "1. Add Student\n2. Read From File\n3. Exit\nEnter your choice: ";
                
                Console.Write(menu);
                int choice = int.Parse(Console.ReadLine()!);    
                switch (choice)
                {
                    case 1:
                        try
                        {
                            Console.Write("Enter Roll No: ");
                            int rollNo = int.Parse(Console.ReadLine());
                            Console.Write("Enter Name: ");
                            string name = Console.ReadLine();
                            var student = new Student
                            {
                                RollNo = rollNo,
                                Name = name
                            };
                            Console.Write("Enter Subject and Marks (format: Subject1:Marks1,Subject2:Marks2): ");
                            string input = Console.ReadLine();
                            var subjectNMarks = new Dictionary<string, decimal>();
                            foreach (var item in input.Split(','))
                            {
                                var parts = item.Split(':');
                                if (parts.Length == 2 && decimal.TryParse(parts[1], out decimal marks))
                                {
                                    subjectNMarks[parts[0].Trim()] = marks;
                                }
                                else
                                {
                                    throw new ArgumentException("Invalid subject or marks format");
                                }
                            }
                            student.SubjectNMarks = subjectNMarks;
                            Console.WriteLine(student);
                            StudentUtil.AddStudent(student, FILEPATH);
                            Console.WriteLine("Student added successfully.");
                        }
                        catch (Exception ex)
                        {
                            Console.WriteLine($"Error: {ex.Message}");
                        }
                        break;
                    case 2:
                        try
                        {
                           
                            StudentUtil.ReadFromFile(FILEPATH);
                            Console.WriteLine("Students read from file successfully.");
                        }
                        catch (Exception ex)
                        {
                            Console.WriteLine($"Error: {ex.Message}");
                        }
                        break;
                    case 3:
                        Console.WriteLine("Exiting...");
                        return;
                    default:
                        Console.WriteLine("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }
}
