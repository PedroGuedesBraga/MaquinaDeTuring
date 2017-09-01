package Projeto;

public class TesteMT {

	static String path = "C:/Users/Angélica/git/MaquinaDeTuring/MaquinaDeTuring/src/testes/";

	public TesteMT() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		t1();
		t2();
		t3();
		t4();
		t5();
		t6();

	}

	private static void t1() {
		MaquinaDeTuring mt = new MaquinaDeTuring(path + "parentesesChecker.txt");
		mt.processa("12(2+(3^(4-1)))");
		System.out.println("Teste parentesesChecker.txt");
		System.out.println(mt.estadoAtual);
	}

	private static void t2() {
		MaquinaDeTuring mt = new MaquinaDeTuring(path + "soma_Binaria.txt");
		mt.processa("110110_101011");
		System.out.println("Teste soma_Binaria.txt");
		System.out.println(mt.estadoAtual);
	}

	private static void t3() {
		MaquinaDeTuring mt = new MaquinaDeTuring(path + "binarioToDecimal.txt");
		mt.processa("10110");
		System.out.println("Teste binarioToDecimal.txt");
		System.out.println(mt.estadoAtual);
	}

	private static void t4() {
		MaquinaDeTuring mt = new MaquinaDeTuring(path + "arquivoPalindromo.txt");
		mt.processa("1001001");
		System.out.println("Teste arquivoPalindromo.txt");
		System.out.println(mt.estadoAtual);
	}

	private static void t5() {
		MaquinaDeTuring mt = new MaquinaDeTuring(path + "Universal.txt");
		mt.processa("[_L+,0R.,1R.!1L+,1L+,0L.:,0L.,1L.:]1011");
		System.out.println("Teste Universal.txt");
		System.out.println(mt.estadoAtual);
	}

	private static void t6() {
		MaquinaDeTuring mt = new MaquinaDeTuring(path + "Prime.txt");
		mt.processa("101");
		System.out.println("Teste Prime.txt");
		System.out.println(mt.estadoAtual);
	}

}
