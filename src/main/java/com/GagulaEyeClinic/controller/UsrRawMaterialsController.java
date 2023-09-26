package com.GagulaEyeClinic.controller;


import com.GagulaEyeClinic.dto.UserRawMaterialDTO;
import com.GagulaEyeClinic.model.UserRawMaterialModel;
import com.GagulaEyeClinic.model.UserSupplierModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


public class UsrRawMaterialsController implements Initializable {

    @FXML
    public JFXComboBox<String> colSupplierID;

    @FXML
    private AnchorPane rawMaterialsPane;

    @FXML
    private JFXTextField txtMaterialId;

    @FXML
    private JFXTextField txtMaterialName;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtCategory;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnView;

    @FXML
    private JFXButton btnWarningMassge;

    ObservableList<UserRawMaterialDTO> observableList = FXCollections.observableArrayList();

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String rawId = txtMaterialId.getText();
        String name = txtMaterialName.getText();
        Integer qty = Integer.valueOf(txtQty.getText());
        String category = txtCategory.getText();
        String supId = (String) colSupplierID.getValue();

        UserRawMaterialDTO userRawMaterialDTO = new UserRawMaterialDTO(rawId, name, qty, category, supId);

        try {
            boolean isSaved = UserRawMaterialModel.save(userRawMaterialDTO);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved  !!!").show();
                observableList.clear();
            } else {
                new Alert(Alert.AlertType.ERROR, "Not saved  !!!").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String rawId = txtMaterialId.getText();

        try {
            boolean isRemoved = UserRawMaterialModel.remove(rawId);

            if (isRemoved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted successfully").show();
                txtMaterialId.setText("");
                txtMaterialName.setText("");
                txtQty.setText("");
                txtCategory.setText("");
                colSupplierID.getValue();
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
        String rawId = txtMaterialId.getText();
        String name = txtMaterialName.getText();
        int qty = Integer.parseInt(txtQty.getText());
        String category = txtCategory.getText();
        String supId = (String) colSupplierID.getValue();

        boolean isUpdated = false;
        try {
            isUpdated = UserRawMaterialModel.update(new UserRawMaterialDTO(rawId, name, qty,category, supId));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated successfully").show();
                txtMaterialId.setText("");
                txtMaterialName.setText("");
                txtQty.setText("");
                txtCategory.setText("");
                colSupplierID.setValue("");

            } else {
                new Alert(Alert.AlertType.ERROR, "Update failed").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnViewOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrViewRawMaterials.fxml"));
        rawMaterialsPane.getChildren().clear();
        rawMaterialsPane.getChildren().add(load);

    }

    @FXML
    void btnWarningMassgeOnAction(ActionEvent event) {

    }

    @FXML
    void txtIdOnAction(ActionEvent event) {
        String rawId = txtMaterialId.getText();

        try {
            UserRawMaterialDTO userRawMaterialDTO= UserRawMaterialModel.search(rawId);

            if (userRawMaterialDTO != null) {
               txtMaterialName.setText(userRawMaterialDTO.getName());
                txtQty.setText(String.valueOf(userRawMaterialDTO.getQty()));
                txtCategory.setText(userRawMaterialDTO.getCategory());
                colSupplierID.setValue(userRawMaterialDTO.getSupId());
            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid ID").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        try {
            colSupplierIDOnAction(null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void setCellValueFactory() {

    }

    public void colSupplierIDOnAction(ActionEvent actionEvent) throws SQLException {
        List<String> supplierIDs = UserSupplierModel.getAllSupplierIDs();
        colSupplierID.getItems().clear();
        colSupplierID.getItems().addAll(supplierIDs);

    }
}
