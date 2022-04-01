package main;

import java.io.FileInputStream;

import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import antlr.ExprLexer;
import antlr.ExprParser;

public class main {
    public static void main(String[] args) throws Exception {


        String inputFile = null;

        if(args.length > 0)
            inputFile = args[0];

        InputStream is = System.in;
        
        if(inputFile != null)
        {
            is = new FileInputStream(inputFile);
        }
        
        CharStream input = CharStreams.fromFileName("input.in");
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        ParseTree tree = parser.prog();
        is.close();
        


    }
}