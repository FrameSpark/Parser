package com.FrameSpark;


import com.FrameSpark.Parser.*;
import com.FrameSpark.Parser.Test;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);
    String data = new String();
    Parser p = new Parser();

    Test tester = new Test();
    boolean testm = true;

    if (testm == false){
    if(tester.mainTest(data) != 0){
        controller.print("Error!");
    }
    else {
        controller.print("Enter the mathematical expression");
        data = scanner.nextLine();
        System.out.println(p.solution(data));

    }
    }
    else{
        tester.TestMode();
    }

}}
