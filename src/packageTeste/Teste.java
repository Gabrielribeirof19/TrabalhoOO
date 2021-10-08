package packageTeste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import controller.*;


class Teste {
	ControllerCliente cliente = new ControllerCliente();
	ControllerVendedor vendedor = new ControllerVendedor();
	ControllerVenda venda = new ControllerVenda();
	ControllerCalcado calcado = new ControllerCalcado();
	String[] dados = new String[11];
	String[] dadosCliente = new String[11];
	String[] dadosVendedor = new String[11];
	String[] dadosVenda = new String[11];
	 

	@Test
	void testCadastroCliente() {
		dadosCliente[1] = "Cliente";
	    dadosCliente[2] = "06732848159";
		dadosCliente[3] = "email@email.com";
		dadosCliente[4] = "061";
		dadosCliente[5] = "999999999";
		dadosCliente[6] = "End";
		dadosCliente[7] = "42942134";
		dadosCliente[8] = "End";
		dadosCliente[9] = "End";
		dadosCliente[10] = "4.";
		assertTrue(cliente.cadastro(dadosCliente));
	}
	
	@Test
	void testExcluirCliente() {
		dadosCliente[1] = "Cliente";
	    dadosCliente[2] = "06732848159";
		dadosCliente[3] = "email@email.com";
		dadosCliente[4] = "061";
		dadosCliente[5] = "999999999";
		dadosCliente[6] = "End";
		dadosCliente[7] = "42942134";
		dadosCliente[8] = "End";
		dadosCliente[9] = "End";
		dadosCliente[10] = "4.";
		
		cliente.cadastro(dadosCliente);
		
		assertTrue(cliente.excluir(0));
	}
	
	@Test
	void testCadastroVenda() {
		dados[1] = "Calcado";
		dados[2] = "23";
		dados[3] = "4";
		dados[4] = "5";
		dados[5] = "Azul";
		dados[6] = "1";
		dados[7] = "true";
		dados[8] = "true";
		calcado.cadastro(dados);

		dadosCliente[1] = "Cliente";
		dadosCliente[2] = "06732848159";
		dadosCliente[3] = "email@email.com";
		dadosCliente[4] = "061";
		dadosCliente[5] = "999999999";
		dadosCliente[6] = "End";
		dadosCliente[7] = "42942134";
		dadosCliente[8] = "End";
		dadosCliente[9] = "End";
		dadosCliente[10] = "4.";
		cliente.cadastro(dadosCliente);
		
		dados[1] = "Vendedor";
        dados[2] = "04582492399";
        dados[3] = "email@email.com";
        dados[4] = "061";
        dados[5] = "999999999";
        dados[6] = "1";
        dados[7] = "3";
        vendedor.cadastro(dados);
		
        dadosVenda[1] = "Cliente";
        dadosVenda[2] = "Calcado";
        dadosVenda[3] = "1";
        dadosVenda[4] = "4";
        assertTrue(venda.cadastro(dadosVenda, cliente, calcado, null, null, vendedor, null));
	}
}
