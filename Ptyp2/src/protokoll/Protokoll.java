package protokoll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Protokoll {

	private FileWriter writer;
	private BufferedReader reader;
	private String fileLocation;
	private File protokollTxt;
	public static final String formatStr = "%-20s %-15s %-15s %-15s%n";

	/**
	 * erstellt ein Textfile an belibiger location
	 *
	 * @param location
	 *            - gew�nschter Pfad
	 */
	public Protokoll(String location) {
		this.fileLocation = location;
		protokollTxt = new File(fileLocation);

		try {
			writer = new FileWriter(protokollTxt, true);
			reader = new BufferedReader(new FileReader(protokollTxt));
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
			writer = new FileWriter(protokollTxt,true);
			// writer = new BufferedWriter(new FileWriter(protokollTxt, true));
			reader = new BufferedReader(new FileReader(protokollTxt));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * schreibt einen Protkolleintrag bestehend aus eingetragenem Datum, Kommzeit,
	 * Gehzeit, Aktuellem Datum und dem Username des Benutzers
	 *
	 * @param dateInput
	 *            - einzutragenes Datum
	 * @param aktuellesDatum
	 *            - aktuelles locales Datum/Uhrzeit
	 * @param kommzeit
	 * @param gehzeit
	 * @param username
	 *            - Benutzer der änderungen durchführte
	 * @throws FileNotFoundException
	 *
	 *             TODO : eintr�ge f�r verschiedene Mitarbeiter(Wer hat zeit
	 *             eingetragen, Mitarbeiter soll spaeter nur eigene zeit sehen
	 */
	public boolean writeEntry(String dateInput, String aktuellesDatum, String kommzeit, String gehzeit, String username)
			throws FileNotFoundException {
		String akutell = aktuellesDatum;
		String datum = dateInput;
		String kommZeit = kommzeit;
		String gehZeit = gehzeit;
		String user = username;

		try {
			//wenn file leer -> ueerschriften einfuegen
			if (protokollTxt.length() == 0) {
				createProtokollHeader();
			}
			//schreiben der Eintraege
			File protokollVorherTxt = protokollTxt;

			writer.write(String.format(formatStr, akutell, kommZeit, gehZeit, user));
			if (protokollTxt != protokollVorherTxt) {
			return true;
			}
			else return false;
		} catch (IOException e) {

			e.printStackTrace();
			return false;
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
 * liest die protokolle eines Users und gibt diese zur�ck
 * @param username
 * @return eine Liste aller Protokolle, die zum username geh�ren
 * @throws FileNotFoundException
 */
	public ArrayList<String> readEnrty(String username) throws FileNotFoundException {

		String user = username;
		ArrayList<String> protokoll = new ArrayList<>();
		try {
			for (int i = 0; i < protokollTxt.length(); i++) {
				String entry = reader.readLine();
				if (entry.contains(username)) {
					protokoll.add(entry);
				}
			}
			reader.close();
		} catch (Exception e) {

		}

		return protokoll;
	}

	/**
	 * F�gt �berschriften der Kategorien ein
	 *
	 * @throws IOException
	 */
	private void createProtokollHeader() throws IOException {

		writer.write(String.format(formatStr, "Ge�ndert am: ", "Kommzeit:", "GehZeit:", "Ge�ndert von: "));
	}


}
