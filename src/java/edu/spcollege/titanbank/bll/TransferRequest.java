/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

/**
 *
 * @author Dustin
 */
public class TransferRequest {
    
    private BankAccount source;
    private BankAccount destination;
    private ScheduleType whenTo;
    private double amt;
    private TransferStatus status;

    public enum ScheduleType{
        IMMEDIATELY,
        FUTURE
    }
    public enum TransferStatus{
        PENDING,
        COMPLETED
    }
    public TransferRequest(BankAccount from, BankAccount to, ScheduleType when, double amt){
        this.source = from;
        this.destination = to;
        this.whenTo = when;
        this.amt = amt;
        this.status = TransferStatus.PENDING;
    }
    public BankAccount getSource() {
        return source;
    }

    public BankAccount getDestination() {
        return destination;
    }

    public ScheduleType getWhenTo() {
        return whenTo;
    }
    
    public double getAmount(){
        return this.amt;
    }
    public TransferStatus getStatus(){
        return this.status;
    }
    
    public void completeTransaction(){
        this.status = TransferStatus.COMPLETED;
    }
}
