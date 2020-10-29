/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001proyectohilos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author FP Mañana A
 */
class AccesoFichero {
private static String ruta="C:\\proyectosjava\\008BuscadorContactos\\contactos.csv";
    static ArrayList<Contacto> sacarContactos(String n_buscado) {
        ArrayList<Contacto> lista=new ArrayList<>();
        FileReader fr=null;
		try {
			fr=new FileReader(ruta);
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();
			while(linea!=null)
			{
				String[] datos=linea.split(",");
                                String nombre=datos[0];
				Contacto c=new Contacto(nombre, datos[1], Integer.parseInt(datos[2]));
				if(nombre.toUpperCase().contains(n_buscado.toUpperCase()))
                                {
                                   lista.add(c); 
                                }
                                
				linea=br.readLine();
				
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return lista; 
    }
    
}
