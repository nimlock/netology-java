package base.task_3_3_1.roles;

import base.task_3_3_1.Book;
import base.task_3_3_1.restrictions.*;

public class AdministratorLiblarianReader implements Administrator, Librarian, Reader {
    String name;

    public AdministratorLiblarianReader(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void findAndIssueBook(Reader reader) {
        System.out.printf("Now I gonna find book for you, %s\n", reader.getName());
    }

    @Override
    public void overdueNotification(Reader reader) {
        System.out.printf("Dear %s, you have to return book\n", reader.getName());
    }

    @Override
    public void orederBook(Supplier supplier, Book book) {
        System.out.printf("Hello, %s, we need new book %s\n",
                supplier.getName(), book.getTitle());
    }

    @Override
    public void takeBook(Book book) {
        System.out.printf("I want to get that book - %s\n", book.getTitle());
    }

    @Override
    public void returnBook(Book book) {
        System.out.printf("Please, take back that book - %s\n", book.getTitle());
    }
}
