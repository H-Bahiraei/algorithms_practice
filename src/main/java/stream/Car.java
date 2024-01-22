package stream;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/22/2024
 * @project algorithms_practice
 * &
 */
public class Car {
    int price;
    String color;

    public Car( String color, int price) {
        this.price = price;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
