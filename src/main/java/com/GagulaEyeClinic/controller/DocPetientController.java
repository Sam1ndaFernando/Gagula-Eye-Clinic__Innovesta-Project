package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.io.IOException;

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


    public void btnMedicineOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/docMedicine.fxml"));
        patientDetailsPane.getChildren().clear();
        patientDetailsPane.getChildren().add(load);
    }

    public void btnFinishOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/docDash.fxml"));
        patientDetailsPane.getChildren().clear();
        patientDetailsPane.getChildren().add(load);
    }

    public void btnScanOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/docScanComparison.fxml"));
        patientDetailsPane.getChildren().clear();
        patientDetailsPane.getChildren().add(load);
    }
}
