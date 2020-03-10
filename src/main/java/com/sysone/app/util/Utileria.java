package com.sysone.app.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	public static List<String> getNextDays(int count) {
		List<String> nextDays = new LinkedList<String>();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date end = cal.getTime();

		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);

		while (!gcal.getTime().after(end)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(format.format(d));
		}

		return nextDays;
	}

	public static String guardarImagen(MultipartFile multipartFile, HttpServletRequest request) {
		String nombreOriginal = multipartFile.getOriginalFilename();
		String nombreFinal = randomAlphaNumeric(nombreOriginal.length()) + "-" + nombreOriginal;
		nombreFinal = nombreFinal.replace(" ", "-").toLowerCase();
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");

		try {
			File imageFile = new File(rutaFinal + nombreFinal);
			multipartFile.transferTo(imageFile);
			System.out.println("Save file [" + nombreFinal + "] on: " + "[" + rutaFinal + "]");
			return nombreFinal;
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
			return null;
		}
	}

	public static String randomAlphaNumeric(int count) {
		String caracteres = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int caracter = (int) (Math.random() * caracteres.length());
			builder.append(caracteres.charAt(caracter));
		}
		return builder.toString();
	}
}
