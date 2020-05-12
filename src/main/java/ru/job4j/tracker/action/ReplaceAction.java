package ru.job4j.tracker.action;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.input.Input;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter name: ");
        if (memTracker.replace(id, new Item(name))) {
            System.out.println("Item is successfully replaced!");
        } else {
            System.out.println("Wrong id!");
        }
        return true;
    }
}
