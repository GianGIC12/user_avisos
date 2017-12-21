/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

import beans.UsuarioBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    
    public void completarIds() throws SQLException{
        
        
         Conexion objCon = new Conexion();

        objCon.conectar();
        
        
        sql="SELECT id,idUser FROM db_todobusco_prod.mod_usuario_perfil"
                + " limit 100";
        
        System.out.println(sql);
        
          PreparedStatement stm = objCon.getCon().prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        
          while (rs.next()) {
              
               int idUser = rs.getInt("idUser");
               int idPerfil = rs.getInt("id");
              
               UsuarioBean user= new UsuarioBean();
                user.setId_usuario(idUser);
               user.setId_perfil(idPerfil);
               
               
               System.out.println(idUser+"******"+idPerfil);
               
               usuarios[contUsuarios]=user;
              
              contUsuarios++;
              
          }
        
        System.out.println(" Cantidad de Usuarios: "+contUsuarios);
          
       objCon.desconectar();   
          
        
    }
    
    
   public void completarDatosPersonales() throws SQLException{
       
         Conexion objCon = new Conexion();

        objCon.conectar();
      
       
       for (int i = 0; i < contUsuarios; i++) {
           
           sql="select id,id_country,last_visit_date,name,document_number,gender,email,celphone,created_at\n" +
" from db_todobusco_prod.mod_usuario_usuario where id= "+usuarios[i].getId_usuario();
           
            PreparedStatement stm = objCon.getCon().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
           
            
             while (rs.next()) {
                 
                int idPais=rs.getInt("id_country");
                String ultima_visita= rs.getString("last_visit_date").substring(0,10);
                String nombre= rs.getString("name");
                String dni= rs.getString("document_number");
                String genero= rs.getString("gender");
                String email= rs.getString("email");
                String celular= rs.getString("celphone");
                String fecha_registro= rs.getString("created_at").substring(0,10);
                
                String pais="Nuevo";
                
                 if (idPais==1) {
                     
                     pais="Nicaragua";
                     
                 }else if (idPais==38) {
                     
                     pais="Costa Rica";
                     
                 }
                
                 
                 usuarios[i].setPais(pais);
                 usuarios[i].setUltima_visita(ultima_visita);
                 usuarios[i].setNombre(nombre);
                 usuarios[i].setDni(dni);
                 usuarios[i].setGenero(genero);
                 usuarios[i].setEmail(email);
                 usuarios[i].setCelular(celular);
                 usuarios[i].setFecha_registro(fecha_registro);
                 
             }
            
           System.out.println(usuarios[i].getId_usuario()+"****"+usuarios[i].getId_perfil()+"******"+usuarios[i].getEmail());
           
       }
       
       
       
       objCon.desconectar();  
       
   } 
    
   
   public void completarAvisos() throws SQLException{
       
       
       Conexion objCon = new Conexion();

        objCon.conectar();
       
       
        for (int i = 0; i < contUsuarios; i++) {
           
            int contAvisos = 0;
            
            sql="select id,idCategoria,tituloAviso,idPais,fchPublicacion,estado from db_todobusco_prod.mod_aviso_aviso\n" 
                    +"\n" 
                    +"where idPerfil=" + usuarios[i].getId_perfil();
            
            System.out.println(sql);
            
            
       }
        
        
        objCon.desconectar();
       
       
       
       
   }
   
    
    
}
