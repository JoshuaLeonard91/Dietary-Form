/*
 * Author: Joshua Leonard
 * Course: COP3503
 * Project #: 4
 * Title: Project 4 GUI
 * Due Date: 8/05/2022
 *
 * Program creates a GUI called Dietary Survey and takes in userInputs,
 * the GUI will listen for user action on the submit button or clear button,
 * either clearing the form or writing to a file and then clearing the form,
 * appends user information to a text file, if the program is restarted it
 * will overwrite and/or create a new file.
 */
package Project4;

import javax.swing.*;

/**
 * This class holds the main method and is mainly used to initialize the CustomJFrame
 * and display it.
 */
public class Project4 {
    public static void main(String[] args) {
        //creates JFrame
        CustomJFrame frame = new CustomJFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
    }

}
