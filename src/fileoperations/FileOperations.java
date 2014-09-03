//  Assignment 1, File Operations
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: (Description of each file/class)
package fileoperations;

import javax.swing.JFrame;

/**
 *
 * @author csiebler
 */
public class FileOperations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Initialize JFrame & Dimensions
            JFrame frame = new JFrame("CSE 494 - File Operations");

            // Set Default Dimension, Close Operation, Bounds, and Resizable
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Initialize the Tabbed Pane to perform file operations
            FileOperationsPane fileOperationsPanel = new FileOperationsPane();

            // Add the panel and set the frame size & visibility
            frame.add(fileOperationsPanel);
            frame.pack();
            frame.setVisible(true);
        });
    }
    
}
