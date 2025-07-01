namespace ThreadsAndTuples
{
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
        static void Main(string[] args)
        {
            Thread t1 = new Thread(new ThreadStart(Func1));
            t1.Start();
            Thread t2 = new Thread(new ThreadStart(Func2));

            t1.Join();
            Console.WriteLine("main thred");
            t2.Start();
            Console.WriteLine("main thred");


            

            void func1(out int x, out int y)
            {
                x = -1;
                y = -1;
            }
            int x, y;
            func1(out x,out y);
            Console.WriteLine($"{x}, : : {y}");
        }
    }
}
