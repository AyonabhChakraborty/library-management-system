
import books.Book;

import users.User;

import observer.InventoryObserver;
import observer.PatronObserver;

import inventory.searchpackage.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        library.addObserver(
                new InventoryObserver()
        );

        library.addObserver(
                new PatronObserver()
        );

        while(true){

            System.out.println("\n===== LIBRARY MENU =====");

            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Add User");
            System.out.println("4. Search By Title");
            System.out.println("5. Search By Author");
            System.out.println("6. Search By ISBN");
            System.out.println("7. Borrow Book");
            System.out.println("8. Return Book");
            System.out.println("9. Show Books");
            System.out.println("10. Show Users");
            System.out.println("11. Exit");

            int choice =
                    Integer.parseInt(
                            sc.nextLine()
                    );

            switch(choice){

                case 1:

                    System.out.print("Book Id : ");
                    Integer bookId =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    System.out.print("Title : ");
                    String title =
                            sc.nextLine();

                    System.out.print("Author : ");
                    String author =
                            sc.nextLine();

                    System.out.print("ISBN : ");
                    Integer isbn =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    System.out.print("Year : ");
                    Integer year =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    System.out.print("Genre : ");
                    String genre =
                            sc.nextLine();

                    Book book =
                            new Book(
                                    bookId,
                                    title,
                                    author,
                                    isbn,
                                    year,
                                    genre,
                                    true
                            );

                    library
                            .getBookManager()
                            .addBook(book);

                    break;

                case 2:

                    System.out.print(
                            "Book Id : "
                    );

                    Integer removeBookId =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    for(Book b :
                            library
                            .getBookManager()
                            .getBooks()){

                        if(b.getBookId()
                                .equals(removeBookId)){

                            library
                                    .getBookManager()
                                    .removeBook(b);

                            break;
                        }
                    }

                    break;

                case 3:

                    System.out.print(
                            "User Id : "
                    );

                    int userId =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    System.out.print(
                            "Name : "
                    );

                    String name =
                            sc.nextLine();

                    System.out.print(
                            "Email : "
                    );

                    String email =
                            sc.nextLine();

                    User user =
                            new User(
                                    userId,
                                    name,
                                    email
                            );

                    library
                            .getPatronManager()
                            .addUser(user);

                    break;

                case 4:

                    System.out.print(
                            "Title : "
                    );

                    String titleSearch =
                            sc.nextLine();

                    List<Book> titleResult =
                            library
                            .getBookManager()
                            .searchBy(
                                    new searchByTitle(),
                                    titleSearch
                            );

                    for(Book b : titleResult){
                        System.out.println(
                                b
                        );
                    }

                    break;

                case 5:

                    System.out.print(
                            "Author : "
                    );

                    String authorSearch =
                            sc.nextLine();

                    List<Book> authorResult =
                            library
                            .getBookManager()
                            .searchBy(
                                    new searchByAuthor(),
                                    authorSearch
                            );

                    for(Book b : authorResult){
                        System.out.println(
                                b
                        );
                    }

                    break;

                case 6:

                    System.out.print(
                            "ISBN : "
                    );

                    String isbnSearch =
                            sc.nextLine();

                    List<Book> isbnResult =
                            library
                            .getBookManager()
                            .searchBy(
                                    new searchByISBN(),
                                    isbnSearch
                            );

                    for(Book b : isbnResult){
                        System.out.println(
                                b
                        );
                    }

                    break;

                case 7:

                    System.out.print(
                            "Book Id : "
                    );

                    Integer borrowBookId =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    System.out.print(
                            "User Id : "
                    );

                    Integer borrowUserId =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    Book borrowBook = null;

                    User borrowUser = null;

                    for(Book b :
                            library
                            .getBookManager()
                            .getBooks()){

                        if(b.getBookId()
                                .equals(borrowBookId)){

                            borrowBook = b;
                            break;
                        }
                    }

                    for(User u :
                            library
                            .getPatronManager()
                            .getUsers()){

                        if(u.getUserId()
                                == borrowUserId){

                            borrowUser = u;
                            break;
                        }
                    }

                    if(borrowBook != null
                            &&
                            borrowUser != null){

                        library.borrowBook(
                                borrowBook,
                                borrowUser
                        );
                    }

                    break;

                case 8:

                    System.out.print(
                            "Book Id : "
                    );

                    Integer returnBookId =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    System.out.print(
                            "User Id : "
                    );

                    Integer returnUserId =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    Book returnBook = null;

                    User returnUser = null;

                    for(Book b :
                            library
                            .getBookManager()
                            .getBooks()){

                        if(b.getBookId()
                                .equals(returnBookId)){

                            returnBook = b;
                            break;
                        }
                    }

                    for(User u :
                            library
                            .getPatronManager()
                            .getUsers()){

                        if(u.getUserId()
                                == returnUserId){

                            returnUser = u;
                            break;
                        }
                    }

                    if(returnBook != null
                            &&
                            returnUser != null){

                        library.returnBook(
                                returnBook,
                                returnUser
                        );
                    }

                    break;

                case 9:

                    for(Book b :
                            library
                            .getBookManager()
                            .getBooks()){

                        System.out.println(
                                b
                        );
                    }

                    break;

                case 10:

                    for(User u :
                            library
                            .getPatronManager()
                            .getUsers()){

                        System.out.println(
                                u
                        );
                    }

                    break;

                case 11:

                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid Choice"
                    );
            }
        }
    }
}