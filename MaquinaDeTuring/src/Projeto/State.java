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
	
	//Sobrescrita do equals para usar no contains
	@Override
	public boolean equals(Object state){ //Dois estados sao iguais se tem o mesmo nome
		if(state instanceof State){
			return ((State) state).getName().equals(this.getName());
		}
		return false;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
	public void addTransicao(Transicao transicao){
		this.getTransicoes().add(transicao);
	}
	
	

	

}
