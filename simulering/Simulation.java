

/*
  Modell f�r trafiksimulering
  ===========================

  F�ljande klasser skall anv�ndas: 

     Car representerar fordon
         ankomsttid och destination som s�tts n�r objektet skapas

     Light representerar ljussignaler
         Se nedan
  
     Lane representerar ett v�gavsnitt
         En v�g representeras av en array d�r varje element
	 antingen �r tomt eller inneh�ller en referens till 
         ett bil-objekt.
         OBS: Klassen Lane p�minner om k�mekanismen i f�reg�ende
         uppgift men den skiljer sig ocks� i flera avseende.
         I denna klass st�lls nya bilar i ena �nden av ARRAYEN
         och inte n�rmast efter den som finns d�r. I k�mekanismen        
         var alltid elementen (kunderna) samlade medan bilarna
         i denna klass kan vara utspridda �ver hela arrayen.
         
 
     TrafficSystem
         Definierar de komponeneter dvs de v�gar och signaler
	 som ing�r i systemet. Se vidare nedan

     Simulation
         main-metod som driver simuleringen


  Den situation som skall simuleras ser schematiskt ut enligt



         C           B                               A
       s1<----r1-----<---------r0---------------------
       s2<----r2-----< 


  En fil (v�gstr�cka) r0 delar sig vid B i tv� filer r1 och r2.
  Signal s1 kontrollerar fil r1 och och signal s2 fil r2.
 
  Bilar uppst�r vid A. Sannolikheten att en bil skall komma till A
  vid ett visst tidsteg kallas ankomstintensiteten.

  Vid ett tidssteg r�r sig bilarna ett steg fram�t (om platsen framf�r
  �r ledig). Vid C tas bilarna ut fr�n filerna om repektive
  signal �r gr�n. Vid B tas bilar ut fr�n r0 och l�ggs in p� r1 eller r2
  beroende p� destination (och om platsen �r ledig).

  Anm: Man skulle kunna representera systemet med tv� Lane-objekt
  men d� m�ste man ha n�got s�tt att representera en "avtappning"
  (d�r sv�ngfilen b�rjar). Med den h�r valda representationen
  blir Lane-klassen enklare.  
    
*/





public class Simulation {

    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utf�r stegningen, anropar utskriftsmetoder
    // args skall inneh�lla
    	
    	//int arrivalProb, int turnProb, 
        	//	int lengthTurn, int lengthStart, int period, int green I DEN ORDNINGEN
    	//l�gg in args 6 = s2's gr�ntid
    	//samt args 7 = hur l�nge skall simulationen h�llas
    	//fyll p� med args h�r efter behov
    TrafficSystem	trafficSys = new TrafficSystem(Integer.parseInt(args[0]), 
    		Integer.parseInt(args[1]), Integer.parseInt(args[2]), 
    		Integer.parseInt(args[3]), Integer.parseInt(args[4]), 
    		Integer.parseInt(args[5])
    		);
    
    
    
    // tidsloop
    for(int i = 0; i < Integer.parseInt(args[6]); i++){
    	trafficSys.step();
    	trafficSys.print();
    }

    trafficSys.printStatistics();
	//...

    }
}
