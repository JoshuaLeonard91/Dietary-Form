package Project4;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The fileHandler class handles all the files and has a method that is called to append to the csv file,
 * the FileHandler constructor creates the new file and sets append to false and also adds the header, when the writeResult
 * method is called its set to append to the file. As long as the program is running it will append to the csv file, if the program
 * is restarted it will create a new file
 */
public class FileHandler {
    private String surveyFile = "survey_results.csv";
    private FileWriter fileOutput;
    private PrintWriter printWriter;

    /**
     * The fileHandler constructor creates and/or overwrites the file everytime this is called, usually once during the start
     * of the program in the CustomJFrame class. The constructors write the header information for the csv file.
     * @throws IOException
     */
    public FileHandler() {
        try {
            //append == false == creates new file
            fileOutput = new FileWriter(surveyFile,false);
            printWriter = new PrintWriter(fileOutput);
            printWriter.write("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight\n");
        }catch (FileNotFoundException e) {
            System.out.println("*Error creating file*"+e.getMessage());
        } catch (IOException e) {
            System.out.println("*Error writing to file*"+" "+e.getMessage());
        }
        try {
            fileOutput.close();
        } catch (IOException e) {
            System.out.println("*Error closing file output stream*"+e.getMessage());
        }
        printWriter.close();
    }//end file handler

    /**
     * The writeResult method is called in the CustomJFrame class to append the data results from the Dietary Survey
     * gui application
     * @param surveyData String
     */
    public void writeResults(String surveyData) {

        try
        {
            //append == true == doesnt erase file
            fileOutput = new FileWriter(surveyFile,true);
            printWriter = new PrintWriter(fileOutput);
            printWriter.write(surveyData+"\n");
        } catch (FileNotFoundException e) {
            System.out.println("*Error opening file*"+e.getMessage());
        } catch (IOException e) {
            System.out.println("*Error writing to file*"+" "+e.getMessage());
        }
        try {
            fileOutput.close();
        }
        catch (IOException e) {
            System.out.println("*Error closing file output stream*"+e.getMessage());
        }
        printWriter.close();

    }//end write result

}
