package base.task_3_3_1.restrictions;

import base.task_3_3_1.Book;

public interface Reader {
    String getName();
    void takeBook(Book book);
    void returnBook(Book book);
}
