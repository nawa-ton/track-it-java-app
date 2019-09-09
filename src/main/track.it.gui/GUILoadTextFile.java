/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package track.it.gui;

import command.LoadTextFile;
import exception.ExpensePurposeHasCommaException;
import exception.TitleHasCommaException;
import model.BudgetList;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 *
 * @author kungcheow
 */
public class GUILoadTextFile extends javax.swing.JFrame {
    private BudgetList budgetList;
    /**
     * Creates new form LoadTextFile
     */
    public GUILoadTextFile(BudgetList budgetList) {
        initComponents();
        this.budgetList = budgetList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadFilePanel = new javax.swing.JPanel();
        enterNameLabel = new javax.swing.JLabel();
        fileNameInput = new javax.swing.JTextField();
        loadBtn = new javax.swing.JButton();
        msgLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuCreateBtn = new javax.swing.JMenu();
        menuViewBgListBtn = new javax.swing.JMenu();
        menuLoadBtn = new javax.swing.JMenu();
        menuDownloadBtn = new javax.swing.JMenu();
        menuSaveBtn = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Load Text File");

        loadFilePanel.setBackground(new java.awt.Color(255, 255, 255));
        loadFilePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        enterNameLabel.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        enterNameLabel.setForeground(new java.awt.Color(0, 51, 102));
        enterNameLabel.setText("Enter file name");

        fileNameInput.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        fileNameInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));

        loadBtn.setBackground(new java.awt.Color(0, 153, 153));
        loadBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        loadBtn.setForeground(new java.awt.Color(255, 255, 255));
        loadBtn.setText("Load");
        loadBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBtnActionPerformed(evt);
            }
        });

        msgLabel.setForeground(new java.awt.Color(0, 153, 153));
        msgLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout loadFilePanelLayout = new javax.swing.GroupLayout(loadFilePanel);
        loadFilePanel.setLayout(loadFilePanelLayout);
        loadFilePanelLayout.setHorizontalGroup(
            loadFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadFilePanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(loadFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(msgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addGroup(loadFilePanelLayout.createSequentialGroup()
                        .addGroup(loadFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enterNameLabel)
                            .addComponent(fileNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        loadFilePanelLayout.setVerticalGroup(
            loadFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadFilePanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(enterNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loadFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(msgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        menuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 4));

        menuCreateBtn.setText("Create budget");
        menuCreateBtn.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        menuCreateBtn.setMargin(new java.awt.Insets(0, 0, 0, 10));
        menuCreateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCreateBtnMouseClicked(evt);
            }
        });
        menuBar.add(menuCreateBtn);

        menuViewBgListBtn.setText("View budgets");
        menuViewBgListBtn.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        menuViewBgListBtn.setMargin(new java.awt.Insets(0, 0, 0, 10));
        menuViewBgListBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuViewBgListBtnMouseClicked(evt);
            }
        });
        menuBar.add(menuViewBgListBtn);

        menuLoadBtn.setForeground(new java.awt.Color(0, 51, 102));
        menuLoadBtn.setText("Load");
        menuLoadBtn.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        menuLoadBtn.setMargin(new java.awt.Insets(0, 0, 0, 10));
        menuBar.add(menuLoadBtn);

        menuDownloadBtn.setText("Download");
        menuDownloadBtn.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        menuDownloadBtn.setMargin(new java.awt.Insets(0, 0, 0, 10));
        menuDownloadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDownloadBtnMouseClicked(evt);
            }
        });
        menuBar.add(menuDownloadBtn);

        menuSaveBtn.setText("Save");
        menuSaveBtn.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        menuSaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSaveBtnMouseClicked(evt);
            }
        });
        menuBar.add(menuSaveBtn);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loadFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loadFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(562, 297));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBtnActionPerformed
        String fileName = fileNameInput.getText();
        if(fileName.trim().isEmpty()){
            msgLabel.setText("No file chosen.");
            msgLabel.setForeground(Color.red);
        }else{
            try{
                LoadTextFile loadTextFile = new LoadTextFile();
                loadTextFile.load(fileName,budgetList);
                msgLabel.setText("Loading is done.");
                msgLabel.setForeground(Color.blue);
            }catch (NoSuchFileException noSuchFileException) {
                msgLabel.setText("File not found. Please re-enter");
                msgLabel.setForeground(Color.red);
            }catch(IOException ioException){
                System.out.println("Oops, sorry. Fail to access the file.");
                ioException.printStackTrace();
            }catch(TitleHasCommaException titleCommaException){
                System.out.println("Budget title contains non-permitted comma. Unable to load the file.");
            }catch(ExpensePurposeHasCommaException purposeCommaException){
                System.out.println("Expense purpose contains non-permitted comma. Unable to load the file.");
            }
        }
        //file not found error=============
    }//GEN-LAST:event_loadBtnActionPerformed

    private void menuCreateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCreateBtnMouseClicked
        this.dispose();
        GUICreateBudget createBudget = new GUICreateBudget(budgetList);
        createBudget.setVisible(true);
    }//GEN-LAST:event_menuCreateBtnMouseClicked

    private void menuViewBgListBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuViewBgListBtnMouseClicked
        this.dispose();
        GUIViewBudgetList viewBudgetList = new GUIViewBudgetList(budgetList);
        viewBudgetList.setVisible(true);
    }//GEN-LAST:event_menuViewBgListBtnMouseClicked

    private void menuDownloadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDownloadBtnMouseClicked
        this.dispose();
        GUIDownloadTextFile downloadTextFile = new GUIDownloadTextFile(budgetList);
        downloadTextFile.setVisible(true);
    }//GEN-LAST:event_menuDownloadBtnMouseClicked

    private void menuSaveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSaveBtnMouseClicked
        this.dispose();
        GUISaveToTextFile saveToTextFile = new GUISaveToTextFile(budgetList);
        saveToTextFile.setVisible(true);
    }//GEN-LAST:event_menuSaveBtnMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GUILoadTextFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUILoadTextFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUILoadTextFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUILoadTextFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUILoadTextFile(new BudgetList()).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterNameLabel;
    private javax.swing.JTextField fileNameInput;
    private javax.swing.JButton loadBtn;
    private javax.swing.JPanel loadFilePanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCreateBtn;
    private javax.swing.JMenu menuDownloadBtn;
    private javax.swing.JMenu menuLoadBtn;
    private javax.swing.JMenu menuSaveBtn;
    private javax.swing.JMenu menuViewBgListBtn;
    private javax.swing.JLabel msgLabel;
    // End of variables declaration//GEN-END:variables
}
