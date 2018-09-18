package br.com.sitedoph.uniph.aplicacao.util.config;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Formatador {

	private static ZoneId zoneId = ZoneId.of("America/Sao_Paulo");

	public static ZoneId getZoneId() {
		return zoneId;
	}

	public static DateTimeFormatter getFormatador(String pattern) {
		return DateTimeFormatter.ofPattern(pattern);
	}

}
