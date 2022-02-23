import javax.crypto.*;
import javax.crypto.spec.*;

class Main {

private static String asHex(byte buf[]) {
StringBuffer strbuf = new StringBuffer(buf.length*2);
 int i;
 for(i=0;i<buf.length;i++) {
	 if(((int)buf[i]& (0xff) )<0x10)
	 strbuf.append("0");
 strbuf.append(Long.toString((int)buf[i]&0xff, 16));
}
return strbuf.toString();
}

public static void main(String[]args) throws Exception {
String message = "ONLINE SMART TRAINER"; 
//Get the KeyGenerator 
KeyGenerator kgen= KeyGenerator.getInstance("AES");
 kgen.init(128); //192 and 256 bits may not be available 
//Generate the secret key specs. 
SecretKey skey = kgen.generateKey();
 byte[] raw = skey.getEncoded();
 SecretKeySpec skeySpec= new SecretKeySpec(raw,"AES");
 // Instantiate the cipher
 Cipher cipher = Cipher.getInstance("AES");
 cipher.init(Cipher.ENCRYPT_MODE,skeySpec);
 byte[] encrypted= cipher.doFinal((args.length==0? message : args[0]).getBytes());
 System.out.println("Encrypted String:" + asHex(encrypted)); 
cipher.init(Cipher.DECRYPT_MODE,skeySpec);
 byte[]original=cipher.doFinal(encrypted);
 String originalString=new String(original); 
System.out.println("Original String in Hexadecimal:" + asHex(original));
 System.out.println("Original String:" + originalString);
}
}

// Encrypted String:65f711c0bb75e5cdba334240d785d9de86d260f6da96e69a93ab344eafca40b8
// Original String in Hexadecimal:4f4e4c494e4520534d41525420545241494e4552
// Original String:ONLINE SMART TRAINER
