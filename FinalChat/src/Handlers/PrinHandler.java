/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import UIChat.UIPrincipal;
import UIChat.UICliente;
import UIChat.UIServer;
/**
 *
 * @author mfernandez
 */
public class PrinHandler implements ActionListener{
    UIPrincipal uiPrincipal=null; 
    UICliente uiCli=new UICliente();
    public PrinHandler(UIPrincipal uiPrin){
        uiPrincipal=uiPrin;
        actionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==uiPrincipal.jButton2){
            uiCli.setVisible(true);
        }
        if (ae.getSource()==uiPrincipal.jButton1){
            (new UIServer()).setVisible(true);   
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void actionListener(PrinHandler aThis) {
        uiPrincipal.jButton2.addActionListener(aThis);
        uiPrincipal.jButton1.addActionListener(aThis);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
