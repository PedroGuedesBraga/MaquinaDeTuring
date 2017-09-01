package Projeto;
import java.util.LinkedList;

public class State {
	
	String name;
	LinkedList<Transicao> transicoes; //Cada estado tem um conjunto de transicoes
	boolean isFinal; //Se o estado e de acc ou rej
	
	public State(String name, boolean isFinal){
		this.name = name;
		this.transicoes = new LinkedList<Transicao>();
		this.isFinal = isFinal;
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
	
	//Sobrescrita do equals para usar no contains
	@Override
	public boolean equals(Object state){ //Dois estados sao iguais se tem o mesmo nome
		if(state instanceof State){
			return ((State) state).getName().equals(this.getName());
		}
		return false;
	}
	
	
	
	@Override
	public String toString() {
		return "State [name=" + name + ", transicoes=" + transicoes.toString() + ", isFinal=" + isFinal + "]";
	}

	public void addTransicao(Transicao transicao){
		this.getTransicoes().add(transicao);
	}
}
