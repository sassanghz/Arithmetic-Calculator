import java.io.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("input.txt"));
			System.out.println();
		}catch(FileNotFoundException e) {
			e.getMessage();
		}
	}
	
}
