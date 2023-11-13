import java.util.Scanner;

public class Device extends Product{
    private String brand;
    private String color;
    private Boolean isNew;
    private double memory;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Device{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", isNew=" + isNew +
                ", memory=" + memory +
                ", " + super.toString();
    }
    public void addDevice(int count){
        setId(count+1);
        while (true){
            System.out.print("🟨 Enter product Brand: ");
            setBrand(new Scanner(System.in).nextLine());
            if (!getBrand().isBlank()) break;
            else  System.err.println("Empty product Brand ❌");
        }
        while (true){
            System.out.print("🟨 Enter product name: ");
            setName(new Scanner(System.in).nextLine());
            if (!getName().isBlank()) break;
            else System.err.println("Empty product name ❌");
        }
        while (true){
            System.out.print("🟨 Enter product memory: ");
            setMemory(new Scanner(System.in).nextInt());
            if (getMemory()>0) break;
            else System.err.println("Empty product memory ❌");
        }
        while (true){
            System.out.print("🟨 Enter product color: ");
            setColor(new Scanner(System.in).nextLine());
            if (!getColor().isBlank()) break;
            else System.err.println("Empty product color ❌");
        }
        while (true){
            System.out.print("🟨 Enter product description: ");
            setDescription(new Scanner(System.in).nextLine());
            if (!getDescription().isEmpty()) break;
            else System.err.println("Empty product description ❌");
        }
        System.out.print("🟨 Enter product price: ");
        setPrice(new Scanner(System.in).nextBigDecimal());
        System.out.print("🟨 New product? (true or false): ");
        setNew(new Scanner(System.in).nextBoolean());
        System.out.println();
        System.out.println(">>>> Successfully added devices <<<< ✅");
    }
}
