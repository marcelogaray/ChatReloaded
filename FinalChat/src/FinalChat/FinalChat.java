/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalChat;
import UIChat.UIPrincipal;
import Handlers.PrinHandler;

/**
 *
 * @author mfernandez
 */
public class FinalChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UIPrincipal uiPrin=new UIPrincipal();
        uiPrin.setVisible(true);
        new PrinHandler(uiPrin);
                
        
    }
    
}
