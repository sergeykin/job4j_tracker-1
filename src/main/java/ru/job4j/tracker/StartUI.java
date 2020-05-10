package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                addItem(input, tracker);
            } else if (select == 1) {
                findAllItem(input, tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findByIdItem(input, tracker);
            } else if (select == 5) {
                findByNameItems(input, tracker);
            } else if (select == 6) {
                System.out.println("=== Exit ====");
                run = false;
            }
        }
    }

    public static void addItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAllItem(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    public static void findByIdItem(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Wrong id! Not found");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Item is successfully replaced!");
        } else {
            System.out.println("Wrong id!");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String id = input.askStr("Enter id: ");
        if (tracker.deleted(id)) {
            System.out.println("Item is successfully deleted!");
        } else {
            System.out.println("Wrong id!");
        }
    }

    public static void findByNameItems(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        new StartUI().init(new ConsoleInput(), tracker);
    }
}