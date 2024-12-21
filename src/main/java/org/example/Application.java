package org.example;

import java.util.Scanner;

public class Application {
    private final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        System.out.println("Bienvenue dans l'application de calculatrice !");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            System.out.print("Entrez le symbole de votre choix : ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("q")) {
                System.out.println("Merci d'avoir utilisé la calculatrice. Au revoir !");
                break;
            }

            try {
                Operation operation = Operation.fromSymbol(choice);
                double num1 = getNumber(scanner, "Entrez le premier nombre : ");
                double num2 = getNumber(scanner, "Entrez le deuxième nombre : ");
                double result = performOperation(operation, num1, num2);
                System.out.println("Le résultat de " + operation.getDescription() + " est : " + result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private void showMenu() {
        System.out.println("\nSélectionnez une opération :");
        for (Operation op : Operation.values()) {
            System.out.println(" " + op.getSymbol() + " - " + op.getDescription());
        }
        System.out.println(" Q - Quitter");
    }

    private double getNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer une valeur numérique.");
            }
        }
    }

    private double performOperation(Operation operation, double num1, double num2) {
        return switch (operation) {
            case ADD -> calculator.add(num1, num2);
            case SUBTRACT -> calculator.sub(num1, num2);
            case MULTIPLY -> calculator.mul(num1, num2);
            case DIVIDE -> calculator.div(num1, num2);
            default -> throw new IllegalStateException("Valeur inattendue : " + operation);
        };
    }
}
