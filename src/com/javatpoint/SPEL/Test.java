package com.javatpoint.SPEL;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Created by Asus x556 on 28-Nov-16.
 */
public class Test {
    public static void main(String[]ars){
        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("'Hello SPEL'.bytes.length");
        String message = (Integer) exp.getValue()+"";
        System.out.println(message);
    }
}
