package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class UsrMedicineController {

    @FXML
    private AnchorPane mediPane;

    @FXML
    private JFXComboBox<?> comBoxDocID;

    @FXML
    private JFXTextField txtMedicineId;

    @FXML
    private JFXTextField txtMedicineName;

    @FXML
    private JFXComboBox<?> comBoxPatientId;

    @FXML
    private TextArea txtDiscription;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

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
    void comBoxDocIDOnAction(ActionEvent event) {

    }

    @FXML
    void comBoxPatientIdOnAction(ActionEvent event) {

    }

}
