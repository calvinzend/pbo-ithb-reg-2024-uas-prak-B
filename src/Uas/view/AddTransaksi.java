package Uas.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class AddTransaksi extends JFrame{
    private JLabel name, alamat, phone, berat, typeLabel;
    private JTextField nameField, alamatField, phoneField, beratField;
    private JComboBox type;
    private JButton back, simpan;
    private JPanel mainPanel, inputJPanel;


    public AddTransaksi(){
        super("Transaksi");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setFont(new Font("Arial", Font.BOLD, 30));

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.PINK);

        name = new JLabel("Name  :");
        name.setForeground(Color.blue);
        name.setFont(new Font("Arial", Font.BOLD, 24));

        alamat = new JLabel("Address  :");
        alamat.setForeground(Color.blue);
        alamat.setFont(new Font("Arial", Font.BOLD, 24));

        phone = new JLabel("Phone  :");
        phone.setForeground(Color.blue);
        phone.setFont(new Font("Arial", Font.BOLD, 24));

        berat = new JLabel("Berat  :");
        berat.setForeground(Color.blue);
        berat.setFont(new Font("Arial", Font.BOLD, 24));

        typeLabel = new JLabel("Type  :");
        typeLabel.setForeground(Color.blue);
        typeLabel.setFont(new Font("Arial", Font.BOLD, 24));

        simpan = new JButton("Simpan");
        simpan.setFont(new Font("Arial", Font.BOLD, 24));

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 24));

        
        nameField =  new JTextField(10);
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));

        alamatField =  new JTextField(10);
        alamatField.setFont(new Font("Arial", Font.PLAIN, 20));

        phoneField =  new JTextField(10);
        phoneField.setFont(new Font("Arial", Font.PLAIN, 20));

        beratField =  new JTextField(10);
        beratField.setFont(new Font("Arial", Font.PLAIN, 20));


        String typePengiriman[] = { "Building Materials" ,"House Moving","Instant Delivery"};

        type = new JComboBox(typePengiriman);

        inputJPanel = new JPanel(new GridLayout(8,2,30,30));
        inputJPanel.setOpaque(false);

        inputJPanel.add(name);
        inputJPanel.add(nameField);
        inputJPanel.add(alamat);
        inputJPanel.add(alamatField);
        inputJPanel.add(phone);
        inputJPanel.add(phoneField);
        inputJPanel.add(berat);
        inputJPanel.add(beratField);
        inputJPanel.add(typeLabel);
        inputJPanel.add(type);
        inputJPanel.add(simpan);
        inputJPanel.add(back);

        

        mainPanel.add(inputJPanel);

        add(mainPanel);
        setVisible(true);

    }


}
