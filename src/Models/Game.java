package Models;

import java.util.ArrayList;

public class Game {

    public String title;
    public int ageRating;
    public String publisher;
    public String genre;
    public int price;
    public int gameID;
    public int numInStock;




    public Game(String title, int ageRating, String publisher, String genre, int price, int gameID, int numInStock) {
        this.title = title;
        this.ageRating = ageRating;
        this.publisher = publisher;
        this.genre = genre;
        this.price = price;
        this.gameID = gameID;
        this.numInStock = numInStock;
    }

}
