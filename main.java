import java.io.*;
public class main {

	public static void main(String[] args) {
		
		 String postfix = Operate_Method.reversePolishNotation(readFile());
		 System.out.println("Postfix: " + postfix);
 
		 double result = Operate_Method.MathEvaluator(postfix);
		 System.out.println("Result: " + result);
		
	}

	public static String readFile(){
		StringBuilder readOperations = new StringBuilder();
		BufferedReader br = null;

		try{
			br = new BufferedReader(new FileReader("input.txt"));
			String line;

			while((line = br.readLine()) != null){
				readOperations.append(line).append(" ");
			}
			br.close();
		}catch(FileNotFoundException e){
			System.out.println("Error: " + e.getMessage());
		}catch (IOException e){
			System.out.println("Error: " + e.getMessage());
		}
		
		return readOperations.toString().trim();
	}


	
}
