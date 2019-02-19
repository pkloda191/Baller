package com.example.baller;

public class Baller {
    //Fields
    private String first_name;
    private String last_name;
    private int jersey_number;
    private int age;
    private int height_feet;
    private int height_inches;

    //Constructor
    public Baller(String first_name, String last_name, int jersey_number, int age, int height_feet, int height_inches) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.jersey_number = jersey_number;
        this.age = age;
        this.height_feet = height_feet;
        this.height_inches = height_inches;
    }


    public Baller()
    {
        this.first_name = "FNAME";
        this.last_name = "LNAME";
        this.age = 0;
        this.jersey_number = 0;
        this.height_inches = 0;
        this.height_feet = 0;
    }

    public void display() {
        System.out.println(this.first_name + " " + this.last_name + " #" + this.jersey_number + " (" + this.age + ") " + this.height_feet + "' " + this.height_inches);
        //System.out.format("%s %c %s (%d)", this.first_name, this.middle_initial, this.last_name, this.age);
    }

    //Getter/Setter Methods
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age >= 1) {
            this.age = age;
        }
    }

    @Override
    public String toString()
    {
        return getFirst_name() + " " + getLast_name() + " Age: " + getAge() + " Jersey: " + getJersey_number() + " Height: " + getHeight_feet() + "'" + getHeight_inches() + "\"";
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getJersey_number() {
        return jersey_number;
    }

    public int getHeight_feet() {
        return height_feet;
    }

    public int getHeight_inches() {
        return height_inches;
    }
}