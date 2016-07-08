import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FourLetter {

	public static void main(String[] args) {
			
		String[] dictionary;
		ArrayList<String> text = new ArrayList<String>();
		
		
		try {
			FileReader fileRead = new FileReader(new File(System.getProperty("user.dir")+"\\src\\dictionary.txt"));
			BufferedReader buffRead = new BufferedReader(fileRead);
			
			String line = null;
			while((line = buffRead.readLine())!= null){
				text.add(line);
			}
			buffRead.close();
		} catch (FileNotFoundException e) {
			System.out.println("File is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("line is not read correctly");
			e.printStackTrace();
		}
		
		//input param
		dictionary = text.toArray(new String[] {});		
		String source = "SPLIT";
		
		fourLettersInCommon(source, dictionary);

	}

	static String[] fourLettersInCommon(String source, String[] dictionary) {
		
		ArrayList<String> consecString = new ArrayList<String>();
		String[] consecStringArray;
		
		ArrayList<String> commonWords = new ArrayList<String>();
		String[] commonWordsArray = {};
		
		// get all possible four consecutive letter combination from source
		for (int i = 0; (i + 4) < source.length()+1; i++) {			
			consecString.add(source.substring(i, i + 4));
		}
		consecStringArray = consecString.toArray(new String[] {});

		//brute force.. nested for loop... super gross
		//compare word in dictionary contains one of the source's substrings
		for (int j=0;j<dictionary.length;j++){
			for(int k=0;k<consecStringArray.length;k++){
				//if word contains one of the substrings then add to common words then break out
				if(dictionary[j].toUpperCase().contains(consecStringArray[k].toUpperCase())){
					commonWords.add(dictionary[j]);
					break;
				}
			}
		}
		
		//Change ArrayList into array to return
		commonWordsArray = commonWords.toArray(new String[] {});		
		
		return commonWordsArray;

	}

}
