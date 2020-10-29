/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001proyectohilos;

import java.util.ArrayList;
import javafx.concurrent.Task;
import javafx.scene.control.TextField;

/**
 *
 * @author FP Mañana A
 */
class MiTarea extends Task{

String tf_buscador;
ArrayList<Contacto> lista;
    public MiTarea(String tf_buscador) {
        this.tf_buscador = tf_buscador;
    }

    @Override
    protected ArrayList<Contacto> call() throws Exception {
       ArrayList<Contacto> lista=AccesoFichero.sacarContactos(tf_buscador);
        return lista;
    }
    
}
