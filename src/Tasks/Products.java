package Tasks;

public class Products implements Comparable<Products> {

    private String nameProduct;
    private double price;

    public Products(String nameProduct, double price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Products product) {
        if (this.price < product.price) {
            return -1;
        } else if (this.price < product.price) {
            return 1;

        }else return 0;

    }
}
