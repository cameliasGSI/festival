/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Bilhete;
import backend.Festival;
import backend.Colaborador;
import backend.ColaboradorPago;
import backend.GameDesigners;
import backend.Patrocinio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author João
 */
public class Menu extends JFrame {
    
    private JFrame anterior;
    private List<Festival> fest;
    
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }
    
    public Menu(List<Festival> festivais) {
        initComponents();
        
        this.fest = festivais;
        
        refreshListaFestivais();
        refreshListaColaboradores();
        refreshListaPatrocinadores();
        refreshListaGameDesigners();
        refreshBalanco();
        
        patrocinadoresTable.setAutoCreateRowSorter(true);
        gameDesignersTable.setAutoCreateRowSorter(true);
    }
    
    public Menu(JFrame anterior) {
        
        this.anterior = anterior;
        
        initComponents();
    }
    
    public void refreshListaFestivais() {
        DefaultTableModel model = new DefaultTableModel();

        //duas ultimas colunas sao botao editar e instancia do festival
        String[] cols = {"Nome","Local", "Data inicio", "Data fim", "Lotação", "", ""};
        model.setColumnIdentifiers(cols);
        
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        for (Festival festival : fest) {
            
            Object[] valores = { 
                festival.getNome(), 
                festival.getLocal(),
                formato.format(festival.getDataInicio()),
                formato.format(festival.getDataFim()),
                festival.getLotacao(),
                "editar",
                festival
            };
            model.addRow(valores);
        }
        
        Action edit = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                Festival editar = (Festival)((DefaultTableModel)table.getModel()).getValueAt(modelRow, 6);
                editarFestival(editar);
            }
        };
        
        festivaisTable.setModel(model);
        
        //esconder coluna com a instancia
        festivaisTable.getColumnModel().getColumn(6).setWidth(0);
        festivaisTable.getColumnModel().getColumn(6).setMinWidth(0);
        festivaisTable.getColumnModel().getColumn(6).setMaxWidth(0);
        
        ButtonColumn buttonColumn = new ButtonColumn(festivaisTable, edit, 5);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
        
        
        ComboBoxModel comboModel = new DefaultComboBoxModel(fest.toArray());
        
        ComboBoxColaboradores.setModel(comboModel);
        comboBoxPatrocinadores.setModel(comboModel);
        comboBoxGameDesigners.setModel(comboModel);
        fbalancoComboBox1.setModel(comboModel);
    }
    
    public void refreshListaColaboradores() {
        Festival selecionado = (Festival) ComboBoxColaboradores.getSelectedItem();
        DefaultTableModel model = new DefaultTableModel();

        //duas ultimas colunas sao botao editar e instancia do festival
        String[] cols = {"Nome","Morada", "Telefone", "Função", "NIF", "Pagamento", "", ""};
        model.setColumnIdentifiers(cols);
        
        if (selecionado != null) {
            for (Colaborador colaborador : selecionado.getColaboradores()) {
                int nif = 0;
                double pagamento = 0;

                if (colaborador instanceof ColaboradorPago) {
                    nif = ((ColaboradorPago) colaborador).getNif();
                    pagamento = ((ColaboradorPago) colaborador).getPagamento();
                }

                Object[] valores = { 
                    colaborador.getNome(), 
                    colaborador.getMorada(),
                    colaborador.getTelefone(),
                    colaborador.getFuncao(),
                    nif > 0 ? nif : "Voluntario",
                    pagamento > 0 ? pagamento : "Voluntario",
                    "editar",
                    colaborador
                };
                model.addRow(valores);
            }
        }
        
        Action edit = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                Colaborador editar = (Colaborador)((DefaultTableModel)table.getModel()).getValueAt(modelRow, 7);
                editarColaborador(editar, selecionado);
            }
        };
        
        colaboradoresTable.setModel(model);
        
        //esconder coluna com a instancia
        colaboradoresTable.getColumnModel().getColumn(7).setWidth(0);
        colaboradoresTable.getColumnModel().getColumn(7).setMinWidth(0);
        colaboradoresTable.getColumnModel().getColumn(7).setMaxWidth(0);
        
        ButtonColumn buttonColumn = new ButtonColumn(colaboradoresTable, edit, 6);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }
    
    public void refreshListaPatrocinadores() {
        Festival selecionado = (Festival) comboBoxPatrocinadores.getSelectedItem();
        DefaultTableModel model = new DefaultTableModel();

        //duas ultimas colunas sao botao editar e instancia do festival
        String[] cols = {"Nome","Contribuiçao", "", ""};
        model.setColumnIdentifiers(cols);
        
        if (selecionado != null) {
            for (Patrocinio patrocinio : selecionado.getPatrocinio()) {
                double contrib = 0;

                Object[] valores = { 
                    patrocinio.getPatrocinador(), 
                    patrocinio.getContribuicao(),
                    "editar",
                    patrocinio
                };
                model.addRow(valores);
            }
        }
        
        Action edit = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                Patrocinio editar = (Patrocinio)((DefaultTableModel)table.getModel()).getValueAt(modelRow, 3);
                editarPatrocinio(editar, selecionado);
            }
        };
        
        patrocinadoresTable.setModel(model);
        
        //esconder coluna com a instancia
        patrocinadoresTable.getColumnModel().getColumn(3).setWidth(0);
        patrocinadoresTable.getColumnModel().getColumn(3).setMinWidth(0);
        patrocinadoresTable.getColumnModel().getColumn(3).setMaxWidth(0);
        
        ButtonColumn buttonColumn = new ButtonColumn(patrocinadoresTable, edit, 2);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }
    
    public void refreshListaGameDesigners() {
        Festival selecionado = (Festival) comboBoxGameDesigners.getSelectedItem();
        DefaultTableModel model = new DefaultTableModel();

        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        
        //duas ultimas colunas sao botao editar e instancia do festival
        String[] cols = {"Nome","Telefone", "Cachê","Data Sessão","Jogo", "", ""};
        model.setColumnIdentifiers(cols);
        
        if (selecionado != null) {
            for (GameDesigners gameDesigner : selecionado.getGameDesigners()) {
                double cache = 0;

                Object[] valores = { 
                    gameDesigner.getNome(), 
                    gameDesigner.getTelefone(),
                    gameDesigner.getCache(),
                    formato.format(gameDesigner.getDiaHora()),
                    gameDesigner.getJogo(),
                    "editar",
                    gameDesigner
                };
                model.addRow(valores);
            }
        }
        
        Action edit = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                GameDesigners editar = (GameDesigners)((DefaultTableModel)table.getModel()).getValueAt(modelRow, 6);
                editarGameDesigner(editar, selecionado);
            }
        };
        
        gameDesignersTable.setModel(model);
        
        //esconder coluna com a instancia
        gameDesignersTable.getColumnModel().getColumn(6).setWidth(0);
        gameDesignersTable.getColumnModel().getColumn(6).setMinWidth(0);
        gameDesignersTable.getColumnModel().getColumn(6).setMaxWidth(0);
        
        ButtonColumn buttonColumn = new ButtonColumn(gameDesignersTable, edit, 5);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
        
        totalGameDesigners.setText("" + selecionado.getGameDesigners().size());
    }
    
    private void refreshBalanco() {
        Festival selecionado = (Festival) fbalancoComboBox1.getSelectedItem();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        int rb = receitaBilhetes(selecionado);
        int rp = receitaPatrocinios(selecionado);
        int cg = custosGameDesigners(selecionado);
        int cc = custoColaboradores(selecionado);
        int total = (rb + rp - cg - cc);
        String desc = "Lucro";
        
        if (total < 0) {
            desc = "Prejuizo";
        }
        
        valorrbilhetes.setText("" + rb);
        valorRpatrocinios.setText("" + rp);
        valorcgdjLabel7.setText("" + cg);
        valorBTotalLabel9.setText("" +total + " " + desc );
        
        Date diaMaior = diaMaiorAfluencia(selecionado);
        
        if (diaMaior != null) {
            valormafluencia.setText(formato.format(diaMaior));
        }
        else {
            valormafluencia.setText("");
        }
    }
    
    private int receitaBilhetes(Festival festival) {
       int rb = 0;
       
        for(Bilhete b : festival.getBilhetes() ){
            rb +=( b.getPreço() );
        }
        
        return rb;
    }
    
    private int receitaPatrocinios(Festival festival) {
        int rp = 0;
        
        for(Patrocinio p : festival.getPatrocinio()){
            rp += (p.getContribuicao());
        }
        return rp;
    }
    
    private int custosGameDesigners(Festival festival) {
        int cg = 0;
        
        for(GameDesigners g : festival.getGameDesigners()){
            cg += (g.getCache());
        }
        return cg;
    }
    
    private int custoColaboradores(Festival festival) {
        int cc = 0;
        
        for(Colaborador c : festival.getColaboradores()){
            if (c instanceof ColaboradorPago) {
                cc += (((ColaboradorPago) c).getPagamento());
            }
            else cc += 0;
                        
                        
        }
        
        return cc;
    }
    
    private Date diaMaiorAfluencia(Festival festival){
        Map<String, Integer> dias = new HashMap<String, Integer>();
        DateFormat formato = new SimpleDateFormat("ddMMyyyy");
        int max = 0;
        String maior = null;
        
        if (!festival.getBilhetes().isEmpty()) {
            for(Bilhete b : festival.getBilhetes()){
                String key = formato.format(b.getData());

                if(dias.containsKey(key)) {
                    int current = dias.get(key);
                    dias.put(key, ++current);
                }
                else {
                    dias.put(key, 1);
                }
            }

            for(String data : dias.keySet()) {
                if (dias.get(data) > max) {
                    max = dias.get(data);
                    maior = data;
                }
            }

            try {
                return formato.parse(maior);
            } catch (ParseException ex) {
                System.out.println("Nao conseguiu calcular o dia");
            }
        }
        
        return null;
    }
    
    private void editarFestival(Festival festival) {
        NovoFestival novoFestival = new NovoFestival(this, fest, festival);
        novoFestival.setLocationRelativeTo(null);
        
        this.setVisible(false);
        novoFestival.setVisible(true);
    }
    
    private void editarColaborador(Colaborador colaborador, Festival pai) {
        ColaboradorForm colaboradorForm = new ColaboradorForm(this, fest, colaborador, pai);
        colaboradorForm.setLocationRelativeTo(null);
        
        this.setVisible(false);
        colaboradorForm.setVisible(true);
    }
    
    private void editarPatrocinio(Patrocinio patrocinio, Festival pai) {
        NovoPatrocinador novoPatrocinador = new NovoPatrocinador(this, fest, patrocinio, pai);
        novoPatrocinador.setLocationRelativeTo(null);
        
        this.setVisible(false);
        novoPatrocinador.setVisible(true);
    }
    
    private void editarGameDesigner(GameDesigners gameDesigner, Festival pai) {
        GameDesigner gameDesignerForm = new GameDesigner(this, fest, gameDesigner, pai);
        gameDesignerForm.setLocationRelativeTo(null);
        
        this.setVisible(false);
        gameDesignerForm.setVisible(true);
    }
    
    public void terminar() {
        Arranque.terminar(fest);
    }
    
    public void setAnterior(JFrame anterior) {
        this.anterior = anterior;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        festivaisTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        ColaboradoresLabel = new javax.swing.JLabel();
        ComboBoxColaboradores = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        colaboradoresTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        PFEStivalLabel = new javax.swing.JLabel();
        comboBoxPatrocinadores = new javax.swing.JComboBox<>();
        PtextoLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        patrocinadoresTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        comboBoxGameDesigners = new javax.swing.JComboBox<>();
        GDlabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        gameDesignersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        totalGameDesigners = new javax.swing.JLabel();
        valorRbilhetesPanel6 = new javax.swing.JPanel();
        BalancoLabel1 = new javax.swing.JLabel();
        valorrbilhetes = new javax.swing.JLabel();
        RBilhetesLabel3 = new javax.swing.JLabel();
        RpatrocinioLabel4 = new javax.swing.JLabel();
        valorRpatrocinios = new javax.swing.JLabel();
        cgdLabel6 = new javax.swing.JLabel();
        fbalancoComboBox1 = new javax.swing.JComboBox<>();
        valorcgdjLabel7 = new javax.swing.JLabel();
        BTotalLabel8 = new javax.swing.JLabel();
        valorBTotalLabel9 = new javax.swing.JLabel();
        maflluencia = new javax.swing.JLabel();
        valormafluencia = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(800, 600));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel2.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));

        jButton1.setText("Novo Festival");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Novo Colaborador");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Novo Game Designer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Novo Patrocinador");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Gerir Bilheteiras");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Menu", jPanel2);
        jPanel2.getAccessibleContext().setAccessibleName("");

        festivaisTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        festivaisTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(festivaisTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Festivais", jPanel1);

        ColaboradoresLabel.setText("Colaboradores:");

        ComboBoxColaboradores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxColaboradoresActionPerformed(evt);
            }
        });

        colaboradoresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        colaboradoresTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(colaboradoresTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ColaboradoresLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxColaboradores, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ColaboradoresLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxColaboradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Colaboradores", jPanel3);

        PFEStivalLabel.setText("Patrocinadores:");

        comboBoxPatrocinadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxPatrocinadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPatrocinadoresActionPerformed(evt);
            }
        });

        PtextoLabel1.setText("Os patrocinadores deste festival são:");

        patrocinadoresTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(patrocinadoresTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PtextoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxPatrocinadores, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PFEStivalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PFEStivalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxPatrocinadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PtextoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Patrocinadores", jPanel5);

        comboBoxGameDesigners.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxGameDesigners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGameDesignersActionPerformed(evt);
            }
        });

        GDlabel.setText("Game Designers:");

        gameDesignersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(gameDesignersTable);

        jLabel1.setText("Total de Game Designers:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GDlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxGameDesigners, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalGameDesigners, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(GDlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxGameDesigners, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalGameDesigners, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86))
        );

        jTabbedPane1.addTab("Game Designers", jPanel4);

        BalancoLabel1.setText("Balanço:");

        RBilhetesLabel3.setText("Receita bilhetes:");

        RpatrocinioLabel4.setText("Receita dos patrocinios:");

        cgdLabel6.setText("Custos Game Designers:");

        fbalancoComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fbalancoComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbalancoComboBox1ActionPerformed(evt);
            }
        });

        BTotalLabel8.setText("Balanço total:");

        maflluencia.setText("dia de maior afluencia:");

        javax.swing.GroupLayout valorRbilhetesPanel6Layout = new javax.swing.GroupLayout(valorRbilhetesPanel6);
        valorRbilhetesPanel6.setLayout(valorRbilhetesPanel6Layout);
        valorRbilhetesPanel6Layout.setHorizontalGroup(
            valorRbilhetesPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valorRbilhetesPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(valorRbilhetesPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BalancoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fbalancoComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(valorRbilhetesPanel6Layout.createSequentialGroup()
                        .addGroup(valorRbilhetesPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(valorRbilhetesPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(RpatrocinioLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RBilhetesLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cgdLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                            .addComponent(BTotalLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maflluencia, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(valorRbilhetesPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(valorcgdjLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valorRpatrocinios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valorrbilhetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valorBTotalLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valormafluencia, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
                .addContainerGap(368, Short.MAX_VALUE))
        );
        valorRbilhetesPanel6Layout.setVerticalGroup(
            valorRbilhetesPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valorRbilhetesPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(valorRbilhetesPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(valorRbilhetesPanel6Layout.createSequentialGroup()
                        .addComponent(BalancoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fbalancoComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(RBilhetesLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RpatrocinioLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(valorRbilhetesPanel6Layout.createSequentialGroup()
                        .addComponent(valorrbilhetes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorRpatrocinios, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(valorRbilhetesPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cgdLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(valorRbilhetesPanel6Layout.createSequentialGroup()
                        .addComponent(valorcgdjLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addGap(6, 6, 6)
                .addGroup(valorRbilhetesPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(valorRbilhetesPanel6Layout.createSequentialGroup()
                        .addComponent(valorBTotalLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addComponent(BTotalLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(valorRbilhetesPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(maflluencia)
                    .addComponent(valormafluencia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(300, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Balanço", valorRbilhetesPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        NovoFestival novoFestival = new NovoFestival(this, fest);
        novoFestival.setLocationRelativeTo(null);
        
        this.setVisible(false);
        novoFestival.setVisible(true);
    }                                                                              


    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        terminar();
    }//GEN-LAST:event_formWindowClosing

    private void comboBoxGameDesignersActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        refreshListaGameDesigners();
    }                                                     

    private void comboBoxPatrocinadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPatrocinadoresActionPerformed
        refreshListaPatrocinadores();
    }//GEN-LAST:event_comboBoxPatrocinadoresActionPerformed

    private void ComboBoxColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxColaboradoresActionPerformed
        refreshListaColaboradores();
    }//GEN-LAST:event_ComboBoxColaboradoresActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        GestaoBilhetes novoGerirBilhetes = new GestaoBilhetes(this, fest);
        novoGerirBilhetes.setLocationRelativeTo(null);

        this.setVisible(false);
        novoGerirBilhetes.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        NovoPatrocinador novoPatrocinador = new NovoPatrocinador(this, fest);
        novoPatrocinador.setLocationRelativeTo(null);

        this.setVisible(false);
        novoPatrocinador.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        GameDesigner gameDesigner = new GameDesigner(this, fest);
        gameDesigner.setLocationRelativeTo(null);

        this.setVisible(false);
        gameDesigner.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ColaboradorForm colaborador = new ColaboradorForm(this, fest);
        colaborador.setLocationRelativeTo(null);

        this.setVisible(false);
        colaborador.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fbalancoComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbalancoComboBox1ActionPerformed
        refreshBalanco();
    }//GEN-LAST:event_fbalancoComboBox1ActionPerformed




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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BTotalLabel8;
    private javax.swing.JLabel BalancoLabel1;
    private javax.swing.JLabel ColaboradoresLabel;
    private javax.swing.JComboBox<String> ComboBoxColaboradores;
    private javax.swing.JLabel GDlabel;
    private javax.swing.JLabel PFEStivalLabel;
    private javax.swing.JLabel PtextoLabel1;
    private javax.swing.JLabel RBilhetesLabel3;
    private javax.swing.JLabel RpatrocinioLabel4;
    private javax.swing.JLabel cgdLabel6;
    private javax.swing.JTable colaboradoresTable;
    private javax.swing.JComboBox<String> comboBoxGameDesigners;
    private javax.swing.JComboBox<String> comboBoxPatrocinadores;
    private javax.swing.JComboBox<String> fbalancoComboBox1;
    private javax.swing.JTable festivaisTable;
    private javax.swing.JTable gameDesignersTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel maflluencia;
    private javax.swing.JTable patrocinadoresTable;
    private javax.swing.JLabel totalGameDesigners;
    private javax.swing.JLabel valorBTotalLabel9;
    private javax.swing.JPanel valorRbilhetesPanel6;
    private javax.swing.JLabel valorRpatrocinios;
    private javax.swing.JLabel valorcgdjLabel7;
    private javax.swing.JLabel valormafluencia;
    private javax.swing.JLabel valorrbilhetes;
    // End of variables declaration//GEN-END:variables
}


