package com.example.boarding_pass;


import classes.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


import java.time.LocalTime;


import static javafx.collections.FXCollections.observableArrayList;

public class HelloController {
     Locations locations = new Locations();
     TravelTimes tTimes = new TravelTimes();
     Passenger passenger = new Passenger();
     Flight flight = new Flight();

     BoardingPass boardingPass = new BoardingPass();

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
        
       if(inputPhoneNumber.getText().isEmpty() || !inputPhoneNumber.getText().matches("\\d*") || inputPhoneNumber.getText().length() != 10){
           inputPhoneNumber.setText("");
           inputPhoneNumber.requestFocus();
       }else{
           validInputs++;
       }

       if(inputEmail.getText().isEmpty() || !(inputEmail.getText().contains("@") && inputEmail.getText().contains("."))){
         inputEmail.setText("");
         inputEmail.requestFocus();
       }else{
           validInputs++;
       }

       if(inputDate.getValue() == null){
           inputDate.requestFocus();
       }else{
           validInputs++;
       }

       if(inputOrigin.getValue() == null){
           inputOrigin.requestFocus();
       }else{
           validInputs++;
       }

       if (inputDestination.getValue() == null || inputDestination.getValue().equals(inputOrigin.getValue()) ){
           inputDestination.setValue(null);
           inputDestination.requestFocus();
       }else{
           validInputs++;
       }

       if(inputDepartTime.getValue() == null){
           inputDepartTime.requestFocus();
       }else {
           validInputs++;
       }

        if (validInputs == 9){
            passenger.setName(inputName.getText());
            passenger.setAge(Integer.parseInt(inputAge.getText()));
            passenger.setGender((inputGenderSelection.getValue().toLowerCase()));
            passenger.setPhoneNum(inputPhoneNumber.getText());
            passenger.setEmail(inputEmail.getText());

            flight.setDate(inputDate.getValue());
            flight.setOrigin(inputOrigin.getValue());
            flight.setDestination(inputDestination.getValue());
            flight.setDepartTime(LocalTime.parse(inputDepartTime.getValue()));

            flight.setOriginLAT(locations.findLocationLAT(flight.getOrigin()));
            flight.setOriginLONG(locations.findLocationLONG(flight.getOrigin()));
            flight.setDestinationLAT(locations.findLocationLAT(flight.getDestination()));
            flight.setDestinationLONG(locations.findLocationLONG(flight.getDestination()));
            flight.calculateDistance();
            flight.calculateDuration();
            flight.calculateBaseTicketPrice();
            flight.calculateDiscounts(passenger.getAge(), passenger.getGender());

            outputFlightTime.setText(String.valueOf(flight.getDepartTime()));
            outputArrivalTime.setText(String.valueOf(flight.getArrivalTime()));
            outputFlightDuration.setText(flight.getFlightDurationMins() + "Ms");
            
            outputTicketPrice.setText("$" + String.format("%.2f",flight.getTicketPrice()));
            outputAgeDiscountAmount.setText("-" + String.format("%.2f", flight.getAgeDiscount()));
            outputLadiesDiscountAmount.setText("-" + String.format("%.2f", flight.getGenderDiscount()));
            outputTotalCost.setText("$" + String.format("%.2f", flight.getTotalCost()));

            flightEstimateBox.setOpacity(1);
        }

    }

    public void onBookFlightButtonPress(MouseEvent mouseEvent) {
       boardingPass.setDate(flight.getDate());
       boardingPass.setOrigin(flight.getOrigin());
       boardingPass.setDestination(flight.getDestination());
       boardingPass.setDepartTime(flight.getDepartTime());
       boardingPass.setArrivalTime(flight.getArrivalTime());

       boardingPass.setName(passenger.getName());
       boardingPass.setAge(passenger.getAge());
       boardingPass.setGender(passenger.getGender());
       boardingPass.setPhoneNum(passenger.getPhoneNum());
       boardingPass.setEmail(passenger.getEmail());

       boardingPass.setTotalCost(flight.getTotalCost());
       boardingPass.writePassToEntriesFile();
    }



}