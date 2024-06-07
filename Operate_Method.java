public class Operate_Method {
    
    public static String reversePolishNotation(String[] variable){
        
        StringBuilder arrangeOperation = new StringBuilder();
        Stack opStack = new Stack();

        for(String op: variable){
            if(isOperand(op)){
                arrangeOperation.append(op).append(" ");
            }else if(op.equals("(")){
                opStack.push(op);
            }else if(op.equals(")")){
                while(!opStack.isEmpty() && !opStack.peek().equals("()")){
                    arrangeOperation.append(opStack.pop()).append(" ");
                }if(!opStack.isEmpty()){
                    opStack.pop();
                }
            }else{
                while(!opStack.isEmpty() && operator(op) <= operator(opStack.peek())){
                    arrangeOperation.append(opStack.pop()).append(" ");
                }
                opStack.push(op);
            }
        }

        while(!opStack.isEmpty()){
            arrangeOperation.append(opStack.pop()).append(" ");
        }

        return arrangeOperation.toString().trim();
    }

    private static boolean isOperand(String variable){
        return variable.matches("[a-zA-Z0-9]") || variable.equals("$");
    }

    private static int operator(String operator){
        switch (operator) {
            case ">":
            case ">=":
            case "==":
            case "!=":
            case "<":
            case "<=":
                return 0;
            case "(":
            case ")":
                return -1;
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                throw new IllegalArgumentException("Operator Invalid: " + null);
        }
    }

    public static String toString(String[] printOperand){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < printOperand.length; i++){
            result.append(printOperand[i]);

            if(i < printOperand.length-1){
                result.append(" ");
            }
        }

        return result.toString();
    }


}
