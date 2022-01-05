### 解题思路
此处撰写解题思路

### 代码

```java
class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }
   private String lock = "lock";

    public void foo(Runnable printFoo) throws InterruptedException {
           synchronized (lock) {
        for (int i = 0; i < n; i++) {
             lock.wait();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        
            printFoo.run();
           lock.notify();
        }
    }
    }

    public void bar(Runnable printBar) throws InterruptedException {
         synchronized (lock) {
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	lock.notify();
                lock.wait();
            printBar.run();
         
        }
    }
    }
}
```