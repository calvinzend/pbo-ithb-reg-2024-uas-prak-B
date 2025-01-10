package Uas.model.classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

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
        String query = "INSERT INTO `transaction`(`id`, `customer_id`, `delivery_type`, `expected_weight`, `total_cost`, `created_at`, `receipt_name`, `receipt_address`, `receipt_phone`)) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement st = con.prepareStatement(query)) {
            Customer user = SingletonManager.getInstance().getCustomer();

            LocalDateTime now = LocalDateTime.now();  
            st.setInt(1, 0);
            st.setInt(2, user.getId());
            st.setString(3, type);
            st.setInt(4, Integer.parseInt(berat));
            st.setString(5, null);
            st.setDate(6, null);
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


}
