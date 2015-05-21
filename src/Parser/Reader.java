package Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	public boolean readFile(String filename){

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename)); //open file
			String line;
			while ((line = reader.readLine()) != null)
			{
				System.out.println(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

}
