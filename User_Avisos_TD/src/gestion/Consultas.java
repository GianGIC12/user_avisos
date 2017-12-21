/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

import beans.AvisoBean;
import beans.UsuarioBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        
        
        sql="SELECT id,idUser FROM db_todobusco_prod.mod_usuario_perfil  where created_at>'2017-09-01'"
                + " limit 4000";
        
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
            
            sql="select id,idCategoria,tituloAviso,idPais,fchPublicacion,estado,destaque from db_todobusco_prod.mod_aviso_aviso\n" 
                    +"\n" 
                    +"where idPerfil=" + usuarios[i].getId_perfil();
            
           
            
             PreparedStatement stm = objCon.getCon().prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            
            List<AvisoBean> avisos= new ArrayList<AvisoBean>();
            
            while (rs.next()) {
                
                AvisoBean aviso= new AvisoBean();
                
                int id_aviso= rs.getInt("id");
                int idCategoria= rs.getInt("idCategoria");
                String titulo_aviso= rs.getString("tituloAviso");
                int idPais=rs.getInt("idPais");
                
                String fecha_publicacion="";
                
                if (rs.getString("fchPublicacion")==null) {
                    
                    fecha_publicacion="";
                    
                }else {
                 
                    fecha_publicacion= rs.getString("fchPublicacion").substring(0,10);
                   
                }
                
                
                
                
                
                String estado=rs.getString("estado");
                int idDestaque=rs.getInt("destaque");
                
                String portal="";
                String categoria="";
                String pais="";
                String destaque="";
                
                if (idCategoria==1) {
                    
                    portal="Casa Busco";
                    categoria="Casas";
                    
                }else if (idCategoria==2) {
                    
                    portal="Carro Busco";
                    categoria="Carros";
                    
                }else{
                    
                    portal= "Venta Busco";
                    
                    categoria="Ventas";
                }
                
                if (idPais==1) {
                    
                    pais="Nicaragua";
                    
                }else if (idPais==38) {
                    
                    pais="Costa Rica";
                    
                }else{
                    
                    pais="Nuevo";
                    
                }
              
                if (estado.equalsIgnoreCase("0")) {
                    estado="Despublicado";
                }else if (estado.equalsIgnoreCase("1")) {
                    estado="Publicado";
                }else if (estado.equalsIgnoreCase("2")) {
                    estado="Caducado";
                }else if (estado.equalsIgnoreCase("3")) {
                    estado="Eliminado";
                }else if (estado.equalsIgnoreCase("4")) {
                    estado="Pendiente De Pago";
                }else if (estado.equalsIgnoreCase("5")) {
                    estado="Moderado";
                }else if (estado.equalsIgnoreCase("6")) {
                    estado="De Baja";
                }else if (estado.equalsIgnoreCase("7")) {
                    estado="Vendido";
                }else if (estado.equalsIgnoreCase("8")) {
                    estado="Pendiente de Edicion";
                }else if (estado.equalsIgnoreCase("9")) {
                    estado="Eliminacion Total";
                }
                
                
                if (idDestaque==1) {
                    destaque="Aviso Simple";
                }else if (idDestaque==2) {
                    destaque="Destaque Plata";
                }else if (idDestaque==3) {
                    destaque="Destaque Oro";
                }else if (idDestaque==6) {
                    destaque="Destaque Membresia";
                }
                
                aviso.setId_aviso(id_aviso);
                aviso.setPortal(portal);
                aviso.setCategoria(categoria);
                aviso.setTitulo_aviso(titulo_aviso);
                aviso.setPais_aviso(pais);
                aviso.setFecha_publicacion(fecha_publicacion);
                aviso.setEstado(estado);
                aviso.setDestaque(destaque);
                
                
                avisos.add(aviso);
                
                contAvisos++;
            }
            
            usuarios[i].setAvisos(avisos);
            usuarios[i].setContadorAvisos(contAvisos);
            
            
            System.out.println(usuarios[i].getId_usuario()+"******"+usuarios[i].getId_perfil()+"*****"+usuarios[i].getContadorAvisos());
            
            
       }
        
        
        objCon.desconectar();
       
       
       
       
   }
   
    
   
   public void recorrerAvisos(){
       
       
       for (int i = 0; i < contUsuarios; i++) {
          
           
           int contador= usuarios[i].getContadorAvisos();
           
           System.out.println(""+contador);
           
           if (contador==0) {
               
               System.out.println("El id= "+usuarios[i].getId_usuario()+"No tiene avisos "+usuarios[i].getId_perfil());
               
           }else{
               System.out.println("entro");
               
               for (AvisoBean aviso: usuarios[i].getAvisos() ) {
                   
                   System.out.println("***"+aviso.getId_aviso()+"****"+aviso.getFecha_publicacion()
                   +"********"+aviso.getPais_aviso()+"****" +aviso.getDestaque());
                   
               }
               
               
               
               
           }
           
           
           
           
           
       }
       
       
       
       
       
   }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public UsuarioBean[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UsuarioBean[] usuarios) {
        this.usuarios = usuarios;
    }

    public int getContUsuarios() {
        return contUsuarios;
    }

    public void setContUsuarios(int contUsuarios) {
        this.contUsuarios = contUsuarios;
    }
   
   
   
   
    
}
