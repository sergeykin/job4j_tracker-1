package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        tracker.add(item1);
        tracker.add(item2);
        Item[] expected = {item1, item2};
        Item[] result = tracker.findAll();
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("first");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] expected = {item1, item3};
        Item[] result = tracker.findByName("first");
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("first");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item result = tracker.findById(item2.getId());
        assertThat(result, is(item2));
    }

    @Test
    public void whenFindByIdNotFound() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("first");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item result = tracker.findById("1");
        assertThat(result, is(nullValue()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("first");
        tracker.add(item1);
        tracker.replace(item1.getId(), new Item("second"));
        assertThat(tracker.findById(item1.getId()).getName(), is("second"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("first");
        tracker.add(item1);
        tracker.deleted(item1.getId());
        assertThat(tracker.findById(item1.getId()), is(nullValue()));
    }

}