import java.util.ArrayList;

public class NoticeBoard 
{
	ArrayList<String> news_list;
	String incharge_name;

	public NoticeBoard(ArrayList<String> news_list, String incharge_name) 
	{
		this.news_list = news_list;
		this.incharge_name = incharge_name;
	}

	public void display() 
	{	
		System.out.println("=".repeat(30));
		for(int  i = 0; i < news_list.size(); i++) {

			System.out.println("id: " + i);
			System.out.println("content: " + news_list.get(i) + "\n");

		}
		System.out.println("=".repeat(30));
		System.out.println("Incharge Name: " + incharge_name);
	}

	public void addContent(String content) 
	{
		news_list.add(content);
	}
}