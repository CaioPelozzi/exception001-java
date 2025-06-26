package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			
			//jeito de fazer a conversão mais facil de converter string em date;
			System.out.print("Check-In date (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-Out date (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Entre com as datas atualizadas da reserva:");
			
			//jeito de fazer a conversão mais facil de converter string em date;
			System.out.print("Check-In date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-Out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
		} catch (ParseException e) {
			System.out.println("Data inválida");
		} catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		sc.close();
	}

}
