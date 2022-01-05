### 解题思路
此处撰写解题思路

### 代码

```java
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	Deque<Integer> deque;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        deque = new LinkedList<>();
        while (iterator.hasNext()) {
            deque.offer(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return deque.peekFirst();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer integer = deque.pollFirst();
        return integer;
    }

    @Override
    public boolean hasNext() {
        return !deque.isEmpty();
    }
}
```