/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tracy Ayres
 */
public class FileSystemGUI extends javax.swing.JFrame {

    FileSystem fs;
    Path pathToFile;
    InputStream flashIn = null;
    BufferedReader flashcardReader;
    ArrayList<FileSystemClass> flashcardList = new ArrayList<FileSystemClass>();
    int index = 0;

    public void showScreen() {
        this.TermText.setText("Term");
        this.DefText.setText("Definition");
    }
    
    public void updateScreen() {
        flashcardList.get(index).setTerm(this.TermText.getText());
        flashcardList.get(index).setDef(this.DefText.getText());
    }

    public void addFlashcards() {
        String fileName = "c:\\flashcards\\flashcards.txt";
        String outputLine;
        File file = new File(fileName);

        try {
            FileWriter fileOut = new FileWriter(file);

            for (int x = 0; x < flashcardList.size() - 1; x++) {
                //%d integer
                //%f float or double
                //%s string
                //%n new line

                outputLine = String.format("%s,%s", flashcardList.get(x).getTerm(), flashcardList.get(x).getDef());
                fileOut.write(outputLine);
            }

            fileOut.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Cannot write flashcard file\n" + ex.getMessage(), "File IO Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates new form FileSystem
     */
    public FileSystemGUI() {
        initComponents();
        this.setTitle("Company");
        fs = FileSystems.getDefault();
        pathToFile = fs.getPath("c:\\flashcard\\flashcard.txt");
        FileSystemClass aPerson;
        String line;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CreateLabel = new javax.swing.JLabel();
        TermText = new javax.swing.JTextField();
        DefText = new javax.swing.JTextField();
        Create = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CreateLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CreateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CreateLabel.setText("Create Flashcards");

        TermText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TermText.setText("Term");

        DefText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DefText.setText("Definition");

        Create.setText("Create");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TermText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DefText, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Create))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CreateLabel)
                .addGap(42, 42, 42)
                .addComponent(TermText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DefText, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Create)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileSystemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileSystemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileSystemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileSystemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileSystemGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Create;
    private javax.swing.JLabel CreateLabel;
    private javax.swing.JTextField DefText;
    private javax.swing.JTextField TermText;
    // End of variables declaration//GEN-END:variables
}