/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControlRaciones;
import Controlador.ControlRegistroAlimento;
import Modelo.RegistroAlimento;
import Vista.Tablas.TablaAlimento;
import java.awt.Color;
import static java.awt.EventQueue.invokeLater;
import java.awt.Image;
import static java.lang.Double.parseDouble;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;

/**
 *
 * @author ricar
 */
public class FrmAlimentos extends javax.swing.JFrame {

    /**
     * Creates new form FrmUsuarios
     */
    private ControlRegistroAlimento control = new ControlRegistroAlimento();
    private ControlRaciones controlRac = new ControlRaciones();
    private TablaAlimento modelo = new TablaAlimento();

    public FrmAlimentos() {
        initComponents();
        control.CargarDatos();
        CargarTabla();
        limpiar();
        txtBuscar.requestFocus();
        Botones(false);
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        jPanel1.setBackground(Color.DARK_GRAY);
        jPanel2.setBackground(Color.DARK_GRAY);
        jPanel3.setBackground(Color.DARK_GRAY);
        jPanel4.setBackground(Color.DARK_GRAY);
        ImageIcon JLupa = new ImageIcon(getClass().getResource("/Vista/Imagenes/Lupa.png"));
        Icon fondoJLupa = new ImageIcon(JLupa.getImage().getScaledInstance(Lupa.getWidth(), Lupa.getHeight(), Image.SCALE_DEFAULT));
        Lupa.setIcon(fondoJLupa);
        ImageIcon J = new ImageIcon(getClass().getResource("/Vista/Imagenes/Line.png"));
        Icon fondoJ = new ImageIcon(J.getImage().getScaledInstance(L1.getWidth(), L1.getHeight(), Image.SCALE_DEFAULT));
        L1.setIcon(fondoJ);
        ImageIcon k = new ImageIcon(getClass().getResource("/Vista/Imagenes/Line2.png"));
        Icon fondok = new ImageIcon(k.getImage().getScaledInstance(L2.getWidth(), L2.getHeight(), Image.SCALE_DEFAULT));
        L2.setIcon(fondok);        
    }
    /**
     * Este metodo se usa para Cargar nuestra tabla.
     *
     * @return void No retorna ningún valor.
     */
    private void CargarTabla() {
        modelo.setLista(control.getLista());
        tblAlimentos.setModel(modelo);
        tblAlimentos.updateUI();
    }
    /**
     * Este metodo se usa para Cargar nuestra tabla con los datos resultantes de
     * la busqueda.
     *
     * @return void No retorna ningún valor.
     */
    private void CargarTablaBusqueda() {
        modelo.setLista(control.getListabusqueda());
        tblAlimentos.setModel(modelo);
        tblAlimentos.updateUI();
    }
    /**
     * Este metodo se usa para bloquear o activar los botones dentro de la ventana
     *@param sw de tipo boleano
     */   
    public void Botones(boolean sw){
       this.btnModificar.setEnabled(sw);
       this.btnEliminar.setEnabled(sw);
       this.txtEnergiaMetabolizable.setEnabled(sw);
        this.ComboBoxTipoAlimento.setEnabled(sw);
        this.txtProteinaC.setEnabled(sw);
        this.txtCalcio.setEnabled(sw);
        this.txtFosforo.setEnabled(sw);
        this.txtLisina.setEnabled(sw);
        this.txtCosto.setEnabled(sw);
    }
       /**
     * Limpia todos los JField de la ventana
     */ 
    private void limpiar(){
        this.txtDatoSElecionado.setText("");
        this.txtBuscar.setText("");
        this.txtCalcio.setText("");
        this.txtEnergiaMetabolizable.setToolTipText("");
        this.txtFosforo.setText("");
        this.txtLisina.setText("");
        this.txtPosicion.setText("");
        this.txtProteinaC.setText("");
        this.ComboBoxTipoAlimento.setSelectedIndex(0);
    }

    /**
     * Este metodo se usa para Eliminar un registro.
     *
     * @return void No retorna ningún valor.
     */
    public void Eliminar() {
        if (!this.txtDatoSElecionado.getText().isEmpty()) {
            if (this.tblAlimentos.getRowCount() >= control.getLista().tamano()) {
                control.getLista().eliminarPorPosicion(Integer.parseInt(txtPosicion.getText()));
            } else {
              control.getLista().eliminarPorPosicion(control.getListabusqueda().buscarDatoAlimento(control.getListabusqueda().verDatoPosicion(Integer.parseInt(txtPosicion.getText()))));
            }
            control.InsertarArchivo();
            CargarTabla();
            limpiar();
            Botones(false);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un dato");
        }     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        Lupa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlimentos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        ComboBoxTipoAlimento = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEnergiaMetabolizable = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFosforo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtProteinaC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtLisina = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCalcio = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDatoSElecionado = new javax.swing.JTextField();
        txtPosicion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        L1 = new javax.swing.JLabel();
        L2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tabla de Alimentos - Sistema de Formulacion de Raciones");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Acciones   ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 10), new java.awt.Color(255, 255, 255))); // NOI18N

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAtras.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/shape_move_back.png"))); // NOI18N
        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/magnifier.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSeleccionar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/cursor.png"))); // NOI18N
        btnSeleccionar.setText("Selecionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnSeleccionar)
                .addGap(40, 40, 40)
                .addComponent(btnEliminar)
                .addGap(30, 30, 30)
                .addComponent(btnCancelar)
                .addGap(40, 40, 40)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar)
                    .addComponent(btnAtras)
                    .addComponent(btnBuscar)
                    .addComponent(jButton1))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar   ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 10), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Break", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");

        txtBuscar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lupa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Lupa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblAlimentos.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblAlimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Descripcion", "Costo $/Kg", "Tipo", "Energía Metabolizable", "Proteina C.", "Fósforo", "Calcio", "Lisina"
            }
        ));
        jScrollPane1.setViewportView(tblAlimentos);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ComboBoxTipoAlimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Energético", "Proteico", "Forraje Verde", "Forraje Seco", "Ensilaje", "Mineral", "Vitamina", "Aditivo" }));

        jLabel2.setFont(new java.awt.Font("Break", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo de Alimento:");

        txtCosto.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Break", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Costo $/Kg:");

        txtEnergiaMetabolizable.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtEnergiaMetabolizable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEnergiaMetabolizableKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Break", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Energia Metabolizable:");

        txtFosforo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtFosforo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFosforoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Break", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fosforo:");

        txtProteinaC.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtProteinaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProteinaCKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Break", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Proteina C.: ");

        jLabel7.setFont(new java.awt.Font("Break", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Lisina:");

        txtLisina.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtLisina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLisinaKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Break", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Calcio:");

        txtCalcio.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtCalcio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalcioKeyTyped(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/table_edit.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Break", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripcion:");

        jLabel10.setFont(new java.awt.Font("Break", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Posicion:");

        txtDatoSElecionado.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtDatoSElecionado.setEnabled(false);

        txtPosicion.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtPosicion.setEnabled(false);
        txtPosicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPosicionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCalcio))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtProteinaC))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEnergiaMetabolizable)))
                .addGap(100, 100, 100)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLisina))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFosforo))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxTipoAlimento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDatoSElecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(txtDatoSElecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtEnergiaMetabolizable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(ComboBoxTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFosforo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtProteinaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtLisina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCalcio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Break", 1, 60)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ALIMENTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(L2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(L1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        var form = new FrmPrincipalA();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            if (txtBuscar.getText().isEmpty()) {
                CargarTabla();
            } else {
                control.CargarDatosPorBusqueda(txtBuscar.getText());
                CargarTablaBusqueda();
            }
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (!txtDatoSElecionado.getText().isEmpty()) {
            if (tblAlimentos.getRowCount() >= control.getLista().tamano()) {
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))).setTipoAlimento(ComboBoxTipoAlimento.getSelectedItem().toString());
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))).setCostoKg(parseDouble(txtCosto.getText()));
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))).setEnergiaMetabolizable(parseDouble(txtEnergiaMetabolizable.getText()));
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))).setFosforo(parseDouble(txtFosforo.getText()));
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))).setProteinaC(parseDouble(txtProteinaC.getText()));
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))).setCalcio(parseDouble(txtCalcio.getText()));
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))).setLisina(parseDouble(txtLisina.getText()));
            } else {
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(control.getLista().buscarDatoAlimento(control.getListabusqueda().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))))).setTipoAlimento(ComboBoxTipoAlimento.getSelectedItem().toString());
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(control.getLista().buscarDatoAlimento(control.getListabusqueda().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))))).setCostoKg(parseDouble(txtCosto.getText()));
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(control.getLista().buscarDatoAlimento(control.getListabusqueda().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))))).setEnergiaMetabolizable(parseDouble(txtEnergiaMetabolizable.getText()));
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(control.getLista().buscarDatoAlimento(control.getListabusqueda().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))))).setFosforo(parseDouble(txtFosforo.getText()));
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(control.getLista().buscarDatoAlimento(control.getListabusqueda().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))))).setProteinaC(parseDouble(txtProteinaC.getText()));
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(control.getLista().buscarDatoAlimento(control.getListabusqueda().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))))).setCalcio(parseDouble(txtCalcio.getText()));
                ((RegistroAlimento) control.getLista().obtenerPorPosicion(control.getLista().buscarDatoAlimento(control.getListabusqueda().obtenerPorPosicion(Integer.parseInt(txtPosicion.getText()))))).setLisina(parseDouble(txtLisina.getText()));
            }
            control.InsertarArchivo();
            CargarTabla();
            limpiar();
            Botones(false);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un dato");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!txtDatoSElecionado.getText().isEmpty()) {
            if (tblAlimentos.getRowCount() >= control.getLista().tamano()) {
                control.getLista().eliminarPorPosicion(Integer.parseInt(txtPosicion.getText()));
            } else {
              control.getLista().eliminarPorPosicion(control.getListabusqueda().buscarDatoAlimento(control.getListabusqueda().verDatoPosicion(Integer.parseInt(txtPosicion.getText()))));
            }
            control.InsertarArchivo();
            CargarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un dato");
        }       
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int f = tblAlimentos.getSelectedRow();
        limpiar();
        String dato = "";
        String tipo = "";
        if (tblAlimentos.getRowCount() >= control.getLista().tamano()) {
            dato += ((RegistroAlimento) control.getLista().obtenerPorPosicion(f)).getNombre() + "/";
            dato += ((RegistroAlimento) control.getLista().obtenerPorPosicion(f)).getTipo() + "/";
            dato += ((RegistroAlimento) control.getLista().obtenerPorPosicion(f)).getParte() + "/";
            dato += ((RegistroAlimento) control.getLista().obtenerPorPosicion(f)).getProceso() + "/";
            dato += ((RegistroAlimento) control.getLista().obtenerPorPosicion(f)).getCalidad() + "/";
            dato += ((RegistroAlimento) control.getLista().obtenerPorPosicion(f)).getOrigen();
            tipo = ((RegistroAlimento) control.getLista().obtenerPorPosicion(f)).getTipoAlimento();
        } else {
            dato += ((RegistroAlimento) control.getListabusqueda().obtenerPorPosicion(f)).getNombre() + "/";
            dato += ((RegistroAlimento) control.getListabusqueda().obtenerPorPosicion(f)).getTipo() + "/";
            dato += ((RegistroAlimento) control.getListabusqueda().obtenerPorPosicion(f)).getParte() + "/";
            dato += ((RegistroAlimento) control.getListabusqueda().obtenerPorPosicion(f)).getProceso() + "/";
            dato += ((RegistroAlimento) control.getListabusqueda().obtenerPorPosicion(f)).getCalidad() + "/";
            dato += ((RegistroAlimento) control.getListabusqueda().obtenerPorPosicion(f)).getOrigen();
            tipo = ((RegistroAlimento) control.getListabusqueda().obtenerPorPosicion(f)).getTipoAlimento();
        }

        txtDatoSElecionado.setText(dato);
        txtPosicion.setText(String.valueOf(f));
        this.ComboBoxTipoAlimento.setSelectedItem(tipo);
         Botones(true);
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
        Botones(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        char e = evt.getKeyChar();
        if ((e < 'a' || e > 'z') && (e < 'A' || e > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        char e = evt.getKeyChar();
        if (!(e < 'a' || e > 'z') && (e < 'A' || e > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtProteinaCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProteinaCKeyTyped
        char e = evt.getKeyChar();
        if (!(e < 'a' || e > 'z') && (e < 'A' || e > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtProteinaCKeyTyped

    private void txtCalcioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalcioKeyTyped
        char e = evt.getKeyChar();
        if (!(e < 'a' || e > 'z') && (e < 'A' || e > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCalcioKeyTyped

    private void txtLisinaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLisinaKeyTyped
        char e = evt.getKeyChar();
        if (!(e < 'a' || e > 'z') && (e < 'A' || e > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtLisinaKeyTyped

    private void txtFosforoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFosforoKeyTyped
        char e = evt.getKeyChar();
        if (!(e < 'a' || e > 'z') && (e < 'A' || e > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFosforoKeyTyped

    private void txtEnergiaMetabolizableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnergiaMetabolizableKeyTyped
        char e = evt.getKeyChar();
        if (!(e < 'a' || e > 'z') && (e < 'A' || e > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEnergiaMetabolizableKeyTyped

    private void txtPosicionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPosicionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPosicionKeyTyped
//HAcer control;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int f=tblAlimentos.getSelectedRow();
        controlRac.setRegistroAlimento((RegistroAlimento)control.getLista().verDatoPosicion(f));
        controlRac.guardarRegistroAlimento();
        controlRac.InsertarArchivo();
        FrmRaciones frm = new FrmRaciones();
        frm.dispose();
        frm.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            for (var info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            getLogger(FrmAlimentos.class.getName()).log(SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        invokeLater(() -> {
            new FrmAlimentos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxTipoAlimento;
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel Lupa;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlimentos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCalcio;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDatoSElecionado;
    private javax.swing.JTextField txtEnergiaMetabolizable;
    private javax.swing.JTextField txtFosforo;
    private javax.swing.JTextField txtLisina;
    private javax.swing.JTextField txtPosicion;
    private javax.swing.JTextField txtProteinaC;
    // End of variables declaration//GEN-END:variables
}
