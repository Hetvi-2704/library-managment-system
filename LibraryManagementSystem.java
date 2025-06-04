import java.util.*;

class Book {

    public int id;
    public String title;
    public String author;
    public String genre;
    public int totalCopies;
    public int availableCopies;

    private Book(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.author = builder.author;
        this.genre = builder.genre;
        this.totalCopies = builder.totalCopies;
        this.availableCopies = builder.totalCopies; 
    }

    public static class Builder {
        public int id;
        public String title;
        public String author;
        public String genre;
        public int totalCopies;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setCopies(int totalCopies) {
            if (totalCopies < 0) {
                throw new IllegalArgumentException("Copies must be at least 0.");
            }
            this.totalCopies = totalCopies;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public void borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("No copies available to borrow.");
        }
    }

    public void returnBook() {
        if (availableCopies < totalCopies) {
            availableCopies++;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("All copies are already in the library. Nothing to return.");
        }
    }

    public void display() {
        System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author +
                " | Genre: " + genre + " | Available: " + availableCopies + "/" + totalCopies);
    }

    public boolean matches(String keyword) {
        keyword = keyword.toLowerCase();
        return title.toLowerCase().contains(keyword) ||
               author.toLowerCase().contains(keyword) ||
               genre.toLowerCase().contains(keyword);
    }
}

class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private int nextId = 1;

    public void addBook(String title, String author, String genre, int copies) {
        try {
            Book newBook = new Book.Builder()
                    .setId(nextId++)
                    .setTitle(title)
                    .setAuthor(author)
                    .setGenre(genre)
                    .setCopies(copies)
                    .build();
            books.add(newBook);
            System.out.println("Book added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book book : books) {
            book.display();
        }
    }

    public void searchBooks(String keyword) {
        boolean found = false;
        for (Book book : books) {
            if (book.matches(keyword)) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching books found.");
        }
    }

    public void borrowBook(int id) {
        for (Book book : books) {
            if (book.id == id) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.id == id) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();

                    System.out.print("Enter number of copies: ");
                    int copies = scanner.nextInt();
                    scanner.nextLine();

                    library.addBook(title, author, genre, copies);
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter keyword to search (title/author/genre): ");
                    String keyword = scanner.nextLine();
                    library.searchBooks(keyword);
                    break;

                case 4:
                    System.out.print("Enter book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    library.borrowBook(borrowId);
                    break;

                case 5:
                    System.out.print("Enter book ID to return: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting Library System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
