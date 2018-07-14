import java.util.Random;

public class Keygen {
	public String geek_Password(int len)
    {
        String cc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String sc = "abcdefghijklmnopqrstuvwxyz";
        String num = "0123456789";
        String sym = "!@#$%^&*_=+-/.?<>)(";
        String va = cc + sc + num + sym;
        Random rm = new Random(); 
        char[] pas = new char[len]; 
        for (int i = 0; i < len; i++)
        {
            pas[i] =va.charAt(rm.nextInt(va.length()));
 
        }
        return String.valueOf(pas);
    }

}
