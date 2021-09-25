using System;
using System.Diagnostics;
using System.Threading;
namespace BubbleSort
{
    class MySort
    {
        public void randomFill(int[] arr)
        {
            Random random = new Random();
            for (int i = 0; i < arr.Length; i++)
            {
                arr[i] = random.Next(0, 100000);
            }
        }

        public void descending(int[] arr){ //to heaven or the next semester, wathever happens first
            Array.Sort<int>(arr,
                    new Comparison<int>(
                            (i1, i2) => i2.CompareTo(i1)
                    ));
        }
        public void ascending(int[] arr){//into hell xD
            Array.Sort<int>(arr,
                   new Comparison<int>(
                           (i1, i2) => i1.CompareTo(i2)
                   ));
        } 


        static void Main(string[] args)
        {

            MySort ms = new MySort();

            const int Size1 = 500;
            const int Size2 = 5000;
            const int Size3 = 10000;

            int[] arr = new int[Size3]; //Modify to change the size of the array


            //Note: if you want the array to be filled in an ascending way, use ms.ascending(arr)
            //if you want the array to be filled in an descending way, use ms.descending(arr)
            //if you want the array to be filled in a random way, do not add a thing. That's the default filling way.

            for(int k=0; k < 100; k++)
            {
                ms.randomFill(arr);
               // ms.ascending(arr);
              //  ms.descending(arr);

                //foreach (int p in arr)
                //    Console.Write(p + " ");

                
                Stopwatch sw = new Stopwatch();
                sw.Start();
                int temp;
                for (int j = 0; j <= arr.Length - 2; j++)
                {
                    for (int i = 0; i <= arr.Length - 2; i++)
                    {
                        if (arr[i] > arr[i + 1])
                        {
                            temp = arr[i + 1];
                            arr[i + 1] = arr[i];
                            arr[i] = temp;
                        }
                    }
                }
                sw.Stop();
                double ts = sw.Elapsed.TotalMilliseconds;
                
               // foreach (int p in arr)
               //     Console.Write(p + " ");
                Console.WriteLine(ts);
            }
            
        }
    }
}
