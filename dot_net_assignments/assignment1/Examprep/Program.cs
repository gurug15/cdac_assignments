using System.Data;
using System.Reflection;
using System.Runtime.CompilerServices;
using System.Xml.Serialization;

namespace Examprep
{


    public class ABC
    {
        public int X { get; set; }

        public void Display()
        {
            Console.WriteLine($"here is x: {X}");
        }
    }


    internal class Program
    {
        const string filepath = @"C:\Users\gurug\OneDrive\Desktop\CDAC\cdac_assignments\dot_net_assignments\assignment1\Examprep\Abc.txt";
        const string dirpath = @"C:\Users\gurug\OneDrive\Desktop\CDAC\cdac_assignments\dot_net_assignments\assignment1\Examprep";
        static void Main2(string[] args)
        {

            Type xcc = typeof(ABC);
            object obj = Activator.CreateInstance((Type)xcc)!;
            PropertyInfo prop = xcc.GetProperty("X");
            prop.SetValue(obj, 100);


            MethodInfo dispMethod = xcc.GetMethod("Display")!;
            dispMethod.Invoke(obj, null);

            Console.WriteLine();
            Console.WriteLine("Hello, World!");
        }



        static void Main3(string[] args)
        {

            string[] readLines = [];
            string readText = "";
            if (File.Exists(filepath))
            {
                readLines = File.ReadAllLines(filepath);
                File.AppendAllText(filepath, "| this is another entry");
                readText = File.ReadAllText(filepath);


            }

            Console.WriteLine(readText);
            foreach (string line in readLines)
            {
                Console.WriteLine(line);
            }

        }

            
        static void Main4(string[] args)
        {
            using (StreamReader reader = new StreamReader(filepath))
            {
                Console.WriteLine(Directory.Exists(dirpath));
                string[] dirs = Directory.GetDirectories(dirpath);
                dirs.Select(d => d).ToList<string>().ForEach(d =>
                {
                    Console.WriteLine(d);
                });
                string[] drivers = Directory.GetLogicalDrives();
                dirs.Select(d => d).ToList<string>().ForEach(d =>
                {
                    Console.WriteLine(d);
                });
                string line;
                while ((line = reader.ReadLine()) != null)
                {
                    Console.WriteLine(line);
                }
            }
        }

        static int i = 1;

        public void getThreadInformation()
        {
           
            //lock (this)
            //{
                for (; i <= 1000; i++)
                {
                    //Thread.Sleep(1000);
                    Console.WriteLine("i=" + i + " " + " Thread Name: " + Thread.CurrentThread.Name);
                }
            //}

            Console.WriteLine(i);
        }

        static void Main(string[] args)
        {
            //Program obj = new Program();
            //Thread t1 = new Thread(new ThreadStart(obj.getThreadInformation));
            //Thread t2 = new Thread(new ThreadStart(obj.getThreadInformation));
            //t1.Name = "MyThread1";
            //t2.Name = "MyThread2";
            //t1.Start();
            //t2.Start();


            Task  t = new Task(();
        }

    }
    }
