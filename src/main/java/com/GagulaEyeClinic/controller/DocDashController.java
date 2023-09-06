package com.GagulaEyeClinic.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class DocDashController {

    @FXML
    private AnchorPane DocDashPane;

    @FXML
    private StackedBarChart<?, ?> patientBarChart;

    @FXML
    private Label lblAppointmentsCount;

    @FXML
    private Label lblTreatedPatientsCount;

    @FXML
    private Label lblRegistedPatientsCount;

    @FXML
    private Label lblWarningRequestsCount;

}
