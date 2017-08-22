import java.util.LinkedList;

public class MaquinaDeTuring {
	
	//Uma maquina de turing tem um conjunto de estados
	LinkedList<State> states;
	String cadeia; //Cadeia que recebe -Talvez seja inútil esse atributo
	LinkedList listaDeCaracteres; //Ira modificar a cadeia que recebe por meio de uma linkedList para facilitar, onde cada elemento representa um caractere
	State estadoAtual; //A maquina de turing processa a cadeia de acordo com o estado atual em que ela esta operando
	int cabeca; //posica da cabeça na fita
	String caractereAtual; //Caractere atual que a maquina esta processando
	
	
	public MaquinaDeTuring(String cadeia){
		this.cadeia = cadeia;
		for(char i : cadeia.toCharArray()){
			listaDeCaracteres.add(i);
		}
		this.cabeca = 0;
		caractereAtual =  (String) this.listaDeCaracteres.get(0);
	}
	
	//Faz as modificacoes necessaria na listaDeCaracteres de acordo com o estado atual
	public void processa(){
		LinkedList<Transicao> transicoes = this.estadoAtual.getTransicoes(); //Transicoes do estado atual
		Transicao transicaoCorreta;
		//Acha a transicao correta para processar
		for (Transicao transicao : transicoes){
			//Acha a transicao que le o simbolo atual
			if (transicao.getSimboloAtual().equals(caractereAtual)){
				transicaoCorreta = transicao;
				break;
			}
		}
	}
	

	
}
