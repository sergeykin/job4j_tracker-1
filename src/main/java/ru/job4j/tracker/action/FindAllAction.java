package ru.job4j.tracker.action;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.input.Input;

import java.util.List;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        List<Item> items = memTracker.findAll();
        for (Item item : items) {
            System.out.println(item);
        }
        return true;
    }
}
