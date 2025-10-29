class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<tokens.length;i++){
            int result=0;
            String current=tokens[i];
            if (!current.equals("*") && !current.equals("-") && !current.equals("+") && !current.equals("/")) {
                stack.push(Integer.parseInt(current));
            }else{
                int a=stack.pop();
                int b=stack.pop();
                switch (current) {
                   case "*":
                    result=a*b;break;
                   case "+":
                    result=a+b;break;
                   case "-":
                    result=b-a;break;
                   case "/": 
                   result=b/a;break;
                   default :
                    break;
                };

                stack.push(result);

            }
            
        }
        return stack.peek();
    }
}
