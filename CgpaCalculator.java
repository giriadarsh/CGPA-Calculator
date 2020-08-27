import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


	public class CgpaCalculator
	{
		public static void main (String args[]) throws FileNotFoundException
		{
			File fp = new File ("C:\\Users\\ADARSH KUMAR\\Desktop\\GradeCard5.txt") ;
			Scanner sc = new Scanner (fp) ;
			ArrayList <String> al = new ArrayList <> () ;
			
			
			System.out.println("Enter total credit of backlogs which you have cleared yet. If no enter 0");
			Scanner in = new Scanner (System.in) ;
			int p = in.nextInt() ;			
			while(sc.hasNext())
			{
				String temp = sc.next() ;
				if(temp.length()==1)
					al.add(temp) ;
			}
			
			sc.close();
			
			String arr [] = new String [al.size()];
			
			arr = al.toArray(arr) ; 
			
			//Iterator <String> itr = al.iterator() ;
			
			ArrayList <String> al1 = new ArrayList <String> () ;
			ArrayList <Integer> al2 = new ArrayList <Integer> () ;
			
			for(int i=0;i<al.size();i++)
			{
				if(arr[i].matches("[0-9]"))
				{
					if(i<al.size()-1 && arr[i+1].matches("[a-zA-Z]"))
					{
						al2.add(Integer.parseInt(arr[i])) ;
						al1.add(arr[i+1]) ;
					}
				}
			}
			
			//System.out.println(al1) ;
			//System.out.println(al2) ;
			
			Iterator <String> i = al1.iterator() ;
			Iterator <Integer> j = al2.iterator() ;
			
			float credit_total =0 ;
			float sum_total = 0 ;
			float credit = 0 ;
			
			while(i.hasNext())
			{
				String tmp = i.next() ;
				int point=0 ;
				
				if(tmp.compareTo("S")==0)
				{
					point = 10 ;
					credit = j.next() ;
				}
				
				if(tmp.compareTo("A")==0)
				{
					point = 9 ;
					credit = j.next() ;
				}
				if(tmp.compareTo("B")==0)
				{
					point = 8 ;
					credit = j.next() ;
				}
				
				if(tmp.compareTo("C")==0)
				{
					point = 7 ;
					credit = j.next() ;
				}
				
				if(tmp.compareTo("D")==0)
				{
					point = 6 ;
					credit = j.next() ;
				}
				
				if(tmp.compareTo("E")==0)
				{
					point = 5 ;
					credit = j.next() ;
				}
				
				if(tmp.compareTo("R")==0)
				{
					point = 4 ;
					credit = j.next() ;
				}
				
				if(tmp.compareTo("F")==0)
				{
					point = 0 ;
					credit = j.next() ;
				}
				
				if(tmp.compareTo("I")==0)
				{
					j.next() ;
					point=0 ;
					credit=0 ;
				}
				
				if(tmp.compareTo("P")==0)
				{
					j.next() ;
					point=0 ;
					credit=0 ;
				}
				
				credit_total += credit ;
				sum_total += point*credit ;	
			}
			
			System.out.println("Cgpa calculated is : "+sum_total/(credit_total-p));
		}
	}
