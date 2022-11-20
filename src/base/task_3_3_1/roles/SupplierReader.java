package base.task_3_3_1.roles;

import base.task_3_3_1.Book;
import base.task_3_3_1.restrictions.*;

public class SupplierReader implements Supplier, Reader {
    String name;

    public SupplierReader(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void takeBook(Book book) {
        System.out.printf("My name %s, I want to get book %s\n", this.getName(), book.getTitle());
    }

    @Override
    public void returnBook(Book book) {
        System.out.printf("I`m %s and I bring back book %s\n", this.getName(), book.getTitle());
    }

    @Override
    public void bringBook(Administrator administrator, Book book) {
        System.out.printf("Hey, administrator %s, I`ve brougth to you book %s\n",
                administrator.getName(),
                book.getTitle());
    }
}
