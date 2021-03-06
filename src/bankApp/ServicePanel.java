/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankApp;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter
 */
public class ServicePanel extends javax.swing.JFrame {

    private BankClient client;

    /**
     * Creates new form ServicePanel
     */
    public ServicePanel(BankClient client) {
        this.client = client;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblCardNum = new javax.swing.JLabel();
        jtxtCardNumber = new javax.swing.JTextField();
        jbtnTokenize = new javax.swing.JButton();
        jlblCardError = new javax.swing.JLabel();
        jlblFirstRes = new javax.swing.JLabel();
        jtxtTokenResult = new javax.swing.JTextField();
        jlblToken = new javax.swing.JLabel();
        jtxtToken = new javax.swing.JTextField();
        jlblTokenError = new javax.swing.JLabel();
        jbtnDetokenize = new javax.swing.JButton();
        jlblSecondRes = new javax.swing.JLabel();
        jtxtCardResult = new javax.swing.JTextField();
        jlblMessage = new javax.swing.JLabel();
        jbtnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlblCardNum.setText("Card Number:");

        jtxtCardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCardNumberActionPerformed(evt);
            }
        });

        jbtnTokenize.setText("TOKENIZE");
        jbtnTokenize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTokenizeActionPerformed(evt);
            }
        });

        jlblFirstRes.setText("Result:");

        jlblToken.setText("Token:");

        jtxtToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtTokenActionPerformed(evt);
            }
        });

        jbtnDetokenize.setText("DETOKENIZE");
        jbtnDetokenize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDetokenizeActionPerformed(evt);
            }
        });

        jlblSecondRes.setText("Result:");

        jlblMessage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblMessage.setForeground(new java.awt.Color(0, 255, 0));
        jlblMessage.setToolTipText("");

        jbtnLogout.setText("Log out");
        jbtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlblMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblToken, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlblCardNum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jlblCardError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jtxtCardNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                                            .addComponent(jtxtToken, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlblTokenError, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(56, 56, 56)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jbtnTokenize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jlblFirstRes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtxtTokenResult)
                                            .addComponent(jbtnDetokenize, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                            .addComponent(jlblSecondRes, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtxtCardResult))))))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlblSecondRes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblCardNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnTokenize, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jtxtCardNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblCardError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblFirstRes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtTokenResult, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlblToken, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtToken, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnDetokenize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblTokenError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtCardResult, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtCardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCardNumberActionPerformed
        String cardText = jtxtCardNumber.getText();
        if (!cardText.matches("\\d{16}")) {
            jlblCardError.setText("Wrong format! Card number must contain 16 digits");
        } else {
            jlblCardError.setText("");
        }
    }//GEN-LAST:event_jtxtCardNumberActionPerformed

    private void jtxtTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtTokenActionPerformed
        String tokenText = jtxtToken.getText();
        if (!tokenText.matches("\\d{16}")) {
            jlblTokenError.setText("Wrong format! Token must contain 16 digits!");
        } else {
            jlblTokenError.setText("");
        }
    }//GEN-LAST:event_jtxtTokenActionPerformed

    private void jbtnTokenizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTokenizeActionPerformed
        String cardNum = jtxtCardNumber.getText();
        try {
            String token = client.getServer().tokenize(cardNum);
            if (!token.startsWith("Error")) {
                jtxtTokenResult.setText(token);
                jlblMessage.setText("Successfully registered token!");
            } else {
                jlblMessage.setText("Unable to tokenize! Wrong information"
                        + " or low privilege level");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ServicePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnTokenizeActionPerformed

    private void jbtnDetokenizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDetokenizeActionPerformed
        String token = jtxtToken.getText();
        String cardNum;
        try {
            cardNum = client.getServer().detokenize(token);
            if (cardNum != null) {
                jtxtCardResult.setText(cardNum);
                jlblMessage.setText("Successful detokenization!");
            } else {
                jlblMessage.setText("Ubable to detokenize! Incorrect token or"
                        + " low privilege level");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ServicePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnDetokenizeActionPerformed

    private void jbtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLogoutActionPerformed
        try {
            client.getServer().closeConnection();
            client.changeSession(null);
        } catch (RemoteException ex) {
            Logger.getLogger(ServicePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnDetokenize;
    private javax.swing.JButton jbtnLogout;
    private javax.swing.JButton jbtnTokenize;
    private javax.swing.JLabel jlblCardError;
    private javax.swing.JLabel jlblCardNum;
    private javax.swing.JLabel jlblFirstRes;
    private javax.swing.JLabel jlblMessage;
    private javax.swing.JLabel jlblSecondRes;
    private javax.swing.JLabel jlblToken;
    private javax.swing.JLabel jlblTokenError;
    private javax.swing.JTextField jtxtCardNumber;
    private javax.swing.JTextField jtxtCardResult;
    private javax.swing.JTextField jtxtToken;
    private javax.swing.JTextField jtxtTokenResult;
    // End of variables declaration//GEN-END:variables
}
