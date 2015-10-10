package homeWork1;

/**
 * Created by Dima on 10.10.2015.
 */
public class Product {
    private String article;
    private double price;

    public Product(String article, double price) {
        this.article = article;
        this.price = price;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getArticle() {
        return article;
    }

    public double getPrice() {
        return price;
    }
}
