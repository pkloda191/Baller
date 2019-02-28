package com.example.baller;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Baller implements Serializable
{
    //Fields
    public String first_name;
    public String last_name;
    public int jersey_number;
    public int age;
    public int height_feet;
    public int height_inches;

    //Constructor
    public Baller(String first_name, String last_name, int jersey_number, int age, int height_feet, int height_inches)
    {
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

    @Exclude
    public void display()
    {
        System.out.println(this.first_name + " " + this.last_name + " #" + this.jersey_number + " (" + this.age + ") " + this.height_feet + "' " + this.height_inches);
    }

    //Getter/Setter Methods
    @Exclude
    public int getAge()
    {
        return this.age;
    }

    @Exclude
    public void setAge(int age)
    {
        if (age >= 1)
        {
            this.age = age;
        }
    }

    @Override
    @Exclude
    public String toString()
    {
        return getFirst_name() + " " + getLast_name() + " Age: " + getAge() + " Jersey: " + getJersey_number() + " Height: " + getHeight_feet() + "'" + getHeight_inches() + "\"";
    }

    @Exclude
    public String getFirst_name() {
        return first_name;
    }

    @Exclude
    public String getLast_name() {
        return last_name;
    }

    @Exclude
    public int getJersey_number() {
        return jersey_number;
    }

    @Exclude
    public int getHeight_feet() {
        return height_feet;
    }

    @Exclude
    public int getHeight_inches() {
        return height_inches;
    }
}