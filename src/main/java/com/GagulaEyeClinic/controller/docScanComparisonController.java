package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class docScanComparisonController {
    private FileChooser fileChooser; // File chooser for selecting images
    private File file = new File("C:\\Users\\Nadil\\IdeaProjects\\Gagula-Eye-Clinic__Innovesta-Project\\src\\main\\resources\\assets\\icons\\Human.png"); // Default empty file
    private Image image; // Image object to hold the selected image
    private FileInputStream fileInputStream; // Input stream for reading files

    private FileChooser fileChooser2; // File chooser for selecting images
    private File file2 = new File("C:\\Users\\Nadil\\IdeaProjects\\Gagula-Eye-Clinic__Innovesta-Project\\src\\main\\resources\\assets\\icons\\Human.png"); // Default empty file
    private Image image2; // Image object to hold the selected image
    private FileInputStream fileInputStream2; // Input stream for reading files
    public AnchorPane scanComparisonPane;

    @FXML
    private JFXProgressBar ScaningBar;

    @FXML
    private AnchorPane pic01Pane;

    @FXML
    private ImageView pic01ImgPane;

    @FXML
    private JFXButton btnSelectBtn01;

    @FXML
    private AnchorPane pic02Pane;

    @FXML
    private ImageView pic02ImgPane;

    @FXML
    private JFXButton btnSelectPic02;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnComparision;

    @FXML
    private JFXButton btnFinish;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {

        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/docPetient.fxml"));
        scanComparisonPane.getChildren().clear();
        scanComparisonPane.getChildren().add(load);
    }

    @FXML
    void btnComparisionOnAction(ActionEvent event) {

    }

    @FXML
    void btnFinishOnAction(ActionEvent event) throws IOException {

        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/docPetient.fxml"));
        scanComparisonPane.getChildren().clear();
        scanComparisonPane.getChildren().add(load);
    }

    @FXML
    void pic1AddOnAction(ActionEvent event) {


        Stage primaryStage = new Stage();

// Create a FileChooser and set allowed file extensions
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)", "*.PNG");
        FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("JPEG files(*.jpeg)", "*.JPEG");
        fc.getExtensionFilters().addAll(ext1, ext2, ext3);

// Show the open file dialog and store the selected file
        file = fc.showOpenDialog(primaryStage);

        if (file != null) {
            // If a file was selected, create an Image object from it
            image = new Image(file.toURI().toString(), 100, 100, true, true);
            System.out.println(file.getAbsolutePath());

            // Set the selected image to an ImageView (assuming imgPerson is an ImageView)
            pic01ImgPane.setImage(image);
        } else {
            // If no file was selected, use a default image
            image = new Image("icons/Human.png");
        }

    }

    @FXML
    void pic2AddOnAction(ActionEvent event) {
        Stage primaryStage = new Stage();

// Create a FileChooser and set allowed file extensions
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)", "*.PNG");
        FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("JPEG files(*.jpeg)", "*.JPEG");
        fc.getExtensionFilters().addAll(ext1, ext2, ext3);

// Show the open file dialog and store the selected file
        file2 = fc.showOpenDialog(primaryStage);

        if (file2 != null) {
            // If a file was selected, create an Image object from it
            image2 = new Image(file2.toURI().toString(), 100, 100, true, true);
            System.out.println(file2.getAbsolutePath());

            // Set the selected image to an ImageView (assuming imgPerson is an ImageView)
            pic02ImgPane.setImage(image2);
        } else {
            // If no file was selected, use a default image
            image2 = new Image("icons/Human.png");
        }

    }

}


