import javax.swing.*;

public class VotingPanel extends JFrame {
    public VotingPanel(User user) {
        setTitle("Vote Now");
        setSize(300, 250);
        setLayout(null);

        JLabel lbl = new JLabel("Choose your candidate:");
        lbl.setBounds(50, 20, 200, 30);
        add(lbl);

        JComboBox<String> combo = new JComboBox<>(VoterDatabase.candidates.keySet().toArray(new String[0]));
        combo.setBounds(50, 60, 200, 25);
        add(combo);

        JButton voteBtn = new JButton("Vote");
        voteBtn.setBounds(100, 110, 100, 30);
        add(voteBtn);

        voteBtn.addActionListener(e -> {
            if (!user.hasVoted()) {
                VoterDatabase.vote(combo.getSelectedItem().toString());
                user.setVoted(true);
                JOptionPane.showMessageDialog(this, "Vote cast successfully");
            } else {
                JOptionPane.showMessageDialog(this, "You have already voted!");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}