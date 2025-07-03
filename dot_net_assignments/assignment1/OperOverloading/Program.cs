namespace OperOverloading
{
    internal class Program
    {
        static void Main1(string[] args)
        {
            Cass2 c = new Cass2();
            Cass2 c2 = new Cass2 { i = 3000 };
            c.i = 100;
            Console.WriteLine(c.i);
            c = c + 100;
            Console.WriteLine(c.i);
            c2 = c - c2;
            Console.WriteLine(c2.i);
        }
        static void Main()
        {
            IndexingArr arr = new IndexingArr();
            arr[0] = 1;
            arr[1] = 2; 
            arr[2] = 3;
            arr[3] = 4;
            arr[4] = 5;
            Console.WriteLine(arr[3]);
        }

        internal class Cass2
        {
            public int i;

            public static Cass2 operator+(Cass2 a, int q)
            {

                a.i = a.i +  q;
                return a;
            }
            public static Cass2 operator-(Cass2 a, Cass2 q)
            {

                a.i = a.i - q.i;
                return a;
            }
        }

        internal class IndexingArr
        {
            private int[] arr = new int[10];

            public int this[int i]
            {
                get
                {
                    return arr[i];
                }
                set
                {
                    arr[i] = value;
                }
            }
        }
    }
}
