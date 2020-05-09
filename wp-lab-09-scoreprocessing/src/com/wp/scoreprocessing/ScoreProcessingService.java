package com.wp.scoreprocessing;

public class ScoreProcessingService {
	public ScoreDO processScores(String[] scores) {
		if (scores == null || scores.length == 0)
			return null;
		
		ScoreDO scoreDO = new ScoreDO();

		int sum = 0;
		int squareSum = 0;
		int count = scores.length;
		int[] scoreNums = new int[count];
		for (int i=0; i<count; i++) {
			int score = Integer.parseInt(scores[i]);
			sum += score;
			squareSum += score * score;
			scoreNums[i] = score;
		}
		
		scoreDO.setScores(scoreNums);
		scoreDO.setSum(sum);
		
		double mean = ((double)sum) / count;
		scoreDO.setMean(mean);
		scoreDO.setStdDev(Math.sqrt((((double)squareSum)/count) - (mean * mean)));		
		
		return scoreDO;
	}
}
