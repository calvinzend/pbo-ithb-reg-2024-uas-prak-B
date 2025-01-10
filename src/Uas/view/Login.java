package Uas.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Uas.controller.LoginController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel mainPanel, inputJPanel;
    private JLabel telepon, password, logoLabel, logoLabel2;
    private JTextField phoneField;
    private JPasswordField passwordValue;
    private JButton login, register;


    public Login(){
        super("Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setFont(new Font("Arial", Font.BOLD, 30));

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.PINK);

        ImageIcon logoIcon = new ImageIcon("src/Uas/view/gambar/logo.jpg");
        Image scaledImage = logoIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(scaledImage);
        logoLabel = new JLabel(logoIcon);

        ImageIcon logoIcon2 = new ImageIcon("src/Uas/view/gambar/motor.jpg");
        Image scaledImage2 = logoIcon2.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        logoIcon2 = new ImageIcon(scaledImage2);
        logoLabel2 = new JLabel(logoIcon2);

        telepon = new JLabel("Telepon  :");
        telepon.setForeground(Color.blue);
        telepon.setFont(new Font("Arial", Font.BOLD, 24));

        password = new JLabel("Password  :");
        password.setForeground(Color.blue);
        password.setFont(new Font("Arial", Font.BOLD, 24));

        phoneField =  new JTextField(10);
        phoneField.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordValue = new JPasswordField(10);
        passwordValue.setFont(new Font("Arial", Font.PLAIN, 20));
        
        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.BOLD, 24));
        register = new JButton("Register");
        register.setFont(new Font("Arial", Font.BOLD, 24));

        inputJPanel = new JPanel(new GridLayout(4,2,30,30));
        inputJPanel.setOpaque(false);


        inputJPanel.add(logoLabel);
        inputJPanel.add(logoLabel2);
        inputJPanel.add(telepon);
        inputJPanel.add(phoneField);
        inputJPanel.add(password);
        inputJPanel.add(passwordValue);
        inputJPanel.add(login);
        inputJPanel.add(register);
        

        mainPanel.add(inputJPanel);
        add(mainPanel);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               LoginController loginController = new LoginController();
               boolean login = loginController.checkLogin(phoneField.getText(), new String(passwordValue.getPassword()));

               if (login) {
                    new Trasaksi();
                    dispose();
               }
            }

        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
              new Register();
              dispose();
            }

        });


        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
