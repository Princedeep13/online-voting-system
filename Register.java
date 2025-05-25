import javax.swing.*;

public class Register extends JFrame {
    public Register() {
        setTitle("Register");
        setSize(300, 200);
        setLayout(null);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(20, 20, 80, 25);
        add(lblUser);

        JTextField txtUser = new JTextField();
        txtUser.setBounds(100, 20, 150, 25);
        add(txtUser);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(20, 60, 80, 25);
        add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(100, 60, 150, 25);
        add(txtPass);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(100, 100, 100, 25);
        add(btnSubmit);

        btnSubmit.addActionListener(e -> {
            boolean registered = VoterDatabase.register(txtUser.getText(), new String(txtPass.getPassword()));
            JOptionPane.showMessageDialog(this, registered ? "Registered!" : "Username taken");
            if (registered) {
                new Login().setVisible(true);
                dispose();
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}