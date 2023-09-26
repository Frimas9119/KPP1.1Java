import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader; 

class Toy {
    private String name;
    private int price;
    private int minAge;
    private int maxAge;
    private String sizeOrQuantityOrWeight;

    public Toy(String name, int price, int minAge, int maxAge, String sizeOrQuantityOrWeight) {
        this.name = name;
        this.price = price;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.sizeOrQuantityOrWeight = sizeOrQuantityOrWeight;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public String getSizeOrQuantityOrWeight() {
        return sizeOrQuantityOrWeight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        List<Toy> toys = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("q.txt"));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String name = parts[0];
            int price = Integer.parseInt(parts[1].trim()); // Trim leading/trailing whitespace
            int minAge = Integer.parseInt(parts[2].trim()); // Trim leading/trailing whitespace
            int maxAge = Integer.parseInt(parts[3].trim()); // Trim leading/trailing whitespace
            String sizeOrQuantityOrWeight = parts[4];

            Toy toy = new Toy(name, price, minAge, maxAge, sizeOrQuantityOrWeight);
            toys.add(toy);
        }

        System.out.print("Введіть початкову ціну (у копійках): ");
        int minPrice = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine().trim());

        System.out.print("Введіть кінцеву ціну (у копійках): ");
        int maxPrice = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine().trim());

        List<Toy> filteredToys = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice && toy.getMinAge() > 4) {
                filteredToys.add(toy);
            }
        }

        System.out.println("Результати фільтрації:");
        for (Toy toy : filteredToys) {
            System.out.println("Назва: " + toy.getName() + ", Ціна: " + toy.getPrice() / 100.0 + " грн, Мінімальний вік: "
                    + toy.getMinAge() + ", Максимальний вік: " + toy.getMaxAge());

            if ("Лялька".equals(toy.getName())) {
                System.out.println("Розмір: " + toy.getSizeOrQuantityOrWeight() + " см");
            } else if ("Кубики".equals(toy.getName())) {
                System.out.println("Кількість в наборі: " + toy.getSizeOrQuantityOrWeight() + " шт");
            } else if ("М'яч".equals(toy.getName())) {
                System.out.println("Вага: " + toy.getSizeOrQuantityOrWeight() + " г");
            } else if ("Конструктор".equals(toy.getName())) {
                System.out.println("Кількість конструкцій: " + toy.getSizeOrQuantityOrWeight());
            }
            System.out.println();
        }
    }
}
