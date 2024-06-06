import java.io.*;
public class main {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("input.txt"));
			System.out.println();
			br.close();
		}catch(FileNotFoundException e) {
			e.getMessage();
		}catch (IOException e){
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}
