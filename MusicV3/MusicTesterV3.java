
/**
 * Write a description of class MusicTester here.
 *
 * @author (Murali Lingamsetty)
 * @version (3/6/2022)
 */
public class MusicTesterV3
{

//Origianl Methods
public static void displayMusic(MusicV3 [] sList){
      System.out.printf("%-25s %4s   %-20s%n", "Title", "Year", "Artist");
      for(MusicV3 s: sList){
            System.out.println(s);
        }
    } 

public static void getTitle(MusicV3[] source)
    {
       int i;
       int j;
       int position;
       MusicV3 temp;
        for ( i = source.length - 1 ; i >= 0 ; i-- )
        {
            position = 0;
            for ( j = 0 ; j <= i ; j++ )
            {
                if ( source[ j ].getTitle().compareTo(source[ position ].getTitle()) > 0)
                    position = j;
            }
            temp = source[ i ];
            source[ i ] = source[position ];
            source[ position ] = temp;
        }   
       }

public static void getYear(MusicV3[] source)
    {
       int i;
       int j;
       int position;
       MusicV3 temp;
       
        for ( i = source.length - 1 ; i >= 0 ; i-- )
        {
            position = 0;
            for ( j = 0 ; j <= i ; j++ )
            {
                if ( source[ j ].getYear() > source[ position ].getYear() )
                    position = j;
            }
            temp = source[ i ];
            source[ i ] = source[position ];
            source[ position ] = temp;
        }   
       }
    
public static void  getArtist(MusicV3[] source)
    {
      int i;
      int j;
      int position;
      MusicV3 temp;
        
        for ( i = source.length - 1 ; i >= 0 ; i-- )
        {
            position = 0;
            for ( j = 0 ; j <= i ; j++ )
            {
                if ( source[ j ].getArtist().compareTo(source[ position ].getArtist()) > 0)
                    position = j;
            }
            temp = source[ i ];
            source[ i ] = source[position ];
            source[ position ] = temp;
       }
      }    

      
//Binary method of searching for song titles      
public static void binarySearchTitle(MusicV3[] m, String toFind)
 {
  int max = m.length;
  int min = -1;
  int search;

  while( max - min > 1 )
  {
  search = (( max + min ) / 2);
  if( m[search].getTitle().compareTo(toFind) > 0)
  max = search;
  else
  min = search;
  }
  if( (min >= 0) && (m[min].getTitle().compareTo(toFind) == 0 ))
    System.out.print(m[min]);
  else
   System.out.print("Not in List");
  }
  
  
//Binary method of searching for song year   
public static void binarySearchYear(MusicV3[] m, int toFind)
{
   int max = m.length;
   int min = -1;
   int search;

   while( max - min > 1 )
   {
   search = ( max + min ) / 2;

   if(m[search].getYear() > toFind)
   max = search;
   else
   {
   min = search;
   if( m[search].getYear() == toFind)
   {
   break;
    }
   }
  }

   if( (min >= 0) && (m[min].getYear() == toFind))
  {
  linearPrintYear(m, min, toFind);
  }
  else
  System.out.println("NOT found: " + toFind);
}
  

//Binary method of searching for song artist
public static void binarySearchArtist(MusicV3[] m, String toFind)
{
   int max = m.length;
   int min = -1;
   int search;

   while( max - min > 1 )
   {
   search = ( max + min ) / 2;

   if(m[search].getArtist().compareTo(toFind) > 0)
   max = search;
   else
   {
   min = search;
   if( m[search].getArtist().compareTo(toFind) == 0)
   {
   break;
    }
   }
  }

   if( (min >= 0) && (m[min].getArtist().compareTo(toFind) == 0 ))
  {
  linearPrintArtist(m, min, toFind);
  }
  else
  System.out.println("NOT found: " + toFind);
}

//find matches and print out matches based on year
public static void linearPrintYear(MusicV3[] m, int min, int toFind)
{
  int i;
  int start = min;
  int end = min;

  // find the starting point of match
  i = min - 1;
  while((i >= 0) && (m[i].getYear() == toFind))
  { 
  start = i;
  i--;
  }
  // find the end point of match
  i = min + 1;
  while((i < m.length) && (m[i].getYear() ==  toFind))
  {
  end = i;
  i++;
  }
  // print out the match
  for(i = start; i <= end; i++)
  System.out.println(m[i]);
}

//Find the matches and print out matches based on artist
public static void linearPrintArtist(MusicV3[] m, int min, String toFind)
{
   int i;
   int start = min;
   int end = min;

   // find the starting point of match
   i = min - 1;
   while((i >= 0) && (m[i].getArtist().compareTo(toFind) == 0))
   {
   start = i;
   i--;
  }
  // find the end point of match
  i = min + 1;
  while((i < m.length) && (m[i].getArtist().compareTo(toFind) == 0))
   {
   end = i;
   i++;
  }
  // print out the match
  for(i = start; i <= end; i++)
  System.out.println(m[i]);
}
   
public static void main(String[] args){
        MusicV3[] songs = new MusicV3[10];
        
        songs[0] = new MusicV3("Radioactive", 2012, "Imagine Dragons");
        songs[1] = new MusicV3("Fireball", 2014, "Pitbull");
        songs[2] = new MusicV3("Believer", 2017, "Imagine Dragons");
        songs[3] = new MusicV3("Counting Stars", 2013, "Jay Sean");
        songs[4] = new MusicV3("Treasure", 2012, "Bruno Mars");
        songs[5] = new MusicV3("Glad you came", 2013, "Maroon 5");
        songs[6] = new MusicV3("Best Day of My Life", 2014, "American Authors");
        songs[7] = new MusicV3("Centuries", 2014, "Fall Out Boy");
        songs[8] = new MusicV3("Pompeii", 2013, "Bastille");
        songs[9] = new MusicV3("Moves Like Jagger", 2010, "Maroon 5");
        
        //Original details
        System.out.printf("TOP 10 SONGS ON TRENDING %n%n");
        displayMusic(songs); 
        
        //Seeing if specific song is there eventhough its on the list
        System.out.printf("%nIs The track Believer in the chart %n");
        getTitle(songs);
        binarySearchTitle(songs, "Believer");
        
        //seeing if specific song is there eventhough it isnt
        System.out.printf("%nIs the track Get Lucky in the chart %n");
        getTitle(songs);
        binarySearchTitle(songs, "Get Lucky");
        
        //filtering songs based on year
        System.out.printf("%nIs there tracks from the year 2012 %n");
        getYear(songs);
        binarySearchYear(songs, 2012);
        
        //filtering songs based on an unmatched year
        System.out.printf("%nIs there tracks from the year 2011 %n ");
        getYear(songs);
        binarySearchYear(songs, 2011);
        
        //filtering songs based on artist
        System.out.printf("%nIs there artist Bruno Mars?5 %n");
        getArtist(songs);
        binarySearchArtist(songs, "Bruno Mars");
        
        //filtering songs based on artist that isnt there
        System.out.printf("%nIs there artist Taylor Swift%n");
        getArtist(songs);
        binarySearchArtist(songs, "Taylor Swift");
    }
}