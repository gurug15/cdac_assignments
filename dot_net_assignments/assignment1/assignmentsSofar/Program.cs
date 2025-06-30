namespace assignmentsSofar.ObjectInitializers
{
    internal class Program
    {
        static void Main1()
        {
            Class1 o = new Class1();
            o.Prop1 = 1;
            o.Prop2 = 2;
            o.Prop3 = 3;
            o.Prop4 = 4;

            //object initializer - use it when there are no constructors
            Class1 o2 = new Class1() { Prop1 = 1, Prop2 = 2, Prop3 = 3, Prop4 = 4 };
            Class1 o3 = new Class1 { Prop1 = 1, Prop2 = 2, Prop3 = 3, Prop4 = 4 };

        }
    }
    public class Class1
    {
        private int prop4;
        public int Prop4
        {
            get { return prop4; }
            set
            {
                if (value < 100)
                    prop4 = value;
                else
                    Console.WriteLine("invalid Prop1");
            }
        }

        public int Prop1 { get; set; }
        public int Prop2 { get; set; }
        public int Prop3 { get; set; }


    }
}
namespace assignmentsSofar.InheritanceExamples1
{
    internal class Program
    {
        static void Main1()
        {
            BaseClass o = new BaseClass();
            //o.
            DerivedClass o2 = new DerivedClass();
            //o2.
        }
    }

    public class BaseClass : object
    {
        public int A { get; set; }
        public int B { get; set; }
    }
    public class DerivedClass : BaseClass
    {
        public int C { get; set; }
        public int D { get; set; }
    }
}
namespace assignmentsSofar.InheritanceExamples2

{
    class Program //internal by default for members of a namespace
    {
        static void Main5()
        {
            BaseClass o = new BaseClass();
            //o.
            //TestAccessSpecifiers.BaseClass o2 = new TestAccessSpecifiers.BaseClass();
            //o2.

        }
    }

    public class BaseClass
    {
        //public - available everywhere
        //private - same class
        //protected - same class,  derived class
        //internal - same class, same assembly(same project)
        //protected internal - same class,  derived class, same assembly(same project)
        //private protected - same class,  derived class that is in the same assembly
        int a; //private by default for members of a class
        public int PUBLIC;
        private int PRIVATE;
        protected int PROTECTED;
        internal int INTERNAL;
        protected internal int PROTECTED_INTERNAL;
        private protected int PRIVATE_PROTECTED;
    }

    public class DerivedClass //: TestAccessSpecifiers.BaseClass   // : BaseClass
    {
        void DoSomething()
        {
            //this.
        }
    }
}

namespace assignmentsSofar.OverloadingHidingOverriding
{
    internal class Program
    {
        static void Main1()
        {
            DerivedClass o = new DerivedClass();
            // o.Display1();
            //o.Display1("aaa");

            o.Display2();
            o.Display3();
        }
        static void Main2()
        {
            BaseClass o;
            o = new BaseClass();
            o.Display2(); //non virtual-early bound/compile time binding -
            //depends on how the reference has been declared
            o.Display3();//virtual-late bound/run time binding -
                         //depends on object creation

            Console.WriteLine();
            o = new DerivedClass();
            o.Display2(); //non virtual-early bound/compile time binding -
            //depends on how the reference has been declared
            o.Display3();//virtual-late bound/run time binding -
                         //depends on object creation

            Console.WriteLine();
            o = new SubDerivedClass();
            o.Display2(); //non virtual-early bound/compile time binding -
            //depends on how the reference has been declared
            o.Display3();//virtual-late bound/run time binding -
                         //depends on object creation

            Console.WriteLine();
            o = new SubSubDerivedClass();
            o.Display2(); //non virtual-early bound/compile time binding -
            //depends on how the reference has been declared
            o.Display3();//virtual-late bound/run time binding -
            //depends on object creation

        }
    }
    public class BaseClass
    {
        public void Display1()
        {
            Console.WriteLine("base display1");
        }
        public void Display2()
        {
            Console.WriteLine("base display2");
        }
        public virtual void Display3()
        {
            Console.WriteLine("base display3");
        }
    }
    public class DerivedClass : BaseClass
    {
        //overloading
        public void Display1(string s)
        {
            Console.WriteLine("derived display1" + s);
        }

        //hiding
        public new void Display2()
        {
            Console.WriteLine("derived display2");
        }
        //overriding
        public override void Display3()
        {
            Console.WriteLine("derived display3");
        }
    }
    public class SubDerivedClass : DerivedClass
    {
        //hiding
        public new void Display2()
        {
            Console.WriteLine("subderived display2");
        }
        //overriding
        public override sealed void Display3()
        {
            Console.WriteLine("subderived display3");
        }
    }
    public class SubSubDerivedClass : SubDerivedClass
    {
        //hiding
        public new void Display2()
        {
            Console.WriteLine("subsubderived display2");
        }
        //overriding
        public new void Display3()
        {
            Console.WriteLine("subsubderived display3");
        }
    }
}

namespace assignmentsSofar.RefOutInKeyw
{
    class Examples
    {
        void swap(ref int a, ref int b)
        {
            Console.WriteLine("swwaping");
            int temp = a;
            a = b;
            b = temp;
        }

        static void Main1()
        {
            var a = 1;
            var b = 2;
            Examples examples = new Examples();

            Console.WriteLine($"a is {a}, b is {b}");
            examples.swap(ref a, ref b);
            
            Console.WriteLine($"a is {a}, b is {b}");
        }
    }
}
namespace assignmentsSofar.ExceptoinHandling.One
{
    class Program
    {
        static void Main1()
        {
            try
            {
                Console.WriteLine("Enter a number");
                int x = int.Parse(Console.ReadLine()!);
                int y = 100 / x;
            }
            catch (MyctomException ex)
            {
                throw new MyctomException("invlid arg");
                //Console.WriteLine(ex.ToString());
            }
            catch (DivideByZeroException ex)
            {
                throw new Exception("cannot divide by o");
            }
            catch (Exception ex)
            {
                throw new Exception("jaba");
            }
            finally
            {
                Console.WriteLine("somethiing Happend");
            }

            int Func1(int x)
            {
                return 100 * x;
                Console.WriteLine("wtf");
            }

        }
    }




    class MyctomException : ApplicationException
    {
        public MyctomException(string message) : base(message)
        {

        }
    }

}
namespace assignmentsSofar.DelegationExamples
{

    public delegate int Calc(int x,int y);
    class DelegateExample
    {
        private event Calc calc;
        static void Main1()
        {
            DelegateExample d = new DelegateExample();
            d.calc = d.add;
            d.calc += d.sub;
            d.calc -= d.sub;
            Console.WriteLine(d.calc!(1, 2));
        }

        static void Main2()
        {
            int i = 100;

            Action o1 = delegate ()
            {
                Console.WriteLine("anon method called");
                //anon methods can access local variables declared in outer code
                //can also access anon types/classes
                Console.WriteLine(++i);
            };
            Console.WriteLine(i);
            o1();
            Func<int, int, int> o2 = delegate (int a, int b)
            {
                return a + b;
            };
            Console.WriteLine(o2(10, 5));
        }
        int add(int x, int y)
        {
            return x + y;
        }

        int sub(int x, int y)
        {
            return x - y;
        }
    }
}
namespace assignmentsSofar.ActionsLambdaAnon
{
    internal class Xyz
    {
        static void Main()
        {
            Func<int, int> funct = a => a * 10;
            Console.WriteLine(funct(1));


            Predicate<int> IsEven = a => a % 2 == 0;

            Console.WriteLine(IsEven(2));



        }
    }
}