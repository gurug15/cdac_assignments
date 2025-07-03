using System.Runtime.Serialization.Formatters.Binary;
using System.Runtime.Serialization.Json;
using System.Text;
using System.Xml.Serialization;

namespace WorkingWithFiles
{
    internal class Program
    {
        const string FILE_PATH = @"C:\Users\gurug\OneDrive\Desktop\Examprep\";
        static void Main1()
        {
            File.Create(FILE_PATH);
            Directory.CreateDirectory("C:\\Users\\gurug\\OneDrive\\Desktop\\Examprep\\hello");

            String[] dirs = Directory.GetDirectories("C:\\Users\\gurug\\OneDrive\\Desktop\\Examprep\\hello");
            foreach (String dir in dirs)
            {
                Console.WriteLine(dir);
            }
        }

        static void Main2()
        {
            using (
            FileStream stream = File.Open(FILE_PATH, FileMode.Create))
            {
                string s = "Hello in heloo file";
                byte[] barr = Encoding.Default.GetBytes(s);
                stream.Write(barr, 0, barr.Length);
            }
            using (
            FileStream stream = File.Open(FILE_PATH, FileMode.Open))
            {
                
                byte[] barr  = new byte[stream.Length];
                stream.Read(barr,0,barr.Length);
                string reading = Encoding.Default.GetString(barr);
                Console.WriteLine(reading);
            }
        }

        static void Main3()
        {
            using(StreamWriter stream = File.CreateText(FILE_PATH))
            {
                stream.WriteLine("hello this is goutu");
                stream.WriteLine("from japan im here to learn .net");
                stream.WriteLine("this is my address");
            }
            using (StreamReader stream = File.OpenText(FILE_PATH))
            {
                string? line;
                while((line = stream.ReadLine()) != null)
                {
                    Console.WriteLine(line);
                }    
            }
        }


        static void Maino()
        {

            SerialClas c = new SerialClas();
            c.x = 10000;
            var bf = new DataContractJsonSerializer(typeof(SerialClas));
            var s = new FileStream($"{FILE_PATH}one.dat", FileMode.Create);


            
        }

        [Serializable]
        public class SerialClas
        {
            public int x;
            public SerialClas() { }

            public string GetVal()
            {
                return "after deserialization";
            }

        }


    }
}
namespace SerializationInCore
{
    internal class Program
    {
        static void Main2()
        {
            JsonSerialize();
            JsonDeserialize();
        }
        private static void JsonSerialize()
        {

            Class1 o = new Class1();
            o.i = 100;
            o.P1 = "aaa";
            o.P2 = 200;
            DataContractJsonSerializer js = new DataContractJsonSerializer(typeof(Class1));
            Stream s = new FileStream("C:\\o.json", FileMode.Create);
            js.WriteObject(s, o);
            s.Close();
        }

        private static void JsonDeserialize()
        {
            DataContractJsonSerializer js = new DataContractJsonSerializer(typeof(Class1));
            Stream s = new FileStream("C:\\o.json", FileMode.Open);
            Class1 o = (Class1)js.ReadObject(s);
            s.Close();
            Console.WriteLine(o.i);
            Console.WriteLine(o.P1);
            Console.WriteLine(o.P2);
        }

        //private static void button4_Click()
        //{
        //    Class1 o = new Class1();
        //    o.i = 100;
        //    o.P1 = "aaa";
        //    o.P2 = 200;
        //    SoapFormatter sf = new SoapFormatter();
        //    Stream s = new FileStream("C:\\o.soap", FileMode.Create);
        //    sf.Serialize(s, o);
        //    s.Close();
        //} 
    }

    [Serializable]
    public class Class1 //:ISerializable
    {
        private int private_data;
        public int i;
        [XmlElement]
        public string P1
        {
            get;
            set;
        }
        private int mP2;
        [XmlAttribute]
        public int P2
        {
            get { return mP2; }
            set { mP2 = value; }
        }



        //public void GetObjectData(SerializationInfo info, StreamingContext context)
        //{
        //    //called during Serialize
        //    info.AddValue("i", i);
        //    info.AddValue("mP2", mP2);
        //}
        //public Class1()
        //{

        //}
        //public Class1(SerializationInfo info, StreamingContext context)
        //{
        //    //called during Deserialize
        //    i = info.GetInt32("i");
        //    mP2 = info.GetInt32("mP2");
        //}
    }
}

