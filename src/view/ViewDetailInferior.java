package view;

import controller.ControllerInferior;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewDetailInferior implements ActionListener {
    private JFrame janela;
    private JLabel labelNome = new JLabel("Nome: ");
    private JTextField fieldNome;
    private JLabel labelPreco = new JLabel("Preço: ");
    private JTextField fieldPreco;
    private JLabel labelTamanho = new JLabel("Tamanho(NUMERAL): ");
    private JTextField fieldTamanho;
    private JLabel labelPorcentagemCash = new JLabel("Porcentagem de Cash: ");
    private JTextField fieldPorcentagemCash;
    private JLabel labelCor = new JLabel("Cor: ");
    private JTextField fieldCor;
    private JLabel labelEstoque = new JLabel("Estoque: ");
    private JTextField fieldEstoque;
    private JLabel labelMaterial = new JLabel("Material: ");
    private JTextField fieldMaterial;
    private JLabel labelTipo = new JLabel("Tipo(Skinny, jogger): ");
    private JTextField fieldTipo;
    private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
    private static ControllerInferior inferior = new ControllerInferior();
    private String[] novoDado = new String[11];
    private int opc;
	private String s;
    private int posi;

    public void cadastrar(int op, ControllerInferior inf, ViewInferior viewInferior, int pos){
        posi = pos;
        opc = op;
        inferior = inf;

        if(posi == 1) s = "Cadastro calcado";
        if(posi == 2) s = "Detalhe calcado";
        janela = new JFrame(s);

        if (opc == 2){
            fieldNome = new JTextField(inferior.getiInferior(posi).getNome(), 200);
            fieldPreco = new JTextField(String.valueOf(inferior.getiInferior(posi).getPreco()), 200);
            fieldTamanho = new JTextField(String.valueOf(inferior.getiInferior(posi).getTamanho()), 200);
            fieldPorcentagemCash = new JTextField(String.valueOf(inferior.getiInferior(posi).getPorcentagem()), 200);
            fieldCor = new JTextField(inferior.getiInferior(posi).getCor(), 200);
            fieldEstoque = new JTextField(String.valueOf(inferior.getiInferior(posi).getEstoque()), 200);
            fieldTipo = new JTextField(String.valueOf(inferior.getiInferior(posi).getTipo()), 200);
            fieldMaterial = new JTextField(String.valueOf(inferior.getiInferior(posi).getMaterial()), 200);

        }else{
            fieldNome = new JTextField(200);
            fieldPreco = new JTextField(200);
            fieldTamanho = new JTextField(200);
            fieldPorcentagemCash = new JTextField(200);
            fieldCor = new JTextField(200);
            fieldEstoque = new JTextField(200);
            fieldTipo = new JTextField(200);
            fieldMaterial = new JTextField(200);
            botaoSalvar.setBounds(245, 250, 115, 30);
        }

        labelNome.setBounds(30, 20, 150, 25);
		fieldNome.setBounds(180, 20, 180, 25);
		labelPreco.setBounds(30, 50, 150, 25);
		fieldPreco.setBounds(180, 50, 180, 25);	
		labelTamanho.setBounds(30, 70, 150, 25);
		fieldTamanho.setBounds(180, 70, 180, 25);
        labelPorcentagemCash.setBounds(30, 100, 150, 25);
        fieldPorcentagemCash.setBounds(180, 100, 180, 25);
        labelCor.setBounds(30, 130, 150, 25);
        fieldCor.setBounds(180, 130, 180, 25);
        labelEstoque.setBounds(30, 160, 150, 25);
        fieldEstoque.setBounds(180, 160, 180, 25);
        labelTipo.setBounds(30, 190, 150, 25);
        fieldTipo.setBounds(180, 190, 180, 25);
        labelMaterial.setBounds(30, 220, 150, 25);
        fieldMaterial.setBounds(180, 220, 180, 25);

        
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
        this.janela.add(labelTipo);
		this.janela.add(fieldTipo);
        this.janela.add(labelMaterial);
		this.janela.add(fieldMaterial);

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
				System.out.println("OPC: "+ opc);
                novoDado[0] = Integer.toString(inferior.getQtdInferior());
				novoDado[1] = fieldNome.getText();
				novoDado[2] = fieldPreco.getText();
				novoDado[3] = fieldTamanho.getText();
				novoDado[4] = fieldPorcentagemCash.getText();
				novoDado[5] = fieldCor.getText();
                novoDado[6] = fieldEstoque.getText();
                novoDado[7] = fieldTipo.getText();
                novoDado[8] = fieldMaterial.getText();

                if(opc == 2){
                    res = inferior.editar(novoDado, posi);
                }else{
                    res = inferior.cadastro(novoDado);
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
				res = inferior.excluir(posi);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoInferior(); 
			
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

    public void mensagemErroExclusaoInferior() {
        JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n ", null, JOptionPane.ERROR_MESSAGE);
    }


}
