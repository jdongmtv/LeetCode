import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	
	public static void main(String[] args) {
		Date date;
		try {
			String original = "2014-04-27T18:00:00Z";
			int  index = original.indexOf("T");
			original = original.substring(0,index);
			date = new SimpleDateFormat("yyyy-MM-dd").parse(original);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy");
			System.err.println(simpleDateFormat.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
