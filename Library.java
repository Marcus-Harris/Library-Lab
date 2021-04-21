package com.tts;

import java.util.ArrayList;

public class Library {
    String address;
    ArrayList<Book> myBook;

    public Library(String address) {
        this.address = address;
        this.myBook = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        this.myBook.add(book);
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress() {
        System.out.println(this.address);
    }

    public void printAvailableBooks() {
        boolean libraryIsEmpty = true;

        for(int i = 0; i < this.myBook.size(); ++i) {
            Book libraryBook = this.myBook.get(i);
            if (!libraryBook.isBorrowed()) {
                System.out.println(libraryBook.getTitle());
                libraryIsEmpty = false;
            }
        }

        if (libraryIsEmpty) {
            System.out.println("Sorry, our catalog is empty");
        }

    }

    public String borrowBook(String bookTitle) {
        for(int i = 0; i < this.myBook.size(); ++i) {
            Book libBook = (Book)this.myBook.get(i);
            String libBookTitle = libBook.getTitle();
            if (libBookTitle.equals(bookTitle)) {
                if (!libBook.isBorrowed()) {
                    libBook.borrowed();
                    System.out.println("We have " + libBookTitle + ", and you have successfully borrowed it!");
                    return null;
                }

                System.out.println("Someone else has " + libBookTitle + " right now :(");
                return null;
            }
        }

        System.out.println("Your book was not found in our system, sorry.");
        return null;
    }

    public String returnBook(String bookTitle) {
        boolean found = false;

        for(int i = 0; i < this.myBook.size(); ++i) {
            Book libraryBook = (Book)this.myBook.get(i);
            String libraryBookTitle = libraryBook.getTitle();
            if (libraryBookTitle.equals(bookTitle)) {
                if (libraryBook.isBorrowed()) {
                    libraryBook.returned();
                    System.out.println("You successfully returned " + libraryBookTitle + "!");
                    found = true;
                    break;
                }

                if (!found) {
                    System.out.println("Are you sure you got the book from here? It isn't in our system.");
                }
            }
        }
        System.out.println();
        return null;
    }
}
