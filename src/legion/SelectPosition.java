package legion;

import java.util.Scanner;

public class SelectPosition {
    public static String selectLeadership() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите должность сотрудника");
        System.out.println("1. Генеральный директор");
        System.out.println("2. Заместитель генерального директора");
        System.out.println("3. Коммерческий директор");
        System.out.println("4. Исполнительный директор");
        System.out.println("5. Директор по продажам");
        System.out.println("6. Заместитель директора по продажам");
        System.out.println("7. Заместитель коммерческого директора");
        System.out.println("8. Заместитель исполнительного директора");
        String i = scanner.next();
        String position = null;
        while (!Check.checkMenu(i, 8)) {
            i = scanner.next();
        }

        switch (Integer.valueOf(i)) {
            case 1:
                position = "Генеральный директор";
                break;
            case 2:
                position = "Заместитель генерального директора";
                break;
            case 3:
                position = "Коммерческий директор";
                break;
            case 4:
                position = "Исполнительный директор";
                break;
            case 5:
                position = "Директор по продажам";
                break;
            case 6:
                position = "Заместитель директора по продажам";
                break;
            case 7:
                position = "Заместитель коммерческого директора";
                break;
            case 8:
                position = "Заместитель исполнительного директора";
                break;
        }
        return position;
    }

    public static String selectHR() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите должность сотрудника");
        System.out.println("1. Главный бухгалтер");
        System.out.println("2. Бухгалтер");
        System.out.println("3. Начальник отдела финансов");
        System.out.println("4. Экономист");
        System.out.println("5. Специалист по кадрам");
        String i = scanner.next();
        String position = null;
        while (!Check.checkMenu(i, 5)) {
            i = scanner.next();
        }

        switch (Integer.valueOf(i)) {
            case 1:
                position = "Главный бухгалтер";
                break;
            case 2:
                position = "Бухгалтер";
                break;
            case 3:
                position = "Начальник отдела финансов";
                break;
            case 4:
                position = "Экономист";
                break;
            case 5:
                position = "Специалист по кадрам";
                break;
        }
        return position;
    }

    public static String selectIT() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите должность сотрудника");
        System.out.println("1. Руководитель отдела IT");
        System.out.println("2. Системный администратор");
        System.out.println("3. Сетевой инженер");
        System.out.println("4. Администратор 1С");
        System.out.println("5. Специалист по ИБ");
        System.out.println("6. Программист 1C");
        String i = scanner.next();
        String position = null;
        while (!Check.checkMenu(i, 6)) {
            i = scanner.next();
        }

        switch (Integer.valueOf(i)) {
            case 1:
                position = "Руководитель отдела IT";
                break;
            case 2:
                position = "Системный администратор";
                break;
            case 3:
                position = "Сетевой инженер";
                break;
            case 4:
                position = "Администратор 1С";
                break;
            case 5:
                position = "Специалист по ИБ";
                break;
            case 6:
                position = "Программист 1C";
                break;
        }
        return position;
    }

    public static String selectEdition() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите должность сотрудника");
        System.out.println("1. Главный редактор");
        System.out.println("2. Старший редактор");
        System.out.println("3. Помощник редактора");
        System.out.println("4. Верстальщик");
        System.out.println("5. Корректор");
        System.out.println("6. Дизайнер");
        String i = scanner.next();
        String position = null;
        while (!Check.checkMenu(i, 6)) {
            i = scanner.next();
        }

        switch (Integer.valueOf(i)) {
            case 1:
                position = "Главный редактор";
                break;
            case 2:
                position = "Старший редактор";
                break;
            case 3:
                position = "Помощник редактора";
                break;
            case 4:
                position = "Верстальщик";
                break;
            case 5:
                position = "Корректор";
                break;
            case 6:
                position = "Дизайнер";
                break;
        }
        return position;
    }

    public static String selectElaboration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите должность сотрудника");
        System.out.println("1. Начальник отдела развития");
        System.out.println("2. Специалист отдела развития");
        String i = scanner.next();
        String position = null;
        while (!Check.checkMenu(i, 2)) {
            i = scanner.next();
        }

        switch (Integer.valueOf(i)) {
            case 1:
                position = "Начальник отдела развития";
                break;
            case 2:
                position = "Специалист отдела развития";
                break;
        }
        return position;
    }

    public static String selectRussianLanguage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите должность сотрудника");
        System.out.println("1. Начальник отдела развития");
        System.out.println("2. Специалист");
        String i = scanner.next();
        String position = null;
        while (!Check.checkMenu(i, 2)) {
            i = scanner.next();
        }

        switch (Integer.valueOf(i)) {
            case 1:
                position = "Начальник отдела русского языка";
                break;
            case 2:
                position = "Специалист";
                break;
        }
        return position;
    }

    public static String selectMath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите должность сотрудника");
        System.out.println("1. Начальник отдела математики");
        System.out.println("2. Математик-программист");
        System.out.println("3. Главный специалист");
        System.out.println("4. Старший специалист");
        System.out.println("5. Специалист");
        System.out.println("6. Младший специалист");
        String i = scanner.next();
        String position = null;
        while (!Check.checkMenu(i, 6)) {
            i = scanner.next();
        }

        switch (Integer.valueOf(i)) {
            case 1:
                position = "Начальник отдела математики";
                break;
            case 2:
                position = "Математик-программист";
                break;
            case 3:
                position = "Главный специалист";
                break;
            case 4:
                position = "Старший специалист";
                break;
            case 5:
                position = "Младший специалист";
                break;
            case 6:
                position = "Специалист";
                break;
        }
        return position;
    }

    public static String selectSales() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите должность сотрудника");
        System.out.println("1. Директор департамента продаж");
        System.out.println("2. Заместитель директора департамента продаж");
        System.out.println("3. Специалист по работе с регионами");
        String i = scanner.next();
        String position = null;
        while (!Check.checkMenu(i, 3)) {
            i = scanner.next();
        }

        switch (Integer.valueOf(i)) {
            case 1:
                position = "Директор департамента продаж";
                break;
            case 2:
                position = "Заместитель директора департамента продаж";
                break;
            case 3:
                position = "Специалист по работе с регионами";
                break;
        }
        return position;
    }

}
