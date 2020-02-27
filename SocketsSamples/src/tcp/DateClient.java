package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

import javax.swing.JOptionPane;

public class DateClient {

    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("localhost", 12345);
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            Date dataServidor = (Date) entrada.readObject();
            JOptionPane.showMessageDialog(null, "Data recebida do servidor: " + dataServidor.toString());
            System.out.println("Data recebida do servidor: " + dataServidor.toString());
            entrada.close();
            cliente.close();
            System.out.println("Conexão encerrada");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
