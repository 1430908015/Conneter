import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class main {
    public static final int CMD_PORT = 19960;
    public static KeyPair RSA;
    public static List<ServerListening> serverListenings= new ArrayList<>();


    public static void main(String[] args){try{

        RSA = RSA4096.generateKeyPair();

        for (int o = 0;o<=9;o++)
            serverListenings.add(new ServerListening(CMD_PORT+o));


    } catch (Exception e) {e.printStackTrace();}}
}
