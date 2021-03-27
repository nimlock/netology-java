package base.task_3_1_1;

class FromOverduedStatusMover extends BookMover {
    protected FromOverduedStatusMover() {
//      Override superclass field value.
        super.allowedNewStatuses = new Status[]{Status.AVAILABLE, Status.ARCHIVED};
    }
}
