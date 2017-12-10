package interview.airbnb;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/28/17
 */
public class Calculator {
    public int evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
        Deque<Integer> values = new ArrayDeque<>();

        // Stack for Operators: 'ops'
        Deque<Character> ops = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            char c = tokens[i];
            // Current token is a whitespace, skip it
            if (c == ' ')
                continue;

            // Current token is a number, push it to stack for numbers
            if (Character.isDigit(c)) {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && Character.isDigit(tokens[i])) sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
            }

            // Current token is an opening brace, push it to 'ops'
            else if (c == '(') ops.push(c);
            // Closing brace encountered, solve entire brace
            else if (c == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.isEmpty() && hasPrecedence(c, ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(c);
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.isEmpty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    private double compose(int number, int digit) {
        int len = 0, tmp = digit;
        while (tmp != 0) {
            len++;
            tmp /= 10;
        }
        return (double) number + digit * Math.pow(10, -len);
    }

    public static void main(String[] args) {
        Calculator s = new Calculator();

//        System.out.println(s.calculate("1.234+0.5"));
//        System.out.println(s.calculate("1.234*0.5"));
        System.out.println(s.evaluate("3-1"));
    }
}
