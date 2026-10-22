package com.example.homework02_program1;

//Name: David Sargent
//Date: 10-21-2026
//Desc: com.example.homework02_program1.ColorInfo class, takes three integers, and formats Hex String
public class ColorInfo {
    //Make three ints for RGB
    private int redNum;
    private int blueNum;
    private int greenNum;

    //Base-Constructor; Then Overloaded;
    public ColorInfo(int num1, int num2, int num3)
    {
        //R-N1; G-N2; B-N3;
        redNum = num1;
        greenNum = num2;
        blueNum = num3;
    }
    //Generated Getter & Setters
    public int getRedNum() {
        return redNum;
    }

    public void setRedNum(int redNum) {
        this.redNum = redNum;
    }

    public int getBlueNum() {
        return blueNum;
    }

    public void setBlueNum(int blueNum) {
        this.blueNum = blueNum;
    }

    public int getGreenNum() {
        return greenNum;
    }

    public void setGreenNum(int greenNum) {
        this.greenNum = greenNum;
    }
}
