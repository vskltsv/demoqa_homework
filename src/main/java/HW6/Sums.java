package HW6;

public class Sums {
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
        System.out.println(SwitchCaseExample(6));

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


    public static String getAuto(String markAuto) {

        if (markAuto != null && markAuto.equals("BMW")) {
            return "BMW";
        } else if (markAuto != null && markAuto.equals("AUDI")) {
            return "AUDI";
        } else {
            return "Марка машины не определена";
        }
    }


    public static String SwitchCaseExample(int day) {
        String dayName;

        switch (day) {
            case 1:
                dayName = "Понедельник";
                break;
            case 2:
                dayName = "Вторник";
                break;
            case 3:
                dayName = "Среда";
                break;
            case 4:
                dayName = "Четверг";
                break;
            case 5:
                dayName = "Пятница";
                break;
            case 6:
                dayName = "Суббота";
                break;
            case 7:
                dayName = "Воскресенье";
                break;
            default:
                dayName = "Некорректный день";
                break;
        }

        return dayName;
    }
}