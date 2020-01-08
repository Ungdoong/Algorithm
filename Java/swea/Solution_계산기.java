package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
 
class Solution_계산기{
 
    static boolean isFound;
 
    public static void main(String args[]) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_1223.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int T = 1; T <= 10; T++) {
 
            Stack<Character> operStack = new Stack<>();
            Stack<Character> postStack = new Stack<>();
             
            Stack<Integer> calStack = new Stack<>();
 
            // [input] CaseNo DataLen
            int testLen = Integer.parseInt(br.readLine());
 
            // [input] 데이터 입력 ex. "(3+5+(4+3*6))", "3*2*6*(2+3)+4+1+5*7*8"
            String readLine = br.readLine();
             
            // Part1. 후위연산으로 변환
            for (int i = 0; i < testLen; i++) {
                char input = readLine.charAt(i);
                 
                if(input == '(') {
                    operStack.push(input);
                }else if(input == ')') {
                    while(operStack.peek()!='(') { // 연산자 스택에는 괄호가 pair로 존재
                        // 괄호 안에 연산자가 남아있는 연산자 처리 (우선순위가 높은 연산자, 혹
                        postStack.push(operStack.pop());
                    }
                    operStack.pop(); // ( ) 까지 연산을 끝냈으므로  '('을 날림
                }else if(input >= '0' && input <='9') {
                    postStack.push(input);
                }else {
                    // 연산자가 2번 연달아오기 직전 5 + 6 * 7 + 8 
                    // post: [5,6,7] oper: [+,*] input:'+' => post: [5,6,7,*,+] oper[+]
                     
                    // case1(While 통과). 우선순위가 낮거나 같은 연산자가 온 경우, 연산자 스택의 pop하여 후위연산 배열에 넣는다.
                    while(!operStack.isEmpty() && priority(input) >= priority(operStack.peek())) {
                        postStack.push(operStack.pop());
                        if(operStack.isEmpty()) {
                            break;
                        }
                    } 
                    // case2(While 무시). 우선순위가 높은 연산자가 input으로 왔을 때는, 연산자스택의 값을 pop하지 않는다.
                     
                    operStack.push(input); // 최근 연산자는 스택에 저장
                }
            }
             
            // 괄호가 없는 input 값이 주어졌다면, 마지막에 스택에는 마지막 연산자가 남아있다.
            while(!operStack.isEmpty()) {
                postStack.push(operStack.pop());
            }
            
            // Part2. 계산과정
            int x,y;
            int length = postStack.size();
            Character[] postArr = new Character[length];
            postStack.toArray(postArr);
             
            for(int i=0; i<length; i++) {
                char item = postArr[i];
                // System.out.print(item); 후위연산 변환 디버깅
                if(item >= '0' && item <= '9') {
                    calStack.push(item-'0');
                }else if(item == '*') {
                    x = calStack.pop();
                    y = calStack.pop();
                    calStack.push(x*y);
                }else if(item == '+') {
                    x = calStack.pop();
                    y = calStack.pop();
                    calStack.push(x+y);
                }
            }
 
            System.out.println(String.format("#%d %d", T, calStack.pop()));
        }
 
    }
 
    // 연산자 우선 순위 (값이 낮을 수록 우선순위가 높다)
     
    private static int priority(char c) {
        switch(c) {
        // case '(':    return 5; 
        case '*':   return 1; 
        case '-':   return 2;  
        case '+':   return 2;
        default : return -1;
        }
    }
 
}