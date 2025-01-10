package Uas.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Uas.model.classes.Delivery_Details;
import Uas.model.classes.Transaction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HistoryTransaksi extends JFrame {
    private JPanel mainPanel;
    private JTable history;
    private DefaultTableModel tableModel;
    private JButton backButton;
    private JButton detailButton;

    public HistoryTransaksi() {
        super("History Transaksi");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setFont(new Font("Arial", Font.BOLD, 30));

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.PINK);

        String[] columnNames = {"transaction_id", "delivery_type", "delivery_fee", "total_cost", "created_at", "updated_at"};
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

        detailButton = new JButton("Detail");
        detailButton.setFont(new Font("Arial", Font.BOLD, 20));
        detailButton.setBackground(Color.PINK);
        detailButton.setForeground(Color.BLUE);
        detailButton.setFocusPainted(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.PINK);
        buttonPanel.add(backButton);
        buttonPanel.add(detailButton);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0;  
        gbc.gridx = 0;
        gbc.gridy = 1;  
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        Data();

        detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedRow = history.getSelectedRow();
                if (selectedRow >= 0) {
                    int transactionId = (int) tableModel.getValueAt(selectedRow, 0);
                    new HistoryDetail(transactionId);  
                    dispose();
                }
            }
        });
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

    private void Data() {
        ArrayList<Transaction> transactions = Transaction.getData();
        if (transactions != null) {
            for (Transaction transaction : transactions) {
                Object[] rowData = {
                    transaction.getId(),
                    transaction.getDelivery_type(),
                    transaction.getExpected_weight(),
                    transaction.getTotal_cost(),
                    transaction.getCreated_at(),
                    Delivery_Details.getUpdatedBy(transaction.getId())
                };
                tableModel.addRow(rowData);
            }
        }
    }
    public static void main(String[] args) {
        new HistoryTransaksi();
    }

}
