package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.StubAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.StubInput;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] { action });
        assertThat(action.isCall(), is(true));
    }
}