using Microsoft.Data.SqlClient;
using System;
using System.Data;
using System.Diagnostics.Metrics;
using WebApi1.Controllers;
using static System.Net.Mime.MediaTypeNames;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace WebApi1
{
    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic {  get; set; } 
        public int DeptNo {  get; set; }

        public static List<Employee> GetAllEmployees()
        {
            var employees = new List<Employee>();
            SqlConnection conn = new SqlConnection();
            //Data Source = (localdb)\ProjectModels; Initial Catalog = master; Integrated Security = True; Connect Timeout = 30; Encrypt = False; Trust Server Certificate = False; Application Intent = ReadWrite; Multi Subnet Failover = False            conn.ConnectionString = " Data Source = (localdb)\\MSSQLLocalDB; Initial Catalog = master; Integrated Security = True; ";
            conn.ConnectionString = "Data Source = (localdb)\\ProjectModels; Initial Catalog = ActsJune25; Integrated Security = True; ";
            try
            {
                conn.Open();
                SqlCommand sc = new SqlCommand();
                sc.Connection = conn;
                sc.CommandType = CommandType.StoredProcedure;
                sc.CommandText = "GetAllEmployees";

                SqlDataReader dr = sc.ExecuteReader();

                while (dr.Read())
                {
                    int EmpId = dr.GetInt32("EmpNo");
                    string name = dr.GetString("Name");
                    decimal basic = dr.GetDecimal("Basic");
                    int deptno = dr.GetInt32("DeptNo");
                    Employee emp = new Employee { EmpNo = EmpId, Name = name, Basic = basic, DeptNo = deptno };
                    employees.Add(emp);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }
            finally
            {
                conn.Close();
            }
            return employees;
        }

        public static void InsertEmployee(Employee obj)
        {
            SqlConnection conn = new SqlConnection();
            //Data Source = (localdb)\ProjectModels; Initial Catalog = master; Integrated Security = True; Connect Timeout = 30; Encrypt = False; Trust Server Certificate = False; Application Intent = ReadWrite; Multi Subnet Failover = False            conn.ConnectionString = " Data Source = (localdb)\\MSSQLLocalDB; Initial Catalog = master; Integrated Security = True; ";
            conn.ConnectionString = "Data Source = (localdb)\\ProjectModels; Initial Catalog = ActsJune25; Integrated Security = True; ";
            try
            {
                conn.Open();
                SqlCommand sc = new SqlCommand();
                sc.Connection = conn;
                sc.CommandType = CommandType.StoredProcedure;
                sc.CommandText = "InserEmployees";
                sc.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                sc.Parameters.AddWithValue("@Name", obj.Name);
                sc.Parameters.AddWithValue("@Basic", obj.Basic);
                sc.Parameters.AddWithValue("@DeptNo", obj.DeptNo);
                
                sc.ExecuteNonQuery();
               
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }
            finally
            {
                conn.Close();
            }
            
        }

    }
}
