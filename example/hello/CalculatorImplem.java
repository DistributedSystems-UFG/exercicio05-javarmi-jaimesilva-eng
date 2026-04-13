package example.hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImplem extends UnicastRemoteObject implements Calculator {

    public CalculatorImplem(int port) throws RemoteException {
        super(port);
    }

    public int multiplica(int a, int b) throws RemoteException {
        return a * b;
    }

    public double divide(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Divisão por zero não permitida.");
        }
        return a / b;
    }
}
