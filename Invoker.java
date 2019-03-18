public class Invoker {
    Float readRequest(String object){
        RemoteObject remoteObject = new RemoteObject();

        String[] request = object.split("\\|");
        int op = Integer.parseInt(request[1]);
        float p1 = Float.parseFloat(request[2]);
        float p2 = Float.parseFloat(request[3]);

        switch (op){
            case 0: return remoteObject.sum(p1, p2);
            case 1: return remoteObject.sub(p1, p2);
            case 2: return remoteObject.mul(p1, p2);
            default: return remoteObject.div(p1, p2);
        }
    }
}
