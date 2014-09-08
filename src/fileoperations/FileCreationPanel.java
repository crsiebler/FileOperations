//  Assignment 1, File Operations
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: (Description of each file/class)
package fileoperations;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
class FileCreationPanel extends JPanel {

    // Define the Result strings that are reused often
    private static final String EMPTY = "";
    private static final String ERROR_MESSAGE = "ERROR: Could not create file";
    private static final String EXISTS = "ERROR: File exists";
    private static final String CREATED = "SUCCESS: File created";
    private static final String CANCEL = "CANCELLED: User did not save a file";
    private static final String NEW_LINE = "\n";
    
    // Declare two file choosers to compare
    JFileChooser fileChooser;
    
    // Declare components for comparing
    JButton submitButton;
    JTextArea resultsArea;
    
    /**
     * Constructor initializes the components.
     */
    public FileCreationPanel() {
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
        
        // Initialize the subpanels
        JPanel fileChooserPanel = new JPanel();
        
        // Set the text area to not editable
        resultsArea.setEditable(false);
        
        // Add a listener for the button
        submitButton.addActionListener(new SubmitListener());
        
        // Set the layout for the panel and subpanels
        fileChooserPanel.setLayout(new GridLayout(1, 2));
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
            
            // Open file choosers for the first and second files
            returnVal = fileChooser.showSaveDialog(FileCreationPanel.this);
            
            // Make sure the user selected a file
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // Grab the path for the user selected file
                File file = fileChooser.getSelectedFile();
                
                // Display the selected file paths
                resultsArea.append(file.getPath());
                
                // Check if the file exists
                if (file.exists()) {
                    resultsArea.append(NEW_LINE);
                    resultsArea.append(NEW_LINE);
                    resultsArea.append(EXISTS);
                } else {
                    // File does not exist, so create the file
                    try (FileWriter fw = new FileWriter(file)) {
                        // Write an empty string to the file
                        fw.write(EMPTY);
                        
                        // Display success to the user
                        resultsArea.append(NEW_LINE);
                        resultsArea.append(NEW_LINE);
                        resultsArea.append(CREATED);
                    } catch (IOException ex) {
                        resultsArea.setText(ERROR_MESSAGE);
                    }
                }
            } else {
                // User did not select two files
                resultsArea.setText(CANCEL);
            }
        }
        
    }

}
