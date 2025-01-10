package Uas.model.classes;

public class SingletonManager {
    private static SingletonManager instance;
    private Customer customer;

    SingletonManager() {
    }

    public static SingletonManager getInstance() {
        if (instance == null) {
            instance = new SingletonManager();
        }
        return instance;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
   

 

}