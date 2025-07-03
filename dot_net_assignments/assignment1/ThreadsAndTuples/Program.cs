using System.Runtime.CompilerServices;
using static ThreadsAndTuples.Program;

namespace ThreadsAndTuples
{
    public interface MathOper
    {
        int Add(int x, int y);


        int Mul(int x, int y);
        int Div(int x, int y);
    }
    public class MathOperImpl : MathOper
    {
        public int Add(int a, int b)
        {
            return a + b;
        }
        public int Mul(int a, int b)
        {

            return a * b;
        }
        public int Div(int a, int b)
        {
            return a / b;
        }
    }
    public static class MathExt
    {
        public static int Sub(this MathOper o, int a, int b)
        {
            return a - b;
        }
    }

    internal class Program
    {
        static void Func1()
        {
            for (int i = 0; i < 100; i++)
            {

                Console.WriteLine("Func1---" + i);
            }
            
        }

        static void Func2()
        {
            for (int i = 0; i < 100; i++)
            {

                Console.WriteLine("Func2---" + i);
            }

        }

        static void Main1as(string[] args)
        {
/*            Thread t1 = new Thread(new ThreadStart(Func1));
            t1.Start();
            Thread t2 = new Thread(new ThreadStart(Func2));
*/
            //t1.Join();
            //Console.WriteLine("main thred");
            //t2.Start();
            //Console.WriteLine("main thred");




            //void func1(out int x, out int y)
            //{
            //    x = -1;
            //    y = -1;
            //}
            //int x, y;
            //func1(out x,out y);
            FuncInterLocked();
            //Console.WriteLine($"{x}, : : {y}");
        }
        static void Main2(string[] args) { 
        
            MathOper mathOper = new MathOperImpl();
            Console.WriteLine(mathOper.Sub(1,3));
        
        }
        static void Main3(string[] args)
        {
            //Task task = new Task(() =>
            //{
            //    while (false) 
            //        Console.WriteLine("ofadada");
            ////});
            //Task<int> task = new Task<int>(()=>100);
            //task.Start();
            //int result = task.Result;
            //Console.WriteLine(result);
            //task.Wait();

            Task<int> t = Task.Run<int>(() => 100);
            Console.WriteLine(t.Result);
        }

        static void FuncInterLocked()
        {


            //makes every opertaion is syncronized
            int i = 1;
            Console.WriteLine(i);
            Interlocked.Add(ref i, 10);
            Console.WriteLine(i);
            Interlocked.Increment(ref i);
            Console.WriteLine(i);
            Interlocked.Decrement(ref i);
            Console.WriteLine(i);
            Interlocked.Exchange(ref i, 100);
            Console.WriteLine(i);

        }

        static async Task Main22()
        {
            Console.WriteLine("before");
            string result = await DoAsyncSomething();
            Console.WriteLine(result);
            Console.WriteLine("after");
        }

        static async Task<string> DoAsyncSomething()
        {


            return await Task.Run(() => "Hello");
        }
        
       
    }
 

}
