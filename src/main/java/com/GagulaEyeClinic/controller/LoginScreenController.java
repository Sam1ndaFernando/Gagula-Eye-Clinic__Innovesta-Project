package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class LoginScreenController {

    @FXML
    private AnchorPane loginPane;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXTextField usrnmeField;

    @FXML
    private JFXPasswordField passwrdField;

    public void loginBtnOnAction(ActionEvent actionEvent) {
        
    }
}
