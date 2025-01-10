package Uas.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Uas.controller.RegisterController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame{
    private JPanel mainPanel, inputJPanel;
    private JLabel telepon, password, address, name, logoLabel, logoLabel2;
    private JTextField phoneField, addressField, nameField;
    private JPasswordField passwordValue;
    private JButton register;


    public Register(){
        super("Register");
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

        name = new JLabel("Name  :");
        name.setForeground(Color.blue);
        name.setFont(new Font("Arial", Font.BOLD, 24));

        address = new JLabel("Address  :");
        address.setForeground(Color.blue);
        address.setFont(new Font("Arial", Font.BOLD, 24));

        telepon = new JLabel("Telepon  :");
        telepon.setForeground(Color.blue);
        telepon.setFont(new Font("Arial", Font.BOLD, 24));

        password = new JLabel("Password  :");
        password.setForeground(Color.blue);
        password.setFont(new Font("Arial", Font.BOLD, 24));

        phoneField =  new JTextField(10);
        phoneField.setFont(new Font("Arial", Font.PLAIN, 20));

        nameField =  new JTextField(10);
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));

        addressField =  new JTextField(10);
        addressField.setFont(new Font("Arial", Font.PLAIN, 20));

        passwordValue = new JPasswordField(10);
        passwordValue.setFont(new Font("Arial", Font.PLAIN, 20));
        
        register = new JButton("register");
        register.setFont(new Font("Arial", Font.BOLD, 24));
        register = new JButton("Register");
        register.setFont(new Font("Arial", Font.BOLD, 24));

        inputJPanel = new JPanel(new GridLayout(6,2,30,30));
        inputJPanel.setOpaque(false);

        inputJPanel.add(logoLabel);
        inputJPanel.add(logoLabel2);


        inputJPanel.add(name);
        inputJPanel.add(nameField);
        inputJPanel.add(address);
        inputJPanel.add(addressField);
        inputJPanel.add(telepon);
        inputJPanel.add(phoneField);
        inputJPanel.add(password);
        inputJPanel.add(passwordValue);
        inputJPanel.add(register);
        inputJPanel.add(register);
        

        mainPanel.add(inputJPanel);
        add(mainPanel);

   
         register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                        
            if (phoneField.getText().trim().isEmpty() || new String(passwordValue.getPassword()).trim().isEmpty() || nameField.getText().trim().isEmpty() || addressField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Isi semua field");
                }else{

               RegisterController registerController = new RegisterController();
               boolean register = registerController.register(phoneField.getText(), new String(passwordValue.getPassword()), nameField.getText(), addressField.getText());

               if (register) {
                    new Login();
                    dispose();
               }
            }
        }

        });


        setVisible(true);
    }

    public static void main(String[] args) {
        new Register();
    }
}
