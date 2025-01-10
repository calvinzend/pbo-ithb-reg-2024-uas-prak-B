package Uas.model.classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;


import Uas.model.enums.Status;

public class Delivery_Details {
    private int id;
    private int transaction_id;
    private Status status;
    private String current_position;
    private String evidence;
    private Date date;
    private String updated_by;

    public Delivery_Details(int id, int transaction_id, Status status, String current_position, String evidence,
            Date date, String updated_by) {
        this.id = id;
        this.transaction_id = transaction_id;
        this.status = status;
        this.current_position = current_position;
        this.evidence = evidence;
        this.date = date;
        this.updated_by = updated_by;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCurrent_position() {
        return current_position;
    }

    public void setCurrent_position(String current_position) {
        this.current_position = current_position;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public static boolean addDetail(int transactionId, String status, String currentPosition, String evidence,
            String updatedBy) {
        String query = "INSERT INTO `delivery_details` (transaction_id, status, current_position, evidence, date, updated_by) "
                +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement st = con.prepareStatement(query)) {

            LocalDateTime now = LocalDateTime.now();

            st.setInt(1, transactionId);
            st.setString(2, status);
            st.setString(3, currentPosition);
            st.setString(4, evidence);
            st.setDate(5, java.sql.Date.valueOf(now.toLocalDate()));
            st.setString(6, updatedBy);

            int rowsInserted = st.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception ex) {
            System.out.println("Error while adding delivery detail: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public static String getUpdatedBy(int transactionId) {
        String query = "SELECT updated_by FROM delivery_details WHERE transaction_id = ?";

        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement st = con.prepareStatement(query)) {

            st.setInt(1, transactionId);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("updated_by");
                } else {
                    return null;
                }
            }

        } catch (Exception ex) {
            System.out.println("Error while retrieving updated_by: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Delivery_Details> getHistory(int transactionId) {
        String query = "SELECT * FROM delivery_details WHERE transaction_id = ?";
        ArrayList<Delivery_Details> delivery_Details = new ArrayList<>();
    
        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement st = con.prepareStatement(query)) {
    
            st.setInt(1, transactionId);
    
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {

                    Status status = null;
                    try {
                        status = Status.valueOf(rs.getString("status"));
                    } catch (IllegalArgumentException e) {
                        System.out.println(" Error: " + rs.getString("status"));
                    }
    
                    Delivery_Details detail = new Delivery_Details(
                        rs.getInt("id"),
                        rs.getInt("transaction_id"),
                        status,  
                        rs.getString("current_position"),
                        rs.getString("evidence"),
                        new Date(rs.getTimestamp("date").getTime()), 
                        rs.getString("updated_by")
                    );
                    delivery_Details.add(detail);  
                }
    
            } catch (Exception ex) {
                System.out.println("Error while retrieving history: " + ex.getMessage());
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            System.out.println("Error while executing query: " + ex.getMessage());
            ex.printStackTrace();
        }
    
        return delivery_Details;  
    }


   
}
