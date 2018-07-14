
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

class Crypto1 {
	private static final String ALGO = "AES";
	private static final String TRANS = "AES";

	public static void encrypt(String key, File i, File o)
			throws Exceptionforcrypto {
		doCrypto(Cipher.ENCRYPT_MODE, key, i, o);
	}

	public static void decrypt(String key, File i, File o)
			throws Exceptionforcrypto {
		doCrypto(Cipher.DECRYPT_MODE, key, i, o);
	}

	private static void doCrypto(int cipherMode, String key, File in,
			File ou) throws Exceptionforcrypto {
		try {
			Key secretKey = new SecretKeySpec(key.getBytes(), ALGO);
			Cipher cipher = Cipher.getInstance(TRANS);
			cipher.init(cipherMode, secretKey);
			
			FileInputStream inputStream = new FileInputStream(in);
			byte[] input = new byte[(int) in.length()];
			inputStream.read(input);
			
			byte[] output = cipher.doFinal(input);
			
			FileOutputStream outputStream = new FileOutputStream(ou);
			outputStream.write(output);
			
			inputStream.close();
			outputStream.close();
			
		} catch (NoSuchPaddingException | NoSuchAlgorithmException
				| InvalidKeyException | BadPaddingException
				| IllegalBlockSizeException | IOException ex) {
			throw new Exceptionforcrypto("Error on encrypting/decrypting your file",ex);
		}
	}
}

