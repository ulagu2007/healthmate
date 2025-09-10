import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class UserLoginUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserLoginUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("User Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 620);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Outer container with thin white border like the screenshot
        JPanel outer = new JPanel(new BorderLayout());
        outer.setBackground(new Color(34, 36, 38)); // dark background around inner card
        outer.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));
        frame.add(outer, BorderLayout.CENTER);

        // Inner card (the big rectangle)
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(new Color(46, 50, 52)); // slightly lighter dark
        card.setBorder(new LineBorder(Color.WHITE, 2));
        outer.add(card, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.BOTH;

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 20);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 20);
        Font btnFont = new Font("Segoe UI", Font.BOLD, 18);

        // Left large empty area (to mimic big left region in screenshot)
        JPanel leftSpacing = new JPanel();
        leftSpacing.setBackground(new Color(46, 50, 52));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.weightx = 0.55;
        gbc.weighty = 1.0;
        card.add(leftSpacing, gbc);

        // Username label
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(new Color(220, 220, 220));
        userLabel.setFont(labelFont);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.weightx = 0.45;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.LINE_START;
        card.add(userLabel, gbc);

        // Username input (aligned right like screenshot)
        JTextField userField = new JTextField("Rishabh");
        userField.setFont(inputFont);
        userField.setPreferredSize(new Dimension(320, 44));
        userField.setBackground(Color.WHITE);
        userField.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        card.add(userField, gbc);

        // Middle empty space (so username input appears top-right)
        JPanel midSpace = new JPanel();
        midSpace.setBackground(new Color(46, 50, 52));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 0.6;
        gbc.anchor = GridBagConstraints.CENTER;
        card.add(midSpace, gbc);

        // Password label
        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(new Color(220, 220, 220));
        passLabel.setFont(labelFont);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.LINE_START;
        card.add(passLabel, gbc);

        // Password field
        JPasswordField passField = new JPasswordField();
        passField.setFont(inputFont);
        passField.setPreferredSize(new Dimension(320, 44));
        passField.setBackground(Color.WHITE);
        passField.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        card.add(passField, gbc);

        // Bottom area for the purple Login button (left side)
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.setBackground(new Color(46, 50, 52));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        card.add(bottomPanel, gbc);

        GridBagConstraints b = new GridBagConstraints();
        b.insets = new Insets(6, 10, 6, 10);
        b.fill = GridBagConstraints.HORIZONTAL;
        b.weightx = 0.5;
        b.gridx = 0;
        b.gridy = 0;

        // Login button (purple on the left)
        JButton loginBtn = new JButton("Login");
        loginBtn.setFont(btnFont);
        loginBtn.setPreferredSize(new Dimension(320, 60));
        loginBtn.setFocusPainted(false);
        loginBtn.setForeground(Color.BLACK);
        loginBtn.setBackground(new Color(176, 160, 255)); // light purple like left button in screenshot
        loginBtn.setOpaque(true);
        loginBtn.setBorderPainted(false);
        bottomPanel.add(loginBtn, b);

        // Add a spacer on the right (we removed the Driver Login button entirely)
        b.gridx = 1;
        b.weightx = 0.5;
        JPanel rightSpacer = new JPanel();
        rightSpacer.setBackground(new Color(46, 50, 52));
        rightSpacer.setPreferredSize(new Dimension(320, 60));
        bottomPanel.add(rightSpacer, b);

        // Optional: small action for login button
        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            JOptionPane.showMessageDialog(frame, "Attempt login for: " + user);
        });

        // Make frame visible
        frame.setVisible(true);
    }
}
