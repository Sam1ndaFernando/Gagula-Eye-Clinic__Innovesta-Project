package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDashboardController {

    @FXML
    private AnchorPane userSecPane;

    @FXML
    private AnchorPane userNaviPanal;

    @FXML
    private JFXButton homeBtn;

    @FXML
    private JFXButton patientBtn;

    @FXML
    private JFXButton btnAppoiments;

    @FXML
    private JFXButton btnMedicine;

    @FXML
    private JFXButton btnSuppliers;

    @FXML
    private JFXButton btnRawMaterial;

    @FXML
    private JFXButton btnEmployees;

    @FXML
    private JFXButton logoutBtn;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    @FXML
    private JFXTextField SearchBar;

    @FXML
    private JFXButton SearchBtn;

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
            root = FXMLLoader.load(getClass().getResource("/view/usrDash.fxml"));
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
    void btnAppoimentsOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/usrAppointments.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

    @FXML
    void btnEmployeesOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/usrEmployee.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

    @FXML
    void btnMedicineOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/usrMedicine.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

    @FXML
    void btnRawMaterialOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/usrRawMaterials.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

    @FXML
    void btnSuppliersOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/usrSuppliers.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

    @FXML
    void homeBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/usrDash.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

    @FXML
    void logoutBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/loginScreen.fxml"));
        userSecPane.getChildren().clear();
        userSecPane.getChildren().add(load);

    }

    @FXML
    void patientBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/userPatients.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

}
