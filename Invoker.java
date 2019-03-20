public class Invoker {
    private Marshaller marshaller = new Marshaller();

    String processRequest(String object){
        ICalculator remoteObject = new RemoteObject();
        Message message = marshaller.unmarshall(object);

        int op = message.op;
        float p1 = message.p1;
        float p2 = message.p2;
        float result;
        int messageType = 1;

        if (op == 0) {
            result = remoteObject.sum(p1, p2);
        } else if (op == 1) {
            result = remoteObject.sub(p1, p2);
        } else if (op == 2) {
            result = remoteObject.mul(p1, p2);
        } else {
            result = remoteObject.div(p1, p2);
        }

        return marshaller.marshall(messageType, result);
    }
}
