import java.util.ArrayList;

public class smartBurglar {
	public static String makeDeBruijnSequence(int k, int n) 
	{
		 //String builder method is a mutable (read changeable) sequence of characters
		 StringBuilder deBruijnSequenceString = new StringBuilder();
		 synthesizeLyndonWords(1, 1, k, new int[n+1], deBruijnSequenceString);
		 String endingZeroes = "0";
		 for(int i = 0; i < (n-2); i++)
		 {
			 endingZeroes = endingZeroes + "0";
		 }
		 deBruijnSequenceString.append(endingZeroes);
		 return deBruijnSequenceString.toString(); 
	}
	
	public static void createAllCombinations(int k, int n)
	{
		for(int a = 0; a < k; a++)
		{
			for(int b = 0; b < k; b++)
			{
				for(int c = 0; c < k; c++)
				{
					for(int d = 0; d < k; d++)
					{
						allCombinations.add(a+""+b+""+c+""+d);
					}
				}
			}
		}
	}
	
	private static void synthesizeLyndonWords(int t, int p, int k, int[] necklaceArray, StringBuilder deBruijnSequenceString)
	{
		if(t > (necklaceArray.length-1))
		{
			if((necklaceArray.length-1) % p == 0)
			{
				for(int i = 1; i < p+1;i++)
				{
					deBruijnSequenceString.append(necklaceArray[i]);					
				}
			}
		 }
		else 
		{
			necklaceArray[t] = necklaceArray[t-p];
			synthesizeLyndonWords(t+1,p, k, necklaceArray, deBruijnSequenceString);
			for(int j = (necklaceArray[t-p]+1) ; j <= (k-1); j++)
			{
				necklaceArray[t] = j;
				synthesizeLyndonWords(t+1,t, k, necklaceArray, deBruijnSequenceString);
			}
		}
	}
	
	static ArrayList<String> allCombinations = new ArrayList<String>();
	public static void main(String[] args)
	{
		int k = 10;
		int n = 4;
		String deBruijnSequence = makeDeBruijnSequence(k, n);
		if(k == 10 && n == 4)
		{
			createAllCombinations(k,n);
			for(int i = 0; i < deBruijnSequence.length()-3; i++)
			{
				allCombinations.remove(deBruijnSequence.substring(i,i+4));
			}
			if(!(allCombinations.size()==0))
			{
				System.out.println("There are "+allCombinations.size()+" combinations missing:");
				for(int i = 0; i < allCombinations.size(); i++)
				{
					System.out.println(allCombinations.get(i));
				}
			}
			else
			{
				System.out.println("The De-Bruijn Sequence has been generated and verified to match all of the combinations:");
				System.out.println(deBruijnSequence);
			}
		}
		else
		{
			System.out.println("The De-Bruijn Sequence has been generated:");
			System.out.println(deBruijnSequence);
		}
	}
}
