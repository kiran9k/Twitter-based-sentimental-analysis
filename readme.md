###################################################################################################

					SENTIMENTAL ANALYSIS OF TWEETS
	
###################################################################################################


OBJECTIVE : 


- Seacrh for tweets of any kind(brand,company,product,etc) . Know what common people have to say about it !


HOW IT WORKS ? : 

- user enters the keyword to search .

- since tweets can be of any language , as of now, only English , Russian ,French ,Spanish , Bulgarian ,Hindi is supported .

- translate non -english tweets to english 

- uses Bing API for translation 

- get the translated text of tweets .

- pass the text for sentimental analysis .

- evaluate the sentiment based on the score . 

- write the result to file 

- The file would contain : tweet id ,tweet owners name ,Orignal tweet text , sentimental result .




API's REQUIRED :

- Bing translation API

- Twitter API




FEATURES:

- know what common people think about your product

- option to filter the product search by giving suitable keywords

- option to search tweets from or to a particular user

- Limit a count value for number of tweets to be processed .

- FREE to use


LIMITATION :

- Bing API has free usage of upto 2M char/month . Beyond that is chargable .

- Twitter API has window size of  15 min . One can process only 180 search call every 15 min . 

