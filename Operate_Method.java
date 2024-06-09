import java.util.Stack;

public class Operate_Method {

    public static String reversePolishNotation(String[] variable) {
        StringBuilder arrangeOperation = new StringBuilder();
        Stack<String> opStack = new Stack<>();

        for (String op : variable) {
            if (isOperand(op)) {
                arrangeOperation.append(op).append(" ");
            } else if (op.equals("(")) {
                opStack.push(op);
            } else if (op.equals(")")) {
                while (!opStack.isEmpty() && !opStack.peek().equals("(")) {
                    arrangeOperation.append(opStack.pop()).append(" ");
                }
                if (!opStack.isEmpty()) {
                    opStack.pop();
                }
            } else {
                while (!opStack.isEmpty() && operator(op) <= operator(opStack.peek())) {
                    arrangeOperation.append(opStack.pop()).append(" ");
                }
                opStack.push(op);
            }
        }

        while (!opStack.isEmpty()) {
            arrangeOperation.append(opStack.pop()).append(" ");
        }
        return arrangeOperation.toString().trim();
    }

    private static boolean isOperand(String variable) {
        return variable.matches("[a-zA-Z0-9]+") || variable.equals("$");
    }

    private static int operator(String operator) {
        switch (operator) {
            case ">":
            case ">=":
            case "==":
            case "!=":
            case "<":
            case "<=":
                return 0;
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            case "(":
            case ")":
                return -1;
            default:
                throw new IllegalArgumentException("Operator Invalid: " + operator);
        }
    }

    public static String MathEvaluator(String[] calculate) {
        String postFix = reversePolishNotation(calculate);
        Stack<Double> stackOperation = new Stack<>();
        String[] operations = postFix.split(" ");

        for (String operation : operations) {
            if (isOperand(operation)) {
                stackOperation.push(Double.parseDouble(operation));
            } else {
                double y = stackOperation.pop();
                double x = stackOperation.pop();
                double result = 0;

                switch (operation) {
                    case "^":
                        result = Math.pow(x, y);
                        break;
                    case "*":
                        result = x * y;
                        break;
                    case "/":
                        result = x / y;
                        break;
                    case "+":
                        result = x + y;
                        break;
                    case "-":
                        result = x - y;
                        break;
                    case "==":
                        return String.valueOf(x == y);
                    case "!=":
                        return String.valueOf(x != y);
                    case ">=":
                        return String.valueOf(x >= y);
                    case ">":
                        return String.valueOf(x > y);
                    case "<=":
                        return String.valueOf(x <= y);
                    case "<":
                        return String.valueOf(x < y);
                    default:
                        throw new IllegalArgumentException("Operator Invalid: " + operation);
                }
                stackOperation.push(result);
            }
        }
        return String.valueOf(stackOperation.pop());
    }
}
