package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.ControllerCasaco;

public class ViewDetailCasaco implements ActionListener{
    //name price material ziper capuz bolso tamanho  Pcash cor estoque
    private JFrame janela;
    private JLabel labelNome = new JLabel("Nome: ");
    private JTextField fieldNome;
    private JLabel labelPreco = new JLabel("Preço: ");
    private JTextField fieldPreco;
    private JLabel labelMaterial = new JLabel("Material: ");
    private JTextField fieldMaterial;
    private JLabel labelZiper = new JLabel("Possui ziper( true ou false): ");
    private JTextField fieldZiper;
    private JLabel labelCapuz = new JLabel("Possui capuz( true ou false): ");
    private JTextField fieldCapuz;
    private JLabel labelBolso = new JLabel("Possui bolso( true ou false): ");
    private JTextField fieldBolso;
    private JLabel labelTamanho = new JLabel("Tamanho(P, M, G): ");
    private JTextField fieldTamanho;
    private JLabel labelPCash = new JLabel("Porcentagem de cashback: ");
    private JTextField fieldPCash;
    private JLabel labelCor = new JLabel("Cor: ");
    private JTextField fieldCor;
    private JLabel labelEstoque = new JLabel("Estoque: ");
    private JTextField fieldEstoque;
    private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
    private String[] novoDado = new String[11];
    private static ControllerCasaco casaco = new ControllerCasaco();
    private int opc;
	private String s;
    private int posi;



    public void cadastrar(int op, ControllerCasaco ca, ViewCasaco viewCasaco, int pos) {
        posi = pos;
        opc = op;
        casaco = ca;

        if(posi == 1) s = "Cadastro Casaco";
        if(posi == 2) s = "Detalhe Casaco";
        janela = new JFrame(s);

        if (opc == 2){
            fieldNome = new JTextField(casaco.getCasaco(posi).getNome(), 200);
            fieldPreco = new JTextField(String.valueOf(casaco.getCasaco(posi).getPreco()),200);
            fieldTamanho = new JTextField(casaco.getCasaco(posi).getTamanhoString(), 200);
            fieldMaterial = new JTextField(casaco.getCasaco(posi).getMaterial(), 200);
            fieldZiper = new JTextField(String.valueOf(casaco.getCasaco(posi).getZiper()), 200);
            fieldCapuz = new JTextField(String.valueOf(casaco.getCasaco(posi).getCapuz()), 200);
            fieldBolso = new JTextField(String.valueOf(casaco.getCasaco(posi).getBolso()), 200);
            fieldPCash = new JTextField(String.valueOf(casaco.getCasaco(posi).getPorcentagem()), 200);
            fieldCor = new JTextField(String.valueOf(casaco.getCasaco(posi).getCor()), 200);
            fieldEstoque = new JTextField(String.valueOf(casaco.getCasaco(posi).getEstoque()), 200);
        }else{
            fieldNome = new JTextField(200);
            fieldTamanho = new JTextField(200);
            fieldPreco = new JTextField(200);
            fieldMaterial = new JTextField(200);
            fieldZiper = new JTextField(200);
            fieldCapuz = new JTextField(200);
            fieldBolso = new JTextField(200);
            fieldPCash = new JTextField(200);
            fieldCor = new JTextField(200);
            fieldEstoque = new JTextField(200);
            botaoSalvar.setBounds(245,280, 115, 30);
        }

            labelNome.setBounds(30, 20, 150, 25);
            fieldNome.setBounds(180, 20, 180, 25);
            labelPreco.setBounds(30, 50, 150, 25);
            fieldPreco.setBounds(180, 50, 180, 25);	
            labelMaterial.setBounds(30, 70, 150, 25);
            fieldMaterial.setBounds(180, 70, 28, 25);
            labelZiper.setBounds(30, 100, 150, 25);
            fieldZiper.setBounds(210, 100, 65, 25);
            labelCapuz.setBounds(30, 130, 150, 25);
            fieldCapuz.setBounds(180, 130, 180, 25);
            labelBolso.setBounds(30, 160, 150, 25);
            fieldBolso.setBounds(180, 160, 180, 25);
            labelPCash.setBounds(30, 190, 150, 25);
            fieldPCash.setBounds(180, 190, 180, 25);
            labelCor.setBounds(30, 220, 150, 25);
            fieldCor.setBounds(180, 220, 180, 25);
            labelEstoque.setBounds(30, 250, 150, 25);
            fieldEstoque.setBounds(180, 250, 180, 25);
            labelTamanho.setBounds(30, 280, 150, 25);
            fieldTamanho.setBounds(180, 280, 180, 25);

            
        if(opc == 2){
            botaoSalvar.setBounds(120, 300, 115, 30);
			botaoExcluir.setBounds(245, 300, 115, 30);
			this.janela.add(botaoExcluir);
        }

        this.janela.add(labelNome);
		this.janela.add(fieldNome);
		this.janela.add(labelPreco);
		this.janela.add(fieldPreco);
		this.janela.add(labelMaterial);
        this.janela.add(fieldMaterial);
        this.janela.add(labelZiper);
        this.janela.add(fieldZiper);
        this.janela.add(labelCapuz);
        this.janela.add(fieldCapuz);
        this.janela.add(labelBolso);
        this.janela.add(fieldBolso);
        this.janela.add(labelPCash);
        this.janela.add(fieldPCash);
        this.janela.add(labelCor);
        this.janela.add(fieldCor);
        this.janela.add(labelEstoque);
        this.janela.add(fieldEstoque);
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

                novoDado[0] = Integer.toString(casaco.getQtdCasaco());
				novoDado[1] = fieldNome.getText();
				novoDado[2] = fieldPreco.getText();
				novoDado[3] = fieldTamanho.getText();
				novoDado[4] = fieldPCash.getText();
				novoDado[5] = fieldCor.getText();
                novoDado[6] = fieldEstoque.getText();
                novoDado[7] = fieldCapuz.getText();
                novoDado[8] = fieldZiper.getText();
                novoDado[9] = fieldBolso.getText();
                novoDado[10] = fieldMaterial.getText();

                res = casaco.cadastro(novoDado);
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
				res = casaco.excluir(posi);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusao(); 
			
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

    public void mensagemErroExclusao() {
        JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n ", null, JOptionPane.ERROR_MESSAGE);
    }
}