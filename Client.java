import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String op;
        Float p1;
        Float p2;

        while (true){
            System.out.println("Digite a operação: ");
            op = stdIn.readLine();

            System.out.println("Primeiro operando: ");
            String rcv = stdIn.readLine();
            if (!isNumber(rcv)){
                continue;
            }
            p1 = Float.parseFloat(rcv);

            System.out.println("Segundo operando: ");
            rcv = stdIn.readLine();
            if (!isNumber(rcv)){
                continue;
            }
            p2 = Float.parseFloat(rcv);

            calculates(op, p1, p2);
        }
    }

    private static void calculates(String opName, float p1, float p2){
        ICalculator calculator = new ClientProxy();
        opName = opName.toLowerCase();
        if (opName.equals("sub")){
            calculator.sub(p1, p2);
        } else if (opName.equals("sum")){
            calculator.sum(p1, p2);
        } else if (opName.equals("mul")){
            calculator.mul(p1, p2);
        } else if (opName.equals("div")){
            calculator.div(p1, p2);
        } else {
            System.out.println("Operacao nao encontrada!");
        }
    }

    private static boolean isNumber(String s){
        try{
            Float.parseFloat(s);
        } catch (NumberFormatException nf){
            System.out.println("Not a number");
            return false;
        }
        return true;
    }
}
