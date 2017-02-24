package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-24T10:23:07")
@StaticMetamodel(Project.class)
public class Project_ { 

    public static volatile SingularAttribute<Project, Date> created;
    public static volatile SingularAttribute<Project, String> name;
    public static volatile SingularAttribute<Project, String> description;
    public static volatile SingularAttribute<Project, Date> lastModified;

}