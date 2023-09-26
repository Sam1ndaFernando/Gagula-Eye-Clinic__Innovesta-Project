package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.dto.DocPatientDTO;
import com.GagulaEyeClinic.dto.UserPatientDTO;
import com.GagulaEyeClinic.model.DocPatientModel;
import com.GagulaEyeClinic.model.UserPatientModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

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
    private JFXComboBox<String> ComBoxGender;

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


    public void patIdOnAction(ActionEvent event) {
        String patId = txtPatientId.getText();

        try {
            DocPatientDTO docPatientDTO = DocPatientModel.search(patId);

            if (docPatientDTO != null) {
                txtPatientNIC.setText(docPatientDTO.getNic());
                txtPatientAddress.setText(docPatientDTO.getAddress());
                txtPatientName.setText(docPatientDTO.getName());
                txtContactNo.setText(docPatientDTO.getContactNum());
                txtPatientAge.setText(String.valueOf(docPatientDTO.getAge()));
                ComBoxGender.setValue(docPatientDTO.getGender());


            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid ID").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
