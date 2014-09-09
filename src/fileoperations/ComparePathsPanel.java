//  Assignment 1, File Operations
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: Compare the paths of two files.
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
 * Compare the paths of two files.
 *
 * @author csiebler
 */
class ComparePathsPanel extends JPanel {
    
    // Define the Result strings that are reused often
    private static final String FILE_HEADER_1 = "File Path 1\n==========\n";
    private static final String FILE_HEADER_2 = "File Path 2\n==========\n";
    private static final String ALIKE = "Files are within the same directory!";
    private static final String DIFFERENT = "Files are in separate directories";
    private static final String CANCEL = "CANCELLED: User did not select two files";
    private static final String NEW_LINE = "\n";
    
    // Declare two file choosers to compare
    JFileChooser fileChooser1;
    JFileChooser fileChooser2;
    
    // Declare components for comparing
    JButton submitButton;
    JTextArea resultsArea;
    
    /**
     * Constructor initializes the components.
     */
    public ComparePathsPanel() {
        initComponents();
    }
    
    /**
     * Initialize the components for the GUI
     */
    private void initComponents() {
        // Initialize the components
        fileChooser1 = new JFileChooser();
        fileChooser2 = new JFileChooser();
        submitButton = new JButton("Select Files");
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
     * Listener for the submit button. Compares the two files submitted.
     */
    private class SubmitListener implements ActionListener {

        /**
         * 
         * @param e 
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Declare the return value for the file choosers
            int returnVal1, returnVal2;
            
            // Clear the text area before displaying results
            resultsArea.setText("");
            
            // Allow the user to only select files
            fileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser2.setFileSelectionMode(JFileChooser.FILES_ONLY);

            // Open file choosers for the first and second files
            returnVal1 = fileChooser1.showOpenDialog(ComparePathsPanel.this);
            returnVal2 = fileChooser2.showOpenDialog(ComparePathsPanel.this);
            
            // Make sure the user selected a file
            if (returnVal1 == JFileChooser.APPROVE_OPTION
                    && returnVal2 == JFileChooser.APPROVE_OPTION) {
                // Grab the path for the user selected files
                File file1 = fileChooser1.getSelectedFile();
                File file2 = fileChooser2.getSelectedFile();
                
                // Display the selected file paths
                resultsArea.append(FILE_HEADER_1);
                resultsArea.append(file1.getParent());
                resultsArea.append(NEW_LINE);
                resultsArea.append(NEW_LINE);
                resultsArea.append(FILE_HEADER_2);
                resultsArea.append(file2.getParent());
                
                // Check if the two paths are the same
                if (file1.getParent().equals(file2.getParent())) {
                    resultsArea.append(NEW_LINE);
                    resultsArea.append(NEW_LINE);
                    resultsArea.append(NEW_LINE);
                    resultsArea.append(ALIKE);
                } else {
                    resultsArea.append(NEW_LINE);
                    resultsArea.append(NEW_LINE);
                    resultsArea.append(NEW_LINE);
                    resultsArea.append(DIFFERENT);
                }
            } else {
                // User did not select two files
                resultsArea.setText(CANCEL);
            }
        }
        
    }
    
}
