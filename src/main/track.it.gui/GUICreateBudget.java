/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package track.it.gui;

import exception.TitleHasCommaException;
import model.Budget;
import model.BudgetList;

import java.awt.Color;

/**
 *
 * @author kungcheow
 */
public class GUICreateBudget extends javax.swing.JFrame {
    private BudgetList budgetList;
    private int budgetIndex;


    public GUICreateBudget(BudgetList budgetList) {
        initComponents();
        viewCreatedBgBtn.setVisible(false);
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

        createBudgetPanel = new javax.swing.JPanel();
        budgetTitleLabel = new javax.swing.JLabel();
        budgetTitleInput = new javax.swing.JTextField();
        budgetAmtLabel = new javax.swing.JLabel();
        budgetAmtInput = new javax.swing.JTextField();
        createBudgetBtn = new javax.swing.JButton();
        msgLabel = new javax.swing.JLabel();
        viewCreatedBgBtn = new javax.swing.JButton();
        requiredField = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuCreateBtn = new javax.swing.JMenu();
        menuViewBgListBtn = new javax.swing.JMenu();
        menuLoadBtn = new javax.swing.JMenu();
        menuDownloadBtn = new javax.swing.JMenu();
        menuSaveBtn = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create New Budget");
        setBackground(new java.awt.Color(255, 255, 255));

        createBudgetPanel.setBackground(new java.awt.Color(255, 255, 255));
        createBudgetPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        budgetTitleLabel.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        budgetTitleLabel.setForeground(new java.awt.Color(0, 51, 102));
        budgetTitleLabel.setText("Budget Title (without any comma)*");

        budgetTitleInput.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        budgetTitleInput.setToolTipText("Required field. Comma is not allowed.");
        budgetTitleInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));

        budgetAmtLabel.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        budgetAmtLabel.setForeground(new java.awt.Color(0, 51, 102));
        budgetAmtLabel.setText("Budget amount (CAD)*");
        budgetAmtLabel.setToolTipText("Required field.");

        budgetAmtInput.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        budgetAmtInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));

        createBudgetBtn.setBackground(new java.awt.Color(0, 51, 102));
        createBudgetBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        createBudgetBtn.setForeground(new java.awt.Color(255, 255, 255));
        createBudgetBtn.setText("Create");
        createBudgetBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        createBudgetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBudgetBtnActionPerformed(evt);
            }
        });

        msgLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        msgLabel.setForeground(new java.awt.Color(0, 153, 153));
        msgLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        viewCreatedBgBtn.setBackground(new java.awt.Color(0, 153, 153));
        viewCreatedBgBtn.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        viewCreatedBgBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewCreatedBgBtn.setText("View");
        viewCreatedBgBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        viewCreatedBgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCreatedBgBtnActionPerformed(evt);
            }
        });

        requiredField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        requiredField.setText("* Required field");

        javax.swing.GroupLayout createBudgetPanelLayout = new javax.swing.GroupLayout(createBudgetPanel);
        createBudgetPanel.setLayout(createBudgetPanelLayout);
        createBudgetPanelLayout.setHorizontalGroup(
            createBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createBudgetPanelLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(createBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(msgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(createBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(budgetAmtLabel)
                        .addGroup(createBudgetPanelLayout.createSequentialGroup()
                            .addComponent(createBudgetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(requiredField))
                        .addComponent(budgetAmtInput)
                        .addComponent(budgetTitleInput, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(budgetTitleLabel)
                        .addComponent(viewCreatedBgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79))
        );
        createBudgetPanelLayout.setVerticalGroup(
            createBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createBudgetPanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(budgetTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(budgetTitleInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(budgetAmtLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(budgetAmtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(createBudgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createBudgetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(requiredField))
                .addGap(28, 28, 28)
                .addComponent(msgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewCreatedBgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        menuBar.setBackground(new java.awt.Color(0, 51, 102));
        menuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 4));
        menuBar.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N

        menuCreateBtn.setForeground(new java.awt.Color(0, 51, 102));
        menuCreateBtn.setText("Create budget");
        menuCreateBtn.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        menuCreateBtn.setMargin(new java.awt.Insets(0, 0, 0, 10));
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

        menuLoadBtn.setText("Load");
        menuLoadBtn.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        menuLoadBtn.setMargin(new java.awt.Insets(0, 0, 0, 10));
        menuLoadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLoadBtnMouseClicked(evt);
            }
        });
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
            .addComponent(createBudgetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(createBudgetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(595, 540));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createBudgetBtnActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // get budgetTitleInput and budgetAmtInput, and create new Budget =========
        //Keep index of the created budget        
        try{
            String title = budgetTitleInput.getText();
            int budgetAmt = Integer.parseInt(budgetAmtInput.getText());
            if(title.trim().isEmpty()){
                viewCreatedBgBtn.setVisible(false);
                msgLabel.setText("Title cannot be blank.");
                msgLabel.setForeground(Color.red);
            }else{
                Budget budget = new Budget(title);
                budget.setBudget(budgetAmt);
                if(budgetList.isBudgetTitleDuplicated(budget)){
                    viewCreatedBgBtn.setVisible(false);
                    msgLabel.setText(budgetList.budgetDuplicateMsg(title));
                    msgLabel.setForeground(Color.red);
                }else{
                    budgetList.addBudgetItem(budget);
                    msgLabel.setText("'"+budget.getTitle()+"' is created");
                    msgLabel.setForeground(Color.blue);
                    viewCreatedBgBtn.setVisible(true);
                    budgetIndex = budgetList.getBudgetIndex(budget);
                }
            }
        }catch(NumberFormatException numberFormatException){
            viewCreatedBgBtn.setVisible(false);
            msgLabel.setText("Budget amount is not an integer. Please re-enter.");
            msgLabel.setForeground(Color.red);
        }catch(TitleHasCommaException titleCommaException){
            viewCreatedBgBtn.setVisible(false);
            msgLabel.setText(titleCommaException.titleHasCommaMsg());
            msgLabel.setForeground(Color.red);
        }
    }                                               

    private void viewCreatedBgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCreatedBgBtnActionPerformed
        GUIViewBudgetDetail bgDetail = new GUIViewBudgetDetail(budgetList, budgetIndex);
        bgDetail.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewCreatedBgBtnActionPerformed

    private void menuViewBgListBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuViewBgListBtnMouseClicked
        this.dispose();
        GUIViewBudgetList viewBudgetList = new GUIViewBudgetList(budgetList);
        viewBudgetList.setVisible(true);
    }//GEN-LAST:event_menuViewBgListBtnMouseClicked

    private void menuLoadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLoadBtnMouseClicked
        this.dispose();
        GUILoadTextFile loadTextFile = new GUILoadTextFile(budgetList);
        loadTextFile.setVisible(true);
    }//GEN-LAST:event_menuLoadBtnMouseClicked

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
//            java.util.logging.Logger.getLogger(GUICreateBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUICreateBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUICreateBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUICreateBudget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUICreateBudget(new BudgetList()).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField budgetAmtInput;
    private javax.swing.JLabel budgetAmtLabel;
    private javax.swing.JTextField budgetTitleInput;
    private javax.swing.JLabel budgetTitleLabel;
    private javax.swing.JButton createBudgetBtn;
    private javax.swing.JPanel createBudgetPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCreateBtn;
    private javax.swing.JMenu menuDownloadBtn;
    private javax.swing.JMenu menuLoadBtn;
    private javax.swing.JMenu menuSaveBtn;
    private javax.swing.JMenu menuViewBgListBtn;
    private javax.swing.JLabel msgLabel;
    private javax.swing.JLabel requiredField;
    private javax.swing.JButton viewCreatedBgBtn;
    // End of variables declaration//GEN-END:variables
}
