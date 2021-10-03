import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        int x, y;
        int rez;
        String s;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        String str = s.replaceAll(" ", "");

        String textThrow1 = "trows Exception // т.к. в римской системе нет отрицательных чисел ";
        String textThrow2 = "trows Exception // т.к. используются одновременно разные системы счисления";
        String textThrow3 = "trows Exception // т.к. строка не является математической операцией";
        String textThrow4 = "trows Exception // т.к. формат математической операции не удовлетворяет " +
                "заданию - два операнда (от 1-10) и один оператор (+,-,/,*)";
        String[] StrMassiv = str.split("(\\+|-|\\*|/)");

        if (StrMassiv.length > 2) {
            System.out.println(textThrow4);
            System.exit(0);
        }
        if (StrMassiv.length <= 1) {
            System.out.println(textThrow3);
            System.exit(0);
        }
////////////////////////////////////////
        x = cifryRimckie(StrMassiv[0]);
        y = cifryRimckie(StrMassiv[1]);
        rez = rezultat(str, x, y);
        if (rez < 0) printRezult(textThrow1);
        if ((x > 0 && y == 0) || (x == 0 && y > 0)) printRezult(textThrow2);
        if (x > 0 && y > 0) printRezult("Rezultat = " + rezRimskiy(rez));
////////////////////////////////////////
        x = cifryArabskie(StrMassiv[0]);
        y = cifryArabskie(StrMassiv[1]);
        rez = rezultat(str, x, y);
        if (x > 0 && y > 0) printRezult("Rezultat = " + rez);
        if ((x > 0 && y == 0) || (x == 0 && y > 0)) printRezult(textThrow4);
    }

    ////==================================================
    public static void printRezult(String textThrow) {
        System.out.println(textThrow);
        System.exit(0);
    }

    public static int cifryRimckie(String str) {
        String[] perchisleneRimskix = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < perchisleneRimskix.length; i++) {
            if (perchisleneRimskix[i].contentEquals(str)) return i + 1;
        }
        return 0;
    }

    public static String rezRimskiy(int z) {
        String[] perchisleneRimskix = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] desRimskix = new String[]{"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        String rez = "";
        int d = z/10;
        int c = z%10;
        if (d > 0) rez = desRimskix[d-1];
        if (c > 0) rez = rez + perchisleneRimskix[c-1];
        if (z==100) rez = "C";
        return rez;
    }

    public static int cifryArabskie(String str) {
        String[] perchisleneRimskix = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (int i = 0; i < perchisleneRimskix.length; i++) {
            if (perchisleneRimskix[i].contentEquals(str)) return i + 1;
        }
        return 0;
    }

    public static int rezultat(@NotNull String vvod, int x, int y) {
        int rez = -1;
        if (vvod.indexOf("+") > 0) rez = Operation.ADDITION.action(x, y);
        if (vvod.indexOf("-") > 0) rez = Operation.SUBSTRACTION.action(x, y);
        if (vvod.indexOf("*") > 0) rez = Operation.MULTIPLICATION.action(x, y);
        if (vvod.indexOf("/") > 0) rez = Operation.DIVISION.action(x, y);
        return rez;
    }
}
