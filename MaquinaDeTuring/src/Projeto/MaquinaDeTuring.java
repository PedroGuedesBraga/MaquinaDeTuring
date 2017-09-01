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
		// this.run();
		// step();

	}

	public void run() {
		boolean end = false;
		while (!end) {
			end = step();

		}
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

	// roda a maquina com uma cadeia - chamado dentro do processa
	// *VER COMO TRATAR O CARACTERE BRANCO NA LINKEDLIST
	private void arun() {
		// Enquanto nao estiver em um estado de aceitacao ou rejeicao, a maquina
		// continua rodando - Estados de act/rej comecam com "halt"

		while (!isFinalState(estadoAtual)) { // Enquanto nao chegar nos estados
												// de acc e rej, a MT roda
			// System.out.println(this.listaDeCaracteres.toString() + " & " +
			// this.estadoAtual+ " >> " + this.cabeca);
			for (Transicao transicao : estadoAtual.getTransicoes()) {

				if (transicao.getSimboloLido().equals(this.caractereAtual) || transicao.getSimboloLido().equals("*")) {
					if (transicao.getNovoSimbolo().equals("*")) {

					} else {
						this.listaDeCaracteres.set(cabeca, transicao.getNovoSimbolo());
						// (1a Verificacao) Verifica se escreveu na ultima ou
						// primeira posicao, se sim, adicionar "_" branco em uma
						// das pontas (Abordagem da fita "infinita para os 2
						// lados"
						if (!this.listaDeCaracteres.getFirst().equals("_")) {
							this.listaDeCaracteres.addFirst("_");
							this.cabeca++; // Se adicionar um branco na frente,
											// o valor da cabeca altera
						}
						if (!this.listaDeCaracteres.getLast().equals("_")) {
							this.listaDeCaracteres.addLast("_");
						}
					}
					if (transicao.getDirecao().equalsIgnoreCase("r")) {
						cabeca++;
					} else if (transicao.getDirecao().equals("*")) {
						// Se a direcao for *, nao se move
					} else {
						cabeca--;
					}
					// (2a verificacao) Se a cabeca estiver nas extremidades e
					// quiser se mover "2+ casas" longe da cadeia/slots ocupados
					// Ex.: A cabeca esta na ponta (branco), mas se quer mover a
					// cabeça mais para longe ainda dos slots ocupados. Ou seja,
					// a kbc esta na ponta e a ponta é branco
					if (this.cabeca == this.listaDeCaracteres.size() - 1) {
						this.listaDeCaracteres.addLast("_");
					} else if (this.cabeca == 0) {
						this.listaDeCaracteres.addFirst("_");
						this.cabeca++; // Quando e adicionado branco na frente,
										// o valor da cabeca aumenta
					}

					// Atualiza o caractere atual
					this.caractereAtual = this.listaDeCaracteres.get(cabeca);
					if (!transicao.getNovoEstado().getName().equals("*")) {
						estadoAtual = transicao.novoEstado;
					}
					break; // Pois senao pode continuar o for para as transicoes
							// no novo estado atualizado
				}
			}
		}
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
