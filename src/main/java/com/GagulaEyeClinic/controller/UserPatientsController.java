package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.dto.UserPatientDTO;
import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.GagulaEyeClinic.model.UserSupplierModel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.GagulaEyeClinic.model.UserPatientModel;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class UserPatientsController implements Initializable {
    @FXML
    public JFXComboBox<String>  comBoxDoctorId;

    @FXML
    private AnchorPane usrPatientPane;

    @FXML
    private JFXTextField txtPatientAge;

    @FXML
    private JFXComboBox<String> comBoxGender;

    @FXML
    private JFXTextField txtPatientId;

    @FXML
    private JFXTextField txtPatientName;

    @FXML
    private JFXTextField txtPatientAddress;

    @FXML
    private JFXTextField txtPatientNIC;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnView;




    ObservableList<UserSupplierDTO> observableList = FXCollections.observableArrayList();
    @FXML
    void btnAddOnAction(ActionEvent event) {
        String patId = txtPatientId.getText();
        String name = txtPatientName.getText();
        String address = txtPatientAddress.getText();
        Integer age = Integer.parseInt(txtPatientAge.getText());
        String nic = txtPatientNIC.getText();
        String contactNum = txtContactNo.getText();
        String gender = comBoxGender.getValue();
        String docId = comBoxDoctorId.getValue();


        UserPatientDTO userPatientDTO = new UserPatientDTO(patId, name, address, age, nic, contactNum, gender,docId);

            try {
                boolean isSaved = UserPatientModel.save(userPatientDTO);

                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved :) !!!").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Not saved :) !!!").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
            e.printStackTrace();
            }

        String textToEncode = "Patient Id = " + patId +
        "\nPatient name = " + "Name = " + name +
                "\nAddress = " + address +
                "\nAge = " + age +
                "\nNIC = " + nic +
                "\nContact Number = " + contactNum +
                "\nGender = " + gender +
                "\nDoctor ID = " + docId;
        String filePath = "qr-code.png"; // Output file path

        int width = 300; // Width of the QR code image
        int height = 300; // Height of the QR code image

        try {
            // Create a QR code writer
            MultiFormatWriter writer = new MultiFormatWriter();

            // Set up encoding hints (optional)
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            // Generate a QR code matrix
            BitMatrix bitMatrix = writer.encode(textToEncode, BarcodeFormat.QR_CODE, width, height, hints);

            // Convert the matrix to an image and save it to a file
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", Paths.get(filePath));

            System.out.println("QR Code generated successfully!");
        } catch (WriterException | IOException e) {
            e.printStackTrace();
}
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String patId = txtPatientId.getText();
        try {
            boolean isRemoved = UserPatientModel.remove(patId);

            if (isRemoved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted successfully").show();
                txtPatientId.setText("");
                txtPatientName.setText("");
                txtPatientAddress.setText("");
                txtPatientAge.setText("");
                txtPatientNIC.setText("");
                txtContactNo.setText("");
                comBoxGender.setValue("");
                comBoxDoctorId.setValue("");
                observableList.clear();

            } else {
                new Alert(Alert.AlertType.ERROR, "Delete failed").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String patId = txtPatientId.getText();
        String name = txtPatientName.getText();
        String address = txtPatientAddress.getText();
        Integer age = Integer.parseInt(txtPatientAge.getText());
        String nic = txtPatientNIC.getText();
        String contactNum = txtContactNo.getText();
        String gender = comBoxGender.getValue();
        String docId = comBoxDoctorId.getValue();

        boolean isUpdated = false;
        try {
            isUpdated = UserPatientModel.update(new UserPatientDTO(patId, name, address,age, nic, contactNum,gender,docId));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated successfully").show();
                txtPatientId.setText("");
                txtPatientName.setText("");
                txtPatientAddress.setText("");
                txtPatientAge.setText("");
                txtPatientNIC.setText("");
                txtContactNo.setText("");
                comBoxGender.setValue("");
                comBoxDoctorId.setValue("");
            } else {
                new Alert(Alert.AlertType.ERROR, "Update failed").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnViewOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrViewPatients.fxml"));
        usrPatientPane.getChildren().clear();
        usrPatientPane.getChildren().add(load);

    }

    @FXML
    void comBoxPatientIdOnAction(ActionEvent event) {
        String selectedGender = (String) comBoxGender.getValue();
        if (selectedGender != null) {

        }
    }

    @FXML
    void patIdOnAction(ActionEvent event) {
        String patId = txtPatientId.getText();

        try {
            UserPatientDTO userPatientDTO = UserPatientModel.search(patId);

            if (userPatientDTO != null) {
                txtPatientNIC.setText(userPatientDTO.getNic());
                txtPatientAddress.setText(userPatientDTO.getAddress());
                txtPatientName.setText(userPatientDTO.getName());
                txtContactNo.setText(userPatientDTO.getContactNum());
                txtPatientAge.setText(String.valueOf(userPatientDTO.getAge()));
                comBoxGender.setValue(userPatientDTO.getGender());
                comBoxDoctorId.setValue(userPatientDTO.getDocId());

            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid ID").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> genderOptions = FXCollections.observableArrayList("Male", "Female");
        comBoxGender.setItems(genderOptions);
        setCellValueFactory();
    }

    private void setCellValueFactory() {
    }

    public void comBoxDoctorIdOnAction(ActionEvent actionEvent) {

    }
}
