//  Assignment 1, File Operations
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: Rename a file from the user input and selection.
package fileoperations;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author csiebler
 */
class RenameFilePanel extends JPanel {

    // Define the Result strings that are reused often
    private static final String EMPTY = "";
    private static final String INPUT_ERROR = "ERROR: Must input a file name";
    private static final String RENAME_ERROR = "ERROR: File could not be renamed";
    private static final String SUCCESS = "SUCCESS: File renamed";
    private static final String CANCEL = "CANCELLED: User did not select a file";
    private static final String NEW_LINE = "\n";

    // Declare file chooser to save a file
    JFileChooser fileChooser;
    
    // Declare components for comparing
    JLabel inputLabel;
    JTextField inputField;
    JButton submitButton;
    JTextArea resultsArea;
    
    /**
     * Constructor initializes the components.
     */
    public RenameFilePanel() {
        initComponents();
    }
    
    /**
     * Initialize the components for the GUI
     */
    private void initComponents() {
        // Initialize the components
        inputLabel = new JLabel("File Name:");
        inputField = new JTextField();
        submitButton = new JButton("Rename File");
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
            // Check that the user input a file name
            if (inputField.getText().isEmpty()) {
                // Declare the return value for the file choosers
                int returnVal;

                // Clear the text area before displaying results
                resultsArea.setText(EMPTY);

                // Allow the user to only select files
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                // Open file choosers for the first and second files
                returnVal = fileChooser.showOpenDialog(RenameFilePanel.this);

                // Make sure the user selected a file
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    // Grab the path for the user selected file
                    File file = fileChooser.getSelectedFile();

                    // Rename the file to the user input
                    if (file.renameTo(new File(inputField.getText()))) {
                        // Display the selected file path & success message
                        resultsArea.append(file.getPath());
                        resultsArea.append(NEW_LINE);
                        resultsArea.append(NEW_LINE);
                        resultsArea.append(SUCCESS);
                    } else {
                        // Could not rename the file so display error message
                        resultsArea.append(RENAME_ERROR);
                    }
                } else {
                    // User did not select two files
                    resultsArea.setText(CANCEL);
                }
            } else {
                // User did not input a file name
                resultsArea.setText(INPUT_ERROR);
            }
        }
        
    }

}
