import javax.swing.*;

public class AdminPanel extends JFrame {
    public AdminPanel() {
        setTitle("Admin - Results");
        setSize(300, 300);
        setLayout(null);

        JTextArea results = new JTextArea();
        results.setBounds(30, 30, 220, 200);
        add(results);

        StringBuilder sb = new StringBuilder("Voting Results:\n");
        for (String candidate : VoterDatabase.candidates.keySet()) {
            sb.append(candidate).append(": ")
              .append(VoterDatabase.candidates.get(candidate)).append(" votes\n");
        }

        results.setText(sb.toString());
        results.setEditable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}