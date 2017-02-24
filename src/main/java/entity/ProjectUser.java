package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

@Entity
public class ProjectUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int userId;
    private String userName;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;
    @ManyToMany(mappedBy = "projectUsers")
    private List<Project> projects;

    public ProjectUser() {
    }

    public ProjectUser(int userId, String userName, String email, Date created) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.created = created;
    }

    public ProjectUser(int userId, String userName, String email, Date created, List<Project> projects) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.created = created;
        this.projects = projects;
    }

    public ProjectUser(String userName, String email, Date created) {
        this.userName = userName;
        this.email = email;
        this.created = created;
    }

    public ProjectUser(String userName, String email, Date created, List<Project> projects) {
        this.userName = userName;
        this.email = email;
        this.created = created;
        this.projects = projects;
    }
  
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProjects(Project projects) {
        this.projects.add(projects);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ProjectUser{" + "userId=" + userId + ", userName=" + userName + ", email=" + email + ", created=" + created + ", projects=" + projects + '}';
    }
    
}