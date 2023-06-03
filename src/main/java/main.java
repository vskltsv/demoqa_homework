public class main {
    public static void main(String[] args) {

        System.out.println("сложение int: " + sumInt(42_000, 39_000));
        System.out.println("умножение int с выходом за пределы " + multiplicationInt(23_000_000, 11_000_000));
        System.out.println("вычитание из double int " + increaseNum(8.5, 2));
        System.out.println("деление int на double " + divisionNum(5, 8.5));
        System.out.println("деление int на int с отсеканием остатка " + divisionOfNumber(5, 2));
        System.out.println("сложение byte " + sumByte((byte) 34, (byte) 30));
        System.out.println("сравнение int " + compareInt(5, 3));
        System.out.println("сравнение int " + compareInt(1, 4));
        System.out.println("получение остатка от деления " + percentageNum(10, 3));
        System.out.println("инкрементация на 1 полученного int " + incrementInt(5));

        System.out.println(getAuto("BMW"));
        System.out.println(getAuto("AUDI"));

    }


    public static int sumInt(int num1, int num2) {
        return num1 + num2;
    }

    public static int multiplicationInt(int num1, int num2) {
        return num1 * num2;
    }

    public static double increaseNum(double num1, int num2) {
        return num1 - num2;
    }

    public static double divisionNum(int num1, double num2) {
        return num1 / num2;
    }

    public static double divisionOfNumber(int num1, int num2) {
        return num1 / num2;
    }


    public static int sumByte(byte num1, byte num2) {
        return num1 + num2;
    }

    public static boolean compareInt(int num1, int num2) {
        return num1 > num2;
    }

    public static int percentageNum(int num1, int num2) {
        return num1 % num2;
    }

    public static int incrementInt(int num) {
        return ++num;
    }


    public static String getAuto(String language) {

        if (language != null && language.equals("BMW")) {
            return "BMW";
        } else if (language != null && language.equals("AUDI")) {
            return "AUDI";
        } else {
            return "Марка машины не определена";
        }
    }


}