package legion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private String id;
    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private String birthday;
    private String gender;
    private String phone;
    private String department;
    private String boss;
    private Date date;
    private Integer money;
    private String status;
    private DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getBoss() {
        return boss;
    }

    public Date getDate() {
        return date;
    }

    public Integer getMoney() {
        return money;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  "Фамилия:       " + this.surname +
                "\nИмя:           " + this.name +
                "\nОтчество:      " + this.patronymic +
                "\nДата рождения: " + this.birthday +
                "\nПол:           " + this.gender +
                "\nТелефон:       " + this.phone +
                "\nДолжность:     " + this.position +
                "\nОтдел:         " + this.department +
                "\nДаты приёма:   " + df.format(this.date) +
                "\nЗарплата:      " + this.money +
                "\nСтатус:        " + this.status +
                "\n";
    }
}
