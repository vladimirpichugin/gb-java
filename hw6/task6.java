package hw6;

import java.util.*;

public class task6 {

    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Dell", 8, 512, "Windows 10", "Чёрный", 80099.99));
        laptops.add(new Laptop("HP", 16, 512, "Windows 11", "Серый", 120099.99));
        laptops.add(new Laptop("Lenovo", 8, 256, "Windows 10", "Красный", 60049.99));
        laptops.add(new Laptop("Apple", 16, 512, "macOS Big Sur", "Синий", 170099.99));


        // print results
        Set<Laptop> rest = filterLaptops(laptops, Map.of("ram", 8, "storage", 512, "os", "Windows 10", "color", "Чёрный"));
        System.out.println(rest);

    }


    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        Set<Laptop> filteredLaptops = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean matches = true;
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                switch (key) {
                    case "ram":
                        int ram = (int) value;
                        if (laptop.getRam() < ram) {
                            matches = false;
                        }
                        break;
                    case "storage":
                        int storage = (int) value;
                        if (laptop.getStorage() < storage) {
                            matches = false;
                        }
                        break;
                    case "os":
                        String os = (String) value;
                        if (!laptop.getOs().equals(os)) {
                            matches = false;
                        }
                        break;
                    case "color":
                        String color = (String) value;
                        if (!laptop.getColor().equals(color)) {
                            matches = false;
                        }
                        break;
                }
            }

            if (matches) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }

}

class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;
    private double price;

    public Laptop(String brand, int ram, int storage, String os, String color, double price) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return brand + " - RAM: " + ram + "GB, Диск: " + storage + "GB, ОС: " + os + ", Цвет: " + color + ", Стоимость: " + price;
    }
}
