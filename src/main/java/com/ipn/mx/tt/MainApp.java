package com.ipn.mx.tt;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainApp extends Application {

    Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/Center/Login.fxml"));
        
        this.stage = stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");

        Image image = new Image("/imagenes/brain.png");
        
        stage.getIcons().add(image);
        stage.setTitle("TT 2018-A030");
        stage.setScene(scene);
        stage.show();

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
    public void imprimirmensaje() {
        System.out.println("hola");
    }

    public static void main(String[] args) {
        launch(args);
    }
    public class onEnter implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) {
             System.out.println("HOLAAAAAAAAA");
        }
        
    }

}
