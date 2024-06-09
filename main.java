import java.io.*;

public class main {

    public static void main(String[] args) {
        String[] postfix = readFile("input.txt");

        if (postfix == null) {
            System.out.println("Error reading the file.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String line : postfix) {
                if (line != null && !line.trim().isEmpty()) {
                    System.out.println("Processing line: " + line);
                    writer.write("Original: " + line + "\n");

                    String[] equations = line.replace("(", "( ").replace(")", " )").split(" ");
                    String calculate = Operate_Method.MathEvaluator(equations);
                    System.out.println("Calculated result: " + calculate);

                    writer.write("Answer: " + calculate + "\n\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String[] readFile(String filename) {
        String[] readOperations = new String[30];
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < 30) {
                System.out.println("Read line: " + line);
                readOperations[index++] = line;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        return readOperations;
    }
}
