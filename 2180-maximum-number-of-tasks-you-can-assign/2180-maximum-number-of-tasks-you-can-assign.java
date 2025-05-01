public class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0, right = Math.min(tasks.length, workers.length);

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canFinish(mid, tasks, workers, pills, strength)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canFinish(int mid, int[] tasks, int[] workers, int pills, int strength) {
        Deque<Integer> queue = new ArrayDeque<>();
        int i = 0;
        int taskIndex = 0;

        for (int j = workers.length - mid; j < workers.length; j++) {
            int w = workers[j];

            while (taskIndex < mid && tasks[taskIndex] <= w + strength) {
                queue.addLast(tasks[taskIndex]);
                taskIndex++;
            }

            if (queue.isEmpty()) return false;

            if (queue.peekFirst() <= w) {
                queue.pollFirst();
            } else {
                if (pills == 0) return false;
                pills--;
                queue.pollLast();
            }
        }

        return true;
    }
}
