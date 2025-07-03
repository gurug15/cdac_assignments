using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Reflection;
namespace ThreadsAndTuples
{
    internal class ReflectioneXAMPLES
    {
        static void Main()
        {
           Assembly asm = Assembly.LoadFile(@"C:\\Users\\gurug\\OneDrive\\Desktop\\CDAC\\cdac_assignments\\dot_net_assignments\\assignment1\\assignmentsSofar\\bin\\Debug\\net8.0\\assignmentsSofar.dll");
            Console.WriteLine(asm.FullName);
            Console.WriteLine(asm.GetName().Name);
            Type[] types = asm.GetTypes();
            foreach (Type t in types)
            {
                //Console.WriteLine("    " + t.FullName);
                Console.WriteLine("    Class:" + t.Name);
                //Console.WriteLine("       " +t.Attributes);
                t.GetConstructors().ToList().ForEach(ctor => Console.WriteLine("           ctor:" + ctor.Name));

                t.GetMethods().ToList().ForEach(method =>
                {
                    Console.WriteLine("           method:" + method.Name);
                    method.GetParameters().ToList().ForEach(param => Console.WriteLine("              param:" + param.Name));

                });
                
            }
            Console.ReadLine();
        }
    }
}
