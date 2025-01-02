package Project4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CustomJFrame class has all the information to create GUI. The CustomJFrame class also has an inner class called
 * innerActionListener that implements the ActionListener class, the CustomJFrame class also has a createDate string.
 * The inner class has two methods, ActionPerformed and clearForm.
 */
public class CustomJFrame extends JFrame {
    private JLabel headingLabel = new JLabel("Personal Information");
    private JLabel firstNameLabel = new JLabel("First Name: ");
    private JLabel lastNameLabel = new JLabel("Last Name: ");
    private JLabel phoneNumberLabel = new JLabel("Phone Number: ");
    private  JLabel emailLabel = new JLabel("Email: ");
    private JLabel dietaryLabel = new JLabel("Dietary Information");
    private JLabel genderLabel = new JLabel("Sex:");
    private JLabel waterLabel = new JLabel("How many cups of water do you drink a day?");
    private JLabel mealsLabel = new JLabel("How many meals on average do you eat a day?");
    private JLabel checkBoxLabel = new JLabel("Do any of these meals regularly contain:");
    private JLabel walkLabel = new JLabel("On average how many miles do you walk in a day?");
    private JLabel weightLabel = new JLabel("How much do you weigh?");
    private JTextField firstNameTextField = new JTextField("", 15);
    private JTextField lastNameTextField = new JTextField("", 15);
    private JTextField phoneNumberTextField = new JTextField("", 15);
    private JTextField emailTextField = new JTextField("", 15);
    private JRadioButton maleRadioButton = new JRadioButton("Male");
    private JRadioButton femaleRadioButton = new JRadioButton("Female");
    private JRadioButton preferRadioButton = new JRadioButton("Prefer not to answer");
    private ButtonGroup radioButtonGroup = new ButtonGroup();
    private JSpinner waterIntakeSpinner = new JSpinner(new SpinnerNumberModel(15, 0, 50, 1));
    private JSlider mealSlider = new JSlider(0,10,3);
    private JCheckBox wheatCheckBox = new JCheckBox("Wheat");
    private JCheckBox sugarCheckBox = new JCheckBox("Sugar");
    private JCheckBox dairyCheckBox = new JCheckBox("Dairy");
    private JComboBox walkComboBox = new JComboBox();
    private String[] walkOptions = {"Less than 1 Mile",
            "More than 1 mile but less than 2 miles", "More than 2 miles but less than 3 miles",
            "More than 3 miles"};
    private JFormattedTextField weightFormattedTextField;
    private JButton clearButton = new JButton("Clear");
    private JButton submitButton = new JButton("Submit");
    private FileHandler fileHandler;

    /**
     * The CustomJFrame is the constructor for the custom JFrame that sets up the layout for the gui
     */
    public CustomJFrame() {
        //variables for innerActionListener
        fileHandler = new FileHandler();
        innerActionListener listener = new innerActionListener();

        //JFrame setup variables
        setLayout(new GridBagLayout());
        GridBagConstraints layoutManager = new GridBagConstraints();
        NumberFormat numberFormatter = NumberFormat.getNumberInstance();
        numberFormatter.setGroupingUsed(false);

        //JFrame initial positioning
        layoutManager.anchor = GridBagConstraints.NORTHWEST;

        //JFrame Title
        setTitle("Dietary Survey");

        //heading
        layoutManager.gridx = 0;
        layoutManager.gridy = 0;
        this.add(headingLabel,layoutManager);//end heading

        //first name options
        layoutManager.gridx = 0;
        layoutManager.gridy = 1;
        layoutManager.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(firstNameLabel, layoutManager);
        layoutManager.insets = new Insets(0, 100, 10, 5);
        layoutManager.gridx = 0;
        this.add(firstNameTextField, layoutManager);//end first name

        //last name
        layoutManager.gridx = 0;
        layoutManager.gridy = 2;
        layoutManager.insets = new Insets(0, 0, 10, 5);
        this.add(lastNameLabel, layoutManager);
        layoutManager.insets = new Insets(0, 100, 10, 5);
        layoutManager.gridx = 0;
        this.add(lastNameTextField, layoutManager);//end last name

        //phone number
        layoutManager.gridx = 0;
        layoutManager.gridy = 3;
        layoutManager.insets = new Insets(0, 0, 10, 5);
        this.add(phoneNumberLabel, layoutManager);
        layoutManager.insets = new Insets(0, 100, 10, 5);
        layoutManager.gridx = 0;
        this.add(phoneNumberTextField, layoutManager);//end phone number

        //email
        layoutManager.gridx = 0;
        layoutManager.gridy = 4;
        layoutManager.insets = new Insets(0, 0, 10, 5);
        this.add(emailLabel, layoutManager);
        layoutManager.insets = new Insets(0, 100, 10, 5);
        layoutManager.gridx = 0;
        this.add(emailTextField, layoutManager);//end email

        //Gender options
        radioButtonGroup.add(maleRadioButton);
        radioButtonGroup.add(femaleRadioButton);
        radioButtonGroup.add(preferRadioButton);
        layoutManager.gridx = 0;
        layoutManager.gridy = 5;
        layoutManager.insets = new Insets(0, 0, 0, 0);
        this.add(genderLabel, layoutManager);
        layoutManager.insets = new Insets(0, 100, 0, 0);
        layoutManager.gridx = 0;
        layoutManager.gridy = 5;
        maleRadioButton.setActionCommand("Male");
        this.add(maleRadioButton, layoutManager);
        layoutManager.insets = new Insets(0, 100, 0, 0);
        layoutManager.gridx = 0;
        layoutManager.gridy = 6;
        femaleRadioButton.setActionCommand("Female");
        this.add(femaleRadioButton, layoutManager);
        layoutManager.insets = new Insets(0, 100, 10, 0);
        layoutManager.gridx = 0;
        layoutManager.gridy = 7;
        preferRadioButton.setActionCommand("Prefer not to answer");
        this.add(preferRadioButton, layoutManager);//end gender options

        //dietary info options
        layoutManager.anchor = GridBagConstraints.CENTER;
        layoutManager.insets = new Insets(0, 0, 10, 5);
        layoutManager.gridx = 0;
        layoutManager.gridy = 9;
        this.add(dietaryLabel, layoutManager);//end dietary options

        //Water options
        layoutManager.anchor = GridBagConstraints.CENTER;
        layoutManager.insets = new Insets(0, 0, 10, 5);
        layoutManager.gridx = 0;
        layoutManager.gridy = 12;
        this.add(waterLabel, layoutManager);
        layoutManager.gridy = 13;
        this.add(waterIntakeSpinner, layoutManager);//end water options

        //food options
        mealSlider.setMajorTickSpacing(1);
        mealSlider.setPaintTicks(true);
        mealSlider.setPaintLabels(true);

        layoutManager.gridx = 0;
        layoutManager.gridy = 15;
        layoutManager.insets = new Insets(0, 0, 10, 5);
        this.add(mealsLabel, layoutManager);
        layoutManager.gridx = 0;
        layoutManager.gridy = 16;
        this.add(mealSlider, layoutManager);//end food options

        // does food contain options
        layoutManager.gridx = 0;
        layoutManager.gridy = 17;
        layoutManager.insets = new Insets(0, 0, 10, 5);
        this.add(checkBoxLabel, layoutManager);
        layoutManager.gridx = 0;
        layoutManager.gridy = 18;
        layoutManager.insets = new Insets(0, 0, 10, 120);
        this.add(wheatCheckBox, layoutManager);
        layoutManager.insets = new Insets(0, 0, 10, 5);
        this.add(sugarCheckBox, layoutManager);
        layoutManager.insets = new Insets(0, 115, 10, 0);
        this.add(dairyCheckBox, layoutManager);//end does food contain options

        //miles walked option
        layoutManager.gridx = 0;
        layoutManager.gridy = 19;
        layoutManager.insets = new Insets(0, 0, 10, 5);
        this.add(walkLabel, layoutManager);
        layoutManager.gridx = 0;
        layoutManager.gridy = 20;
        walkComboBox.setModel(new DefaultComboBoxModel(walkOptions));
        this.add(walkComboBox, layoutManager);//end miles walked option

        //weight option
        layoutManager.gridx = 0;
        layoutManager.gridy = 21;
        layoutManager.insets = new Insets(0, 0, 10, 5);
        this.add(weightLabel, layoutManager);
        layoutManager.gridx = 0;
        layoutManager.gridy = 22;
        weightFormattedTextField = new JFormattedTextField(numberFormatter);
        weightFormattedTextField.setPreferredSize(new Dimension(150, 20));
        this.add(weightFormattedTextField, layoutManager);//end weight option

        //clear button
        layoutManager.anchor = GridBagConstraints.SOUTHWEST;
        layoutManager.gridx = 0;
        layoutManager.gridy = 24;
        layoutManager.insets = new Insets(0, 0, 10, 5);
        clearButton.setBackground(Color.yellow);
        clearButton.setName("Clear");
        clearButton.addActionListener(listener);
        this.add(clearButton, layoutManager);//end clear button

        //submit button
        layoutManager.anchor = GridBagConstraints.SOUTHEAST;
        layoutManager.gridx = 0;
        layoutManager.gridy = 24;
        layoutManager.insets = new Insets(0, 0, 10, 5);
        submitButton.setBackground(Color.green);
        submitButton.setName("Submit");
        submitButton.addActionListener(listener);
        this.add(submitButton, layoutManager);//end submit button

    }
    /**
     * The innerActionListener is an inner class within the CustomJFrame class that implements
     * the ActionListener, the inner class also has two methods.
     */
    class innerActionListener implements ActionListener
    {
        /**
         * The actionPerformed method listens for an event from the GUI, if the event String returns
         * "Submit", it will process the user information and write to a file and clear the form. If the String returns
         * anything else it will clear the form and not write anything to a file. Calls the clearForm method.
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JButton button = (JButton) e.getSource();
            String name = button.getName();
            String buttonSelection;
            String surveyData;

            //create date | Notes originally had a method for create date similar to Project3, removed due to not being specified in UML
            String dateCreated;
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
            Date date = new Date();
            dateCreated = dateFormat.format(date);
            //end create date | Notes originally had a method for create date similar to Project, removed due to not being specified in UML

            if(radioButtonGroup.getSelection() != null)
            {
                buttonSelection = radioButtonGroup.getSelection().getActionCommand();
            }else{
                buttonSelection = "";
            }

            if(name.equals("Submit")){
                surveyData = dateCreated+","+firstNameTextField.getText()+","
                        +lastNameTextField.getText()+","+phoneNumberTextField.getText()+","
                        +emailTextField.getText()+","+buttonSelection+","
                        +waterIntakeSpinner.getValue()+","+mealSlider.getValue()+","
                        +wheatCheckBox.isSelected()+","+sugarCheckBox.isSelected()+","
                        +dairyCheckBox.isSelected()+","+walkComboBox.getSelectedItem()+","
                        +weightFormattedTextField.getText();
                fileHandler.writeResults(surveyData);
                clearForm();
            }else{
                clearForm();
            }
        }//end action performed

        /**
         * clearForm method resets all the fields to the default values:
         * water = 15,meals = 3, walk = selection 0, all fields set to "" for
         * empty string.
         */
        private void clearForm()
        {
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            phoneNumberTextField.setText("");
            emailTextField.setText("");
            radioButtonGroup.clearSelection();
            waterIntakeSpinner.setValue(15);
            mealSlider.setValue(3);
            dairyCheckBox.setSelected(false);
            wheatCheckBox.setSelected(false);
            sugarCheckBox.setSelected(false);
            walkComboBox.setSelectedIndex(0);
            weightFormattedTextField.setText("");
        }//end clearForm
    }//end class innerActionListener

}

