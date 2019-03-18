public class ClientProxy implements ICalculator {
    Requestor requestor = new Requestor();

    @Override
    public float sum(float p1, float p2) {
        requestor.makeRequest(0, p1, p2);
        return 0;
    }

    @Override
    public float sub(float p1, float p2) {
        requestor.makeRequest(1, p1, p2);
        return 0;
    }

    @Override
    public float mul(float p1, float p2) {
        requestor.makeRequest(2, p1, p2);
        return 0;
    }

    @Override
    public float div(float p1, float p2) {
        requestor.makeRequest(3, p1, p2);
        return 0;
    }
}
