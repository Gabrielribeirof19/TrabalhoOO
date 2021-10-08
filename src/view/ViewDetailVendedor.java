package view;

import controller.ControllerVendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Mostra os detalhes de cada objeto Vendedor na tela, chama os métodos de exclusão, cadastro e edição
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class ViewDetailVendedor implements ActionListener{
    private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField fieldNome;
	private JLabel labelCpf = new JLabel("CPF: ");
	private JTextField fieldCpf;
	private JLabel labelTelefone = new JLabel("Telefone");
	private JTextField fieldDDD;
	private JTextField fieldTelefone;
	private JLabel labelEmail = new JLabel("Email: ");
	private JTextField fieldEmail;
	private JLabel labelIdentificador = new JLabel("Identificador: ");
	private JTextField fieldIdentificador;
    private JLabel labelNumeroDeVendas = new JLabel("Número de vendas: ");
	private JTextField fieldNumeroDeVendas;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[11];
	private static ControllerVendedor vendedor = new ControllerVendedor();
	private int opc;
	private String s;
    private int posi;

    public void cadastrar(int op, ControllerVendedor v, ViewVendedor viewVendedor, int pos) {
        posi = pos;
        opc = op;
        vendedor = v;

        if(posi == 1) s = "Cadastro Vendedor";
        if(posi == 2) s = "Detalhe Vendedor";
        janela = new JFrame(s);

        if (opc == 2){
            fieldNome = new JTextField(vendedor.getvVendedor(posi).getNome(), 200);
            fieldCpf = new JTextField(vendedor.getvVendedor(posi).getCpf(), 200);
            fieldDDD = new JTextField(vendedor.getvVendedor(posi).getTelefone().getDDD(), 200);
            fieldTelefone = new JTextField(vendedor.getvVendedor(posi).getTelefone().getNumero(), 200);
            fieldEmail = new JTextField(vendedor.getvVendedor(posi).getEmail(), 200);
            fieldIdentificador = new JTextField(String.valueOf(vendedor.getvVendedor(posi).getId()), 200);
            fieldNumeroDeVendas = new JTextField(String.valueOf(vendedor.getvVendedor(posi).getNumVenda()), 200);
        }else{
            fieldNome = new JTextField(200);
            fieldCpf = new JTextField(200);
            fieldDDD = new JTextField(200);
            fieldTelefone = new JTextField(200);
            fieldEmail = new JTextField(200);
            fieldIdentificador = new JTextField(200);
            fieldNumeroDeVendas = new JTextField(200);
            botaoSalvar.setBounds(245, 175, 115, 30);
        }

        labelNome.setBounds(30, 20, 150, 25);
		fieldNome.setBounds(180, 20, 180, 25);
		labelCpf.setBounds(30, 50, 150, 25);
		fieldCpf.setBounds(180, 50, 180, 25);	
		labelTelefone.setBounds(30, 70, 150, 25);
		fieldDDD.setBounds(180, 70, 28, 25);
		fieldTelefone.setBounds(210, 70, 65, 25);
        labelEmail.setBounds(30, 100, 150, 25);
        fieldEmail.setBounds(180, 100, 180, 25);
        labelIdentificador.setBounds(30, 130, 150, 25);
        fieldIdentificador.setBounds(180, 130, 180, 25);
        labelNumeroDeVendas.setBounds(30, 160, 150, 25);
        fieldNumeroDeVendas.setBounds(180, 160, 180, 25);
        
        if(opc == 2){
            botaoSalvar.setBounds(120, 195, 115, 30);
			botaoExcluir.setBounds(245, 195, 115, 30);
			this.janela.add(botaoExcluir);
        }

        this.janela.add(labelNome);
		this.janela.add(fieldNome);
		this.janela.add(labelCpf);
		this.janela.add(fieldCpf);
		this.janela.add(labelEmail);
		this.janela.add(fieldEmail);
		this.janela.add(labelTelefone);
		this.janela.add(fieldDDD);
		this.janela.add(fieldTelefone);
		this.janela.add(botaoSalvar);
        this.janela.add(labelIdentificador);
		this.janela.add(fieldIdentificador);
        this.janela.add(labelNumeroDeVendas);
		this.janela.add(fieldNumeroDeVendas);

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
				
				novoDado[0] = Integer.toString(vendedor.getQtdVendedor());
				novoDado[1] = fieldNome.getText();
				novoDado[2] = fieldCpf.getText();
				novoDado[3] = fieldEmail.getText();
				novoDado[4] = fieldDDD.getText();
				novoDado[5] = fieldTelefone.getText();
                novoDado[6] = fieldIdentificador.getText();
                novoDado[7] = fieldNumeroDeVendas.getText();

                if(opc == 2){
                    res = vendedor.editar(novoDado, posi);
                }else{
                    res = vendedor.cadastro(novoDado);
                }
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
				res = vendedor.excluir(posi);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoVendedor(); 
			
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
        JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
                + "Pode ter ocorrido um dos dois erros a seguir:  \n"
                + "1. Nem todos os campos foram preenchidos \n"
                + "2. CPF, identidade, DDD e telefone não contém apenas números", null, 
                JOptionPane.ERROR_MESSAGE);
    }

    public void mensagemErroExclusaoCliente() {
        JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n ", null, JOptionPane.ERROR_MESSAGE);
    }
    
    public void mensagemErroExclusaoVendedor() {
        JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n ", null, JOptionPane.ERROR_MESSAGE);
    }
}

