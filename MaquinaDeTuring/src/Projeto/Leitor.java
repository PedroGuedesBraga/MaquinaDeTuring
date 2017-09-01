package Projeto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Leitor {

	private String caminho;

	public Leitor(String caminho) {
		this.caminho = caminho;

	}

	public LinkedList<String[]> ler() {

		LinkedList<String[]> lista = new LinkedList<>();

		try {
			FileReader arq = new FileReader(caminho);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // lê a primeira linha

			while (linha != null) {
				if (!linha.isEmpty() && !linha.startsWith(";")) {
					lista.add(linha.split(" "));

				}

				linha = lerArq.readLine(); // lê da segunda até a última linha
			}

			arq.close();
			
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		return lista;
	}
}
