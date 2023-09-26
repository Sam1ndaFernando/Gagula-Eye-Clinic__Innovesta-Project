package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoctorsDashboardController {
    @FXML
    private AnchorPane DocSecPane;

    @FXML
    private AnchorPane docNaviPanal;

    @FXML
    private JFXButton homeBtn;

    @FXML
    private JFXButton patientBtn;

    @FXML
    private JFXButton logoutBtn;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXTextField SearchBar;

    @FXML
    private JFXButton SearchBtn;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblHeading;

    @FXML
    private AnchorPane load;

    private Timeline timeline; // Declare the Timeline here


    private void updateTimeLabel() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String formattedTime = timeFormat.format(new Date());
        lblTime.setText(formattedTime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(new Date());
        lblDate.setText(formattedDate);
    }

    public void initialize() {
        updateTimeLabel();

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(1),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        updateTimeLabel();
                    }
                }
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        AnchorPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/docDash.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        load.getChildren().clear();
        load.getChildren().add(root);


    }


    @FXML
    void SearchBtnOnAction(ActionEvent event) {

    }

    @FXML
    void homeBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/docDash.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);
    }

    @FXML
    void logoutBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/loginScreen.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.setTitle("Login_page");
        stage.centerOnScreen();
        stage.show();
        Stage stage1 = (Stage) DocSecPane.getScene().getWindow();
        stage1.close();
        stage1.setFullScreen(true);
        stage.setFullScreen(true);
    }

    @FXML
    void patientBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/docPetient.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);
    }
}