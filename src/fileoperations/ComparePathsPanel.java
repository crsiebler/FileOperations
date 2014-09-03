//  Assignment 1, File Operations
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: Compare the paths of two files.
package fileoperations;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        submitButton = new JButton("Submit");
        resultsArea = new JTextArea(2, 50);
        
        // Initialize the subpanels
        JPanel fileChooserPanel = new JPanel();
        
        // Set the text area to not editable
        resultsArea.setEditable(false);
        
        // Add a listener for the button
        submitButton.addActionListener(new SubmitListener());
        
        // Set the layout for the panel and subpanels
        fileChooserPanel.setLayout(new GridLayout(1, 2));
        setLayout(new BorderLayout());
        
        // Add the file choosers to the subpanel
        fileChooserPanel.add(fileChooser1);
        fileChooserPanel.add(fileChooser2);
        
        // Add the components to the main panel
        add(fileChooserPanel, BorderLayout.NORTH);
        add(resultsArea, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
    }
    
    /**
     * Listener for the submit button. Compares the two files submitted.
     */
    private class SubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
}
