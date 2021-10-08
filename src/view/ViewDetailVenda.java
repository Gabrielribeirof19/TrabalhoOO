package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControllerCalcado;
import controller.ControllerCamiseta;
import controller.ControllerCasaco;
import controller.ControllerCliente;
import controller.ControllerInferior;
import controller.ControllerVenda;
import controller.ControllerVendedor;

/**
 * Mostra os detalhes de cada objeto Venda na tela, chama os métodos de exclusão e cadastro
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class ViewDetailVenda implements ActionListener{

    private JFrame janela;
	private JLabel labelNomeCliente = new JLabel("Nome do Cliente: ");
	private JTextField fieldNomeCliente;
	private JLabel labelPreco = new JLabel("Preço: ");
	private JTextField fieldPreco;
	private JLabel labelIdVenda = new JLabel("Id da venda: ");
	private JTextField fieldIdVenda;
	private JLabel labelIdVendedor = new JLabel("Id Vendedor: ");
	private JTextField fieldIdVendedor;
	private JLabel labelNomeProduto = new JLabel("Nome do Produto: ");
	private JTextField fieldNomeProduto;
	private JLabel labelCashBack = new JLabel("CashBack: ");
	private JTextField fieldCashBack;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControllerVenda v = new ControllerVenda();
	private int posi;
	private int opc;
	private String s;
    private ControllerCliente c;
    private ControllerCalcado calcado;
    private ControllerCamiseta camiseta;
    private ControllerCasaco casaco;
    private ControllerInferior inf;
    private ControllerVendedor vendedor;
    
    public void cadastrar(int op, ControllerVenda venda, ViewVenda viewVenda, int pos, ControllerCliente cliente, ControllerCalcado cal, ControllerInferior inferior, ControllerCasaco cas, ControllerVendedor ve, ControllerCamiseta cam) {
        opc = op;
		posi = pos;
		v = venda;
        c = cliente;
        calcado = cal;
        inf = inferior;
        casaco = cas;
        vendedor = ve;
        camiseta = cam;

        if (opc == 1) s = "Cadastro de Venda";
		if (opc == 2) s = "Detalhe Venda";
        janela = new JFrame(s);

        if (opc == 2){
            fieldNomeCliente = new JTextField(v.getVenda(posi).getNomeCliente(), 200);
            fieldPreco = new JTextField(String.valueOf(v.getVenda(posi).getPreco()), 200);
            fieldIdVenda = new JTextField(String.valueOf(v.getVenda(posi).getIdVenda()), 200);
            fieldIdVendedor = new JTextField(String.valueOf(v.getVenda(posi).getIdVendedor()), 200);
            fieldNomeProduto = new JTextField(v.getVenda(posi).getNomeProduto(), 200);
            fieldCashBack = new JTextField(String.valueOf(v.getVenda(posi).getCashBack()), 200);
            botaoSalvar.setBounds(120, 195, 115, 30);
			botaoExcluir.setBounds(245, 195, 115, 30);
			this.janela.add(botaoExcluir);

        }else{
            fieldNomeCliente = new JTextField(200);
            fieldIdVendedor = new JTextField(200);
            fieldIdVenda = new JTextField(200);
            fieldNomeProduto = new JTextField(200);
            fieldPreco = new JTextField(200);
            fieldCashBack = new JTextField(200);
            botaoSalvar.setBounds(245, 175, 115, 30);
        }

        labelNomeCliente.setBounds(30, 20, 150, 25);
		fieldNomeCliente.setBounds(180, 20, 180, 25);
		labelPreco.setBounds(30, 50, 150, 25);
		fieldPreco.setBounds(180, 50, 180, 25);	
		labelIdVenda.setBounds(30, 70, 150, 25);
		fieldIdVenda.setBounds(180, 70, 28, 25);
        labelIdVendedor.setBounds(30, 100, 150, 25);
        fieldIdVendedor.setBounds(180, 100, 180, 25);
        labelNomeProduto.setBounds(30, 130, 150, 25);
        fieldNomeProduto.setBounds(180, 130, 180, 25);
        labelCashBack.setBounds(30, 160, 150, 25);
        fieldCashBack.setBounds(180, 160, 180, 25);


        this.janela.add(labelNomeCliente);
		this.janela.add(fieldNomeCliente);
		this.janela.add(labelPreco);
		this.janela.add(fieldPreco);
		this.janela.add(labelIdVenda);
		this.janela.add(fieldIdVenda);
		this.janela.add(labelIdVendedor);
		this.janela.add(fieldIdVendedor);
        this.janela.add(labelNomeProduto);
		this.janela.add(fieldNomeProduto);
        this.janela.add(labelCashBack);
		this.janela.add(fieldCashBack);
        this.janela.add(botaoSalvar);


        this.janela.setLayout(null);

		this.janela.setSize(400, 350);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res = true;
	
				novoDado[0] = Integer.toString(v.getQtdVenda());
				novoDado[1] = fieldNomeCliente.getText();
                novoDado[2] = fieldNomeProduto.getText();
                novoDado[3] = fieldIdVendedor.getText();
                novoDado[4] = fieldIdVenda.getText();

                res = v.cadastro(novoDado, c, calcado, inf, casaco, vendedor, camiseta);
				if(res) {
					mensagemSucessoCadastro();
				}
				else mensagemErroCadastro();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}
		if(src == botaoExcluir) {
			boolean res = false;
				res = v.cancelar(posi);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoVenda(); 
			
		}
	}
    public void mensagemSucessoExclusao() {
        JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    public void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    public void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n ", null, 
                JOptionPane.ERROR_MESSAGE);
    }
    
    public void mensagemErroExclusaoVenda() {
        JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n ", null, JOptionPane.ERROR_MESSAGE);
    }

}
