package ru.job4j.tracker.action;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.input.Input;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        memTracker.add(item);
        System.out.println("Item successfully added!");
        return true;
    }
}
