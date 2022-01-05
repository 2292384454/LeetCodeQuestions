//我们提供一个类： 
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。 
//
// 请设计修改程序，以确保 "foobar" 被输出 n 次。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 1
//输出: "foobar"
//解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
// 
//
// 示例 2: 
//
// 
//输入: n = 2
//输出: "foobarfoobar"
//解释: "foobar" 将被输出两次。
// 
// 👍 110 👎 0

package leetcode.editor.cn;

import java.util.concurrent.Semaphore;

//Java：交替打印FooBar
public class P1115PrintFoobarAlternately {
    public static void main(String[] args) {
        FooBar fooBar = new P1115PrintFoobarAlternately().new FooBar(4);
        // TO TEST
        Thread foo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new printFoo());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread bar = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new printBar());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        bar.start();
        foo.start();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    //互斥锁实现
    class FooBar {
        private final int n;
        private boolean firstFooOver = false;//用于控制第一个输出的是foo还是bar，后续会自动交替输出
        private final Object lock = new Object();

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    firstFooOver = true;//第一次输出foo完成，后续的顺序控制就交给线程切换了
                    lock.notify();//唤醒bar
                    //如果i<n-1说明一会还会再输出一次foo，foo线程可以释放锁等待被bar唤醒
                    //否则不需要等待，已经完成n次foo的输出
                    if (i < n - 1)
                        lock.wait();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (!firstFooOver) lock.wait();
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    lock.notify();//唤醒foo
                    //如果i<n-1说明一会还会再输出一次bar，bar线程可以释放锁等待被foo唤醒
                    //否则不需要等待，已经完成n次bar的输出
                    if (i < n - 1)
                        lock.wait();
                }
            }
        }
    }
    //runtime:25 ms
    //memory:38.3 MB
*/

    //信号量实现
    class FooBar {
        private final int n;
        private final Semaphore fooSem = new Semaphore(1);
        private final Semaphore barSem = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                fooSem.acquire();
                printFoo.run();
                barSem.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                barSem.acquire();
                printBar.run();
                fooSem.release();
            }
        }
    }
    //runtime:26 ms
    //memory:38.8 MB


    //    作者：scxin
    //    链接：https://leetcode-cn.com/problems/print-foobar-alternately/solution/lockwaitnotifyjian-dan-yi-dong-by-scxin-h9np/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //    KevinHwang：这个方法有问题，当先执行bar到lock.wait()后再执行foo到lock.wait()时两个线程都waiting，没有线程可以唤醒它们。
    // class FooBar {
    //     private final int n;
    //
    //     public FooBar(int n) {
    //         this.n = n;
    //     }
    //
    //     private final Object lock = new Object();
    //
    //     public void foo(Runnable printFoo) throws InterruptedException {
    //         synchronized (lock) {
    //             for (int i = 0; i < n; i++) {
    //                 lock.wait();
    //                 // printFoo.run() outputs "foo". Do not change or remove this line.
    //                 printFoo.run();
    //                 lock.notify();
    //             }
    //         }
    //     }
    //
    //     public void bar(Runnable printBar) throws InterruptedException {
    //         synchronized (lock) {
    //             for (int i = 0; i < n; i++) {
    //                 // printBar.run() outputs "bar". Do not change or remove this line.
    //                 lock.notify();
    //                 lock.wait();
    //                 printBar.run();
    //             }
    //         }
    //     }
    // }

//leetcode submit region end(Prohibit modification and deletion)

}

class printFoo implements Runnable {

    @Override
    public void run() {
        System.out.print("foo");
    }
}

class printBar implements Runnable {

    @Override
    public void run() {
        System.out.print("bar");
    }
}
