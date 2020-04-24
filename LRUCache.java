class LRUCache {
  int counter = 0;
  int capacity = 0;
  Map<Integer, Data> cache = new HashMap<>();
  static class Data {
    int value;
    int age;
    Data(int value, int age) {
      this.value = value;
      this.age = age;
    }
  }
  public LRUCache(int capacity) {
    this.capacity = capacity;
    counter = 0;
  }

  public int get(int key) {
    Data data = cache.get(key);
    if(data == null) return -1;
    int v = data.value;
    cache.put(key, new Data(v, this.counter));
    counter++;
    return v;
  }

  public void put(int key, int value) {
    if(cache.size() >= this.capacity && !cache.containsKey(key)) {
      int c = (int)1e7 + 7;
      int k = -1;
      for(Map.Entry<Integer, Data> entry : cache.entrySet()) {
        Data dataValue = entry.getValue();
        if(c > dataValue.age) {
          c = dataValue.age;
          k = entry.getKey();
        }
      }
      cache.remove(k);
    }  
    cache.put(key, new Data(value, this.counter));
    counter++;
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */