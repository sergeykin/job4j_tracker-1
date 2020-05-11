package ru.job4j.tracker.action;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Tracker;
import ru.job4j.tracker.input.Input;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Item is successfully replaced!");
        } else {
            System.out.println("Wrong id!");
        }
        return true;
    }
}
