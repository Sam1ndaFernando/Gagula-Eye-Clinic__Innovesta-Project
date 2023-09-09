package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class WelcomeScreenController {

    public JFXButton btnWelcomePge;
    @FXML
    private AnchorPane welcomePane;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    public void btnWelcomePgeOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/loginScreen.fxml"));
        welcomePane.getChildren().clear();
        welcomePane.getChildren().add(load);
    }
}
