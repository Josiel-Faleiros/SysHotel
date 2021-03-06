/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsi.pi.syshotel;

import br.edu.utfpr.cm.pi.dao.DaoReserva;
import br.edu.utfpr.cm.pi.modal.Reserva;
import br.edu.utfpr.cm.tsi.pi.sessao.Data;
import br.edu.utfpr.cm.tsi.pi.syshotel.Util.Util;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoaoPaulo
 */
public class JDialogPesquisaReservas extends javax.swing.JDialog {

    private DefaultTableModel model;
    private String dadosReserva[] = new String[]{"Cod", "Status ", "Cod Cliente", "Cliente", "Cod Apartamento", "Número", "Andar", "Descrição", "Data entrada", "Data Saída"};
    private List<Reserva> reservas;

    /**
     * Creates new form JDialogPesquisaReservas
     */
    public JDialogPesquisaReservas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarTabela();
        novo();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    DefaultTableModel tmReservas = new DefaultTableModel(null, new String[]{"", "", "", ""});
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelImagemPesReservas = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tfCod = new javax.swing.JTextField();
        jLabelPesReservasCodigo = new javax.swing.JLabel();
        jLabelPesReservasDescr = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbReservas = new javax.swing.JTable();
        btAtualizar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        btHospedar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Reservas");
        setMaximumSize(new java.awt.Dimension(800, 450));
        setMinimumSize(new java.awt.Dimension(800, 450));
        setPreferredSize(new java.awt.Dimension(800, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelImagemPesReservas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelImagemPesReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagemPesReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/cm/tsi/pi/icons/PesReservas.png"))); // NOI18N
        jLabelImagemPesReservas.setMaximumSize(new java.awt.Dimension(300, 100));
        jLabelImagemPesReservas.setMinimumSize(new java.awt.Dimension(300, 100));
        jLabelImagemPesReservas.setPreferredSize(new java.awt.Dimension(300, 100));
        getContentPane().add(jLabelImagemPesReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 380, 50));

        jSeparator1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jSeparator1.setPreferredSize(new java.awt.Dimension(800, 2));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 82, 800, 2));

        tfCod.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(tfCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 110, 30));

        jLabelPesReservasCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelPesReservasCodigo.setText("Código:");
        getContentPane().add(jLabelPesReservasCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabelPesReservasDescr.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelPesReservasDescr.setText("Cliente:");
        getContentPane().add(jLabelPesReservasDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        tfDescricao.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tfDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescricaoKeyReleased(evt);
            }
        });
        getContentPane().add(tfDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 210, 30));

        tbReservas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Cod Cliente", "Cliente", "Cod Apartamento", "Número", "Andar", "Descrição", "Data Entrada", "Data Saída"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbReservas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbReservas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 720, 160));

        btAtualizar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/cm/tsi/pi/icons/update.png"))); // NOI18N
        btAtualizar.setToolTipText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 65, 41));

        btLimpar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/cm/tsi/pi/icons/clear02.png"))); // NOI18N
        btLimpar.setToolTipText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 65, 41));

        btFechar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/cm/tsi/pi/icons/Close.png"))); // NOI18N
        btFechar.setToolTipText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 65, 41));

        btHospedar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btHospedar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/cm/tsi/pi/icons/Hospedagem_1.png"))); // NOI18N
        btHospedar.setToolTipText("Hospedar");
        btHospedar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHospedarActionPerformed(evt);
            }
        });
        getContentPane().add(btHospedar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 65, 41));

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/utfpr/cm/tsi/pi/icons/PesquisarPadrao.png"))); // NOI18N
        btPesquisar.setMaximumSize(new java.awt.Dimension(30, 30));
        btPesquisar.setMinimumSize(new java.awt.Dimension(30, 30));
        btPesquisar.setPreferredSize(new java.awt.Dimension(28, 25));
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 30, 30));

        setSize(new java.awt.Dimension(816, 488));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        if (Util.imprimirConfirmacao("Deseja Sair?")) {
            dispose();
        }
    }//GEN-LAST:event_btFecharActionPerformed

    private void btHospedarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHospedarActionPerformed
        novo();
        Util.abrirJDialogCentralizado(new JDialogCadastrarHospedagem(null, true));

    }//GEN-LAST:event_btHospedarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        atualizar();

    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        if (Util.imprimirConfirmacao("")) {
        }
    }//GEN-LAST:event_btLimparActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void tfDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescricaoKeyReleased
        obterPorNome();
    }//GEN-LAST:event_tfDescricaoKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btHospedar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JLabel jLabelImagemPesReservas;
    private javax.swing.JLabel jLabelPesReservasCodigo;
    private javax.swing.JLabel jLabelPesReservasDescr;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbReservas;
    private javax.swing.JTextField tfCod;
    private javax.swing.JTextField tfDescricao;
    // End of variables declaration//GEN-END:variables

    private void novo() {
        tfCod.setText(null);
        tfDescricao.setText(null);
        popularTabela();
    }

    private void popularTabela() {
        reservas = new DaoReserva().listar();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(dadosReserva);
        prencherTabela();

    }

    private void prencherTabela() {

        model = new DefaultTableModel();
        model.setColumnIdentifiers(dadosReserva);


        if (reservas != null || reservas.isEmpty()) {
            for (Reserva re : reservas) {
                model.addRow(new Object[]{re.getId(),
                    re.getStatus(),
                    re.getCli().getId(),
                    re.getCli().getNome(),
                    re.getApt().getId(),
                    re.getApt().getAndar(),
                    re.getApt().getNumero(),
                    re.getApt().getDescricao(),
                    re.getDataDeEntrada(),
                    re.getDataDeSaida()});

            }
            tbReservas.setModel(model);
        } else {
            model = new DefaultTableModel();
            model.setColumnIdentifiers(dadosReserva);
            tbReservas.setModel(model);
        }

    }

    private void iniciarTabela() {
        reservas = new DaoReserva().listar();
        if (reservas != null) {
            prencherTabela();
        }
    }

    private void pesquisar() {
        if (!tfCod.getText().equals("")) {
            obterPorId();
        } else {
            Util.dispayMsg("Forneça um Código");
        }
    }

    private void obterPorId() {
        if (!tfCod.getText().isEmpty()) {

            reservas.clear();
            Reserva res = new DaoReserva().obterPorId(Integer.parseInt(tfCod.getText()));
            if (res != null) {
                reservas.add(res);
            }
            prencherTabela();
            tfCod.setText("");

        } else {
            Util.dispayMsg("Forneça um Cod!");
        }
    }

    private void obterPorNome() {

        try {
            reservas.clear();
            reservas = new DaoReserva().obterNome(tfDescricao.getText());
            prencherTabela();
        } catch (Exception e) {
            Logger.getLogger(JDialogCadastrarReservas.class.getName()).log(Level.SEVERE, null, e);//erro
            Util.dispayMsg("Erro ao Pesquisar Por Nome!");

        }
    }

    private void atualizar() {
        if (tbReservas.getSelectedRow() != -1) {
            if (Util.imprimirConfirmacao("Carregar dados?")) {
                int linha = tbReservas.getSelectedRow();
                if (linha == -1) {
                    return;
                }
                Data.hash.put("reserva", reservas.get(linha));
            }
        }

        dispose();
    }
}
