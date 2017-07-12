/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fxutilities;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 *
 * @author taleb
 */
public class Frame {
    
    private static Stage stage;
    
    
    public static void load(ActionEvent event,Class classController,String fxmlFile,String title) throws IOException{
        stage = new Stage();
         
    Parent root = FXMLLoader.load(
        classController.getResource(fxmlFile));
    stage.setScene(new Scene(root));
    stage.setTitle(title);
    stage.initModality(Modality.WINDOW_MODAL);
    stage.initOwner(
        ((Node)event.getSource()).getScene().getWindow() );
    stage.show();
    }
    
    public static void autoSize(){
        stage.sizeToScene();
        stage.setX((Screen.getPrimary().getBounds().getMaxX()-stage.getWidth())/2);
        stage.setY(0);
    }
}
