import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Product {
    private String name;
    private String description;
    private BigDecimal price;
    protected long id;
    private LocalDate createAt = LocalDate.now();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
       this.id = id;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return " " +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", id=" + id +
                ", createAt=" + createAt +
                '}';
    }

    public static void deleteProduct(Product[] products , int count) {
        System.out.print("Enter 🆔 for delete Product: ");
        long delete = new Scanner(System.in).nextLong();
        boolean choice = false;
        for (int i = 0; i < count; i++) {
            if (products[i].getId() == delete) {
                products[i] = null;
                choice = true;
            }
        }
        if (!choice){
            System.out.println(">>>> Incorrect 🆔 <<<<");
        }
    }
}
