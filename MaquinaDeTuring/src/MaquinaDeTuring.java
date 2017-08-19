import java.util.LinkedList;

public class MaquinaDeTuring {
	
	//Uma maquina de turing tem um conjunto de estados
	LinkedList<State> states;
	String cadeia; //Cadeia que recebe
	LinkedList listaDeCaracteres; //Ira modificar a cadeia que recebe por meio de uma linkedList para facilitar, onde cada elemento representa um caractere
	State estadoAtual; //A maquina de turing processa a cadeia de acordo com o estado atual
	
	public MaquinaDeTuring(String cadeia){
		this.cadeia = cadeia;
		for(char i : cadeia.toCharArray()){
			listaDeCaracteres.add(i);
		}
	}
	
}
