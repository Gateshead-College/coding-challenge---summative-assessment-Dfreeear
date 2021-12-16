package Views;

import Models.Employee;
import Models.Game;

import java.util.Scanner;
import java.util.ArrayList;

public class StockMenu {

    Scanner myScanner = new Scanner(System.in);
    ArrayList<Game> gamesArray = new ArrayList<>();
    ArrayList<Employee> employeeArray = new ArrayList<>();
    boolean currentAdmin;

    public static void main(String[] args) {
        StockMenu menu = new StockMenu();
        menu.initialise();
        menu.initialise2();
        menu.login();

    }

    private void login() {
        System.out.println("____________________________________");
        System.out.println("Hello, what is your username?");
        String username = new Scanner(System.in).nextLine();
        System.out.println("What is your password?");
        String password = new Scanner(System.in).nextLine();
        for (Employee e : employeeArray) {
            if (e.getUsername().equalsIgnoreCase(username) && e.getPassword().equals(password)) {
                {
                    if (e.getIsAdmin()) {
                        mainMenuChoice();
                    } else {
                        nonAdminMenu();
                    }

                }
            }
            if (!e.getUsername().equalsIgnoreCase(username) && !e.getPassword().equals(password)) {
                System.out.println("xxxxxxxxxxxxxxxxxxxx");
                System.out.println("That username or password is incorrect");
                System.out.println("Please try again");
                login();
            }

        }
    }

    private void logout() {
        System.out.println("logging out...");
    }

    public void initialise() {
        gamesArray.add(new Game("Starfield", 15, "Bathesda", "Sci/fi", 70, 0, 12));
        gamesArray.add(new Game("Skyrim", 15, "Bathesda", "Fantasy", 20, 1, 50));
        gamesArray.add(new Game("Minecraft", 7, "Microsoft", "Sandbox", 15, 2, 45));
        gamesArray.add(new Game("Witcher 3", 15, "CD Projekt Red", "Fantasy", 30, 3, 7));
    }

    public void initialise2() {
        employeeArray.add(new Employee("Dan", "Freear", "dfr", "123", 1, true));
        employeeArray.add(new Employee("Andrew", "Tudor", "ant", "123", 2, false));
        employeeArray.add(new Employee("Hannah", "Leightell", "Hal", "123", 3, false));
    }

    private void mainMenuChoice() {
        System.out.println("_______________________________________");
        System.out.println("Hello welcome to the D3 Gaming menu");
        System.out.println("Please choose from the following:");
        System.out.println("1: Game info and stock");
        System.out.println("2: Employee info");
        System.out.println("_________________________________________");

        int input = Integer.parseInt(myScanner.nextLine());
        switch (input) {
            case 1:
                getMenuChoice();
                break;
            case 2:
                getEmployeeMenuChoice();
                break;
        }
    }

    private void nonAdminMenu() {
        System.out.println("_________________________________________");
        System.out.println("Hello, welcome to the non admin menu");
        System.out.println("Please choose from the following:");
        System.out.println("1: View Games and stock");
        System.out.println("2: View employee info");
        System.out.println("3: amend employee info");
        System.out.println("4: Back to login page - you will be logged out!");
        System.out.println("_________________________________________");
        int input = Integer.parseInt(myScanner.nextLine());
        switch (input) {
            case 1:
                viewGames();
                break;
            case 2:
                viewEmployees();
                break;
            case 3:
                System.out.println("You do not have admin access to edt info, please speak to your manager");
                System.out.println("Would you like to go back to the menu?");
                if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
                    nonAdminMenu();
                } else {
                    System.out.println("Logging out...");
                    login();
                    break;
                }
            case 4:
                logout();
                break;
        }

    }

    private void viewEmployees() {
        if (!employeeArray.isEmpty()) {
            int x = 1;
            System.out.println("Here are all our current staff: ");
            for (Employee input : employeeArray) {
                System.out.println(x + "-" + input.getForename() + "" + input.getSurname() + ", Service Level: " + input.getService());
                x++;
            }
            System.out.println("Would you like to go back to main menu and edit any details?");
            if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
                mainMenuChoice();
            } else {
                System.out.println("Exiting....");
            }

        }
    }


    private void getEmployeeMenuChoice() {
        System.out.println("_________________________________________");
        System.out.println("Hello welcome to the employee menu");
        System.out.println("Please choose an option from below:");
        System.out.println("1: View employees List");
        System.out.println("2: Amend the employee records menu");
        System.out.println("3: Back");
        System.out.println("_________________________________________");
        int input = Integer.parseInt(myScanner.nextLine());
        switch (input) {
            case 1:
                viewEmployeesAdmin();
                break;
            case 2:
                amendEmployeeRecordMenu();
                break;
            case 3:
                mainMenuChoice();
                break;
        }

    }

    private void amendEmployeeRecordMenu() {
        System.out.println("_________________________________________");
        System.out.println("Welcome the the Employee Amend Details Menu:");
        System.out.println("Please choose an option from below:");
        System.out.println("1: Add a new employee");
        System.out.println("2: Remove an existing employee");
        System.out.println("3: Update an employees details");
        System.out.println("4: Go back");
        System.out.println("_________________________________________");

        int input = Integer.parseInt(myScanner.nextLine());
        switch (input) {
            case 1:
                displayEmployeesNew();
                break;
            case 2:
                displayEmployeesDelete();
                break;
            case 3:
                displayEmployeesEdit();
                break;
            case 4:
                getEmployeeMenuChoice();
                break;
        }

    }

    private void displayEmployeesNew() {
        System.out.println("_______________________________");
        System.out.println("Welcome to to add employees menu");
        System.out.println("What is the forename of the new employee:");
        String forename = new Scanner(System.in).nextLine();
        System.out.println("What is the surnname of the new employee:");
        String surname = new Scanner(System.in).nextLine();
        System.out.println("Who is the username of the new employee:");
        String username = new Scanner(System.in).nextLine();
        System.out.println("What is the password of the new employee:");
        String password = new Scanner(System.in).nextLine();
        System.out.println("What is the service of the new employee:");
        Integer service = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("What is the Game ID of the new game:");
        Boolean admin = new Scanner(System.in).nextLine();
        System.out.println("What is the number of stock of the new game:");
        Integer numInStock = Integer.parseInt(new Scanner(System.in).nextLine());
        employeeArray.add(new Employee(forename, surname, username, password, service, admin));
        System.out.println("New game added is: " + "forename:: " + forename + " Surname:  " + surname + " Username: " + username + " Password:  " + password + " Service: " + service + " admin status" + admin);
        System.out.println("");
        System.out.println("Would you like to add another employee-?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            displayEmployeesNew();
        } else {
            mainMenuChoice();
        }
    }

    private void displayEmployeesEdit() {
        if (!employeeArray.isEmpty()) {
            int x = 1;
            System.out.println("Please select an employee to edit: ");
            for (Employee input : employeeArray) {
                System.out.println(x + "-" + input.getForename() + " " + input.getSurname());
                x++;
            }
            System.out.println(x + " - Go back");
            int input = Integer.parseInt(new Scanner(System.in).nextLine());
            if (input <= employeeArray.size()) {
                Employee employee = employeeArray.get(input - 1);
                updateEmployeeRecord(employee);
            }
        }
    }

    private void updateEmployeeRecord(Employee selected) {
        System.out.println("_________________________________________");
        System.out.println("Which field would you like to amend?");
        System.out.println("1 - First name");
        System.out.println("2 - Second Name");
        System.out.println("3 - Username");
        System.out.println("4 - Password");
        System.out.println("5 - Service");
        System.out.println("6 - Admin rights");
        System.out.println("_________________________________________");
        getNewEmployeeValue(selected, Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    private void getNewEmployeeValue(Employee selected, int i) {
        switch (i) {
            case 1 -> updateForename(selected);
            case 2 -> updateSurname(selected);
            case 3 -> updateUsername(selected);
            case 4 -> updatePassword(selected);
            case 5 -> updateService(selected);
            case 6 -> updateAdminRights(selected);
        }

    }

    private void updateAdminRights(Employee selected) {
        if (selected.getIsAdmin()) {
            currentAdmin = true;
        } else {
            currentAdmin = false;
        }

        System.out.println("Their current admin status is: " + currentAdmin);
        System.out.println("Would you like to change their admin status? ");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            currentAdmin = !currentAdmin;
            selected.setIsAdmin(!selected.getIsAdmin());
            System.out.println("Their new admin status is " + currentAdmin);
            System.out.println("Would you like to edit more of this employees details? ");
            if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
                updateEmployeeRecord(selected);
            } else {
                amendEmployeeRecordMenu();
            }

        } else {
            System.out.println("Exiting back to menu");
            amendEmployeeRecordMenu();
        }

    }


    private void updateService(Employee selected) {
        System.out.println("The current service is: " + selected.service);
        System.out.println("Please enter the new service: ");
        int newService = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Are you sure you want to replace " + selected.service + " with " + newService);
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            selected.service = newService;
        }
        System.out.println("The new service is " + selected.service);
        System.out.println("Would you like to edit more of this games details? ");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            updateEmployeeRecord(selected);
        } else {
            amendEmployeeRecordMenu();
        }
    }

    private void updatePassword(Employee selected) {
        System.out.println("The current password is: " + selected.password);
        System.out.println("Please enter the new password: ");
        String newPass = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + selected.password + " with " + newPass);
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            selected.password = newPass;
        }
        System.out.println("The new password is " + selected.password);
        System.out.println("Would you like to edit more of this games details? ");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            updateEmployeeRecord(selected);
        } else {
            amendEmployeeRecordMenu();
        }

    }

    private void updateUsername(Employee selected) {
        System.out.println("The current username is: " + selected.username);
        System.out.println("Please enter the new username: ");
        String newUName = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + selected.username + " with " + newUName);
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            selected.username = newUName;
        }
        System.out.println("The new username is " + selected.username);
        System.out.println("Would you like to edit more of this games details? ");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            updateEmployeeRecord(selected);
        } else {
            amendEmployeeRecordMenu();
        }

    }

    private void updateSurname(Employee selected) {
        System.out.println("The current first name is: " + selected.surname);
        System.out.println("Please enter the new stock number: ");
        String newSName = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + selected.surname + " with " + newSName);
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            selected.surname = newSName;
        }
        System.out.println("The new surname is " + selected.surname);
        System.out.println("Would you like to edit more of this games details? ");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            updateEmployeeRecord(selected);
        } else {
            amendEmployeeRecordMenu();
        }
    }

    private void updateForename(Employee selected) {
        System.out.println("The current first name is: " + selected.forename);
        System.out.println("Please enter the new stock number: ");
        String newFName = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + selected.forename + " with " + newFName);
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            selected.forename = newFName;
        }
        System.out.println("The new forename is " + selected.forename);
        System.out.println("Would you like to edit more of this games details? ");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            updateEmployeeRecord(selected);
        } else {
            amendEmployeeRecordMenu();
        }

    }

    private void displayEmployeesDelete() {
        if (!employeeArray.isEmpty()) {
            int x = 1;
            System.out.println("Please select an employee you wish to delete: ");
            for (Employee input : employeeArray) {
                System.out.println(x + "-" + input.getForename() + input.getSurname());
                x++;
            }
            System.out.println(x + " - Go back");
            int input = Integer.parseInt(new Scanner(System.in).nextLine());
            if (input <= gamesArray.size()) {
                deleteEmployeeRecord(input);
            }
        }
    }

    private void deleteEmployeeRecord(int choice) {
        Employee employee = employeeArray.get(choice - 1);
        System.out.println("you are viewing: " + employee.getForename() + " " + employee.getSurname());
        System.out.println();
        System.out.println("please select from the following options:");
        System.out.println("Are you sure you want to delete the record of " + employee.getForename() + " " + employee.getSurname() + " ?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            System.out.println("Deleting record now...");
            employeeArray.remove(choice - 1);
            getEmployeeMenuChoice();
        } else {
            System.out.println("Very well, aborting.");
            amendRecordMenu();
        }
    }

    private void viewEmployeesAdmin() {
        System.out.println("The current staff we employ are:");
        for (int i = 0; i < employeeArray.size(); i++) {
            for (Employee input : employeeArray) {
                System.out.println(i + " - " + input.getForename() + " " + input.getSurname() + ", Username: " + input.getUsername() + ", Password: " + input.getPassword() + input.getService() + ", Service: " + " Admin approvals: " + input.getIsAdmin());
                i++;
            }
            System.out.println("would you like to go back to the main menu?" );
            if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
                mainMenuChoice();
            }
            else {
                System.out.println("Exiting...");
                break;
            }
            }
        }


    private void getMenuChoice() {
        System.out.println("Hello welcome to the stock menu");
        System.out.println("Please choose an option from below:");
        System.out.println("1: View Games List");
        System.out.println("2: Print all game details");
        System.out.println("3: Amend the records menu");
        System.out.println("4: Back");

        int input = Integer.parseInt(myScanner.nextLine());
        switch (input) {
            case 1:
                viewGames();
                break;
            case 2:
                viewExtraDetails();
                break;
            case 3:
                amendRecordMenu();
                break;
            case 4:
                mainMenuChoice();
        }
    }


    private void amendRecordMenu() {
        System.out.println("Welcome the the Amend Details Menu:");
        System.out.println("Please choose an option from below:");
        System.out.println("1: Add a new item");
        System.out.println("2: Remove an existing item");
        System.out.println("3: Update an item");
        System.out.println("4: Back");


        int input = Integer.parseInt(myScanner.nextLine());
        switch (input) {
            case 1:
                displayGamesNew();
                break;
            case 2:
                displayGamesDelete();
                break;
            case 3:
                displayGamesEdit();
                break;
            case 4:
                amendRecordMenu();
                break;

        }
    }

    // delete
    private void displayGamesDelete() {
        if (!gamesArray.isEmpty()) {
            int x = 1;
            System.out.println("Please select a game to delete: ");
            for (Game input : gamesArray) {
                System.out.println(x + "-" + input.title);
                x++;
            }
            System.out.println(x + " - Go back");
            int input = Integer.parseInt(new Scanner(System.in).nextLine());
            if (input <= gamesArray.size()) {
                deleteRecord(input);
            }
        }
    }

    private void deleteRecord(int choice) {
        Game games = gamesArray.get(choice - 1);
        System.out.println("you are viewing: " + games.title);
        System.out.println();
        System.out.println("please select from the following options:");
        System.out.println("Are you sure you want to delete the record of " + games.title + " ?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            System.out.println("Deleting record now...");
            gamesArray.remove(choice - 1);
            getMenuChoice();
        } else {
            System.out.println("Very well, aborting.");
            amendRecordMenu();
        }
    }

    // all details
    private void viewExtraDetails() {
        System.out.println("The current games we have in stock are:");
        for (int i = 0; i < gamesArray.size(); i++) {
            System.out.println("Title: " + gamesArray.get(i).title
                    + ", Age Rating: " + gamesArray.get(i).ageRating + ", Publisher: " + gamesArray.get(i).publisher + ", Genre:  " +
                    gamesArray.get(i).genre + ", Price: ," + gamesArray.get(i).price
                    + ", ID: " + gamesArray.get(i).gameID + ", Stock Level:  " + gamesArray.get(i).numInStock);
        }
    }

    // view
    private void viewGames() {
        System.out.println("The current games we have in stock are:");
        for (int i = 0; i < gamesArray.size(); i++) {
            System.out.println(gamesArray.get(i).title);
        }
        System.out.println("Feel free to edit or view more details back at the main menu");
        System.out.println("Please click y to exit to menu or n to close");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            getMenuChoice();
        } else {
            System.out.println("Exiting....");
        }
    }

    // edit
    private void displayGamesEdit() {
        if (!gamesArray.isEmpty()) {
            int x = 1;
            System.out.println("Please select a game to edit: ");
            for (Game input : gamesArray) {
                System.out.println(x + "-" + input.title);
                x++;
            }
            System.out.println(x + " - Go back");
            int input = Integer.parseInt(new Scanner(System.in).nextLine());
            if (input <= gamesArray.size()) {
                Game games = gamesArray.get(input - 1);
                updateRecord(games);
            }
        }
    }

    private void updateRecord(Game selected) {
        System.out.println("Which field would you like to amend?");
        System.out.println("1 - Title");
        System.out.println("2 - Age Rating");
        System.out.println("3 - Publisher");
        System.out.println("4 - Genre");
        System.out.println("5 - Price");
        System.out.println("6 - Game ID");
        System.out.println("7 - Stock Number");
        getNewValue(selected, Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    private void getNewValue(Game selected, int i) {
        switch (i) {
            case 1 -> updateTitle(selected);
            case 2 -> updateAgeRating(selected);
            case 3 -> updateGenre(selected);
            case 4 -> updatePrice(selected);
            case 5 -> updateGameID(selected);
            case 6 -> updateStockNum(selected);
        }

    }

    private void updateStockNum(Game selected) {
        System.out.println("The current stock number is: " + selected.numInStock);
        System.out.println("Please enter the new stock number: ");
        Integer newStock = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Are you sure you want to replace " + selected.numInStock + " with " + newStock);
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            selected.numInStock = newStock;
        }
        System.out.println("The new stock number is " + selected.ageRating);
        System.out.println("Would you like to edit more of this games details? ");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            updateRecord(selected);
        } else {
            getMenuChoice();
        }
    }

    private void updateGameID(Game selected) {
        System.out.println("The current Game ID is: " + selected.gameID);
        System.out.println("Please enter the Game ID: ");
        Integer newID = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Are you sure you want to replace " + selected.gameID + " with " + newID);
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            selected.gameID = newID;
        }
        System.out.println("The new game Game ID is " + selected.ageRating);
        System.out.println("Would you like to edit more of this games details? ");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            updateRecord(selected);
        } else {
            getMenuChoice();
        }
    }

    private void updatePrice(Game selected) {
        System.out.println("The current price is: " + selected.price);
        System.out.println("Please enter the new price: ");
        Integer newPrice = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Are you sure you want to replace " + selected.price + " with " + newPrice);
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            selected.price = newPrice;
        }
        System.out.println("The new game price is " + selected.ageRating);
        System.out.println("Would you like to edit more of this games details? ");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            updateRecord(selected);
        } else {
            getMenuChoice();
        }
    }

    private void updateGenre(Game selected) {
        System.out.println("The current genre is: " + selected.genre);
        System.out.println("Please enter the new genre:");
        String newGenre = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + selected.genre + " with " + newGenre);
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            selected.genre = newGenre;
        }
        System.out.println("The new game genre is " + selected.title);
        System.out.println("Would you like to edit more of this games details? ");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            updateRecord(selected);
        } else {
            getMenuChoice();
        }

    }


    private void updateTitle(Game selected) {
        System.out.println("The current title is: " + selected.title);
        System.out.println("Please enter the new title: ");
        String newName = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + selected.title + " with " + newName);
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            selected.title = newName;
        }
        System.out.println("The new game title is " + selected.title);
        System.out.println("Would you like to edit more of this games details? ");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            updateRecord(selected);
        } else {
            getMenuChoice();
        }
    }

    private void updateAgeRating(Game selected) {
        System.out.println("The current Age Rating is: " + selected.ageRating);
        System.out.println("Please enter the new age rating: ");
        Integer newAge = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Are you sure you want to replace " + selected.ageRating + " with " + newAge);
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            selected.ageRating = newAge;
        }
        System.out.println("The new game age rating is " + selected.ageRating);
        System.out.println("Would you like to edit more of this games details? ");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            updateRecord(selected);
        } else {
            getMenuChoice();
        }

    }
    // add

    private void displayGamesNew() {
        System.out.println("The current games we have in stock are:");
        for (int i = 0; i < gamesArray.size(); i++) {
            System.out.println(gamesArray.get(i).title);
        }
        addRecordMenu();
    }

// add

    private void addRecordMenu() {
        System.out.println("_______________________________");
        System.out.println("Welcome to to add Games menu");
        System.out.println("What is the name of the new game:");
        String title = new Scanner(System.in).nextLine();
        System.out.println("What is the age rating of the new game:");
        Integer ageRating = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Who is the publisher of the new game:");
        String publisher = new Scanner(System.in).nextLine();
        System.out.println("What is the genre of the new game:");
        String genre = new Scanner(System.in).nextLine();
        System.out.println("What is the price of the new game:");
        Integer price = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("What is the Game ID of the new game:");
        Integer gameID = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("What is the number of stock of the new game:");
        Integer numInStock = Integer.parseInt(new Scanner(System.in).nextLine());
        gamesArray.add(new Game(title, ageRating, publisher, genre, price, gameID, numInStock));
        System.out.println("New game added is: " + "Title: " + title + " Publsher:  " + publisher + " Genre: " + genre + " price: " + price);
        System.out.println("");
        System.out.println("Would you like to add another game?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            addRecordMenu();
        } else {
            getMenuChoice();
        }
    }


}

    
