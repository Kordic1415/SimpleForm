import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleForm {
    private JFrame frame;
    private JTextField nameField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JComboBox<String> ageComboBox;
    private JCheckBox agreeCheckBox;

    public SimpleForm() {
        frame = new JFrame("Simple Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(5, 2));
        frame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        JLabel ageLabel = new JLabel("Age:");
        String[] ageOptions = {"Below 18", "18-30", "31-50", "Above 50"};
        ageComboBox = new JComboBox<>(ageOptions);

        JLabel agreeLabel = new JLabel("Agree to terms:");
        agreeCheckBox = new JCheckBox();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                String age = (String) ageComboBox.getSelectedItem();
                boolean agreed = agreeCheckBox.isSelected();

                // Process the form data here
                System.out.println("Name: " + name);
                System.out.println("Gender: " + gender);
                System.out.println("Age: " + age);
                System.out.println("Agreed to terms: " + agreed);
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(genderLabel);
        frame.add(maleRadioButton);
        frame.add(new JLabel()); // empty label for spacing
        frame.add(femaleRadioButton);
        frame.add(ageLabel);
        frame.add(ageComboBox);
        frame.add(agreeLabel);
        frame.add(agreeCheckBox);
        frame.add(new JLabel()); // empty label for spacing
        frame.add(submitButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleForm();
            }
        });
    }
}
