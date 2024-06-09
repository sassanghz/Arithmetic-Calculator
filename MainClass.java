import java.io.*;
public class MainClass{

	public static void main(String[] args) {
		
		 String [] postfix = readFile("input.txt");

		 try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/input.txt"));
			
			for(int i = 0; i < postfix.length; i++){
				if(postfix[i] != null){
					writer.write(postfix[i] + "\n");

					String[] equations = postfix[i].split(" ");
					String calculate = Operate_Method.MathEvaluator(equations);
					System.out.println(calculate);

					writer.write("Answer: " + calculate + "\n");
				}
			}
			writer.close();
		}catch (IOException e){
			System.out.println("Error: " + e.getMessage());
		}
		
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
