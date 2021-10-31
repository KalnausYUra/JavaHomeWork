package com.pb.kalnaus.hw5;

public class Reader {

private String fullName;
    private int libraryCardNumber;
    private String faculty;
    private String dateOfBirth;
    private String  phoneNumber;

    public Reader() {
    }

    public Reader(String fullName, int libraryCardNumber, String faculty, String dateOfBirth, String  phoneNumber) {
        this.fullName = fullName;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(int libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String  getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String  phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(int numberBooks ) {
    System.out.println(fullName + " взял " + numberBooks + " книги");
    }

    public void takeBook(String... numberBooks ) {
        System.out.print(fullName + " взял книги: ");
        for (int k = 0; k < numberBooks.length; k++) {
            System.out.print(numberBooks[k]);
            if(k < numberBooks.length -1 )  {
                System.out.print(", ");
            }
        }
        System.out.print(".");
    }

    public void takeBook(Book... books ) {
        System.out.print("\n" + fullName + " взял книги: ");
        for(int i = 0;i<books.length;i++) {

            System.out.print(books[i].getNameBook() + " (" + books[i].getAuthor()+ " " + books[i].getYear()+ " г.)");
            if(i < books.length -1 )  {
                System.out.print(", ");
            }
        }
        System.out.print(".");
    }

    public void returnBook(int numberBooks ) {
        System.out.println(fullName + " вернул " + numberBooks + " книги");
    }

    public void returnBook(String... numberBooks ) {
        System.out.print(fullName + " вернул книги: ");

        for (int j = 0; j < numberBooks.length; j++) {
            System.out.print(numberBooks[j]);
            if(j < numberBooks.length -1 )  {
                System.out.print(", ");
            }
        }
        System.out.print(".");
    }

    public void returnBook(Book... books ) {
        System.out.print(fullName + " вернул книги: ");
        for(int i =0;i<books.length;i++) {

            System.out.print(books[i].getNameBook() + " (" + books[i].getAuthor()+ " " + books[i].getYear()+ " г.)");
            if(i < books.length -1 )  {
                System.out.print(", ");
            }
        }
        System.out.print(".");
    }
}