package Uas.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Uas.controller.LoginController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Trasaksi extends JFrame{
    private JButton addTrasaksi, addDetail, back;
    private JPanel mainPanel;


    public Trasaksi(){
        super("Transaksi");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setFont(new Font("Arial", Font.BOLD, 30));

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.PINK);
        

        addDetail = new JButton("add Detail");
        addDetail.setFont(new Font("Arial", Font.BOLD, 24));

        addTrasaksi = new JButton("add Transaksi");
        addTrasaksi.setFont(new Font("Arial", Font.BOLD, 24));

        back = new JButton("back");
        back.setFont(new Font("Arial", Font.BOLD, 24));

        mainPanel.add(addTrasaksi);
        mainPanel.add(new Label());
        mainPanel.add(addDetail);
        mainPanel.add(new Label());
        mainPanel.add(back);


         addTrasaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               new AddTransaksi();
               dispose();
            }

        });
         addDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               new AddDetail();
               dispose();
            }

        });
         back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               new MenuUtama();
               dispose();
            }

        });

        add(mainPanel);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Trasaksi();
    }

}
