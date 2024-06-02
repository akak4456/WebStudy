package org.adele.jvm.chapter12;

/**
 * volatile 변수 증가 연산 테스트 
 * 
 * @author zzm
 */
public class VolatileTest {
    public static int race = 0;

    public static synchronized void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        // 다른 모든 스레드가 종료할 때까지 대기
        while (Thread.activeCount() > 1)
            Thread.yield();

        System.out.println(race);
    }
}