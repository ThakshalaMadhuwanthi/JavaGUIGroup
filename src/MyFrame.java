                                                                                                                                                                                                                          import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
                                                                                                                                                                                                                          import java.sql.SQLException;
                                                                                                                                                                                                                          import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFrame extends JFrame implements ActionListener {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 700;

    private JTextField nameField, emailField, emailSignInField;
    private JPasswordField passwordField, passwordSignInField;
    private ButtonGroup genderGroup;
    private JCheckBox robotCheckBox;
    private JButton signUpButton, signInButton;
    private JComboBox<Integer> dateComboBox, yearComboBox;
    private JComboBox<String> monthComboBox;
    private JRadioButton maleButton,femaleButton;

    MyFrame() {
        setTitle("User Registration Form");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Header
        JLabel headerLabel = new JLabel("Sign Up");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        headerLabel.setBounds(200, 20, 200, 30);
        headerLabel.setForeground(new Color(0, 102, 204));
        add(headerLabel);

        // Name field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        nameLabel.setBounds(30, 70, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameField.setBounds(120, 70, 250, 25);
        add(nameField);

        // Email field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        emailLabel.setBounds(30, 110, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailField.setBounds(120, 110, 250, 25);
        add(emailField);

        // Gender selection
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        genderLabel.setBounds(30, 150, 100, 25);
        add(genderLabel);

         maleButton = new JRadioButton("Male");
        maleButton.setBounds(120, 150, 90, 25);
        maleButton.setFont(new Font("Arial", Font.PLAIN, 15));

         femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(220, 150, 90, 25);
        femaleButton.setFont(new Font("Arial", Font.PLAIN, 15));

        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        add(maleButton);
        add(femaleButton);

        // Birthday field
        JLabel birthdayLabel = new JLabel("Birthday:");
        birthdayLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        birthdayLabel.setBounds(30, 190, 100, 25);
        add(birthdayLabel);

        Integer[] dates = new Integer[31];
        for (int i = 0; i < 31; i++) {
            dates[i] = i + 1;
        }
        dateComboBox = new JComboBox<>(dates);
        dateComboBox.setBounds(120, 190, 50, 25);
        add(dateComboBox);

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(180, 190, 80, 25);
        add(monthComboBox);

        Integer[] years = new Integer[101];
        for (int i = 0; i < 101; i++) {
            years[i] = 1990 + i;
        }
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setBounds(270, 190, 80, 25);
        add(yearComboBox);

        // Password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordLabel.setBounds(30, 230, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setBounds(120, 230, 250, 25);
        add(passwordField);

        // Checkbox for robot verification
        robotCheckBox = new JCheckBox("I am not a robot");
        robotCheckBox.setBounds(30, 270, 250, 25);
        robotCheckBox.setFont(new Font("Arial", Font.PLAIN, 14));
        add(robotCheckBox);

        // Sign-up button
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(30, 310, 400, 30);
        signUpButton.setBackground(new Color(0, 102, 204));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 15));
        signUpButton.addActionListener(this);
        add(signUpButton);

        // Sign-in section
        JLabel signInLabel = new JLabel("Sign In");
        signInLabel.setFont(new Font("Arial", Font.BOLD, 25));
        signInLabel.setBounds(200, 370, 200, 30);
        signInLabel.setForeground(new Color(0, 102, 204));
        add(signInLabel);

        JLabel emailSignInLabel = new JLabel("Email:");
        emailSignInLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        emailSignInLabel.setBounds(30, 420, 100, 25);
        add(emailSignInLabel);

        emailSignInField = new JTextField();
        emailSignInField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailSignInField.setBounds(120, 420, 250, 25);
        add(emailSignInField);

        JLabel passwordSignInLabel = new JLabel("Password:");
        passwordSignInLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordSignInLabel.setBounds(30, 460, 100, 25);
        add(passwordSignInLabel);

        passwordSignInField = new JPasswordField();
        passwordSignInField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordSignInField.setBounds(120, 460, 250, 25);
        add(passwordSignInField);

        signInButton = new JButton("Sign In");
        signInButton.setBounds(30, 500, 400, 30);
        signInButton.setBackground(new Color(0, 102, 204));
        signInButton.setForeground(Color.WHITE);
        signInButton.setFont(new Font("Arial", Font.BOLD, 15));
        signInButton.addActionListener(this);
        add(signInButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
            String email = emailField.getText();
            if (nameField.getText().isEmpty() || email.isEmpty() || passwordField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (!robotCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please verify that you're not a robot.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (genderGroup.getSelection() == null) {
                JOptionPane.showMessageDialog(this, "Please select a gender.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

                String name = nameField.getText();            // Get the name from the NAME text field
                String email2 = emailField.getText();          // Get the email from the EMAIL text field
                String gender = maleButton.isSelected() ? "Male" : "Female";  // Determine gender from selected radio button
                String birthday = dateComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + yearComboBox.getSelectedItem();  // Construct birthday
                String password = passwordField.getText();   // Get the password from the PASSWORD text field

                SignUpHandler signUpHandler = new SignUpHandler();
                try {
                    signUpHandler.signUp(name, email2, gender, birthday, password);
                    JOptionPane.showMessageDialog(MyFrame.this, "Sign Up successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();  // To print SQL error if any occurs
                    JOptionPane.showMessageDialog(MyFrame.this, "Error signing up. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }










        } else if (e.getSource() == signInButton) {
            String enteredEmail = emailSignInField.getText();
            String enteredPassword = new String(passwordSignInField.getPassword());
            String registeredEmail = emailField.getText();
            String registeredPassword = new String(passwordField.getPassword());

            if (!isValidEmail(enteredEmail)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!enteredEmail.equals(registeredEmail) || !enteredPassword.equals(registeredPassword)) {
                JOptionPane.showMessageDialog(this, "Sign-in unsuccessful. Please check your credentials.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Sign-in successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    // Email validation method using regex
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}