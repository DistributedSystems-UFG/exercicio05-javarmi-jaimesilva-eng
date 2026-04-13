package example.hello;

import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class NewServer {

    public NewServer() {}

    public static void main(String[] args) {
        try {
            try {
                LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
                System.out.println("RMI registry criado na porta 1099.");
            } catch (Exception e) {
                System.out.println("RMI registry já existe na porta 1099.");
            }

            CalculatorImplem obj = new CalculatorImplem(5679);
            Naming.rebind("MyCalculator", obj);

            System.out.println("Calculator Server ready");
        } catch (Exception e) {
            System.err.println("CalculatorServer exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
