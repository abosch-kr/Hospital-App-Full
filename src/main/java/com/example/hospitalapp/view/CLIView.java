package com.example.hospitalapp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLIView implements View
{
    private final Scanner input = new Scanner(System.in);

    @Override
    public void output(String message)
    {
        System.out.print(message);
    }

    @Override
    public void outputNewLine(String message)
    {
        System.out.println(message);
    }

    @Override
    public String strInput()
    {
        return input.next();
    }

    @Override
    public int intInput()
    {
        int val = -1;
        try {
            val = input.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Enter an integer");
        }
        return val;
    }
}
