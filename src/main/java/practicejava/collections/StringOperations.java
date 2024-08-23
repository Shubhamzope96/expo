package practicejava.collections;

import java.util.HashSet;
import java.util.Set;

public class StringOperations {

	public static void main(String [] args) {
		
		
		String a= new  String("ShubhamZope");
		String b= new  String("ShubhamZope");
		String c="Ritesh";
		String d=a;
		String e ="    adhhjsjdjdhhjhdsf   ";
		System.out.println(a==b);
		System.out.println(a==d);
		System.out.println(a.equals(b));
		System.out.println(a.equals(d));
		System.out.println(a.compareTo(b));
		System.out.println(a.concat(" Zope"));
		System.out.println(a.contains("uabh"));
		System.out.println(a.contentEquals("ubh"));
		System.out.println(a.endsWith("am"));
		System.out.println(a.indexOf("m"));
		System.out.println(e.isBlank());
		System.out.println(e.isEmpty());
		System.out.println(a.lastIndexOf("h"));
		System.out.println(e.replaceFirst("dhh", "xxx"));
		System.out.println(e.strip());
		System.out.println(b.substring(1, 3));
		
		int aa=40;
		int bb= 50;
		int cc = 30;
		
		if(aa>bb) {
			if(aa>cc) {
				System.out.println(aa);
			}else
				System.out.println(cc);
		}else { 
			if(bb>cc) {
				System.out.println(bb);
			}else
				System.out.println(cc);
		}
		int answer = (aa>bb)?((aa>cc)?aa:cc):((bb>cc)?bb:cc);
		System.out.println(answer);
		
		StringBuffer sbf = new StringBuffer("java is my life. java is my passion");
		System.out.println("aa");
		
		String jb = "a";
		System.out.println(jb.hashCode());
		System.out.println(jb.hashCode());
		jb="ab";
		System.out.println(jb.hashCode());
		
		System.out.println(sbf.capacity());
		System.out.println(sbf.reverse());

	}
	
	//charAt(index)- returns character at perticular index
	//compareTo(b)- returns 0 if identical if a is  shorter returns -ve else +ve
	//concat(string)- appends to the referencing string
	//contains(string)- returns true if contains given string characters in sequence
	//endsWith(str)- returns true if string ends with given literal
	//indexOf(str)- returns start index of given string in string
	//isBlank()- returns true is spring contains no char or white space only
	//isEmpty()- returns true if it do not contain even white space
	//lastIndexOf(char)-
	//length()- returns length
	//replace(old char sequence, new char sequence)- replaces all the old characters sequence
	//replaceFirst(regex, new str)- replaces first occurance 
	//split(str)- splits and returns array of elements
	//startsWith- returns true/false
	//strip()- returns string removing starting and trailing white space
	//stripLeading()- removes begining white spaces
	//stripTrailing()- removes end white spaces;
	//substring(start index)
	//substring(start index , end index); skipping end index
	//toCharArray()- return char array
	//toLowerCase()
	//toUpperCase()
	//trim()- same as strip
	
	
	
}
