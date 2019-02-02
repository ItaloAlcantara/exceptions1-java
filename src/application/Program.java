package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner s = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number:");
		int number = s.nextInt();
		System.out.println("Check-In date(dd/mm/yyyy)");
		Date checkIn = sdf.parse(s.next());
		System.out.println("Check-Out date(dd/mm/yyyy)");
		Date checkOut = sdf.parse(s.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in resavation: Date of check-out can't be after check-in");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Resavation: " + reservation);

			System.out.println();

			System.out.println("Enter data to update the reservation");
			System.out.println("Check-In date(dd/mm/yyyy)");
			checkIn = sdf.parse(s.next());
			System.out.println("Check-Out date(dd/mm/yyyy)");
			checkOut = sdf.parse(s.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro in reservation: Reservation dates for update must be future dates");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in resavation: Date of check-out can't be after check-in");
			} else {
				reservation.updateDates(checkIn, checkOut);

				System.out.println("Resavation: " + reservation);
			}
		}

	}

}
