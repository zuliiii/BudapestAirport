import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Flight {
    String airline;
    String destination;
    int passengers;

    Flight(String airline, String destination, int passengers) {
        this.airline = airline;
        this.destination = destination;
        this.passengers = passengers;
    }
}

public class BudapestAirport {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Flight> flights = new ArrayList<>();
        Scanner scanner = new Scanner(new File("input.txt"));

        // read the flights from the file
        while (scanner.hasNext()) {
            String airline = scanner.next();
            String destination = scanner.next();
            int passengers = scanner.nextInt();
            flights.add(new Flight(airline, destination, passengers));
        }

        // check if the file is empty
        if (flights.isEmpty()) {
            System.out.println("0 \nThe file is empty! \nThere is no flight with passengers less than 100 \nThe file is empty!");
            return;
        }

        // Exercise 1: How many flights are there to "Frankfurt"?
        int flightsToFrankfurt = 0;
        for (Flight flight : flights) {
            if (flight.destination.equals("Frankfurt")) {
                flightsToFrankfurt++;
            }
        }
        System.out.println( flightsToFrankfurt);

        // Exercise 2: Which flight has the most passengers?
        Flight maxPassengersFlight = Collections.max(flights, Comparator.comparing(f -> f.passengers));
        System.out.println(maxPassengersFlight.airline + " " + maxPassengersFlight.destination + " " + maxPassengersFlight.passengers );

        // Exercise 3: Find the first flight with passengers less than 100.
        Flight firstFlightWithLessThan100Passengers = null;
        for (Flight flight : flights) {
            if (flight.passengers < 100) {
                firstFlightWithLessThan100Passengers = flight;
                break;
            }
        }
        if (firstFlightWithLessThan100Passengers == null) {
            System.out.println("There is no flight with passengers less than 100.");
        } else {
            System.out.println(firstFlightWithLessThan100Passengers.airline + " " + firstFlightWithLessThan100Passengers.destination + " " + firstFlightWithLessThan100Passengers.passengers);
        }

        // Exercise 4: Name the airline with the most total number of passengers.
        ArrayList<String> airlines = new ArrayList<>();
        for (Flight flight : flights) {
            if (!airlines.contains(flight.airline)) {
                airlines.add(flight.airline);
            }
        }

        String airlineWithMostPassengers = "";
        int maxPassengers = 0;
        for (String airline : airlines) {
            int totalPassengers = 0;
            for (Flight flight : flights) {
                if (flight.airline.equals(airline)) {
                    totalPassengers += flight.passengers;
                }
            }
            if (totalPassengers > maxPassengers) {
                airlineWithMostPassengers = airline;
                maxPassengers = totalPassengers;
            }
        }
        System.out.println(airlineWithMostPassengers + " " + maxPassengers);
    }
}
