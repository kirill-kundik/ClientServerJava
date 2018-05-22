package Lab1.Calc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private boolean isConnected = false;

    public void communicate() {

        while (!isConnected) {
            try {
                System.out.println("Trying to connect to localhost...");
                socket = new Socket("localhost", 6666);
                System.out.println("Connected.");

                isConnected = true;
                outputStream = new ObjectOutputStream(socket.getOutputStream());

                Calculator calculator = new Calculator();

                System.out.println("Writing object... :" + calculator.calc());

                outputStream.writeObject(calculator);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.communicate();
    }

}
