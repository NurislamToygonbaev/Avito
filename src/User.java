import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String password;
    private Product[] products = new Product[100];

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void menuRegister() {
        while (true) {
            System.out.print("🟨 Enter first name: ");
            setFirstName(new Scanner(System.in).nextLine());
            if (!getFirstName().isBlank()) break;
            else System.err.println("Empty first name ❌");
        }
        while (true) {
            System.out.print("🟨 Enter last name: ");
            setLastName(new Scanner(System.in).nextLine());
            if (!getLastName().isBlank()) break;
            else System.err.println("Empty last name ❌");
        }
        while (true) {
            System.out.print("🟨 Enter your gender: ");
            setGender(new Scanner(System.in).nextLine());
            if (getGender().equalsIgnoreCase("male") ||
                    getGender().equalsIgnoreCase("female")) break;
            else System.err.println("Incorrect gender, Please use the male or female");
        }
        while (true) {
            System.out.print("🟨 Enter Email: ");
            setEmail(new Scanner(System.in).nextLine());
            if (getEmail().endsWith("@gmail.com")) break;
            else System.err.println("Incorrect email. Please use the domain @gmail.com");
        }
        while (true) {
            System.out.print("🟨 Enter password: ");
            setPassword(new Scanner(System.in).nextLine());
            if (getPassword().length() >= 4) break;
            else System.err.println("Write more 4 symbol ❌");
        }
        System.out.println();
        System.out.println("Registration successful ✅");

    }

    public void menuLogin(User[] userArray, int counter, int counterForBook, int counterForDevice) {
        String mail = "", pass = "";
        while (true) {
            System.out.print("enter your email: ");
            mail = new Scanner(System.in).nextLine();
            if (mail.endsWith("@gmail.com")) break;
            else System.err.println("Incorrect email. Please use the domain @gmail.com");
        }
        while (true) {
            System.out.print("enter your password: ");
            pass = new Scanner(System.in).nextLine();
            if (pass.length() >= 4) break;
            else System.err.println("write more 4 symbol ❌");
        }
        boolean success = false;
        for (int i = 0; i < userArray.length; i++) {
            if (mail.equalsIgnoreCase(userArray[i].getEmail()) && pass.equals(userArray[i].getPassword())) {
                System.out.println();
                System.out.println(">>>> LogIn successful <<<< ✅");
                boolean menuChoice = true;
                while (menuChoice) {
                    System.out.println();
                    System.out.println("~Profile:📟 " + userArray[i].getFirstName() + " " + userArray[i].getLastName());
                    System.out.println("Email:📧 " + userArray[i].getEmail());
                    menuInside();
                    String buttonMenu = new Scanner(System.in).nextLine();
                    switch (buttonMenu.toLowerCase()) {
                        case "0", "logout" -> {
                            menuChoice = false;
                        }
                        case "1", "add" -> {
                            System.out.println("Choice category: 1-Book📚📖 or 2-Device💻📱");
                            String choiceProduct = new Scanner(System.in).nextLine();
                            switch (choiceProduct.toLowerCase()) {
                                case "1", "book" -> {
                                    Book bookNew = new Book();
                                    bookNew.bookAdd(counter);
                                    products[counter] = bookNew;
                                    counter++;
                                    counterForBook++;
                                }
                                case "2", "device" -> {
                                    Device deviceNew = new Device();
                                    deviceNew.addDevice(counter);
                                    products[counter] = deviceNew;
                                    counter++;
                                    counterForDevice++;
                                }
                                default -> System.err.println("Please, choose the right option ❌");
                            }
                        }
                        case "2", "all product" -> {
                            if (counter > 0) {
                                getAllProducts(counter);
                            } else System.out.println("⛔ Products is empty: " + "Products[0]");
                        }
                        case "3", "all book" -> {
                            if (counterForBook > 0) {
                                getAllBook(counter);
                            } else System.out.println("⛔ Products is empty: " + "Products[0]");
                        }
                        case "4", "all device" -> {
                            if (counterForDevice > 0) {
                                getAllDevices(counter);
                            } else System.out.println("⛔ Products is empty: " + "Products[0]");
                        }
                        case "5", "delete" -> {
                            System.out.print("🗑️ Enter 1-one or 2-many: ");
                            String buttonChoiceForDelete = new Scanner(System.in).nextLine();
                            switch (buttonChoiceForDelete.toLowerCase()) {
                                case "1", "one" -> {
                                    Product.deleteProduct(products, counter);
                                    counter--;
                                    System.out.println();
                                    System.out.println("Product 🗑️ successful");
                                }
                                case "2", "many" -> {
                                    deleteMany(counter);
                                    counter--;
                                }
                                default -> System.out.println("👉 choose the right option");
                            }
                        }
                        default -> System.out.println("👉 choose the right option");
                    }
                }
                success = true;
                break;
            }
        }
        if (!success) {
            System.err.println("Invalid email or password ❌");
        }
    }

    private void menuInside() {
        System.out.println(STR."""
                                
                🔙❕  0. logout
                🆕➕  1. Add new Product
                🛍️🛄  2. Get all Products
                📚📕  3. Get all Book
                💻☎️  4. Get all Device
                🗑️🚮  5. Delete product by ID
                                
                """);
        System.out.print("---->> ");
    }


    private void getAllProducts(int counter) {
        System.out.println(STR."""
                                                        
                Products: ⬇️
                                                        
                """);
        for (int j = 0; j < counter; j++) {
            System.out.println(products[j]);
        }
        System.out.println("___________________________________________");
    }

    private void getAllBook(int counter) {
        System.out.println(STR."""
                                                        
                Book: ⬇️
                                                        
                """);
        for (int k = 0; k < counter; k++) {
            if (products[k] instanceof Book) {
                System.out.println(products[k]);
            }
        }
        System.out.println("___________________________________________");
    }

    private void getAllDevices(int counter) {
        System.out.println(STR."""
                                                        
                Device: ⬇️
                                                        
                """);
        for (int l = 0; l < counter; l++) {
            if (products[l] instanceof Device) {
                System.out.println(products[l]);
            }
        }
        System.out.println("___________________________________________");
    }

    public void deleteMany(int counter){
        boolean cycle = true;
        while (cycle) {
            Product.deleteProduct(products, counter);
            System.out.println();
            System.out.println("Product 🗑️ successful");
            System.out.print("Enter 0️⃣-stop or others 🆔: ");
            String choiceButtonForDelete = new Scanner(System.in).nextLine();
            if (choiceButtonForDelete.equals("0")) {
                cycle = false;
            }
        }
    }
}
