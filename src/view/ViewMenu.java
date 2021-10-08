package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.*;

/**
 * Apresentar o menu na tela para o usuário
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 202)
 */
public class ViewMenu implements ActionListener {
	
	private static JFrame janela = new JFrame("Loja De Roupas");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton calcado = new JButton("Calçado");
	private static JButton camiseta = new JButton("Camiseta");
	private static JButton casaco = new JButton("Casaco");
	private static JButton inferior = new JButton("Inferior");
	private static JButton cliente = new JButton("Clientes");
	private static JButton vendedor = new JButton("Vendedores");
	private static JButton venda = new JButton("Vendas");
	private static JButton exit = new JButton("Sair");
    public static ControllerCalcado calcadoC = new ControllerCalcado();
    public static ControllerCamiseta camisetaC = new ControllerCamiseta();
    public static ControllerCasaco casacoC = new ControllerCasaco();
    public static ControllerInferior inferiorI = new ControllerInferior();
    public static ControllerCliente clienteC = new ControllerCliente();
    public static ControllerVendedor vendedorV = new ControllerVendedor();
    public static ControllerVenda vendaV = new ControllerVenda();
	public int [] flag1 = new int[1];
	public int [] flag2 = new int[1];
	public int [] flag3 = new int[1];
	public int [] flag4 = new int[1];
	public int [] flag5 = new int[1];
	public int [] flag6 = new int[1];


	public ViewMenu() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(220, 10, 180, 30);
		calcado.setBounds(140, 100, 120, 30);
		camiseta.setBounds(140, 150, 120, 30);
		casaco.setBounds(140, 200, 120, 30);
		inferior.setBounds(140, 250, 120, 30);
		cliente.setBounds(340, 100, 120, 30);
		vendedor.setBounds(340, 150, 120, 30);
		venda.setBounds(340, 200, 120, 30);
		exit.setBounds(340, 250, 120, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(calcado);
		janela.add(camiseta);
		janela.add(casaco);
		janela.add(inferior);
		janela.add(cliente);
		janela.add(vendedor);
		janela.add(venda);
		janela.add(exit);
		
		janela.setSize(600, 400);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		ViewMenu menu = new ViewMenu();
		
		calcado.addActionListener(menu);
		camiseta.addActionListener(menu);
		casaco.addActionListener(menu);
		inferior.addActionListener(menu);
		cliente.addActionListener(menu);
		vendedor.addActionListener(menu);
		venda.addActionListener(menu);
		exit.addActionListener(menu);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
		
		if(src == calcado)
			new ViewCalcado().mostrarDados(calcadoC, flag1);
		
		if(src == camiseta)
			new ViewCamiseta().mostrarDados(camisetaC, flag2);
		
		if(src == casaco)
			new ViewCasaco().mostrarDados(casacoC, flag3);
		
		if(src == inferior)
			new ViewInferior().mostrarDados(inferiorI, flag4);
		
		if(src == cliente)
			new ViewCliente().mostrarDados(clienteC, flag5);
		
		if(src == vendedor)
			new ViewVendedor().mostrarDados(vendedorV, flag6);
		
		if(src == venda)
			new ViewVenda().mostrarDados(vendaV);
		
		if(src == exit)
			 System.exit(0);
		
	}

}