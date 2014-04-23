package twitter_sentimental_analysis;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
public class bing_api_usage {

	public static String translate(String text,String source,String dest) throws Exception
	{
		// Set your Windows Azure Marketplace client info - See http://msdn.microsoft.com/en-us/library/hh454950.aspx
		Translate.setClientId(" Enter your Windows Azure Client Id here"); 
		Translate.setClientSecret(" Enter your Windows Azure Client Secret here ");
		String translatedText = Translate.execute(text, Language.fromString(source), Language.fromString(dest));
		// Translate.execute("hello", "en", "nl");
		//System.out.println(translatedText);
		return translatedText;
	}
	
	

}
