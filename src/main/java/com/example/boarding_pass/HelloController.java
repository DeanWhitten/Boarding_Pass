package com.example.boarding_pass;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static javafx.collections.FXCollections.observableArrayList;

public class HelloController {
    private ArrayList<String[]> strLocationArrayList = new ArrayList<>();

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
    private ChoiceBox<LocalTime> inputDepartTime;
    @FXML
    private Button estimate_btn;




    public void initialize(){
        parseLocationsText();
        
        
        
        
        ArrayList<String> originNameList = new ArrayList<>();
        assignOriginNames(originNameList);
        inputOrigin.getItems().addAll(observableArrayList(originNameList));
        
        ArrayList<String> destNameList = new ArrayList<>();
        assignDestNames(destNameList, originNameList);
        inputDestination.getItems().addAll(destNameList);

    }
    
    public void onBookFlightButtonPress(MouseEvent mouseEvent) {
    }

    public void onEstimateButtonPress(MouseEvent mouseEvent) {
        if (flightEstimateBox.getOpacity() == 0){
            flightEstimateBox.setOpacity(1);
        }

    }

    public void parseLocationsText(){
        String callFileStr;
        try {
            File callFile = new File("src/main/resources/locations.txt");
            Scanner reader = new Scanner(callFile);
            while (reader.hasNextLine()) {
                callFileStr = reader.nextLine();
                String[] textLine = callFileStr.split(",");
                strLocationArrayList.add(textLine);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private void assignOriginNames(ArrayList<String> originNameList) {
        for (String[] strItem : strLocationArrayList){
            String newPlace =   strItem[1] + ", " + strItem[0];
            originNameList.add(newPlace);
        }
        Collections.sort(originNameList);
    }

    private void assignDestNames(ArrayList<String> destNameList,
                                 ArrayList<String> originNameList) {
        for(String oL : originNameList){
                destNameList.add(oL);
        }
    }
}