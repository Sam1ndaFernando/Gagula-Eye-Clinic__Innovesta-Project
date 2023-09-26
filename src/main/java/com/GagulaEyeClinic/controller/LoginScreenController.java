package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.animation.Timeline;
import javafx.scene.control.Alert.AlertType;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.event.EventHandler;
import java.io.IOException;
import javafx.scene.Parent;



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


    private Timeline timeline; // Declare the Timeline here

    private void updateTimeLabel() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String formattedTime = timeFormat.format(new Date());
        lblTime.setText(formattedTime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(new Date());
        lblDate.setText(formattedDate);
    }

    public void initialize() {
        updateTimeLabel();

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(1),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        updateTimeLabel();
                    }
                }
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }



    public void loginBtnOnAction(ActionEvent actionEvent) throws IOException {
        String username = usrnmeField.getText();
        String password = passwrdField.getText();

        // Check for user role based on username
        if ("user".equals(username)) {
            // User role
            String validUserPassword = "1234";

            if (password.equals(validUserPassword)) {
                // Username and password are correct for the user role, proceed to userDashboard
                loadDashboard("/view/userDashboard.fxml");
                return; // Exit the method
            }
        } else if ("doctor".equals(username)) {
            // Doctor role
            String validDoctorPassword = "1234";

            if (password.equals(validDoctorPassword)) {
                // Username and password are correct for the doctor role, proceed to doctorDashboard
                loadDashboard("/view/doctorsDashboard.fxml");
                return; // Exit the method
            }
        }

        // Username or password is incorrect, show an error message
        showErrorDialog("Login Failed", "Invalid username or password. Please try again.");
    }

    private void loadDashboard(String dashboardFXMLPath) throws IOException {
        try {
            AnchorPane load = FXMLLoader.load(getClass().getResource(dashboardFXMLPath));
            loginPane.getChildren().clear();
            loginPane.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showErrorDialog(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}