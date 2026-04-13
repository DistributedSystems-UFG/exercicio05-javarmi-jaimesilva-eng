package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    int multiplica(int a, int b) throws RemoteException;
    double divide(double a, double b) throws RemoteException;
}
