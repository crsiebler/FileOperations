//  Assignment 1, File Operations
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: Delete the user selected file.
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
class DeleteFilePanel extends JPanel {

    // Define the Result strings that are reused often
    private static final String EMPTY = "";
    private static final String DELETED = "SUCCESS: File deleted";
    private static final String CANCEL = "CANCELLED: User did not select a file";
    private static final String NEW_LINE = "\n";
    
    // Declare file chooser to delete the selected file
    JFileChooser fileChooser;
    
    // Declare components for comparing
    JButton submitButton;
    JTextArea resultsArea;
    
    /**
     * Constructor initializes the components.
     */
    public DeleteFilePanel() {
        initComponents();
    }
    
    /**
     * Initialize the components for the GUI
     */
    private void initComponents() {
        // Initialize the components
        fileChooser = new JFileChooser();
        submitButton = new JButton("Delete File");
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
            
            // Allow the user to only select files
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            // Open file choosers for the first and second files
            returnVal = fileChooser.showOpenDialog(DeleteFilePanel.this);
            
            // Make sure the user selected a file
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // Grab the path for the user selected file
                File file = fileChooser.getSelectedFile();
                
                // Display the selected file paths
                resultsArea.append(file.getPath());
                
                file.delete();
                
                resultsArea.append(NEW_LINE);
                resultsArea.append(NEW_LINE);
                resultsArea.append(DELETED);
            } else {
                // User did not select two files
                resultsArea.setText(CANCEL);
            }
        }
        
    }

}
