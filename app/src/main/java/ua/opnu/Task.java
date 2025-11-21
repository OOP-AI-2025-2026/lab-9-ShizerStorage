package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        if (list == null) return;
        int i = 0;
        while (i < list.size() - 1) {
            String a = list.get(i);
            String b = list.get(i + 1);
            if (a.length() <= b.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
            i++;
        }
    }

    public void stutter(List<String> list) {
        if (list == null) return;
        int i = 0;
        while (i < list.size()) {
            String s = list.get(i);
            list.add(i + 1, s);
            i += 2;
        }
    }

    public void switchPairs(List<String> list) {
        if (list == null) return;
        int i = 0;
        while (i + 1 < list.size()) {
            String tmp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, tmp);
            i += 2;
        }
    }

    public void removeDuplicates(List<String> list) {
        if (list == null) return;
        int i = 0;
        while (i + 1 < list.size()) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        if (list == null) return;
        int i = 0;
        while (i < list.size()) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i += 2;
            } else {
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue == null) return true;
        int n = queue.size();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Integer v = queue.remove();
            stack.push(v);
            queue.add(v);
        }
        boolean pal = true;
        for (int i = 0; i < n; i++) {
            Integer v = queue.remove();
            Integer s = stack.pop();
            if (!Objects.equals(v, s)) pal = false;
            queue.add(v);
        }
        return pal;
    }

    public void reorder(Queue<Integer> queue) {
        if (queue == null) return;
        List<Integer> list = new ArrayList<>(queue);
        Collections.sort(list);
        queue.clear();
        queue.addAll(list);
    }

    public void rearrange(Queue<Integer> queue) {
        if (queue == null) return;
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            Integer v = queue.remove();
            if (v % 2 == 0) evens.add(v);
            else odds.add(v);
            queue.add(v);
        }
        queue.clear();
        for (Integer e : evens) queue.add(e);
        for (Integer o : odds) queue.add(o);
    }

    public int maxLength(Set<String> set) {
        if (set == null || set.isEmpty()) return 0;
        int max = 0;
        for (String s : set) {
            if (s != null && s.length() > max) max = s.length();
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        if (set == null) return;
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s != null && s.length() % 2 == 0) {
                it.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null) return 0;
        Set<Integer> s1 = new HashSet<>(list1);
        Set<Integer> common = new HashSet<>();
        for (Integer v : list2) {
            if (s1.contains(v)) common.add(v);
        }
        return common.size();
    }

    public boolean isUnique(Map<String, String> map) {
        if (map == null) return true;
        Set<String> seen = new HashSet<>();
        for (String v : map.values()) {
            if (seen.contains(v)) return false;
            seen.add(v);
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        if (map1 == null || map2 == null) return result;
        for (Map.Entry<String, Integer> e : map1.entrySet()) {
            String key = e.getKey();
            Integer val = e.getValue();
            if (map2.containsKey(key) && Objects.equals(map2.get(key), val)) {
                result.put(key, val);
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        if (map == null) return result;
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            Integer key = e.getKey();
            String val = e.getValue();
            if (!result.containsKey(val)) {
                result.put(val, key);
            } else {
                Integer existing = result.get(val);
                if (key != null && existing != null && key > existing) {
                    result.put(val, key);
                }
            }
        }
        return result;
    }

    public int rarest(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer v : map.values()) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        int minFreq = Integer.MAX_VALUE;
        for (Integer f : freq.values()) {
            if (f < minFreq) minFreq = f;
        }
        int bestValue = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int value = e.getKey();
            int f = e.getValue();
            if (f == minFreq && value < bestValue) {
                bestValue = value;
            }
        }
        return bestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        for (Integer v : list) {
            int f = freq.getOrDefault(v, 0) + 1;
            freq.put(v, f);
            if (f > max) max = f;
        }
        return max;
    }

}
