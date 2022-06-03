package classes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private LocalDate date;
    private String origin;
    private String destination;
    private LocalTime departTime;

    private double distance;

    private double arrivalTime;
    private double flightDur;

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

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getFlightDur() {
        return flightDur;
    }

    public void setFlightDur(double flightDur) {
        this.flightDur = flightDur;
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
}

