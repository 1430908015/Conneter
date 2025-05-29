import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security .*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.nio.charset.StandardCharsets;


public class RSA4096 {

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(4096);
        return keyPairGenerator.generateKeyPair();
    }

    public static String encrypt(String plainText, PublicKey publicKey) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, PrivateKey privateKey) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static String publicKeyToBase64(PublicKey publicKey) {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    public static String privateKeyToBase64(PrivateKey privateKey) {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    public static String ByteToHex(byte[] byteArray) {
        int len = byteArray.length;
        // storing the hexadecimal values
        char[] hexValues = "0123456789ABCDEF".toCharArray();
        char[] hexCharacter = new char[len * 2];
        // using  byte operation converting byte
        // array to hexadecimal value
        for (int i = 0; i < len; i++) {
            int v = byteArray[i] & 0xFF;
            hexCharacter[i * 2] = hexValues[v >>> 4];
            hexCharacter[i * 2 + 1] = hexValues[v & 0x0F];
        }
        return new String(hexCharacter);
    }



    public static PublicKey getPublicKeyFromBase64(String base64PublicKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 1. Base64解码
        byte[] encodedPublicKey = Base64.getDecoder().decode(base64PublicKey);
            // 2. 创建X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encodedPublicKey);
            // 3. 根据算法获取KeyFactory（例如RSA、EC、DSA）
        KeyFactory keyFactory = KeyFactory.getInstance("RSA"); // 替换为实际算法
            // 4. 生成PublicKey
        return keyFactory.generatePublic(keySpec);

    }

    public static PublicKey getPublicKeyFromEncoded(byte[] byteArray) throws NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(byteArray);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA"); // 替换为实际算法
        return keyFactory.generatePublic(keySpec);
    }

}
