//编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是： 
//
// 
// 如果这个数字可以被 3 整除，输出 "fizz"。 
// 如果这个数字可以被 5 整除，输出 "buzz"。 
// 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。 
// 
//
// 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14
//, fizzbuzz。 
//
// 假设有这么一个类： 
//
// 
//class FizzBuzz {
//  public FizzBuzz(int n) { ... }               // constructor
//  public void fizz(printFizz) { ... }          // only output "fizz"
//  public void buzz(printBuzz) { ... }          // only output "buzz"
//  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
//  public void number(printNumber) { ... }      // only output the numbers
//} 
//
// 请你实现一个有四个线程的多线程版 FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用： 
//
// 
// 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。 
// 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。 
// 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。 
// 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。 
// 
//
// 
//
// 提示： 
//
// 
// 本题已经提供了打印字符串的相关方法，如 printFizz() 等，具体方法名请参考答题模板中的注释部分。 
// 
//
// 
// 👍 49 👎 0

package leetcode.editor.cn;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

//Java：交替打印字符串
public class P1195FizzBuzzMultithreaded {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new P1195FizzBuzzMultithreaded().new FizzBuzz(15);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FizzBuzz {
        private int n;
        private Integer curr;
        private final Semaphore isFizz;
        private final Semaphore isBuzz;
        private final Semaphore isFizzBuzz;
        private final Semaphore other;

        public FizzBuzz(int n) {
            this.n = n;
            this.curr = 1;
            this.isBuzz = new Semaphore(0);
            this.isFizz = new Semaphore(0);
            this.isFizzBuzz = new Semaphore(0);
            this.other = new Semaphore(0);
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (true) {
                //System.out.println("isFizz wait" + curr);
                isFizz.acquire();
                if (curr > n) {
                    break;
                }
                //System.out.println("isFizz run" + curr);
                printFizz.run();
                other.release();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (true) {
                //System.out.println("isBuzz wait" + curr);
                isBuzz.acquire();
                if (curr > n) {
                    break;
                }
                //System.out.println("isBuzz run" + curr);
                printBuzz.run();
                other.release();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (true) {
                //System.out.println("isFizzBuzz wait" + curr);
                isFizzBuzz.acquire();
                if (curr > n) {
                    break;
                }
                //System.out.println("isFizzBuzz run" + curr);
                printFizzBuzz.run();
                other.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (curr <= n) {
                //System.out.println("Number wait" + curr);
                if (curr % 3 == 0 && curr % 5 == 0) {
                    //System.out.println("Number -> FizzBuzz" + curr);
                    isFizzBuzz.release();
                } else if (curr % 3 == 0) {
                    //System.out.println("Number -> Fizz" + curr);
                    isFizz.release();
                } else if (curr % 5 == 0) {
                    //System.out.println("Number -> Buzz" + curr);
                    isBuzz.release();
                } else {
                    //System.out.println("Number run" + curr);
                    printNumber.accept(curr);
                    other.release();
                }
                other.acquire();
                curr++;
            }
            isFizzBuzz.release();
            isFizz.release();
            isBuzz.release();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
