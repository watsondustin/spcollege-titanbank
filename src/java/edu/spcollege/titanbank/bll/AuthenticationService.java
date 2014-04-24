/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.titanbank.bll;

import java.util.ArrayList;

/**
 *
 * @author Dustin
 */
public class AuthenticationService {

    public final IUserRepository userRepo;
    private ArrayList<User> loggedIn;

    public AuthenticationService(IUserRepository userRepository) {
        this.userRepo = userRepository;
        loggedIn = new ArrayList<>();
    }

    public Customer login(String username, String password) throws UserNotFoundException, InvalidPasswordException {
        Customer cust;
        User user = this.userRepo.findByUserName(username);
        if (user == null) {
            throw new UserNotFoundException();
        }

        if (user.isValidPassword(password)) {
            cust = user.getCustomer();
            loggedIn.add(user);

        } else 
            throw new InvalidPasswordException();
        return cust;
    }

    public void logout(String username){
        User u = find(username);
        if (u != null){
                loggedIn.remove(u);
        }
    }
    
    public boolean isLoggedIn(String username){
       return find(username) != null;
    }
    
    private User find(String username){
        for(User u: loggedIn){
            if (u.getUserName().equals(username))
                return u;
        }
        return null;
    }
}

