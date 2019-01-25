# Encryption

For the encryption and decryption library of docChain in java

Required: 
Secret Key (32bytes)
File(anysize)
Output directories for encrypted and decrypted files

SecretKey is encrpyted with generated RSA keypair in PDFKey

SecretKey is then decrypted and used in the encryption or decryption of the File.

Send the encrpyted Secret and File to user with the private key to let them decrpyt it.