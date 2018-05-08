package protokoll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Protokoll {

	private BufferedWriter writer;
	private String fileLocation;
	private File protokollTxt;
	private final String formatStr = "%-20s %-15s %-15s %-15s%n";

	/**
	 * erstellt ein Textfile an belibiger location
	 * @param location - gewünschter Pfad
	 */
	public Protokoll(String location) {
		this.fileLocation = location;
		protokollTxt = new File(fileLocation);

		try {
			writer = new BufferedWriter(new FileWriter(protokollTxt));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * erstellt ein Textfile in Log/protokoll.txt
	 */
	public Protokoll() {
		protokollTxt = new File("Log/protokoll.txt");
		try {
			writer = new BufferedWriter(new FileWriter(protokollTxt, true));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
/**
 * schreibt einen Protkolleintrag bestehend aus eingetragenem Datum, Kommzeit, Gehzeit, Aktuellem Datum und dem Username des
 * Benutzers
 * @param dateInput - einzutragenes Datum
 * @param aktuellesDatum - aktuelles locales Datum/Uhrzeit
 * @param kommzeit
 * @param gehzeit
 * @param username - Benutzer der änderungen durchführte
 * @throws FileNotFoundException
 *
 * TODO : einträge für verschiedene Mitarbeiter(Wer hat zeit eingetragen, Mitarbeiter soll spaeter nur eigene zeit sehen
 */
	public void writeEntry(String dateInput, String aktuellesDatum, String kommzeit, String gehzeit, String username)
			throws FileNotFoundException {
		String akutell = aktuellesDatum;
		String datum = dateInput;
		String kommZeit = kommzeit;
		String gehZeit = gehzeit;
		String user = username;

		try {
			//wenn file leer -> überschriften einfügen
			if (protokollTxt.length() == 0) {
				createProtokollHeader();
			}
			//schreiben der Einträge
			writer.write(String.format(formatStr, akutell, kommZeit, gehZeit, user));

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
	/**
	 * Fügt überschriften der Kategorien ein
	 * @throws IOException
	 */
	private void createProtokollHeader() throws IOException {

		writer.write(String.format(formatStr, "Geändert am: ", "Kommzeit:", "GehZeit:", "Geändert von: "));
	}
}
