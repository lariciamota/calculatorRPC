import java.io.*;
import java.net.Socket;

public class ClientRequestHandler {
    void handler(String object) throws IOException, ClassNotFoundException {
        Socket clientSocket = new Socket("localhost", 1313);
        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream()); //input from connection

        outToServer.writeObject(object);
        outToServer.flush();
        float result = new Marshaller().unmarshall(in.readObject().toString()).result;
        System.out.println(">>> " + result);
    }
}
