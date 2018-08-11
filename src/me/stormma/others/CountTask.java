package me.stormma.others;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 测试Fork/Join框架
 * @author stormma
 * @date 2017/11/29
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 100;

    private int start;

    private int end;

    @Override
    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) <= THRESHOLD;

        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int mid = (start + end) >> 1;
            CountTask leftTask = new CountTask(start, mid);
            CountTask rightTask = new CountTask(mid + 1, end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            // 等到结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            sum = leftResult + rightResult;
        }
        return sum;
    }

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask task = new CountTask(1, 10000);
        Future<Integer> result = pool.submit(task);

        if (!task.isCompletedAbnormally()) {
            System.out.println(result.get());
        }
    }
}
