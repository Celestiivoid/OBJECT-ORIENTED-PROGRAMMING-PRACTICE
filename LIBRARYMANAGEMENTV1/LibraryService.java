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
            System.out.println("Book title: " + view.getBookTitle() 
            + " | Author name: " + view.getAuthorName() + "| Borrowed by: " + view.getBorrowedBy(null));
        }
    }
    void forBorrowAndReturn() {
        if(book.isEmpty()) {
            System.out.println("No books are available.");
            return;
        }

        for(int i = 0; i < book.size(); i++) {
            Book BnR = book.get(i);
            System.out.println("Book title: " + BnR.getBookTitle() 
            + " | Author name: " + BnR.getAuthorName() 
            + " | Book status: " + BnR.getIsBorrowed() + " | Borrowers' name: " + BnR.getBorrowedBy(null));
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
            selectedBook.borrow(borrow);
            selectedBook.getBorrowedBy(name);
            System.out.println("Successfully borrowed: " + selectedBook.getBookTitle());
            return;
        }
    }
    void returnBook() {

    }
    void searchBook() {

    }
}
