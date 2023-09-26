package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UsrAppointmentsController {

    @FXML
    private AnchorPane useAppoimentsPane;

    @FXML
    private JFXTextField txtAppointmentId;

    @FXML
    private JFXComboBox<?> ComBoxDoctorId;

    @FXML
    private JFXComboBox<?> ComBoxPatientId;

    @FXML
    private JFXComboBox<?> ComBoxPurpose;

    @FXML
    private JFXTimePicker timePickr;

    @FXML
    private JFXDatePicker dtePicker;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnView;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrViewAppoiments.fxml"));
        useAppoimentsPane.getChildren().clear();
        useAppoimentsPane.getChildren().add(load);
    }

    @FXML
    void txtAppointmentIdOnAction(ActionEvent event) {

    }

}
