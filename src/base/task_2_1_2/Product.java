package base.task_2_1_2;

public class Product {
    private final String name;
    private final int price;
    private final String description;

    public Product(int price, String name, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'';
    }
}
