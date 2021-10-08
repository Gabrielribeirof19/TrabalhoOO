package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import controller.ControllerVendedor;

/**
 * Trabalha com os dados do vendedor para que eles sejam apresentados na tela
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class ViewVendedor implements ActionListener, ListSelectionListener{
    private JFrame janela;
    private JLabel titulo;
    private JButton cadastroVendedor;
    private JButton refreshVendedor;
 	private String[] ListaVendedor = new String[50];
    static ControllerVendedor vendedor = new ControllerVendedor();
    JList<String> ListaVendedorCadastrados;
    private String [] dados = new String[11];

    /**
     * Mostrar os dados cadastrados no model Vendedor e fazer ligação com outras views
     * @param vendedorC Carrega os dados do controller criado no menu
     * @param flag Carrega um inteiro para controlar o pré-cadastramento de dados no model 
     */
    public void mostrarDados(ControllerVendedor vendedorC, int [] flag) {
        if(flag[0] == 0){
            for (int i = 0; i < 5; i++){
                dados[1] = "Vendedor"+i;
                dados[2] = "04582492399";
                dados[3] = i+"email@email.com";
                dados[4] = "061";
                dados[5] = "999999999";
                dados[6] = ""+i;
                dados[7] = "3"+i;
                vendedor.cadastro(dados);
            }
            flag[0]++;
        }
        for(int i = 0; i < vendedor.qtdVendedor[0]; i++){
            ListaVendedor[i] = vendedor.getvVendedor(i).getNome();
        }

        ListaVendedorCadastrados = new JList<String>(ListaVendedor);
        janela = new JFrame("Vendedores");
        titulo = new JLabel("Lista de Vendedores");
        cadastroVendedor = new JButton("Cadastrar");
        refreshVendedor = new JButton("Recarregar");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(90, 10, 250, 30);
        ListaVendedorCadastrados.setBounds(20, 50, 350, 120);
        ListaVendedorCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        ListaVendedorCadastrados.setVisibleRowCount(10);

        cadastroVendedor.setBounds(70, 177, 100, 30);
        refreshVendedor.setBounds(200, 177, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(ListaVendedorCadastrados);
        janela.add(cadastroVendedor);
        janela.add(refreshVendedor);

        janela.setSize(400, 250);
        janela.setVisible(true);

        cadastroVendedor.addActionListener(this);
        refreshVendedor.addActionListener(this);
        ListaVendedorCadastrados.addListSelectionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == cadastroVendedor){
            new ViewDetailVendedor().cadastrar(1, vendedor, this, 0);
        }

        if (src == refreshVendedor) {
            for(int i = 0; i < vendedor.qtdVendedor[0]; i++){
                ListaVendedor[i] = vendedor.getvVendedor(i).getNome();
            }
            ListaVendedorCadastrados.setListData(ListaVendedor);
            ListaVendedorCadastrados.updateUI();
        }
    }   

    public void valueChanged(ListSelectionEvent e) {
    	if(e.getValueIsAdjusting()) {
            new ViewDetailVendedor().cadastrar(2, vendedor, this, ListaVendedorCadastrados.getSelectedIndex());
    	}      
    }
}


