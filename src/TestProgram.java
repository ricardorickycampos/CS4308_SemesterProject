import Analyzer.LexicalAnalyzer;
import Analyzer.Token;
import Analyzer.TokenType;
import globalexceptions.InvalidToken;

import java.io.*;

public class TestProgram {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a file.");
            return;
        }

        String filePath = args[0];
        try {
            String inputData = readFile(filePath);
            LexicalAnalyzer analyzer = new LexicalAnalyzer(inputData);

            Token token;
            do {
                token = analyzer.getToken();
                System.out.println(token);
            } while (token.getType() != TokenType.EOS);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (InvalidToken e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }
}