package day_12_Assignment;
import java.io.File;
import java.io.IOException;

public class CreateFileDemo
{
    public static void main(String[] args)
    {

        try {
            File file = new File("Arfin.txt");
            
          	if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }
      
      	// Exception Thrown
        catch (IOException e) {
            System.out.println("An error has occurred."+e);
           // e.printStackTrace();
        }
    }
}