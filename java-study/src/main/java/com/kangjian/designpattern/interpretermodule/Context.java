package com.kangjian.designpattern.interpretermodule;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.StringTokenizer;

public class Context {
    private StringTokenizer tokenizer;
    private String currentToken;

    public Context(String currentToken) {
        this.currentToken = currentToken;

    }

    public String nextToken() {
       if (tokenizer.hasMoreTokens()) {
          currentToken = tokenizer.nextToken();
       } else {
           currentToken = null;
       }
       return currentToken;
    }

    public String currentToken() {
        return currentToken;
    }

    public void skipToken(String token) throws ParseException {
        if (!token.equals(currentToken)) {
            throw new ParseException("Waring: " + token + " is expected, but " + currentToken + "is found", -1);
        }
        nextToken();
    }

    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new ParseException("Waning: " + e.getMessage() , -1);
        }
        return number;
    }
}
