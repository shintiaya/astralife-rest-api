package com.astralife.rest.core.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.astralife.rest.core.enums.EncryptionMode;


public class EncryptionUtils {

	private static final String KEY = "thisisa128bitkey";
	public static synchronized String doCrypt(String value, EncryptionMode mode) {
		try {
			
		    byte[] encryptionKeyBytes = KEY.getBytes();
		 
		    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		    SecretKey secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
		    if(mode.equals(EncryptionMode.ENCRYPT)) {
		    	cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			    byte[] encryptedMessageBytes = cipher.doFinal(value.getBytes());
			    String encoded = Base64.getEncoder().encodeToString(encryptedMessageBytes);
			    return encoded;
		    }else if(mode.equals(EncryptionMode.DECRYPT)) {
			    cipher.init(Cipher.DECRYPT_MODE, secretKey);

			    byte[] decoded = Base64.getDecoder().decode(value.getBytes());
			    byte[] decryptedMessageBytes = cipher.doFinal(decoded);
			    return new String(decryptedMessageBytes);
		    }

		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
	}
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

	    String encryptionKeyString =  "thisisa128bitkey";
	    String originalMessage = "This is a secret message";
	    byte[] encryptionKeyBytes = encryptionKeyString.getBytes();
	 
	    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    SecretKey secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");
	    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	 
	    byte[] encryptedMessageBytes = cipher.doFinal(originalMessage.getBytes());
	 
	    cipher.init(Cipher.DECRYPT_MODE, secretKey);
	 
	    byte[] decryptedMessageBytes = cipher.doFinal(encryptedMessageBytes);
	    System.out.println(new String(decryptedMessageBytes));
	    System.out.println(originalMessage);
	}
}
