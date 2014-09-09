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
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author csiebler
 */
class ReadOnlyPanel extends JPanel {

    // Define the Result strings that are reused often
    private static final String EMPTY = "";
    private static final String ERROR_MESSAGE = "ERROR: File could not be set to read-only";
    private static final String SUCCESS = "SUCCESS: File set to read-only";
    private static final String CANCEL = "CANCELLED: User did not select a file";
    private static final String NEW_LINE = "\n";
    
    // Declare the file chooser to select a file to analyze
    JFileChooser fileChooser;
    
    // Declare components for comparing
    JButton submitButton;
    JTextArea resultsArea;
    
    /**
     * Constructor initializes the components.
     */
    public ReadOnlyPanel() {
        initComponents();
    }
    
    /**
     * Initialize the components for the GUI
     */
    private void initComponents() {
        // Initialize the components
        fileChooser = new JFileChooser();
        submitButton = new JButton("Select File");
        resultsArea = new JTextArea(10, 50);
        
        // Set the text area to not editable
        resultsArea.setEditable(false);
        
        // Add a listener for the button
        submitButton.addActionListener(new SubmitListener());
        
        // Set the layout for the panel
        setLayout(new BorderLayout());
        
        // Add the components to the main panel
        add(resultsArea, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
    }
    
    /**
     * Listener for the open button. Reads the file & displays the file size in
     * bytes.
     */
    private class SubmitListener implements ActionListener {

        /**
         * 
         * @param e 
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Declare the return value for the file choosers
            int returnVal;
            
            // Clear the text area before displaying results
            resultsArea.setText(EMPTY);
            
            // Allow the user to only select files
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            // Open file choosers for the first and second files
            returnVal = fileChooser.showOpenDialog(ReadOnlyPanel.this);
            
            // Make sure the user selected a file
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // Grab the path for the user selected file
                File file = fileChooser.getSelectedFile();
                
                // Set file to read-only
                if (file.setReadOnly()) {
                    // Display the selected file path & success message
                    resultsArea.append(file.getPath());
                    resultsArea.append(NEW_LINE);
                    resultsArea.append(NEW_LINE);
                    resultsArea.append(SUCCESS);
                } else {
                    resultsArea.append(ERROR_MESSAGE);
                }
            } else {
                // User did not select two files
                resultsArea.setText(CANCEL);
            }
        }
        
    }

}
