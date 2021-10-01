package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import controller.ControllerVenda;

public class ViewVenda implements ActionListener, ListSelectionListener{
    private JFrame janela;
	private JLabel titulo;
    private JButton cadastroVenda;
    private JButton refreshVenda;
	private JList<String> listaVendaCadastrados;
    private static ControllerVenda venda = new ControllerVenda();
	private String[] listaVenda = new String[50];

    public void mostrarDados(ControllerVenda vendaV) {
        for(int i = 0; i < venda.qtdVenda[0]; i++){
            listaVenda[i] = new ControllerVenda().getVenda(i).getNomeProduto();
        }
        listaVendaCadastrados = new JList<String>(listaVenda);
        janela = new JFrame("Vendas");
        titulo = new JLabel("Lista de Vendas");
        cadastroVenda = new JButton("Cadastrar");
        refreshVenda = new JButton("Recarregar");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(90, 10, 250, 30);
        listaVendaCadastrados.setBounds(20, 50, 350, 120);
        listaVendaCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaVendaCadastrados.setVisibleRowCount(10);

        cadastroVenda.setBounds(70, 177, 100, 30);
        refreshVenda.setBounds(200, 177, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaVendaCadastrados);
        janela.add(cadastroVenda);
        janela.add(refreshVenda);

        janela.setSize(400, 250);
        janela.setVisible(true);

        cadastroVenda.addActionListener(this);
        refreshVenda.addActionListener(this);
        listaVendaCadastrados.addListSelectionListener(this);
    }

    public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaVendaCadastrados) {
			new ViewDetailVenda().cadastrar(2, venda, this, listaVendaCadastrados.getSelectedIndex());
		}
    }

    public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastroVenda)
			new ViewDetailVenda().cadastrar(1, venda, this, 0);

		if(src == refreshVenda) {
			for(int i = 0; i < venda.qtdVenda[0]; i++){
                listaVenda[i] = new ControllerVenda().getVenda(i).getNomeProduto();
            }		
			listaVendaCadastrados.updateUI();
		}


	}
    
}
