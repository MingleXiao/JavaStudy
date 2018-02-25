package xiaomin.biodemo;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class SocketClient {
    public static void main(String[] args) {
        String msg="Client Data \n  Client";
        try{
            Socket socket=new Socket("127.0.0.1",8080);
            PrintWriter pw=new PrintWriter(socket.getOutputStream());
            pw.println(msg);
            pw.flush();
            pw.close();
            socket.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
