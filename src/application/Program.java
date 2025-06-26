package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();
		
		//jeito de fazer a conversão mais facil de converter string em date;
		System.out.print("Check-In date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.print("Check-Out date (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro! A data de check-out não pode ser menor que a de checkin!");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Entre com as datas atualizadas da reserva:");
			
			//jeito de fazer a conversão mais facil de converter string em date;
			System.out.print("Check-In date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-Out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("As datas devem ser futuras!");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro! A data de check-out não pode ser menor que a de checkin!");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
			
		}
		
		
		
		sc.close();
	}

}
