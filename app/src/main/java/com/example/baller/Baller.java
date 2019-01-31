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

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getJersey_number() {
        return jersey_number;
    }
}