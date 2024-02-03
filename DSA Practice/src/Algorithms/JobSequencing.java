package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Job implements Comparable<Job> {
    String id;
    int deadline;
    int profit;

    public Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public int compareTo(Job other) {
        return Integer.compare(other.profit, this.profit);
    }
}

public class JobSequencing {

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
//        jobs.add(new Job("Job1", 3, 2));
//        jobs.add(new Job("Job2", 3, 4));
//        jobs.add(new Job("Job3", 3, 3));
//        jobs.add(new Job("Job4", 4, 1));
//        jobs.add(new Job("Job4", 4, 10));


        jobs.add(new Job("Job1", 5, 200));
        jobs.add(new Job("Job2", 3, 180));
        jobs.add(new Job("Job3", 3, 190));
        jobs.add(new Job("Job4", 2, 300));
        jobs.add(new Job("Job5", 4, 120));
        jobs.add(new Job("Job6", 2, 100));

        List<String> scheduledJobs = new ArrayList<>();
        int maxProfit = jobSequencingWithMaxProfit(jobs, scheduledJobs);
        //System.out.println("Scheduled Jobs: " + scheduledJobs);
        System.out.println("Maximum Profit: " + maxProfit);
    }

    public static int jobSequencingWithMaxProfit(List<Job> jobs, List<String> scheduledJobs) {
        Collections.sort(jobs);

        // calculate the maxDeadline in order to determine the array length
        int maxDeadline = jobs.stream().mapToInt(job -> job.deadline).max().orElse(0);

        int[] timeSlots = new int[maxDeadline + 1];
        int totalProfit = 0;


        // select the job, be being greedy about profit, i.e pick the job with highest profit first and place it as close as possible to the deadline mentioned.
        for (Job job : jobs) {
            int deadline = job.deadline;

            //findling the empty slot from the right(as close as possible)
            while (deadline > 0 && timeSlots[deadline] != 0) {
                deadline--;
            }

            if (deadline > 0) {
                scheduledJobs.add(job.id);
                timeSlots[deadline] = 1;
                totalProfit += job.profit;
            }
        }

        return totalProfit;
    }
}
