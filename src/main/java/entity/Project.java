package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String name;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModified;
    
    @ManyToMany
    private List<ProjectUser> projectUsers;
    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    public Project() {
    }

    public Project(int projectId, String name, String description, Date created, Date lastModified) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.created = created;
        this.lastModified = lastModified;
    }

    public Project(int projectId, String name, String description, Date created, Date lastModified, List<ProjectUser> projectUsers, List<Task> tasks) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.created = created;
        this.lastModified = lastModified;
        this.projectUsers = projectUsers;
        this.tasks = tasks;
    }

    public Project(String name, String description, Date created, Date lastModified) {
        this.name = name;
        this.description = description;
        this.created = created;
        this.lastModified = lastModified;
    }

    public Project(String name, String description, Date created, Date lastModified, List<ProjectUser> projectUsers) {
        this.name = name;
        this.description = description;
        this.created = created;
        this.lastModified = lastModified;
        this.projectUsers = projectUsers;
    }

    public Project(String name, String description, Date created, Date lastModified, List<ProjectUser> projectUsers, List<Task> tasks) {
        this.name = name;
        this.description = description;
        this.created = created;
        this.lastModified = lastModified;
        this.projectUsers = projectUsers;
        this.tasks = tasks;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public List<ProjectUser> getProjectUsers() {
        return projectUsers;
    }

    public void addProjectUsers(ProjectUser projectUsers) {
        this.projectUsers.add(projectUsers);
    }    

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTasks(Task tasks) {
        this.tasks.add(tasks);
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Project{" + "projectId=" + projectId + ", name=" + name + ", description=" + description + ", created=" + created + ", lastModified=" + lastModified + ", projectUsers=" + projectUsers + ", tasks=" + tasks + '}';
    }

}