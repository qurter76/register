using System;

namespace ConsoleApp1
{
    class paint
    {
        static void Main(string[] args)
        {
            // ������ ���ݰ� ���� �Է¹ޱ�
            Console.Write("Price of item 1:  $ "); double item1p = Returndouble();
            Console.Write("Quantity of item 1: "); double item1Q = Returndouble();
            Console.Write("Price of item 2:  $ "); double item2p = Returndouble();
            Console.Write("Quantity of item 2: "); double item2Q = Returndouble();
            Console.Write("Price of item 3:  $ "); double item3p = Returndouble();
            Console.Write("Quantity of item 3: "); double item3Q = Returndouble();

            // �����ۺ� �Ѱ���
            double totalitem1 = item1p * item1Q;
            double totalitem2 = item2p * item2Q;
            double totalitem3 = item3p * item3Q;

            // ������ �Ѱ���
            double totalPrice = totalitem1 + totalitem2 + totalitem3;

            // 5.5% ����
            double tax = (totalPrice * 5.5) / 100;

            // ���
            Console.WriteLine("Subtotal: $ {0}", totalPrice);
            Console.WriteLine("Tax:      $ {0}", tax);
            Console.WriteLine("Total:    $ {0}", totalPrice + tax);

            Console.ReadLine();
        }

        // �Է°��� ���ڰ� �ƴϸ� �ٽ� �Է¹ޱ�
        static double Returndouble()
        {
            double i;

            while (!double.TryParse(Console.ReadLine(), out i))
            {
                Console.WriteLine("Please enter the number.");
            }

            return i;
        }
    }
}
