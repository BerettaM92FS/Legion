package legion;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ModificationXML {
    public static boolean save(ArrayList<Employee> employees) {
        final File file = new File("legion.xml");
        boolean result = true;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element rootElement = document.createElement("employees");
            document.appendChild(rootElement);

            for (Employee employee : employees) {
                Element employeeNode = createEmployeeNode(document, employee);
                rootElement.appendChild(employeeNode);
            }

            saveXML(document, file);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static Element createEmployeeNode(Document document, Employee legion) {
        //Create employee tag
        Element employeeElement = document.createElement("employee");
        //ID
        Element idElement = document.createElement("id");
        idElement.appendChild(document.createTextNode(legion.getId()));
        employeeElement.appendChild(idElement);//close tag
        //surname
        Element surnameElement = document.createElement("surname");
        surnameElement.appendChild(document.createTextNode(legion.getSurname()));
        employeeElement.appendChild(surnameElement);
        //name
        Element nameElement = document.createElement("name");
        nameElement.appendChild(document.createTextNode(legion.getName()));
        employeeElement.appendChild(nameElement);
        //patronymic
        Element patronymicElement = document.createElement("patronymic");
        patronymicElement.appendChild(document.createTextNode(legion.getPatronymic()));
        employeeElement.appendChild(patronymicElement);
        //birthday
        Element birthdayElement = document.createElement("birthday");
        birthdayElement.appendChild(document.createTextNode(legion.getBirthday()));
        employeeElement.appendChild(birthdayElement);
        //gender
        Element genderElement = document.createElement("gender");
        genderElement.appendChild(document.createTextNode(legion.getGender()));
        employeeElement.appendChild(genderElement);
        //phone
        Element phoneElement = document.createElement("phone");
        phoneElement.appendChild(document.createTextNode(legion.getPhone()));
        employeeElement.appendChild(phoneElement);
        //position
        Element positionElement = document.createElement("position");
        positionElement.appendChild(document.createTextNode(legion.getPosition()));
        employeeElement.appendChild(positionElement);
        //otdel
        Element otdelElement = document.createElement("otdel");
        otdelElement.appendChild(document.createTextNode(legion.getDepartment()));
        employeeElement.appendChild(otdelElement);
        //bossID
        Element bossIDElement = document.createElement("bossID");
        bossIDElement.appendChild(document.createTextNode(legion.getBoss()));
        employeeElement.appendChild(bossIDElement);
        //date
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Element dateElement = document.createElement("date");
        dateElement.appendChild(document.createTextNode(df.format(legion.getDate())));
        employeeElement.appendChild(dateElement);
        //money
        Element moneyElement = document.createElement("money");
        moneyElement.appendChild(document.createTextNode(String.valueOf(legion.getMoney())));
        employeeElement.appendChild(moneyElement);
        //status
        Element statusElement = document.createElement("status");
        statusElement.appendChild(document.createTextNode(String.valueOf(legion.getStatus())));
        employeeElement.appendChild(statusElement);

        return employeeElement;
    }

    public static void update (String id, String tag, String value) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            File file = new File("legion.xml");
            Document document = documentBuilder.parse(file);
            NodeList employees = document.getElementsByTagName("employee");
            for (int i = 0; i < employees.getLength(); i++) {
                Element employee = (Element) employees.item(i);
                if (employee.getElementsByTagName("id").item(0).getTextContent().equalsIgnoreCase(id)) {
                    Element anyTag = (Element) employee.getElementsByTagName(tag).item(0);
                    anyTag.setTextContent(String.valueOf(value));
                    break;
                }
            }
            saveXML(document, file);
        } catch (ParserConfigurationException | SAXException | IOException u) {
            u.printStackTrace();
        }
    }

    private static void saveXML(Document document, File file) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, streamResult);
        } catch (TransformerException t) {
            t.printStackTrace();
        }
    }
}
