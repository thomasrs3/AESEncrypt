/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package PDFcipher;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.NoSuchAlgorithmException;
//import java.security.InvalidKeyException;

public class PDFKey {
  private static KeyPair Pair;

  public static void main(){
    PDFKey.Pair = null;
  }
  //Asymmetric Key
  public static void setRSA(){
    Signature sign = null;
    KeyPairGenerator keyPairGen = null;
    KeyPair pair = null;

    try {//Creating KeyPair generator object and Generating the pair of keys
      sign = Signature.getInstance("SHA256withRSA");
      keyPairGen = KeyPairGenerator.getInstance("RSA");
      pair = keyPairGen.generateKeyPair();
    }
    catch(NoSuchAlgorithmException ex) {
      System.out.println(ex.getMessage());
    }
    //Initializing the key pair generator
    keyPairGen.initialize(2048);

    PDFKey.Pair = pair;
  }
  public KeyPair getRSA(){
    return PDFKey.Pair;
  }
}
