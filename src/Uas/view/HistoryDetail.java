package Uas.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Uas.model.classes.Delivery_Details;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HistoryDetail extends JFrame {
    private JPanel mainPanel;
    private JTable history;
    private DefaultTableModel tableModel;
    private JButton backButton;

    public HistoryDetail(int transaction_id) {
        super("History Detail");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setFont(new Font("Arial", Font.BOLD, 30));

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.PINK);

        String[] columnNames = {"status", "evidence", "date", "updated_by"};
        tableModel = new DefaultTableModel(columnNames, 0);
        history = new JTable(tableModel);
        history.setForeground(Color.PINK);
        history.setFont(new Font("Arial", Font.PLAIN, 16));
        history.setRowHeight(30);
        history.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        history.getTableHeader().setBackground(Color.PINK);
        history.getTableHeader().setForeground(Color.BLUE);
        history.setBackground(Color.PINK);
        history.setForeground(Color.BLUE);

        JScrollPane scrollPane = new JScrollPane(history);
        // scrollPane.getViewport().setBackground(Color.PINK);
        scrollPane.setBackground(Color.PINK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;  
        gbc.weightx = 1.0;  
        gbc.weighty = 1.0;  
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        mainPanel.add(scrollPane, gbc);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBackground(Color.PINK);
        backButton.setForeground(Color.BLUE);
        backButton.setFocusPainted(false);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.PINK);
        buttonPanel.add(backButton);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0;  
        gbc.gridx = 0;
        gbc.gridy = 1;  
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        Data(transaction_id);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               new MenuUtama();
               dispose();
            }

        });


        add(mainPanel);

        setVisible(true);
    }

    private void Data(int tr) {
        ArrayList<Delivery_Details> delivery_Details =Delivery_Details.getHistory(tr);
        if (delivery_Details != null) {
            for (Delivery_Details details : delivery_Details) {
                Object[] rowData = {
                    details.getStatus(),
                    details.getCurrent_position(),
                    details.getEvidence(),
                    details.getDate(),
                    details.getUpdated_by()
                };
                tableModel.addRow(rowData);
            }
        }
    }

 
}
