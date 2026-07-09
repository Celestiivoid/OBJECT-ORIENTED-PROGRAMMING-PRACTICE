package LIBRARYMANAGEMENTV1;

public class Book {
    String bookTitle;
    String authorName;
    boolean isBorrowed;
    String borrowedBy;

    Book(String bookTitle, String authorName, boolean isBorrowed) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.isBorrowed = false;
    }

    String borrow(int bookIndex) {
        if(bookIndex <= 0) {
            return "Cannot validate 0 or negative numbers.";
        }
        isBorrowed = true;
        return "Successfully borrowed: " + bookTitle;
    }
    String returnBook(int bookIndex) {
        if(bookIndex <= 0) {
            return "Cannot validate 0 or negative numbers.";
        }
        isBorrowed = false;
        return "Successfully returned: " + bookTitle;  

    }
    void displayBook() {

    }

    String getBookTitle() {
        return bookTitle;
    }
    String getAuthorName() {
        return authorName;
    }
    String getIsBorrowed() {
        if(isBorrowed) {
            return "Borrowed";
        }
        else {
            return "Available";
        }
    }
    String getBorrowedBy(String name) {
        if(name == null) {
            return "None";
        }
        else {
            borrowedBy = name;
            return borrowedBy; 
        }
    }
}
