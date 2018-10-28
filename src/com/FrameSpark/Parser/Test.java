package com.FrameSpark.Parser;

import static java.lang.Character.isDigit;

public class Test {

    /**
     *  Checking for the main exceptions
     * @param data
     * @return
     */
    public int mainTest(String data){
        if (moreMathSignTest(data) != 0){
            return 1;
        }
        if (spaceTest(data) != 0){
            return 2;
        }
        if (unidentifiedSignTest(data) != 0){
            return 3;
        }
        return 0;
    }

   private int moreMathSignTest(String data){
        boolean msign = false;
        for(int i=0; i< data.length();i++)
        {
            char s = data.charAt(i);
            if(isDigit(s))
            {
                msign = false;
            }
            if((s=='-' || s=='+' || s=='/' || s=='*')&&(msign)){
                return 1;
            }
            if((s=='-' || s=='+' || s=='/' || s=='*')&&(!msign)){
                msign = true;
            }

        }
        return 0;

    }
   private int spaceTest(String data){
        for(int i=0; i< data.length();i++)
        {
            if(data.charAt(i) == ' '){
                return 2;
            }
        }
        return 0;

    }
   private  int unidentifiedSignTest(String data){
        for(int i=0; i< data.length();i++)
        {
            char s = data.charAt(i);
            if(!isDigit(s) && s!='-' && s!='+' && s!='/' && s!=42 && s!='(' && s!=')' ){
                return 3;
            }
        }
        return 0;
    }

    public void TestMode(){
        Parser p = new Parser();
        double res = p.solution("(3+2)*4");
        if(res == 20.0){
            System.out.println("Test1 OK");
        }else {
            System.out.println("Test1 Error");
        }
        res = p.solution("10+5-4");
        if(res == 11.0){
            System.out.println("Test2 OK");
        }else {
            System.out.println("Test2 Error");
        }
        res = p.solution("(5+3)-(6/3)");
        if(res == 6.0){
            System.out.println("Test3 OK");
        }else {
            System.out.println("Test3 Error");
        }
    }
}
