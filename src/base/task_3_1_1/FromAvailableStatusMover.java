package base.task_3_1_1;

class FromAvailableStatusMover extends BookMover {
    protected FromAvailableStatusMover() {
//      Override superclass field value.
        super.allowedNewStatuses = new Status[]{Status.BORROWED, Status.ARCHIVED};
    }
}
