package controller;

import model.Cliente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import br.com.leandrocolevati.Lista.Lista;

public class ModificacaoCadastroController {
	
	public ModificacaoCadastroController() {
		super();
	}
	
	private void novoArquivo(Lista l, String nomeArquivo) throws IOException {
	}
	
	public void novoCadastro(int idadeMin, int idadeMax, double limiteCredito) throws IOException {
		Lista lClient = new Lista();
		File arq = new File("C:\\TEMP", "cadastro.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains(";")) {
					String[] vetLinha = linha.split(";");
					Cliente cliente = new Cliente();
					cliente.cpf = vetLinha[0];
					cliente.nome = vetLinha[1];
					cliente.idade = Integer.parseInt(vetLinha[2]);
					cliente.limiteCredito = Double.parseDouble(vetLinha[3]);
					if ((cliente.idade >= idadeMin && cliente.idade <= idadeMax) && cliente.limiteCredito >= limiteCredito) {
						lClient.addFirst(cliente);
					}
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leFluxo.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}
		String nomeArquivo = "idade" + idadeMin + " limite" + limiteCredito;
		novoArquivo(lClient, nomeArquivo);
	}

}
