/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm;

import java.io.File;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bregm_000
 */
@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)

public class Tasks {

    @XmlElement(name = "task")
    private List<Task> tasks = null;
    private Map<String, Task> taskMap = null;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    public Map<String, Task> getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(Map<String, Task> taskMap) {
        this.taskMap = taskMap;
    }
    public static Tasks unMarshalTasks() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Tasks.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Tasks mtasks = (Tasks) jaxbUnmarshaller.unmarshal(new File("src/tm/tasks.xml"));
        //MarshalTask mtask = new Task();
        for (Task task : mtasks.getTasks()) {
            System.out.print(task);
        }
        return mtasks;
    }
    public static void marshalTasks(Tasks tasks) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Tasks.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(tasks, System.out);
        jaxbMarshaller.marshal(tasks, new File("src/tm/mtasks.xml"));
    }
}
