package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.store.MemTracker;

public class StartUI {

    public void init(Input input, MemTracker memTracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Enter select: ");
            UserAction action = actions[select];
            run = action.execute(input, memTracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            System.out.printf("%d. %s%n", i, actions[i].name());
        }
    }


    public static void main(String[] args) {
        MemTracker memTracker = new MemTracker();
        new StartUI().init(new ValidateInput(new ConsoleInput()), memTracker, new UserAction[] {
                new CreateAction(),
                new FindAllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        });
    }
}