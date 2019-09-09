/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package track.it.gui;

import command.saveTool.SaveReportToTextFile;
import command.saveTool.SaveReportToTextFilePercent;
import model.BudgetList;
import model.forex.ForexListBuilder;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author kungcheow
 */
public class GUIDownloadTextFile extends javax.swing.JFrame {
    private String fileName;
    private String selectedReportType;
    private String selectedCurrency;
    private BudgetList budgetList;
    private ForexListBuilder forexListBuilder;
    /**
     * Creates new form DownloadTextFile
     */
    public GUIDownloadTextFile(BudgetList budgetList) {
        initComponents();
        this.budgetList = budgetList;
        forexListBuilder = new ForexListBuilder();
        msgLabel.setBorder(new LineBorder(Color.WHITE,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reportTypeRadioBtnGroup = new javax.swing.ButtonGroup();
        currencyRadioBtnGroup = new javax.swing.ButtonGroup();
        downloadPanel = new javax.swing.JPanel();
        selectFileLabel = new javax.swing.JLabel();
        reportTypePanel = new javax.swing.JPanel();
        simpleReportRadio = new javax.swing.JRadioButton();
        detailReportRadio = new javax.swing.JRadioButton();
        reportTypeLabel = new javax.swing.JLabel();
        currencyPanel = new javax.swing.JPanel();
        cadRadio = new javax.swing.JRadioButton();
        usdRadio = new javax.swing.JRadioButton();
        gbpRadio = new javax.swing.JRadioButton();
        eurRadio = new javax.swing.JRadioButton();
        currencyLabel = new javax.swing.JLabel();
        downloadBtn = new javax.swing.JButton();
        fileNameLabel = new javax.swing.JLabel();
        fileNameInput = new javax.swing.JTextField();
        requiredField = new javax.swing.JLabel();
        msgLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuCreateBtn = new javax.swing.JMenu();
        menuViewBgListBtn = new javax.swing.JMenu();
        menuLoadBtn = new javax.swing.JMenu();
        menuDownloadBtn = new javax.swing.JMenu();
        menuSaveBtn = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Download Report");

        downloadPanel.setBackground(new java.awt.Color(255, 255, 255));
        downloadPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));

        selectFileLabel.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        selectFileLabel.setForeground(new java.awt.Color(0, 51, 102));
        selectFileLabel.setText("Select report type and currency");

        reportTypePanel.setBackground(new java.awt.Color(0, 51, 102));

        simpleReportRadio.setBackground(new java.awt.Color(0, 51, 102));
        reportTypeRadioBtnGroup.add(simpleReportRadio);
        simpleReportRadio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        simpleReportRadio.setForeground(new java.awt.Color(255, 255, 255));
        simpleReportRadio.setSelected(true);
        simpleReportRadio.setText("Simple report");

        detailReportRadio.setBackground(new java.awt.Color(0, 51, 102));
        reportTypeRadioBtnGroup.add(detailReportRadio);
        detailReportRadio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        detailReportRadio.setForeground(new java.awt.Color(255, 255, 255));
        detailReportRadio.setText("Detailed report");

        reportTypeLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        reportTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        reportTypeLabel.setText("Report type");

        javax.swing.GroupLayout reportTypePanelLayout = new javax.swing.GroupLayout(reportTypePanel);
        reportTypePanel.setLayout(reportTypePanelLayout);
        reportTypePanelLayout.setHorizontalGroup(
            reportTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportTypePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(reportTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportTypeLabel)
                    .addComponent(simpleReportRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(detailReportRadio)
                .addGap(20, 20, 20))
        );
        reportTypePanelLayout.setVerticalGroup(
            reportTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportTypePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(reportTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(reportTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpleReportRadio)
                    .addComponent(detailReportRadio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        currencyPanel.setBackground(new java.awt.Color(0, 51, 102));

        cadRadio.setBackground(new java.awt.Color(0, 51, 102));
        currencyRadioBtnGroup.add(cadRadio);
        cadRadio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cadRadio.setForeground(new java.awt.Color(255, 255, 255));
        cadRadio.setSelected(true);
        cadRadio.setText("CAD");

        usdRadio.setBackground(new java.awt.Color(0, 51, 102));
        currencyRadioBtnGroup.add(usdRadio);
        usdRadio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        usdRadio.setForeground(new java.awt.Color(255, 255, 255));
        usdRadio.setText("USD");

        gbpRadio.setBackground(new java.awt.Color(0, 51, 102));
        currencyRadioBtnGroup.add(gbpRadio);
        gbpRadio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        gbpRadio.setForeground(new java.awt.Color(255, 255, 255));
        gbpRadio.setText("GBP");

        eurRadio.setBackground(new java.awt.Color(0, 51, 102));
        currencyRadioBtnGroup.add(eurRadio);
        eurRadio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        eurRadio.setForeground(new java.awt.Color(255, 255, 255));
        eurRadio.setText("EUR");

        currencyLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        currencyLabel.setForeground(new java.awt.Color(255, 255, 255));
        currencyLabel.setText("Currency");

        javax.swing.GroupLayout currencyPanelLayout = new javax.swing.GroupLayout(currencyPanel);
        currencyPanel.setLayout(currencyPanelLayout);
        currencyPanelLayout.setHorizontalGroup(
            currencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currencyPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(currencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currencyLabel)
                    .addGroup(currencyPanelLayout.createSequentialGroup()
                        .addComponent(cadRadio)
                        .addGap(18, 18, 18)
                        .addComponent(usdRadio)
                        .addGap(18, 18, 18)
                        .addComponent(gbpRadio)
                        .addGap(18, 18, 18)
                        .addComponent(eurRadio)))
                .addGap(16, 16, 16))
        );
        currencyPanelLayout.setVerticalGroup(
            currencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currencyPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(currencyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(currencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cadRadio)
                    .addComponent(usdRadio)
                    .addComponent(gbpRadio)
                    .addComponent(eurRadio))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        downloadBtn.setBackground(new java.awt.Color(0, 153, 153));
        downloadBtn.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        downloadBtn.setForeground(new java.awt.Color(255, 255, 255));
        downloadBtn.setText("Download Report");
        downloadBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        downloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadBtnActionPerformed(evt);
            }
        });

        fileNameLabel.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
        fileNameLabel.setForeground(new java.awt.Color(0, 51, 102));
        fileNameLabel.setText("Enter file name without extension");

        fileNameInput.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        fileNameInput.setToolTipText("");
        fileNameInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));

        requiredField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        requiredField.setText("Required field");

        msgLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        msgLabel.setForeground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout downloadPanelLayout = new javax.swing.GroupLayout(downloadPanel);
        downloadPanel.setLayout(downloadPanelLayout);
        downloadPanelLayout.setHorizontalGroup(
            downloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(downloadPanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(downloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(requiredField)
                    .addGroup(downloadPanelLayout.createSequentialGroup()
                        .addGroup(downloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fileNameLabel)
                            .addComponent(selectFileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reportTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(currencyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, downloadPanelLayout.createSequentialGroup()
                        .addComponent(fileNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(downloadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(msgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        downloadPanelLayout.setVerticalGroup(
            downloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(downloadPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(selectFileLabel)
                .addGap(18, 18, 18)
                .addGroup(downloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(currencyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportTypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(fileNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(downloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(downloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requiredField)
                .addGap(33, 33, 33)
                .addComponent(msgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
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

        menuLoadBtn.setText("Load");
        menuLoadBtn.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        menuLoadBtn.setMargin(new java.awt.Insets(0, 0, 0, 10));
        menuLoadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLoadBtnMouseClicked(evt);
            }
        });
        menuBar.add(menuLoadBtn);

        menuDownloadBtn.setForeground(new java.awt.Color(0, 51, 102));
        menuDownloadBtn.setText("Download");
        menuDownloadBtn.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        menuDownloadBtn.setMargin(new java.awt.Insets(0, 0, 0, 10));
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
            .addComponent(downloadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(downloadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(833, 503));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void downloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadBtnActionPerformed
        if(fileNameInput.getText().trim().isEmpty()){
            msgLabel.setText("File name cannot be left blank.");
            msgLabel.setForeground(Color.red);
        }else{
            fileName = fileNameInput.getText()+ ".csv";
            simpleReportRadio.setActionCommand("simple");
            detailReportRadio.setActionCommand("detail");
            selectedReportType = reportTypeRadioBtnGroup.getSelection().getActionCommand();
            System.out.println(selectedReportType);
            cadRadio.setActionCommand("CAD");
            usdRadio.setActionCommand("USD");
            gbpRadio.setActionCommand("GBP");
            eurRadio.setActionCommand("EUR");
            selectedCurrency = currencyRadioBtnGroup.getSelection().getActionCommand();
            System.out.println(selectedCurrency);

            //download to text file
            if(selectedReportType.equals("simple")){
                try {
                    SaveReportToTextFile saveReportToTextFile = new SaveReportToTextFile();
                    saveReportToTextFile.save(fileName,budgetList,forexListBuilder.getCurrency(selectedCurrency));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (UnsupportedEncodingException unicodeException) {
                    unicodeException.printStackTrace();
                }
            }else{
                try {
                    SaveReportToTextFilePercent saveReportToTextFilePercent = new SaveReportToTextFilePercent();
                    saveReportToTextFilePercent.save(fileName,budgetList,forexListBuilder.getCurrency(selectedCurrency));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (UnsupportedEncodingException unicodeException) {
                    unicodeException.printStackTrace();
                }
            }
            String filePath = new File(fileName).getAbsolutePath();
            msgLabel.setText("Text file can be found at "+filePath);
            msgLabel.setForeground(Color.blue);
        }

        
    }//GEN-LAST:event_downloadBtnActionPerformed

    private void downloadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadBtnMouseClicked
        this.dispose();
        GUIDownloadTextFile downloadTextFile = new GUIDownloadTextFile(budgetList);
        downloadTextFile.setVisible(true);
    }//GEN-LAST:event_downloadBtnMouseClicked

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

    private void menuLoadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLoadBtnMouseClicked
        this.dispose();
        GUILoadTextFile loadTextFile = new GUILoadTextFile(budgetList);
        loadTextFile.setVisible(true);
    }//GEN-LAST:event_menuLoadBtnMouseClicked

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
//            java.util.logging.Logger.getLogger(GUIDownloadTextFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUIDownloadTextFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUIDownloadTextFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUIDownloadTextFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUIDownloadTextFile(new BudgetList()).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton cadRadio;
    private javax.swing.JLabel currencyLabel;
    private javax.swing.JPanel currencyPanel;
    private javax.swing.ButtonGroup currencyRadioBtnGroup;
    private javax.swing.JRadioButton detailReportRadio;
    private javax.swing.JButton downloadBtn;
    private javax.swing.JPanel downloadPanel;
    private javax.swing.JRadioButton eurRadio;
    private javax.swing.JTextField fileNameInput;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JRadioButton gbpRadio;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCreateBtn;
    private javax.swing.JMenu menuDownloadBtn;
    private javax.swing.JMenu menuLoadBtn;
    private javax.swing.JMenu menuSaveBtn;
    private javax.swing.JMenu menuViewBgListBtn;
    private javax.swing.JLabel msgLabel;
    private javax.swing.JLabel reportTypeLabel;
    private javax.swing.JPanel reportTypePanel;
    private javax.swing.ButtonGroup reportTypeRadioBtnGroup;
    private javax.swing.JLabel requiredField;
    private javax.swing.JLabel selectFileLabel;
    private javax.swing.JRadioButton simpleReportRadio;
    private javax.swing.JRadioButton usdRadio;
    // End of variables declaration//GEN-END:variables
}
