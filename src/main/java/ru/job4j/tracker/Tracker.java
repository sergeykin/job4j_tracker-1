package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {

    private final Item[] items = new Item[100];

    private int position;

    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] found = new Item[position];
        int matched = 0;
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                found[matched++] = items[i];
            }
        }
        return Arrays.copyOf(found, matched);
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        item.setId(id);
        items[index] = item;
        return true;
    }

    public boolean deleted(String id) {
        int index = indexOf(id);
        System.arraycopy(items, index + 1, items, index, position - index - 1);
        items[position - 1] = null;
        position--;
        return true;
    }

    private int indexOf(String id) {
        int index = -1;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

}
