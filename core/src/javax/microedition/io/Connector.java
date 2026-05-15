/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.microedition.io;

import java.io.IOException;

/**
 *
 * @author admin
 */
public class Connector {

    public static SocketConnection open(String name) throws IOException {
        int portSepIndex = name.lastIndexOf(':');
        int port = Integer.parseInt(name.substring(portSepIndex + 1));
        String host = name.substring("socket://".length(), portSepIndex);
        
        return new SocketConnection(host,port);
    }

}
