/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsocketcliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XZeroMarx
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {

        try {
            /*Random r = new Random();
            int port = r.nextInt(5000);*/
            
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server corriendo en puerto "+5000);
            Socket cliente = server.accept();

            ObjectInputStream input = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(cliente.getOutputStream());
            DataInputStream inStream = new DataInputStream(cliente.getInputStream());
            DataOutputStream outStream = new DataOutputStream(cliente.getOutputStream());
            BufferedReader inString = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            System.out.println("vida");
            cliente.getInputStream();
            System.out.println("muerte");
            if(inString.equals("Hola")){
                output.writeObject("Wena qlo desde el server");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
