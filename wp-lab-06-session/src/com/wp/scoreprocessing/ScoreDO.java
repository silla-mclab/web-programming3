package com.wp.scoreprocessing;

public class ScoreDO {
	private String[] scores = null;
	private int sum;
	private double mean;
	private double stdDev;

	public String[] getScores() {
		return scores;
	}
	
	public void setScores(String[] scores) {
		this.scores = scores;
	}
	
	public int getSum() {
		return sum;
	}
	
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public double getMean() {
		return mean;
	}
	
	public void setMean(double mean) {
		this.mean = mean;
	}
	
	public double getStdDev() {
		return stdDev;
	}
	
	public void setStdDev(double stdDev) {
		this.stdDev = stdDev;
	}
}
