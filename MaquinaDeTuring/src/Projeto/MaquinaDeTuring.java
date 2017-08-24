package Projeto;
import java.util.LinkedList;
import java.util.Set;

public class MaquinaDeTuring {
	
	//Uma maquina de turing tem um conjunto de estados - Set nao tem dois objetos iguais
	LinkedList<State> states;
	String cadeia; //Cadeia que recebe -Talvez seja inútil esse atributo
	LinkedList<String> listaDeCaracteres; //FITA - Ira modificar a cadeia que recebe por meio de uma linkedList para facilitar, onde cada elemento representa um caractere
	State estadoAtual; //A maquina de turing processa a cadeia de acordo com o estado atual em que ela esta operando
	int cabeca; //posica da cabeça na fita
	String caractereAtual; //Caractere atual que a maquina esta processando
	
	
	public MaquinaDeTuring(String caminho){ //Construtor inicializa a maquina
		this.buildMaquinaDeTuring(caminho);
		
	}
	
	
	
	//Faz as modificacoes necessaria na listaDeCaracteres de acordo com o estado atual
	public void processa(String cadeia){
		this.cadeia = cadeia;
		for(char i : cadeia.toCharArray()){
			listaDeCaracteres.add(Character.toString(i));
		}
		caractereAtual =  (String) this.listaDeCaracteres.get(0);
			
	}
	
	//roda a maquina com uma cadeia - chamado dentro do processa
	//*VER COMO TRATAR O CARACTERE BRANCO NA LINKEDLIST
	private void run(){
		//Enquanto nao estiver em um estado de aceitacao ou rejeicao, a maquina continua rodando
		while(estadoAtual.getName().split("-")[0] != "halt"){
			
			for(Transicao transicao : estadoAtual.getTransicoes()){
				if(transicao.getSimboloLido().equals(this.caractereAtual) || transicao.getSimboloLido().equals("*")){ //"*" Em simboloLido significa: Qualquer simbola
					if(transicao.getNovoSimbolo().equals("*")){
					//"*" em novoSimbolo, significa "no change"
					}else{
						this.listaDeCaracteres.set(cabeca, transicao.getNovoSimbolo());
					}
					if(transicao.getDirecao().equalsIgnoreCase("r")){
						cabeca++;
					}else{
						cabeca--;
					}
					if(!transicao.getNovoEstado().equals("*")){
						estadoAtual = transicao.novoEstado;
					}
					break; //Pois senao pode continuar o for para as transicoes no novo estado atualizado
				}
			}
		}
	}
	
	
	public void buildMaquinaDeTuring(String caminho){
		Leitor leitor = new Leitor(caminho);
		LinkedList<String[]> infoComponentes = leitor.ler(); //Informacoes necessarias para criar a maquina
		//Cria os estados
		for(String[] array : infoComponentes){
			String nomeDoEstado = array[0];
			State novoEstado = new State(nomeDoEstado);
			this.states.add(novoEstado);
		}
		//Cria as transicoes e adiciona elas aos seus respectivos estados
		for(String[] array : infoComponentes){
			Transicao novaTransicao = new Transicao(array[0], array[1], array[2], array[3], pesquisaEstadoPorNome(array[4]));
			ligaTransicaoAoEstado(novaTransicao);
		}
		this.estadoAtual = states.get(0);
		this.cabeca = 0;
		
		
		
			
	}
	
	
	//Metodo que recebe uma transicao e a liga com o estado em que ela "sai"
	private void ligaTransicaoAoEstado(Transicao transicao){
		for(State estado : this.states){
			if(transicao.getEstado().equals(estado)){
				estado.getTransicoes().add(transicao);
			}
		}
	}
	
	//Pesquisa estado por nome na MT.
	private State pesquisaEstadoPorNome(String name){
		for(State estado : this.states){
			if(estado.getName().equals(name)){
				return estado;
			}
		}
		return null;
	}

	
}
