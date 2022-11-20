package base.task_4_1_2;

class Box<K,T> {
    private K key;
    private T obj;

    protected Box(K key, T obj){
        this.key = key;
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
                "key=" + key +
                "; keyType=" + key.getClass().getName() +
                ", obj=" + obj +
                "; objType=" + obj.getClass().getName() +
                '}';
    }
}
