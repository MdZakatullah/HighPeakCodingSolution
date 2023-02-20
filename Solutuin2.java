package highPeakSolution;

import java.util.Arrays;
import java.util.Scanner;

public class Solutuin2 {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the number of jobs");
		int job=scn.nextInt();
		System.out.println("Enter job start time, end time and earnings");
		int n=scn.nextInt();
		
		
	}

	
	
	class Job{
		int start, end, profit;

		 Job(int start, int end, int profit) {
			this.start = start;
			this.end = end;
			this.profit = profit;
		}
		
	}
	
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n=profit.length;
		Job []jobs=new Job[n];
		for(int i=0; i<n; i++) {
		}
		
		Arrays.sort(jobs, (a,b) -> (a.end-b.end));
		
		int dp[]=new int [n];
		dp[0]=jobs[0].profit;
		
		for(int i=1; i<n; i++) {
			
			dp[i]=Math.max(dp[i-1], jobs[i].profit);
			for(int j=1; j>=0; j--) {
				if(jobs[j].end<=jobs[i].start) {
					dp[i]=Math.max(dp[i], jobs[i].profit+dp[j]);
					break;
				}
			}
			
		}
		return dp[n-1];
	}

}
