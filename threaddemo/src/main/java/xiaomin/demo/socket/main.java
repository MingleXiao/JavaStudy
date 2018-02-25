package xiaomin.demo.socket;

import java.io.IOException;
import java.net.ServerSocket;

public class main {
    public static void main(String[] args) throws IOException {
        int port=8080;
        ServerSocket serverSocket=new ServerSocket(port);
        while (true){
            serverSocket.accept();
        }
    }
}
