package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import controller.ControllerVendedor;


public class ViewVendedor implements ActionListener, ListSelectionListener{
    private JFrame janela;
    private JLabel titulo;
    private JButton cadastroVendedor;
    private JButton refreshVendedor;
 	private String[] ListaVendedor = new String[50];
    private static ControllerVendedor v = new ControllerVendedor();
    JList<String> ListaVendedorCadastrados;
    
    public void mostrarDados(ControllerVendedor vendedorC) {
    
        for(int i = 0; i < v.qtdVendedor[0]; i++){
            ListaVendedor[i] = new ControllerVendedor().getvVendedor(i).getNome();
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
            new ViewDetailVendedor().cadastrar(1, v, this, 0);
        }

        if (src == refreshVendedor) {
            for(int i = 0; i < v.qtdVendedor[0]; i++){
                ListaVendedor[i] = v.getvVendedor(i).getNome();
            }
            ListaVendedorCadastrados.updateUI();
        }
    }   

    public void valueChanged(ListSelectionEvent e) {
    	if(e.getValueIsAdjusting()) {
            new ViewDetailVendedor().cadastrar(2, v, this, ListaVendedorCadastrados.getSelectedIndex());
    	}      
    }
}


