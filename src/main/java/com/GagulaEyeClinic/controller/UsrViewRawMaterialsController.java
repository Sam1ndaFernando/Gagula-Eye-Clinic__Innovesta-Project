package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class UsrViewRawMaterialsController {

    @FXML
    private AnchorPane usrViewRawMaterialsPane;

    @FXML
    private TableView<?> tblViewRawMaterials;

    @FXML
    private TableColumn<?, ?> colMatID;

    @FXML
    private TableColumn<?, ?> colMatName;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colSupplieID;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private JFXButton btnBack;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

}
