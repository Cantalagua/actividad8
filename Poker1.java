package poker1;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

    public void shuffle() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el deck");

    }

    public void showMenu() {
        Scanner myObj = new Scanner(System.in);

        Card pick;
        Card head;
        Deck deck = new Deck();
        boolean salir = false;
        System.out.println("¡Bienvenido a Poker!");
        while (!salir) {
            System.out.println("\nSeleccioa una opción \n 1.Mezclar deck \n 2.Sacar una carta \n 3.Carta al azar \n 4.Generar una mano de 5 cartas \n 0.Salir");
            String elec = myObj.nextLine();

            if (elec.equals("1")) {
                deck.shuffle();

            } else if (elec.equals("2")) {
                System.out.println("Carta head:");
                head = deck.head();
                System.out.println(head.toString());
                System.out.println(deck.restantes());
            } else if (elec.equals("3")) {
                System.out.println("Carta pick: ");
                pick = deck.pick();
                System.out.println(pick.toString());
                System.out.println(deck.restantes());
            } else if (elec.equals("4")) {
                System.out.println("Tu mano: ");
                for (int i = 0; i < 5; i++) {
                    pick = deck.pick();
                    System.out.println(pick.toString());
                }
                System.out.println(deck.restantes());
            } else if (elec.equals("0")) {
                salir = true;
            } else {
                System.out.println("Opción no válida");
            }

        }
    }
}

class CardProgram {

    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.showMenu();

    }

}
