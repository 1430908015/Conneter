import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class main {
    public static final int CMD_PORT = 21500;
    public static Scanner input = new Scanner(System.in);;
    public static Boolean FINAL_SERVER = false;
    public static KeyPair RSA;
    public static List<ServerListening> serverListenings= new ArrayList<>();


    public static void main(String[] args){try{
        RSA = RSA4096.generateKeyPair();

        Socket socket = new Socket();
        try {socket.connect(new InetSocketAddress("heidong.space", 21500), 1000);} catch (IOException e) {
            FINAL_SERVER = true;
            System.out.println("服务器已开启");
        }


        System.out.println(Arrays.toString(RSA.getPublic().getEncoded()));
        System.out.println(RSA4096.ByteToHex(RSA.getPublic().getEncoded()));
        System.out.println(RSA4096.publicKeyToBase64(RSA.getPublic()));
        System.out.println(RSA.getPublic().getEncoded().length);
        System.out.println(RSA.getPublic().getEncoded().length*256);
        for (int o = 0;o<=9;o++)
            serverListenings.add(new ServerListening(CMD_PORT+o));


    } catch (Exception e) {e.printStackTrace();}}
}
