import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRequestHandler {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        handler();
    }

    private static void handler() throws IOException, ClassNotFoundException {
        ServerSocket welcomeSocket = new ServerSocket(1313);

        while(true) {
            Socket connectionSocket = welcomeSocket.accept();

            ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
            ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());

            String rcv = (String) inFromClient.readObject();
            String result = new Invoker().processRequest(rcv);
            outToClient.writeObject(result);
            outToClient.flush();
        }
    }
}
