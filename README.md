# Dietary Survey Form

## Overview
The **Dietary Survey Form** demonstrates:
- Creating and designing a graphical user interface (GUI).
- Using events to create a dynamic and responsive interface.
- Reading and implementing UML diagrams to define relationships between classes and methods.

This project captures dietary survey data, writes it to a CSV file, and provides a clear and functional user interface.

## Objectives
- Design and layout GUI components using Java Swing.
- Capture and process user input dynamically via event listeners.
- Write survey results to a CSV file in the required format.
- Implement robust exception handling for all input and output operations.

## Features
1. **Graphical User Interface**:
   - Uses `CustomJFrame` to create a form with all required input fields and buttons.
   - Incorporates aesthetic design and logical component layout.
   - Components include:
     - Text fields for user details.
     - Radio buttons for sex selection.
     - Sliders, spinners, combo boxes, and formatted text fields for dietary inputs.

2. **Event Handling**:
   - Buttons for `Submit` and `Clear` actions register event listeners.
   - Captures and processes data on `Submit` and writes it to a CSV file.
   - Resets form fields to default values on `Clear`.

3. **File Operations**:
   - Initializes the `survey_results.csv` file with the required header using the `FileHandler` class.
   - Appends submitted survey data to the CSV file without overwriting existing data.

4. **Robustness**:
   - Handles incomplete or empty submissions gracefully.
   - Ensures the GUI does not crash regardless of user input.
   - Limits input for numeric fields using formatted text fields.

## Requirements
- **Java Development Kit (JDK) 8 or higher**
- Output File:
  - `survey_results.csv`

## Class Structure
### 1. **Project4**
   - Contains the `main` method.
   - Initializes and displays the `CustomJFrame`.

### 2. **FileHandler**
   - Handles file operations for the survey results.
   - Methods:
     - `FileHandler()`: Creates `survey_results.csv` with the required header. Overwrites any existing file.
     - `writeResults(String surveyData)`: Appends survey data to the file in CSV format.

### 3. **CustomJFrame (extends JFrame)**
   - Creates the GUI for the dietary survey form.
   - Components:
     - **Labels**: Descriptive text for each input field.
     - **Text Fields**: Inputs for name, phone, email, etc.
     - **Radio Buttons**: Selection for sex (e.g., Male, Female).
     - **Spinners**: Numeric input for water and meals.
     - **Sliders**: Numeric input for dietary categories.
     - **ComboBox**: Dropdown for physical activity distance.
     - **Buttons**: `Submit` and `Clear`.

   - Inner Class:
     - **InnerActionListener**:
       - Implements `ActionListener` for button actions.
       - Methods:
         - `actionPerformed()`: Captures form data on submit, writes it to the CSV file, and clears the form.
         - `clearForm()`: Resets all fields to their default values.

## Implementation Details
### GUI Components:
1. **Text Fields**:
   - First Name, Last Name, Phone Number, Email.

2. **Radio Buttons**:
   - Sex: Male, Female (only one selectable at a time).

3. **Spinners**:
   - Numeric input for Water (min=0, max=50, default=15) and Meals (min=0, max=50, default=15).

4. **Sliders**:
   - For Wheat, Sugar, Dairy (min=0, max=10, default=3).

5. **ComboBox**:
   - Options for distance:
     - Less than 1 Mile.
     - More than 1 mile but less than 2 miles.
     - More than 2 miles but less than 3 miles.
     - More than 3 miles.
   - Default: Less than 1 Mile.

6. **Buttons**:
   - **Submit**: Captures data, writes it to `survey_results.csv`, and clears the form.
   - **Clear**: Resets all form fields to default values.

### File Operations:
1. **FileHandler**:
   - Ensures `survey_results.csv` includes the following header:
     ```csv
     DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight
     ```
   - Appends data as comma-separated values.

2. **Output Example (survey_results.csv)**:
   ```csv
   DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight
   2024-01-01 10:00:00,John,Doe,1234567890,johndoe@example.com,Male,10,3,2,4,5,Less than 1 Mile,180
