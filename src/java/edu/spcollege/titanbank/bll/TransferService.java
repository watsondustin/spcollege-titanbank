/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dustin
 */
public class TransferService {
    
    ArrayList<TransferRequest> transactions;
    
    public TransferService(){
        transactions = new ArrayList<>();
    }
    
    public void tranfer(TransferRequest request){
        if (request.getWhenTo() == TransferRequest.ScheduleType.FUTURE)
            transactions.add(request);
        else{
            try {
                request.getSource().withdraw(request.getAmount());
                request.getDestination().deposit(request.getAmount());
                request.completeTransaction();
                transactions.add(request);
            } catch (InsufficientFundsException ex) {
                Logger.getLogger(TransferService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public List getTransactions(TransferRequest.TransferStatus status){
        ArrayList<TransferRequest> results = new ArrayList<>();
        for(TransferRequest request: transactions){
            if(request.getStatus() == status)
                results.add(request);
        }
        return Collections.unmodifiableList(results);
    }
}
