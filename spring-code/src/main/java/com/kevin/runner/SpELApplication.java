package com.kevin.runner;

import com.kevin.entity.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Code is far away from bug with the animal protecting
 *
 * @author kevin lau (双鹰)
 */
public class SpELApplication {

    public static void main(String[] args) {
         ExpressionParser parser = new SpelExpressionParser();
         String spelStr = "username:#{#user.name}";
         Expression expression = parser.parseExpression(spelStr, ParserContext.TEMPLATE_EXPRESSION);
         EvaluationContext context = new StandardEvaluationContext();
         User user = new User();
         user.setName("kevin");
         context.setVariable("user",user);
        final String value = expression.getValue(context, String.class);
        System.out.println(value);
    }
}
