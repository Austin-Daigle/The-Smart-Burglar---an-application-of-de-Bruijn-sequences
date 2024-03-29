# <a name = "top"></a> The Smart Burglar: an application of De Bruijn sequences

This project was orignally designed and writtein in Fall 2020.

## Table Of Contents:
*  [Abstract](#abstract)
*  [Introduction](#intro)
*  [Background](#background)
*  [Pseudocode](#pseudocode)
*  [The Original Algorithm](#algorithm)
*  [The Java Program](#javaprogram)
*  [The 10,003 Digits](#10003Digits)
*  [Conclusion (tl;dr)](#conclusion)
*  [Works Cited](#workscited)



##  <a name="abstract"></a>Abstract:
This project's focus is to develop an algorithmic process to create a string of 10,003 numerical characters that tests all possible combinations on a four-digit (zero through nine) electronic combination lock. The advantage of this process would save an enormous amount of time when testing hardware or gaining unauthorized access into secured equipment or locations; because, instead of entering 40,000 characters to test all 10,000 possible combinations, you would instead only need to enter 10,003 characters; thus, increasing your efficiency by nearly three-fold (Berry).

[Back to top](#top)

## <a name="intro"></a>Introduction:

The hypothetical prompt that inspired the need for the algorithmic process mentioned above is called “The Clever Burglar.” The premise of “The Clever Burglar” is that a burglar is attempting to enter a hotel room. However, the aforementioned room has a combination (zero through nine) on the door that requires the correct four-digit combination to grant access
The burglar wishing to enter the room wants a sequence of numerical characters that tests all possible combinations on the lock. It is important to note that in this hypothetical scenario, the combination lock mentioned (unlike modern combination locks) does not require the user to press an “enter” key; It does not disable itself after an amount of failed attempts, or alert security, or set off an alarm, Most importantly, it does not automatically clear all of its memory when the entered digits exceed the four-digit memory limit.

Alternatively, the way the memory in this lock works is that when a new digit is entered into memory (after already having four digits entered), the first digit to be entered gets deleted, and the current values in memory shift over to the left by one space. This feature (or rather a massive flaw) allows for an individual to test multiple combinations for each digit entered after the first four digits; this condition allows for an algorithm to be made to exploit this flaw.

The algorithm that will be used to solve this problem is called the De Bruijn Sequence, a De Bruijn sequence is a sequence in which every feasible length of string-_n_ under the dictionary of _k_ is possible as a continuous sequence, _n_ represents the digit string length allows for the operation while the variable _k_ represents the alphabet of either all supported characters (or in this case a numerical range) (Berry). The sequence contains one instance of each unique combination when a substring is derived from the being index selected and the ending end (the beginning index plus the value of _n_) (please see Table A below view an example of this concept) (Berstel).

![image](https://user-images.githubusercontent.com/100094056/193476310-1226fb66-2db9-4306-9e24-6dfb9ee8f75f.png)

De Bruijn sequences can be synthesized using a variety of algorithms and methods, the most common methods used are the Hamiltonian path, shift registers, the Eulerian cycle, and an Inverted Burrows-Wheelers function. However, the process that was implemented for this development was the Lyndon Words algorithm, this was chosen due to its ability to be relatively efficient yet straightforward (Berry).

A Lyndon Word is a string that is populated (non-empty) and is exactly smaller than all of the lexicographic (or, in this case, the order of a pre-ordered set) of all of the rotations of a given dictionary string (Sawada). The Lyndon Words string will be used to rotate through the dictionary string for this process and then augment the final result to construct the desired De-Bruijn string. The subsequent string can be deconstructed to analyze and verify the result, and in application, fulfill the requirements of solving for all possible combinations (Berstel).

[Back to top](#top)

## <a name="background"></a>Background:
As mentioned above, the Lyndon words algorithm operates on the smallest string object that is lexicographically equivalent to the _k_\-dictionary string. These strings are called “necklaces.” Logically speaking, an aperiodic form of a _necklace_ would equal a _Lyndon word_. The object is to extract the Lyndon Words from the input to generate the De-Bruijn sequence upon each recursion, view Table B and Table C below to see a representation of the process above.

![image](https://user-images.githubusercontent.com/100094056/193476295-3b1924bd-cebd-420b-9c9d-818a9af83c40.png)

![image](https://user-images.githubusercontent.com/100094056/193476331-02e86577-370d-4f85-931a-5c2c37d4ec70.png)


The following theorem was directly referenced from _A fast algorithm to generate necklaces with fixed content_ by Joe Sawada as the referenced core that derived the algorithm that was converted and eventually coded into Java. 

A note for the reader: I do not claim credit for the original algorithm, but instead, I cited the author and source material, and I instead created a derivative adaptation based on the source work, some changes were made from the original function and the Java adaption to correct for the limitation and nuances within the Java programming language.

![image](https://user-images.githubusercontent.com/100094056/193476484-c7834223-48b3-4877-a192-e510fd76f096.png)

Using the algorithm given from the reference above, it is possible to convert it to a recursive algorithmic runtime with similar variables to the original theorem (Sawada). The method shown above can be described as a statement of: if α is representative of a pre-necklace with the function of _p = lyn(α)_, then α can be necklace if it has a _n modulus_ of _p_ that is equivalent to zero and it shares the relation of _n_ is directly equal to _p_ concurrently; then _theorem 1_ from above can be said to be true, and the necklace (or selected characters) can be added or printed out to the sequence. The string object (or array object) remains constant, assuming the dictionary (k-value) remains constant for the purpose of alternation and computation. _Theorem 1_, in application, will recurse multiple times until each subroutine is complete without anymore stack (or user) recursion calls to itself; this function does not feature “break” statements or user-stop base cases in this algorithm to terminate this process.

Below is the adapted pseudocode from the first revision of pseudocode from _Theorem 1_ from the cited text (Sawada); some changes have been made to the pseudocode below to allow for capability with the java adaptation.

[Back to top](#top)

### <a name="pseudocode"></a>Pseudocode adapted from _Theorem 1_
	procedure simpleFixedContent( t, p: integer)
	Local j: integer
	Begin
		If t > n then begin
			If n mod p = 0 then
				Print();
			endIf;
		endIf;
		else begin
			for j ∈ {at-p,…,k-2,k-1} do begin
				at: = j;
				if j := at-p then simpleFixedContent( t + 1 , p );
				endIf;
				else begin simpleFoxedContent( t + 1 , t );
				endElse;
			endFor;
		endElse;
	end;

[Back to top](#top)

## <a name="algorithm"></a>The Original Algorithm:

The algorithm that will be adapted into Java is derived from Theorem 1 (see above) with a few modifications (further modifications will be taken to necessitate the conversion to Java). This algorithm's primary concept is to repeatedly and recursively extend pre-necklaces until they equal the length of _n_ (Sawada). The pre-necklaces that are not necklaces will not be extended into the final sequence. The general process starts upon execution; local variables and parameters are initialized. The value of _t_ and _p_ are declared to the value of 1 (at they are variables for the purpose of controlling the alternation and assignments of data to/from the pre-necklace object (sized at _n_+1)). The first if statement within the algorithm evaluates whether the value of _t_ is greater than the value of _a.length-1_ (one minus the pre-necklace object); when true, then a second if statement is evaluated. The second if statement checks to see if the value of the modulus of (_a.length-1_) and _p_ equals zero, if true, then for every value from 1 to (_p+1_) append the final output by the given character present in _a_ at the value of the for loop at that iteration.

If the root if statement evaluates to false, then the else statement will execute the following process: change the current numerical value at index value _t_ in the object _a_ to the current value index value of _t-p_ in _a_ (this part is one section that changes the value in the pre-necklace object for the sake of rotation)_,_ then call a recursion of the algorithm with all of the current value but augment the value of _t_ by 1, then for each value between ((the current numerical value of _a_ at the index of _t-p_) plus 1) to _k-1_: change the present value of _a_ at the index of the value of _j_ and also recurse the whole algorithm but with the value of _t_ incremented by 1. This algorithm terminates when each “parent” and “child” execute and complete their respective subroutines to completion until no other recursions are called, and all called processes are exhausted (Sawada).

On a final note with the final Java adaption, the primary change that was implemented to make the function work was to have a post-process subroutine that adds _n-2_ zeroes to the end of the De Bruijn sequence to complete the “rollover.” Other changes were slight changes to the recursion calls, objects/variables used (to get around Java object limits), and a validation routine that cross-references all of the possible combinations to the Da-Bruijn (this is only enabled in the _n­_ = 4 and _k_ = 10 demo) and prints the final result.

[Back to top](#top)

## <a name="javaprogram"></a>The Java Program: TheCleverBurglar.java:
Source Code: [TheCleverBurglar.java](https://github.com/Austin-Daigle/The-Smart-Burglar---an-application-of-de-Bruijn-sequences/blob/main/TheCleverBurglar.java)

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
					System.out.println("The De-Bruijn Sequence has been generated and verified "
					+"to match all of the combinations:");
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

[Back to top](#top)

## <a name="10003Digits"></a>The 10,003 Digits:

	0000100020003000400050006000700080009001100120013001400150016001700180019002100220023002400250026002700280029003100320033003400
	3500360037003800390041004200430044004500460047004800490051005200530054005500560057005800590061006200630064006500660067006800690
	0710072007300740075007600770078007900810082008300840085008600870088008900910092009300940095009600970098009901010201030104010501
	0601070108010901110112011301140115011601170118011901210122012301240125012601270128012901310132013301340135013601370138013901410
	1420143014401450146014701480149015101520153015401550156015701580159016101620163016401650166016701680169017101720173017401750176
	0177017801790181018201830184018501860187018801890191019201930194019501960197019801990202030204020502060207020802090211021202130
	2140215021602170218021902210222022302240225022602270228022902310232023302340235023602370238023902410242024302440245024602470248
	0249025102520253025402550256025702580259026102620263026402650266026702680269027102720273027402750276027702780279028102820283028
	4028502860287028802890291029202930294029502960297029802990303040305030603070308030903110312031303140315031603170318031903210322
	0323032403250326032703280329033103320333033403350336033703380339034103420343034403450346034703480349035103520353035403550356035
	7035803590361036203630364036503660367036803690371037203730374037503760377037803790381038203830384038503860387038803890391039203
	9303940395039603970398039904040504060407040804090411041204130414041504160417041804190421042204230424042504260427042804290431043
	2043304340435043604370438043904410442044304440445044604470448044904510452045304540455045604570458045904610462046304640465046604
	6704680469047104720473047404750476047704780479048104820483048404850486048704880489049104920493049404950496049704980499050506050
	7050805090511051205130514051505160517051805190521052205230524052505260527052805290531053205330534053505360537053805390541054205
	4305440545054605470548054905510552055305540555055605570558055905610562056305640565056605670568056905710572057305740575057605770
	5780579058105820583058405850586058705880589059105920593059405950596059705980599060607060806090611061206130614061506160617061806
	1906210622062306240625062606270628062906310632063306340635063606370638063906410642064306440645064606470648064906510652065306540
	6550656065706580659066106620663066406650666066706680669067106720673067406750676067706780679068106820683068406850686068706880689
	0691069206930694069506960697069806990707080709071107120713071407150716071707180719072107220723072407250726072707280729073107320
	7330734073507360737073807390741074207430744074507460747074807490751075207530754075507560757075807590761076207630764076507660767
	0768076907710772077307740775077607770778077907810782078307840785078607870788078907910792079307940795079607970798079908080908110
	8120813081408150816081708180819082108220823082408250826082708280829083108320833083408350836083708380839084108420843084408450846
	0847084808490851085208530854085508560857085808590861086208630864086508660867086808690871087208730874087508760877087808790881088
	2088308840885088608870888088908910892089308940895089608970898089909091109120913091409150916091709180919092109220923092409250926
	0927092809290931093209330934093509360937093809390941094209430944094509460947094809490951095209530954095509560957095809590961096
	2096309640965096609670968096909710972097309740975097609770978097909810982098309840985098609870988098909910992099309940995099609
	9709980999111121113111411151116111711181119112211231124112511261127112811291132113311341135113611371138113911421143114411451146
	1147114811491152115311541155115611571158115911621163116411651166116711681169117211731174117511761177117811791182118311841185118
	6118711881189119211931194119511961197119811991212131214121512161217121812191222122312241225122612271228122912321233123412351236
	1237123812391242124312441245124612471248124912521253125412551256125712581259126212631264126512661267126812691272127312741275127
	6127712781279128212831284128512861287128812891292129312941295129612971298129913131413151316131713181319132213231324132513261327
	1328132913321333133413351336133713381339134213431344134513461347134813491352135313541355135613571358135913621363136413651366136
	7136813691372137313741375137613771378137913821383138413851386138713881389139213931394139513961397139813991414151416141714181419
	1422142314241425142614271428142914321433143414351436143714381439144214431444144514461447144814491452145314541455145614571458145
	9146214631464146514661467146814691472147314741475147614771478147914821483148414851486148714881489149214931494149514961497149814
	9915151615171518151915221523152415251526152715281529153215331534153515361537153815391542154315441545154615471548154915521553155
	4155515561557155815591562156315641565156615671568156915721573157415751576157715781579158215831584158515861587158815891592159315
	9415951596159715981599161617161816191622162316241625162616271628162916321633163416351636163716381639164216431644164516461647164
	8164916521653165416551656165716581659166216631664166516661667166816691672167316741675167616771678167916821683168416851686168716
	8816891692169316941695169616971698169917171817191722172317241725172617271728172917321733173417351736173717381739174217431744174
	5174617471748174917521753175417551756175717581759176217631764176517661767176817691772177317741775177617771778177917821783178417
	8517861787178817891792179317941795179617971798179918181918221823182418251826182718281829183218331834183518361837183818391842184
	3184418451846184718481849185218531854185518561857185818591862186318641865186618671868186918721873187418751876187718781879188218
	8318841885188618871888188918921893189418951896189718981899191922192319241925192619271928192919321933193419351936193719381939194
	2194319441945194619471948194919521953195419551956195719581959196219631964196519661967196819691972197319741975197619771978197919
	8219831984198519861987198819891992199319941995199619971998199922223222422252226222722282229223322342235223622372238223922432244
	2245224622472248224922532254225522562257225822592263226422652266226722682269227322742275227622772278227922832284228522862287228
	8228922932294229522962297229822992323242325232623272328232923332334233523362337233823392343234423452346234723482349235323542355
	2356235723582359236323642365236623672368236923732374237523762377237823792383238423852386238723882389239323942395239623972398239
	9242425242624272428242924332434243524362437243824392443244424452446244724482449245324542455245624572458245924632464246524662467
	2468246924732474247524762477247824792483248424852486248724882489249324942495249624972498249925252625272528252925332534253525362
	5372538253925432544254525462547254825492553255425552556255725582559256325642565256625672568256925732574257525762577257825792583
	2584258525862587258825892593259425952596259725982599262627262826292633263426352636263726382639264326442645264626472648264926532
	6542655265626572658265926632664266526662667266826692673267426752676267726782679268326842685268626872688268926932694269526962697
	2698269927272827292733273427352736273727382739274327442745274627472748274927532754275527562757275827592763276427652766276727682
	7692773277427752776277727782779278327842785278627872788278927932794279527962797279827992828292833283428352836283728382839284328
	4428452846284728482849285328542855285628572858285928632864286528662867286828692873287428752876287728782879288328842885288628872
	8882889289328942895289628972898289929293329342935293629372938293929432944294529462947294829492953295429552956295729582959296329
	6429652966296729682969297329742975297629772978297929832984298529862987298829892993299429952996299729982999333343335333633373338
	3339334433453346334733483349335433553356335733583359336433653366336733683369337433753376337733783379338433853386338733883389339
	4339533963397339833993434353436343734383439344434453446344734483449345434553456345734583459346434653466346734683469347434753476
	3477347834793484348534863487348834893494349534963497349834993535363537353835393544354535463547354835493554355535563557355835593
	5643565356635673568356935743575357635773578357935843585358635873588358935943595359635973598359936363736383639364436453646364736
	4836493654365536563657365836593664366536663667366836693674367536763677367836793684368536863687368836893694369536963697369836993
	7373837393744374537463747374837493754375537563757375837593764376537663767376837693774377537763777377837793784378537863787378837
	8937943795379637973798379938383938443845384638473848384938543855385638573858385938643865386638673868386938743875387638773878387
	9388438853886388738883889389438953896389738983899393944394539463947394839493954395539563957395839593964396539663967396839693974
	3975397639773978397939843985398639873988398939943995399639973998399944445444644474448444944554456445744584459446544664467446844
	6944754476447744784479448544864487448844894495449644974498449945454645474548454945554556455745584559456545664567456845694575457
	6457745784579458545864587458845894595459645974598459946464746484649465546564657465846594665466646674668466946754676467746784679
	4685468646874688468946954696469746984699474748474947554756475747584759476547664767476847694775477647774778477947854786478747884
	7894795479647974798479948484948554856485748584859486548664867486848694875487648774878487948854886488748884889489548964897489848
	9949495549564957495849594965496649674968496949754976497749784979498549864987498849894995499649974998499955556555755585559556655
	6755685569557655775578557955865587558855895596559755985599565657565856595666566756685669567656775678567956865687568856895696569
	7569856995757585759576657675768576957765777577857795786578757885789579657975798579958585958665867586858695876587758785879588658
	8758885889589658975898589959596659675968596959765977597859795986598759885989599659975998599966667666866696677667866796687668866
	8966976698669967676867696777677867796787678867896797679867996868696877687868796887688868896897689868996969776978697969876988698
	9699769986999777787779778877897798779978787978887889789878997979887989799879998888988998989999000

[Back to top](#top)

## <a name = "conclusion"></a>Conclusion:

The hypothetical burglar must compile and execute [TheCleverBurglar.java](https://github.com/Austin-Daigle/The-Smart-Burglar---an-application-of-de-Bruijn-sequences/blob/main/TheCleverBurglar.java) and would haft to record the 10,003 digits from the program output. The burglar would approach the keypad and enter the 10,003 digits in a continuous stream (a significant improvement over 40,000 digits), and then the keypad lock will open for the burglar. 

[Back to top](#top)

## <a name="workscited"></a>Works Cited:

NOTE: all of these sources are also available in this [repo directory](https://github.com/Austin-Daigle/The-Smart-Burglar---an-application-of-de-Bruijn-sequences/tree/main/Backed%20Up%20Sources) as .pdf in case these websites go offline.

Berry, Nick. De Bruijn Sequences, DataGenetics, 2013, [https://datagenetics.com/blog/october22013/index.html](https://datagenetics.com/blog/october22013/index.html).

Berstel, Jean, and Dominique Perrin. “The Origins of Combinatorics on Words.” European Journal of Combinatorics, Academic Press, 15 Dec. 2005,   [www.sciencedirect.com/science/article/pii/S0195669805001629](https://www.sciencedirect.com/science/article/pii/S0195669805001629).

Sawada, Joe. A Fast Algorithm to Generate Necklaces with Fixed Content. CORE, Department of Computer Science, University of Toronto, 2003, [core.ac.uk/reader/82247950](https://core.ac.uk/outputs/82247950).

[Back to top](#top)
