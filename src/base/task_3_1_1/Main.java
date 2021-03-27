package base.task_3_1_1;

class Main {
    public static void main(String[] args) {
        BookMover fromAvailableStatusMover = new FromAvailableStatusMover();
        BookMover fromBorrowedStatusMover = new FromBorrowedStatusMover();
        BookMover fromArchievedStatusMover = new FromArchievedStatusMover();
        BookMover fromOverduedStatusMover = new FromOverduedStatusMover();

        Book book1 = new Book("Harry Potter: Origins");
        System.out.println("Начальный статус книги: " + book1.getStatus() + "\n");

        fromAvailableStatusMover.moveToStatus(book1, Status.OVERDUED);
        fromAvailableStatusMover.moveToStatus(book1, Status.BORROWED);
        System.out.println();

        fromBorrowedStatusMover.moveToStatus(book1, Status.BORROWED);
        fromBorrowedStatusMover.moveToStatus(book1, Status.OVERDUED);
        System.out.println();

        fromOverduedStatusMover.moveToStatus(book1, Status.BORROWED);
        fromOverduedStatusMover.moveToStatus(book1, Status.ARCHIVED);
        System.out.println();

        fromArchievedStatusMover.moveToStatus(book1, Status.OVERDUED);
        fromArchievedStatusMover.moveToStatus(book1, Status.AVAILABLE);
    }
}
