import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

 
public class users {
 
    public void storeObject(userss emp,String nu1) throws IOException{
         
        OutputStream os = null;
        DataOutputStream ds = null;
        ObjectOutputStream objos = null;
        try {
            os = new FileOutputStream("C:\\Users\\Public\\"+nu1);
            ds = new DataOutputStream(os);
            objos = new ObjectOutputStream(ds);
            objos.writeObject(emp);
            objos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
             objos.close();
             os.close();
            
        }
         
    }
   
    }
  
    



