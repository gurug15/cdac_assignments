using System;

namespace ConsoleApp1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
        }
    }
}


namespace MynameSpace
{
     class Jaba : Ikd, Jabajba
    {
        int a;
        Jaba(int a)
        {
            this.a = a;
        }
        public int Aa()
        {
            return a;
        }

        public override int Aab()
        {
            throw new NotImplementedException();
        }
    }



    abstract class Ikd
    {
        public virtual int Aab();
    }


      interface Jabajba
    {
       abstract int Aa();
    }
}
