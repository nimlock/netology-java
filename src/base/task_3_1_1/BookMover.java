package base.task_3_1_1;

class BookMover {
    protected Status[] allowedNewStatuses;

    protected void moveToStatus(Book book, Status requestedStatus) {
        if (isStatusInArray(requestedStatus, allowedNewStatuses)) {
            System.out.println("Книга переводится в статус " + requestedStatus);
            book.setStatus(requestedStatus);
        } else {
            System.out.printf("Перевод книги из статуса %s в статус %s невозможен%n", book.getStatus(), requestedStatus);
        }
        System.out.println("Текущий статус книги: " + book.getStatus());
    }

    protected boolean isStatusInArray(Status givenStatus, Status[] statusArray) {
        boolean result = false;
        for (Status element : statusArray) {
            if (element == givenStatus) {
                result = true;
                break;
            }
        }
        return result;
    }
}
