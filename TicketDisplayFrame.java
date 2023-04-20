import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TicketDisplayFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public TicketDisplayFrame() throws IOException, ClassNotFoundException {
        JPanel panel = new JPanel();
        String[] columns = {"Source", "Destination", "Date", "Train", "Class Name", "Passengers"};

        ArrayList<Ticket> tickets = readTicketsFromFile();

        Object[][] data = new Object[tickets.size()][6];

        for (int i = 0; i < tickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            data[i][0] = ticket.getSource();
            data[i][1] = ticket.getDestination();
            data[i][2] = ticket.getDate();
            data[i][3] = ticket.getTrain();
            data[i][4] = ticket.getClass();
            data[i][5] = ticket.getPassengers();
        }

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }

    private ArrayList<Ticket> readTicketsFromFile() throws IOException, ClassNotFoundException {
        FileInputStream 
        fis = new FileInputStream("tickets.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Ticket> tickets = (ArrayList<Ticket>) ois.readObject();
        ois.close();
        fis.close();
        return tickets;
    }

}
