/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import java.awt.event.ActionListener;
import UIChat.UIPrincipal;
import java.awt.event.ActionEvent;
import UIChat.UICliente;

/**
     *
 * @author mfernandez
 */
public final class PrincipalHandler implements ActionListener{
    UIPrincipal uiPrincipal=null;
    public PrincipalHandler (UIPrincipal uiPrin){
        uiPrincipal=uiPrin;
        actionListener(this);
    }

   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==uiPrincipal.jButton2){
            (new UICliente()).setVisible(true);
        }
        if (ae.getSource()==uiPrincipal.jButton2){
            //(new UIServer()).setVisible(true);   
        }
    }
   
        public void actionListener(ActionListener e){
            uiPrincipal.jButton1.addActionListener(e);
            uiPrincipal.jButton2.addActionListener(e);
            
        }

}
