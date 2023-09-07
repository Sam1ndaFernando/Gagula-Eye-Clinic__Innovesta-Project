package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

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
    void btnBackOnAction(ActionEvent event) {

    }

}
