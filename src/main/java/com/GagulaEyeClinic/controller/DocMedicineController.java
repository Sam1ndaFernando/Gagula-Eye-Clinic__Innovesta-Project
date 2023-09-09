package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DocMedicineController {

    @FXML
    private AnchorPane MedicinePane;

    @FXML
    private JFXTextField txtPatientAge;

    @FXML
    private JFXComboBox<?> ComBoxGender;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnFinish;

    @FXML
    private JFXComboBox<?> comBoxPatientId;

    @FXML
    private JFXTimePicker timePickr;

    @FXML
    private TextArea txtSpeech;

    @FXML
    private JFXButton btnVoice;

    @FXML
    private JFXButton btnView;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/docPetient.fxml"));
        MedicinePane.getChildren().clear();
        MedicinePane.getChildren().add(load);
    }

    @FXML
    void btnFinishOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewOnAction(ActionEvent event) {

    }

    @FXML
    void btnVoiceOnAction(ActionEvent event) {

    }

    @FXML
    void comBoxPatientIdOnAction(ActionEvent event) {

    }

}
