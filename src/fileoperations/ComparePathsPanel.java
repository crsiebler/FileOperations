//  Assignment 1, File Operations
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: Compare the paths of two files.
package fileoperations;

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
        fileChooser1 = new JFileChooser();
        fileChooser2 = new JFileChooser();
        submitButton = new JButton();
        resultsArea = new JTextArea(2, 50);
        
        submitButton.addActionListener(new SubmitListener());
    }
    
    private class SubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
}
