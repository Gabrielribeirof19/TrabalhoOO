package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import controller.ControllerCasaco;

public class ViewCasaco implements ActionListener, ListSelectionListener{
    private JFrame janela;
	private JLabel titulo;
    private JButton cadastroCasaco;
    private JButton refreshCasaco;
    private String[] listaCasaco = new String[50];
    private static ControllerCasaco casaco = new ControllerCasaco();
    JList <String> listaCasacoCadastrados;




    public void mostrarDados(ControllerCasaco casacoC) {
        for(int i = 0; i < casaco.qtdCasaco[0]; i++){
            listaCasaco[i] = casaco.getCasaco(i).getNome();
        }


        listaCasacoCadastrados = new JList<String>(listaCasaco);
        janela = new JFrame("Casacos");
        titulo = new JLabel("Lista de Casacos");
        cadastroCasaco = new JButton("Cadastrar");
        refreshCasaco = new JButton("Recarregar");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(90, 10, 250, 30);
        listaCasacoCadastrados.setBounds(20, 50, 350, 120);
        listaCasacoCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaCasacoCadastrados.setVisibleRowCount(10);

        cadastroCasaco.setBounds(70, 177, 100, 30);
        refreshCasaco.setBounds(200, 177, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaCasacoCadastrados);
        janela.add(cadastroCasaco);
        janela.add(refreshCasaco);

        janela.setSize(400, 250);
        janela.setVisible(true);

        cadastroCasaco.addActionListener(this);
        refreshCasaco.addActionListener(this);
        listaCasacoCadastrados.addListSelectionListener(this);
    
    }

	public void valueChanged(ListSelectionEvent e) {
    	if(e.getValueIsAdjusting()) {
            new ViewDetailCasaco().cadastrar(2, casaco, this, listaCasacoCadastrados.getSelectedIndex());
    	}   
		
	}
    
	public void actionPerformed(ActionEvent e) {
		  Object src = e.getSource();
        if(src == cadastroCasaco){
            new ViewDetailCasaco().cadastrar(1, casaco, this, 0);
        }

        if (src == refreshCasaco) {
            for(int i = 0; i < casaco.qtdCasaco[0]; i++){
                listaCasaco[i] = casaco.getCasaco(i).getNome();
            }
            listaCasacoCadastrados.setListData(listaCasaco);
            listaCasacoCadastrados.updateUI();
        }
		
	}
    
}
