//假设有这么一个类： 
//
// class ZeroEvenOdd {
//  public ZeroEvenOdd(int n) { ... }      // 构造函数
//  public void zero(printNumber) { ... }  // 仅打印出 0
//  public void even(printNumber) { ... }  // 仅打印出 偶数
//  public void odd(printNumber) { ... }   // 仅打印出 奇数
//}
// 
//
// 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程： 
//
// 
// 线程 A 将调用 zero()，它只输出 0 。 
// 线程 B 将调用 even()，它只输出偶数。 
// 线程 C 将调用 odd()，它只输出奇数。 
// 
//
// 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n
//。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出："0102"
//说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出："0102030405"
// 
// 👍 96 👎 0

package leetcode.editor.cn;

import java.util.IntSummaryStatistics;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

//Java：打印零与奇偶数
public class P1116PrintZeroEvenOdd {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new P1116PrintZeroEvenOdd().new ZeroEvenOdd(15);
        // TO TEST
        IntConsumer printNumber = new IntSummaryStatistics();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(printNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(printNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(printNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        A.start();
        B.start();
        C.start();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    //互斥锁实现
    class ZeroEvenOdd {
        private final int n;
        private final Object oddLock = new Object();//奇数锁
        private final Object evenLock = new Object();//偶数锁
        //flag标志位:
        // 0或者2 - 输出0；
        // 1 - 输出奇数；
        // 3 - 输出偶数。
        private int flag = 0;
        private final int lastEven, lastOdd;

        public ZeroEvenOdd(int n) {
            this.n = n;
            lastEven = (n & 1) == 0 ? n : n - 1;
            lastOdd = (n & 1) == 1 ? n : n - 1;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (oddLock) {
                    synchronized (evenLock) {
                        while (flag != 0 && flag != 2) {
                            if (flag == 1) oddLock.wait();
                            else evenLock.wait();
                        }
//                        System.out.print(0);
                        printNumber.accept(0);
                        flag = (++flag) % 4;
                        oddLock.notify();
                        evenLock.notify();
                        if (i < n - 1)//如果这不是最后一次输出0，就把奇/偶锁释放并进入等待，等待下一次被odd或者even唤醒
                            if (flag == 1) oddLock.wait();
                            else evenLock.wait();
                    }
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            int num = 2;
            while (num <= n) {
                synchronized (evenLock) {
                    while (flag != 3) {
                        evenLock.notify();
                        evenLock.wait();
                    }
//                    System.out.print(num);
                    printNumber.accept(num);
                    num += 2;
                    flag = (++flag) % 4;
                    evenLock.notify();
                    if (n != lastEven)//如果num不是最后一个偶数，就把偶数锁释放并进入等待，等待下一次被zero唤醒
                        evenLock.wait();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            int num = 1;
            while (num <= n) {
                synchronized (oddLock) {
                    while (flag != 1) {
                        oddLock.notify();
                        oddLock.wait();
                    }
//                    System.out.print(num);
                    printNumber.accept(num);
                    num += 2;
                    flag = (++flag) % 4;
                    oddLock.notify();
                    if (n != lastOdd)//如果num不是最后一个奇数，就把奇数锁释放并进入等待，等待下一次被zero唤醒
                        oddLock.wait();
                }
            }
        }
    }*/
    //信号量实现
    class ZeroEvenOdd {
        private final int n;
        private final Semaphore zeroSem = new Semaphore(1);//第一个输出0
        private final Semaphore evenSem = new Semaphore(0);
        private final Semaphore oddSem = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                try {
                    zeroSem.acquire();
                    printNumber.accept(0);
                    if ((i & 1) == 0) {
                        oddSem.release(); //i为偶数就释放一个奇数信号量
                    } else {
                        evenSem.release(); //i为奇数就释放一个偶数信号量
                    }
                } catch (InterruptedException ignore) {
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            int num = 2;
            while (num <= n) {
                try {
                    evenSem.acquire(); //使用一个偶数信号量
                    printNumber.accept(num);
                    num += 2;
                    zeroSem.release(); //释放一个零信号量
                } catch (InterruptedException ignore) {
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            int num = 1;
            while (num <= n) {
                try {
                    oddSem.acquire(); //使用一个奇数信号量
                    printNumber.accept(num);
                    num += 2;
                    zeroSem.release(); //释放一个零信号量
                } catch (InterruptedException ignore) {
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
