/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;
import ModelSet.ClienteModel;
import UIChat.UICliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;                                       
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author mfernandez
 */
public class ClientHandler implements ActionListener{
    ClienteModel cliModel=null;
    UICliente uiClient=null;
    DefaultListModel dlm=new DefaultListModel();
    public ClientHandler(UICliente uiCli, ClienteModel cliModel){
        uiClient=uiCli;
        this.cliModel=cliModel;
        actionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()==uiClient.jButton1){
                uiClient.jList1.setModel(dlm);
                int port = Integer.parseInt(uiClient.jTextField1.getText());
                 String url = uiClient.jTextField2.getText();
                 String nick = uiClient.jTextField4.getText();
                 if (cliModel==null){
                     cliModel = new ClienteModel(port,url,nick,uiClient);
                     cliModel.start();
                 }
                 uiClient.jButton1.setEnabled(false);
                 uiClient.jButton2.setEnabled(true);
               }
         if(ae.getSource()==uiClient.jButton2){
                if (cliModel!=null){
                cliModel.enviarTrama(3, "");
                cliModel.interrupt();
            }
            cliModel = null;
            uiClient.jButton1.setEnabled(true);
            uiClient.jButton2.setEnabled(false);
            dlm.removeAllElements();
            uiClient.jTextArea1.setText("");
        } 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       private void jTextField3KeyPressed(KeyEvent evt) {                                       

        if (evt.getKeyCode()==10){
            cliModel.enviarMensaje(uiClient.jTextField3.getText());
            uiClient.jTextField3.setText("");
        }
    }     
   public void keyPressed(KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
   public void mensajeRecibido(String sMensaje){
        uiClient.jTextArea1.append(sMensaje + "\n");
    }
    
    public void nuevaPersona(String nick){
        dlm.addElement(nick);
    }
    
    public void borrarPersona(int nPos){
        dlm.remove(nPos);
    }
    private void actionListener(ClientHandler aThis) {
        uiClient.jButton1.addActionListener(aThis);
        uiClient.jButton2.addActionListener(aThis);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void keyListener(KeyAdapter aThis) {
        uiClient.jTextField3.addKeyListener(aThis);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
