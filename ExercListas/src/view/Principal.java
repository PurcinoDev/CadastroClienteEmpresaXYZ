package view;

import controller.ModificacaoCadastroController;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		ModificacaoCadastroController modifiCadastro = new ModificacaoCadastroController();
		
		String caminho = "C:\\TEMP";
		String arquivo = "cadastro.csv";
		modifiCadastro.novoCadastro(caminho, arquivo, 41, 60, 8000.0);
		modifiCadastro.novoCadastro(caminho, arquivo, 31, 40, 5000.0);
		modifiCadastro.novoCadastro(caminho, arquivo, 21, 30, 3000.0);
		}
		
	}