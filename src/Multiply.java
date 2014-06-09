
public class Multiply {
	
	  public String multiply(String num1, String num2) {		  
		  if(num1==null || num2==null)
			  throw new NullPointerException();
		  StringBuilder a = new StringBuilder(num1).reverse();
		  StringBuilder b = new StringBuilder(num2).reverse();
		  int[] tmp = new int[a.length()+b.length()];
		  for(int i=0;i<a.length();i++)
			  for(int j=0;j<b.length();j++)
				  tmp[i+j] += (a.charAt(i)-'0')*(b.charAt(j)-'0');
		  int carry = 0;
		  for(int i=0;i<tmp.length;i++) {
			  tmp[i] += carry;
			  carry = tmp[i]/10;
			  tmp[i] = tmp[i]%10;
		  }
		  int i = tmp.length-1;
		  while(i>=0 && tmp[i]==0)
			  --i;
		  StringBuilder result = new StringBuilder();
		  while(i>=0) {
			  result.append(tmp[i--]);
		  }
		  if(result.length()!=0)
		    return result.toString();
		   return "0";
	  }
	  
}
