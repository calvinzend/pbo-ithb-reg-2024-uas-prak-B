package Uas.controller;

import javax.swing.JOptionPane;

import Uas.model.classes.Customer;

public class RegisterController {

    public boolean register(String phone, String pass, String name, String address){

   
        Customer customer = new Customer(0, pass, name, address, phone);

         if (Customer.Register(customer)){
            JOptionPane.showMessageDialog(null, "Register berhasil");
           return true;
        }else{
            JOptionPane.showMessageDialog(null, "Gagal Register");
            return false;
        }
        
    }

}
