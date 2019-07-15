//Name: Marcus Santos
//Date: 6/30/19
//Program: Santos_WordOccurrence||Santos_WordUnitTest
//Purpose: Using unit testing to make sure the output is correct
//===========================================================================================================================
package WordOccurrence;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Santos_WordOccurrence {
	//creates a new method that accepts a filename and a hashmap
	 static String countWords(String fileName) throws IOException {
		// new file to take any file needed to run
		Scanner file = new Scanner(new File(fileName));
		Map<String, Integer> words = new HashMap();
		while (file.hasNext()) {
			String word = file.next();
			Integer count = words.get(word);
			if (count != null)
				count++;
			else
				count = 1;
			words.put(word, count);
		}
		//Sorts the whole map based from highest to lowest integer
		LinkedHashMap<String, Integer> sortingMap = new LinkedHashMap<>();
		words.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> sortingMap.put(x.getKey(), x.getValue()));
		//creates an array to select top 20 words used
		Set<String>wordKey = sortingMap.keySet();
		String[]wordArray = wordKey.toArray(new String[wordKey.size()]);
		for(int i=0;i<wordArray.length&& i<20;i++) {
			System.out.println(wordArray[i] + " = " + sortingMap.get(wordArray[i]));
		}
		return fileName;
		}

		public static void main(String[] args) throws IOException {
			Map<String, Integer> words = new HashMap<String, Integer>();
			countWords("c:\\Users\\SANTO_000\\Documents\\Seminole State\\Cen3024\\src\\WordOccurrence\\macbeth.txt");

		}

	}
