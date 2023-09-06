package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;

public class DocPetientController {

    @FXML
    private AnchorPane patientDetailsPane;

    @FXML
    private JFXTextField txtPatientId;

    @FXML
    private JFXTextField txtPatientName;

    @FXML
    private JFXTextField txtPatientAddress;

    @FXML
    private JFXTextField txtPatientNIC;

    @FXML
    private JFXTextField txtPatientAge;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXComboBox<?> ComBoxGender;

    @FXML
    private JFXButton btnScan;

    @FXML
    private JFXButton btnMedicine;

    @FXML
    private JFXButton btnFinish;

    @FXML
    void btnFinishOnAction(ActionEvent event) {

    }

    @FXML
    void btnMedicineOnAction(ActionEvent event) {

    }

    @FXML
    void btnScanOnAction(ActionEvent event) {

    }

}
