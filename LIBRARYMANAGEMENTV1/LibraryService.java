package LIBRARYMANAGEMENTV1;
import java.util.Scanner;
import java.util.ArrayList;

class LibraryService {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Book> book = new ArrayList<>();

    void addBook() {
        while(true) {
            System.out.println("=====ADD-BOOK=====");
            System.out.println("Enter book name: ");
            String bookName = scanner.nextLine();

            if(bookName.isEmpty()) {
                System.out.println("Book field cannot be empty.");
                continue;
            }

            System.out.println("Enter author name: ");
            String authorName = scanner.nextLine();

            if(authorName.isEmpty()) {
                System.out.println("Author field cannot be empty.");
                continue;
            }

            Book newBook = new Book(bookName, authorName, false);
            book.add(newBook);
            System.out.println("Successfully added " + bookName + "!");
            return;
        }
    }
    void viewBooks() {
        System.out.println("=====VIEW-BOOKS=====");
        if(book.isEmpty()) {
            System.out.println("No books are available.");
            return;
        }

        for(int i = 0; i < book.size(); i++) {
            Book view = book.get(i);
            System.out.println((i + 1) + ".) " + "Book title: " + view.getBookTitle() 
            + " | Author name: " + view.getAuthorName() + " | Book status: " + view.getIsBorrowed());
        }
    }
    void forBorrowAndReturn() {
        if(book.isEmpty()) {
            System.out.println("No books are available.");
            return;
        }

        for(int i = 0; i < book.size(); i++) {
            Book BnR = book.get(i);
            System.out.println((i + 1) + ".) " + "Book title: " + BnR.getBookTitle() 
            + " | Author name: " + BnR.getAuthorName() 
            + " | Book status: " + BnR.getIsBorrowed() + " | Borrowers' name: " + BnR.getBorrowedBy());
        }
    }
    void borrowBook() {
        while(true) {
            System.out.println("=====BORROW-BOOK=====");
            if(book.isEmpty()) {
                forBorrowAndReturn();
                return;
            }

            forBorrowAndReturn();
            System.out.println("Pick a book to borrow: ");
            int borrow;

            try {
                borrow = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(borrow < 1 || borrow > book.size()) {
                System.out.println("Out of range.");
                continue;
            }

            System.out.println("Enter name of borrower: ");
            String name = scanner.nextLine();

            if(name.isEmpty()) {
                System.out.println("Borrowers' name cannot be empty.");
                continue;
            }

            Book selectedBook = book.get(borrow - 1);

            if(selectedBook.getIsBorrowed().equals("Borrowed")) {
                System.out.println("Book is already borrowed.");
                return;
            }
            String result = selectedBook.borrow(name);
            System.out.println(result);
            return;
        }
    }
    void returnBook() {
        while(true) {
            System.out.println("=====RETURN-BOOK=====");

            if(book.isEmpty()) {
                forBorrowAndReturn();
                return;
            }

            forBorrowAndReturn();
            System.out.println("Pick a book to return: ");
            int pick;

            try {
                pick = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(pick < 1 || pick > book.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Book selectedBook = book.get(pick - 1);
            if(selectedBook.getIsBorrowed().equals("Available")) {
                System.out.println("Book is already available.");
                return;
            }

            String result = selectedBook.returnBook();
            System.out.println(result);
            return;
        }
    }
    void searchBook() {
        while(true) {
            System.out.println("=====SEARCH-BOOK=====");
            System.out.println("Enter book name or author name: ");
            String search = scanner.nextLine();

            if(search.isEmpty()) {
                System.out.println("Search field cannot be empty.");
                return;
            }

            for(int i = 0; i < book.size(); i++) {
                Book searchBook = book.get(i);
                if(search.equals(searchBook.getBookTitle()) || search.equals(searchBook.getAuthorName())) {
                    System.out.println("Book found!");
                    searchBook.displayBook();
                    return;
                }
            }
            System.out.println("Book not found.");
            return;
        }
    }
}
