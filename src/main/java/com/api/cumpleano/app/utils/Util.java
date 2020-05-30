package com.api.cumpleano.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.api.cumpleano.app.entity.Persona;
import com.api.cumpleano.app.poem.domain.Poem;

@Component
public class Util {

	@Value("${api.poem.endpoint}")
	String urlPoem;

	public int getEdad(Date fecha) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(fecha);
		LocalDate now = LocalDate.now();

		LocalDate cumpleano = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));
		Period periodo = Period.between(cumpleano, now);
		return periodo.getYears();

	}

	public Persona calcularCumple(Persona persona, Date fecha) {

		try {
			/* Fecha actual */
			LocalDate today = LocalDate.now();

			LocalDate birthday = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate nextBDay = birthday.withYear(today.getYear());

			if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
				nextBDay = nextBDay.plusYears(1);
			}

			Period p = Period.between(today, nextBDay);
			long totalD = ChronoUnit.DAYS.between(today, nextBDay);

			if (totalD == 364) {
				for (Poem poem : getPoem()) {
					persona.setmensajeCumpleano(poem.getContent());
				}
			} else {
				persona.setmensajeCumpleano("Restan " + p.getMonths() + " meses, y " + p.getDays()
						+ " días para su próximo cumpleaños. (" + totalD + " días en total)");
			}

		} catch (DateTimeParseException exc) {
			System.out.printf("Error: %s no es una fecha válida!%n", fecha);
		}
		return persona;
	}

	private Poem[] getPoem() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(urlPoem, Poem[].class);
	}
}
