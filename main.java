import java.io.*;
public class main {

	public static void main(String[] args) {
		
		 String [] postfix = readFile();

		 if(postfix != null || !postfix.isEmpty()){
			String postinfix = Operate_Method.reversePolishNotation(postfix);
		 }
		 System.out.println("Postfix: " + postfix);
 
		 double result = Operate_Method.MathEvaluator(postfix);
		 System.out.println("Result: " + result);
		
	}

	public static String[] readFile(String filename){

		String[] readOperations = new String[30];
		BufferedReader br = null;

		try{
			br = new BufferedReader(new FileReader(filename));
			String line;
			int index = 0;
			while((line = br.readLine()) != null && index < 30){
				readOperations[index++] = line;
			}
			br.close();
		}catch(FileNotFoundException e){
			System.out.println("Error: " + e.getMessage());
		}catch (IOException e){
			System.out.println("Error: " + e.getMessage());
		}
		
		return readOperations;
	}


	
}
