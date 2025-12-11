package library.model;

public class Category {

    private int id;
    private String category;

    public Category() {}

    public Category(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public Category(String category) {
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return category; }
    public void setName(String category) { this.category = category; }
}
