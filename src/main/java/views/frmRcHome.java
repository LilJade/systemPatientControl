package views;

import business.B_ListPatient;
import entities.ListPatient;
import entities.TypeTest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LilJade
 */
public class frmRcHome extends javax.swing.JFrame {

    B_ListPatient business = new B_ListPatient();

    //Creates new form frmLogin
    public frmRcHome() {
        initComponents();
        this.setLocationRelativeTo(null);
        listPatients();
    }
    
    public void listPatients() {
        String titulos[] = {"Id", "Fecha", "Nombres Pacientes", "Posición", "Descripcion", "Tipo de Cita", "Id cita"};
        DefaultTableModel df = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        ArrayList<ListPatient> list = business.B_listPatients();
        Iterator i = list.iterator();
        
        String columns[] = new String[7];
        
        while (i.hasNext()) {
            ListPatient patient;
            patient = (ListPatient) i.next();
            
            columns[0] = String.valueOf(patient.getId());
            columns[1] = String.valueOf(patient.getDatefield());
            columns[2] = patient.getNamePatient();
            columns[3] = String.valueOf(patient.getPosition());
            columns[4] = patient.getDescriptionDate();
            columns[5] = patient.getIdTypeTest().getTypeTest();
            columns[6] = String.valueOf(patient.getIdTypeTest().getId());
            
            df.addRow(columns);
        }
        
        tblPacients.setModel(df);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlConfig = new javax.swing.JPanel();
        btnReloadListPatients = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblDateToday = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacients = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAddPatient = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblSelectedPatient = new javax.swing.JLabel();
        btnEditPatient = new javax.swing.JButton();
        lblNamePatient = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        lblPosition = new javax.swing.JLabel();
        lblIdPatient = new javax.swing.JLabel();
        btnDelPatient = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlConfig.setBackground(new java.awt.Color(255, 255, 255));
        pnlConfig.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnReloadListPatients.setText("REFRESH");
        btnReloadListPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadListPatientsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConfigLayout = new javax.swing.GroupLayout(pnlConfig);
        pnlConfig.setLayout(pnlConfigLayout);
        pnlConfigLayout.setHorizontalGroup(
            pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConfigLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReloadListPatients)
                .addContainerGap())
        );
        pnlConfigLayout.setVerticalGroup(
            pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConfigLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReloadListPatients)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("MADE TOMMY", 1, 14)); // NOI18N
        jLabel1.setText("Lista de Pacientes");

        lblDateToday.setFont(new java.awt.Font("MADE TOMMY", 1, 14)); // NOI18N
        lblDateToday.setText(" ");

        jLabel3.setFont(new java.awt.Font("MADE TOMMY", 1, 14)); // NOI18N
        jLabel3.setText("Fecha:");

        tblPacients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPacients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPacients);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDateToday, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblDateToday)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("MADE TOMMY", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Agregar nuevo paciente");

        btnAddPatient.setFont(new java.awt.Font("MADE TOMMY", 1, 18)); // NOI18N
        btnAddPatient.setText("AGREGAR");
        btnAddPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddPatientMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnAddPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lblSelectedPatient.setFont(new java.awt.Font("MADE TOMMY", 1, 14)); // NOI18N
        lblSelectedPatient.setText("Selecciona un paciente...");

        btnEditPatient.setFont(new java.awt.Font("MADE TOMMY", 1, 18)); // NOI18N
        btnEditPatient.setText("EDITAR");
        btnEditPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditPatientMouseClicked(evt);
            }
        });

        lblNamePatient.setFont(new java.awt.Font("MADE TOMMY", 1, 14)); // NOI18N
        lblNamePatient.setText(" ");
        lblNamePatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("MADE TOMMY", 0, 14)); // NOI18N
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        lblPosition.setFont(new java.awt.Font("MADE TOMMY", 1, 14)); // NOI18N
        lblPosition.setText(" ");
        lblPosition.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblIdPatient.setFont(new java.awt.Font("MADE TOMMY", 1, 14)); // NOI18N
        lblIdPatient.setText(" ");
        lblIdPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnDelPatient.setFont(new java.awt.Font("MADE TOMMY", 1, 18)); // NOI18N
        btnDelPatient.setText("ELIMINAR");
        btnDelPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelPatientMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNamePatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblSelectedPatient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIdPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(lblPosition, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectedPatient)
                    .addComponent(lblIdPatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNamePatient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPosition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPatientMouseClicked
        jdAddPacient jd = new jdAddPacient(this, true);
        jd.setVisible(true);
    }//GEN-LAST:event_btnAddPatientMouseClicked

    private void btnReloadListPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadListPatientsActionPerformed
        listPatients();
    }//GEN-LAST:event_btnReloadListPatientsActionPerformed

    ListPatient patientToEdit = new ListPatient();
    private void tblPacientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientsMouseClicked
        int selected = tblPacients.rowAtPoint(evt.getPoint());
        lblIdPatient.setText(String.valueOf(tblPacients.getValueAt(selected, 0)));
        lblNamePatient.setText(String.valueOf(tblPacients.getValueAt(selected, 2)));
        txtDescription.setText(String.valueOf(tblPacients.getValueAt(selected, 4)));
        lblPosition.setText(String.valueOf(tblPacients.getValueAt(selected, 3)));
        
        patientToEdit.setId(Integer.parseInt(String.valueOf(tblPacients.getValueAt(selected, 0))));
        patientToEdit.setNamePatient(String.valueOf(tblPacients.getValueAt(selected, 2)));
        patientToEdit.setDescriptionDate(String.valueOf(tblPacients.getValueAt(selected, 4)));
        patientToEdit.setDatefield((Timestamp.valueOf(String.valueOf(tblPacients.getValueAt(selected, 1)))));
        patientToEdit.setPosition(Integer.parseInt(String.valueOf(tblPacients.getValueAt(selected, 3))));
        TypeTest ttte = new TypeTest();
        ttte.setTypeTest(String.valueOf(tblPacients.getValueAt(selected, 5)));
        ttte.setId(Integer.parseInt(String.valueOf(tblPacients.getValueAt(selected, 6))));
        patientToEdit.setIdTypeTest(ttte);
    }//GEN-LAST:event_tblPacientsMouseClicked

    private void btnEditPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditPatientMouseClicked
        jdEditPacient jd = new jdEditPacient(this, true);
        jd.receivePatient(patientToEdit);
        jd.setVisible(true);
    }//GEN-LAST:event_btnEditPatientMouseClicked

    private void btnDelPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelPatientMouseClicked
        business.B_deletePatient(patientToEdit);
        btnReloadListPatients.doClick();
    }//GEN-LAST:event_btnDelPatientMouseClicked

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
            java.util.logging.Logger.getLogger(frmRcHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRcHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRcHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRcHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRcHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton btnDelPatient;
    private javax.swing.JButton btnEditPatient;
    public static javax.swing.JButton btnReloadListPatients;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDateToday;
    private javax.swing.JLabel lblIdPatient;
    private javax.swing.JLabel lblNamePatient;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblSelectedPatient;
    private javax.swing.JPanel pnlConfig;
    private javax.swing.JTable tblPacients;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables
}
