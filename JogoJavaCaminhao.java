package caminhao;

import java.util.Scanner;


//Implementar um jogo , com interface por console, em JAVA.
//O objetivo do jogo � fazer com que um caminhao, com tanque de TAM = 6 atravesse um caminho de tamanho 10.
//O jogador vai inserir comandos: avancar, voltar, carregar e descarregar.
//Avancar e voltar movem o caminhao uma posicao e gastam 1 combustivel.
//Carregar e descarregar alteram o combustivel do caminhao e do caminho.
//Na posicao 0, o combustivel disponivel e infinito.
//O jogo termina quando o caminhao chegar na ultima posicao do caminho, ou quanto acabar o combustivel no meio do caminho.


public class jogoCaminhao {
	int mapa [] = new int[10];
	int combustivel = 8;	
	int posicao = 0;

	public void avancar(){
		if((mapa[posicao]==0)&&(posicao!=0)&&(combustivel==0)){
			System.out.println("Voc� perdeu");
			System.exit(0);
		}
		else if((combustivel>0)&&(posicao>=0)){
			System.out.println("Voce avancou");
			posicao++;
			combustivel--;
		}
		else if(posicao==0){
			System.out.println("Voce reabasteceu completamente");
			combustivel = 6;
		}
		else if(posicao==9){
			System.out.println("Voce ganhou");
			System.exit(0);
		}
	}

	public void voltar(){
		if((mapa[posicao]==0)&&(posicao!=0)&&(combustivel==0)){
			System.out.println("Voc� perdeu");
			System.exit(0);
		}
		else if(posicao!=0){
			System.out.println("Voce voltou uma posicao");
			posicao--;
			combustivel--;
		}
		else if(mapa[posicao]==0){
			System.out.println("Voce reabasteceu completamente");
			combustivel = 6;
		}
	}

	public void carregar(){
		if(mapa[posicao]==0){
			System.out.println("Voce nao pode fazer isso, nao ha combustivel nessa parte do mapa");
		}
		else if(mapa[posicao]>0){
			mapa[posicao]--;
			combustivel++;
		}
	}

	public void descarregar(){
		if(mapa[posicao]>=6){
			System.out.println("A quantidade maxima de combustivel nessa parte do mapa foi atingida");
			mapa[posicao] = 6;
		}
		else if(mapa[posicao]<6){
			System.out.println("Voce deixou um combustivel nessa parte do mapa");
			mapa[posicao]++;
		}
	}

	public String checaStatus(){
		String check = "Posicao: "+posicao+
				"Combustivel: "+combustivel+
				"Combustivel na parte atual do mapa: "+mapa[posicao];
		return check;
	}
	public void terminaJogo(){
		if((mapa[posicao])!=0&&(combustivel==0)){
			System.out.println("Voc� perdeu");
			System.exit(0);
		}
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opcao = "";
		boolean infinito = true;
		jogoCaminhao truck = new jogoCaminhao();
		System.out.println("Voce esta em um deserto e o abrigo mais proximo esta a 10 milhas de distancia."+
				"\nNeste jogo voce pode avancar, voltar, carrega ( abastecer ), descarregar ( deixa um combustivel no mapa ) e checar"+
				"\nPara as regras, digite regras.\nBom jogo.");
		do{
			System.out.println("Voce pode avancar, voltar, carregar, descarregar e checar status(apenas digite checar ), para regras, digite regras.");
			opcao = sc.next();
			if(opcao.equals("avancar")){
				truck.avancar();
				
			}
			else if(opcao.equals("voltar")){
				truck.voltar();
			
			}
			else if(opcao.equals("carregar")){
				truck.carregar();
				
			}
			else if(opcao.equals("descarregar")){
				truck.descarregar();
				
			}		
			else if(opcao.equals("checar")){
				System.out.println(truck.checaStatus());
				
			}
			else if(opcao.equals("regras")){
				System.out.println("Apenas digite com letra minuscula.");
				
			}
		}while(infinito==true);
		sc.close();
	}
}
