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
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
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
    public void showScreen(){
        this.TermText.setText("Term");
        this.DefText.setText("Definition");
    }
    public void showRecord(){    
    this.TermText.setText(flashcardList.get(index).getTerm());
    this.DefText.setText(flashcardList.get(index).getDef());
    this.setTitle("Flash Card Creator #" + index);
    }
    
    public void updateRecord() {
        flashcardList.get(index).setTerm(this.TermText.getText());
        flashcardList.get(index).setDef(this.DefText.getText());
    }

    public void addFlashcards() {
        String fileName = "c:\\flashcard\\flashcards.txt";
        String outputLine="";
        File file = new File(fileName);

        try {
            FileWriter fileOut = new FileWriter("c:\\flashcard\\flashcards.txt", true);
            for (int x = 0; x < flashcardList.size(); x++) {
                //%d integer
                //%f float or double
                //%s string
                //%n new line

                outputLine = String.format("%s,%s%n",
                flashcardList.get(x).getTerm(),
                flashcardList.get(x).getDef());
                fileOut.write(outputLine);
                
            }

            fileOut.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Cannot write flashcard file/n" + ex.getMessage(), 
                    "File IO Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates new form FileSystem
     */
    public FileSystemGUI() {
        initComponents();
        fs = FileSystems.getDefault();
        pathToFile = fs.getPath("c:\\flashcard\\flashcards.txt");
        FileSystemClass aCard;
        String line;
        try{
            flashIn = Files.newInputStream(pathToFile);
            flashcardReader = new BufferedReader(new InputStreamReader (flashIn));
            
            while((line = flashcardReader.readLine()) != null){
             String records[] = line.split(",");
             aCard = new FileSystemClass();
             
             try{
                 //aCard.setId(Integer.parseInt(records[0]));
                 aCard.setTerm(records[0]);
                 aCard.setDef(records[1]);
                 
                 flashcardList.add(aCard);
             } catch (NumberFormatException numberFormatException) {
                  //do nothing - skip the error
                    //eliminate problems with bas ids
                    //in reality you would fix this
             }
            }//end of while
            
            flashIn.close();
        }
        catch(IOException ex){
            System.out.println("Cannot open " +pathToFile.getFileName());
            System.exit(1);
        }//end of catch
        showScreen();
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
        Create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateMouseClicked(evt);
            }
        });
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CreateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DefText, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TermText, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(Create)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CreateLabel)
                .addGap(29, 29, 29)
                .addComponent(TermText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DefText, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Create))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateActionPerformed
        updateRecord();
        addFlashcards();
    }//GEN-LAST:event_CreateActionPerformed

    private void CreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateMouseClicked

    }//GEN-LAST:event_CreateMouseClicked

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
