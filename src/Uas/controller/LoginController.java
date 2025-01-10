package Uas.controller;

import javax.swing.JOptionPane;

import Uas.model.classes.Customer;
import Uas.model.classes.SingletonManager;

public class LoginController {

    public boolean checkLogin(String phone, String pass){

         if (Customer.Login(phone, pass)) {
            Customer User = Customer.getData(phone, pass); 
            SingletonManager.getInstance().setCustomer(User);
            JOptionPane.showMessageDialog(null, "Login berhasil");
           return true;
        }else{
            JOptionPane.showMessageDialog(null, "No Phone atau Password salah");
            return false;
        }
        
    }

}
