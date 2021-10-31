package com.pb.kalnaus.hw5;

public class Library {

    public static void main(String[] args) {

        Book[] books = new Book[3];
        books[0] = new Book("Приключения","Иванов И. И.",2000);
        books[1] = new Book("Словарь","Сидоров А. В.",1980);
        books[2] = new Book("Энциклопедия","Гусев К. В.",2010);


        Reader[] readers = new Reader[4];
        readers[0] = new Reader("Cтепанов В.Ю", 12345 , "Экономический","12.12.2000","0987654321");
        readers[1] = new Reader("Сидоров А.Н.", 23456 , "Экологический","2.05.1999","0977777777");
        readers[2] = new Reader("Булка В.А.", 34567 , "Математический","16.03.2001","0966666666");
        readers[3] = new Reader("Ворона В.В.", 45678 , "Юридический","15.08.2002","0955555555");


        for (Book book : books) {
            System.out.println("Название книги: " +book.getNameBook() +", Автор: " + book.getAuthor()+ ", "+ book.getYear() + " г.");
        }

        System.out.println("");

        for(Reader reader : readers) {
            System.out.println("Читатель: " + reader.getFullName() + ", номер читательского билета: " + reader.getLibraryCardNumber()+ ", факультет: " + reader.getFaculty()
            + ", день рождения: " + reader.getDateOfBirth() + ", тел.: " + reader.getPhoneNumber() + ".");

        }
        System.out.println("");
        readers[0].takeBook(3);

        readers[1].takeBook(books[1].getNameBook(),books[2].getNameBook());

        readers[2].takeBook(books[0],books[1]);


        System.out.println(" ");
        readers[0].returnBook(3);
        readers[1].returnBook(books[1].getNameBook(), books[2].getNameBook());
        System.out.println(" ");
        readers[2].returnBook(books[2], books[1]);
/*
        - демонстрируется работа всех вариантов методов takeBook() и returnBook().
*/




    }



}
