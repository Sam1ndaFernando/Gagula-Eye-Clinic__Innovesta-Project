package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.dto.UserMedicineDTO;
import com.GagulaEyeClinic.model.UserMedicineModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import java.sql.SQLException;
import javafx.scene.control.Alert;

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
        String medId = txtMedicineId.getText();
        String name = txtMedicineName.getText();
        String description = txtDiscription.getText();


        UserMedicineDTO userMedicineDTO = new UserMedicineDTO(medId,name,description);


        try {
            boolean isSaved = UserMedicineModel.save(userMedicineDTO);


            if (isSaved) {

                new Alert(Alert.AlertType.CONFIRMATION, "Saved :) !!!").show();

            } else {

                new Alert(Alert.AlertType.ERROR, "Not saved :) !!!").show();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


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
