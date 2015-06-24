package teacher;

import java.util.ArrayList;

public class Calc implements Runnable {
	private int avg;
	private int currentSum;
	private Transcript transc;	
	private int currentIndex=0;
	
	public Calc(Transcript t){
		transc = t;
	}
	
	int getAvg(){
		return avg;
	}
	
	@Override
	public void run() {

		while(true){
			currentSum = transc.getGrades().stream().reduce(0, (total, e) -> total+e);
			ArrayList<Integer> grades = transc.getGrades();
			avg = grades.isEmpty() ? 0 : currentSum/grades.size();
			System.out.println(avg);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
