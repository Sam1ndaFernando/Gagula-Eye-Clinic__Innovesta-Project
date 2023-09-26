package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.dto.UserRawMaterialDTO;
import com.GagulaEyeClinic.model.UserRawMaterialModel;
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

public class UsrViewRawMaterialsController implements Initializable {

    public TableColumn colRawMatID;
    public TableColumn colRawMatName;
    public TableColumn colQty;
    public TableColumn colCategory;
    public TableColumn colSupplierID;
    @FXML
    private AnchorPane usrViewRawMaterialsPane;

    @FXML
    private TableView tblViewRawMaterials;

  

    @FXML
    private JFXButton btnBack;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrRawMaterials.fxml"));
        usrViewRawMaterialsPane.getChildren().clear();
        usrViewRawMaterialsPane.getChildren().add(load);

    }

    private void getAll() {
        try {
            List<UserRawMaterialDTO> userRawMaterialDTOS = UserRawMaterialModel.getAll();
            ObservableList<UserRawMaterialDTO> list = FXCollections.observableArrayList();
            for (UserRawMaterialDTO userRawMaterialDTO :userRawMaterialDTOS){
                list.add(
                        new UserRawMaterialDTO(
                                userRawMaterialDTO.getRawId(),
                                userRawMaterialDTO.getName(),
                                userRawMaterialDTO.getQty(),
                                userRawMaterialDTO.getCategory(),
                                userRawMaterialDTO.getSupId()
                        ));
            }
            tblViewRawMaterials.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {

        colRawMatID.setCellValueFactory(new PropertyValueFactory<>("rawId"));
        colRawMatName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colSupplierID.setCellValueFactory(new PropertyValueFactory<>("supId"));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }
}