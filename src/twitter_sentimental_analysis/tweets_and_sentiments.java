package twitter_sentimental_analysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tweets_and_sentiments {

	public static void write_to_file(String content,String filename,Boolean flag)
	{
		try {			 
			//String content = "This is the content to write into file"; 
			File file = new File(filename);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			} 
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),flag);
			// if you want to append to existing file:
			//FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close(); 
			System.out.println("Done"); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// get keywords from user 
		// get corresponding tweets 
		// fetch only tweets with lang= en
		// pass those tweets to sentimental anlysis tool 
		// return result 
		// write  to file result (optional)
		String keywords="#KFC";
		ArrayList<String> tweet_text=new ArrayList<String>();
		ArrayList<String> tweet_id=new ArrayList<String>();
		ArrayList<String> tweet_name=new ArrayList<String>();
		ArrayList<String> original_tweet=new ArrayList<String>();
		twitter_api.search_tweets(keywords, tweet_text, tweet_id, tweet_name,original_tweet);
		
		float result=2;
		String line="";
		String sentiment="";
		for(int i=0;i<tweet_text.size();i++)
		{
			line=tweet_text.get(i);
			Pattern p1=Pattern.compile(".*(\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])+.*");
			Matcher m;
			do
			{
			m=p1.matcher(line);
			if(m.matches())
			{			
				line=line.replaceAll(m.group(1),"");
			}
			}while(m.matches());
			result=sentimental_analysis.sentiment_analysis(tweet_text.get(i));
			System.out.println(line);
			System.out.println(original_tweet.get(i));
			System.out.println(result);
			if(result==0)
			{
				sentiment ="Neutral";
			}
			if(result<0)
				sentiment ="Negative";
			if(result>0)
				sentiment ="Positive";
			write_to_file(tweet_id.get(i)+"\t"+tweet_name.get(i)+"\t"+original_tweet.get(i).replaceAll("\n", " ")+"\t"+result+"\t"+sentiment+"\n","result.txt",true);
		}
		
	}

}
