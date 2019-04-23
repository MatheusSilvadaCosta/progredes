package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Cliente. Responsável por acessar um objeto remotamente por meio de um ip e um
 * nome.
 *
 * @param <T> Tipo do objeto a ser acessado.
 * @author Tiago Henrique de Melo.
 * https://github.com/tiagohm/rmi-java/blob/master/src/main/java/br/tiagohm/rmi/Client.java
 */
public class Cliente<T extends Remote> {

    private static final int PORT = 1098;
    private final T remote;

    /**
     * Cria uma instância da classe Client.
     *
     * @param ip Endereço IP do local onde se quer acessar o objeto.
     * @param name Nome do objeto a ser acessado.
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException
     * @throws java.net.MalformedURLException
     */
    public Cliente(String ip, String name) throws RemoteException, NotBoundException, MalformedURLException {
        
        //Acessa um objeto remotamente através do ip do local onde está o objeto e seu nome.
        remote = (T) Naming.lookup("rmi://" + ip + ":" + PORT + "/" + name);
    }

    /**
     * Obtém o objeto remoto.
     *
     * @return
     */
    public T getRemoteObj() {
        return remote;
    }
}
