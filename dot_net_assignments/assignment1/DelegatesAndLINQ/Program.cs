﻿
    using System.Runtime.CompilerServices;
using System.Xml.Linq;

    namespace DelegatesAndLINQ
    {

        public class Prog
        {
            static void Mainz()
            {
                Example ex = new Example();
                Console.WriteLine(ex.Show());
            }
        }
        partial class Example
        {
            int x =200;
            public partial int Show();

        }

        partial class Example
        {
            public partial int Show()
            {
                return x;
            }
        }
    }

namespace LinqExample
{
    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }
        public string Gender { get; set; }
        public override string ToString()
        {
            string s = Name + "," + EmpNo.ToString() + "," + Basic.ToString() + "," + DeptNo.ToString();
            return s;
        }
    }
    public class Department
    {
        public int DeptNo { get; set; }
        public string DeptName { get; set; }
    }
    internal class Program
    {
        static List<Employee> lstEmp = new List<Employee>();
        static List<Department> lstDept = new List<Department>();
        public static void AddRecs()
        {
            lstDept.Add(new Department { DeptNo = 10, DeptName = "SALES" });
            lstDept.Add(new Department { DeptNo = 20, DeptName = "MKTG" });
            lstDept.Add(new Department { DeptNo = 30, DeptName = "IT" });
            lstDept.Add(new Department { DeptNo = 40, DeptName = "HR" });

            lstEmp.Add(new Employee { EmpNo = 1, Name = "Vikram", Basic = 10000, DeptNo = 10, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 2, Name = "Vishal", Basic = 11000, DeptNo = 10, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 3, Name = "Abhijit", Basic = 12000, DeptNo = 20, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 4, Name = "Mona", Basic = 11000, DeptNo = 20, Gender = "F" });
            lstEmp.Add(new Employee { EmpNo = 5, Name = "Shweta", Basic = 12000, DeptNo = 20, Gender = "F" });
            lstEmp.Add(new Employee { EmpNo = 10, Name = "Shweta", Basic = 12000, DeptNo = 20, Gender = "F" });
            lstEmp.Add(new Employee { EmpNo = 6, Name = "Sanjay", Basic = 11000, DeptNo = 30, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 7, Name = "Arpan", Basic = 10000, DeptNo = 30, Gender = "M" });
            lstEmp.Add(new Employee { EmpNo = 8, Name = "Shraddha", Basic = 11000, DeptNo = 40, Gender = "F" });
        }

        static void Main()
        {
            AddRecs();
            //var retval = from single_object in collection select one_thing
            //var emps = from emp in lstEmp join dep in lstDept 
            //           on emp.DeptNo equals dep.DeptNo
            //           select new { emp.Name,emp.EmpNo};



            //cartition product
            //var emps = from emp in lstEmp
            //           from dept in lstDept
            //           select new { emp, dept };

            //var emps = from emp in lstEmp
            //           join dep in lstDept
            //           on emp.DeptNo equals dep.DeptNo
            //           orderby emp.Name ascending, emp.EmpNo descending
            //           select new { emp.Name, emp.EmpNo };
            ////IEnumerable<Employee> emps = from emp in lstEmp select emp;

            //var emps = from emp in lstEmp
            //           group emp by emp.DeptNo;


            //var emps = from emp in lstEmp
            //           group emp by emp.DeptNo into deptGroup
            //           select deptGroup.Select(x => new { deptNO = x.DeptNo, name = x.Name });

            var emps =  from emp in lstEmp
                        group emp by emp.DeptNo into deptGroup
                        select new
                        {
                            DeptNo = deptGroup.Key,
                            MaxSalary = deptGroup.Max(e => e.Basic),
                            MinSalary = deptGroup.Min(e => e.Basic)
                        };


            foreach (var item in emps)
            {
                Console.WriteLine(item.ToString());
            //    foreach(var emp in item)
            //        Console.WriteLine(emp);
            }

        }
        static void Main2()
        {
            AddRecs();
            //var retval = from single_object in collection select one_thing
            //var emps = from emp in lstEmp select emp.Name;
            var emps = from emp in lstEmp select emp.EmpNo;

            foreach (var item in emps)
            {
                Console.WriteLine(item);
            }

        }
        static void Main3()
        {
            AddRecs();
            //var retval = from single_object in collection select one_thing
            var emps = from emp in lstEmp select new { emp.Name, emp.EmpNo };

            //var emps = from emp in lstEmp select emp.EmpNo;

            foreach (var item in emps)
            {
                Console.WriteLine(item);
            }

        }
        static void Main4()
        {
            AddRecs();
            var emps = from emp in lstEmp
                       where emp.Basic > 10000
                       select emp;
            //var emps = from emp in lstEmp
            //           where emp.Basic > 10000 && emp.Basic < 12000
            //           select emp;

            //var emps = from emp in lstEmp
            //           where emp.Name.StartsWith("V")
            //           select emp;
            foreach (var item in emps)
            {
                Console.WriteLine(item);
            }
        }
        static void Main5()
        {
            AddRecs();

            var emps = from emp in lstEmp
                           //where emp.Basic > 10000
                       orderby emp.Name
                       select emp;
            //var emps = from emp in lstEmp
            //           orderby emp.Name descending
            //           select emp;

            //var emps = from emp in lstEmp
            //           orderby emp.DeptNo ascending, emp.Name descending
            //           select emp;


            foreach (var emp in emps)
            {
                Console.WriteLine(emp);
            }

            Console.ReadLine();
        }
        static void Mainl()
        {
            AddRecs();


            var emps = from emp in lstEmp
                       join dept in lstDept
                       on emp.DeptNo equals dept.DeptNo
                       select new { emp, dept };


            foreach (var item in emps)
            {
                Console.WriteLine(item.emp.Name);
                Console.WriteLine(item.dept.DeptName);
            }


            Console.WriteLine();
            Console.WriteLine();


            var emps2 = from emp in lstEmp
                        join dept in lstDept
                        on emp.DeptNo equals dept.DeptNo
                        select new { emp.Name, dept.DeptName };
            foreach (var item in emps2)
            {
                Console.WriteLine(item.Name);
                Console.WriteLine(item.DeptName);

            }

        }
    }
}



