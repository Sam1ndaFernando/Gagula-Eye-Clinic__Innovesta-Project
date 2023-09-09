package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

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
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrRawMaterials.fxml"));
        usrViewRawMaterialsPane.getChildren().clear();
        usrViewRawMaterialsPane.getChildren().add(load);

    }

}