package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.db.DBConnection;
import com.GagulaEyeClinic.dto.UserRawMaterialDTO;
import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.GagulaEyeClinic.model.UserRawMaterialModel;
import com.GagulaEyeClinic.model.UserSupplierModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import com.GagulaEyeClinic.model.UserEmployeeModel;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.scene.input.KeyCode;
import java.util.List;
import java.sql.SQLException;
import com.GagulaEyeClinic.dto.UserEmployeeDTO;
import java.time.LocalDate;
import com.jfoenix.controls.JFXDatePicker;

public class UsrEmployeeController implements Initializable {


    public DatePicker datePicker;
    @FXML
    private AnchorPane employeePane;

    @FXML
    private JFXTextField txtEmployeeId;

    @FXML
    private JFXTextField txtEmployeeName;

    @FXML
    private JFXTextField txtJobRole;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXTextField txtAddress;

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
        String empId = txtEmployeeId.getText();
        String name = txtEmployeeName.getText();
        String address = txtAddress.getText();
        String contactNum = txtContactNo.getText();
        String jobRole = txtJobRole.getText();
        LocalDate joinedDate = datePicker.getValue();

        String formattedDate = null;

        if (joinedDate != null) {
            // Format the date as 'yyyy-MM-dd' to match MySQL date format
            formattedDate = joinedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        try {
            boolean isSaved = UserEmployeeModel.save(new UserEmployeeDTO(empId, name, address, contactNum, jobRole,formattedDate));


            if (isSaved) {

                new Alert(Alert.AlertType.CONFIRMATION, "Saved  !!!").show();
                txtEmployeeId.setText("");
                txtEmployeeName.setText("");
                txtAddress.setText("");
                txtContactNo.setText("");
                txtJobRole.setText("");
                datePicker.setValue(null);

            } else {

                new Alert(Alert.AlertType.ERROR, "Not saved  !!!").show();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String empId = txtEmployeeId.getText();
        try {
            boolean isRemoved = UserEmployeeModel.remove(empId);

            if (isRemoved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted successfully").show();
                txtEmployeeId.setText("");
                txtEmployeeName.setText("");
                txtAddress.setText("");
                txtContactNo.setText("");
                txtJobRole.setText("");
                datePicker.setValue(null);

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
        String empId = txtEmployeeId.getText();
        String name = txtEmployeeName.getText();
        String address = txtAddress.getText();
        String contactNum = txtContactNo.getText();
        String jobRole = txtJobRole.getText();
        LocalDate joinedDate = datePicker.getValue();

        String formattedDate = null;

        if (joinedDate != null) {
            // Format the date as 'yyyy-MM-dd' to match MySQL date format
            formattedDate = joinedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        boolean isUpdated = false;
        try {
            isUpdated = UserEmployeeModel.update(new UserEmployeeDTO(empId, name, address, contactNum,jobRole,formattedDate));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated successfully").show();
                txtEmployeeId.setText("");
                txtEmployeeName.setText("");
                txtAddress.setText("");
                txtContactNo.setText("");
                txtJobRole.setText("");
                datePicker.setValue(null);
            } else {
                new Alert(Alert.AlertType.ERROR, "Update failed").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @FXML
    void btnViewOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrViewEmployee.fxml"));
        employeePane.getChildren().clear();
        employeePane.getChildren().add(load);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void empIdOnAction(ActionEvent actionEvent) {
        String empId = txtEmployeeId.getText();

        try {
            UserEmployeeDTO userEmployeeDTO= UserEmployeeModel.search(empId);

            if (userEmployeeDTO != null) {
                txtEmployeeName.setText(userEmployeeDTO.getName());
                txtAddress.setText(String.valueOf(userEmployeeDTO.getAddress()));
                txtContactNo.setText(userEmployeeDTO.getContactNum());
                txtJobRole.setText(userEmployeeDTO.getJobRole());
                datePicker.setValue(LocalDate.parse(userEmployeeDTO.getJoinedDate()));
            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid ID").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}