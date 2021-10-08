package view;
import controller.ControllerCamiseta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Mostra os detalhes de cada objeto Camiseta na tela, chama os métodos de exclusão, cadastro e edição
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class ViewDetailCamiseta implements ActionListener {
    //nome preco tamanho gola Pcash cor estoque mangaLonga
    private JFrame janela;
    private JLabel labelNome = new JLabel("Nome: ");
    private JTextField fieldNome;
    private JLabel labelPreco = new JLabel("Preço: ");
    private JTextField fieldPreco;
    private JLabel labelGola = new JLabel("Gola: ");
    private JTextField fieldGola;
    private JLabel labelManga = new JLabel("Possui Manga Longa( true ou false): ");
    private JTextField fieldManga;
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
    private static ControllerCamiseta camiseta = new ControllerCamiseta();
    private int opc;
	private String s;
    private int posi;

    public void cadastrar(int op, ControllerCamiseta ca, ViewCamiseta viewCamiseta, int pos) {
        posi = pos;
        opc = op;
        camiseta = ca;

        if(posi == 1) s = "Cadastro Casaco";
        if(posi == 2) s = "Detalhe Casaco";
        janela = new JFrame(s);

        if (opc == 2){
            fieldNome = new JTextField(camiseta.getCamiseta(posi).getNome(), 200);
            fieldPreco = new JTextField(String.valueOf(camiseta.getCamiseta(posi).getPreco()),200);
            fieldTamanho = new JTextField(camiseta.getCamiseta(posi).getTamanhoString(), 200);
            fieldGola = new JTextField(camiseta.getCamiseta(posi).getGola(), 200);
            fieldManga = new JTextField(String.valueOf(camiseta.getCamiseta(posi).getMangaLonga()), 200);
            fieldPCash = new JTextField(String.valueOf(camiseta.getCamiseta(posi).getPorcentagem()), 200);
            fieldCor = new JTextField(camiseta.getCamiseta(posi).getCor(), 200);
            fieldEstoque = new JTextField(String.valueOf(camiseta.getCamiseta(posi).getEstoque()), 200);
        }else{
            fieldNome = new JTextField(200);
            fieldTamanho = new JTextField(200);
            fieldPreco = new JTextField(200);
            fieldGola = new JTextField(200);
            fieldManga = new JTextField(200);
            fieldPCash = new JTextField(200);
            fieldCor = new JTextField(200);
            fieldEstoque = new JTextField(200);
            botaoSalvar.setBounds(245,240, 115, 30);
        }
            labelNome.setBounds(30, 20, 150, 25);
            fieldNome.setBounds(180, 20, 180, 25);
            labelPreco.setBounds(30, 50, 150, 25);
            fieldPreco.setBounds(180, 50, 180, 25);	
            labelGola.setBounds(30, 70, 150, 25);
            fieldGola.setBounds(180, 70, 180, 25);
            labelManga.setBounds(30, 100, 150, 25);
            fieldManga.setBounds(180, 100, 180, 25);
            labelPCash.setBounds(30, 130, 150, 25);
            fieldPCash.setBounds(180, 130, 180, 25);
            labelCor.setBounds(30, 160, 150, 25);
            fieldCor.setBounds(180, 160, 180, 25);
            labelEstoque.setBounds(30, 190, 150, 25);
            fieldEstoque.setBounds(180, 190, 180, 25);
            labelTamanho.setBounds(30, 220, 150, 25);
            fieldTamanho.setBounds(180, 220, 180, 25);

        if(opc == 2){
            botaoSalvar.setBounds(120, 240, 115, 30);
			botaoExcluir.setBounds(245, 240, 115, 30);
			this.janela.add(botaoExcluir);
        }


        this.janela.add(labelNome);
		this.janela.add(fieldNome);
		this.janela.add(labelPreco);
		this.janela.add(fieldPreco);
		this.janela.add(labelGola);
        this.janela.add(fieldGola);
        this.janela.add(labelManga);
        this.janela.add(fieldManga);
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

                novoDado[0] = Integer.toString(camiseta.getQtdCamiseta());
				novoDado[1] = fieldNome.getText();
				novoDado[2] = fieldPreco.getText();
				novoDado[3] = fieldTamanho.getText();
				novoDado[4] = fieldGola.getText();
                novoDado[5] = fieldPCash.getText();
				novoDado[6] = fieldCor.getText();
                novoDado[7] = fieldEstoque.getText();
                novoDado[8] = fieldManga.getText();
               
                
                if(opc == 2){
                    res = camiseta.editar(novoDado, posi);
                }else{
                    res = camiseta.cadastro(novoDado);
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
				res = camiseta.excluir(posi);
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
