public class Message {
    int messageType;
    int op;
    float p1;
    float p2;
    float result;

    Message(int messageType, int op, float p1, float p2){
        this.messageType = messageType;
        this.op = op;
        this.p1 = p1;
        this.p2 = p2;
    }

    Message(int messageType, float result){
        this.messageType = messageType;
        this.result = result;
    }

    public String toString(){
        if (messageType == 0){
            return messageType + "|" + op + "|" + p1 + "|" + p2;
        } else {
            return messageType + "|" + result;
        }
    }
}
