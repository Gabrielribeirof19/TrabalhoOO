package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import controller.ControllerCamiseta;
/**
 * Trabalha com os dados da camiseta para que eles sejam apresentados na tela
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class ViewCamiseta implements ActionListener, ListSelectionListener{
    private JFrame janela;
	private JLabel titulo;
    private JButton cadastroCamiseta;
    private JButton refreshCamiseta;
    private String[] listaCamiseta = new String[50];
    static ControllerCamiseta camiseta= new ControllerCamiseta();
    private JList <String> listaCamisetaCadastrados;
    private String [] dados = new String[11];


    /**
     * Mostrar os dados cadastrados no model Camiseta e fazer ligação com outras views
     * @param camisetaC Carrega os dados do Controller criado no menu
     * @param flag Carrega um inteiro para controlar o pré-cadastramento de dados no model 
     */
    public void mostrarDados(ControllerCamiseta camisetaC, int [] flag) {
        if(flag[0] == 0){
            for (int i = 0; i < 5; i++){
                dados[1] = "Camiseta"+i;
                dados[2] = "23"+i;
                dados[3] = "M";
                dados[4] = "Polo";
                dados[5] = "3"+i;
                dados[6] = "Azul";
                dados[7] = ""+i;
                dados[8] = "true";
                camiseta.cadastro(dados);
            }
            flag[0]++;
        }
        for(int i = 0; i < camiseta.qtdCamiseta[0]; i++){
            listaCamiseta[i] =  camiseta.getCamiseta(i).getNome();
        }

        listaCamisetaCadastrados = new JList<String>(listaCamiseta);
        janela = new JFrame("Camisetas");
        titulo = new JLabel("Lista de Camisetas");
        cadastroCamiseta = new JButton("Cadastrar");
        refreshCamiseta = new JButton("Recarregar");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(90, 10, 250, 30);
        listaCamisetaCadastrados.setBounds(20, 50, 350, 120);
        listaCamisetaCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaCamisetaCadastrados.setVisibleRowCount(10);

        cadastroCamiseta.setBounds(70, 177, 100, 30);
        refreshCamiseta.setBounds(200, 177, 100, 30);

        janela.setLayout(null);
        janela.add(titulo);
        janela.add(listaCamisetaCadastrados);
        janela.add(cadastroCamiseta);
        janela.add(refreshCamiseta);

        janela.setSize(400, 250);
        janela.setVisible(true);
        cadastroCamiseta.addActionListener(this);
        refreshCamiseta.addActionListener(this);
        listaCamisetaCadastrados.addListSelectionListener(this);
    
    }

	public void valueChanged(ListSelectionEvent e) {
    	if(e.getValueIsAdjusting()) {
            new ViewDetailCamiseta().cadastrar(2, camiseta, this, listaCamisetaCadastrados.getSelectedIndex());
    	}   
		
	}

	public void actionPerformed(ActionEvent e) {
		  Object src = e.getSource();
        if(src == cadastroCamiseta){
            new ViewDetailCamiseta().cadastrar(1, camiseta, this, 0);
        }

        if (src == refreshCamiseta) {
            for(int i = 0; i < camiseta.qtdCamiseta[0]; i++){
                listaCamiseta[i] = camiseta.getCamiseta(i).getNome();
            }
            listaCamisetaCadastrados.setListData(listaCamiseta);
            listaCamisetaCadastrados.updateUI();
        }
		
	}
    
}
