package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int taskId;
    private String name;
    private String description;
    private int hoursAssigned;
    private int hoursUsed;
    @ManyToOne
    private Project project;
    
    public Task() {
    }

    public Task(int taskId, String name, String description, int hoursAssigned, int hoursUsed) {
        this.taskId = taskId;
        this.name = name;
        this.description = description;
        this.hoursAssigned = hoursAssigned;
        this.hoursUsed = hoursUsed;
    }

    public Task(String name, String description, int hoursAssigned) {
        this.name = name;
        this.description = description;
        this.hoursAssigned = hoursAssigned;
    }

    public Task(int taskId, String name, String description, int hoursAssigned, int hoursUsed, Project project) {
        this.taskId = taskId;
        this.name = name;
        this.description = description;
        this.hoursAssigned = hoursAssigned;
        this.hoursUsed = hoursUsed;
        this.project = project;
    }

    public Task(String name, String description, int hoursAssigned, int hoursUsed) {
        this.name = name;
        this.description = description;
        this.hoursAssigned = hoursAssigned;
        this.hoursUsed = hoursUsed;
    }

    public Task(String name, String description, int hoursAssigned, int hoursUsed, Project project) {
        this.name = name;
        this.description = description;
        this.hoursAssigned = hoursAssigned;
        this.hoursUsed = hoursUsed;
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHoursAssigned() {
        return hoursAssigned;
    }

    public void setHoursAssigned(int hoursAssigned) {
        this.hoursAssigned = hoursAssigned;
    }

    public int getHoursUsed() {
        return hoursUsed;
    }

    public void setHoursUsed(int hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    
}
