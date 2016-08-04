package jaaga.arpit.crystalball;

import java.util.Random;

public class CrystalBall {
	
	public String[] mAnswers = new String[]{"It is certain","It is decidely so","All sign say YES",
			"The stars are not aligned","My reply is No","It is doubtful","Better not tell you now",
			"Concentrate and ask again","Unable to answer now","It is hard to say"};
	
	public String getAnswer()
	{
		String answer = "";
		Random randomGenrator = new Random();
		int randomNumber = randomGenrator.nextInt(mAnswers.length);
		//answer = Integer.toString(randomNumber);
		answer = mAnswers[randomNumber];
		return answer;
	}
	

}
