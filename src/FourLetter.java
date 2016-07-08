import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FourLetter {

	public static void main(String[] args) {
		
		int i = 0;		
		String[] dictionary;
		ArrayList<String> text = new ArrayList<String>();
		
		
		try {
			FileReader fileRead = new FileReader(new File(System.getProperty("user.dir")+"\\src\\dictionary.txt"));
			BufferedReader buffRead = new BufferedReader(fileRead);
			
			String line = null;
			while((line = buffRead.readLine())!= null){
				text.add(line);
				i++;
			}
			buffRead.close();
		} catch (FileNotFoundException e) {
			System.out.println("File is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("line is not read correctly");
			e.printStackTrace();
		}
		
		
		dictionary = text.toArray(new String[] {});
		
		
		//fourLettersInCommon(source, dictionary);

	}

	static String[] fourLettersInCommon(String source, String[] dictionary) {

		String[] consecString = {};
		String[] commonWords = {};

		// get all possible four consecutive letter combination from source
		for (int i = 0; (i + 3) > source.length(); i++) {
			consecString[i] = source.substring(i, i + 3);
		}

		
		
		return commonWords;

	}

}
