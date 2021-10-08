package view;

import controller.ControllerCalcado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Mostra os detalhes de cada objeto Calcado na tela, chama os métodos de exclusão, cadastro e edição
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class ViewDetailCalcado implements ActionListener{
    private JFrame janela;
    private JLabel labelNome = new JLabel("Nome: ");
    private JTextField fieldNome;
    private JLabel labelPreco = new JLabel("Preço: ");
    private JTextField fieldPreco;
    private JLabel labelTamanho = new JLabel("Tamanho: ");
    private JTextField fieldTamanho;
    private JLabel labelPorcentagemCash = new JLabel("Porcentagem Cash: ");
    private JTextField fieldPorcentagemCash;
    private JLabel labelCor = new JLabel("Cor: ");
    private JTextField fieldCor;
    private JLabel labelEstoque = new JLabel("Estoque: ");
    private JTextField fieldEstoque;
    private JLabel labelCanoLongo = new JLabel("Cano Longo(true ou false): ");
    private JTextField fieldCanoLongo;
    private JLabel labelCadarco = new JLabel("Cadarço(true ou false): ");
    private JTextField fieldCadarco;
    private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
    private static ControllerCalcado calcado = new ControllerCalcado();
    private String[] novoDado = new String[11];
    private int opc;
	private String s;
    private int posi;
    
    public void cadastrar(int op, ControllerCalcado ca, ViewCalcado viewCalcado, int pos) {
        posi = pos;
        opc = op;
        calcado = ca;

        if(posi == 1) s = "Cadastro calcado";
        if(posi == 2) s = "Detalhe calcado";
        janela = new JFrame(s);

        if (opc == 2){
            fieldNome = new JTextField(calcado.getCalcado(posi).getNome(), 200);
            fieldPreco = new JTextField(String.valueOf(calcado.getCalcado(posi).getPreco()), 200);
            fieldTamanho = new JTextField(String.valueOf(calcado.getCalcado(posi).getTamanho()), 200);
            fieldPorcentagemCash = new JTextField(String.valueOf(calcado.getCalcado(posi).getPorcentagem()), 200);
            fieldCor = new JTextField(calcado.getCalcado(posi).getCor(), 200);
            fieldEstoque = new JTextField(String.valueOf(calcado.getCalcado(posi).getEstoque()), 200);
            fieldCanoLongo = new JTextField(String.valueOf(calcado.getCalcado(posi).getCano()), 200);
            fieldCadarco = new JTextField(String.valueOf(calcado.getCalcado(posi).getCadarco()), 200);

        }else{
            fieldNome = new JTextField(200);
            fieldPreco = new JTextField(200);
            fieldTamanho = new JTextField(200);
            fieldPorcentagemCash = new JTextField(200);
            fieldCor = new JTextField(200);
            fieldEstoque = new JTextField(200);
            fieldCanoLongo = new JTextField(200);
            fieldCadarco = new JTextField(200);
            botaoSalvar.setBounds(245, 250, 115, 30);
        }

        labelNome.setBounds(30, 20, 150, 25);
		fieldNome.setBounds(180, 20, 180, 25);
		labelPreco.setBounds(30, 50, 150, 25);
		fieldPreco.setBounds(180, 50, 180, 25);	
		labelTamanho.setBounds(30, 70, 150, 25);
		fieldTamanho.setBounds(180, 70, 180, 25);
        labelPorcentagemCash.setBounds(30, 100, 170, 25);
        fieldPorcentagemCash.setBounds(180, 100, 180, 25);
        labelCor.setBounds(30, 130, 150, 25);
        fieldCor.setBounds(180, 130, 180, 25);
        labelEstoque.setBounds(30, 160, 150, 25);
        fieldEstoque.setBounds(180, 160, 180, 25);
        labelCanoLongo.setBounds(30, 190, 180, 25);
        fieldCanoLongo.setBounds(200, 190, 180, 25);
        labelCadarco.setBounds(30, 220, 180, 25);
        fieldCadarco.setBounds(190, 220, 180, 25);

        
        if(opc == 2){
            botaoSalvar.setBounds(120, 250, 115, 30);
			botaoExcluir.setBounds(245, 250, 115, 30);
			this.janela.add(botaoExcluir);
        }

        this.janela.add(labelNome);
		this.janela.add(fieldNome);
		this.janela.add(labelPreco);
		this.janela.add(fieldPreco);
		this.janela.add(labelTamanho);
		this.janela.add(fieldTamanho);
		this.janela.add(labelPorcentagemCash);
		this.janela.add(fieldPorcentagemCash);
		this.janela.add(botaoSalvar);
        this.janela.add(labelCor);
		this.janela.add(fieldCor);
        this.janela.add(labelEstoque);
		this.janela.add(fieldEstoque);
        this.janela.add(labelCanoLongo);
		this.janela.add(fieldCanoLongo);
        this.janela.add(labelCadarco);
		this.janela.add(fieldCadarco);

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
				if(opc == 1) 
					novoDado[0] = Integer.toString(calcado.getQtdCalcado());

				novoDado[1] = fieldNome.getText();
				novoDado[2] = fieldPreco.getText();
				novoDado[3] = fieldTamanho.getText();
				novoDado[4] = fieldPorcentagemCash.getText();
				novoDado[5] = fieldCor.getText();
                novoDado[6] = fieldEstoque.getText();
                novoDado[7] = fieldCanoLongo.getText();
                novoDado[8] = fieldCadarco.getText();


                if(opc == 2){
                    res = calcado.editar(novoDado, posi);
                }else{
                    res = calcado.cadastro(novoDado);
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
				res = calcado.excluir(posi);
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