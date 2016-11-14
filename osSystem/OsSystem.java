package osSystem;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;  

@ManagedBean
@SessionScoped
public class OsSystem implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
    private String version;


    public OsSystem() {
        name = "My OsSystem";
        version = "1.2";
    }
    
    public OsSystem(String name, String version) {
        this.name = name;
        this.version = version;
    }

    @Override
    public String toString() {
        return "osSystem " + name + " was published in " + version;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    
}
