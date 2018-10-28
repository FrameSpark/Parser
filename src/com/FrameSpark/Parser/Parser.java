package com.FrameSpark.Parser;

import java.util.Stack;
import static java.lang.Character.isDigit;
import com.FrameSpark.Parser.Sign;

public class Parser {

    private String postfix;

    /**
     *
     * @param st Mathematical expression
     * @return solution
     */
    public Double solution(String st){
        convertInPostFix(st);
        return solutionPostFix();
    }

    /**
     *
     * @param line Convert to postfix
     */

    private void convertInPostFix(String line) {
        Stack<Sign> st = new Stack<>();
        st.push(new Sign(' ',0));
        int weight;
        String temp = new String();
        char tempChar;
        char item;
        boolean digit = false;
        for (int i = 0; i < line.length(); i++) {
            tempChar = line.charAt(i);
            if (isDigit(tempChar)) {   //если цифра
                temp += tempChar;
                digit = true;
            } else {
                if(digit) { //добавление разделителей
                    temp +='|';
                    digit = false;
                }

                weight = getWeight(tempChar); //вес текущего символа
                Sign signTemp = (Sign)st.peek();

                if (st.empty() || weight == 0 || weight > signTemp.getWeight()) { //вес 0 либо больше чем в верхушке стека
                    st.push(new Sign(tempChar, weight));
                } else {

                    while (!st.empty() && signTemp.getWeight() >= weight) {
                        signTemp = (Sign)st.pop();
                        temp += signTemp.getS();
                        signTemp = (Sign)st.peek();

                    }
                    if (line.charAt(i) != '(' && line.charAt(i) != ')') {
                        st.push(new Sign(tempChar, weight));
                    }
                }
            }
        }
        Sign signTemp;
        while (!st.empty()) {
            signTemp = (Sign)st.pop();
            if (signTemp.getS() != '(' && signTemp.getS() != ')') {
                temp += signTemp.getS();
            }
        }
        this.postfix = temp;
    }
    private int getWeight(char sign){
        switch(sign){
            case '(' : return 0;

            case ')' : return 1;

            case '+' : return 2;

            case '-' : return 2;

            case '*' : return 3;

            case '/' : return 3;

        }
        return 0;
    }
    private Double solutionPostFix(){
        Double temp=0.0;
        Stack<Double> st = new Stack<>();
        char c;
        double m=1;

        for(int i=0; i<postfix.length();i++){
           c = postfix.charAt(i);




           if(isDigit(c)){
                temp *=m;
                temp += (c-48);
                m *=10.0;
            }
            if((c == '|' || c == '+' || c == '-' || c=='/' || c=='*') &&temp!=0.0 ) {
                m=1;
                st.push(temp);
                temp = 0.0;

            }
        if(c == '|' || c == '+' || c == '-' || c=='/' || c=='*') {
            switch (c) {
                case '+':
                    st.push(st.pop() + st.pop());
                    break;
                case '-':
                    st.push((st.pop() - st.pop())*(-1.0));
                    break;
                case '*':
                    st.push(st.pop() * st.pop());
                    break;

                case '/':
                    double f = st.pop();
                    double s = st.pop();
                    st.push(s / f);
                    break;

            }
        }
        }
        return st.pop();
    }

}