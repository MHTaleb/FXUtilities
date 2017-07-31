/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fxutilities;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author taleb
 */
public class Frame {

    private static Stage stage;

    public static void load(ActionEvent event, Class classController, String fxmlFile, String title) throws IOException {
        stage = new Stage();

        Parent root = FXMLLoader.load(
                classController.getResource(fxmlFile));
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

    public static void autoSize() {
        stage.sizeToScene();
        stage.setX((Screen.getPrimary().getBounds().getMaxX() - stage.getWidth()) / 2);
        stage.setY(0);
    }
    
    public static File showOpenDialog(String title, String[] extensions) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("type :", extensions);
        fileChooser.setSelectedExtensionFilter(filter);
        fileChooser.setTitle("Open Resource File");
        File openFile = fileChooser.showOpenDialog(stage);
        return openFile;
        
    }
    
    public static File showOpenDialog(String title) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File openFile = fileChooser.showOpenDialog(stage);
        return openFile;
        
    }
}
