
public class Transicao {
	
	String estadoAtual; //Talvez nao precise, ja que a transicao compoe um State.
	char simboloAtual; //Simbolo que esta sendo lido
	char novoSimbolo; //Simbolo que sera escrito
	String direcao;  //Direcao que a cabeça vai anda (dir ou esquerda)
	State novoEstado; //Novo estado em que a maquina de Turing vai operar (pode ser o mesmo)
	
	public Transicao(String estadoAtual, char simboloAtual, char novoSimbolo, String direcao, State novoEstado) {
		this.estadoAtual = estadoAtual;
		this.simboloAtual = simboloAtual;
		this.novoSimbolo = novoSimbolo;
		this.direcao = direcao;
		this.novoEstado = novoEstado;
	}
	
	

}
