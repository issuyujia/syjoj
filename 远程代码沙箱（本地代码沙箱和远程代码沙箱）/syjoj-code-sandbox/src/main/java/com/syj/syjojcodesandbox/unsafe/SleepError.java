package com.syj.syjojcodesandbox.unsafe;

/**
 * @author syj
 * @date 2024/8/4 17:25
 */

/**
 * 无限睡眠，程序阻塞执行
 */
public class SleepError {
    public static void main(String[] args) throws InterruptedException {
        long ONE_HOUR = 60 * 60 * 1000L;
        Thread.sleep(ONE_HOUR);
        System.out.println("我睡着了");
    }
}
