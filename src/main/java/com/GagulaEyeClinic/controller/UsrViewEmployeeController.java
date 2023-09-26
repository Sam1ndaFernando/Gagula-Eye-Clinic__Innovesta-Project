package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.dto.UserEmployeeDTO;
import com.GagulaEyeClinic.model.UserEmployeeModel;
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

public class UsrViewEmployeeController implements Initializable {

    @FXML
    private AnchorPane usrViewEmployeePane;

    @FXML
    private TableView<UserEmployeeDTO> tblEmployeeDetails;

    @FXML
    private TableColumn<?, ?> colEmpID;

    @FXML
    private TableColumn<?, ?> colEmpName;

    @FXML
    private TableColumn<?, ?> colJobRole;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colJoingDate;

    @FXML
    private JFXButton btnBack;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrEmployee.fxml"));
        usrViewEmployeePane.getChildren().clear();
        usrViewEmployeePane.getChildren().add(load);
    }


    private void getAll() {
        try {
            List<UserEmployeeDTO> userEmployeeDTOS = UserEmployeeModel.getAll();
            ObservableList<UserEmployeeDTO> list = FXCollections.observableArrayList();
            for (UserEmployeeDTO userEmployeeDTO : userEmployeeDTOS){
                list.add(
                        new UserEmployeeDTO(
                                userEmployeeDTO.getEmpId(),
                                userEmployeeDTO.getName(),
                                userEmployeeDTO.getAddress(),
                                userEmployeeDTO.getContactNum(),
                                userEmployeeDTO.getJobRole(),
                                userEmployeeDTO.getJoinedDate()
                        ));
            }
            tblEmployeeDetails.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {

        colEmpID.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colEmpName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNum"));
        colJobRole.setCellValueFactory(new PropertyValueFactory<>("jobRole"));
        colJoingDate.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }
}