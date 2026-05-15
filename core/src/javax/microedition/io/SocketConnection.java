/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.microedition.io;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class SocketConnection {

    public Socket socket;

    SocketConnection(String host, int port) throws IOException {
        socket = new Socket(host,port);
    }
    public DataOutputStream openDataOutputStream() throws IOException {
        return new DataOutputStream(socket.getOutputStream());
    }

    public DataInputStream openDataInputStream() throws IOException {
        return new DataInputStream(socket.getInputStream());
    }

    public void close() {try {
        socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
