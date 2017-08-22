
public class Transicao {
	
	String estadoAtual; //Talvez nao precise, ja que a transicao compoe um State.
	String simboloAtual; //Simbolo que esta sendo lido
	String novoSimbolo; //Simbolo que sera escrito
	String direcao;  //Direcao que a cabeça vai anda (dir ou esquerda)
	State novoEstado; //Novo estado em que a maquina de Turing vai operar (pode ser o mesmo)
	
	public Transicao(String estadoAtual, String simboloAtual, String novoSimbolo, String direcao, State novoEstado) {
		this.estadoAtual = estadoAtual;
		this.simboloAtual = simboloAtual;
		this.novoSimbolo = novoSimbolo;
		this.direcao = direcao;
		this.novoEstado = novoEstado;
	}

	public String getEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(String estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

	public String getSimboloAtual() {
		return simboloAtual;
	}

	public void setSimboloAtual(String simboloAtual) {
		this.simboloAtual = simboloAtual;
	}

	public String getNovoSimbolo() {
		return novoSimbolo;
	}

	public void setNovoSimbolo(String novoSimbolo) {
		this.novoSimbolo = novoSimbolo;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public State getNovoEstado() {
		return novoEstado;
	}

	public void setNovoEstado(State novoEstado) {
		this.novoEstado = novoEstado;
	}
	
	

}
