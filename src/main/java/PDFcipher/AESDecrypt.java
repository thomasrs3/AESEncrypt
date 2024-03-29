/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package PDFcipher;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESDecrypt {

    public static void startDecrypt(String inputEncryptedDirectory, String outputDecipherDirectory, String keyDirectory) {

      //Initializing a Cipher Text
      CipherInputStream decipherText = null;
      FileOutputStream fost = null;
      FileInputStream data = null;
      //AES key
      Key AESkey = null;

      //get data from input File
      try{ data = new FileInputStream(inputEncryptedDirectory); }
      catch(FileNotFoundException ex) { System.out.println(ex.getMessage()); }

      //get AES key from decrypted fileDirectory
      try{ AESkey = readFile(keyDirectory); }
      catch(IOException ex) { System.out.println(ex.getMessage()); }

      //get data from input File
      try{ fost = new FileOutputStream(outputDecipherDirectory); }
      catch(FileNotFoundException ex) { System.out.println(ex.getMessage()); }
      //make cipher
      try{ decipherText = decryptCall(data, AESkey); }
      catch(IOException ex) { System.out.println(ex.getMessage()); }
      //print to file
      try{ writeDecrypt(fost, decipherText); }
      catch(IOException ex) { System.out.println(ex.getMessage()); }

      try{
        data.close();
        fost.close();
      }
      catch(IOException ex) {
        System.out.println(ex.getMessage());
      }
      System.out.println("Decrypt done");
    }

    private static CipherInputStream decryptCall(FileInputStream data, Key pair) throws IOException{

      Cipher cipher = null;
      try{//Creating a Cipher object
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      }
      catch(NoSuchPaddingException | NoSuchAlgorithmException ex) {
        System.out.println(ex.getMessage());
      }
      //Initializing a Cipher object
      try{ cipher.init(Cipher.DECRYPT_MODE, pair); }
      catch(InvalidKeyException ex) { System.out.println(ex.getMessage()); }
      return (new CipherInputStream(data, cipher));
    }

    private static void writeDecrypt(FileOutputStream data, CipherInputStream cipherText) throws IOException{
      int i;
      byte[] block = new byte[256];
      while ((i = cipherText.read(block)) != -1) {
        data.write(block, 0, i);
      }
      try{
        data.close();
        cipherText.close();
      }
      catch(IOException ex) {
        System.out.println(ex.getMessage());
      }
    }

    private static Key readFile(String path) throws IOException {
      byte[] encodedKey = null;
      try{ encodedKey = readFileString(path); }
      catch(IOException ex) { System.out.println(ex.getMessage()); }

      return (new SecretKeySpec(encodedKey,0,encodedKey.length, "AES"));
    }

    private static byte[] readFileString(String path) throws IOException {
      return Files.readAllBytes(Paths.get(path));
    }
}
