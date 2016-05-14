/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author bregm_000
 */
@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
/**
 * Task class maps to task fields from XML
 * 
 */
 
public class Task {
    @XmlAttribute (name="taskID")
    private int taskID;
    @XmlAttribute (name="parentID")
    private int parentID;
    private String taskName;
    private String taskDescription;
    
    //@XmlJavaTypeAdapter (LocalDateTimeAdapter.class)   
    private String plannedStart;
    //@XmlJavaTypeAdapter (LocalDateTimeAdapter.class)
    private String plannedEnd;
    
    //@XmlJavaTypeAdapter(DurationAdapter.class)
    private int plannedDuration;
    //@XmlJavaTypeAdapter (LocalDateTimeAdapter.class)
    private String actualStart;
    private String actualEnd;    
    //@XmlJavaTypeAdapter(DurationAdapter.class)
    private int actualDuration;
    private boolean isImportant;
    private boolean isUrgent;
    private String taskStatus;
    
    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
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

    public String getPlannedStart() {
        return plannedStart;
    }

    public void setPlannedStart(String plannedStart) {
        this.plannedStart = plannedStart;
    }

    public String getPlannedEnd() {
        return plannedEnd;
    }

    public void setPlannedEnd(String plannedEnd) {
        this.plannedEnd = plannedEnd;
    }

    public String getActualStart() {
        return actualStart;
    }

    public void setActualStart(String actualStart) {
        this.actualStart = actualStart;
    }

    public String getActualEnd() {
        return actualEnd;
    }

    public void setActualEnd(String actualEnd) {
        this.actualEnd = actualEnd;
    }

    public int getPlannedDuration() {
        return plannedDuration;
    }

    public void setPlannedDuration(int plannedDuration) {
        this.plannedDuration = plannedDuration;
    }

    public int getActualDuration() {
        return actualDuration;
    }

    public void setActualDuration(int actualDuration) {
        this.actualDuration = actualDuration;
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

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        /* Checked out of GIT */
        return "Task [ID=" + taskID
                + ", Parent TaskID=" + parentID
                + ", Task Name=" + taskName
                + ", Planned Start=" + plannedStart
                + ", plannedEnd=" + plannedEnd
                + " Planned duration=" + plannedDuration
                + " Is important=" + isImportant
                + " Is urgent=" + isUrgent
                + "]\n";
    }

}
