/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author bravee06
 */
public class Flight {
    // số hiệu chuyến bay 
    private String flightNumber;
    // nơi bắt đầu 
    private String departureCity;
    // nơi đến 
    private String destinationCity;
    // thơi gian bắt đầu 
    private String departureTime;
    // thơi gian đến 
    private String arrivalTime;
    
    private List<Seat> seats;

    private List<Crew> assignedCrewMembers;
    
    public Flight() {
    }

    public Flight(String flightNumber, String departureCity, String destinationCity, String departureTime, String arrivalTime, List<Seat> seats) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = seats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
    
    
    public void assignCrewMember(Crew crewMember) {
        assignedCrewMembers.add(crewMember);
    }

    /*
     // số hiệu chuyến bay 
    private String flightNumber;
    // nơi bắt đầu 
    private String departureCity;
    // nơi đến 
    private String destinationCity;
    // thơi gian bắt đầu 
    private String departureTime;
    // thơi gian đến 
    private String arrivalTime;
    
    private List<Seat> seats;

    private List<Crew> assignedCrewMembers;
    
    */
    
    @Override
    public String toString() {
        String firstData = flightNumber + "," + departureCity + ","+ destinationCity + ","+ departureTime + ","+ arrivalTime + ",";
       
        for(Seat s : this.seats){
           firstData += "{"+s.toString()+"}" + ",";
        }
        for(Crew c : assignedCrewMembers){
            firstData += "{"+c.toString()+"}" + ",";
        }
        return firstData;
    }

    
    
    
    
}
