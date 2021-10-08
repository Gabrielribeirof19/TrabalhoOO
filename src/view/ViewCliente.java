package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controller.ControllerCliente;

/**
 * Trabalha com os dados do cliente para que eles sejam apresentados na tela
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class ViewCliente implements ActionListener, ListSelectionListener{
    private JFrame janela;
    private JLabel titulo;
    private JButton cadastroCliente;
    private JButton refreshCliente;
    static ControllerCliente cliente = new ControllerCliente();
    private JList<String> listaClienteCadastrados;
    private String[] listaCliente = new String[50];
    private String [] dados = new String[11];

    /**
     * Mostrar os dados cadastrados no model Cliente e fazer ligação com outras views
     * @param clienteC Carrega os dados do Controller criado no menu
     * @param flag Carrega um inteiro para controlar o pré-cadastramento de dados no model 
     */
    public void mostrarDados(ControllerCliente clienteC, int [] flag) {
        if(flag[0] == 0){
            for (int i = 0; i < 5; i++){
                dados[1] = "Cliente"+i;
                dados[2] = "06732848159";
                dados[3] = i+"email@email.com";
                dados[4] = "061";
                dados[5] = "999999999";
                dados[6] = "End"+i;
                dados[7] = "42942134";
                dados[8] = "End"+i;
                dados[9] = "End"+i;
                dados[10] = "4."+i;
                cliente.cadastro(dados);
            }
            flag[0]++;
        }
        for(int i = 0; i < cliente.qtdCliente[0]; i++){
            listaCliente[i] = cliente.getCliente(i).getNome();
            System.out.println();
        }
        
        listaClienteCadastrados = new JList<String>(listaCliente);
        janela = new JFrame("Clientes");
        titulo = new JLabel("Lista de Clientes");
        cadastroCliente = new JButton("Cadastrar");
        refreshCliente = new JButton("Recarregar");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(90, 10, 250, 30);
        listaClienteCadastrados.setBounds(20, 50, 350, 120);
        listaClienteCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaClienteCadastrados.setVisibleRowCount(10);

        cadastroCliente.setBounds(70, 177, 100, 30);
        refreshCliente.setBounds(200, 177, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaClienteCadastrados);
        janela.add(cadastroCliente);
        janela.add(refreshCliente);
        janela.setSize(400, 250);
        janela.setVisible(true);
        cadastroCliente.addActionListener(this);
        refreshCliente.addActionListener(this);
        listaClienteCadastrados.addListSelectionListener(this);
    }

    public void valueChanged(ListSelectionEvent e) {

        if(e.getValueIsAdjusting()) {
            new ViewDetailCliente().cadastrar(2, cliente, this, listaClienteCadastrados.getSelectedIndex());
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
	
	    if(src == cadastroCliente)
			new ViewDetailCliente().cadastrar(1, cliente, this, 0);
        
        if (src == refreshCliente) {
            for(int i = 0; i < cliente.qtdCliente[0]; i++){
                System.out.println("VALOR QTDCLIENTE " + cliente.qtdCliente[0]);
                listaCliente[i] = cliente.getCliente(i).getNome();
            }
            listaClienteCadastrados.setListData(listaCliente);
            listaClienteCadastrados.updateUI();
        }
    }
}

