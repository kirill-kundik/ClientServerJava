package Lab1.Calc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream inputStream;

    public void communicate() {

        try {

            serverSocket = new ServerSocket(6666);
            System.out.println("Server created. Waiting for the client...");
            socket = serverSocket.accept();
            System.out.println("Client connected.");

            inputStream = new ObjectInputStream(socket.getInputStream());
            Calculator calculator = (Calculator) inputStream.readObject();
            System.out.println("Calculator received... Result: " + calculator.calc());

            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Server server = new Server();
        server.communicate();
    }

}
