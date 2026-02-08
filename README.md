<div align="center">
    <h1>
        <b>CS4308<br>Programming Language Project</b>
    </h1>
</div>

## Goal
building an interpreter for a small programming language.

## Purpose
This is a semester project for my CS4308 - Concepts of Programming Languages
spring 2026 course.

## Installation

### Prerequisites
- Java 11 or higher

### Setup
1. Clone or download this repository
2. Compile the Java file:
```bash
   javac ~/TestProgram.java
```
3. Run the program:
```bash
   java ~/TestProgram < inputfile > 
```
## Features
### Lexical Analyzer
Takes an expression from a file as a string of 'source code' and verifys the correctness of each "lexeme" in the input.
Returns an error message if the input is incorrect, along with what and where the error is in the input.

### Token & TokenType
Allows valid lexemes to be held as individual tokens.
The class tokenType allows predetermined types to be assigned to the tokens.

## How to use
A valid text file should be used as the argument when running TestProgram.java, As of now, file should just be one line.

The file "input.txt" is provided incase needed.

TestProgram will output the valid tokens to string on the console until it hits the end of the input and returns EOS token or an error.

### Valid Tokens
```bash
    +  -  *  /  (  )  Integer
```
