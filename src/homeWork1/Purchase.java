package homeWork1;

/**
 * Created by Dima on 02.10.2015.
 */
public class Purchase {
    private String article;
    private int count;

    Purchase(){};

    Purchase(String article, int count){
        this.article = article;
        this.count = count;
    }

    public String getArticle() {
        return article;
    }

    public int getCount() {
        return count;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
