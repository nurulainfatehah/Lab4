
public class WordCounter {

	private String text;
	private int word;
	
	public void setText(String text) {
		
		this.text = text;
		
		char ch[]= new char[text.length()];     
        for(int i=0;i<text.length();i++)  
        {  
            ch[i]= text.charAt(i);  
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                word++;  
        }  
		
	}
	
	public int getWordCount(){
						
		return word;
	}
}
