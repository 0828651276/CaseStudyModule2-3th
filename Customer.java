import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Customer {
    private String name;
    private String cccd;
    private String phone;
    private String email;
    private final String password;

    public Customer(String name, String cccd, String phone, String email, String password) {
        this.name = name;
        this.cccd = cccd;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePhone(String phone) {
        String regex = "^0\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public boolean validateCCCD(String cccd) {
        String regex = "^036\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cccd);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static Customer register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter CCCD: ");
        String cccd = scanner.nextLine();

        String phone;
        do {
            System.out.print("Enter phone: ");
            phone = scanner.nextLine();
            if (!new Customer("", "", "", "", "").validatePhone(phone)) {
                System.out.println("Invalid phone number. Please try again.");
            }
        } while (!new Customer("", "", "", "", "").validatePhone(phone));

        String email;
        do {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            if (!new Customer("", "", "", "", "").validateEmail(email)) {
                System.out.println("Invalid email. Please try again.");
            }
        } while (!new Customer("", "", "", "", "").validateEmail(email));

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Store the customer information
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customer.txt", true))) {
            writer.write(name + "," + cccd + "," + email + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("passincustomer.txt", true))) {
            writer.write(phone + "," + password + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Register successful!");
        return new Customer(name, cccd, phone, email, password);

    }

    public static Customer login() {
        Scanner scanner = new Scanner(System.in);
        String phone, password;

        while (true) {
            System.out.print("Enter phone: ");
            phone = scanner.nextLine();

            System.out.print("Enter password: ");
            password = scanner.nextLine();

            // Validate login
            try (BufferedReader reader = new BufferedReader(new FileReader("passincustomer.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts[0].equals(phone) && parts[1].equals(password)) {
                        System.out.println("Login successful!");
                        return new Customer("", "", phone, "", password);
                    }
                }
                System.out.println("Invalid login. Please try again.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
