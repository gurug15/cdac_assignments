using System;
using System.Collections.Generic;
using System.Linq;

namespace WebApplication2.Models
{
    public class Employee
    {
        // Static list of employees (acting as an in-memory data store)
        private static List<Employee> employees = new List<Employee>
        {
            new Employee { EmpNo = 1, EName = "Guru", DeptNo = 10, Basic = 1000000m },
            new Employee { EmpNo = 2, EName = "Anita", DeptNo = 20, Basic = 850000m },
            new Employee { EmpNo = 3, EName = "Raj", DeptNo = 10, Basic = 920000m },
            new Employee { EmpNo = 4, EName = "Neha", DeptNo = 30, Basic = 730000m },
            new Employee { EmpNo = 5, EName = "Aman", DeptNo = 20, Basic = 810000m },
            new Employee { EmpNo = 6, EName = "Sneha", DeptNo = 40, Basic = 950000m },
            new Employee { EmpNo = 7, EName = "Vikas", DeptNo = 10, Basic = 600000m },
            new Employee { EmpNo = 8, EName = "Deepa", DeptNo = 20, Basic = 700000m },
            new Employee { EmpNo = 9, EName = "Manoj", DeptNo = 30, Basic = 890000m },
            new Employee { EmpNo = 10, EName = "Kiran", DeptNo = 10, Basic = 920000m },
            new Employee { EmpNo = 11, EName = "Farah", DeptNo = 50, Basic = 970000m },
            new Employee { EmpNo = 12, EName = "Rohit", DeptNo = 30, Basic = 880000m },
            new Employee { EmpNo = 13, EName = "Ishita", DeptNo = 40, Basic = 910000m },
            new Employee { EmpNo = 14, EName = "Siddharth", DeptNo = 50, Basic = 880000m },
            new Employee { EmpNo = 15, EName = "Priya", DeptNo = 60, Basic = 990000m }
        };

        // Properties
        public int EmpNo { get; set; }
        public int DeptNo { get; set; }
        public string EName { get; set; }
        public decimal Basic { get; set; }

        // Returns all employees
        public static List<Employee> GetAllEmployees()
        {
            return employees;
        }

        // Returns a single employee by EmpNo or throws exception if not found
        public static Employee GetSingleEmployee(int EmpNo)
        {
            var employee = employees.FirstOrDefault(e => e.EmpNo == EmpNo);
            if (employee == null)
                throw new Exception($"Employee with EmpNo {EmpNo} not found.");

            return employee;
        }

        // Inserts a new employee into the list
        public static void InsertEmployee(Employee obj)
        {
            if (obj == null)
                throw new ArgumentNullException(nameof(obj), "Employee object cannot be null.");

            // Check if EmpNo already exists to avoid duplicates
            if (employees.Any(e => e.EmpNo == obj.EmpNo))
                throw new Exception($"Employee with EmpNo {obj.EmpNo} already exists.");

            employees.Add(obj);
        }

        // Updates an existing employee's details
        public static void UpdateEmployee(Employee obj)
        {
            if (obj == null)
                throw new ArgumentNullException(nameof(obj), "Employee object cannot be null.");

            var employee = employees.FirstOrDefault(e => e.EmpNo == obj.EmpNo);
            if (employee == null)
                throw new Exception($"Employee with EmpNo {obj.EmpNo} not found.");

            // Update properties
            employee.EName = obj.EName;
            employee.DeptNo = obj.DeptNo;
            employee.Basic = obj.Basic;
        }

        // Deletes an employee by EmpNo
        public static void DeleteEmployee(int EmpNo)
        {
            var employee = employees.FirstOrDefault(e => e.EmpNo == EmpNo);
            if (employee == null)
                throw new Exception($"Employee with EmpNo {EmpNo} not found.");

            employees.Remove(employee);
        }
    }
}
