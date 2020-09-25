package com.company.Main.BatalhaNaval;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Batalha_Naval {

    public static String tabuleiro[][] = new String[8][8];//cria um tabuleiro  8x8//
    public static int posicao[][] = new int[8][8];//posicoes dos barcos no tabuleiro//


    public static void zeraPosicao() {
        for (int l = 0; l < 8; l++) {//preenche as linhas com 0//
            for (int c = 0; c < 8; c++) {//preenche as colunas com 0//
                posicao[l][c] = 0;
            }
        }
    }


    //Posicao dos submarinos no tabuleiro//
    public static void posicaoDosSubmarinos() {

        //SUBMARINO 1//
        posicao[1][2] = 1;

        //SUBMARINO 2//
        posicao[1][0] = 1;

        //SUBMARINO 3//
        posicao[6][7] = 1;

        //SUBMARINO 4//
        posicao[4][6] = 1;

        //SUBMARINO 5//
        posicao[3][1] = 1;
    }

    //Posicao dos distroyers no tabuleiro//
    public static void posicaoDosDistroyers() {

        //DISTROYER 1//
        posicao[0][6] = 3;
        posicao[0][7] = 3;

        //DISTROYER 2//
        posicao[3][6] = 3;
        posicao[3][7] = 3;

        //DISTROYER 3//
        posicao[5][0] = 3;
        posicao[5][1] = 3;

        //DISTROYER 4//
        posicao[4][2] = 3;
        posicao[4][3] = 3;
    }

    //Posicao dos cruzadores no tabuleiro//
    public static void posicaoDosCruzadores() {

        //CRUZADOR 1//
        posicao[5][3] = 5;
        posicao[5][4] = 5;
        posicao[5][5] = 5;

        //CRUZADOR 2//
        posicao[1][5] = 5;
        posicao[1][6] = 5;
        posicao[1][7] = 5;

        //CRUZADOR 3//
        posicao[2][4] = 5;
        posicao[2][5] = 5;
        posicao[2][6] = 5;
    }

    //Posicao dos navios no tabuleiro//
    public static void posicaoDosNavios() {

        //NAVIO 1//
        posicao[0][0] = 7;
        posicao[0][1] = 7;
        posicao[0][2] = 7;
        posicao[0][3] = 7;

        //NAVIO 2//
        posicao[6][2] = 7;
        posicao[6][3] = 7;
        posicao[6][4] = 7;
        posicao[6][5] = 7;
    }

    // Posicao do Porta Aviao no tabuleiro//
    public static void posicaoDoPortaAviao() {

        //PORTA AVIAO//
        posicao[7][3] = 9;
        posicao[7][4] = 9;
        posicao[7][5] = 9;
        posicao[7][6] = 9;
        posicao[7][7] = 9;
    }


    public static int lerLinha() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int Linha = 0;
        try {
            System.out.println("Informe a linha que deseja atirar:");
            Linha = Integer.parseInt(entrada.readLine());
            if (Linha >= 0 && Linha <= 7) {
                return (Linha);
            } else {
                System.out.println("Linha invalida!!!");
                return (lerLinha());
            }
        } catch (Exception e) {
            System.out.println("Linha invalida!!!");
            return (lerLinha());
        }
    }

    public static int lerColuna() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int Coluna = 0;
        //int acert=14;
        try {
            System.out.println("Informe a coluna que deseja atirar ");
            Coluna = Integer.parseInt(entrada.readLine());
            if (Coluna >= 0 && Coluna <= 7) {
                return (Coluna);
            } else {
                System.out.println("Coluna invalida!!!");
                return (lerColuna());
            }
        } catch (Exception e) {
            System.out.println("Coluna invalida!!!");
            return (lerColuna());
        }


    }

    public static void inicilizaMatriz() {
        for (int l = 0; l < 8; l++) {//preenche as linhas com elementos de 0 a 7//
            for (int c = 0; c < 8; c++) {//preenche as colunas com elementos de 0 a 7//
                tabuleiro[l][c] = " ";
            }
        }
    }

    public static void imprimeTabuleiro() {
        System.out.println("    0   1   2   3   4   5   6   7"); //numero da coluna
        System.out.println("  _________________________________");
        for (int l = 0; l < 8; l++) {//preenche as linhas com elementos de 0 a 7//
            System.out.print(l + " ");   //numero da linhas do lado do tabuleiro
            for (int c = 0; c < 8; c++) {//preenche as colunas com elementos de 0 a 7//
                System.out.print("| " + tabuleiro[l][c] + " ");
            }
            System.out.println("|");
            System.out.println("  _________________________________");
        }
    }

    public static void verificaPosicao() {

        int submarino = 5;
        int distroyer = 8;
        int cruzador = 9;
        int navio = 8;
        int portaAvioes = 5;

        int controladora = 0;//usamos essa variável para controlar o loop.

        while (controladora == 0) {
            int lin = lerLinha();//aqui lê a linha
            int col = lerColuna();//aqui lê a coluna

            int escolha = posicao[lin][col];
            System.out.println(escolha);

            if (tabuleiro[lin][col] == " ") {//se vc ainda n escolheu essa posicao
                switch (escolha) {
                    case 0:
                        System.out.println("Você atirou na agua, tente novamente!!!");
                        tabuleiro[lin][col] = "X";
                        imprimeTabuleiro();
                        break;
                    case 1:
                        System.out.println("Você acertou um Submarino!!!");
                        tabuleiro[lin][col] = "1";
                        submarino--; //diminui uma unidade de submarino
                        imprimeTabuleiro();
                        break;
                    case 3:
                        System.out.println("Você acertou um Distroyer!!!");
                        tabuleiro[lin][col] = "3";
                        distroyer--; //diminui uma unidade de distroyer
                        imprimeTabuleiro();
                        break;
                    case 5:
                        System.out.println("Você acertou um Cruzador!!!");
                        tabuleiro[lin][col] = "5";
                        cruzador--; //diminui uma unidade de cruzador
                        imprimeTabuleiro();
                        break;
                    case 7:
                        System.out.println("Você acertou um Navio!!!");
                        tabuleiro[lin][col] = "7";
                        navio--; //diminui uma unidade de navio
                        imprimeTabuleiro();
                        break;
                    case 9:
                        System.out.println("Você acertou um Porta-avioes!!!");
                        tabuleiro[lin][col] = "90";
                        portaAvioes--; //diminui uma unidade de portaAvioes
                        imprimeTabuleiro();
                        break;
                }//fim do switch
            }//fim do primeiro if

            //Verificação de eliminação total
            if (submarino == 0 && distroyer == 0 && cruzador == 0 && navio == 0 && portaAvioes == 0) {
                controladora = 1;
            }


        }//fim do while
    }


    public static void main(String[] args) {
        int linha, coluna;

        //BufferedReader entrada;
        //entrada = new BufferedReader(new InputStreamReader(System.in));
        //METODOS QUE INICIALIZAM OS BARCOS//
        zeraPosicao();
        posicaoDosSubmarinos();
        posicaoDosDistroyers();
        posicaoDosCruzadores();
        posicaoDosNavios();
        posicaoDoPortaAviao();


        inicilizaMatriz();
        imprimeTabuleiro();



        verificaPosicao();
        //imprimeTabuleiro();
        System.out.println("Parabéns você venceu soldado!!!");

        //System.out.println(linha + " " + coluna);

    }


}