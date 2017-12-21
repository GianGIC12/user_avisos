/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class UsuarioBean {
    
    int id_usuario,id_perfil;
    String pais,ultima_visita,nombre,dni,genero,email,celular,fecha_registro;
    List<AvisoBean> avisos;
    
    int contadorAvisos;

    public UsuarioBean() {
        
        avisos= new ArrayList<AvisoBean>();
        
        pais="";
        ultima_visita="";
        nombre="";
        dni="";
        genero="";
        email="";
        celular="";
        fecha_registro="";
        contadorAvisos=0;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUltima_visita() {
        return ultima_visita;
    }

    public void setUltima_visita(String ultima_visita) {
        this.ultima_visita = ultima_visita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public List<AvisoBean> getAvisos() {
        return avisos;
    }

    public void setAvisos(List<AvisoBean> avisos) {
        this.avisos = avisos;
    }

    public int getContadorAvisos() {
        return contadorAvisos;
    }

    public void setContadorAvisos(int contadorAvisos) {
        this.contadorAvisos = contadorAvisos;
    }
    

    
    
}
