package legion;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class DomParser {
    private final File file = new File("legion.xml");
    private final ArrayList<Employee> arrayList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {

        parser(file);

        while (true) {
            System.out.println("1. Вывод всех сотрудников.");
            System.out.println("2. Вывод всех сотрудников по конкретным отделам.");
            System.out.println("3. Вывод уволенных сотрудников.");
            System.out.println("4. Поиск сотрудников.");
            System.out.println("5. Добавить нового сотрудника.");
            System.out.println("6. Изменить данные сотрудника.");
            System.out.println("7. ТОП-10 самых дорогих сотрудников");
            System.out.println("8. ТОП-10 самых преданных сотрудников");
            System.out.println("9. Выход");

            String temp = scanner.next();
            while (!Check.checkMenu(temp, 9)) {
                temp = scanner.next();
            }
            switch (Integer.valueOf(temp)) {
                case 1:
                    print(arrayList);
                    break;
                case 2:
                    departmentEmployee();
                    break;
                case 3:
                    getFiredEmployee(arrayList);
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    addNewEmployee();
                    break;
                case 6:
                    updateEmployee();
                    break;
                case 7:
                    goldEmployee(arrayList);
                    break;
                case 8:
                    oldEmployee(arrayList);
                    break;
                case 9:
                    return;
            }
        }
    }

    private void parser(File file) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(file);

            NodeList nodeList = document.getElementsByTagName("employee");

            for (int i = 0; i < nodeList.getLength(); i++) {
                arrayList.add(getEmployee(nodeList.item(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Employee getEmployee(Node node) throws ParseException {
        Employee employee = new Employee();
        if(node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            employee.setId(getTagValue("id", element));
            employee.setName(getTagValue("name", element));
            employee.setSurname(getTagValue("surname", element));
            employee.setPatronymic(getTagValue("patronymic", element));
            employee.setBirthday(getTagValue("birthday", element));
            employee.setGender(getTagValue("gender", element));
            employee.setPhone(getTagValue("phone", element));
            employee.setPosition(getTagValue("position", element));
            employee.setDepartment(getTagValue("otdel", element));
            employee.setBoss(getTagValue("bossID", element));
            employee.setDate(parseDate(getTagValue("date", element)));
            employee.setMoney(Integer.valueOf(getTagValue("money", element)));
            employee.setStatus(getTagValue("status", element));
        }
        return employee;
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
    private Date parseDate(String str) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.parse(str);
    }

    private void print(ArrayList<Employee> arrayList) {
        for (Employee employee: arrayList) {
            System.out.println(employee);
        }
    }

    private void departmentEmployee() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите отдел:");
        allDepartment();

        String temp = scanner.next();
        while (!Check.checkMenu(temp, 8)) {
            temp = scanner.next();
        }
        switch (Integer.valueOf(temp)) {
            case 1:
                arrayList.stream().filter(x -> x.getDepartment().equals("Руководство"))
                        .forEach(System.out::println);
                break;
            case 2:
                arrayList.stream().filter(x -> x.getDepartment().equals("Кадры и бухгалтерия"))
                        .forEach(System.out::println);
                break;
            case 3:
                arrayList.stream().filter(x -> x.getDepartment().equals("Отдел ИТ"))
                        .forEach(System.out::println);
                break;
            case 4:
                arrayList.stream().filter(x -> x.getDepartment().equals("Редакция"))
                        .forEach(System.out::println);
                break;
            case 5:
                arrayList.stream().filter(x -> x.getDepartment().equals("Отдел русского языка"))
                        .forEach(System.out::println);
                break;
            case 6:
                arrayList.stream().filter(x -> x.getDepartment().equals("Отдел математики"))
                        .forEach(System.out::println);
                break;
            case 7:
                arrayList.stream().filter(x -> x.getDepartment().equals("Отдел продаж"))
                        .forEach(System.out::println);
                break;
            case 8:
                arrayList.stream().filter(x -> x.getDepartment().equals("Отдел развития"))
                        .forEach(System.out::println);
                break;
        }
    }

    private void goldEmployee(ArrayList<Employee> arrayList) {
        arrayList.stream().sorted(Comparator.comparing(Employee::getMoney).reversed()).limit(10)
                .forEach(System.out::println);
    }

    private void oldEmployee(ArrayList<Employee> arrayList) {
        arrayList.stream().sorted(Comparator.comparing(Employee::getDate)).limit(10).forEach(System.out::println);
    }

    private void allDepartment() {
        System.out.println("1. Руководство");
        System.out.println("2. Кадры и бухгалтерия");
        System.out.println("3. Отдел ИТ");
        System.out.println("4. Редакция");
        System.out.println("5. Отдел русского языка");
        System.out.println("6. Отдел математики");
        System.out.println("7. Отдел продаж");
        System.out.println("8. Отдел развития");
    }

    private void search() {
        System.out.println("1. Поиск по фамилии");
        System.out.println("2. Поиск по имени");
        System.out.println("3. Поиск по должности");
        System.out.println("4. Поиск по ФИО начальника");
        System.out.println("5. Выход");

        String temp = scanner.next();
        while (!Check.checkMenu(temp, 5)) {
            temp = scanner.next();
        }
        switch (Integer.valueOf(temp)) {
            case 1:
                System.out.println("Введите фамилию сотрудника");
                String surname = scanner.next();
                while (!Check.checkText(surname)) {
                    surname = scanner.next();
                }
                String finalSurname = surname;
                List<Employee> filterOne = arrayList.stream()
                        .filter(x -> finalSurname.equals(x.getSurname()))
                        .collect(Collectors.toList());
                if (filterOne.size() > 0) {
                    filterOne.forEach(System.out::println);
                } else {
                    System.out.println("Сотрудник с такой фамилией не найден!" + "\n");
                }
                break;
            case 2:
                System.out.println("Введите имя сотрудника");
                String name = scanner.next();
                while (!Check.checkText(name)) {
                    name = scanner.next();
                }
                String finalName = name;
                List<Employee> filterTwo = arrayList.stream()
                        .filter(x -> finalName.equals(x.getName()))
                        .collect(Collectors.toList());
                if (filterTwo.size() > 0) {
                    filterTwo.forEach(System.out::println);
                } else {
                    System.out.println("Сотрудник с таким именем не найден!" + "\n");
                }
                break;
            case 3:
                System.out.println("Введите должность сотрудника");
                String position = scanner.next();
                while (!Check.checkText(position)) {
                    position = scanner.next();
                }
                String finalPosition = position;
                List<Employee> filterThree = arrayList.stream()
                        .filter(x -> finalPosition.equals(x.getPosition()))
                        .collect(Collectors.toList());
                if (filterThree.size() > 0) {
                    filterThree.forEach(System.out::println);
                } else {
                    System.out.println("Сотрудник с такой должностью не найден!" + "\n");
                }
                break;
            case 4:
                System.out.println("Выберите сотрудника");
                printAllFIO(arrayList);
                String bossID = getIdEmployee(arrayList);
                List<Employee> filterFour = arrayList.stream()
                        .filter(x -> bossID.equals(x.getBoss()))
                        .collect(Collectors.toList());
                if (filterFour.size() > 0) {
                    filterFour.forEach(System.out::println);
                } else {
                    System.out.println("У данного сотрудника нет подчинённых" + "\n");
                }
                break;
            case 5:
                return;
        }
    }

    private void addNewEmployee() {
        Employee employee = new Employee();

        System.out.println("В какой отдел добавить сотрудника?");
        allDepartment();

        String temp = scanner.next();
        while (!Check.checkMenu(temp, 8)) {
            temp = scanner.next();
        }
        employee.setDepartment(selectDepartment(Integer.valueOf(temp)));
        employee.setPosition(selectPosition(temp));

        String uuid = UUID.randomUUID().toString();
        employee.setId(uuid);

        System.out.println("Выберите пол сотрудника" + "\n1. Мужской" + "\n2. Женский");
        String tempTwo = scanner.next();
        while (!Check.checkMenu(tempTwo, 2)) {
            tempTwo = scanner.next();
        }
        employee.setGender(selectGender(Integer.valueOf(tempTwo)));

        System.out.println("Введите имя сотрудника");
        String name = scanner.next();
        while (!Check.checkText(name)) {
            name = scanner.next();
        }
        employee.setName(name);

        System.out.println("Введите фамилию сотрудника");
        String surname = scanner.next();
        while (!Check.checkText(surname)) {
            surname = scanner.next();
        }
        employee.setSurname(surname);

        System.out.println("Введите отчество сотрудника");
        String patronymic = scanner.next();
        while (!Check.checkText(patronymic)) {
            patronymic = scanner.next();
        }
        employee.setPatronymic(patronymic);

        System.out.println("Введите дату рождения сотрудника в данном формате: дд.ММ.гггг");
        String birthday = scanner.next();
        while (!Check.checkBirthday(birthday)) {
            birthday = scanner.next();
        }
        employee.setBirthday(birthday);

        System.out.println("Введите номер сотрудника в данном формате: Х(ХХХ)ХХХ-ХХ-ХХ");
        String phone = scanner.next();
        while (!Check.checkPhone(phone)) {
            phone = scanner.next();
        }
        employee.setPhone(phone);

        employee.setBoss(selectBoss());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date now = new Date();
        String td = sdf.format(now);
        try {
            Date date = sdf.parse(td);
            employee.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Введите зарплату сотрудника");
        String money = scanner.next();
        while (!Check.testMoney(money)) {
            money = scanner.next();
        }
        employee.setMoney(Integer.valueOf(money));

        employee.setStatus("Числится");

        arrayList.add(employee);

        if (ModificationXML.save(arrayList)) {
            System.out.println("Готово");
        }
    }

    private String getIdEmployee(ArrayList<Employee> arrayList) {
        String temp = scanner.next();
        while (!Check.checkMenu(temp, arrayList.size())) {
            temp = scanner.next();
        }
        String id = arrayList.get(Integer.valueOf(temp) - 1).getId();
        return id;
    }

    private void printAllFIO(ArrayList<Employee> arrayList) {
        int count = 0;
        List<String> listFIO = arrayList.stream().map(x -> x.getSurname() + " " + x.getName() + " " + x.getPatronymic()).collect(Collectors.toList());
        //arrayList.stream().map(x -> x.getSurname() + " " + x.getName() + " " + x.getPatronymic()).forEach(System.out::println);
        for (String s : listFIO) {
            count++;
            System.out.println(count + ". " + s);
        }
    }

    private void updateEmployee() {
        System.out.println("Какого сотрудника хотите изменить?");
        printAllFIO(arrayList);
        choiceTag(getIdEmployee(arrayList));
    }
    private void choiceTag(String id) {
        System.out.println("Что хотите изменить?" + "\n");
        System.out.println("1. Фамилию");
        System.out.println("2. Имя");
        System.out.println("3. Отчество");
        System.out.println("4. Дату рождения");
        System.out.println("5. Пол");
        System.out.println("6. Телефон");
        System.out.println("7. Отдел и должность");
        System.out.println("8. Начальника");
        System.out.println("9. Дату зачисления");
        System.out.println("10. Зарплату");
        System.out.println("11. Уволить");
        String tag = null;
        String value = null;
        String s = scanner.next();
        while (!Check.checkMenu(s, 11)) {
            s = scanner.next();
        }
        switch (Integer.valueOf(s)) {
            case 1:
                tag = "surname";
                System.out.println("Введите фамилию сотрудника");
                value = scanner.next();
                while (!Check.checkText(value)) {
                    value = scanner.next();
                }
                break;
            case 2:
                tag = "name";
                System.out.println("Введите имя сотрудника");
                value = scanner.next();
                while (!Check.checkText(value)) {
                    value = scanner.next();
                }
                break;
            case 3:
                tag = "patronymic";
                System.out.println("Введите отчество сотрудника");
                value = scanner.next();
                while (!Check.checkText(value)) {
                    value = scanner.next();
                }
                break;
            case 4:
                tag = "birthday";
                System.out.println("Введите дату рождения сотрудника в данном формате: дд.ММ.гггг");
                value = scanner.next();
                while (!Check.checkBirthday(value)) {
                    value = scanner.next();
                }
                break;
            case 5:
                tag = "gender";
                System.out.println("Выберите пол сотрудника" + "\n1. Мужской" + "\n2. Женский");
                String t = scanner.next();
                while (!Check.checkMenu(t, 2)) {
                    t = scanner.next();
                }
                value = selectGender(Integer.valueOf(t));
                break;
            case 6:
                tag = "phone";
                System.out.println("Введите номер сотрудника в данном формате: Х(ХХХ)ХХХ-ХХ-ХХ");
                value = scanner.next();
                while (!Check.checkPhone(value)) {
                    value = scanner.next();
                }
                break;
            case 7:
                departmentAndPosition(id);
                return;
            case 8:
                tag = "bossID";
                value = selectBoss();
                break;
            case 9:
                tag = "date";
                System.out.println("Введите дату в данном формате: дд.ММ.гггг");
                value = scanner.next();
                while (!Check.checkDate(value)) {
                    value = scanner.next();
                }
                break;
            case 10:
                tag = "money";
                System.out.println("Введите зарплату сотрудника");
                value = scanner.next();
                while (!Check.testMoney(value)) {
                    value = scanner.next();
                }
                break;
            case 11:
                tag = "status";
                value = "Уволен";
                break;
        }
        ModificationXML.update(id, tag, value);
    }

    private String selectGender(int i) {
        if (i == 1) {
            return "Мужской";
        }
        return "Женский";
    }

    private String selectDepartment(int i) {
        String departent = null;
        switch (i) {
            case 1:
                departent = "Руководство";
                break;
            case 2:
                departent = "Кадры и бухгалтерия";
                break;
            case 3:
                departent = "Отдел ИТ";
                break;
            case 4:
                departent = "Редакция";
                break;
            case 5:
                departent = "Отдел русского языка";
                break;
            case 6:
                departent = "Отдел математики";
                break;
            case 7:
                departent = "Отдел продаж";
                break;
            case 8:
                departent = "Отдел развития";
                break;
        }
        return departent;
    }

    private String selectBoss() {
        String boss = null;
        System.out.println("Вы хотите назначить начальника?" + "\n1. Да" + "\n2. Нет");
        String temp = scanner.next();
        while (!Check.checkMenu(temp, 2)) {
            temp = scanner.next();
        }
        switch (Integer.valueOf(temp)) {
            case 1:
                printAllFIO(arrayList);
                System.out.println("Выберите начальника");
                boss = getIdEmployee(arrayList);
                break;
            case 2:
                boss = " ";
                break;
        }
        return boss;
    }

    private static String selectPosition(String s) {
        String pos = null;
        switch (Integer.valueOf(s)) {
            case 1:
                pos = SelectPosition.selectLeadership();
                break;
            case 2:
                pos = SelectPosition.selectHR();
                break;
            case 3:
                pos = SelectPosition.selectIT();
                break;
            case 4:
                pos = SelectPosition.selectEdition();
                break;
            case 5:
                pos = SelectPosition.selectRussianLanguage();
                break;
            case 6:
                pos = SelectPosition.selectMath();
                break;
            case 7:
                pos = SelectPosition.selectSales();
                break;
            case 8:
                pos = SelectPosition.selectElaboration();
                break;
        }
        return pos;
    }

    private void departmentAndPosition(String id) {
        System.out.println("Выберите отдел");
        allDepartment();
        String te = scanner.next();
        while (!Check.checkMenu(te, 8)) {
            te = scanner.next();
        }
        String value = selectDepartment(Integer.valueOf(te));
        ModificationXML.update(id, "otdel", value);
        ModificationXML.update(id, "position", selectPosition(te));
    }

    private void getFiredEmployee(ArrayList<Employee> arrayList) {
        arrayList.stream().filter(x -> x.getStatus().equals("Уволен")).forEach(System.out::println);
    }
}
