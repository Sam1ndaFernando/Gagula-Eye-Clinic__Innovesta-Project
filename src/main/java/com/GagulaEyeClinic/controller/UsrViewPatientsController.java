package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UsrViewPatientsController {

    @FXML
    private AnchorPane usrViewPatientsPane;

    @FXML
    private TableView<?> tblPatientDetails;

    @FXML
    private TableColumn<?, ?> colPatientId;

    @FXML
    private TableColumn<?, ?> colPatientName;

    @FXML
    private TableColumn<?, ?> colPatienrAddress;

    @FXML
    private TableColumn<?, ?> colPatientNIC;

    @FXML
    private TableColumn<?, ?> colPatientAge;

    @FXML
    private TableColumn<?, ?> colContactNo;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private JFXButton btnBack;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/userPatients.fxml"));
        usrViewPatientsPane.getChildren().clear();
        usrViewPatientsPane.getChildren().add(load);

    }

}