import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Connet implements Runnable {
    public static final int NAME_LEN = 32;
    public static String Name = "你好啊哈哈哈";

    public static List<Connet> Connets = new ArrayList<>();

    public Socket socket;
    public Thread thread;
    public BufferedInputStream in;
    public BufferedOutputStream out;
    public PublicKey publicKey;

    public Connet(Socket socket) {
        this.socket = socket;
        thread = new Thread(this);
        thread.start();
    }



    public void sent(String output)
    {

    }


    @Override
    public void run() {
        try {

            in = new BufferedInputStream(socket.getInputStream());
            out = new BufferedOutputStream(socket.getOutputStream());
            out.write(main.RSA.getPublic().getEncoded());
            publicKey = RSA4096.getPublicKeyFromEncoded(in.readNBytes(550));
            while (true) {
                if (!thread.isAlive())
                    break;



            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}