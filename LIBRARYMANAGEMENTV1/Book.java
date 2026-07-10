package LIBRARYMANAGEMENTV1;

public class Book {
    private String bookTitle;
    private String authorName;
    private boolean isBorrowed;
    private String borrowedBy = "None";

    Book(String bookTitle, String authorName, boolean isBorrowed) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.isBorrowed = isBorrowed;
    }

    String borrow(String name) {
        isBorrowed = true;
        borrowedBy = name;
        return "Successfully borrowed: " + bookTitle;
    }
    String returnBook() {
        isBorrowed = false;
        borrowedBy = "None";
        return "Successfully returned: " + bookTitle;  

    }
    void displayBook() {
        System.out.println("Book name: " + getBookTitle());
        System.out.println("Author name: " + getAuthorName());
        System.out.println("Book status: " + getIsBorrowed());
        System.out.println("Borrower: " + getBorrowedBy());
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
    String getBorrowedBy() {
        return borrowedBy;
    }
}
