import java.util.Stack;

class ArithmeticExpressionParser {

    public static int evaluateExpression(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Ignore space
            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                StringBuilder num = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num.append(expression.charAt(i++));
                }
                i--;
                operands.push(Integer.parseInt(num.toString()));
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.pop(); // Remove '(' from stack
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // Process based on precedence
                while (!operators.isEmpty() && precedence(ch) <= precedence(operators.peek())) {
                    operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.push(ch);
            }
        }

        // Evaluate remaining
        while (!operators.isEmpty()) {
            operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
        }

        // Result is the top value
        return operands.pop();
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0; // Default for '('
    }

    private static int applyOperator(char operator, int b, int a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0; // Default case
    }

    public static void main(String[] args) {
        String expression = "((10 + 2) * 3) - (4 / 2)";
        int result = evaluateExpression(expression);
        System.out.println("Result of expression " + expression + " is: " + result);
    }
}
