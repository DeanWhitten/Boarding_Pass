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
    private int flightDurInMin;


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

    public int getFlightDurInMin() {
        return flightDurInMin;
    }

    public void setFlightDurInMin(int flightDurInMin) {
        this.flightDurInMin = flightDurInMin;
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

        int durInMins = (int) (dist / mph) * 60;

        setFlightDurInMin(durInMins);

    }
}

