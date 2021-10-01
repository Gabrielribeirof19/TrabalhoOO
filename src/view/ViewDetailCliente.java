package view;

import controller.ControllerCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewDetailCliente implements ActionListener{
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
    private JLabel labelCEP = new JLabel("CEP: ");
    private JTextField fieldCEP;
    private JLabel labelBairro = new JLabel("Bairro: ");
    private JTextField fieldBairro;
    private JLabel labelComplemento = new JLabel("Complemento: ");
    private JTextField fieldComplemento;
    private JLabel labelEndereco = new JLabel("Endereço: ");
    private JTextField fieldEndereco;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[11];
	private static ControllerCliente cliente = new ControllerCliente();
	private int opc;
	private String s;
    private int posi;

    public void cadastrar(int op, ControllerCliente c, ViewCliente viewCliente, int pos) {
        posi = pos;
        opc = op;
        cliente = c;

        if(posi == 1) s = "Cadastro Cliente";
        if(posi == 2) s = "Detalhe Cliente";
        janela = new JFrame(s);

        if (opc == 2){
            fieldNome = new JTextField(cliente.getCliente(posi).getNome(), 200);
            fieldCpf = new JTextField(cliente.getCliente(posi).getCpf(), 200);
            fieldDDD = new JTextField(cliente.getCliente(posi).getTelefone().getDDD(), 200);
            fieldTelefone = new JTextField(cliente.getCliente(posi).getTelefone().getNumero(), 200);
            fieldEmail = new JTextField(cliente.getCliente(posi).getEmail(), 200);
            fieldEndereco = new JTextField((cliente.getCliente(posi).getEndereco().getEndereco()), 200);
            fieldCEP = new JTextField(String.valueOf(cliente.getCliente(posi).getEndereco().getCEP()), 200);
            fieldComplemento = new JTextField((cliente.getCliente(posi).getEndereco().getComplemento()), 200);
            fieldBairro = new JTextField((cliente.getCliente(posi).getEndereco().getBairro()), 200);

        }else{
            fieldNome = new JTextField(200);
            fieldCpf = new JTextField(200);
            fieldDDD = new JTextField(200);
            fieldTelefone = new JTextField(200);
            fieldEmail = new JTextField(200);
            fieldEndereco = new JTextField(200);
            fieldCEP = new JTextField(200);
            fieldComplemento = new JTextField(200);
            fieldBairro = new JTextField(200);
            botaoSalvar.setBounds(245, 270, 115, 30);
        }

        labelNome.setBounds(30, 20, 150, 25);
		fieldNome.setBounds(180, 20, 180, 25);
		labelCpf.setBounds(30, 50, 150, 25);
		fieldCpf.setBounds(180, 50, 180, 25);	
		labelTelefone.setBounds(30, 80, 150, 25);
		fieldDDD.setBounds(180, 80, 28, 25);
		fieldTelefone.setBounds(210, 80, 65, 25);
        labelEmail.setBounds(30, 110, 150, 25);
        fieldEmail.setBounds(180, 110, 180, 25);
        labelEndereco.setBounds(30, 140, 150, 25);
        fieldEndereco.setBounds(180, 140, 180, 25);
        labelCEP.setBounds(30, 170, 150, 25);
        fieldCEP.setBounds(180, 170, 180, 25);
        labelBairro.setBounds(30, 200, 150, 25);
        fieldBairro.setBounds(180, 200, 180, 25);
        labelComplemento.setBounds(30, 230, 150, 25);
        fieldComplemento.setBounds(180, 230, 180, 25);
        
        if(opc == 2){
            botaoSalvar.setBounds(120, 270, 115, 30);
			botaoExcluir.setBounds(245, 270, 115, 30);
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
        this.janela.add(labelEndereco);
		this.janela.add(fieldEndereco);
        this.janela.add(labelCEP);
		this.janela.add(fieldCEP);
        this.janela.add(labelBairro);
		this.janela.add(fieldBairro);
        this.janela.add(labelComplemento);
		this.janela.add(fieldComplemento);

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
				
                novoDado[0] = Integer.toString(cliente.getQtdCliente());
				novoDado[1] = fieldNome.getText();
				novoDado[2] = fieldCpf.getText();
				novoDado[3] = fieldEmail.getText();
				novoDado[4] = fieldDDD.getText();
				novoDado[5] = fieldTelefone.getText();
                novoDado[6] = fieldEndereco.getText();
                novoDado[7] = fieldCEP.getText();
                novoDado[8] = fieldBairro.getText();
                novoDado[9] = fieldComplemento.getText();
                
                res = cliente.cadastro(novoDado);
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
				res = cliente.excluir(posi);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoCliente(); 
			
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
    
}