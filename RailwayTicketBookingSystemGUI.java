import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RailwayTicketBookingSystemGUI {
    private ArrayList<Ticket> tickets;


    private JFrame frame;
    private JPanel panel;
    private JLabel sourceLabel, destinationLabel, dateLabel, passengersLabel, trainLabel, classLabel;
    private JTextField sourceField, destinationField, dateField, passengersField;
    private JComboBox trainBox, classBox;
    private JButton submitButton, resetButton, adminViewButton;

    public RailwayTicketBookingSystemGUI() {
        // Initialize the frame and panel
        tickets = new ArrayList<>();
        frame = new JFrame("Railway Ticket Booking System");
        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create the labels and text fields
        sourceLabel = new JLabel("Source Station:");
        sourceField = new JTextField(20);
        destinationLabel = new JLabel("Destination Station:");
        destinationField = new JTextField(20);
        dateLabel = new JLabel("Travel Date (dd/mm/yyyy):");
        dateField = new JTextField(10);
        passengersLabel = new JLabel("Number of Passengers:");
        passengersField = new JTextField(2);
        trainLabel = new JLabel("Select Train:");
        classLabel = new JLabel("Select Class:");

        // Create the train combo box
        String[] trains = {"Rajdhani Express", "Shatabdi Express", "Duronto Express", "Humsafar Express", "Garib Rath Express"};
        trainBox = new JComboBox(trains);

        // Create the class combo box
        String[] classes = {"First Class", "Second Class"};
        classBox = new JComboBox(classes);

        // Create the submit and reset buttons
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action when submit button is clicked
                String source = sourceField.getText();
                String destination = destinationField.getText();
                String date = dateField.getText();
                String passengers = passengersField.getText();
                String train = (String) trainBox.getSelectedItem();
                String className = (String) classBox.getSelectedItem();
                
                if (source.equals("") || destination.equals("") || date.equals("") || passengers.equals("") || train.equals("") || className.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields.");
                } else {
                    String message = "Source: " + source + "\nFrom: " + destination + "\nDate: " + date + "\nPassengers " + passengers + "\nTrain: " + train + "\nClass name: " + className;
                    JOptionPane.showMessageDialog(null, message, "Ticket Details", JOptionPane.PLAIN_MESSAGE);
                }

                Ticket ticket = new Ticket(source, destination, date,passengers,train,className);
                 tickets.add(ticket);

             // Save the ticket details to a file using serialization
                    try {
                        FileOutputStream fileOut = new FileOutputStream("tickets.ser");
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(tickets);
                        out.close();
                        fileOut.close();
                        System.out.println("Ticket details saved to tickets.ser");
                    } catch (Exception ex) {
                        ex.printStackTrace();
        }
            }
        });

        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action when reset button is clicked
                sourceField.setText("");
                destinationField.setText("");
                dateField.setText("");
                passengersField.setText("");
                trainBox.setSelectedIndex(0);
                classBox.setSelectedIndex(0);
            }
        });

// Create the admin view button
JButton adminButton = new JButton("Admin View");
adminButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            new TicketDisplayFrame();
        } catch (ClassNotFoundException | IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
});




        // Add the components to the panel
        panel.add(sourceLabel);
        panel.add(sourceField);
        panel.add(destinationLabel);
        panel.add(destinationField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(passengersLabel);
        panel.add(passengersField);
        panel.add(trainLabel);
        panel.add(trainBox);
        panel.add(classLabel);
        panel.add(classBox);
        panel.add(submitButton);
        panel.add(resetButton);
        // Add the admin view button to the panel
        panel.add(adminButton);

        // Add the panel to the frame
        frame.add(panel);

        // Set the frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }    public static void main(String[] args) {
        new RailwayTicketBookingSystemGUI();
    }
}
