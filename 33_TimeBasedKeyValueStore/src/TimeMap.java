import java.util.*;

class TimeMap {

    // Initializing the private hashmap to store the key and value
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>(); // Initializing the hashmap
    }
    
    public void set(String key, String value, int timestamp) {
        // If the key is not present in the hashmap, then add the key and value to the hashmap
        // If the key is present in the hashmap, then add the value to the key
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value); 
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key); // Getting the value of the key from the hashmap
        if (treeMap == null) return ""; // If the key is not present in the hashmap, then return empty string
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp); // Getting the value of the key from the treemap
        return entry == null ? "" : entry.getValue(); // If the value is null, then return empty string
    }

    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo", "bar", 1);
        System.out.println(obj.get("foo", 1)); // Output: bar
        System.out.println(obj.get("foo", 3)); // Output: bar
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4)); // Output: bar2
        System.out.println(obj.get("foo", 5)); // Output: bar2
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */