package com.javatpoint.SPEL.variable;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by Asus x556 on 28-Nov-16.
 */
public class Test {
    public static void main(String[]args){
        Calculation calculation = new Calculation();
        StandardEvaluationContext context = new StandardEvaluationContext(calculation);

        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("number").setValue(context,"5");

        System.out.println(calculation.cube());

    }
}
