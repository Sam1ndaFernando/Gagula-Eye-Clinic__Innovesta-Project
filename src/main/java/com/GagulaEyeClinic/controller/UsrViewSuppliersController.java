package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.GagulaEyeClinic.model.UserSupplierModel;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UsrViewSuppliersController implements Initializable {


    public TableView tblSuppliers;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn address;
    public TableColumn colNic;
    public TableColumn colEmail;
    public TableColumn colContactNum;
    @FXML
    private AnchorPane usrViewSuppliersPane;


    @FXML
    private JFXButton btnBack;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrSuppliers.fxml"));
        usrViewSuppliersPane.getChildren().clear();
        usrViewSuppliersPane.getChildren().add(load);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }

    private void getAll() {
        try {
            List<UserSupplierDTO> userSupplierDTOS = UserSupplierModel.getAll();
            ObservableList<UserSupplierDTO> list = FXCollections.observableArrayList();
            for (UserSupplierDTO userSupplierDTO :userSupplierDTOS){
                list.add(
                        new UserSupplierDTO(
                        userSupplierDTO.getSupId(),
                        userSupplierDTO.getName(),
                        userSupplierDTO.getAddress(), userSupplierDTO.getEmail(),
                        userSupplierDTO.getNic(),
                        userSupplierDTO.getContactNum()
                ));
            }
            tblSuppliers.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {

        colId.setCellValueFactory(new PropertyValueFactory<>("supId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colContactNum.setCellValueFactory(new PropertyValueFactory<>("contactNum"));
    }
}