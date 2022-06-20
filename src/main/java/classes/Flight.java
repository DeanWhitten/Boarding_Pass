package classes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private LocalDate date;
    private String origin;
    private String destination;
    private LocalTime departTime;

    private double originLAT;
    private double originLONG;
    private double destinationLAT;
    private double destinationLONG;

    private double distance;

    private LocalTime arrivalTime;
    private int flightDurationMins;
    private int flightDurationHours;

    private double ticketPrice;
    private double genderDiscount;
    private double ageDiscount;
    private double totalCost;



    public void flight(){
      this.date = date;
      this.origin = origin;
      this.destination = destination;
      this.departTime = departTime;
    }



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public LocalTime getDepartTime() {
        return departTime;
    }

    public void setDepartTime(LocalTime departTime) {
        this.departTime = departTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getFlightDurationMins() {
        return flightDurationMins;
    }

    public void setFlightDurationMins(int flightDurationMins) {
        this.flightDurationMins = flightDurationMins;
    }


    public double getOriginLAT() {
        return originLAT;
    }

    public void setOriginLAT(double originLAT) {
        this.originLAT = originLAT;
    }

    public double getOriginLONG() {
        return originLONG;
    }

    public void setOriginLONG(double originLONG) {
        this.originLONG = originLONG;
    }

    public double getDestinationLAT() {
        return destinationLAT;
    }

    public void setDestinationLAT(double destinationLAT) {
        this.destinationLAT = destinationLAT;
    }

    public double getDestinationLONG() {
        return destinationLONG;
    }

    public void setDestinationLONG(double destinationLONG) {
        this.destinationLONG = destinationLONG;
    }

    public int getFlightDurationHours() {
        return flightDurationHours;
    }

    public void setFlightDurationHours(int flightDurationHours) {
        this.flightDurationHours = flightDurationHours;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getGenderDiscount() {
        return genderDiscount;
    }

    public void setGenderDiscount(double genderDiscount) {
        this.genderDiscount = genderDiscount;
    }

    public double getAgeDiscount() {
        return ageDiscount;
    }

    public void setAgeDiscount(double ageDiscount) {
        this.ageDiscount = ageDiscount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    public void calculateDistance(){
        double lat1 = originLAT;
        double lon1 = originLONG;
        double lat2 = destinationLAT;
        double lon2 = destinationLONG;

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        setDistance(dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public void calculateDuration(){
        double dist = getDistance();
        double mph = 500;

        int totalDurInMins = (int) (dist / mph) * 60;
        setFlightDurationMins(totalDurInMins);
        setFlightDurationHours(totalDurInMins/60);

        setArrivalTime(getDepartTime().plusMinutes(totalDurInMins));
    }

    public void calculateBaseTicketPrice(){
        double dist = getDistance();
        double costPerMile = .20;
        
        setTicketPrice(dist * costPerMile);
    }


    public void calculateDiscounts(int age, String gender) {
        double basePrice = getTicketPrice();
        if(age <= 12){
           setAgeDiscount(basePrice * .50);
        } else if (age >= 60 ) {
           setAgeDiscount(basePrice * .60);
        }else{
            setAgeDiscount(0.00);
        }
        basePrice -= getAgeDiscount();
        setTotalCost(basePrice);

        if(gender.equals("female")){
           setGenderDiscount(basePrice * .25);
        }else{
            setGenderDiscount(0.00);
        }

        basePrice -= getGenderDiscount();
        setTotalCost(basePrice);
    }
}

