package Uas.model.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Customer {
    private int id;
    private String password;
    private String name;
    private String address;
    private String phone;

    
    public Customer(int id, String password, String name, String address, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }


     public static boolean Login(String phone, String password){
        String query = "SELECT * FROM customer WHERE phone = ? and password = ?";

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement st = con.prepareStatement(query)) {

            st.setString(1, phone);
            st.setString(2, password);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return true;
                }else{
                    return false;
                }
            }
        }catch (Exception ex) {
            System.out.println("Terjadi kesalahan: " + ex.getMessage());
            return false;
        }
    } 

     public static Customer getData(String phone, String password){
        String query = "SELECT * FROM customer WHERE phone = ? and password = ?";

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement st = con.prepareStatement(query)) {

            st.setString(1, phone);
            st.setString(2, password);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new Customer(rs.getInt("id"), 
                                rs.getString("password"), 
                                rs.getString("name")
                                , rs.getString("address")
                                , rs.getString("phone"));
                }
            }
        }catch (Exception ex) {
            System.out.println("Terjadi kesalahan: " + ex.getMessage());
            return null;
        }
        return null;
    } 

    public static boolean Register(Customer customer) {
        String query = "INSERT INTO `customer`(`id`, `password`, `name`, `address`, `phone`) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement st = con.prepareStatement(query)) {

            st.setInt(1, customer.getId());
            st.setString(2, customer.getPassword());
            st.setString(3, customer.getName());
            st.setString(4, customer.getAddress());
            st.setString(5, customer.getPhone());


            int rowsInserted = st.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception ex) {
            System.out.println("Terjadi kesalahan saat registrasi: " + ex.getMessage());
            return false;
        }
    }


}
