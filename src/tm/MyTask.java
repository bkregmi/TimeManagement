/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bregm_000
 */
@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)

public class MyTask {

    private int taskID;
    private int parentID;
    private String taskName;
    private String taskDescription;
    private Duration taskDuration;
    private LocalDateTime plannedStart;
    private LocalDateTime plannedEnd;
    private LocalDateTime actualStart;
    private LocalDateTime actualEnd;
    private Duration plannedDuration;
    private Duration actualDuration;
    private boolean isImportant;
    private boolean isUrgent;
    private String taskStatus;
    private Map<String, MyTask> taskMap;
    private List<MyTask> tasks;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

    public MyTask() {

    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Duration getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(Duration taskDuration) {
        this.taskDuration = taskDuration;
    }

    public boolean isIsImportant() {
        return isImportant;
    }

    public void setIsImportant(boolean isImportant) {
        this.isImportant = isImportant;
    }

    public boolean isIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    public LocalDateTime getPlannedStart() {
        return plannedStart;
    }

    public void setPlannedStart(LocalDateTime plannedStart) {
        this.plannedStart = plannedStart;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskMap(Map<String, MyTask> taskMap) {
        this.taskMap = taskMap;
    }

    public void setTasks(List<MyTask> tasks) {
        this.tasks = tasks;
    }

    public LocalDateTime getPlannedEnd() {
        return plannedEnd;
    }

    public void setPlannedEnd(LocalDateTime plannedEnd) {
        this.plannedEnd = plannedEnd;
    }

    public LocalDateTime getActualStart() {
        return actualStart;
    }

    public void setActualStart(LocalDateTime actualStart) {
        this.actualStart = actualStart;
    }

    public LocalDateTime getActualEnd() {
        return actualEnd;
    }

    public void setActualEnd(LocalDateTime actualEnd) {
        this.actualEnd = actualEnd;
    }

    public Duration getPlannedDuration() {
        return plannedDuration;
    }

    public void setPlannedDuration(Duration plannedDuration) {
        this.plannedDuration = plannedDuration;
    }

    public Duration getActualDuration() {
        return actualDuration;
    }

    public void setActualDuration(Duration actualDuration) {
        this.actualDuration = actualDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public void parseXML() throws XPathExpressionException {
        DocumentBuilderFactory builderFactory
                = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
        }

        try {
            Document xmlDocument = builder.parse(
                    new FileInputStream("src/tm/tasks.xml"));
            String expression = "/projects/project/projectName";
            String tExpression = "/projects/project/tasks";

//read a string value
            String projectName = xPath.compile(expression).evaluate(xmlDocument);
            String tasks = xPath.compile(tExpression).evaluate(xmlDocument);
//read an xml node using xpath
            Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
            Node tNode = (Node) xPath.compile(tExpression).evaluate(xmlDocument, XPathConstants.NODE);
//read a nodelist using xpath
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            NodeList tNodeList = (NodeList) xPath.compile(tExpression).evaluate(xmlDocument, XPathConstants.NODESET);
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
//            }

            if (null != tNode) {
                tNodeList = tNode.getChildNodes();
                NodeList nList = xmlDocument.getElementsByTagName("task");
                System.out.println("============================");

                visitChildNodes(nList);

//                for (int i = 0; null != nodeList && i < tNodeList.getLength(); i++) {
//                    System.out.println(i);
//                    Node nod = tNodeList.item(i);
//                    //if (nod.getNodeType() == Node.ELEMENT_NODE) {
//                    System.out.println(tNodeList.item(i).getNodeName() + " : " + nod.getFirstChild().getNodeValue());
//                    // }
//                }
            }

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void visitChildNodes(NodeList nList) {
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("Node Name = " + node.getNodeName() + "; Value = " + node.getTextContent());
                //Check all attributes
                if (node.hasAttributes()) {
                    // get attributes names and values
                    NamedNodeMap nodeMap = node.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node tempNode = nodeMap.item(i);
                        System.out.println("Attr name : " + tempNode.getNodeName() + "; Value = " + tempNode.getNodeValue());
                    }
                    if (node.hasChildNodes()) {
                        //We got more childs; Let's visit them as well
                        visitChildNodes(node.getChildNodes());
                    }
                }
            }
        }
    }

    public void removeTask(MyTask task) {
        //taskMap.remove("" + task.getTaskID(), task);
    }

    public void addTask(MyTask task) {

    }

    public void updateTask(MyTask task) {

    }

    public void parseTasksXML() {
        try {
            String id;
            String pid;
            String name;
            String desc;
            String pDuration;
            String aDuration;
            String pStart;
            String pEnd;
            String aStart;
            String aEnd;
            String important;
            String urgent;
            String status;
            MyTask task;
            tasks = new ArrayList<>();
            taskMap = new HashMap<String, MyTask>();
            //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
            Calendar cal = Calendar.getInstance();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src/tm/tasks.xml"));
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("task");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    //Create new MyTask Object
                    task = new MyTask();
                    id = eElement.getAttribute("taskID");
                    pid = eElement.getAttribute("parentID");
                    name = eElement.getElementsByTagName("taskName").item(0).getTextContent();
                    desc = eElement.getElementsByTagName("taskDescription").item(0).getTextContent();
                    pStart = eElement.getElementsByTagName("plannedStart").item(0).getTextContent();
                    pEnd = eElement.getElementsByTagName("plannedEnd").item(0).getTextContent();
                    pDuration = eElement.getElementsByTagName("plannedDuration").item(0).getTextContent();
                    aDuration = ((eElement.getElementsByTagName("actualDuration").item(0).getTextContent() == null
                            || eElement.getElementsByTagName("actualDuration").item(0).getTextContent().isEmpty())
                                    ? "0" : eElement.getElementsByTagName("actualDuration").item(0).getTextContent());
                    aStart = eElement.getElementsByTagName("actualStart").item(0).getTextContent();
                    aEnd = eElement.getElementsByTagName("actualStart").item(0).getTextContent();
                    urgent = eElement.getElementsByTagName("isUrgent").item(0).getTextContent();
                    important = eElement.getElementsByTagName("isImportant").item(0).getTextContent();
                    status = eElement.getElementsByTagName("taskStatus").item(0).getTextContent();
                    if (urgent.equalsIgnoreCase("no") || urgent.isEmpty()) {
                        task.setIsUrgent(false);
                    } else {
                        task.setIsUrgent(false);
                    }
                    if (important.isEmpty() || important.equalsIgnoreCase("no")) {
                        task.setIsImportant(false);
                    } else {
                        task.setIsImportant(true);
                    }

                    task.setTaskID(Integer.parseInt(id));
                    task.setTaskDescription(desc);
                    task.setTaskName(name);
                    task.setPlannedDuration(Duration.ofMinutes(Integer.parseInt(pDuration)));
                    task.setActualDuration(Duration.ofMinutes(Integer.parseInt(aDuration)));
                    if (!(aStart.isEmpty())) {
                        task.setActualStart(LocalDateTime.parse(aStart, dtf));
                    }
                    if (!(aEnd.isEmpty())) {
                        task.setActualStart(LocalDateTime.parse(aStart, dtf));
                    }
                    if (!(aEnd.isEmpty())) {
                        task.setActualEnd(LocalDateTime.parse(aEnd, dtf));
                    }
                    if (!(pStart.isEmpty())) {
                        task.setPlannedStart(LocalDateTime.parse(pStart, dtf));
                    }

                    if (!(pEnd.isEmpty())) {
                        task.setPlannedEnd(LocalDateTime.parse(pEnd, dtf));
                    }
                    if (!(status.isEmpty())) {
                        task.setStatus(status);
                    }
                    task.setIsUrgent(true);
                    if (!(task.getTaskStatus().equalsIgnoreCase("done"))) {
                        taskMap.put("" + task.getTaskID(), task);
                    }
                    tasks.add(task);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(MyTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<MyTask> getTasks() {
        return tasks;
        //return null;
    }

    public Map<String, MyTask> getTaskMap() {
        return taskMap;
        //return null;
    }

    
    @Override
    public String toString() {
        return "Task [ID=" + taskID
                + ", Tak Name=" + taskName
                + ", Planned Start=" + plannedStart
                + ", plannedEnd=" + plannedEnd
                + " Planned duration=" + plannedDuration.getSeconds() / 60
                + " Is important=" + isImportant
                + " Is urgent=" + isUrgent
                + "]\n";
    }

}
