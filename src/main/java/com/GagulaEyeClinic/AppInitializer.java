package com.GagulaEyeClinic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

//public class Appinitializer extends Application {
//
//    @Override
//    public void start(Stage stage) throws Exception {
//    stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/loadingScreen.fxml"))));
//    stage.show();
//    }
//}

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/welcomeScreen.fxml"))));
        primaryStage.setTitle("Gangula Eye Care");
        primaryStage.getIcons().add(new Image("/assets/icons/free-microphone-icon-342-thumb.png"));
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }
}