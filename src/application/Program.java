package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number:");
			int number = s.nextInt();
			System.out.println("Check-In date(dd/mm/yyyy)");
			Date checkIn = sdf.parse(s.next());
			System.out.println("Check-Out date(dd/mm/yyyy)");
			Date checkOut = sdf.parse(s.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Resavation: " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.println("Check-In date(dd/mm/yyyy)");
			checkIn = sdf.parse(s.next());
			System.out.println("Check-Out date(dd/mm/yyyy)");
			checkOut = sdf.parse(s.next());
	
			reservation.updateDates(checkIn, checkOut);
	
			System.out.println("Resavation: " + reservation);
			s.close();
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: "+e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Error in reservation: Values is not able to put in the number.");
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error.");
		}

	}

}
