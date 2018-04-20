package secsemassignment2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This is the Model class
 * @date 2018-04-12
 * @author Keon Muellerchen
 */
public class Car {
    //declare instance variable
    private String make, model, colour;
    private double year;
    private static final String[] validColours = {"White", "Silver", "Black", "Red", "Blue", "Yellow", "Other colour"};
    
    /**
     * This is the constructor, it will set all the instance variables to have a value.
     */
    public Car(String make, String model, String colour, double year)
    {
        setMake(make);
        setModel(model);
        setColour(colour);
        setYear(year);
    }//end

    
    /**
     * Returns the value of the instance variable.
     * @return 
     */
    public String getMake() {
        return make;
    }//end

    /**
     * Validates that the argument make is not empty, throws an IllegalArgumentException if it is.
     * @param make
     */
    public void setMake(String make) {
        if(make.isEmpty())
            throw new IllegalArgumentException("Must enter a car make!");
        else
            this.make = make;
    }//end

    
    /**
     * Returns the value of the instance variable.
     * @return 
     */
    public String getModel() {
        return model;
    }//end

    /**
     * Validates that the argument model is not empty, throws an IllegalArgumentException if it is.
     * @param model
     */
    public void setModel(String model) {
        if(model.isEmpty())
            throw new IllegalArgumentException("Must enter a car model!");
        else
            this.model = model;
    }//end

    
    /**
     * Returns the value of the instance variable.
     * @return 
     */
    public String getColour() {
        return colour;
    }//end

    /**
     * Validates that the argument is one of the set colour choices, throws an IllegalArgumentException if it isn't.
     * @param colour
     */
    public void setColour(String colour) {
       for (String validColour : validColours)
        {
            if (validColour.equalsIgnoreCase(colour))
            {
                this.colour = colour;
                return;
            }
        }
        throw new IllegalArgumentException("Valid colours are: White, Silver, Black, Red, Blue, Yellow, Other colour");
    }//end

    
    /**
     * Returns the value of the instance variable.
     * @return 
     */
    public double getYear() {
        return year;
    }//end

    /**
     * Validates that the argument is between 1920 - 2018, throws an IllegalArgumentException if it isn't.
     * @param year
     */
    public void setYear(double year) {
        if (year < 1920 || year > 2018)
            throw new IllegalArgumentException("Year must be between 1920 and 2018!");
        else
            this.year = year;
    }//end
    
    
    public void saveCarToFile(String stringToWrite) throws IOException {
        String FILENAME = "car.txt";
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true)))
        {
            
            bw.write(stringToWrite);
            
            System.out.println("... Car saved! ...");
            
        } catch (IOException e) 
        {
            e.printStackTrace();
        }//end of catch
    }//end of saveCarToFile
    
    /**
     * Override toString method
     * @return 
     */
    @Override
    public String toString()
    {
        return String.format("You added a " + String.format("%.0f", year) + " " + colour + " " + make + " " + model + "!");
        //return String.format("You added a %.0f %s %s %s!", year, colour , make, model);
    }//end    
}//end of Car
