package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class BoardingPass {
    private UUID boardingPassNumber;
    private LocalDate date;
    private String origin;
    private String destination;
    private LocalTime departTime;
    private LocalTime arrivalTime;

    private String name;
    private int age;
    private String gender;
    private String phoneNum;
    private String email;

    private double totalCost;

    public UUID getBoardingPassNumber() {
        return boardingPassNumber;
    }

    public void setBoardingPassNumber(UUID boardingPassNumber) {
        this.boardingPassNumber = boardingPassNumber;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }




    public void writePassToEntriesFile(){
        UUID uniqueKey = UUID.randomUUID();
        setBoardingPassNumber(uniqueKey);

        try {
            FileWriter myWriter = new FileWriter("src/main/resources/boardingPassEntries.txt");
            myWriter.write(boardingPassNumber + "*"
                    + date + "*" + origin + "*" + destination + "*" + arrivalTime
                    + "*" + name + "*" + email + "*" + phoneNum + "*" +  gender
                    + "*" + age + "*" + totalCost
            );
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



}
