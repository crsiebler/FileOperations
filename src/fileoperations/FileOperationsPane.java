//  Assignment 1, File Operations
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: Tabbed Pane to store all the file operations required. Each
//              tab represents a single request for the assignment.
package fileoperations;

import javax.swing.JTabbedPane;

/**
 * Tabbed Pane to store all the file operations required. Each tab represents a
 * single request for the assignment.
 *
 * @author csiebler
 */
class FileOperationsPane extends JTabbedPane {
    
    // Declare the Panels to insert into the Tabbed Pane
    ComparePathsPanel comparePathsPanel;
    FileCreationPanel fileCreationPanel;
    ModificationDatePanel modDatePanel;
    ModificationTimePanel modTimePanel;
    DirectoryPanel dirPanel;
    FileExistsPanel fileExistsPanel;
    ReadOnlyPanel readOnlyPanel;
    RenameFilePanel renameFilePanel;
    FileBytesPanel fileBytesPanel;
    TempFilePanel tempFilePanel;
    DeleteFilePanel deleteFilePanel;
    
    /**
     * Constructor initializes all the components in the Tabbed Pane.
     */
    public FileOperationsPane() {
        // Initialize the Panels for the File Operations
        comparePathsPanel = new ComparePathsPanel();
        fileCreationPanel = new FileCreationPanel();
        modDatePanel = new ModificationDatePanel();
        modTimePanel = new ModificationTimePanel();
        dirPanel = new DirectoryPanel();
        fileExistsPanel = new FileExistsPanel();
        readOnlyPanel = new ReadOnlyPanel();
        renameFilePanel = new RenameFilePanel();
        fileBytesPanel = new FileBytesPanel();
        tempFilePanel = new TempFilePanel();
        deleteFilePanel = new DeleteFilePanel();
        
        // Add the Panels to the Tabbed Pane
        addTab("Compare Paths", comparePathsPanel);
        addTab("Create File", fileCreationPanel);
        addTab("Modification Date", modDatePanel);
        addTab("Modification Time", modTimePanel);
        addTab("Directory", dirPanel);
        addTab("File Exists", fileExistsPanel);
        addTab("Read-Only", readOnlyPanel);
        addTab("Rename File", renameFilePanel);
        addTab("File Bytes", fileBytesPanel);
        addTab("Temporary File", tempFilePanel);
        addTab("Delete File", deleteFilePanel);
    }
    
}
