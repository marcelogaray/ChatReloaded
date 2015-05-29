/*
 * MCliente.java
 *
 * Created on 1 de noviembre de 2007, 22:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package ModelSet;
import UIChat.UICliente;
import UIChat.UICliente;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import Handlers.ClientHandler;


/**
 *
 * @author Administrador
 */
public class ClienteModel extends Thread{

    public int port;
    public String url;
    public Socket s;
    public boolean bConectado;
    public UICliente ventana;
    private String nick;
    public ClientHandler cliCon;
    /** Creates a new instance of MCliente */
    public ClienteModel(int port, String url, String nick, UICliente ventana) {
        this.port=port;
        this.url=url;
        this.ventana=ventana;
        this.nick=nick;
    }

    ClienteModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void run(){
        try{
            s=new Socket(url, port);
            DataInputStream dis=new DataInputStream(s.getInputStream());
            enviarTrama(1, nick);
            bConectado=true;
            while(bConectado){
                int nCodigo =dis.readInt();
                String sTrama=dis.readUTF();
                switch(nCodigo){
                    case 1:                        
                        cliCon.nuevaPersona(sTrama);
                        break;
                    case 2:
                        cliCon.mensajeRecibido(sTrama);
                        break;
                    case 3:
                        try{
                            int nPos = Integer.parseInt(sTrama);
                            cliCon.borrarPersona(nPos);
                        }catch(Exception e2){
                        }
                        break;
                }
            }
            //JOptionPane.showMessageDialog(ventana, "Se ha podido conectar");
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "No se pudo establecer la conexión");
        }
    }
    
    public void enviarMensaje(String sMensaje){
        enviarTrama(2, sMensaje);
    }
    
    public void enviarTrama(int nCodigo, String sTrama){
        try{
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            dos.writeInt(nCodigo);
            dos.writeUTF(sTrama);
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "No se pudo enviar el mensaje");
        }
        
    }

}
