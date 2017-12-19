/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

import beans.UsuarioBean;
import conexion.Conexion;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Consultas {
    
    String sql;
    
    UsuarioBean[] usuarios;
    int contUsuarios;

    public Consultas() {
        
        usuarios= new UsuarioBean[40000];
        contUsuarios=0;
        
    }
    
    
    public void completarUsuarios() throws SQLException{
        
        
         Conexion objCon = new Conexion();

        objCon.conectar();
        
        
        sql="";
        
        
        
        
        
        
        
    }
    
    
    
    
    

    
    
}
