package Views;

import Models.Game;

import java.util.Scanner;
import java.util.ArrayList;

public class StockMenu {

    Scanner myScanner = new Scanner(System.in);
    Game[] games = new Game[4];
    ArrayList<Game> gamesArray = new ArrayList<>();

    public static void main(String[] args) {
        StockMenu menu = new StockMenu();
        menu.initialise();

    }

    public void initialise() {
        games[0] = new Game("Starfield", 15, "Bathesda", "Sci/fi", 70, 0, 12);
        games[1] = new Game("Skyrim", 15, "Bathesda", "Fantasy", 20, 1, 50);
        games[2] = new Game("Minecraft", 7, "Microsoft", "Sandbox", 15, 2, 45);
        games[3] = new Game("Witcher 3", 15, "CD Projekt Red", "Fantasy", 30, 3, 7);
        getMenuChoice();
    }

    private void getMenuChoice() {
        System.out.println("Hello welcome to the stock menu");
        System.out.println("Please choose an option from below:");
        System.out.println("1: View Games List");
        System.out.println("2: Print all details");
        System.out.println("3: Amend the records menu");

        int input = Integer.parseInt(myScanner.nextLine());
        switch (input) {
            case 1:
                viewGames();
                break;
            case 2:
                viewExtraDetails();
                break;
            case 3:
                chooseRecord();
                amendRecordMenu();
                break;


        }
    }

    private void chooseRecord() {


    }

    private void amendRecordMenu() {
        System.out.println("Welcome the the Amend Details Menu:");
        System.out.println("Please choose an option from below:");
        System.out.println("1: Add a new item");
        System.out.println("2: Remove an existing item");
        System.out.println("3: Update an item");


        int input = Integer.parseInt(myScanner.nextLine());
        switch (input) {
            case 1:
               // addNewRecord();
                break;
            case 2:
                deleteRecord(input);
                break;
            case 3:
                //updateRecord();
                break;


        }
    }

    private void deleteRecord(int choice) {
        Game games = gamesArray.get(choice - 1);
    }


    private void viewExtraDetails() {
        System.out.println("The current games we have in stock are:");
        for (int i = 0; i < games.length; i++) {
            System.out.println("Title: " + games[i].title + ", Age Rating: " + games[i].ageRating + ", Publisher: " + games[i].publisher + ", Genre:  " +
                    games[i].genre + ", Price: ," + games[i].price + ", ID: " + games[i].gameID + ", Stock Level:  " + games[i].numInStock );
        }
    }

    private void viewGames() {
        System.out.println("The current games we have in stock are:");
        for (int i = 0; i < games.length; i++){
            System.out.println( games[i].title);
        }


    }
}

    
