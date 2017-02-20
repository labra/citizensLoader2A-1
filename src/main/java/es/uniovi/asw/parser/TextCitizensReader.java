package es.uniovi.asw.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uniovi.asw.modelos.Citizen;

public class TextCitizensReader implements CitizensReader {

    @Override
    public List<Citizen> readCitizens(String filePath) throws IOException {
	String linea = "";
	String[] datosCitizen = null;
	List<Citizen> newCitizens = new ArrayList<Citizen>();
	try {
	    BufferedReader fichero = new BufferedReader(new FileReader(filePath));
	    while (fichero.ready()) {
		linea = fichero.readLine();
		datosCitizen = linea.split(";");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaNacimiento = dateFormat.parse(datosCitizen[3]);
		newCitizens.add(new Citizen(datosCitizen[0], datosCitizen[1], datosCitizen[2], fechaNacimiento,
			datosCitizen[4], datosCitizen[5], datosCitizen[6]));
	    }
	    fichero.close();
	} catch (ParseException pe) {
	    System.out.println("Conversión de fecha errónea");
	}
	return newCitizens;
    }

}