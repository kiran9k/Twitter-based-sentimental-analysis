package twitter_sentimental_analysis;

import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.SentimentAnnotator;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.TypesafeMap.Key;

public class sentimental_analysis {

	public static float sentiment_analysis(String line)
	{
		//Uses Stanford NLP sentimnet analysis
		//found in latest model released from stanford
		// ver 3.3.1
		//applies sentiment analysis to text 
		
		Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        int mainSentiment = 0;
        int overall=0;
        int sent_count=0;
        if (line != null && line.length() > 0) {
        	int longest = 0;
            Annotation annotation = pipeline.process(line);
            for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            	sent_count++;
            	System.out.println(sentence);            	
            	Tree tree = sentence.get(SentimentCoreAnnotations.AnnotatedTree.class);
                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
                overall+=sentiment-2;
                System.out.println(sentiment);
                String partText = sentence.toString();
                //System.out.println(partText);
                if (partText.length() > longest) {
                    mainSentiment = sentiment;
                    longest = partText.length();
                }
 
            }
        }
        float result=(float)overall/(float)sent_count;
        
        
        return result;
	}

}
