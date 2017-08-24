package Projeto;
import java.util.LinkedList;

public class State {
	
	String name;
	LinkedList<Transicao> transicoes; //Cada estado tem um conjunto de transicoes
	
	public State(String name){
		this.name = name;
		this.transicoes = new LinkedList<Transicao>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Transicao> getTransicoes() {
		return transicoes;
	}

	public void setTransicoes(LinkedList<Transicao> transicoes) {
		this.transicoes = transicoes;
	}
	
	

	

}