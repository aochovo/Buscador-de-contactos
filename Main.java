/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001proyectohilos;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
public class Main extends Application{
TextField tf_buscador;
Label lb_contacto;
VBox vBox;
ProgressBar pb_barra;
   public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	tf_buscador=new TextField();
        lb_contacto=new Label();
        pb_barra=new ProgressBar();
        MiTarea2 tarea2=new MiTarea2();
        Thread hilo2=new Thread(tarea2);
        pb_barra.progressProperty().bind(tarea2.progressProperty());
        hilo2.setDaemon(true);
        hilo2.start();
        //EventHandler<Suc>
        EventHandler<KeyEvent> oyente_teclas=new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
             MiTarea tarea=new MiTarea(tf_buscador.getText());
             Thread hilo=new Thread(tarea);
             hilo.setDaemon(true);
             hilo.start();
             tarea.setOnSucceeded(new EventHandler() {
                 @Override
                 public void handle(Event t) {
                     ArrayList<Contacto> lista=(ArrayList<Contacto>)tarea.getValue();
                     rellenarLabel(lista);
                 }
             });
            }
        };
        tf_buscador.setOnKeyReleased(oyente_teclas);
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(tf_buscador,lb_contacto);
        Scene s=new Scene(vBox,300,300);
        primaryStage.setScene(s);	
        primaryStage.show();
       
        }
        private void rellenarLabel(ArrayList<Contacto> lista)
        {
            String lista_contactos="";
            for (Contacto contacto : lista) {
                lista_contactos=lista_contactos+contacto.getNombre()+"-"+contacto.getApellido()+"-"+contacto.getEdad()+"\n";
            }
            
            if(tf_buscador.getText().isEmpty())
            {
                lb_contacto.setText("");
            }
            else
                {
            lb_contacto.setText(lista_contactos);
        }
        }
}

