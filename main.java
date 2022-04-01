import java.io.FileInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import antlr4Grammar.LabeledExprLexer;
import antlr4Grammar.LabeledExprParser;


public class main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String inputFile = null;

        if(args.length > 0)
            inputFile = args[0];

        InputStream is = System.in;
        
        if(inputFile != null)
        {
            is = new FileInputStream(inputFile);
        }
        
        CharStream input = CharStreams.fromFileName("input.in");
        LabeledExprLexer lexer = new LabeledExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);

        ParseTree tree = parser.prog();
        is.close();
        // @Deprecated
        // EvalVisitor eval = new EvalVisitor();
        // eval.visit(tree);

        System.out.println("Acabou.");


    }
}