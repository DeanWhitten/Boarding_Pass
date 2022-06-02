package com.example.boarding_pass;


import classes.Locations;
import classes.Passenger;
import classes.TravelTimes;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static javafx.collections.FXCollections.observableArrayList;

public class HelloController {
     Locations Locations;
     TravelTimes tTimes;
     Passenger passenger;
    public GridPane flightEstimateBox;
    public Label outputFlightTime;
    public Label outputArrivalTime;
    public Label outputFlightDuration;
    public Label outputTicketPrice;
    public Label outputLadiesDiscountAmount;
    public Label outputAgeDiscountAmount;
    public Label outputTotalCost;
    public Button bookFlight_btn;

    
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputAge;
    @FXML
    private ChoiceBox<String> inputGenderSelection;
    @FXML
    private TextField inputPhoneNumber;
    @FXML
    private TextField inputEmail;
    @FXML
    private DatePicker inputDate;
    @FXML
    private ChoiceBox<String> inputOrigin;
    @FXML
    private ChoiceBox<String> inputDestination;
    @FXML
    private ChoiceBox<String> inputDepartTime;
    @FXML
    private Button estimate_btn;




    public void initialize(){
        Locations locations = new Locations();
        TravelTimes tTimes = new TravelTimes();
        Passenger passenger = new Passenger();



        inputGenderSelection.getItems().addAll("Male", "Female");

        inputOrigin.getItems().addAll(observableArrayList(locations.locationNamesList()));
        inputDestination.getItems().addAll(observableArrayList(locations.locationNamesList()));
        inputDepartTime.getItems().addAll(observableArrayList(tTimes.listOfDepartureTimes()));

    }
    


    public void onEstimateButtonPress(MouseEvent mouseEvent) {
        int validInputs = 0;

        if(inputName.getText().isEmpty()){
            inputName.requestFocus();
        }else{
           validInputs++;
        }

        if(inputAge.getText().isEmpty() || !inputAge.getText().matches("\\d*")){
            inputAge.setText("");
            inputAge.requestFocus();
        }else{
            validInputs++;
        }

        if(inputGenderSelection.getValue() == null){
           inputGenderSelection.requestFocus();
        }else{
            validInputs++;
        }
        
        


        if (validInputs == 9){
            passenger.setName(inputName.getText());
            passenger.setAge(Integer.parseInt(inputAge.getText()));
            passenger.setGender((inputGenderSelection.getValue().toLowerCase()));
            passenger.setPhoneNum(inputPhoneNumber.getText());


            flightEstimateBox.setOpacity(1);

        }

    }

    public void onBookFlightButtonPress(MouseEvent mouseEvent) {
    }



}