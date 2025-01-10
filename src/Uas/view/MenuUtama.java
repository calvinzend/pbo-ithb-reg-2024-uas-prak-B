package Uas.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuUtama extends JFrame{

    private JButton login, register, trasaksiPengiriman, history;
    private JPanel mainPanel, buttonPanel;


    public MenuUtama(){
        super("Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setFont(new Font("Arial", Font.BOLD, 30));

        
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.PINK);

 
        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.BOLD, 24));
        register = new JButton("Register");
        register.setFont(new Font("Arial", Font.BOLD, 24));
        trasaksiPengiriman = new JButton("Trasaksi Pengiriman");
        trasaksiPengiriman.setFont(new Font("Arial", Font.BOLD, 24));
        history = new JButton("History");
        history.setFont(new Font("Arial", Font.BOLD, 24));

        buttonPanel = new JPanel(new GridLayout(1,4,30,30));
        buttonPanel.setOpaque(false);

        buttonPanel.add(login);
        buttonPanel.add(register);
        buttonPanel.add(trasaksiPengiriman);
        buttonPanel.add(history);

        mainPanel.add(buttonPanel);
        add(mainPanel);

        
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Login();
                dispose();
            }

        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Register();
                dispose();
            }

        });
        trasaksiPengiriman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Trasaksi();
                dispose();
            }

        });
        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Login();
                dispose();
            }

        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuUtama();    
    }
}
    