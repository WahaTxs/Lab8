/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Achik
 */
public class PainterController implements Initializable {

   
      private enum PenSize {
        SMALL(2), MEDIUM(4), LARGE(6);
        private final int value;
        PenSize(int value) { this.value = value; }
        public int getValue() { return value; }
    }

    @FXML
    private RadioButton radioBtnBlack;
    @FXML
    private ToggleGroup colorToggleGroup;
    @FXML
    private RadioButton radioBtnRed;
    @FXML
    private RadioButton radioBtnGreen;
    @FXML
    private RadioButton radioBtnBlue;
    @FXML
    private RadioButton radioBtnSizeSmall;
    @FXML
    private ToggleGroup penSizeToggleGroup;
    @FXML
    private RadioButton radioBtnSizeMedium;
    @FXML
    private RadioButton radioBtnSizeLarge;
    @FXML
    private Button undoBtn;
    @FXML
    private Button clrBtn;
    @FXML
    private Pane drawingAreaPane;
    private Color currentColor = Color.BLACK;
    private PenSize currentSize = PenSize.MEDIUM;
  @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioBtnBlack.setUserData(Color.BLACK);
        radioBtnRed.setUserData(Color.RED);
        radioBtnGreen.setUserData(Color.GREEN);
        radioBtnBlue.setUserData(Color.BLUE);

        radioBtnSizeSmall.setUserData(PenSize.SMALL);
        radioBtnSizeMedium.setUserData(PenSize.MEDIUM);
        radioBtnSizeLarge.setUserData(PenSize.LARGE);

        radioBtnBlack.setSelected(true);
        radioBtnSizeMedium.setSelected(true);
    }

    /**
     * Initializes the controller class.
     */
     @FXML
    private void colorRadioButtonSelected() {
        currentColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private void sizeRadioButtonSelected() {
        currentSize = (PenSize) penSizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private void undoButtonPressed() {
        int total = drawingAreaPane.getChildren().size();
        if (total > 0) drawingAreaPane.getChildren().remove(total - 1);
    }

    @FXML
    private void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
        
    }

    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        Circle dot = new Circle(event.getX(), event.getY(), currentSize.getValue(), currentColor);
        drawingAreaPane.getChildren().add(dot);
    }
    
}
