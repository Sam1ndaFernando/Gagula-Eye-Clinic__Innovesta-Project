package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.GagulaEyeClinic.model.UserSupplierModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class UsrSuppliersController implements Initializable {

    public JFXTextField txtEmail;
    @FXML
    private AnchorPane suppliersPane;

    @FXML
    private JFXTextField txtSupplierId;

    @FXML
    private JFXTextField txtSupplierName;

    @FXML
    private JFXTextField txtSupplierAddress;

    @FXML
    private JFXTextField txtNic;

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


    private TableView<UserSupplierDTO> tblViewSuppliers;


    ObservableList<UserSupplierDTO> observableList = FXCollections.observableArrayList();

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String supId = txtSupplierId.getText();
        String name = txtSupplierName.getText();
        String address = txtSupplierAddress.getText();
        String nic = txtNic.getText();
        String email = txtEmail.getText();
        String contactNum = txtContactNo.getText();

        try {
            boolean isSaved = UserSupplierModel.save(new UserSupplierDTO(supId, name, address, nic,email, contactNum));


            if (isSaved) {

                new Alert(Alert.AlertType.CONFIRMATION, "Saved  !!!").show();
                txtSupplierId.setText("");
                txtSupplierName.setText("");
                txtSupplierAddress.setText("");
                txtNic.setText("");
                txtContactNo.setText("");
                txtEmail.setText("");

            } else {

                new Alert(Alert.AlertType.ERROR, "Not saved  !!!").show();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String supId = txtSupplierId.getText();
        try {
            boolean isRemoved = UserSupplierModel.remove(supId);

            if (isRemoved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted successfully").show();
                txtSupplierId.setText("");
                txtSupplierName.setText("");
                txtSupplierAddress.setText("");
                txtNic.setText("");
                txtContactNo.setText("");
                txtEmail.setText("");
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
        String supId = txtSupplierId.getText();
        String name = txtSupplierName.getText();
        String address = txtSupplierAddress.getText();
        String nic = txtNic.getText();
        String email = txtEmail.getText();
        String contactNum = txtContactNo.getText();

        boolean isUpdated = false;
        try {
            isUpdated = UserSupplierModel.update(new UserSupplierDTO(supId, name, address, nic,email, contactNum));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated successfully").show();
                txtSupplierId.setText("");
                txtSupplierName.setText("");
                txtSupplierAddress.setText("");
                txtNic.setText("");
                txtContactNo.setText("");
                txtEmail.setText("");
            } else {
                new Alert(Alert.AlertType.ERROR, "Update failed").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnViewOnAction(ActionEvent event) throws IOException {

        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrViewSuppliers.fxml"));
        suppliersPane.getChildren().clear();
        suppliersPane.getChildren().add(load);

    }


    @FXML
    void txtSupplierIdOnAction(ActionEvent event) {
        String supId = txtSupplierId.getText();

        try {
            UserSupplierDTO userSupplierDTO = UserSupplierModel.search(supId);

            if (userSupplierDTO != null) {
                txtNic.setText(userSupplierDTO.getNic());
                txtSupplierAddress.setText(userSupplierDTO.getAddress());
                txtSupplierName.setText(userSupplierDTO.getName());
                txtEmail.setText(userSupplierDTO.getEmail());
                txtContactNo.setText(userSupplierDTO.getContactNum());
            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid ID").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();

    }

    private void setCellValueFactory() {

    }

}
