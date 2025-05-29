import java.net.ServerSocket;

public class ServerListening implements Runnable{
    ServerSocket serverSocket;
    int port;
    Thread thread;

    public ServerListening(int port)
    {
        thread=new Thread(this);
        this.port = port;
        thread.start();
    }

    @Override
    public void run(){try{


        serverSocket = new ServerSocket(port);

        while (true)
            Connet.Connets.add(new Connet(serverSocket.accept()));


    }catch (Exception e) {e.printStackTrace();}}}
