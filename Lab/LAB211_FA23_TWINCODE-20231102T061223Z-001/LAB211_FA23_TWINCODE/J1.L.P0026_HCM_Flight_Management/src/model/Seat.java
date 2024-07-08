/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Seat {
    private String seatNumber;
    private boolean isOccupied;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isOccupied = false;
    }

    public Seat() {
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy() {
        isOccupied = true;
    }

    @Override
    public String toString() {
        return seatNumber+"," + isOccupied;
    }
    
    
}