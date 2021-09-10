package solution;

import models.Root;
import models.Ticket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MathOperationsImpl implements MathOperations {
    public double averageTime(Root root) {
        long sum = 0;
        List<Integer> flightTime = flightTime(root);
        for (Integer number : flightTime) {
            sum += number;
        }
        return (double) sum / flightTime.size();
    }

    public int calculatingPercentile(Root root, double percentile) {
        List<Integer> flightTime = flightTime(root);
        Collections.sort(flightTime);
        int index = (int) (percentile / 100.0 * flightTime.size());
        if (index > 0)
            index--;
        return flightTime.get(index);
    }

    public List<Integer> flightTime(Root root) {
        List<Integer> result = new ArrayList<>();
        List<Ticket> tickets = root.getTickets();
        Ticket ticket;
        for (int i = 0; i < tickets.size(); i++) {
            ticket = tickets.get(i);
            String departure = ticket.getDeparture_date() + " " + ticket.getDeparture_time();
            String arrival = ticket.getArrival_date() + " " + ticket.getArrival_time();
            try {
                Date departureDate = new SimpleDateFormat("dd.MM.yy HH:mm", Locale.ENGLISH).parse(departure);
                Date arrivalDate = new SimpleDateFormat("dd.MM.yy HH:mm", Locale.ENGLISH).parse(arrival);
                result.add((int) ((arrivalDate.getTime() - departureDate.getTime()) / 1000 / 60));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
