package Projeto;
public class Transicao {
	
	String estado; //Estado que a transicao pertence (que ela "sai").
	String simboloLido; //Simbolo que esta sendo lido
	String novoSimbolo; //Simbolo que sera escrito
	String direcao;  //Direcao que a cabeça vai anda (dir ou esquerda)
	State novoEstado; //Novo estado em que a transicao leva (pode ser o mesmo).
	
	public Transicao(String estado, String simboloLido, String novoSimbolo, String direcao, State novoEstado) {
		this.estado = estado;
		this.simboloLido = simboloLido;
		this.novoSimbolo = novoSimbolo;
		this.direcao = direcao;
		this.novoEstado = novoEstado;
	}

	public String getEstado() {
		return estado; //RETORNA O NOME DO ESTADO
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSimboloLido() {
		return simboloLido;
	}

	public void setSimboloLido(String simboloLido) {
		this.simboloLido = simboloLido;
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
