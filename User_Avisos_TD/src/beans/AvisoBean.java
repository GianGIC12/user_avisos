/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author user
 */
public class AvisoBean {
    
    int id_aviso;
    String portal, categoria,titulo_aviso,pais_aviso,fecha_publicacion,estado;

    public AvisoBean() {
    }

    public int getId_aviso() {
        return id_aviso;
    }

    public void setId_aviso(int id_aviso) {
        this.id_aviso = id_aviso;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo_aviso() {
        return titulo_aviso;
    }

    public void setTitulo_aviso(String titulo_aviso) {
        this.titulo_aviso = titulo_aviso;
    }

    public String getPais_aviso() {
        return pais_aviso;
    }

    public void setPais_aviso(String pais_aviso) {
        this.pais_aviso = pais_aviso;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
