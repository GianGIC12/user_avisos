/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import beans.AvisoBean;
import beans.UsuarioBean;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author user
 */
public class ExportarCSV {

    public ExportarCSV() {
    }
    
    
    
    public void exportarResultados(UsuarioBean[] usuarios, int contUsuarios) throws IOException{
        
        
         String outputFile = "C:/Users/user/Google Drive/Reporting_TB/usuarios_publicaciones.csv";
        
           boolean alreadyExists = new File(outputFile).exists();
         
           
           if (alreadyExists) {
            File bd_usuarios_publicaciones = new File(outputFile);
            bd_usuarios_publicaciones.delete();
        }
           
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');
           
           
            csvOutput.write("id_usuario");
        csvOutput.write("id_perfil");
        csvOutput.write("pais_registro");
        csvOutput.write("ultima_visita");
        csvOutput.write("nombre");
        csvOutput.write("dni");
        csvOutput.write("genero");
        csvOutput.write("email");
        csvOutput.write("celular");
        csvOutput.write("Fecha_registro");
        csvOutput.write("id_aviso");
        csvOutput.write("portal");
        csvOutput.write("categoria");
        csvOutput.write("titulo_aviso");
        csvOutput.write("pais_aviso");
        csvOutput.write("fecha_publicacion");
        csvOutput.write("estado");
        csvOutput.write("destaque");
        
        
        
        csvOutput.endRecord();
            
            
           for (int i = 0; i < contUsuarios; i++) {
            
               int contadorAvisos= usuarios[i].getContadorAvisos();
               
               if (contadorAvisos==0) {
                   
        csvOutput.write(usuarios[i].getId_usuario()+"");
        csvOutput.write(usuarios[i].getId_perfil()+"");
        csvOutput.write(usuarios[i].getPais());
        csvOutput.write(usuarios[i].getUltima_visita());
        csvOutput.write(usuarios[i].getNombre());
        csvOutput.write(usuarios[i].getDni());
        csvOutput.write(usuarios[i].getGenero());
        csvOutput.write(usuarios[i].getEmail());
        csvOutput.write(usuarios[i].getCelular());
        csvOutput.write(usuarios[i].getFecha_registro());
        csvOutput.write("0000");
        csvOutput.write("No Definido");
        csvOutput.write("No Definido");
        csvOutput.write("No Definido");
        csvOutput.write("No definido");
        csvOutput.write("No Definido");
        csvOutput.write("No Definido");
        csvOutput.write("No Definido");
        
        
        csvOutput.endRecord();
                   
                   
                   
               }else {
                   
                   
                   
                   for (AvisoBean aviso: usuarios[i].getAvisos() ) {
                       
            csvOutput.write(usuarios[i].getId_usuario()+"");
        csvOutput.write(usuarios[i].getId_perfil()+"");
        csvOutput.write(usuarios[i].getPais());
        csvOutput.write(usuarios[i].getUltima_visita());
        csvOutput.write(usuarios[i].getNombre());
        csvOutput.write(usuarios[i].getDni());
        csvOutput.write(usuarios[i].getGenero());
        csvOutput.write(usuarios[i].getEmail());
        csvOutput.write(usuarios[i].getCelular());
        csvOutput.write(usuarios[i].getFecha_registro());
        csvOutput.write(aviso.getId_aviso()+"");
        csvOutput.write(aviso.getPortal());
        csvOutput.write(aviso.getCategoria());
        csvOutput.write(aviso.getTitulo_aviso());
        csvOutput.write(aviso.getPais_aviso());
        csvOutput.write(aviso.getFecha_publicacion());
        csvOutput.write(aviso.getEstado());
        csvOutput.write(aviso.getDestaque());
        
        
        
        csvOutput.endRecord();
                       
                       
                       
                   }
                   
                   
                   
                   
               }
               
               
               
               
               
        }
 
            
            
           
         csvOutput.close();  
        
        
    }
    
    
    
}
