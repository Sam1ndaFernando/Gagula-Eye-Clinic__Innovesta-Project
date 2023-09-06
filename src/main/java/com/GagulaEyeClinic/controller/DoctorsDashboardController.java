package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

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
    void SearchBtnOnAction(ActionEvent event) {

    }

    @FXML
    void homeBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/docDash.fxml"));
        rootPane.getChildren().clear();
        rootPane.getChildren().add(load);
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
    }

    @FXML
    void patientBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/docPetient.fxml"));
        rootPane.getChildren().clear();
        rootPane.getChildren().add(load);
    }
}