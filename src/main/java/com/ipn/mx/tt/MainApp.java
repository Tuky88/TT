package com.ipn.mx.tt;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainApp extends Application {

    Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXML.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        this.stage=stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/menu.css");
        
        Image image = new Image("/imagenes/brain.png");
        this.stage.getIcons().add(image);
        this.stage.setTitle("TT 2018-A030");
        this.stage.setScene(scene);
        this.stage.show();
    }


    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
