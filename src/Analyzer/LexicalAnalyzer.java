package Analyzer;

import globalexceptions.InvalidToken;

public class LexicalAnalyzer {


    private String sourceCode;
    private int index = 0;

    public LexicalAnalyzer(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Token getToken() throws InvalidToken {
        skipWhiteSpace();
        if (index >= sourceCode.length()) {
            return new Token(TokenType.EOS, "", 1, index);
        }
        char currentChar = sourceCode.charAt(index);
        if (Character.isDigit(currentChar)) {
            int startIndex = index;
            String token = readNumber();
            return new Token(TokenType.INT_LIT, token, 1, startIndex);
        }
        TokenType operatorType = operatorAssign(currentChar);
        Token token = new Token(operatorType, String.valueOf(currentChar), 1, index);
        index++;
        return token;
    }

    // Helper Methods
    private String readNumber() {
        int startIndex = index;
        while (index < sourceCode.length() && Character.isDigit(sourceCode.charAt(index))) {
            index++;
        }
        return sourceCode.substring(startIndex, index);
    }
    private void skipWhiteSpace() {
        while (index < sourceCode.length() && Character.isWhitespace(sourceCode.charAt(index))) {
            index++;
        }
    }

    private TokenType operatorAssign(char c) throws InvalidToken {
        switch (c) {
            case '+' -> {
                return TokenType.PLUS;
            }
            case '-' -> {
                return TokenType.MINUS;
            }
            case '*' -> {
                return TokenType.MULTIPLY;
            }
            case '/' -> {
                return TokenType.DIVIDE;
            }
            case '(' -> {
                return TokenType.LEFT_PAREN;
            }
            case ')' -> {
                return TokenType.RIGHT_PAREN;
            }
            default -> {
                throw new InvalidToken("Invalid token: " + c + " @INDEX: " + (index));
            }
        }
    }
}
