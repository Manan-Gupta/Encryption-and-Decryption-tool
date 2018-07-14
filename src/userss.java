import java.io.Serializable;

@SuppressWarnings("serial")
public class userss implements Serializable{
	     
	    private String name;
	    private String keyy;
	    private String password;    
	    
	     
	    
	    public String getname() {
	        return name;
	    }
	 
	    public void setname(String name) {
	        this.name = name;
	    }
	 
	    public String getkeyy() {
	        return keyy;
	    }
	 
	    public void setkeyy(String keyy) {
	        this.keyy = keyy;
	    }
	 
	    public String getpassword() {
	        return password;
	    }
	 
	    public void setpassword(String salary) {
	        this.password = salary;
	    }
	}

