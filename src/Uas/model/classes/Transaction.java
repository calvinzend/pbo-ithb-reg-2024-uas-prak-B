package Uas.model.classes;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaction {
    private int id;
    private int customer_id;
    private String delivery_type;
    private int expected_weight;
    private int total_cost;
    private Date created_at;
    private String receipt_name;
    private String receipt_address;
    private String receipt_phone;

    public Transaction(){}
    
    public Transaction(int id, int customer_id, String delivery_type, int expected_weight, int total_cost,
            Date created_at, String receipt_name, String receipt_address, String receipt_phone) {
        this.id = id;
        this.customer_id = customer_id;
        this.delivery_type = delivery_type;
        this.expected_weight = expected_weight;
        this.total_cost = total_cost;
        this.created_at = created_at;
        this.receipt_name = receipt_name;
        this.receipt_address = receipt_address;
        this.receipt_phone = receipt_phone;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public String getDelivery_type() {
        return delivery_type;
    }
    public void setDelivery_type(String delivery_type) {
        this.delivery_type = delivery_type;
    }
    public int getExpected_weight() {
        return expected_weight;
    }
    public void setExpected_weight(int expected_weight) {
        this.expected_weight = expected_weight;
    }
    public int getTotal_cost() {
        return total_cost;
    }
    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }
    public Date getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    public String getReceipt_name() {
        return receipt_name;
    }
    public void setReceipt_name(String receipt_name) {
        this.receipt_name = receipt_name;
    }
    public String getReceipt_address() {
        return receipt_address;
    }
    public void setReceipt_address(String receipt_address) {
        this.receipt_address = receipt_address;
    }
    public String getReceipt_phone() {
        return receipt_phone;
    }
    public void setReceipt_phone(String receipt_phone) {
        this.receipt_phone = receipt_phone;
    }

    public static boolean AddTransaksi(String name, String alamat, String phone, String berat, String type) {
        String query = "INSERT INTO `transaction`(`id`, `customer_id`, `delivery_type`, `expected_weight`, `total_cost`, `created_at`, `receipt_name`, `receipt_address`, `receipt_phone`) " +
               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement st = con.prepareStatement(query)) {
            Customer user = SingletonManager.getInstance().getCustomer();

            int cost = getCost(type) * Integer.parseInt(berat); 
            LocalDateTime now = LocalDateTime.now();
            st.setInt(1, 0);
            st.setInt(2, user.getId());
            st.setString(3, type);
            st.setInt(4, Integer.parseInt(berat));
            st.setInt(5, cost);
            st.setDate(6, java.sql.Date.valueOf(now.toLocalDate()));
            st.setString(7, name);    
            st.setString(8, alamat);    
            st.setString(9, phone);    


            int rowsInserted = st.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception ex) {
            System.out.println("Terjadi kesalahan saat registrasi: " + ex.getMessage());
            return false;
        }
    }

     public static int getCost(String type){
        String query = "SELECT * FROM cost WHERE type = ? ";

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement st = con.prepareStatement(query)) {

            st.setString(1, type);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("fee");
                }
            }
        }catch (Exception ex) {
            System.out.println("Terjadi kesalahan: " + ex.getMessage());
            return 0;
        }
        return 0;
    } 

     public static ArrayList<Transaction> getData(){
        String query = "SELECT * FROM transaction order by created_at DESC";
        ArrayList<Transaction> transactions =  new ArrayList<>();

        try (Connection con = ConnectionManager.getConnection();
            PreparedStatement st = con.prepareStatement(query)) {

            try (ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                    Transaction transaction = new Transaction();
                    transaction.setId(rs.getInt("id"));
                    transaction.setCustomer_id(rs.getInt("customer_id"));
                    transaction.setDelivery_type(rs.getString("delivery_type"));
                    transaction.setExpected_weight(rs.getInt("expected_weight"));
                    transaction.setTotal_cost(rs.getInt("total_cost"));
                    transaction.setCreated_at(new Date(rs.getTimestamp("created_at").getTime()));

                transactions.add(transaction);
                }
            }
        }catch (Exception ex) {
            System.out.println("Terjadi kesalahan: " + ex.getMessage());
        }
        return transactions;
    } 

    


}
