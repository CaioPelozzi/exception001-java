package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("As datas da reserva tem que ser datas futuras!");
		} 
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro! A data de check-out não pode ser menor que a de checkin!");
		}
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		//getTime() -> retorna a diferença em milisegundos;
		long diff = this.checkOut.getTime() - this.checkIn.getTime();
		// TimeUnit é um enumerado que tem operações com datas, esse foi convertendo os milisegundos em dias;
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("As datas da reserva tem que ser datas futuras!");
		} 
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro! A data de check-out não pode ser menor que a de checkin!");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;	
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut) + ", " + this.duration() + " nights";
	}
	
	
	
	
	
}
