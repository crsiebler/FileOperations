//  Assignment 1, File Operations
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: (Description of each file/class)
package fileoperations;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author csiebler
 */
class FileExistsPanel extends JPanel {

    // Define the Result strings that are reused often
    private static final String EMPTY = "";
    private static final String EXISTS = "FOUND: File exists";
    private static final String MISSING = "NOT FOUND: File does not exist";
    
    // Declare components for comparing
    JLabel inputLabel;
    JTextField inputField;
    JButton submitButton;
    JTextArea resultsArea;
    
    /**
     * Constructor initializes the components.
     */
    public FileExistsPanel() {
        initComponents();
    }
    
    /**
     * Initialize the components for the GUI
     */
    private void initComponents() {
        // Initialize the components
        inputLabel = new JLabel("File Path:");
        inputField = new JTextField();
        submitButton = new JButton("Check File");
        resultsArea = new JTextArea(10, 50);
        
        // Initialize the subpanels
        JPanel inputPanel = new JPanel();
        
        // Set the text area to not editable
        resultsArea.setEditable(false);
        
        // Add a listener for the button
        submitButton.addActionListener(new SubmitListener());
        
        // Set the layout for the panel & subpanel
        inputPanel.setLayout(new BorderLayout());
        setLayout(new BorderLayout());
        
        // Add the components to the subpanel
        inputPanel.add(inputLabel, BorderLayout.WEST);
        inputPanel.add(inputField, BorderLayout.CENTER);
        
        // Add the components to the main panel
        add(inputPanel, BorderLayout.NORTH);
        add(resultsArea, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
    }
    
    /**
     * Listener for the save button. Creates an empty file.
     */
    private class SubmitListener implements ActionListener {

        /**
         * 
         * @param e 
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear the text area before displaying results
            resultsArea.setText(EMPTY);
            
            // Grab the path for the user selected file
            File file = new File(inputField.getText());
                
            // Check if the file exists
            if (file.exists()) {
                resultsArea.append(EXISTS);
            } else {
                resultsArea.append(MISSING);
            }
        }
        
    }

}
