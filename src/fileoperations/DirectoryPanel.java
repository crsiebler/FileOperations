//  Assignment 1, File Operations
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: Save a hard-coded file in a user selected directory.
package fileoperations;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author csiebler
 */
class DirectoryPanel extends JPanel {

    // Define the Result strings that are reused often
    private static final String EMPTY = "";
    private static final String FILE_NAME = "/Test.txt";
    private static final String ERROR_MESSAGE = "ERROR: Could not create file";
    private static final String CREATED = "SUCCESS: File created";
    private static final String CANCEL = "CANCELLED: User did not select a directory";
    private static final String NEW_LINE = "\n";
    
    // Declare file chooser to select the directory to save to
    JFileChooser fileChooser;
    
    // Declare components for comparing
    JButton submitButton;
    JTextArea resultsArea;
    
    /**
     * Constructor initializes the components.
     */
    public DirectoryPanel() {
        initComponents();
    }
    
    /**
     * Initialize the components for the GUI
     */
    private void initComponents() {
        // Initialize the components
        fileChooser = new JFileChooser();
        submitButton = new JButton("Save File");
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
     * Listener for the save button. Creates an empty file.
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

            // Allow the user to only select directories
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
            // Open file choosers for the first and second files
            returnVal = fileChooser.showOpenDialog(DirectoryPanel.this);
            
            // Make sure the user selected a file
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // Grab the path for the user selected file
                File file = fileChooser.getSelectedFile();
                
                // Display the selected file paths
                resultsArea.append(file.getPath());
                
                // Create a new file to write to
                File newFile = new File (file + FILE_NAME);
                
                // Create the file in the user selected directory
                try (FileWriter fw = new FileWriter(newFile)) {
                    // Write an empty string to the file
                    fw.write(EMPTY);

                    // Display success to the user
                    resultsArea.append(NEW_LINE);
                    resultsArea.append(NEW_LINE);
                    resultsArea.append(CREATED);
                } catch (IOException ex) {
                    resultsArea.setText(ERROR_MESSAGE);
                }
            } else {
                // User did not select two files
                resultsArea.setText(CANCEL);
            }
        }
        
    }

}
