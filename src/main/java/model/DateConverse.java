package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateConverse {
	//private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	private static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	public static String convertLocalDateToString(LocalDate localD) {
		//DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		return localD.format(format);
	}
	
	public static LocalDate convertStringToLocalDate(String str) {
		//DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		
		return LocalDate.parse(str , format);
		
	}
	
	
}
