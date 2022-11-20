package base.task_4_1_1;

class Box<T> {
    T obj;

    protected Box(T obj) {
        this.obj = obj;
    }

    protected void setObj(T obj) {
        this.obj = obj;
    }

    protected T getObj() {
        return this.obj;
    }

    @Override
    public String toString() {
        return "Box{" +
                "obj=" + obj +
                "; objType=" + obj.getClass().getName() +
                '}';
    }
}
