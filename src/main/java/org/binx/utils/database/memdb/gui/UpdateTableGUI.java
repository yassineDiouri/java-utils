/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.binx.utils.database.memdb.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import org.binx.utils.database.memdb.core.manager.ColumnManager;
import org.binx.utils.database.memdb.core.manager.TableManager;
import org.binx.utils.database.memdb.core.model.Column;
import org.binx.utils.database.memdb.core.model.Constraint;
import org.binx.utils.database.memdb.core.model.ConstraintType;

/**
 *
 * @author diouri
 */
public class UpdateTableGUI extends javax.swing.JFrame {

    /**
     * Creates new form UpdateTableGUI
     */
    private String databaseName;
    private String schemaName;
    private String tableName;
    
    public UpdateTableGUI(String databaseName, String schemaName, String tableName) {
        this.databaseName = databaseName;
        this.schemaName   = schemaName;
        this.tableName    = tableName;
        
        initComponents();
        loadConstraints();
        loadTable(databaseName, schemaName, tableName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyPanel = new javax.swing.JPanel();
        updateTableLabel = new javax.swing.JLabel();
        columnsPanel = new javax.swing.JPanel();
        columnsLabel = new javax.swing.JLabel();
        columnsComboBox = new javax.swing.JComboBox<>();
        columnDetailPanel = new javax.swing.JPanel();
        columnOrderLabel = new javax.swing.JLabel();
        columnTypeLabel = new javax.swing.JLabel();
        columnOrderTextField = new javax.swing.JTextField();
        columnTypeTextField = new javax.swing.JTextField();
        columnConstraintsLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        columnConstraintsTextArea = new javax.swing.JTextArea();
        newColumnPanel = new javax.swing.JPanel();
        newColumnNameLabel = new javax.swing.JLabel();
        newColumnNameTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        newColumnConstraintsList = new javax.swing.JList<>();
        newColumnConstraintsLabel = new javax.swing.JLabel();
        addColumnButton = new javax.swing.JButton();
        newColumnTypeLabel = new javax.swing.JLabel();
        newColumnTypeComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        updateTableLabel.setText("jLabel1");

        columnsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Columns"));

        columnsLabel.setText("Choose Column");

        columnsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                columnsComboBoxActionPerformed(evt);
            }
        });

        columnDetailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Column"));

        columnOrderLabel.setText("Order:");

        columnTypeLabel.setText("Type:");

        columnOrderTextField.setEnabled(false);

        columnTypeTextField.setEnabled(false);

        columnConstraintsLabel.setText("Constraints:");

        columnConstraintsTextArea.setColumns(20);
        columnConstraintsTextArea.setRows(5);
        columnConstraintsTextArea.setEnabled(false);
        jScrollPane2.setViewportView(columnConstraintsTextArea);

        javax.swing.GroupLayout columnDetailPanelLayout = new javax.swing.GroupLayout(columnDetailPanel);
        columnDetailPanel.setLayout(columnDetailPanelLayout);
        columnDetailPanelLayout.setHorizontalGroup(
            columnDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(columnDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(columnDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(columnDetailPanelLayout.createSequentialGroup()
                        .addComponent(columnTypeLabel)
                        .addGap(22, 22, 22)
                        .addComponent(columnTypeTextField))
                    .addGroup(columnDetailPanelLayout.createSequentialGroup()
                        .addComponent(columnOrderLabel)
                        .addGap(18, 18, 18)
                        .addComponent(columnOrderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(columnConstraintsLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        columnDetailPanelLayout.setVerticalGroup(
            columnDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(columnDetailPanelLayout.createSequentialGroup()
                .addGroup(columnDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(columnDetailPanelLayout.createSequentialGroup()
                        .addGroup(columnDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(columnOrderLabel)
                            .addComponent(columnOrderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(columnConstraintsLabel))
                        .addGap(18, 18, 18)
                        .addGroup(columnDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(columnTypeLabel)
                            .addComponent(columnTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 101, Short.MAX_VALUE))
        );

        newColumnPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("New Column"));

        newColumnNameLabel.setText("Name:");

        jScrollPane1.setViewportView(newColumnConstraintsList);

        newColumnConstraintsLabel.setText("Constraints:");

        addColumnButton.setText("Add Column");
        addColumnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addColumnButtonActionPerformed(evt);
            }
        });

        newColumnTypeLabel.setText("Type:");

        newColumnTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "String", "Integer", "Float", "Boolean" }));

        javax.swing.GroupLayout newColumnPanelLayout = new javax.swing.GroupLayout(newColumnPanel);
        newColumnPanel.setLayout(newColumnPanelLayout);
        newColumnPanelLayout.setHorizontalGroup(
            newColumnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newColumnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newColumnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addColumnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(newColumnPanelLayout.createSequentialGroup()
                        .addGroup(newColumnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newColumnNameLabel)
                            .addComponent(newColumnTypeLabel))
                        .addGap(36, 36, 36)
                        .addGroup(newColumnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(newColumnTypeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 220, Short.MAX_VALUE)
                            .addComponent(newColumnNameTextField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(newColumnConstraintsLabel)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        newColumnPanelLayout.setVerticalGroup(
            newColumnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newColumnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newColumnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newColumnPanelLayout.createSequentialGroup()
                        .addGroup(newColumnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newColumnNameLabel)
                            .addComponent(newColumnNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newColumnConstraintsLabel))
                        .addGap(18, 18, 18)
                        .addGroup(newColumnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newColumnTypeLabel)
                            .addComponent(newColumnTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addColumnButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout columnsPanelLayout = new javax.swing.GroupLayout(columnsPanel);
        columnsPanel.setLayout(columnsPanelLayout);
        columnsPanelLayout.setHorizontalGroup(
            columnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(columnsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(columnsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(columnsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(columnDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(newColumnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        columnsPanelLayout.setVerticalGroup(
            columnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(columnsPanelLayout.createSequentialGroup()
                .addGroup(columnsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(columnsLabel)
                    .addComponent(columnsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(columnDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newColumnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateTableLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(columnsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateTableLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(columnsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addColumnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addColumnButtonActionPerformed
        String columnName = newColumnNameTextField.getText();
        String columnType = (String) newColumnTypeComboBox.getSelectedItem();
        ConstraintType[] constraints = new ConstraintType[newColumnConstraintsList.getSelectedValuesList().size()];
        int i = 0;
        for(String constraint : newColumnConstraintsList.getSelectedValuesList()) {
            constraints[i++] = ConstraintType.valueOf(constraint);
        }
        
        try {
            ColumnManager.createNewColumnDefaultDB(this.schemaName, this.tableName, columnName, Class.forName("java.lang."+columnType), constraints);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateTableGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadColumns(this.schemaName, this.tableName);
        clearAddColumnForm();
        columnsComboBox.setSelectedItem(columnName);
    }//GEN-LAST:event_addColumnButtonActionPerformed

    private void columnsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_columnsComboBoxActionPerformed
        String columnName = (String) columnsComboBox.getSelectedItem();
        Column column = ColumnManager.getColumnDefaultDB(this.schemaName, this.tableName, columnName);
        if(column != null) {
            columnTypeTextField.setText(column.getType().getSimpleName());
            columnOrderTextField.setText(""+column.getOrder());

            String constraints = "";
            for(Constraint constraint : column.getConstraints()) {
                constraints += constraints.isEmpty() ? constraint.getType().name() : "\n" + constraint.getType().name();
            }
            columnConstraintsTextArea.setText(constraints);
        }
    }//GEN-LAST:event_columnsComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addColumnButton;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel columnConstraintsLabel;
    private javax.swing.JTextArea columnConstraintsTextArea;
    private javax.swing.JPanel columnDetailPanel;
    private javax.swing.JLabel columnOrderLabel;
    private javax.swing.JTextField columnOrderTextField;
    private javax.swing.JLabel columnTypeLabel;
    private javax.swing.JTextField columnTypeTextField;
    private javax.swing.JComboBox<String> columnsComboBox;
    private javax.swing.JLabel columnsLabel;
    private javax.swing.JPanel columnsPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel newColumnConstraintsLabel;
    private javax.swing.JList<String> newColumnConstraintsList;
    private javax.swing.JLabel newColumnNameLabel;
    private javax.swing.JTextField newColumnNameTextField;
    private javax.swing.JPanel newColumnPanel;
    private javax.swing.JComboBox<String> newColumnTypeComboBox;
    private javax.swing.JLabel newColumnTypeLabel;
    private javax.swing.JLabel updateTableLabel;
    // End of variables declaration//GEN-END:variables

    private void loadTable(String databaseName, String schemaName, String tableName) {
        updateTableLabel.setText("Update Table: " + tableName + " (Database:"+ databaseName + " | schema:" + schemaName + ")");
        loadColumns(schemaName, tableName);
    }
    
    private void loadConstraints() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(ConstraintType constraint : ConstraintType.values()) {
            listModel.addElement(constraint.name());
        }
        newColumnConstraintsList.setModel(listModel);
    }
    
    private void loadColumns(String schemaName, String tableName) {
        columnsComboBox.removeAllItems();
        for(String column : TableManager.getAllNamesColumnsDefaultDB(schemaName, tableName)) {
            columnsComboBox.addItem(column);
        }
    }
    
    private void clearAddColumnForm() {
        newColumnNameTextField.setText("");
        newColumnConstraintsList.clearSelection();
        newColumnTypeComboBox.setSelectedIndex(0);
    }
}
