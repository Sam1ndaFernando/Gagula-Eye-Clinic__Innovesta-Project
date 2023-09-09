package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UsrRawMaterialsController {

    @FXML
    private AnchorPane rawMaterialsPane;

    @FXML
    private JFXTextField txtMaterialId;

    @FXML
    private JFXTextField txtMaterialName;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtCategory;

    @FXML
    private JFXComboBox<?> comBoxSupplieid;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnView;

    @FXML
    private JFXButton btnWarningMassge;

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
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrViewRawMaterials.fxml"));
        rawMaterialsPane.getChildren().clear();
        rawMaterialsPane.getChildren().add(load);

    }

    @FXML
    void btnWarningMassgeOnAction(ActionEvent event) {

    }

    @FXML
    void comBoxSupplieidOnAction(ActionEvent event) {

    }

}
