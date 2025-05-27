import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame {
    public Login() {
        setTitle("Login");
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

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(30, 100, 100, 25);
        add(btnLogin);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(140, 100, 100, 25);
        add(btnRegister);

        btnLogin.addActionListener(e -> {
            User user = VoterDatabase.login(txtUser.getText(), new String(txtPass.getPassword()));
            if (user != null) {
                if (user.getUsername().equals("admin")) {
                    new AdminPanel().setVisible(true);
                } else {
                    new VotingPanel(user).setVisible(true);
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials");
            }
        });

        btnRegister.addActionListener(e -> {
            new Register().setVisible(true);
            dispose();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}