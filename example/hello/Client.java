package example.hello;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        System.out.println("Initiating client");
        
        String host = (args.length < 1) ? null : args[0];
        try {
            //Registry registry = LocateRegistry.getRegistry(host);
            //System.out.println("Registry has been located");
            //Hello stub = (Hello) registry.lookup("Hello");

            Hello stub = (Hello) Naming.lookup("rmi://" + host + "/MyHello"); 
            System.out.println("Found server");
            String response = stub.sayHello();
            System.out.println("Response: " + response);

            int result = stub.soma(100,1000);
            System.out.println("Response from soma: " + result);

            int resultSubtrai = stub.subtrai(50, 20);
            System.out.println("Response from subtrai: " + resultSubtrai);

            String resultConcatena = stub.concatena("Olá, ", "mundo!");
            System.out.println("Response from concatena: " + resultConcatena);

            Calculator calcStub = (Calculator) Naming.lookup("rmi://" + host + "/MyCalculator");
            System.out.println("Found Calculator server");

            int resultMultiplica = calcStub.multiplica(8, 7);
            System.out.println("Response from multiplica: " + resultMultiplica);

            double resultDivide = calcStub.divide(20, 4);
            System.out.println("Response from divide: " + resultDivide);
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
