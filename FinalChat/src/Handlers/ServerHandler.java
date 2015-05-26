/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import java.awt.event.ActionListener;
import ModelSet.ServerModelo;
import UIChat.UIServer;
import java.awt.event.ActionEvent;

/**
 *
 * @author mfernandez
 */
public class ServerHandler implements ActionListener{
    ServerModelo serMod=null;
    UIServer uiServer=null;
    public ServerHandler(UIServer uiSer, ServerModelo serModel){
           uiServer=uiSer;
           this.serMod=serModel;
           actionListener(this);
       }

    @Override
    public void actionPerformed(ActionEvent ae) {
     if(ae.getSource()==uiServer.jButton1)   {
         if (serMod==null){
            int port = Integer.parseInt(uiServer.jTextField1.getText());
            serMod = new ServerModelo(uiServer, port);
            serMod.start();
        }
     }     
    }
    public void actionListener(ActionListener e){
        uiServer.jButton1.addActionListener(e);
    }
}
