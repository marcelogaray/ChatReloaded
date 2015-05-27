/*
 * MSGestorConexiones.java
 *
 * Created on 1 de noviembre de 2007, 23:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ModelSet;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class ConexionModelGestor {
    
    private static ConexionModelGestor singleton=new ConexionModelGestor();
    public  static ConexionModelGestor getInstance(){
        return singleton;
    }
    
    private ArrayList<ConexionModel> conexiones = new ArrayList<ConexionModel>();
    
    public void enviarTrama(int nCodigo, String sTrama){
        for (ConexionModel ms:conexiones){
            ms.enviarTrama(nCodigo, sTrama);
        }
    }
    
    public void conectaNuevo(ConexionModel nuevo){
        for (ConexionModel ms:conexiones){
            nuevo.enviarTrama(1, ms.getNick());
        }
        conexiones.add(nuevo);
    }
    
    public void desconecta(ConexionModel eliminar){
        int nPos=-1;
        for (int n=0;n<conexiones.size();n++){
            if (conexiones.get(n)==eliminar){
                nPos=n;
            }
        }
        if (nPos!=-1){
            for (int n=0;n<conexiones.size();n++){
                if (n!=nPos){
                    conexiones.get(n).enviarTrama(3, ""+nPos);
                }
            }
            conexiones.remove(nPos);
        }
    }    
    
}
