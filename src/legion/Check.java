package legion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {

    public static boolean checkPhone(String phone) {
        String PHONE_VERIFICATION = "\\+\\d{12}\\b|\\d{1}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}\\b";
        Pattern pattern = Pattern.compile(PHONE_VERIFICATION);
        Matcher matcher = pattern.matcher(phone);
        boolean isPhoneValid = matcher.matches();

        if (!isPhoneValid) {
            System.out.println("Не правильно набран номер!");
            return false;
        }
        return true;
    }

    public static boolean checkBirthday(String birthday) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(birthday);
        } catch (ParseException p) {
            System.out.println("Дата введена не верно!");
            return false;
        }
        if (testAge(birthday) < 18) {
            System.out.println("Сотрудник слишком мал");
            return false;
        }
        return true;
    }

    public static boolean checkDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        Date dateMin = new Date();
        Date dateMy = new Date();
        try {
            dateMy = dateFormat.parse(date);
            dateMin = dateFormat.parse("01.01.2010");
        } catch (ParseException p) {
            System.out.println("Дата введена не верно!");
            return false;
        }
        if (dateMin.getTime() > dateMy.getTime()) {
            System.out.println("В это время компании ещё не существовало!");
            return false;
        }
        return true;
    }

    public static boolean checkMenu(String temp, int i) {
        try {
            Integer.parseInt(temp);
        } catch (NumberFormatException n) {
            System.out.println("Введите число");
            return false;
        }
        if (Integer.valueOf(temp) == 0 || Integer.valueOf(temp) > i) {
            System.out.println("Такого числа в меню нет!");
            return false;
        }
        if (Integer.valueOf(temp) < 0) {
            System.out.println("Отрицательные числа использовать нельзя!");
            return false;
        }
        return true;
    }

    public static boolean checkText(String text) {
        Pattern pattern = Pattern.compile("^[А-Я][а-я]{1,12}", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        boolean isText = matcher.matches();

        if (!isText) {
            System.out.println("Ошибка!");
            return false;
        }
        return true;
    }

    public static boolean  testMoney(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException n) {
            System.out.println("Введите сумму");
            return false;
        }
        if (Integer.valueOf(money) < 0) {
            System.out.println("Отрицательные суммы вводить нельзя!");
            return false;
        }
        if (Integer.valueOf(money) > 150000) {
            System.out.println("Сумма слишком велика!");
            return false;
        }
        if (Integer.valueOf(money) < 10000) {
            System.out.println("Сумма слишком мала!");
            return false;
        }
        return true;
    }

    private static Integer testAge(String birthday) {
        Date dateNow = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long mil = dateNow.getTime() - date.getTime();
        int days = (int) (mil / (24 * 60 * 60 * 1000));
        return days = days / 365;
    }

}
