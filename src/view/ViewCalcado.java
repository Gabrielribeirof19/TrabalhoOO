package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import controller.ControllerCalcado;


public class ViewCalcado implements ActionListener, ListSelectionListener{
    private JFrame janela;
    private JLabel titulo;
    private JButton cadastroCalcado;
    private JButton refreshCalcado;
 	private String[] ListaCalcado = new String[50];
    private static ControllerCalcado calcado = new ControllerCalcado();
    private JList<String> ListaCalcadoCadastrados;
    
    public void mostrarDados(ControllerCalcado calcadoC) {
    
        for(int i = 0; i < calcado.qtdCalcado[0]; i++){
            ListaCalcado[i] = calcado.getCalcado(i).getNome();
        }

        ListaCalcadoCadastrados = new JList<String>(ListaCalcado);
        janela = new JFrame("Calçados");
        titulo = new JLabel("Lista de Calçados");
        cadastroCalcado = new JButton("Cadastrar");
        refreshCalcado = new JButton("Recarregar");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(90, 10, 250, 30);
        ListaCalcadoCadastrados.setBounds(20, 50, 350, 120);
        ListaCalcadoCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        ListaCalcadoCadastrados.setVisibleRowCount(10);

        cadastroCalcado.setBounds(70, 177, 100, 30);
        refreshCalcado.setBounds(200, 177, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(ListaCalcadoCadastrados);
        janela.add(cadastroCalcado);
        janela.add(refreshCalcado);

        janela.setSize(400, 250);
        janela.setVisible(true);

        cadastroCalcado.addActionListener(this);
        refreshCalcado.addActionListener(this);
        ListaCalcadoCadastrados.addListSelectionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == cadastroCalcado){
            new ViewDetailCalcado().cadastrar(1, calcado, this, ListaCalcadoCadastrados.getSelectedIndex());
        }

        if (src == refreshCalcado) {
            for(int i = 0; i < calcado.qtdCalcado[0]; i++){
                ListaCalcado[i] = calcado.getCalcado(i).getNome();
            }
            ListaCalcadoCadastrados.setListData(ListaCalcado);

            ListaCalcadoCadastrados.updateUI();
        }
    }   

    public void valueChanged(ListSelectionEvent e) {
    	if(e.getValueIsAdjusting()) {
            new ViewDetailCalcado().cadastrar(2, calcado, this, ListaCalcadoCadastrados.getSelectedIndex());
    	}      
    }
}


