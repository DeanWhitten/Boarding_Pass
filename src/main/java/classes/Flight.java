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

    private double arrivalTime;
    private double flightDur;


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
}

