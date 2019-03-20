import java.io.IOException;

public class Requestor {
    ClientRequestHandler client = new ClientRequestHandler();
    Marshaller marshaller = new Marshaller();

    public void makeRequest(int op, float p1, float p2){
        int messageType = 0; //request
        String object = marshaller.marshall(messageType, op, p1, p2);
        try {
            client.handler(object);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
