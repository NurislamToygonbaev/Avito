import java.util.Scanner;

public class Book extends Product {
    private String authorFullName;

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorFullName='" + authorFullName + '\'' +
                ", " + super.toString();
    }

    public void bookAdd(int count) {
        setId(count+1);
        while (true) {
            System.out.print("🟨 Enter Book name: ");
            setName(new Scanner(System.in).nextLine());
            if (!getName().isBlank()) break;
            else System.err.println("Empty product name ❌");
        }
        while (true) {
            System.out.print("🟨 Enter Book description: ");
            setDescription(new Scanner(System.in).nextLine());
            if (!getDescription().isBlank()) break;
            else System.err.println("Empty product description ❌");
        }
        System.out.print("Enter product prise: ");
        setPrice(new Scanner(System.in).nextBigDecimal());
        while (true){
            System.out.print("🟨 Enter Book author full name: ");
            setAuthorFullName(new Scanner(System.in).nextLine());
            if (!getAuthorFullName().isBlank()) break;
            else System.err.println("Empty product author full name ❌");
        }
        System.out.println();
        System.out.println(">>>> Successfully added Book <<<< ✅");
    }
}
