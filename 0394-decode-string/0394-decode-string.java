class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                String ns = "";
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    ns = stack.pop() + ns;
                }
                if (!stack.isEmpty()) {
                    stack.pop(); 
                }
                
                String repcnt = "";
                while (!stack.isEmpty() && stack.peek().matches("\\d+")) {
                    repcnt = stack.pop() + repcnt;
                }
                
                int k = Integer.parseInt(repcnt);
                StringBuilder decstr = new StringBuilder();
                for (int i = 0; i < k; i++) {
                    decstr.append(ns);
                }
                stack.push(decstr.toString());
            } else {
                stack.push(String.valueOf(ch));
            }
        }

        StringBuilder res = new StringBuilder();
        for (String tos : stack) {
            res.append(tos);
        }
        return res.toString();
    }
}