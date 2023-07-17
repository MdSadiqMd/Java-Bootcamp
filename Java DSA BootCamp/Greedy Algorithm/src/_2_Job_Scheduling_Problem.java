import java.util.ArrayList;
import java.util.Collections;

public class _2_Job_Scheduling_Problem {
    char id;
    int deadline, profit;

    public _2_Job_Scheduling_Problem() {}

    public _2_Job_Scheduling_Problem(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    void printjobsequence(ArrayList<_2_Job_Scheduling_Problem> arr, int maxdeadline) {
        int n = arr.size();
        Collections.sort(arr, (a, b) -> b.profit - a.profit);

        boolean result[] = new boolean[maxdeadline];
        char job[] = new char[maxdeadline];

        for (_2_Job_Scheduling_Problem jobProblem : arr) {
            for (int j = Math.min(maxdeadline - 1, jobProblem.deadline - 1); j >= 0; j--) {
                if (!result[j]) {
                    result[j] = true;
                    job[j] = jobProblem.id;
                    break;
                }
            }
        }

        for (char id : job) {
            if (id != 0) {
                System.out.print(id + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<_2_Job_Scheduling_Problem> arr = new ArrayList<>();
        arr.add(new _2_Job_Scheduling_Problem('a', 2, 100));
        arr.add(new _2_Job_Scheduling_Problem('b', 1, 19));
        arr.add(new _2_Job_Scheduling_Problem('c', 2, 27));
        arr.add(new _2_Job_Scheduling_Problem('d', 1, 25));

        int maxdeadline = 2;
        _2_Job_Scheduling_Problem scheduler = new _2_Job_Scheduling_Problem();
        scheduler.printjobsequence(arr, maxdeadline);
    }
}
