using Microsoft.Data.SqlClient;
using System.Data;
using System.Data.SqlTypes;

namespace DatabaseExamples
{
    internal class Program
    {
        
        static void Main()
        {

            //Insert();
            Select();
            
        }


        static void Select()
        {
            SqlConnection conn = Connect();
            try
            {
                conn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = conn;
                cmdInsert.CommandType = CommandType.Text;
                cmdInsert.CommandText = "select * from Employees";
                SqlDataReader reader = cmdInsert.ExecuteReader();
                while (reader.Read())
                {
                    Console.WriteLine(reader["name"]+ "     " + reader["basic"]);
                }

                Console.WriteLine("read....");

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

        static void Insert()
        {
                SqlConnection conn = Connect();
            try
            {
                conn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = conn;
                cmdInsert.CommandType = CommandType.Text;
                cmdInsert.CommandText = "insert into Employees values(5,'dalle',10,100000.0)";
                cmdInsert.Parameters.AddWithValue("name", "guru");
                cmdInsert.ExecuteNonQuery();
                Console.WriteLine("inserted....");

            }catch(Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }
            finally
            {
                conn.Close();
            }
        }
        static SqlConnection Connect()
        {
            SqlConnection conn = new SqlConnection();
            conn.ConnectionString = @"Data Source=(localdb)\ProjectModels;Initial Catalog=ActsJune25;Integrated Security=True";

            return conn;
        }
    }
}
