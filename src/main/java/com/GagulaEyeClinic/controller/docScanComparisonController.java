package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class docScanComparisonController {
    public AnchorPane scanComparisonPane;

    @FXML
    private JFXProgressBar ScaningBar;

    @FXML
    private AnchorPane pic01Pane;

    @FXML
    private ImageView pic01ImgPane;

    @FXML
    private JFXButton btnSelectBtn01;

    @FXML
    private AnchorPane pic02Pane;

    @FXML
    private ImageView pic02ImgPane;

    @FXML
    private JFXButton btnSelectPic02;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnComparision;

    @FXML
    private JFXButton btnFinish;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {

        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/docPetient.fxml"));
        scanComparisonPane.getChildren().clear();
        scanComparisonPane.getChildren().add(load);
    }

    @FXML
    void btnComparisionOnAction(ActionEvent event) {

    }

    @FXML
    void btnFinishOnAction(ActionEvent event) throws IOException {

        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/docPetient.fxml"));
        scanComparisonPane.getChildren().clear();
        scanComparisonPane.getChildren().add(load);
    }

    @FXML
    void btnSelectBtn01OnAction(ActionEvent event) {

    }

    @FXML
    void btnSelectPic02OnAction(ActionEvent event) {

    }

}
