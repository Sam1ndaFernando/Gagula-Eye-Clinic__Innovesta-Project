package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.dto.UserPatientDTO;
import com.GagulaEyeClinic.model.UserPatientModel;
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

public class UsrViewPatientsController implements Initializable {

    public TableColumn colDocId;
    @FXML
    private AnchorPane usrViewPatientsPane;

    @FXML
    private TableView<UserPatientDTO> tblPatientDetails;

    @FXML
    private TableColumn<?, ?> colPatientId;

    @FXML
    private TableColumn<?, ?> colPatientName;

    @FXML
    private TableColumn<?, ?> colPatienrAddress;

    @FXML
    private TableColumn<?, ?> colPatientNIC;

    @FXML
    private TableColumn<?, ?> colPatientAge;

    @FXML
    private TableColumn<?, ?> colContactNo;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private JFXButton btnBack;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/userPatients.fxml"));
        usrViewPatientsPane.getChildren().clear();
        usrViewPatientsPane.getChildren().add(load);

    }

    private void getAll() {
        try {
            List<UserPatientDTO> userPatientDTOS = UserPatientModel.getAll();
            ObservableList<UserPatientDTO> list = FXCollections.observableArrayList();
            for (UserPatientDTO userPatientDTO :userPatientDTOS){
                list.add(
                        new UserPatientDTO(
                                userPatientDTO.getPatId(),
                                userPatientDTO.getName(),
                                userPatientDTO.getAddress(),
                                userPatientDTO.getAge(),
                                userPatientDTO.getNic(),
                                userPatientDTO.getContactNum(),
                                userPatientDTO.getGender(),
                                userPatientDTO.getDocId()
                        ));
            }
            tblPatientDetails.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {

        colPatientId.setCellValueFactory(new PropertyValueFactory<>("patId"));
        colPatientName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPatienrAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPatientNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colPatientAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNum"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colDocId.setCellValueFactory(new PropertyValueFactory<>("docId"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }
}