package ru.job4j.tracker.action;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.input.Input;

import java.util.List;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        String name = input.askStr("Enter name: ");
        List<Item> items = memTracker.findByName(name);
        for (Item item: items) {
            System.out.println(item);
        }
        return true;
    }
}
