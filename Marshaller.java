public class Marshaller {
    String marshall(int messageType, int op, float p1, float p2){
        return new Message(messageType, op, p1, p2).toString();
    }

    String marshall(int messageType, float result){
        return new Message(messageType, result).toString();
    }

    Message unmarshall(String object){
        String[] request = object.split("\\|");
        int messageType = Integer.parseInt(request[0]);
        if (messageType == 0){
            return new Message(messageType, Integer.parseInt(request[1]), Float.parseFloat(request[2]), Float.parseFloat(request[3]));
        } else {
            return new Message(messageType, Float.parseFloat(request[1]));
        }
    }
}
