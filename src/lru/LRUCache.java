package lru;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author yebingxu
 */
public class LRUCache {

    HashMap<Integer, Item> lruMap = new HashMap<Integer, Item>();
    private Queue<Item> priorityQueue;
    private static int timer = 0;
    private int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        priorityQueue = new PriorityQueue<Item>(capacity, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                if (a.getStamp() < b.getStamp()) {
                    return -1;
                } else if (a.getStamp() == b.getStamp()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }

    public int get(int key) {
        if (lruMap.size() == 0) {
            return -1;
        }
        Item item = lruMap.get(key);
        if (item == null) {
            return -1;
        } else {
            priorityQueue.remove(item);
            item.setStamp(++timer);
            priorityQueue.offer(item);
            return item.getValue();
        }
    }

    public void set(int key, int value) {
        if (lruMap.size() == 0) {
            Item item = new Item(key, value, ++timer);
            lruMap.put(key, item);
            priorityQueue.offer(item);
            return;
        }
        if (lruMap.size() == capacity) {
            removeLRUItem();
        }
        Item item = lruMap.get(key);
        if (item == null) {
            item = new Item(key, value, ++timer);
            lruMap.put(key, item);
            priorityQueue.offer(item);
        } else {
            priorityQueue.remove(item);
            item.setValue(value);
            item.setStamp(++timer);
            priorityQueue.offer(item);
        }
    }

    private void removeLRUItem() {
        Item item = priorityQueue.poll();
        lruMap.remove(item.getKey());
    }


    private class Item {
        private int key;
        private int value;
        private int stamp;

        public Item(int key, int value, int stamp) {
            this.key = key;
            this.value = value;
            this.stamp = stamp;
        }
        public int getKey() {
            return key;
        }
        public void setKey(int key) {
            this.key = key;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public int getStamp() {
            return stamp;
        }
        public void setStamp(int stamp) {
            this.stamp = stamp;
        }
        public boolean equals(Item b) {
            if (key == b.getKey()) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.set(2, 6);
        System.out.println(cache.get(1));
        cache.set(1,5);
        cache.set(1,2);
        int i = cache.get(1);
        System.out.println(i);
        int j = cache.get(2);
        System.out.println(j);
    }
}