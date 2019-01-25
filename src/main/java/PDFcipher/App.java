package PDFcipher;

public class App {
    public String getGreeting() {
        return "Getting Started.";
    }
    public String getEnding() {
        return "Encryption Finished.";
    }
    public static void main(String[] args) {
        System.out.println("Begin");

        //input file
        String inputDirectory = "/Users/admin/Desktop/RandomNumbers.txt"; //inputforthekey
        String outputCipherDirectory = "/Users/admin/Desktop/cipherdone.txt";//encryptedAESkey
        String outputDecipherDirectory = "/Users/admin/Desktop/decipherdone.txt";//decryptedAESkey

        PDFKey keyPairs = new PDFKey();//make RSA keys to encrypt AESkey
        keyPairs.setRSA();

        EncryptKey encryptAESkey = new EncryptKey();
        DecryptKey decryptAESkey = new DecryptKey();
        System.out.println(new App().getGreeting());

        encryptAESkey.startEncrypt(inputDirectory, outputCipherDirectory, keyPairs);//encryptedAESkey created using RSAkey
        decryptAESkey.startDecrypt(outputCipherDirectory, outputDecipherDirectory, keyPairs);//decryptedAESkey created using RSAkey

        System.out.println("Key encryption/decryption finished");

        AESEncrypt encryptFile = new AESEncrypt();
        AESDecrypt decryptFile = new AESDecrypt();

        String PDFfileDirectory = "/Users/admin/Desktop/test.pdf";//file to encrypt
        String encryptedDirectory = "/Users/admin/Desktop/encryptAES.txt";//file to decrypt
        String decryptedDirectory = "/Users/admin/Desktop/decryptAES.txt";//file should match PDFfileDirectory

        encryptFile.startEncrypt(PDFfileDirectory, encryptedDirectory, outputDecipherDirectory);//encryptAES file created
        decryptFile.startDecrypt(encryptedDirectory, decryptedDirectory, outputDecipherDirectory);//decryptAES file created

        System.out.println(new App().getEnding());
    }
}
