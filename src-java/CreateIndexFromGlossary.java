package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Simple script to scan an input file for headings identified by {@code headingPattern} and print out an unordered list of github
 * wiki style links to those headings. Headings should contain letters and digits only, processing of special characters such as
 * (/) is not implemented.<br />
 * e.g. look for <br />
 * ### Attribute Path <br />
 * and print <br />
 * * [[Attribute Path|Glossary#attribute-path]]
 * 
 * @author reichert
 */
public class CreateIndexFromGlossary {

	private static final String	PATH			= "C:\\DMP\\dswarm-documentation-wiki\\";
	private static final String	FILENAME		= "Glossary";
	private static final String	FILE_ENDING		= ".md";
	private static final String	HEADING_PATTERN	= "### ";

	public static void main(String[] args) throws IOException {

		File base = new File(PATH + FILENAME + FILE_ENDING);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(base), "UTF8"))) {

			String line;

			while ((line = br.readLine()) != null) {

				if (line.startsWith(HEADING_PATTERN)) {

					String name = line.substring(HEADING_PATTERN.length(), line.length());
					String link = "* [[" + name + "|" + FILENAME + "#" + name.toLowerCase().replace(' ', '-') + "]]";

					System.out.println(link);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
