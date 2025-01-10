package Uas.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Uas.model.classes.Delivery_Details;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDetail extends JFrame{
    private JLabel transaction_id, status, evidence, current_position,updated_by;
    private JTextField transaction_idField, current_positionField,  evidenceField, updated_byField;
    private JComboBox<String> statusField;
    private JButton back, simpan;
    private JPanel mainPanel, inputJPanel;


    public AddDetail(){
        super("Transaksi");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setFont(new Font("Arial", Font.BOLD, 30));

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.PINK);

        transaction_id = new JLabel("Transaction id  :");
        transaction_id.setForeground(Color.blue);
        transaction_id.setFont(new Font("Arial", Font.BOLD, 24));

        status = new JLabel("Status  :");
        status.setForeground(Color.blue);
        status.setFont(new Font("Arial", Font.BOLD, 24));

        current_position = new JLabel("Current position  :");
        current_position.setForeground(Color.blue);
        current_position.setFont(new Font("Arial", Font.BOLD, 24));

        evidence = new JLabel("Evidence  :");
        evidence.setForeground(Color.blue);
        evidence.setFont(new Font("Arial", Font.BOLD, 24));

        updated_by = new JLabel("Update by  :");
        updated_by.setForeground(Color.blue);
        updated_by.setFont(new Font("Arial", Font.BOLD, 24));

        simpan = new JButton("Simpan");
        simpan.setFont(new Font("Arial", Font.BOLD, 24));

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 24));

        
        transaction_idField =  new JTextField(10);
        transaction_idField.setFont(new Font("Arial", Font.PLAIN, 20));

        current_positionField =  new JTextField(10);
        current_positionField.setFont(new Font("Arial", Font.PLAIN, 20));

        String statuString[] = {"PENDING", "IN_PROGRESS", "ON_DELIVERY", "ARRIVED"};
        statusField =  new JComboBox<>(statuString);
        statusField.setFont(new Font("Arial", Font.PLAIN, 20));

        evidenceField =  new JTextField(10);
        evidenceField.setFont(new Font("Arial", Font.PLAIN, 20));

        updated_byField =  new JTextField(10);
        updated_byField.setFont(new Font("Arial", Font.PLAIN, 20));



        inputJPanel = new JPanel(new GridLayout(8,2,30,30));
        inputJPanel.setOpaque(false);

        inputJPanel.add(transaction_id);
        inputJPanel.add(transaction_idField);
        inputJPanel.add(status);
        inputJPanel.add(statusField);
        inputJPanel.add(current_position);
        inputJPanel.add(current_positionField);
        inputJPanel.add(evidence);
        inputJPanel.add(evidenceField);
        inputJPanel.add(updated_by);
        inputJPanel.add(updated_byField);
        inputJPanel.add(simpan);
        inputJPanel.add(back);


        simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                if (transaction_idField.getText().trim().isEmpty() || current_positionField.getText().trim().isEmpty() || updated_byField.getText().trim().isEmpty() || evidenceField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Mohon diisi semua");
                    
                }else{
 
                    boolean delivery_details = Delivery_Details.addDetail(Integer.parseInt(transaction_idField.getText()),   (String) statusField.getSelectedItem(),current_positionField.getText(), evidenceField.getText(), updated_byField.getText());

                        if (delivery_details) {
                             JOptionPane.showMessageDialog(null, "Berhasil ditambah");
                             new Trasaksi();
                             dispose();
                        }else{
                             JOptionPane.showMessageDialog(null, "Gagal ditambah");
                        }
                    
                }
            }

        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               new Trasaksi();
               dispose();
            }

        });

        mainPanel.add(inputJPanel);

        add(mainPanel);
        setVisible(true);

    }


}
