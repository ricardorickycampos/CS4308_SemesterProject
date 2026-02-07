package Analyzer;

public class Token {
    TokenType type;
    String lexeme;
    int row, col;

    public Token(TokenType type, String lexeme, int row, int col) {
        this.type = type;
        this.lexeme = lexeme;
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public String getLexeme() {
        return lexeme;
    }

    public TokenType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Token for : " + lexeme + " (" + type +  ")";
    }
}
