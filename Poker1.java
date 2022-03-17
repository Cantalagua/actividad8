package poker1;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

class Card {

    private int tipo, valor, color;
    private String[] cardTipo = {"Tréboles", "Corazones", "Diamantes", "Corazones"};
    private String[] cardValor = {"As", "Rey", "Reina", "J", "10",
        "9", "8", "7", "6", "5", "4", "3", "2"};
    private String[] cardColor = {"Rojo", "Negro"};

    public Card(int tipos, int valores, int colores) {
        tipo = tipos;
        valor = valores;
        color = colores;
    }

    public String toString() {
        String cartaFinal = cardValor[valor] + " " + cardColor[color] + " de " + cardTipo[tipo];

        return cartaFinal;
    }

}

class Deck {

    private ArrayList<Card> cartas;

    public Deck() {
        cartas = new ArrayList<Card>();

        for (int a = 0; a <= 3; a++) {
            for (int c = 0; c < 2; c++) {
                for (int b = 0; b <= 12; b++) {
                    if (cartas.size() < 52) {
                        cartas.add(new Card(a, b, c));
                    }
                }
            }
        }
    }

    public Card pick() {
        Random rdm = new Random();
        int index = rdm.nextInt(cartas.size());
        return cartas.remove(index);
    }

    public Card head() {
        return cartas.remove(1);
    }

    public String restantes() {
        String result = "Cartas restantes: " + cartas.size();

        return result;

    }

    public String shuffle() {
        Collections.shuffle(cartas);
        String resultado = "Se mezcló el deck";

        return resultado;

    }

}

class CardProgram {

    public static void main(String[] args) {
        Card pick;
        Card head;
        Deck deck = new Deck();

        System.out.println(deck.shuffle());

        System.out.println("Carta head:");
        head = deck.head();
        System.out.println(head.toString());
        System.out.println(deck.restantes());

        System.out.println("Carta pick: ");
        pick = deck.pick();
        System.out.println(pick.toString());
        System.out.println(deck.restantes());

        System.out.println("Tu mano: ");
        for (int i = 0; i < 5; i++) {
            pick = deck.pick();
            System.out.println(pick.toString());

        }
        System.out.println(deck.restantes());

    }

}
