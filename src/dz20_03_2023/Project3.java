package dz20_03_2023;

public class Project3 {
    public static void main(String[] args) {
        //1
        int a = 8, b = 9;
        int more = a > b ? a : b;
        System.out.println(more);
        //2
        more = more % 2 == 0 ? 0 : -1;
        System.out.println(more);
        //3
        int month = 0;
        for (int i = -2; i < 13; i++) {
            month = i;
            if (month == 12 || month>=1 && month <= 2) {
                System.out.println("зима");
            } else if (month >= 3 && month <= 5) {
                System.out.println("весна");
            } else if (month >= 6 && month <= 8) {
                System.out.println("лето");
            } else if (month >= 9 && month <= 11) {
                System.out.println("осень");
            } else System.out.println("ошибка ввода");
        }
        //4
        int coutn = 4;
        if (coutn <= 100 && coutn >= 90) {
            System.out.println("Отлично");
        } else if (coutn <= 89 && coutn >= 60) {
            System.out.println("Хорошо");
        } else if (coutn <= 59 && coutn >= 40) {
            System.out.println("удовлетворительно");
        } else {
            System.out.println("попробуйте еще раз");
        }
        //5
        int random = 10 + (int) (Math.random() * 500);
        if (random >= 25 && random <= 500) {
            System.out.println("входит в  интервал (25;200)" + " число " + random);
        } else System.out.println("не входит в  интервал (25;200)" + " число " + random);

        //6
        double sum = 100;
        int saleCode = 9011;
        switch (saleCode) {
            case 4525:
                System.out.println(sum * 0.7);
                break;
            case 6424:
            case 7012:
                System.out.println(sum * 0.8);
                break;
            case 7647:
            case 9011:
            case 6612:
                System.out.println(sum * 0.9);
                break;
            default:
                System.out.println(sum);
        }
    }
}
