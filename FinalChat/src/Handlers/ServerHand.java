/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;
import java.awt.event.ActionListener;
import ModelSet.ServerModel;
import UIChat.UIServer;
import java.awt.event.ActionEvent;
/**
 *
 * @author marcelofernandez
 */
public class ServerHand implements ActionListener{
    UIServer uiServ=null;
    ServerModel serMod=null;
    public ServerHand (UIServer uiSer){
        uiServ=uiSer;
        actionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==uiServ.jButton1)   {
         if (serMod==null){
            int port = Integer.parseInt(uiServ.jTextField1.getText());
            serMod = new ServerModel(uiServ, port);
            serMod.start();
        }
     }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void actionListener(ServerHand aThis) {
        uiServ.jButton1.addActionListener(aThis);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
