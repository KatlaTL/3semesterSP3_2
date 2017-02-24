package starter;

import entity.Project;
import entity.ProjectUser;
import entity.Task;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Tester {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);

    public static void main(String[] args) {
        Tester t = new Tester();
        t.createUser("Asger", "asger@gmail.com");
        t.createUser("jakob", "jakob@gmail.com");
        t.createUser("Hans", "hans@gmail.com");
        t.createProject("Project_1.01", "something funny");
        
        t.assignUserToProject(1,1);
        t.assignUserToProject(2,1);
        t.createTaskAndAssignToProject("taske1", "something", 20, 1);
        
        System.out.println("find user: " + t.findUser(1).toString());
        System.out.println("get all users: " + t.getAllUsers());
        System.out.println("find project: " + t.findProject(1));
//        EntityManager em = t.getManager();
//        try {
//            em.getTransaction().begin();
//            
//            em.getTransaction().commit();
//        } catch(Exception e){
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
    }

    public void createUser(String userName, String email) {
        ProjectUser pu = new ProjectUser(userName, email, new Date());
        EntityManager em = getManager();
        try {
            em.getTransaction().begin();
            em.persist(pu);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public ProjectUser findUser(int userId){
        EntityManager em = getManager();
        ProjectUser pu = new ProjectUser();
        try {
            em.getTransaction().begin();
            pu = em.find(ProjectUser.class, userId);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return pu;
    }
    
    public List<ProjectUser> getAllUsers(){
        EntityManager em = getManager();
        List<ProjectUser> puList = new ArrayList();
        try {
            Query q1 = em.createQuery("SELECT u FROM ProjectUser u");
            puList = q1.getResultList();
        } finally {
            em.close();
        }
        return puList;
    }
    
    public void createProject(String name, String description) {
        EntityManager em = getManager();
        Project p = new Project(name, description, new Date(), new Date());
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void assignUserToProject(int userId, int projectId) {
        EntityManager em = getManager();
        try {
            em.getTransaction().begin();
            ProjectUser pu = em.find(ProjectUser.class, userId);
            Project p = em.find(Project.class, projectId);
            pu.addProjects(p);
            p.addProjectUsers(pu);
            em.merge(pu);
            em.merge(p);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public Project findProject(int projectId){
        EntityManager em = getManager();
        Project p = new Project();
        try {
            em.getTransaction().begin();
            p = em.find(Project.class, projectId);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return p;
    }
    
    public void createTaskAndAssignToProject(String name, String description, int hoursAssigned, int projectId) {
        EntityManager em = getManager();
        try {
            em.getTransaction().begin();
            Task t = new Task(name, description, hoursAssigned);
            Project p = em.find(Project.class, projectId);
            t.setProject(p);
            p.addTasks(t);
            em.merge(t);
            em.merge(p);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    private EntityManager getManager() {
        return emf.createEntityManager();
    }
}
