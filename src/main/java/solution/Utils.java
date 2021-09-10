package solution;

import models.Root;
import models.Ticket;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public String checkFile() {
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter the file name(or a stop word \"stop\"):");
            while (true) {
                try {
                    fileName = br.readLine();
                    if (fileName.equals("stop")) {
                        break;
                    }
                    File file = new File(fileName);
                    if (file.exists()) {
                        return fileName;
                    } else {
                        System.out.println("The file does not exist. Try again.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public boolean checkData(Root root) {
        if (root == null)
            return true;
        if (root.getTickets().isEmpty())
            return true;
        ArrayList<Ticket> tickets = root.getTickets();
        for (int i = 0; i < tickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            if (ticket.getOrigin() == null || ticket.getOrigin_name() == null ||
                    ticket.getDestination() == null || ticket.getDestination_name() == null ||
                    ticket.getDeparture_date() == null || ticket.getDeparture_time() == null ||
                    ticket.getArrival_date() == null || ticket.getArrival_time() == null ||
                    ticket.getCarrier() == null || ticket.getStops() == null || ticket.getPrice() == null)
                return true;
        }
        return false;
    }
}
