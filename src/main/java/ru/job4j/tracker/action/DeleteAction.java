package ru.job4j.tracker.action;

import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.input.Input;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        String id = input.askStr("Enter id: ");
        if (memTracker.deleted(id)) {
            System.out.println("Item is successfully deleted!");
        } else {
            System.out.println("Wrong id!");
        }
        return true;
    }
}
