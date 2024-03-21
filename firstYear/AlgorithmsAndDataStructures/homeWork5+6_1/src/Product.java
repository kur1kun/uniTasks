public class Product<T1, T2 extends Comparable<T2>, T3, T4, T5 extends Comparable<T5>> implements Comparable<Product<T1, T2, T3, T4, T5>> {
    private T1 name;
    private T2 price;
    private T3 quantity;
    private T4 category;
    private T5 rating;

    public Product(T1 name, T2 price, T3 quantity, T4 category, T5 rating) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.rating = rating;
    }

    public T1 getName() {
        return name;
    }

    public void setName(T1 name) {
        this.name = name;
    }

    public T2 getPrice() {
        return price;
    }

    public void setPrice(T2 price) {
        this.price = price;
    }

    public T3 getQuantity() {
        return quantity;
    }

    public void setQuantity(T3 quantity) {
        this.quantity = quantity;
    }

    public T4 getCategory() {
        return category;
    }

    public void setCategory(T4 category) {
        this.category = category;
    }

    public T5 getRating() {
        return rating;
    }

    public void setRating(T5 rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(Product<T1, T2, T3, T4, T5> other) {
        return this.price.compareTo(other.price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name=" + name +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category=" + category +
                ", rating=" + rating +
                '}';
    }
}
