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
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author csiebler
 */
class ModificationTimePanel extends JPanel {

    // Define the Result strings that are reused often
    private static final String EMPTY = "";
    private static final String MODIFICATION = "Modification Time\n============\n";
    private static final String CANCEL = "CANCELLED: User did not select a file";
    private static final String NEW_LINE = "\n";
    
    // Declare two file choosers to compare
    JFileChooser fileChooser;
    
    // Declare components for comparing
    JButton submitButton;
    JTextArea resultsArea;
    
    /**
     * Constructor initializes the components.
     */
    public ModificationTimePanel() {
        initComponents();
    }
    
    /**
     * Initialize the components for the GUI
     */
    private void initComponents() {
        // Initialize the components
        fileChooser = new JFileChooser();
        submitButton = new JButton("Open File");
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
     * Listener for the open button. Reads the file & displayed the modification
     * time.
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
            returnVal = fileChooser.showOpenDialog(ModificationTimePanel.this);
            
            // Make sure the user selected a file
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // Format the date
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                
                // Grab the path for the user selected file
                File file = fileChooser.getSelectedFile();
                
                // Display the selected file path & modification date
                resultsArea.append(file.getPath());
                resultsArea.append(NEW_LINE);
                resultsArea.append(NEW_LINE);
                resultsArea.append(MODIFICATION);
                resultsArea.append(sdf.format(file.lastModified()));
            } else {
                // User did not select two files
                resultsArea.setText(CANCEL);
            }
        }
        
    }

}
