package secsemassignment2;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 * @date 2018-04-12
 * @author Keon Muellerchen
 */
public class CarViewController implements Initializable {

    @FXML private TextField makeTextField;
    @FXML private TextField modelTextField;
    @FXML private Slider yearSlider;
    @FXML private ChoiceBox<String> colourChoiceBox;
    @FXML private Label sliderLabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //when window pops up, it doesnt say label, instead makes it blank
        this.sliderLabel.setText("");
        
        //create a List to populate the ChoiceBox
        List differentColours = Arrays.asList("White", "Silver", "Black", "Red", "Blue", "Yellow", "Other colour");
        this.colourChoiceBox.getItems().addAll(differentColours);
    }//end
    
    /**
     * This method will take the values from the slider and update the label formatted with two places after the decimal.
     */
    public void sliderChanged()
    {
        this.sliderLabel.setText(String.format("Year: %.0f", this.yearSlider.getValue()));
    }//end
    
    
    /**
     * This method is called when the button is pushed and will read from the text fields to 
     * create a new Car object and display it in the console.
     */
    public void createCarButtonPushed() throws IOException{
        try
        {
            //save inputs
            String make = makeTextField.getText();
            String model = modelTextField.getText();
            String colour = colourChoiceBox.getValue();
            double year = yearSlider.getValue();
            
            //Create a new car Object
            Car newCar = new Car(make, model, colour, year);
        
            System.out.print(newCar.toString()); //prints out values to console
        
            
            newCar.saveCarToFile(newCar.toString());    //sends new car to saveGameFile method
        }
        catch (IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        }
    }//end
}//end