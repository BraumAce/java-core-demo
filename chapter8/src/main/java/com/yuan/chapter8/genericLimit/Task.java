package com.yuan.chapter8.genericLimit;

/**
 * 取消对检查型异常的检查 <p>
 * 提供一个从 Task 到 Runnable 的适配器，可以抛出任意的异常
 */
public interface Task {

    void run() throws Exception;

    @SuppressWarnings("unchecked")
    static <T extends Throwable> void throwAs(Throwable t) throws T {
        throw (T) t;
    }

    static Runnable asRunnable(Task task) {
        return () -> {
            try {
                task.run();
            } catch(Exception e) {
                Task.<RuntimeException>throwAs(e);
            }
        };
    }
}
