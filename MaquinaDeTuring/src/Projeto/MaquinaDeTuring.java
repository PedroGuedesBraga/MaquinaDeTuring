package Projeto;

import java.util.LinkedList;
import java.util.Set;
import java.util.TimerTask;

public class MaquinaDeTuring {

	// Uma maquina de turing tem um conjunto de estados - Set nao tem dois
	// objetos iguais
	LinkedList<State> states;
	public LinkedList<String> listaDeCaracteres;
	public State estadoAtual;
	public String TransicaoAtual = "";
	public String caminho = "";
	
	int cabeca; // posica da cabeça na fita

	public int getCabeca() {
		return cabeca;
	}

	public String getFita() {
		String fita = "";
		for (String s : listaDeCaracteres) {
			fita += s;
		}
		return fita.replace("_", " ");
	}

	String caractereAtual; // Caractere atual que a maquina esta processando

	boolean end = false;

	public MaquinaDeTuring(String caminho) { // Construtor inicializa a maquina
		this.listaDeCaracteres = new LinkedList<String>();
		this.states = new LinkedList<State>();
		this.caminho = caminho;
		this.buildMaquinaDeTuring(caminho);

	}

	// LEMBRAR DE TIRAR OS COMENTÁRIOS!!!!!!!!!!!!!!

	// Faz as modificacoes necessaria na listaDeCaracteres de acordo com o
	// estado atual
	public void processa(String palavra) {
		for (char i : palavra.toCharArray()) {
			listaDeCaracteres.add(Character.toString(i));
		}
		caractereAtual = (String) this.listaDeCaracteres.get(0);
		// Insere o caractere "_" no começo e no final
		this.cabeca = 1;
		this.listaDeCaracteres.addFirst("_");
		this.listaDeCaracteres.addLast("_");


	}

	public boolean step() {
		for (Transicao transicao : estadoAtual.getTransicoes()) {
			if (transicao.getSimboloLido().equals(this.caractereAtual) || transicao.getSimboloLido().equals("*")) {
				//this.TransicaoAtual = transicao.toString();				
				//System.out.println(TransicaoAtual);
				
				if (transicao.getNovoSimbolo().equals("*")) {

				} else {
					this.listaDeCaracteres.set(cabeca, transicao.getNovoSimbolo());
					this.listaDeCaracteres.addFirst("_");
					this.cabeca++;

					if (!this.listaDeCaracteres.getLast().equals("_")) {
						this.listaDeCaracteres.addLast("_");
					}
				}

				if (transicao.getDirecao().equalsIgnoreCase("r")) {
					cabeca++;
				} else if (transicao.getDirecao().equals("l")) {
					cabeca--;
				}

				if (this.cabeca == this.listaDeCaracteres.size() - 1) {
					this.listaDeCaracteres.addLast("_");
				} else if (this.cabeca == 0) {
					this.listaDeCaracteres.addFirst("_");
					this.cabeca++;
				}

				this.caractereAtual = this.listaDeCaracteres.get(cabeca);
				if (!transicao.getNovoEstado().getName().equals("*")) {
					estadoAtual = transicao.novoEstado;
				}
				break;
			}
		}
		return isFinalState(estadoAtual);
	}

	public void buildMaquinaDeTuring(String caminho) {
		Leitor leitor = new Leitor(caminho);
		LinkedList<String[]> infoComponentes = leitor.ler(); 

		// Cria os estados
		for (String[] array : infoComponentes) {
			String nomeDoEstado = array[0];
			State novoEstado = new State(nomeDoEstado, false);

			if (!this.states.contains(novoEstado)) {
				this.states.add(novoEstado);
			}
		}
		// Cria as transicoes e adiciona elas aos seus respectivos estados
		for (String[] array : infoComponentes) {
			Transicao novaTransicao = new Transicao(array[0], array[1], array[2], array[3],
					pesquisaEstadoPorNome(array[4]));
			ligaTransicaoAoEstado(novaTransicao);
		}
		this.estadoAtual = states.get(0);
		//System.out.println(estadoAtual.transicoes);
	}

	// Metodo que recebe uma transicao e a liga com o estado em que ela "sai"
	private void ligaTransicaoAoEstado(Transicao transicao) {
		State estadoQueATransicaoSai = this.pesquisaEstadoPorNome(transicao.getEstado());
		for (State estado : this.states) {
			if (estadoQueATransicaoSai.equals(estado)) { // Transicao.getEstado
															// RETORNA UMA
															// STRING - ATENCAO!
				if (transicao.simboloLido.equals("*")) {
					estado.getTransicoes().addLast(transicao);
				} else {
					estado.getTransicoes().addFirst(transicao);
				}

			}
		}
	}

	// Pesquisa estado por nome na MT.
	private State pesquisaEstadoPorNome(String name) {
		for (State estado : this.states) {
			if (estado.getName().equals(name)) {
				return estado;
			}
		}
		// Se nao encontrou, e porque esta indo para o estado final
		return new State(name, true);
	}

	// diz se o estado e um estado final
	private boolean isFinalState(State state) {
		return state.isFinal;
	}

}
