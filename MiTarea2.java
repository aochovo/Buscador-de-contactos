/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001proyectohilos;

import javafx.concurrent.Task;

/**
 *
 * @author FP Mañana A
 */
public class MiTarea2 extends Task{

    @Override
    protected Object call() throws Exception {
     for (int i = 1; i <= 200; i++) {
           Thread.sleep(100);
           updateProgress(i, 200);
        }
        return null;
}
}
