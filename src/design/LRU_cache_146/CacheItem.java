package design.LRU_cache_146;

public class CacheItem {
    public CacheItem prev;
    public CacheItem next;
    public int value;
    public int key;

    CacheItem(int key, int value) {
        this.value = value;
        this.key = key;
    }
}
