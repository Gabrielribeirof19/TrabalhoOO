package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import controller.ControllerInferior;

/**
 * Trabalha com os dados do inferior para que eles sejam apresentados na tela
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class ViewInferior implements ActionListener, ListSelectionListener{
    private JFrame janela;
    private JLabel titulo;
    private JButton cadastroInferior;
    private JButton refreshInferior;
 	private String[] ListaInferior = new String[50];
    static ControllerInferior inf = new ControllerInferior();
    JList<String> ListaInferiorCadastrados;
    private String[] dados = new String[11];
    
    /**
     * Mostrar os dados cadastrados no model Inferior e fazer ligação com outras views
     * @param inferiorC Carrega os dados do controller criado no menu
     * @param flag Carrega um inteiro para controlar o pré-cadastramento de dados no model
     */
    public void mostrarDados(ControllerInferior inferiorC, int [] flag) {
        if (flag[0] == 0){
            for (int i = 0; i < 5; i++){
            dados[1] = "Inferior"+i;
            dados[2] = "32"+i;
            dados[3] = "4"+i;
            dados[4] = "4."+i;
            dados[5] = "Azul";
            dados[6] = ""+i;
            dados[7] = "Tipo"+i;
            dados[8] = "Material"+i;
            inf.cadastro(dados);
        }
        flag[0]++;
    }
        
        for(int i = 0; i < inf.qtdInferior[0]; i++){
         ListaInferior[i] = inf.getiInferior(i).getNome();
        }

        ListaInferiorCadastrados = new JList<String> (ListaInferior);
        janela = new JFrame("Vestuário Inferior");
        titulo = new JLabel("Lista de vestuário Inferior");
        cadastroInferior = new JButton("Cadastrar");
        refreshInferior = new JButton("Recarregar");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(70, 10, 300, 30);
        ListaInferiorCadastrados.setBounds(20, 50, 350, 120);
        ListaInferiorCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        ListaInferiorCadastrados.setVisibleRowCount(10);

        cadastroInferior.setBounds(70, 177, 100, 30);
        refreshInferior.setBounds(200, 177, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(ListaInferiorCadastrados);
        janela.add(cadastroInferior);
        janela.add(refreshInferior);

        janela.setSize(400, 250);
        janela.setVisible(true);

        cadastroInferior.addActionListener(this);
        refreshInferior.addActionListener(this);
        ListaInferiorCadastrados.addListSelectionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == cadastroInferior){
            new ViewDetailInferior().cadastrar(1, inf, this, 0);
        }

        if (src == refreshInferior) {
            for(int i = 0; i < inf.qtdInferior[0]; i++){
                ListaInferior[i] = inf.getiInferior(i).getNome();
            }
            ListaInferiorCadastrados.setListData(ListaInferior);
            ListaInferiorCadastrados.updateUI();
        }
    }   

    public void valueChanged(ListSelectionEvent e) {
    	if(e.getValueIsAdjusting()) {
            new ViewDetailInferior().cadastrar(2, inf, this, ListaInferiorCadastrados.getSelectedIndex());
    	}      
    }
}