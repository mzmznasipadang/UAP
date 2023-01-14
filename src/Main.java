
/*
 * Copyright (c) 2023. Victor Chandra - 2602223386 - BO11
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //Setting up Scanner
    Scanner scan = new Scanner(System.in);
    //Array List using OOP to Coffee.Java
    ArrayList<Coffee> coffeeList = new ArrayList<Coffee>();

    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        int choice = 0;
        //4 menu, 1 Add New Coffee, 2. View All Coffee, 3. Remove Coffee, 4. Exit
        //eLKabucks Coffee
        //Welcome to eLKabucks
        do {
            System.out.println("Welcome to eLKabucks Coffee");
            System.out.println("1. Add New Coffee");
            System.out.println("2. View All Coffee");
            System.out.println("3. Remove Coffee");
            System.out.println("4. Exit");
            System.out.print(">>");

            choice = scan.nextInt();
            scan.nextLine();
            if(choice == 1)
                CreateNew();
            else if (choice == 2)
                ViewCoffee();
            else if (choice == 3)
                DeleteCoffee();
            else if (choice == 4)
                System.out.println("Thank you for using EeLkabucks Application");
            System.out.println("eLKabucks uses the highest quality arabica coffee as the base for its beloved drinks");
            System.out.println("Learn about our unique coffee makers and cold brew coffee today.");
            System.out.println("Created and loved by NP (Victor Chandra) - 2602223386");
        }while(choice !=4);
    }

    //Coffee Name (5..30 char, inclusive, atleast 2 words
    //Coffee Category, Latte, Espresso, Macchiato (Case Sensitive)
    //Coffee Price (Between 1000 to 100000), inclusive, must be numeric?
    // Random Generated Coffee ID, XX YYY (X -> A to Z), (Y -> 0 to 9).

    //Coffee List
    private void CreateNew(){
        String name, flavor;
        int price;

        do{
            System.out.println("\n Input Coffee Name [5...30 & min. 2 words : ");
            name = scan.nextLine();
            if(!name.contains(" ")){
                System.out.println("Name must be more than 2 words!");
            }}while(!name.contains(" ") || name.endsWith(" ") || !(name.length() > 5) || !(name.length() < 30));

            do{
                System.out.println("Input Coffee Category [Latte | Espresso | Macchiato (Case Sensitive)] : ");
                flavor = scan.nextLine();
                if(!flavor.equals("Latte") && !flavor.equals("Espresso") && !flavor.equals("Macchiato"))
                    System.out.println("Choose from the Coffee Category Provided!");
            }while(!(flavor.equals("Latte") || flavor.equals("Espresso") || flavor.equals("Macchiato")));


            do{
                System.out.println("Input Coffee Price [Min. 1.000, Max. 100000] : ");
                price = scan.nextInt();
                scan.nextLine();
                if(price < 1000 || price > 100000){
                    System.out.println("Coffee Price needs to be between 1000 to 100000");
                }
                }while(price < 1000 || price > 100000);

                Random rand = new Random();
                String ID = String.format("%c%c%d%d%d", (char)(rand.nextInt('Z' - 'A') + 'A'), (char)(rand.nextInt('Z' - 'A') + 'A'),
                        rand.nextInt(9), rand.nextInt(9), rand.nextInt(9));
                System.out.println("Coffee Added Successfully!");
                coffeeList.add(new Coffee(name, flavor, price, ID));

        }

    //Algo Coffee List Empty
    private void ViewCoffee() {
        if (coffeeList.isEmpty())
            System.out.println("There is no Coffee Data!");
        else {
            int choice;
            do {
                showAll();

                System.out.println("1. Back to Main Menu");
                choice = scan.nextInt();
                        scan.nextLine();
                if (choice == 1)
                    break;
            }while (choice !=1);
        }

    }

    private void showAll() {

        sorting();
        System.out.println("============================================================================");
        System.out.printf("|ID| %-8s | %-15s | %-7s | %-7s |\n", "ID", "Name", "Flavor","Price");
        System.out.println("============================================================================");

        for(int i = 0; i < coffeeList.size() ; i++){
            System.out.printf("| %d | %-8s | %-15s | %-7s | %-7s |\n", i+1, coffeeList.get(i).getID(),coffeeList.get(i).getName(),
                    coffeeList.get(i).getFlavor(), coffeeList.get(i).getPrice());
            System.out.println("============================================================================");
        }
        //ITS WORKINGGGGGGG AAAAAAAAA SO HAPPPYYYYYYYYYY
    }
    // now onto Sorting
    private void sorting() {
        for (int i = 0; i < coffeeList.size(); i++){
            for(int j = 0; j < coffeeList.size() - i - 1; i++){
                if (coffeeList.get(i).getName().compareTo(coffeeList.get(j+1).getName()) > 0){
                    Coffee temp = coffeeList.get(j);
                    coffeeList.set(j, coffeeList.get(j+1));
                    coffeeList.set(j+1, temp);
                }
            }
        }
    }
    //Remove Coffee (Deletion / Update?)
    private void DeleteCoffee(){
        showAll();

        int choice;
        do {
            System.out.printf("Choose Coffee to delete [1 - %d] : ", coffeeList.size());
            choice = scan.nextInt();
            scan.nextLine();
        }while(choice < 1 || choice > coffeeList.size());
        coffeeList.remove(choice-1);
        System.out.println("Successfully Removed Coffee!");
    }
}


