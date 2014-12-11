import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.lang.*;
import java.lang.management.*;

public class Daisakusen
{
   
   private static int row = 0, col = 0;
     
   public static Map compile(int row, int col)
   {
      Map s = new Map(row, col);
      return s;
   }
   public static void menu()//Read from file again 
   {
      try
      {
         BufferedReader bf = new BufferedReader(new FileReader("TableRead.txt"));   
         StringBuilder sb = new StringBuilder();
         String read = null;//make new null line
         try
         {
            read = bf.readLine();//read first line
            if(read.length()>5)//if #rows is greater than 9
               row = (Character.getNumericValue(read.charAt(4))*10)+(Character.getNumericValue(read.charAt(5)));
            else row = Character.getNumericValue(read.charAt(4));
            read = bf.readLine();//read second line
            if(read.length()>5)//if #cols is greater than 9
               col = (Character.getNumericValue(read.charAt(4))*10)+(Character.getNumericValue(read.charAt(5)));
            else col = Character.getNumericValue(read.charAt(4));
            
            while(read != null)
            {
               read = bf.readLine();//get ALL possible values left 
            }
         }
         catch(IOException e){System.out.println(e.getMessage());}
         
      }
      catch(FileNotFoundException e){System.out.println(e.getMessage());}
   
   }
   
   public static void menu(String s)//Read from file again, overloaded to add string literal
   {
   
      try
      {
         BufferedReader bf = new BufferedReader(new FileReader(s));   
         StringBuilder sb = new StringBuilder();
         String read = null;//make new null line
         try
         {
            read = bf.readLine();//read first line
            if(read.length()>5)//if #rows is greater than 9
               row = (Character.getNumericValue(read.charAt(4))*10)+(Character.getNumericValue(read.charAt(5)));
            else row = Character.getNumericValue(read.charAt(4));
            read = bf.readLine();//read second line
            if(read.length()>5)//if #cols is greater than 9
               col = (Character.getNumericValue(read.charAt(4))*10)+(Character.getNumericValue(read.charAt(5)));
            else col = Character.getNumericValue(read.charAt(4));
            
            while(read != null)
            {
               read = bf.readLine();//get ALL possible values left 
            }
         }
         catch(IOException e){System.out.println(e.getMessage());}
         
      }
      catch(FileNotFoundException e){System.out.println(e.getMessage());}
   
   }
   
   public static int menuChoice()
   {
      System.out.println("To start the program, please enter your choice from this list\n");
      System.out.println("1 : Read from \"TableRead\".txt file");
      System.out.println("2 : Provide a description of the game.");
      System.out.println("3 : Auto-play the game after reading the \"TableRead\".txt file");
      System.out.println("4 : Pick from one of the tournament boards to auto-solve!");
      System.out.print("\nChoice : ");
      try{
         
         return new Scanner(System.in).nextInt();
      }
      catch(Exception e){
         return 0;}//return a bad value since you can't follow simple directions
      
   }
   
   public static int tourneyChoice()
   {
      System.out.println("Which Tournament Board would you like?\n");
      System.out.println("1  : 5x5 Normal");
      System.out.println("2  : 5x5 Normal");
      System.out.println("3  : 5x5 Hard");
      System.out.println("4  : 5x5 Hard");
      System.out.println("5  : 7x7 Normal");
      System.out.println("6  : 7x7 Normal");
      System.out.println("7  : 7x7 Hard");
      System.out.println("8  : 10x10 Normal");
      System.out.println("9  : 10x10 Hard");
      System.out.println("10 : 15x15 Normal");
      System.out.println("11 : 15x15 Hard");
      System.out.println("12 : 20x20 Normal");
      System.out.println("13 : 20x20 Hard");
      System.out.println("14 : 20x20 Hard");
      System.out.println("15 : 25x30 Hard");
      System.out.print("\nChoice : ");
      try{
         
         return new Scanner(System.in).nextInt();
      }
      catch(Exception e){
         return 0;}//return a bad value since you can't follow simple directions
      
   }
   
   public static boolean playAgain()//After win condition, display this prompt
   {
      System.out.println("Congrats! You won it.");
      System.out.println("\nDo you wish to play again?");
      System.out.print("\nYes/No : ");
      
      String k = new Scanner(System.in).nextLine();
   
      if(k.length() == 0){//if entered nothing
         System.out.println("Just a return-feed character isn't an answer.\nI guess that means you don't want to play again.\n\nBye.");
         return false;
      }
      if(k.charAt(0) == 'y'||k.charAt(0) == 'Y')
         return true;
      else
         if(k.charAt(0) == 'n'||k.charAt(0) == 'N')
         {
            System.out.println("\nAlright. Bye!");
            return false;
         }
         else 
         {
            System.out.println("\nSince you didn't follow instructions and entered something other than what was \nrequested, I guess that means you don't want to play again. Bye.");
            return false;
         }
   }
  
   public static void printMoveList(Map m)
   {
      System.out.println(m.getMoveList());
      try{
         PrintWriter out = new PrintWriter("CurrentMoveList.txt");
         out.println(m.getMoveList());
         out.close();
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Please create a file called CurrentMoveList.txt in the local directory so that the movelist can be saved.");
      }
      
   }

   /** Get CPU time in nanoseconds. */
   public static long getCpuTime() 
   {
      ThreadMXBean bean = ManagementFactory.getThreadMXBean();
      return bean.getCurrentThreadCpuTime();
   }
 
/** Get user time in nanoseconds. */
   public static long getUserTime() 
   {
      ThreadMXBean bean = ManagementFactory.getThreadMXBean();
      return bean.getCurrentThreadUserTime();
   }

/** Get system time in nanoseconds. */
   public static long getSystemTime() 
   {
      ThreadMXBean bean = ManagementFactory.getThreadMXBean();
      return (bean.getCurrentThreadCpuTime() - bean.getCurrentThreadUserTime());
   }
  
   public static void main(String wakuwaku[])
   {
      do{
         int p = menuChoice();
         while(p != 1 && p != 3 && p != 4)          
         {
            if(p == 2)
            {
               System.out.println("\n=== THIS GAME ===");
               System.out.println("Slither's Puzzle Loop is a neat little game that involves");
               System.out.println("you trying to accomplish two things at once: Create a");
               System.out.println("continuous loop, AND have the correct number of lines");
               System.out.println("around each of the numbered tiles. The unnumbered tiles");
               System.out.println("can have 0-3 lines around them, by the way.");
               System.out.println("With this, there are usually very few (most of the time");
               System.out.println("one) solutions that can be attained. You cannot have one");
               System.out.println("and not the other and \"win\" the game. You must have");
               System.out.println("both conditions complete to win! For more information, check the readme.txt.");
               System.out.println("As well, the readme.txt will explain how to work this program.\n");
               System.out.println("Good luck and have fun!\n");
            }
            else System.out.println("\nInvalid choice. Please try again.");
            p = menuChoice();
         }
         Map game = new Map(1,1);//make new map placeholder     
         String s = "";//Holder for our Filename
      
         if(p == 3 || p == 4)
         {
            if(p == 4)
            {
               int gg = tourneyChoice();
            
               switch(gg)
               {
                  case 1:
                     s = "TourneyBoard1.txt";
                     menu(s); 
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 2:
                     s = "TourneyBoard2.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 3:
                     s = "TourneyBoard3.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 4:
                     s = "TourneyBoard4.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 5:
                     s = "TourneyBoard5.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 6:
                     s = "TourneyBoard6.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 7:
                     s = "TourneyBoard7.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 8:
                     s = "TourneyBoard8.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 9:
                     s = "TourneyBoard9.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 10:
                     s = "TourneyBoard10.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 11:
                     s = "TourneyBoard11.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 12:
                     s = "TourneyBoard12.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 13:
                     s = "TourneyBoard13.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                     
                  case 14:
                     s = "TourneyBoard14.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                      
                  case 15:
                     s = "TourneyBoard15.txt";
                     menu(s);
                     game = compile(row, col);
                     game.gameset(s);
                     break;
                        
                  default: 
                     menu();
                     game = compile(row, col);
                     game.gameset(); //Since we're outside range of tourney maps, just read from TableRead.txt
                     break;
               }
            }
            
            else
            {
               menu();//Done only after p = 1 or 3
               game = compile(row, col);     
               game.gameset();//Setup all tiles.
            }
            
            game.setPVal(p);
            game.setSVal(s);
            System.out.println();
            System.out.println(game);//Print representation of game.
            System.out.println();
            
            long start = System.currentTimeMillis();
            long start2 = System.nanoTime();
            
            long startSystemTimeNano = getSystemTime();
            long startUserTimeNano   = getUserTime();
            long startCpuTimeNano    = getCpuTime();
            
            while(game.wasThereProgress())
            {
               game.automove();//Do the automoves!
            }
         
            if(game.isWon())//If we didn't "time out"
            {
               long elapsedTimeMillis = System.currentTimeMillis()-start;
               long elapsedTimeNanos = System.nanoTime()-start2;
               double elapsedTimeSec = elapsedTimeMillis/1000D;
               double elapsedTimeSecNano = elapsedTimeNanos/1000000000D;
               long taskUserTimeNano    = getUserTime() - startUserTimeNano;
               long taskSystemTimeNano  = getSystemTime() - startSystemTimeNano;
               long taskCpuTimeNano     = getCpuTime() - startCpuTimeNano;
               
               System.out.println("WE DID IT\n");
               Map freshmap = compile(row, col);
               if(p != 3)
                  freshmap.gameset(s);
               else freshmap.gameset();
               System.out.println("Starting Map:");
               System.out.println(freshmap);
               System.out.println("\nEnding Map:");
               System.out.println(game); 
            
               
               System.out.println("Elapsed wall time (milliTime) is "+elapsedTimeSec+'s');
               System.out.println("Elapsed wall time (nanoTime)  is "+elapsedTimeSecNano+'s');
               
               System.out.println("\nElapsed time from CPU = "+(taskCpuTimeNano/1000000000D)+'s');
               System.out.println("-----\nElapsed time from System = "+(taskUserTimeNano/1000000000D)+'s');
               System.out.println("Elapsed time from User   = "+(taskSystemTimeNano/1000000000D)+'s');
            
               System.out.println("\nPress enter to continue for movelist and continuation options.");
               new Scanner(System.in).nextLine();
            
               printMoveList(game);
            }
            
            else//we didn't win... autoautomove!
            {
               System.out.println(game);
               game.autoAutoMove(null);
               
               if(game.isWon())//If we didn't "time out"
               {
                  long elapsedTimeMillis = System.currentTimeMillis()-start; //MilliTime stop
                  long elapsedTimeNanos = System.nanoTime()-start2; //Nanotime stop
                  double elapsedTimeSec = elapsedTimeMillis/1000D;//Change to s
                  double elapsedTimeSecNano = elapsedTimeNanos/1000000000D; //Change to s
                  long taskUserTimeNano    = getUserTime() - startUserTimeNano; //Get the "user" time
                  long taskSystemTimeNano  = getSystemTime() - startSystemTimeNano; //Get the "system" time
                  long taskCpuTimeNano     = getCpuTime() - startCpuTimeNano; //get the "CPU" time
               
                  System.out.println("WE DID IT\n");
                  Map freshmap = compile(row, col);
                  if(p != 3)
                     freshmap.gameset(s);
                  else freshmap.gameset();
                  System.out.println("Starting Map:");
                  System.out.println(freshmap);
                  System.out.println("\nEnding Map:");
                  System.out.println(game); 
               
               
                  System.out.println("Elapsed wall time (milliTime) is "+elapsedTimeSec+'s');
                  System.out.println("Elapsed wall time (nanoTime)  is "+elapsedTimeSecNano+'s');
               
                  System.out.println("\nElapsed time from CPU = "+(taskCpuTimeNano/1000000000D)+'s');
                  System.out.println("-----\nElapsed time from System = "+(taskUserTimeNano/1000000000D)+'s');
                  System.out.println("Elapsed time from User   = "+(taskSystemTimeNano/1000000000D)+'s');
               
                                 
                  System.out.println("\nPress enter to continue for movelist and continuation options.");
                  new Scanner(System.in).nextLine();
               
                  printMoveList(game);
               
               }
            }
         }
         
         else //This else is for manual move play
         {
            menu();//Done only after p = 1 or 3
            game = compile(row, col);     
            game.gameset();//Setup all tiles.
            System.out.println(game);   
            while(!game.isWon())//Keep going till win condition is met
            {   
            
               game.move();//Make a move!
               if(game.isReset())//Are you resetting?
               {
                  System.out.println("==============================\n============RESET=============\n==============================\n\n\n\n\n\n");
                  menu();//recall 
                  game = compile(row, col);//compile new board
                  game.gameset();//set all tiles
               }
               System.out.println();
               System.out.println(game);
            }
            printMoveList(game);
         }
         
         
      }
      while(playAgain());//Keep going till playAgain is false
      
   
      
   /* System.out.println("*---*   *");
      System.out.println("| 3 |    ");
      System.out.println("*   *---*");
      System.out.println("| 2   3 |");
      System.out.println("*---*---*");  */
   }
}

class Map
{
   class Tile
   {  
      
      class Line
      {
         
         public Line(boolean horiz)
         {
            this.on = false;
            horizontal = horiz;
         }
         
         private boolean horizontal;//Is it a horiz. or vert. line?
         private boolean on;//is it on or not
         private boolean banned;//is it a banned line? From zeroes, etc.
      
         public void turnOn()
         {
            on = true;
         }
      
         public void turnOff()
         {
            on = false;
         }
         
         public boolean getStatus()
         {
            return on;
         }
      
         public boolean isBanned()
         {
            return banned;
         }
      
         public void setBanned()//Set it to be banned
         {
            banned = true;
         }
         
         public void removeBanned()
         {
            banned = false;
         }
      }
   
      private int Xcord;//which row it's in
      private int Ycord;//which col it's in
      private int NumSides;//If it's a numbered tile, what # is it?
      private Line NLine, SLine, WLine, ELine; //North South East and West Line of a box.
      private boolean locked = false; //If true, locked from being checked. It's been done
      private ArrayList<String> al = new ArrayList<String>(); 
   
      class ArrayListIterator
      {
         int i = 0;
         
         public boolean hasNext()
         {
            return i < al.size();
         }
         
         public String currentItem()
         {
            return al.get(i);
         }
         
         public void next()
         {
            i++;
         } 
         
         public void reset()
         {
            i = 0;
         }
      }
   
      public Tile(int x, int y)
      {
         Xcord = x;
         Ycord = y;
         NumSides = 5;//Default # is 5 (won't be displayed)
         {//Add all 15 possible representations to ArrayList
            al.add("FFFF");
            al.add("FFFT");
            al.add("FFTF");
            al.add("FFTT");
            al.add("FTFF");
            al.add("FTFT");
            al.add("FTTF");
            al.add("FTTT");
            al.add("TFFF");
            al.add("TFFT");
            al.add("TFTF");
            al.add("TFTT");
            al.add("TTFF");
            al.add("TTFT");
            al.add("TTTF");
         }
      }
      public int getRow()
      {
         return Xcord; //row it's in
      }
      
      public int getCol()
      {
         return Ycord; //col it's in
      }
      
      public String getFirstLine()
      {//First line only used once (third line used after, to avoid duplication of lines)
         return "+" + ((NLine.getStatus()) ? "---" : "   ");
      }
      
      public String getSecondLine()
      {//Second line has the number or not
         String onLine1 = "";
         String onLine2 = " ";
         if(this.Ycord == 1)
            onLine1 = (this.getWestLine().getStatus()) ? "|" : " ";
         if(this.getEastLine().getStatus())
            onLine2 = "|";
         if(NumSides != 5)
            return new String(onLine1+" "+NumSides+" "+onLine2);
         return new String(onLine1+"   "+onLine2);
      }
      
      public String getThirdLine()//Third line in "box" of Tile
      {
         return "+" + ((SLine.getStatus()) ? "---" : "   ");
      }
      
      public void setNumSides(int i)//Set the number in the tile
      {
         NumSides = ((i > 4) ? 5 : i);
         ArrayListIterator ali = new ArrayListIterator();
         int[] stringstoremove = new int[15];//To hold string indexes 
         int index = 0;
         
         switch(i)
         {
            case 1: 
               for(ali.reset(); ali.hasNext(); ali.next())
               {
                  if(this.checkAmountOfTs(ali.currentItem()) != 1)
                     stringstoremove[index++] = ali.i;
               }   
               break;
               
            case 2: 
               for(ali.reset(); ali.hasNext(); ali.next())
               {
                  if(this.checkAmountOfTs(ali.currentItem()) != 2)
                     stringstoremove[index++] = ali.i;
               }   
               break;  
               
            case 3: 
               for(ali.reset(); ali.hasNext(); ali.next())
               {
                  if(this.checkAmountOfTs(ali.currentItem()) != 3)
                     stringstoremove[index++] = ali.i;
               }   
               break; 
          
            default:
               //System.out.println("def");
               break;
         }
       
         for(int k = index-1; k >= 0; k--)//Remove elements (backwards) from AL
            al.remove(stringstoremove[k]);
            
         //System.out.println(this.getAllPossibleRepresentations());
      }
      
      private int checkAmountOfTs(String s)//Check the representations
      {
         int Ts = 0; //Amount of Ts
         for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == 'T')
               Ts++;
               
         return Ts;
      }
      
      private void checkLinesForBannedOrTurnedOn()
      {
         ArrayListIterator ali = new ArrayListIterator();
         boolean[] stringstoremove = new boolean[15];
         Arrays.fill(stringstoremove, false);
         int index = 0;
         
         if(this.getNorthLine().isBanned())
         {
            for(ali.reset(); ali.hasNext(); ali.next())
               if(ali.currentItem().charAt(0) == 'T')
               {
                  stringstoremove[ali.i] = true;
                  //System.out.println(ali.i);
               }
         }
         
         if(this.getNorthLine().getStatus())
         {
            for(ali.reset(); ali.hasNext(); ali.next())
               if(ali.currentItem().charAt(0) == 'F')
               {
                  stringstoremove[ali.i] = true;
                  //System.out.println(ali.i);
               }
         }
            
         if(this.getEastLine().isBanned())
         {
            for(ali.reset(); ali.hasNext(); ali.next())
               if(ali.currentItem().charAt(1) == 'T')   
               {
                  //System.out.println(ali.i);
                  stringstoremove[ali.i] = true;//if statement made sure no duplicates
               }
         }
         
         if(this.getEastLine().getStatus())
         {
            for(ali.reset(); ali.hasNext(); ali.next())
               if(ali.currentItem().charAt(1) == 'F')
               {
                  stringstoremove[ali.i] = true;
                  //System.out.println(ali.i);
               }
         }
         
         if(this.getWestLine().isBanned())
         {
            for(ali.reset(); ali.hasNext(); ali.next())
               if(ali.currentItem().charAt(2) == 'T')
               {
                  //System.out.println(ali.i);
                  stringstoremove[ali.i] = true;//if statement made sure no duplicates
               }  
         }
         
         if(this.getWestLine().getStatus())
         {
            for(ali.reset(); ali.hasNext(); ali.next())
               if(ali.currentItem().charAt(2) == 'F')
               {
                  stringstoremove[ali.i] = true;
                  //System.out.println(ali.i);
               }
         }
         
         if(this.getSouthLine().isBanned())
         {
            for(ali.reset(); ali.hasNext(); ali.next())
               if(ali.currentItem().charAt(3) == 'T')
               {
                  //System.out.println(ali.i);
                  stringstoremove[ali.i] = true;//if statement made sure no duplicates
               }
         }
         
         if(this.getSouthLine().getStatus())
         {
            for(ali.reset(); ali.hasNext(); ali.next())
               if(ali.currentItem().charAt(3) == 'F')
               {
                  stringstoremove[ali.i] = true;
                  //System.out.println(ali.i);
               }
         }
         
         for(int k = 14; k >= 0; k--)//Remove elements (backwards) from AL
            if(stringstoremove[k])
               al.remove(k);
      }
      
      public int getAllPossibleRepresentations()//Get (count of) possible reps
      {
         int i = 0;
         
         ArrayListIterator ali = new ArrayListIterator();
         for(ali.reset(); ali.hasNext(); ali.next())
         {
            i++;
         }
         
         return i;
      }   
      
      private void setLinesFromOneRep(Map m, int r, int c, String s)
      {
         if(s.charAt(0) == 'T')
         {
            if(!this.getNorthLine().getStatus())
            {
               this.getNorthLine().turnOn();
               m.addToMoveList(r, c, "Top", true);   
            }
         }
         
         if(s.charAt(1) == 'T')
         {
            if(!this.getEastLine().getStatus())
            {
               this.getEastLine().turnOn();
               m.addToMoveList(r, c, "Right", true);
            }
         }
         
         if(s.charAt(2) == 'T')
         {
            if(!this.getWestLine().getStatus())
            {
               this.getWestLine().turnOn();
               m.addToMoveList(r, c, "Left", true);
            }
         }
      
         if(s.charAt(3) == 'T') 
         {
            if(!this.getSouthLine().getStatus())
            {
               this.getSouthLine().turnOn();
               m.addToMoveList(r, c, "Bottom", true);
            }
         }
      
         this.setLocked();
      }
      
      private void banMoreLinesFromAbove(Map m, int row, int col, String s)
      {
         switch(s)
         {//NEWS
         
            case "FFFF":
               m.TileMap[row-1][col-1].getNorthLine().setBanned();
               m.TileMap[row-1][col-1].getEastLine().setBanned();
               m.TileMap[row-1][col-1].getWestLine().setBanned();
               m.TileMap[row-1][col-1].getSouthLine().setBanned();
               break;
               
            case "TFFF"://N
               m.TileMap[row-1][col-1].getEastLine().setBanned();
               m.TileMap[row-1][col-1].getWestLine().setBanned();
               m.TileMap[row-1][col-1].getSouthLine().setBanned();
               break;
               
            case "FTFF"://E
               m.TileMap[row-1][col-1].getNorthLine().setBanned();
               m.TileMap[row-1][col-1].getWestLine().setBanned();
               m.TileMap[row-1][col-1].getSouthLine().setBanned();
               break;
               
            case "FFTF"://W
               m.TileMap[row-1][col-1].getEastLine().setBanned();
               m.TileMap[row-1][col-1].getNorthLine().setBanned();
               m.TileMap[row-1][col-1].getSouthLine().setBanned();
               break;
            
            case "FFFT"://S
               m.TileMap[row-1][col-1].getEastLine().setBanned();
               m.TileMap[row-1][col-1].getWestLine().setBanned();
               m.TileMap[row-1][col-1].getNorthLine().setBanned();
               break;
               
            case "TFFT"://NS
               m.TileMap[row-1][col-1].getEastLine().setBanned();
               m.TileMap[row-1][col-1].getWestLine().setBanned();
               break;
               
            case "FTTF"://EW
               m.TileMap[row-1][col-1].getNorthLine().setBanned();
               m.TileMap[row-1][col-1].getSouthLine().setBanned();
               break;
               
            case "TFTF"://NW
               if(row > 1)
                  m.TileMap[row-2][col-1].getWestLine().setBanned();
               if(col > 1)
                  m.TileMap[row-1][col-2].getNorthLine().setBanned();
               m.TileMap[row-1][col-1].getSouthLine().setBanned();//Ban main square
               m.TileMap[row-1][col-1].getEastLine().setBanned();//Ban main square
               break;
         
            case "TTFF"://NE
               if(col < m.col)
                  m.TileMap[row-1][col].getNorthLine().setBanned();
               if(row > 1)
                  m.TileMap[row-2][col-1].getEastLine().setBanned();
               m.TileMap[row-1][col-1].getSouthLine().setBanned();//Ban main square
               m.TileMap[row-1][col-1].getWestLine().setBanned();//Ban main square
            
               break;
               
            case "FFTT"://SW
               if(col > 1)
                  m.TileMap[row-1][col-2].getSouthLine().setBanned();
               if(row < m.row)
                  m.TileMap[row][col-1].getWestLine().setBanned();
               m.TileMap[row-1][col-1].getNorthLine().setBanned();//Ban main square
               m.TileMap[row-1][col-1].getEastLine().setBanned();//Ban main square
               break;
               
            case "FTFT"://SE
               if(col < m.col)
                  m.TileMap[row-1][col].getSouthLine().setBanned();
               if(row < m.row)
                  m.TileMap[row][col-1].getEastLine().setBanned();
               m.TileMap[row-1][col-1].getNorthLine().setBanned();//Ban main square
               m.TileMap[row-1][col-1].getWestLine().setBanned();//Ban main square
               break;
               
            case "TTFT"://NES
               if(col < m.col)
               {
                  m.TileMap[row-1][col].getNorthLine().setBanned();
                  m.TileMap[row-1][col].getSouthLine().setBanned();
               }
               if(row < m.row)
                  m.TileMap[row][col-1].getEastLine().setBanned();
               if(row > 1)
                  m.TileMap[row-2][col-1].getEastLine().setBanned();
               m.TileMap[row-1][col-1].getWestLine().setBanned();
               break;
               
            case "TFTT"://NWS
               if(col > 1)
               {
                  m.TileMap[row-1][col-2].getNorthLine().setBanned();
                  m.TileMap[row-1][col-2].getSouthLine().setBanned();
               }
               if(row < m.row)
                  m.TileMap[row][col-1].getWestLine().setBanned();
               if(row > 1)
                  m.TileMap[row-2][col-1].getWestLine().setBanned();
               m.TileMap[row-1][col-1].getEastLine().setBanned();
               break;
            
            case "TTTF"://NEW
               if(row > 1)
               {
                  m.TileMap[row-2][col-1].getEastLine().setBanned();
                  m.TileMap[row-2][col-1].getWestLine().setBanned();
               }
               if(col > 1)
                  m.TileMap[row-1][col-2].getNorthLine().setBanned();
               if(col < m.col)
                  m.TileMap[row-1][col].getNorthLine().setBanned();
               m.TileMap[row-1][col-1].getSouthLine().setBanned();
               break;
               
            case "FTTT"://EWS
               if(row < m.row)
               {
                  m.TileMap[row][col-1].getEastLine().setBanned();
                  m.TileMap[row][col-1].getWestLine().setBanned();
               }
               if(col > 1)
                  m.TileMap[row-1][col-2].getSouthLine().setBanned();
               if(col < m.col)
                  m.TileMap[row-1][col].getSouthLine().setBanned();
               m.TileMap[row-1][col-1].getNorthLine().setBanned();
               break;
            
            default:
               break;
         }
      }
      
            
      public void printOffTileReps()
      {
         ArrayListIterator ali = new ArrayListIterator();
      
         for(ali.reset(); ali.hasNext(); ali.next())
            System.out.println(ali.currentItem());
      }
      
      public void setNorthLine(Line NLine)
      {//Set its north line to be some line object
         this.NLine = NLine;
      }
      
      public void setSouthLine(Line SLine)
      {//Set its south line to be some line object
         this.SLine = SLine;
      }
      
      public void setWestLine(Line WLine)
      {//Set its west line to be some line object
         this.WLine = WLine;
      }
      
      public void setEastLine(Line ELine)
      {//Set its east line to be some line object
         this.ELine = ELine;
      }
      
      public Line getNorthLine()
      {//get N line
         return this.NLine;
      }
      
      public Line getSouthLine()
      {//get S line
         return this.SLine;
      }
      
      public Line getWestLine()
      {//get W line
         return this.WLine;
      }
      
      public Line getEastLine()
      {//get E line
         return this.ELine;
      }
      
      public String getRepresentation()
      {//String goes "NEWS", so "TFTF" is North and West is on, and East and South line is off"
         String g = "";
         g += (this.getNorthLine().getStatus()) ? "T" : "F";
         g += (this.getEastLine().getStatus()) ? "T" : "F";
         g += (this.getWestLine().getStatus()) ? "T" : "F";
         g += (this.getSouthLine().getStatus()) ? "T" : "F";
         //NOTE: This is not used in this version of the program; however, it WILL be used in the AI portion.
         //Put here preemptively.
         return g;
      }
      
      public int getTileValueLines()
      {//Get the amount of lines around tile
         int q = 0;
         if(this.getNorthLine().getStatus() == true) q++;
         if(this.getWestLine().getStatus() == true) q++;
         if(this.getEastLine().getStatus() == true) q++;
         if(this.getSouthLine().getStatus() == true) q++;
         
         return q;
      }
      
      public int getTileVal()
      {//get the number set in the middle of the tile
         return NumSides;
      }
   
      public boolean isLocked()
      {
         return locked;//Return locked
      }
     
      public void setLocked()
      {
         locked = true; //set it to be locked
      }
   }

   private int row;
   private int col;
   private boolean moveinit = true;//Flag to show intial instructions. Turns off in move() 
   private boolean reset = false;//Flag to reset entire board. Turns on in move()
   Tile[][] TileMap;//Map of Tiles that is in Map class.
   String moveList = "Moves on last-solved board:\r\n";
   int moveListCount = 0;
   int p;
   String s;
   
   private int lineNumber = 0;
   
   Map(int row, int col)//Constructer for a new map: go through and create ALL Tiles AND initialize their line objects (or share with another tile those same objects)
   {
      this.row = row;
      this.col = col;
      
      TileMap = new Tile[row][col];
   
      for(int i = 1; i <= row; i++)
      {
         for(int j = 1; j <= col; j++)
         {
            TileMap[i-1][j-1] = new Tile(i, j);
            if(i==1)
            {
               TileMap[i-1][j-1].setNorthLine(TileMap[i-1][j-1].new Line(true));//New NorthLine for top tiles of board
            }
            else 
            {
               TileMap[i-1][j-1].setNorthLine(TileMap[i-2][j-1].getSouthLine());//Get South Line from tile above for North Tile (if not top tiles)
            }
            
            TileMap[i-1][j-1].setSouthLine(TileMap[i-1][j-1].new Line(true));//New SouthLine for tiles of board
            
            if(j==1)
            {
               TileMap[i-1][j-1].setWestLine(TileMap[i-1][j-1].new Line(false));
               
            }
            else 
            {
               TileMap[i-1][j-1].setWestLine(TileMap[i-1][j-2].getEastLine()); //Get EastLine from neighbor tile for WestLine.
            }
            TileMap[i-1][j-1].setEastLine(TileMap[i-1][j-1].new Line(false)); //Always make new East Line object for tiles
            
         }
      }
   }
   
   private void addToMoveList(int row, int col, String direction, boolean addition)
   {//Private for use in the move() method
      moveList += Integer.toString(++moveListCount);
      moveList += ((moveListCount <= 9) ?
               (".  Row "+row+" , Col "+col+" "+direction+" Line, turned ") :
               (". Row "+row+" , Col "+col+" "+direction+" Line, turned "));
      moveList += (addition) ? "on\r\n" : "off\r\n";
      if(addition)
         lineNumber++;
      else lineNumber--;
      progress = true;//Progress move for automove()!!
   }
   
   public String getMoveList()
   {
      return moveList;
   }
   
   public void setMoveList(String oldMoveList)
   {
      moveList = oldMoveList;
   }
   
   public int getPVal()
   {
      return p;
   }
   
   public String getSVal()
   {
      return s;
   }
   
   public void setPVal(int mainp)
   {
      p = mainp;
   }  
      
   public void setSVal(String mains)
   {
      s = mains;
   }
   
   public void move()//Make a move!
   {
      int r = 0, c = 0; //Initialize row and col to unused #
      boolean stop = false; //flag to continue to next phase of move
      char direction = 'q';//Initialize direction to unused char
   
      if(moveinit)//If first move of the new game
      {
         System.out.println("You can exit this game if you wish by typing \"quit\".");
         System.out.println("You can also reset this game at any time by typing in \"reset\"\n");
         System.out.println("Use the format Row#(space)Col#(space)Direction. Ex: 1 1 T\n");
         moveinit = false;
      }
      System.out.println("Which tile do you want to edit, and which line to edit?\n");
      System.out.print("Choice : ");
      
      String s = new Scanner(System.in).nextLine();
      if(s.equalsIgnoreCase("quit")||s.equalsIgnoreCase("exit"))//get the goodbye command
      {
         System.out.println("\nBye!");
         System.exit(0);
      }
      if(s.equalsIgnoreCase("reset"))//get the reset command
      {
         reset = true;
         return;//get out of the move() to reset the game
      }
      try{
         if(s.charAt(1) != ' ')//If 2-numeral row val
            r = (Character.getNumericValue(s.charAt(0))*10)+(Character.getNumericValue(s.charAt(1)));
         else r = Character.getNumericValue(s.charAt(0));
         
         if(s.charAt(1) == ' ')//If 1-numeral row val
            if(s.charAt(3) != ' ')//If 2-numeral col val
               c = (Character.getNumericValue(s.charAt(2))*10)+(Character.getNumericValue(s.charAt(3)));//Get value of both numbers
            else c = Character.getNumericValue(s.charAt(2));
         else 
         {
            if(s.charAt(4) != ' ')//If 2-numeral col val
               c = (Character.getNumericValue(s.charAt(3))*10)+(Character.getNumericValue(s.charAt(4)));//Get value of both numbers
            else c = Character.getNumericValue(s.charAt(3));
         }
         if(r > 9 && c > 9)//If both choices greater than 9
            direction = s.charAt(6);
         else if((r > 9 && c < 9) || (r < 9 && c > 9))//If one choice greater than 9
            direction = s.charAt(5);
         else direction = s.charAt(4);//If both are 9 or less 
      }
      catch(Exception e){//Entered in invalid format for the moves. 
         System.out.println("\n***Invalid move format.***\nPlease retry using the format Row#(space)Col#(space)Direction. Ex: 1 1 T.\n");
         return;
      }
      
      if(r > row || r < 1)//OOB for rows
      {
         System.out.println(("\nInvalid row input. Please choose a number between 1 and "+row));
         stop = true; //flag the stop operation!! bad input
      }
      
      if(c > col || c < 1)//OOB for cols
      {
         System.out.println(("\nInvalid column input. Please choose a number between 1 and "+col));
         stop = true; //flag the stop operation!! bad input
      }
   
      if(stop)//don't continue on...
         return;
      
      switch(direction)
      {//switch defining which to turn on/off if needed
         case 't':
         case 'T':
            if(!TileMap[r-1][c-1].getNorthLine().getStatus()) 
            {
               TileMap[r-1][c-1].getNorthLine().turnOn();
               this.addToMoveList(r, c, "Top", true);
            }
            else 
            {
               TileMap[r-1][c-1].getNorthLine().turnOff();
               this.addToMoveList(r, c, "Top", false);
            }
            break;
         
         case 'r':
         case 'R':
            if(!TileMap[r-1][c-1].getEastLine().getStatus()) 
            {
               TileMap[r-1][c-1].getEastLine().turnOn();
               this.addToMoveList(r, c, "Right", true);
            }
            else 
            {
               TileMap[r-1][c-1].getEastLine().turnOff();
               this.addToMoveList(r, c, "Right", false);
            }
            break;
         
         case 'l':
         case 'L':
            if(!TileMap[r-1][c-1].getWestLine().getStatus()) 
            {
               TileMap[r-1][c-1].getWestLine().turnOn();
               this.addToMoveList(r, c, "Left", true);
            }
            else 
            {
               TileMap[r-1][c-1].getWestLine().turnOff();
               this.addToMoveList(r, c, "Left", false);
            }
            break;
            
         case 'b':
         case 'B':
            if(!TileMap[r-1][c-1].getSouthLine().getStatus()) 
            {
               TileMap[r-1][c-1].getSouthLine().turnOn();
               this.addToMoveList(r, c, "Bottom", true);
            }
            else 
            {
               TileMap[r-1][c-1].getSouthLine().turnOff();
               this.addToMoveList(r, c, "Bottom", false);
            }
            break;
         default://disply if the letter doesn't match any valid choice
            System.out.println("\nThat is not a valid line entry. The valid moves are:");
            System.out.println(" - T/t for the top line of the selected tile");
            System.out.println(" - L/l for the left line of the selected tile");
            System.out.println(" - R/r for the right line of the selected tile");
            System.out.println(" - B/b for the bottom line of the selected tile");
            
            break;
      }
   }
   
   private boolean didonce = false;
   private boolean progress = true;
   
   public void automove()//Automatically solve the games
   {
      progress = false;//Reset the progress flag
      if(!didonce)
      {
         this.searchForZeroes();//Searching for any zeroes, banning all lines around zero (once)
         this.searchForTwo3s();//Search for two nearby threes
         this.searchCorners();//Search and kill any extra ones that may crop up on sides/corners (once)
         didonce = true;//Only wanna do this type of search once... save some time.
      }
      this.checkForMoreBans();//Check if we can ban some lines
      this.checkForMoreLines();//Check if we can place any special lines down
      //this.checkForAContinuousLink();//Go and check to see if we can make a continuous link--DISCONTINUED. Replaced by above two methods
      this.checkForAnyGuarantees();//Checks for guaranteed lines that can be turned on...
      this.checkForOnlyOneRep();//Go and check for only one representation of any tile
   
   }
   

   public void automove2()
   {
      progress = false;//Reset the progress flag
      this.checkForMoreBans();//Check if we can ban some lines
      this.checkForMoreLines();//Check if we can place any special lines down
      this.checkForAnyGuarantees();//Checks for guaranteed lines that can be turned on...
      this.checkForOnlyOneRep();//Go and check for only one representation of any tile
      //this.checkCongruentLines();
   }
   public void reset(Map m)
   {
      this.TileMap = m.copy().TileMap;
      this.setMoveList(m.getMoveList());
      this.moveListCount = m.moveListCount;
   }
   
   public int getLineNumber()
   {
      return lineNumber;
   }
   
   public void setLineNumber(int i)
   {
      lineNumber = i;
   }
   
   boolean g = true;     
   private boolean wewon = false;
   
   public void autoAutoMove(Tile t)
   {
      Tile j;
      if(t == null)
         j = findLowestRepresentations();
      else j = findLowestRepresentations(t);
      Map tempcopy = this.copy();
      
      if(j == null)
         return;
      
      int x = j.getRow();
      int y = j.getCol();
      
   
      do{
         //System.out.println(this);
        //System.out.println(x+" "+y);
         //System.out.println("Tile [1][2] east: "+TileMap[1][2].getEastLine().isBanned());
        // System.out.println("Tile [2][3] N: "+TileMap[2][3].getNorthLine().isBanned());
         //System.out.println("Tile [2][3] W: "+TileMap[2][3].getWestLine().isBanned());
         
         //System.out.println("Tile [1][7] W: "+TileMap[0][6].getWestLine().isBanned());
         //System.out.println("Tile [1][7] N: "+TileMap[0][6].getNorthLine().isBanned());
         
         //try{
            //Thread.sleep(250);
         //}
         //catch(InterruptedException e){System.out.println(e);}
      
         
         /*if(j == TileMap[5][4])
         {
            System.out.println("WORKING WITH [6][5]");
            TileMap[5][4].printOffTileReps();
         }  */  
         
         String repused;
            
      
         updateReps();
         if(j.getAllPossibleRepresentations() == 0)
            break;
         else
         {
            repused = j.al.get(j.getAllPossibleRepresentations()-1);
         }
         //System.out.println("HEY1: \n"+this);
         j.setLinesFromOneRep(this,x,y,repused);
         //System.out.println("HEY2: \n"+this);
         j.banMoreLinesFromAbove(this,x,y,repused);
         //System.out.println("HEY3: \n"+this);
         int counter = 0;
         do
            automove2();
         while(wasThereProgress()); 
                 
         if(isThereDiverging(j) || areThereTilesWithZeroReps() || isThereLineWithAllButOneBanned())
         {
            tempcopy.removeOneBadRep(tempcopy.TileMap[x-1][y-1],repused);
            this.reset(tempcopy);
            j = TileMap[x-1][y-1];
            continue;
         }
         if(isWon())
         {
            wewon = true;
            return;
         }  
         autoAutoMove(j);
         
         if(wewon)
         {
            //System.out.println("WE WON");  
            return;
         }
         tempcopy.removeOneBadRep(tempcopy.TileMap[x-1][y-1],repused);
         this.reset(tempcopy);
         j = TileMap[x-1][y-1];
      }while(true);
         
   }
   
   private boolean isThereLineWithAllButOneBanned()
   {  
      for(int r = 1; r < row; r++)
         for(int c = 1; c < col; c++)
         {
            if(!TileMap[r-1][c-1].isLocked())
               continue; //Don't care if it's not locked
            boolean areAllBanned = true;
            
            if(TileMap[r-1][c-1].getNorthLine().getStatus())
            {
               areAllBanned = true;
               int linessurrounding = 0;                
               if(r > 1)
               {
                  if(TileMap[r-2][c-1].getEastLine().getStatus())
                     linessurrounding++;
                  else if(!TileMap[r-2][c-1].getEastLine().isBanned())
                     areAllBanned = false;
                        
                  if(TileMap[r-2][c-1].getWestLine().getStatus())
                     linessurrounding++;
                  else if(!TileMap[r-2][c-1].getWestLine().isBanned())
                     areAllBanned = false;
               }
               
               if(c > 1)
               {
                  if(TileMap[r-1][c-2].getNorthLine().getStatus())
                     linessurrounding++;
                  else if(!TileMap[r-1][c-2].getNorthLine().isBanned())
                     areAllBanned = false;
               }
               
               if(c < col)
               {                     
                  if(TileMap[r-1][c].getNorthLine().getStatus())
                     linessurrounding++;
                  else if(!TileMap[r-1][c].getNorthLine().isBanned())
                     areAllBanned = false;
               }
               
               if(TileMap[r-1][c-1].getEastLine().getStatus())
                  linessurrounding++;
               else if(!TileMap[r-1][c-1].getEastLine().isBanned())
                  areAllBanned = false;
                        
               if(TileMap[r-1][c-1].getWestLine().getStatus())
                  linessurrounding++;
               else if(!TileMap[r-1][c-1].getWestLine().isBanned())
                  areAllBanned = false;
            
               if(linessurrounding == 1 && areAllBanned)
                  return true;
            }
            
            if(TileMap[r-1][c-1].getEastLine().getStatus())
            {
               areAllBanned = true;
            
               int linessurrounding = 0;                
            
               if(c < col)
               {
                  if(TileMap[r-1][c].getNorthLine().getStatus())
                     linessurrounding++;
                  else if(!TileMap[r-1][c].getNorthLine().isBanned())
                     areAllBanned = false;
               
                  if(TileMap[r-1][c].getSouthLine().getStatus())
                     linessurrounding++;
                  else if(!TileMap[r-1][c].getSouthLine().isBanned())
                     areAllBanned = false;
               }
               
               if(r > 1)
               {
                  if(TileMap[r-2][c-1].getEastLine().getStatus())
                     linessurrounding++;
                  else if(!TileMap[r-2][c-1].getEastLine().isBanned())
                     areAllBanned = false;
               }
               
               if(r < row)
               {
                  if(TileMap[r][c-1].getEastLine().getStatus())
                     linessurrounding++;
                  else if(!TileMap[r][c-1].getEastLine().isBanned())
                     areAllBanned = false;
               }
            
               if(TileMap[r-1][c-1].getNorthLine().getStatus())
                  linessurrounding++;
               else if(!TileMap[r-1][c-1].getNorthLine().isBanned())
                  areAllBanned = false;
            
               if(TileMap[r-1][c-1].getSouthLine().getStatus())
                  linessurrounding++;
               else if(!TileMap[r-1][c-1].getSouthLine().isBanned())
                  areAllBanned = false;
            
               if(linessurrounding == 1 && areAllBanned)
                  return true;
            }
            
            if(c == 1)
               if(TileMap[r-1][c-1].getWestLine().getStatus())
               {
                  areAllBanned = true;
               
                  int linessurrounding = 0;                  
               
                  if(r > 1)
                  {
                     if(TileMap[r-2][c-1].getWestLine().getStatus())
                        linessurrounding++;
                     else if(!TileMap[r-2][c-1].getWestLine().isBanned())
                        areAllBanned = false;
                  }
               
                  if(r < row)
                  {
                     if(TileMap[r][c-1].getWestLine().getStatus())
                        linessurrounding++;
                     else if(!TileMap[r][c-1].getWestLine().isBanned())
                        areAllBanned = false;
                  }
               
                  if(TileMap[r-1][c-1].getNorthLine().getStatus())
                     linessurrounding++;
                  else if(!TileMap[r-1][c-1].getNorthLine().isBanned())
                     areAllBanned = false;
               
                  if(TileMap[r-1][c-1].getSouthLine().getStatus())
                     linessurrounding++;
                  else if(!TileMap[r-1][c-1].getSouthLine().isBanned())
                     areAllBanned = false;
               
               
               
               
               
                  if(linessurrounding == 1 && areAllBanned)
                     return true;
               }
            
            if(r == row)
               if(TileMap[r-1][c-1].getSouthLine().getStatus())
               {
                  areAllBanned = true;
               
                  int linessurrounding = 0;                   
               
                  if(c > 1)
                  {
                     if(TileMap[r-1][c-2].getSouthLine().getStatus())
                        linessurrounding++;
                     else if(!TileMap[r-1][c-2].getSouthLine().isBanned())
                        areAllBanned = false;
                  }
               
                  if(c < col)
                  {                     
                     if(TileMap[r-1][c].getSouthLine().getStatus())
                        linessurrounding++;
                     else if(!TileMap[r-1][c].getSouthLine().isBanned())
                        areAllBanned = false;
                  }
               
                  if(TileMap[r-1][c-1].getEastLine().getStatus())
                     linessurrounding++;
                  else if(!TileMap[r-1][c-1].getEastLine().isBanned())
                     areAllBanned = false;
                        
                  if(TileMap[r-1][c-1].getWestLine().getStatus())
                     linessurrounding++;
                  else if(!TileMap[r-1][c-1].getWestLine().isBanned())
                     areAllBanned = false;
               
               
               
                  if(linessurrounding == 1 && areAllBanned)
                     return true;
               }
         }
         
      return false;
   }
   
   public int numOfLockedTiles()
   {
      int x = 0;
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
            if(TileMap[r-1][c-1].isLocked())
               x++;
      return x;
   }
   
   public boolean wasThereProgress()
   {//True = some change, false = no change at all in run of automove
      return progress;
   }
   
   private int countLines()
   {
      int count = 0;
      
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
         {
            if(TileMap[r-1][c-1].getNorthLine().getStatus())//is on?
               count++;
               
            if(TileMap[r-1][c-1].getEastLine().getStatus())//is on?
               count++;
               
            if(c == 1)    
               if(TileMap[r-1][c-1].getWestLine().getStatus())//is on?
                  count++;
                  
            if(r == row)   
               if(TileMap[r-1][c-1].getSouthLine().getStatus())//is on?
                  count++;
         }
      return count;
   }
   
   public boolean isWonAI()
   {
      Map.Tile.Line prev = null;//Set the previous line to null
      Map.Tile.Line first = null;//Set the first line to null
      Map.Tile.Line next = null;//Set the next line to null
      boolean flag = true, terminate = false;//Flag is to signal the FIRST check for lines (because there'll be two paths.) Terminate is to get out of first instance of lines
      int newrow = 0, newcol = 0, totallines = 0;//Newrow and Newcol are the row and col; totallines counts the path--how many lines it takes.
      int tempnewrow = 0, tempnewcol = 0;//temporary row and col placeholders
      char whichline = 't';//unused initialized var
      
   
    //Find first instance of "lines"             
      for(int i = 1; i <= row; i++)
      {
         for(int j = 1; j <= col; j++)
         {
            if((TileMap[i-1][j-1].getTileValueLines() == 0)) 
               continue;//if there're no lines on that tile, go to next tile (or new row)
            
            if(flag)//If we found a tile w/ lines
            {
               terminate = true;//Terminate this loop
               if(TileMap[i-1][j-1].getNorthLine().getStatus()) 
               {//Go through this if tree to get ONE starting line; if multiple lines in one tile, South Line will overwrite all having priority.
                  whichline = 'N';
                  first = next = TileMap[i-1][j-1].getNorthLine(); 
               }
               if(TileMap[i-1][j-1].getEastLine().getStatus()) 
               {
                  whichline = 'E';
                  first = next = TileMap[i-1][j-1].getEastLine();
               }
               if(TileMap[i-1][j-1].getWestLine().getStatus()) 
               { 
                  whichline = 'W';
                  first = next = TileMap[i-1][j-1].getWestLine();
               }
               if(TileMap[i-1][j-1].getSouthLine().getStatus()) 
               {
                  whichline = 'S';
                  first = next = TileMap[i-1][j-1].getSouthLine(); 
               }
               newrow = i; 
               newcol = j;
               
            }
            if(terminate)
               break;
         }
         if(terminate) 
            break;
      }
      int testlines = 0;
      do
      { 
         testlines = 0; //reset testline
         switch(whichline)
         {
         
            case 'N'://Case if NorthLine's activated, check rest around that line for path(s).
               if(newrow>1)//If not first row, check row above
               {
                  if(TileMap[newrow-2][newcol-1].getEastLine().getStatus() && (TileMap[newrow-2][newcol-1].getEastLine() != prev)) 
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
                  
                  if(TileMap[newrow-2][newcol-1].getWestLine().getStatus() && (TileMap[newrow-2][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
               }
               
               if(TileMap[newrow-1][newcol-1].getEastLine().getStatus() && (TileMap[newrow-1][newcol-1].getEastLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'E';
               }
               
               if(TileMap[newrow-1][newcol-1].getWestLine().getStatus() && (TileMap[newrow-1][newcol-1].getWestLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'W';
               }  
               
               if(newcol > 1)//If not first col, check column to left
               {
                  if(TileMap[newrow-1][newcol-2].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-2].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'N';
                  }
               }
               
               if(newcol < col)//If not last col, check column to right
               {
                  if(TileMap[newrow-1][newcol].getNorthLine().getStatus() && (TileMap[newrow-1][newcol].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'N';
                  }
               }
               
               break;
            
            case 'E':
               if(newcol<col)
               {
                  if(TileMap[newrow-1][newcol].getNorthLine().getStatus() && (TileMap[newrow-1][newcol].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'N';
                  }
                  
                  if(TileMap[newrow-1][newcol].getSouthLine().getStatus() && (TileMap[newrow-1][newcol].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'S';
                  }
               }
               
               if(newrow>1)
               {
                  if(TileMap[newrow-2][newcol-1].getEastLine().getStatus() && (TileMap[newrow-2][newcol-1].getEastLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
               }
               
               if(newrow < row)
               {
                  if(TileMap[newrow][newcol-1].getEastLine().getStatus() && (TileMap[newrow][newcol-1].getEastLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
               }
               
               if(TileMap[newrow-1][newcol-1].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-1].getNorthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'N';
               }
                  
               if(TileMap[newrow-1][newcol-1].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-1].getSouthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'S';
               }  
            
               break;
               
            case 'W':
            
               if(newcol>1)
               {
                  if(TileMap[newrow-1][newcol-2].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-2].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'N';
                  }
                  
                  if(TileMap[newrow-1][newcol-2].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-2].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'S';
                  }
               }
               
               if(newrow>1)
               {
                  if(TileMap[newrow-2][newcol-1].getWestLine().getStatus() && (TileMap[newrow-2][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
               }
               
               if(newrow < row)
               {
                  if(TileMap[newrow][newcol-1].getWestLine().getStatus() && (TileMap[newrow][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
               }
               
               if(TileMap[newrow-1][newcol-1].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-1].getNorthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'N';
               }
                  
               if(TileMap[newrow-1][newcol-1].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-1].getSouthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'S';
               }  
               break;
               
            case 'S':
            
               if(newrow<row)//If not first row, check row above
               {
                  if(TileMap[newrow][newcol-1].getEastLine().getStatus() && (TileMap[newrow][newcol-1].getEastLine() != prev)) 
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
                  
                  if(TileMap[newrow][newcol-1].getWestLine().getStatus() && (TileMap[newrow][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
               }
               
               if(TileMap[newrow-1][newcol-1].getEastLine().getStatus() && (TileMap[newrow-1][newcol-1].getEastLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'E';
               }
               
               if(TileMap[newrow-1][newcol-1].getWestLine().getStatus() && (TileMap[newrow-1][newcol-1].getWestLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'W';
               }  
               
               if(newcol > 1)//If not first col, check column to left
               {
                  if(TileMap[newrow-1][newcol-2].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-2].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'S';
                  }
               }
               
               if(newcol < col)//If not last col, check column to right
               {
                  if(TileMap[newrow-1][newcol].getSouthLine().getStatus() && (TileMap[newrow-1][newcol].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'S';
                  }
               }
               break;
               
            default:
               break;
         
         }
         if(testlines == 0) //If no new path discovered
            return false; 
         if(testlines > 1 && flag == false)//If more than one path and NOT first
         {
            //System.out.println("WARNING: This board will not generate a solution in the future.\nYou have a diverging path.\n");  
            return false;
         }
         else
         {
            flag = false;//Turn flag off
            newrow = tempnewrow;//Set the row to the temporary placeholder
            newcol = tempnewcol;//Set the col to the temporary placeholder
            prev = next;//Change the one "next" to "prev."
            switch(whichline)
            {
               case 'N':
                  next = TileMap[newrow-1][newcol-1].getNorthLine();
                  break;
               
               case 'E':
                  next = TileMap[newrow-1][newcol-1].getEastLine();
                  break;
               
               case 'W':
                  next = TileMap[newrow-1][newcol-1].getWestLine();
                  break;
               
               case 'S':
                  next = TileMap[newrow-1][newcol-1].getSouthLine();
                  break;
                  
               default:
                  break;
            }
         }
         totallines++;//Increase the total number of lines (in this path)
         
      }while(!(first == next));//Keep going until there's no more paths and got to first line again
      
      if(totallines != countLines())//If the loop encountered does NOT match total # of lines
      {
         //System.out.println(("You've completed a continuous loop, but still have "+(countLines()-totallines)+" extra lines on the board!\n"));
         return false;
      }
      
      boolean isitok = true; //flag if one tile doesn't have correct amount of lines
      
      for(int i = 1; i <= row; i++)
      {
         for(int j = 1; j <= col; j++)
         {
            if((TileMap[i-1][j-1].getTileValueLines() == 4) && (TileMap[i-1][j-1].getTileVal() != 4)) 
            {
               //System.out.println("That little square you did doesn't net you the game, son!\nGet rid of it or make that larger");
               return false;
            }
            if((TileMap[i-1][j-1].getTileVal() != 5))//If has value
            {
               if(((TileMap[i-1][j-1].getTileValueLines()) != TileMap[i-1][j-1].getTileVal())) //If it doesn't equal the amt of lines in, false
               {
                  //System.out.println(("Tile ("+i+", "+j+") needs "+TileMap[i-1][j-1].getTileVal()+" line(s) instead of the "+TileMap[i-1][j-1].getTileValueLines()+" line(s) it has now."));
                  isitok=false;//make it false
               }
            }   
         }
      }
      System.out.println();
      if(!isitok)//Are there an equal number of lines total and lines in the path?
         return false;
      return true;//Every constraint satisfied; return correct answer
   
   }
   
   private boolean isThereDiverging(Tile t)//Diverging or other crap
   {
      Map.Tile.Line prev = null;//Set the previous line to null
      Map.Tile.Line first = null;//Set the first line to null
      Map.Tile.Line next = null;//Set the next line to null
      int newrow = 0, newcol = 0, totallines = 0;//Newrow and Newcol are the row and col; totallines counts the path--how many lines it takes.
      boolean flag = true, terminate = false;
      int tempnewrow = 0, tempnewcol = 0;//temporary row and col placeholders
      char whichline = 't';//unused initialized var
      
      if(t.getNorthLine().getStatus()) 
      {//Go through this if tree to get ONE starting line; if multiple lines in one tile, South Line will overwrite all having priority.
         whichline = 'N';
         first = next = t.getNorthLine(); 
      }
      else if(t.getEastLine().getStatus()) 
      {
         whichline = 'E';
         first = next = t.getEastLine();
      }
      else if(t.getWestLine().getStatus()) 
      { 
         whichline = 'W';
         first = next = t.getWestLine();
      }
      else if(t.getSouthLine().getStatus()) 
      {
         whichline = 'S';
         first = next = t.getSouthLine(); 
      }
      else
      //Find first instance of "lines"             
         for(int i = 1; i <= row; i++)
         {
            for(int j = 1; j <= col; j++)
            {
               if((TileMap[i-1][j-1].getTileValueLines() == 0)) 
                  continue;//if there're no lines on that tile, go to next tile (or new row)
            
               if(flag)//If we found a tile w/ lines
               {
                  terminate = true;//Terminate this loop
                  if(TileMap[i-1][j-1].getNorthLine().getStatus()) 
                  {//Go through this if tree to get ONE starting line; if multiple lines in one tile, South Line will overwrite all having priority.
                     whichline = 'N';
                     first = next = TileMap[i-1][j-1].getNorthLine(); 
                  }
                  else if(TileMap[i-1][j-1].getEastLine().getStatus()) 
                  {
                     whichline = 'E';
                     first = next = TileMap[i-1][j-1].getEastLine();
                  }
                  else if(TileMap[i-1][j-1].getWestLine().getStatus()) 
                  { 
                     whichline = 'W';
                     first = next = TileMap[i-1][j-1].getWestLine();
                  }
                  else if(TileMap[i-1][j-1].getSouthLine().getStatus()) 
                  {
                     whichline = 'S';
                     first = next = TileMap[i-1][j-1].getSouthLine(); 
                  }
                  newrow = i; 
                  newcol = j;
               
               }
               if(terminate)
                  break;
            }
            if(terminate) 
               break;
         }
      
      newrow = t.getRow(); 
      newcol = t.getCol();
      boolean areAllBanned = true;
      
      int testlines = 0;
      do
      {  
         areAllBanned = true;
      
         testlines = 0; //reset testline
         switch(whichline)
         {
            
            case 'N'://Case if NorthLine's activated, check rest around that line for path(s).
               if(newrow>1)//If not first row, check row above
               {
                  if(TileMap[newrow-2][newcol-1].getEastLine().getStatus() && (TileMap[newrow-2][newcol-1].getEastLine() != prev)) 
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
                  else if(!TileMap[newrow-2][newcol-1].getEastLine().getStatus() && !TileMap[newrow-2][newcol-1].getEastLine().isBanned())
                     areAllBanned = false;
                  
                  if(TileMap[newrow-2][newcol-1].getWestLine().getStatus() && (TileMap[newrow-2][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
                  else if(!TileMap[newrow-2][newcol-1].getWestLine().getStatus() && !TileMap[newrow-2][newcol-1].getWestLine().isBanned())
                     areAllBanned = false;
               }
               
               if(TileMap[newrow-1][newcol-1].getEastLine().getStatus() && (TileMap[newrow-1][newcol-1].getEastLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'E';
               }
               else if(!TileMap[newrow-1][newcol-1].getEastLine().getStatus() && !TileMap[newrow-1][newcol-1].getEastLine().isBanned())
                  areAllBanned = false;
               
               if(TileMap[newrow-1][newcol-1].getWestLine().getStatus() && (TileMap[newrow-1][newcol-1].getWestLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'W';
               }  
               else if(!TileMap[newrow-1][newcol-1].getWestLine().getStatus() && !TileMap[newrow-1][newcol-1].getWestLine().isBanned())
                  areAllBanned = false;
               
               if(newcol > 1)//If not first col, check column to left
               {
                  if(TileMap[newrow-1][newcol-2].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-2].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'N';
                  }
                  
                  else if(!TileMap[newrow-1][newcol-2].getNorthLine().getStatus() && !TileMap[newrow-1][newcol-2].getNorthLine().isBanned())
                     areAllBanned = false;
               }
               
               if(newcol < col)//If not last col, check column to right
               {
                  if(TileMap[newrow-1][newcol].getNorthLine().getStatus() && (TileMap[newrow-1][newcol].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'N';
                  }
                  else if(!TileMap[newrow-1][newcol].getNorthLine().getStatus() && !TileMap[newrow-1][newcol].getNorthLine().isBanned())
                     areAllBanned = false;
               }
               
               break;
            
            case 'E':
                                    
            
               if(newcol<col)
               {
                                 
               
                  if(TileMap[newrow-1][newcol].getNorthLine().getStatus() && (TileMap[newrow-1][newcol].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'N';
                  }
                  else if(!TileMap[newrow-1][newcol].getNorthLine().getStatus() && !TileMap[newrow-1][newcol].getNorthLine().isBanned())
                     areAllBanned = false;
                  
               
                  if(TileMap[newrow-1][newcol].getSouthLine().getStatus() && (TileMap[newrow-1][newcol].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'S';
                  }
                  else if(!TileMap[newrow-1][newcol].getSouthLine().getStatus() && !TileMap[newrow-1][newcol].getSouthLine().isBanned())
                     areAllBanned = false;
               
               
               }
               
               if(newrow>1)
               {
                  if(TileMap[newrow-2][newcol-1].getEastLine().getStatus() && (TileMap[newrow-2][newcol-1].getEastLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
                  else if(!TileMap[newrow-2][newcol-1].getEastLine().getStatus() && !TileMap[newrow-2][newcol-1].getEastLine().isBanned())
                     areAllBanned = false;
               }
               
               if(newrow < row)
               {
                  if(TileMap[newrow][newcol-1].getEastLine().getStatus() && (TileMap[newrow][newcol-1].getEastLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
                  else if(!TileMap[newrow][newcol-1].getEastLine().getStatus() && !TileMap[newrow][newcol-1].getEastLine().isBanned())
                     areAllBanned = false;
               }
               
               if(TileMap[newrow-1][newcol-1].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-1].getNorthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'N';
               }
               else if(!TileMap[newrow-1][newcol-1].getNorthLine().getStatus() && !TileMap[newrow-1][newcol-1].getNorthLine().isBanned())
                  areAllBanned = false;
            
               if(TileMap[newrow-1][newcol-1].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-1].getSouthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'S';
               }  
               else if(!TileMap[newrow-1][newcol-1].getSouthLine().getStatus() && !TileMap[newrow-1][newcol-1].getSouthLine().isBanned())
                  areAllBanned = false;
                  
               break;
               
            case 'W':
            
               if(newcol>1)
               {
               
                  if(TileMap[newrow-1][newcol-2].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-2].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'N';
                  }
                  else if(!TileMap[newrow-1][newcol-2].getNorthLine().getStatus() && !TileMap[newrow-1][newcol-2].getNorthLine().isBanned())
                     areAllBanned = false;
                  
                  if(TileMap[newrow-1][newcol-2].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-2].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'S';
                  }
                  else if(!TileMap[newrow-1][newcol-2].getSouthLine().getStatus() && !TileMap[newrow-1][newcol-2].getSouthLine().isBanned())
                     areAllBanned = false;
               
               }
               
               if(newrow>1)
               {
                  if(TileMap[newrow-2][newcol-1].getWestLine().getStatus() && (TileMap[newrow-2][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
                  else if(!TileMap[newrow-2][newcol-1].getWestLine().getStatus() && !TileMap[newrow-2][newcol-1].getWestLine().isBanned())
                     areAllBanned = false;
               }
               
               if(newrow < row)
               {
                  if(TileMap[newrow][newcol-1].getWestLine().getStatus() && (TileMap[newrow][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
                  else if(!TileMap[newrow][newcol-1].getWestLine().getStatus() && !TileMap[newrow][newcol-1].getWestLine().isBanned())
                     areAllBanned = false;
               }
            
               
               if(TileMap[newrow-1][newcol-1].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-1].getNorthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'N';
               }
               else if(!TileMap[newrow-1][newcol-1].getNorthLine().getStatus() && !TileMap[newrow-1][newcol-1].getNorthLine().isBanned())
                  areAllBanned = false;
                  
               if(TileMap[newrow-1][newcol-1].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-1].getSouthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'S';
               }  
               else if(!TileMap[newrow-1][newcol-1].getSouthLine().getStatus() && !TileMap[newrow-1][newcol-1].getSouthLine().isBanned())
                  areAllBanned = false;
               break;
               
            case 'S':
            
               if(newrow<row)//If not first row, check row above
               {
                  if(TileMap[newrow][newcol-1].getEastLine().getStatus() && (TileMap[newrow][newcol-1].getEastLine() != prev)) 
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
                  else if(!TileMap[newrow][newcol-1].getEastLine().getStatus() && !TileMap[newrow][newcol-1].getEastLine().isBanned())
                     areAllBanned = false;
                  
                  if(TileMap[newrow][newcol-1].getWestLine().getStatus() && (TileMap[newrow][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
                  else if(!TileMap[newrow][newcol-1].getWestLine().getStatus() && !TileMap[newrow][newcol-1].getWestLine().isBanned())
                     areAllBanned = false;
               }
               
               if(TileMap[newrow-1][newcol-1].getEastLine().getStatus() && (TileMap[newrow-1][newcol-1].getEastLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'E';
               }
               else if(!TileMap[newrow-1][newcol-1].getEastLine().getStatus() && !TileMap[newrow-1][newcol-1].getEastLine().isBanned())
                  areAllBanned = false;
               
               if(TileMap[newrow-1][newcol-1].getWestLine().getStatus() && (TileMap[newrow-1][newcol-1].getWestLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'W';
               }  
               else if(!TileMap[newrow-1][newcol-1].getWestLine().getStatus() && !TileMap[newrow-1][newcol-1].getWestLine().isBanned())
                  areAllBanned = false;
               
               if(newcol > 1)//If not first col, check column to left
               {
                  if(TileMap[newrow-1][newcol-2].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-2].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'S';
                  }
                  else if(!TileMap[newrow-1][newcol-2].getSouthLine().getStatus() && !TileMap[newrow-1][newcol-2].getSouthLine().isBanned())
                     areAllBanned = false;
               }
               
               if(newcol < col)//If not last col, check column to right
               {
                  if(TileMap[newrow-1][newcol].getSouthLine().getStatus() && (TileMap[newrow-1][newcol].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'S';
                  }
                  else if(!TileMap[newrow-1][newcol].getSouthLine().getStatus() && !TileMap[newrow-1][newcol].getSouthLine().isBanned())
                     areAllBanned = false;
               }
               break;
               
            default:
               break;
         
         }
         
         if(testlines == 0) //If no new path discovered
         {//Need to check if there's no way we can make a path with it..
            return areAllBanned;
         }    
           
         if(testlines > 1 && flag == false)//If more than one path and NOT first
         {
            //System.out.println("Here's divergence");  
            return true;
         }
         else
         {
            flag = false;//Turn flag off
            newrow = tempnewrow;//Set the row to the temporary placeholder
            newcol = tempnewcol;//Set the col to the temporary placeholder
            prev = next;//Change the one "next" to "prev."
            switch(whichline)
            {
               case 'N':
                  next = TileMap[newrow-1][newcol-1].getNorthLine();
                  break;
               
               case 'E':
                  next = TileMap[newrow-1][newcol-1].getEastLine();
                  break;
               
               case 'W':
                  next = TileMap[newrow-1][newcol-1].getWestLine();
                  break;
               
               case 'S':
                  next = TileMap[newrow-1][newcol-1].getSouthLine();
                  break;
                  
               default:
                  break;
            }
         }
         totallines++;//Increase the total number of lines (in this path)
         
      }while(!(first == next));//Keep going until there's no more paths and got to first line again
      
      if(totallines != countLines())//If the loop encountered does NOT match total # of lines
      {
         //System.out.println(("You've completed a continuous loop, but still have "+(lineNumber-totallines)+" extra lines on the board!\n"));
         return true;
      }
      
      boolean isitok = true; //flag if one tile doesn't have correct amount of lines
   
      
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
         {
               
            if((TileMap[r-1][c-1].getTileVal() != 5))//If has value
            {
               if(((TileMap[r-1][c-1].getTileValueLines()) != TileMap[r-1][c-1].getTileVal())) //If it doesn't equal the amt of lines in, false
               {
                  //System.out.println(("Tile ("+newrow+", "+newcol+") needs "+TileMap[r-1][c-1].getTileVal()+" line(s) instead of the "+TileMap[r-1][c-1].getTileValueLines()+" line(s) it has now."));
                  isitok=false;//make it false
               }
            } 
         
            if((TileMap[r-1][c-1].getTileValueLines()) > TileMap[r-1][c-1].getTileVal())
            {
               isitok = false;
               //System.out.println("We hit a major val");
            }
            
         }
            
      //System.out.println();
      if(!isitok)//Are there an equal number of lines total and lines in the path?
      {
         //System.out.println("We have a differing number of lines");
         return true;
      }
      return false;//Every constraint satisfied; return correct answer
   }
   
   private Tile findLowestRepresentations()//Find the tile with the fewest # of reps
   {
      Tile x = null; 
      int xnum = 999;
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
            if(!TileMap[r-1][c-1].isLocked())
               if(TileMap[r-1][c-1].getAllPossibleRepresentations() < xnum)
               {
                  x = TileMap[r-1][c-1];
                  xnum = TileMap[r-1][c-1].getAllPossibleRepresentations();
               }
      return x;
   }
   
   private Tile findLowestRepresentationsNum(Tile t)
   {
      Tile x = null;
      int xnum = 999;
      
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
            if(!TileMap[r-1][c-1].isLocked())
               if(TileMap[r-1][c-1].getTileVal() != 5)
                  if(TileMap[r-1][c-1].getAllPossibleRepresentations() <= xnum)
                  {
                     x = TileMap[r-1][c-1];
                     xnum = TileMap[r-1][c-1].getAllPossibleRepresentations();
                  }
      if(x != null)         
         return x;
      else 
         return findLowestRepresentations(t);
   }
   
   private Tile findLowestRepresentations(Tile t)//Find the tile with the fewest # of reps
   {
      int r = t.getRow();
      int c = t.getCol();
      
      Tile x = null; 
      int xnum = 999;
     
      if(r != row)       
         if(!TileMap[r][c-1].isLocked())
            if(TileMap[r][c-1].getAllPossibleRepresentations() < xnum)
            {
               x = TileMap[r][c-1];
               xnum = TileMap[r][c-1].getAllPossibleRepresentations();
            }
         
      if(r != 1)       
         if(!TileMap[r-2][c-1].isLocked())
            if(TileMap[r-2][c-1].getAllPossibleRepresentations() < xnum && TileMap[r-2][c-1].getAllPossibleRepresentations() != 0)
            {
               x = TileMap[r-2][c-1];
               xnum = TileMap[r-2][c-1].getAllPossibleRepresentations();
            }
         
      if(c != col)       
         if(!TileMap[r-1][c].isLocked())
            if(TileMap[r-1][c].getAllPossibleRepresentations() < xnum && TileMap[r-1][c].getAllPossibleRepresentations() != 0)
            {
               x = TileMap[r-1][c];
               xnum = TileMap[r-1][c].getAllPossibleRepresentations();
            }
         
      if(c != 1)       
         if(!TileMap[r-1][c-2].isLocked())
            if(TileMap[r-1][c-2].getAllPossibleRepresentations() < xnum && TileMap[r-1][c-2].getAllPossibleRepresentations() != 0)
            {
               x = TileMap[r-1][c-2];
               xnum = TileMap[r-1][c-2].getAllPossibleRepresentations();
            }
         
      if(x == null)
         return this.findLowestRepresentations();//If all tiles are locked around it... shouldn't be though
      return x;
   }
   
   public boolean areAllTilesLocked()
   {
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
            if(!TileMap[r-1][c-1].isLocked())
               return false;
      return true;
   }
   
   private void searchForTwo3s()
   {
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
         {
            if(TileMap[r-1][c-1].getTileVal() != 3) //If it's not a zero tile
               continue;//Skip it!
            
            if(r != row)
            {
               if(TileMap[r][c-1].getTileVal() == 3)
               {
                  TileMap[r-1][c-1].getSouthLine().turnOn();
                  this.addToMoveList(r,c,"Bottom",true);
               }
            }
            
            if(c != col)
            {
               if(TileMap[r-1][c].getTileVal() == 3)
               {
                  TileMap[r-1][c-1].getEastLine().turnOn();
                  this.addToMoveList(r,c,"Right",true);
               }
            }
         }
   }
  
   
   private void searchForZeroes()//Search for the zeroes
   {
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
         {
            if(TileMap[r-1][c-1].getTileVal() != 0) //If it's not a zero tile
               continue;//Skip it!
            TileMap[r-1][c-1].getNorthLine().setBanned();
            TileMap[r-1][c-1].getEastLine().setBanned();
            TileMap[r-1][c-1].getWestLine().setBanned();
            TileMap[r-1][c-1].getSouthLine().setBanned();
            TileMap[r-1][c-1].setLocked();
            
            if(r != 1)//Banning for 3s
            {
               if(c != 1)
                  if(TileMap[r-2][c-2].getTileVal() == 3)
                  {
                     TileMap[r-2][c-2].getEastLine().turnOn();
                     this.addToMoveList(r-1,c-1,"Right",true);
                  
                     TileMap[r-2][c-2].getSouthLine().turnOn();
                     this.addToMoveList(r-1,c-1,"Bottom",true);
                  }
               
               if(c != col)
                  if(TileMap[r-2][c].getTileVal() == 3)
                  {
                     TileMap[r-2][c].getWestLine().turnOn();
                     this.addToMoveList(r-1,c+1,"Right",true);
                  
                     TileMap[r-2][c].getSouthLine().turnOn();
                     this.addToMoveList(r-1,c+1,"Bottom",true);
                  }      
            }
            
            if( r != row)
            {
               if(c != 1)
                  if(TileMap[r][c-2].getTileVal() == 3)
                  {
                     TileMap[r][c-2].getEastLine().turnOn();
                     this.addToMoveList(r+1,c-1,"Right",true);
                  
                     TileMap[r][c-2].getNorthLine().turnOn();
                     this.addToMoveList(r+1,c-1,"Top",true);
                  }
               
               if(c != col)
                  if(TileMap[r][c].getTileVal() == 3)
                  {
                     TileMap[r][c].getWestLine().turnOn();
                     this.addToMoveList(r+1,c+1,"Right",true);
                  
                     TileMap[r][c].getNorthLine().turnOn();
                     this.addToMoveList(r+1,c+1,"Top",true);
                  }    
            }
            
            if(r == 1)//If zero is on first row
            {
               if(c != 1)
                  TileMap[r-1][c-2].getNorthLine().setBanned();
               if(c != col)
                  TileMap[r-1][c].getNorthLine().setBanned();
            }
            
            else if(r == row)//If zero is on last row
            {
               if(c != 1)
                  TileMap[r-1][c-2].getSouthLine().setBanned();//Ban line to left of zero.
               if(c != col)
                  TileMap[r-1][c].getSouthLine().setBanned();
            }
            
            if(c == 1)
            {
               if(r != 1)//If not first row
                  TileMap[r-2][c-1].getWestLine().setBanned();//Ban W line above 
               if(r != row)//If not last row
                  TileMap[r][c-1].getWestLine().setBanned();//Ban W line below 
            }
            
            else if( c == col)
            {
               if(r != 1)//If not first row
                  TileMap[r-2][c-1].getEastLine().setBanned();//Ban E line above 
               if(r != row)//If not last row
                  TileMap[r][c-1].getEastLine().setBanned();//Ban E line below 
            }
         }
   }
   
   private void searchCorners()
   {//Check all four corners, removing any representations that are impossible no matter what
      
      int indexTL = TileMap[0][0].al.size();
      for(int i = 0; i < indexTL; i++)
      {
         String TopLeft = TileMap[0][0].al.get(i);
         if(TopLeft == "TTFT" || TopLeft == "FTTT" || TopLeft == "FTTF" || TopLeft == "TFFT" || TopLeft == "FFTT" || TopLeft == "TTFF" || TopLeft == "FFTF" || TopLeft == "TFFF")
            //Above basically checks a bunch of stuff
         {
            TileMap[0][0].al.remove(i);
            indexTL--;
         }
      }
      if(TileMap[0][0].getSouthLine().getStatus() && TileMap[1][0].getWestLine().getStatus() && !TileMap[1][0].getEastLine().getStatus())
         for(int i = 0; i < TileMap[0][0].al.size(); i++)
         {
            if(TileMap[0][0].al.get(i) == "TFTT")
            {
               TileMap[0][0].al.remove(i);          
            }
         }
      else if(TileMap[0][0].getSouthLine().getStatus() && TileMap[1][0].getEastLine().getStatus() && !TileMap[1][0].getWestLine().getStatus())
         for(int i = 0; i < TileMap[0][0].al.size(); i++)
         {
            if(TileMap[0][0].al.get(i) == "FFFT")
            {
               TileMap[0][0].al.remove(i);          
            }
         }
   
      int indexBR = TileMap[row-1][col-1].al.size();        
      for(int i = 0; i < indexBR; i++) 
      { 
         String BottomRight = TileMap[row-1][col-1].al.get(i);
         if(BottomRight == "TTTF" || BottomRight == "TFTT" || BottomRight == "FTTF" || BottomRight == "TFFT" || BottomRight == "FFTT" || BottomRight == "TTFF" || BottomRight == "FFFT" || BottomRight == "FTFF")
         {
            TileMap[row-1][col-1].al.remove(i);
            indexBR--;
         }
      }
   
      
      int indexTR = TileMap[0][col-1].al.size();
      for(int i = 0; i < indexTR; i++)
      {      
         String TopRight = TileMap[0][col-1].al.get(i);
         if(TopRight == "TFTT" || TopRight == "FTTT" || TopRight == "TFTF" || TopRight == "FTFT" || TopRight == "FTTF" || TopRight == "TFFT" || TopRight == "TFFF" || TopRight == "FTFF")
         {
            TileMap[0][col-1].al.remove(i);
            indexTR--;
         }
      }
      
      //if(TileMap[0][col-2].getNorthLine()
      
      int indexBL = TileMap[row-1][0].al.size();
      for(int i = 0; i < indexBL; i++)
      {  
         String BottomLeft = TileMap[row-1][0].al.get(i);    
         if(BottomLeft == "TTTF" || BottomLeft == "TTFT" || BottomLeft == "FTTF" || BottomLeft == "TFFT" || BottomLeft == "TFTF" || BottomLeft == "FTFT" || BottomLeft == "FFTF" || BottomLeft == "FFFT")
         {
            TileMap[row-1][0].al.remove(i);
            indexBL--;
         }
      }
      if(TileMap[row-2][0].getSouthLine().getStatus())
         if(TileMap[row-2][0].getWestLine().getStatus() && !TileMap[row-2][0].getEastLine().getStatus())
            this.removeOneBadRep(TileMap[row-1][0], "TFTT");
         else if(TileMap[row-2][0].getEastLine().getStatus() && !TileMap[row-2][0].getWestLine().getStatus())
            this.removeOneBadRep(TileMap[row-1][0], "TFFF");
   }
   
   //private boolean ifTurnedOnWillThereBeZeroTiles(Map.Tile t, String representation, 
   
   private boolean ifTurnedOnisMiniLoop(Map.Tile.Line l, int r, int c, char Dir)
   {//If the line argument entered is turned on and creates a mini-loop... ban it by sending True
   
      l.turnOn();
      Map.Tile.Line prev = null;//Set the previous line to null
      Map.Tile.Line first = l;//Set the first line to l
      Map.Tile.Line next = l;//Set the next line to l
      int newrow = r, newcol = c, totallines = 0;//Newrow and Newcol are the row and col; totallines counts the path--how many lines it takes.
      int tempnewrow = 0, tempnewcol = 0;//temporary row and col placeholders
      char whichline = Dir;//unused initialized var
      int testlines = 0;
      boolean flag = true;//this is the beginning
      
      do
      { 
         testlines = 0; //reset testline
         switch(whichline)
         {
         
            case 'N'://Case if NorthLine's activated, check rest around that line for path(s).
               if(newrow>1)//If not first row, check row above
               {
                  if(TileMap[newrow-2][newcol-1].getEastLine().getStatus() && (TileMap[newrow-2][newcol-1].getEastLine() != prev)) 
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
                  
                  if(TileMap[newrow-2][newcol-1].getWestLine().getStatus() && (TileMap[newrow-2][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
               }
               
               if(TileMap[newrow-1][newcol-1].getEastLine().getStatus() && (TileMap[newrow-1][newcol-1].getEastLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'E';
               }
               
               if(TileMap[newrow-1][newcol-1].getWestLine().getStatus() && (TileMap[newrow-1][newcol-1].getWestLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'W';
               }  
               
               if(newcol > 1)//If not first col, check column to left
               {
                  if(TileMap[newrow-1][newcol-2].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-2].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'N';
                  }
               }
               
               if(newcol < col)//If not last col, check column to right
               {
                  if(TileMap[newrow-1][newcol].getNorthLine().getStatus() && (TileMap[newrow-1][newcol].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'N';
                  }
               }
               
               break;
            
            case 'E':
               if(newcol<col)
               {
                  if(TileMap[newrow-1][newcol].getNorthLine().getStatus() && (TileMap[newrow-1][newcol].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'N';
                  }
                  
                  if(TileMap[newrow-1][newcol].getSouthLine().getStatus() && (TileMap[newrow-1][newcol].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'S';
                  }
               }
               
               if(newrow>1)
               {
                  if(TileMap[newrow-2][newcol-1].getEastLine().getStatus() && (TileMap[newrow-2][newcol-1].getEastLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
               }
               
               if(newrow < row)
               {
                  if(TileMap[newrow][newcol-1].getEastLine().getStatus() && (TileMap[newrow][newcol-1].getEastLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
               }
               
               if(TileMap[newrow-1][newcol-1].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-1].getNorthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'N';
               }
                  
               if(TileMap[newrow-1][newcol-1].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-1].getSouthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'S';
               }  
            
               break;
               
            case 'W':
            
               if(newcol>1)
               {
                  if(TileMap[newrow-1][newcol-2].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-2].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'N';
                  }
                  
                  if(TileMap[newrow-1][newcol-2].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-2].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'S';
                  }
               }
               
               if(newrow>1)
               {
                  if(TileMap[newrow-2][newcol-1].getWestLine().getStatus() && (TileMap[newrow-2][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
               }
               
               if(newrow < row)
               {
                  if(TileMap[newrow][newcol-1].getWestLine().getStatus() && (TileMap[newrow][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
               }
               
               if(TileMap[newrow-1][newcol-1].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-1].getNorthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'N';
               }
                  
               if(TileMap[newrow-1][newcol-1].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-1].getSouthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'S';
               }  
               break;
               
            case 'S':
            
               if(newrow<row)//If not first row, check row above
               {
                  if(TileMap[newrow][newcol-1].getEastLine().getStatus() && (TileMap[newrow][newcol-1].getEastLine() != prev)) 
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
                  
                  if(TileMap[newrow][newcol-1].getWestLine().getStatus() && (TileMap[newrow][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
               }
               
               if(TileMap[newrow-1][newcol-1].getEastLine().getStatus() && (TileMap[newrow-1][newcol-1].getEastLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'E';
               }
               
               if(TileMap[newrow-1][newcol-1].getWestLine().getStatus() && (TileMap[newrow-1][newcol-1].getWestLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'W';
               }  
               
               if(newcol > 1)//If not first col, check column to left
               {
                  if(TileMap[newrow-1][newcol-2].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-2].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'S';
                  }
               }
               
               if(newcol < col)//If not last col, check column to right
               {
                  if(TileMap[newrow-1][newcol].getSouthLine().getStatus() && (TileMap[newrow-1][newcol].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'S';
                  }
               }
               break;
               
            default:
               break;
         
         }
         if(testlines == 0) //If no new path discovered
         {
            l.turnOff();
            return false; 
         }
         if(testlines > 1 && flag == false)//If more than one path
         {
            //System.out.println("WARNING: This board will not generate a solution in the future.\nYou have a diverging path.\n");  
            l.turnOff();
            return true;
         }
         else
         {
            flag = false;
            newrow = tempnewrow;//Set the row to the temporary placeholder
            newcol = tempnewcol;//Set the col to the temporary placeholder
            prev = next;//Change the one "next" to "prev."
            switch(whichline)
            {
               case 'N':
                  next = TileMap[newrow-1][newcol-1].getNorthLine();
                  break;
               
               case 'E':
                  next = TileMap[newrow-1][newcol-1].getEastLine();
                  break;
               
               case 'W':
                  next = TileMap[newrow-1][newcol-1].getWestLine();
                  break;
               
               case 'S':
                  next = TileMap[newrow-1][newcol-1].getSouthLine();
                  break;
                  
               default:
                  break;
            }
         }
         totallines++;//Increase the total number of lines (in this path)
         
      }while(!(first == next));//Keep going until there's no more paths and got to first line again
      
      if(totallines != countLines())//If the loop encountered does NOT match total # of lines
      {
         //System.out.println(("You've completed a continuous loop, but still have "+(lineNumber-totallines)+" extra lines on the board!\n"));
         //System.out.println(("["+r+"]["+c+"]"));
         //System.out.println("WE GOT ONE CONTINUAL LOOP BAN");
         l.turnOff();
         return true;
      }
      l.turnOff();
      return false;
   }
   
   private void checkForMoreBans()//Check for bans or lines.
   {
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
         {
         /*
            if(TileMap[r-1][c-1].isLocked())
            {
               continue;//If locked, we don't care, now do we? Move on.
            }*/
            
            if(c == 1)
            {//CHECKING FOR BANS ON WEST BB
               if(!TileMap[r-1][c-1].getWestLine().getStatus())
               {//If not on...
                  if(r < row)
                     if(TileMap[r-1][c-1].getSouthLine().isBanned() && TileMap[r][c-1].getWestLine().isBanned())
                        TileMap[r-1][c-1].getWestLine().setBanned();
                  if(r > 1)
                     if(TileMap[r-1][c-1].getNorthLine().isBanned() && TileMap[r-2][c-1].getWestLine().isBanned())
                        TileMap[r-1][c-1].getWestLine().setBanned();
                  if(r == 1)
                     if(TileMap[r-1][c-1].getNorthLine().isBanned())
                        TileMap[r-1][c-1].getWestLine().setBanned();
                  if(r == row)
                     if(TileMap[r-1][c-1].getSouthLine().isBanned())
                        TileMap[r-1][c-1].getWestLine().setBanned();
               
                  if(!TileMap[r-1][c-1].getWestLine().isBanned())
                     if(ifTurnedOnisMiniLoop(TileMap[r-1][c-1].getWestLine(),r,c,'W'))
                        TileMap[r-1][c-1].getWestLine().setBanned();
               }
            }
            if(r == row)
            {
               if(!TileMap[r-1][c-1].getSouthLine().getStatus())
               {
                  if(c > 1)
                     if(TileMap[r-1][c-1].getWestLine().isBanned() && TileMap[r-1][c-2].getSouthLine().isBanned())
                        TileMap[r-1][c-1].getSouthLine().setBanned();        
                  if(c < col)
                     if(TileMap[r-1][c-1].getEastLine().isBanned() && TileMap[r-1][c].getSouthLine().isBanned())
                        TileMap[r-1][c-1].getSouthLine().setBanned();
                  if(c == 1)
                     if(TileMap[r-1][c-1].getWestLine().isBanned())
                        TileMap[r-1][c-1].getSouthLine().isBanned();
                  if(c == col)
                     if(TileMap[r-1][c-1].getEastLine().isBanned())
                        TileMap[r-1][c-1].getSouthLine().isBanned();
               
                  if(!TileMap[r-1][c-1].getSouthLine().isBanned())
                     if(ifTurnedOnisMiniLoop(TileMap[r-1][c-1].getSouthLine(),r,c,'S'))
                        TileMap[r-1][c-1].getSouthLine().setBanned();
               }
            }
            
            if(!TileMap[r-1][c-1].getEastLine().getStatus())
            {
               if(c < col && r > 1)//If in middle...check all three lines up
                  if(TileMap[r-1][c-1].getNorthLine().isBanned() && TileMap[r-1][c].getNorthLine().isBanned() && TileMap[r-2][c-1].getEastLine().isBanned())
                     TileMap[r-1][c-1].getEastLine().setBanned();
               if(c < col && r < row)//If in middle... check all three lines down for banning
                  if(TileMap[r-1][c-1].getSouthLine().isBanned() && TileMap[r-1][c].getSouthLine().isBanned() && TileMap[r][c-1].getEastLine().isBanned())
                     TileMap[r-1][c-1].getEastLine().setBanned();
               if(c == col)//If we're checking out the last col
               {
                  if(r > 1 && r < row)
                  {
                     if(TileMap[r-1][c-1].getNorthLine().isBanned() && TileMap[r-2][c-1].getEastLine().isBanned())
                        TileMap[r-1][c-1].getEastLine().setBanned();
                     if(TileMap[r-1][c-1].getSouthLine().isBanned() && TileMap[r][c-1].getEastLine().isBanned())
                        TileMap[r-1][c-1].getEastLine().setBanned();   
                  } 
                  if(r == 1)
                     if(TileMap[r-1][c-1].getNorthLine().isBanned())
                        TileMap[r-1][c-1].getEastLine().setBanned();
                  if(r == row)
                     if(TileMap[r-1][c-1].getSouthLine().isBanned())
                        TileMap[r-1][c-1].getEastLine().setBanned();
               }
             
               if(!TileMap[r-1][c-1].getEastLine().isBanned())
                  if(ifTurnedOnisMiniLoop(TileMap[r-1][c-1].getEastLine(),r,c,'E'))
                     TileMap[r-1][c-1].getEastLine().setBanned();
                    
            }
            
            if(!TileMap[r-1][c-1].getNorthLine().getStatus())
            {
               
               if(r > 1 && c > 1)
                  if(TileMap[r-1][c-1].getWestLine().isBanned() && TileMap[r-1][c-2].getNorthLine().isBanned() && TileMap[r-2][c-1].getWestLine().isBanned())
                     TileMap[r-1][c-1].getNorthLine().setBanned();
               if(r > 1 && c < col)
                  if(TileMap[r-1][c-1].getEastLine().isBanned() && TileMap[r-1][c].getNorthLine().isBanned() && TileMap[r-2][c-1].getEastLine().isBanned())
                     TileMap[r-1][c-1].getNorthLine().setBanned();
               if(r == 1)
               {
                  if(c == 1)
                     if(TileMap[r-1][c-1].getWestLine().isBanned())
                        TileMap[r-1][c-1].getNorthLine().setBanned();
                  if(c == col)
                     if(TileMap[r-1][c-1].getEastLine().isBanned())
                        TileMap[r-1][c-1].getNorthLine().setBanned();
                  if(c > 1 && c < col)
                     if(TileMap[r-1][c-2].getNorthLine().isBanned() && TileMap[r-1][c-1].getWestLine().isBanned())
                        TileMap[r-1][c-1].getNorthLine().setBanned();
               
               }
               
               if(!TileMap[r-1][c-1].getNorthLine().isBanned())
                  if(ifTurnedOnisMiniLoop(TileMap[r-1][c-1].getNorthLine(),r,c,'N'))
                     TileMap[r-1][c-1].getNorthLine().setBanned();
            }
            
            if(TileMap[r-1][c-1].getNorthLine().getStatus())//Check for straight lines
            {
               if(c < col)
                  if(TileMap[r-1][c].getNorthLine().getStatus())
                  {
                     TileMap[r-1][c-1].getEastLine().setBanned();//Ban line lower
                     if(r > 1) 
                        TileMap[r-2][c-1].getEastLine().setBanned();//Ban line upper too
                  }
            }
            
            if(TileMap[r-1][c-1].getEastLine().getStatus())//Check for straight lines
            {
               if(r < row)
                  if(TileMap[r][c-1].getEastLine().getStatus())
                  {
                     TileMap[r-1][c-1].getSouthLine().setBanned();
                     if(c < col) 
                        TileMap[r-1][c].getSouthLine().setBanned();   
                  }
            }
            
            if(c == 1)
               if(TileMap[r-1][c-1].getWestLine().getStatus())//Check for straight lines
               {
                  if(r < row)
                     if(TileMap[r][c-1].getWestLine().getStatus())
                        TileMap[r-1][c-1].getSouthLine().setBanned();
               }
            
            if(r == row)
               if(TileMap[r-1][c-1].getSouthLine().getStatus())//Check for straight lines
               {
                  if(c < col)
                     if(TileMap[r-1][c].getSouthLine().getStatus())
                        TileMap[r-1][c-1].getEastLine().setBanned();
               }
         }   
   }
   
   private void checkForMoreLines()//Check for more lines...
   {
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
         {
            if(TileMap[r-1][c-1].getNorthLine().getStatus() && !TileMap[r-1][c-1].getNorthLine().isBanned())
            {//If the north line was on...
               if(c < col && r > 1)//If in middle
               {
                  if(TileMap[r-2][c-1].getEastLine().isBanned() && TileMap[r-1][c].getNorthLine().isBanned() && !TileMap[r-1][c-1].getEastLine().isBanned())
                     if(!TileMap[r-1][c-1].getEastLine().getStatus())
                     {
                        TileMap[r-1][c-1].getEastLine().turnOn();
                        this.addToMoveList(r,c,"Right",true);
                     }
                  if(TileMap[r-2][c-1].getEastLine().isBanned() && !TileMap[r-1][c].getNorthLine().isBanned() && TileMap[r-1][c-1].getEastLine().isBanned())
                     if(!TileMap[r-1][c].getNorthLine().getStatus())
                     {
                        TileMap[r-1][c].getNorthLine().turnOn();
                        this.addToMoveList(r,c+1,"Top", true);
                     }
                  if(!TileMap[r-2][c-1].getEastLine().isBanned() && TileMap[r-1][c].getNorthLine().isBanned() && TileMap[r-1][c-1].getEastLine().isBanned())
                     if(!TileMap[r-2][c-1].getEastLine().getStatus())
                     {
                        TileMap[r-2][c-1].getEastLine().turnOn();
                        this.addToMoveList(r-1,c,"Right",true);
                     }    
               }
               
               if(c > 1 && r > 1)//If in middle again
               {
                  if(TileMap[r-2][c-1].getWestLine().isBanned() && TileMap[r-1][c-2].getNorthLine().isBanned() && !TileMap[r-1][c-1].getWestLine().isBanned())
                     if(!TileMap[r-1][c-1].getWestLine().getStatus())
                     {
                        TileMap[r-1][c-1].getWestLine().turnOn();
                        this.addToMoveList(r,c,"Left",true);
                     }
                  if(TileMap[r-2][c-1].getWestLine().isBanned() && !TileMap[r-1][c-2].getNorthLine().isBanned() && TileMap[r-1][c-1].getWestLine().isBanned())
                     if(!TileMap[r-1][c-2].getNorthLine().getStatus())
                     {
                        TileMap[r-1][c-2].getNorthLine().turnOn();
                        this.addToMoveList(r,c-1,"Top",true);
                     }
                  if(!TileMap[r-2][c-1].getWestLine().isBanned() && TileMap[r-1][c-2].getNorthLine().isBanned() && TileMap[r-1][c-1].getWestLine().isBanned())
                     if(!TileMap[r-2][c-1].getWestLine().getStatus())
                     {
                        TileMap[r-2][c-1].getWestLine().turnOn();
                        this.addToMoveList(r-1,c,"Left",true);
                     }
               }
               if(c == 1 && r > 1)
               {
                  if(TileMap[r-1][c-1].getWestLine().isBanned() && !TileMap[r-2][c-1].getWestLine().isBanned())
                     if(!TileMap[r-2][c-1].getWestLine().getStatus())
                     {
                        TileMap[r-2][c-1].getWestLine().turnOn();
                        this.addToMoveList(r-1,c,"Left",true);
                     }
                  if(!TileMap[r-1][c-1].getWestLine().isBanned() && TileMap[r-2][c-1].getWestLine().isBanned())
                     if(!TileMap[r-1][c-1].getWestLine().getStatus())
                     {
                        TileMap[r-1][c-1].getWestLine().turnOn();
                        this.addToMoveList(r,c,"Left",true);
                     }
               }
               if(c == col && r > 1)
               {
                  if(TileMap[r-2][c-1].getEastLine().isBanned() && !TileMap[r-1][c-1].getEastLine().isBanned())
                     if(!TileMap[r-1][c-1].getEastLine().getStatus())
                     {
                        TileMap[r-1][c-1].getEastLine().turnOn();
                        this.addToMoveList(r,c,"Right",true);
                     }
                  if(!TileMap[r-2][c-1].getEastLine().isBanned() && TileMap[r-1][c-1].getEastLine().isBanned())
                     if(!TileMap[r-2][c-1].getEastLine().getStatus())
                     {
                        TileMap[r-2][c-1].getEastLine().turnOn();
                        this.addToMoveList(r-1,c,"Right",true);
                     }
               }
               
               
               if(r == 1)
               {
                  if(c == col)
                  {
                     if(!TileMap[r-1][c-1].getEastLine().getStatus())
                     {
                        TileMap[r-1][c-1].getEastLine().turnOn();
                        this.addToMoveList(r,c,"Right",true);
                     }
                         
                     if(TileMap[r-1][c-2].getNorthLine().isBanned() && !TileMap[r-1][c-1].getWestLine().isBanned())
                        if(!TileMap[r-1][c-1].getWestLine().getStatus())
                        {
                           TileMap[r-1][c-1].getWestLine().turnOn();
                           this.addToMoveList(r,c,"Left",true);
                        }
                        
                     if(!TileMap[r-1][c-2].getNorthLine().isBanned() && TileMap[r-1][c-1].getWestLine().isBanned())      
                        if(!TileMap[r-1][c-2].getNorthLine().getStatus())
                        {
                           TileMap[r-1][c-2].getNorthLine().turnOn();
                           this.addToMoveList(r,c-1,"Top",true);
                        }
                     
                    
                     
                     
                  }
                  if(c == 1)
                  {
                     if(!TileMap[r-1][c-1].getWestLine().getStatus())
                     {
                        TileMap[r-1][c-1].getWestLine().turnOn();
                        this.addToMoveList(r,c,"Left",true);
                     }
                     
                     if(TileMap[r-1][c-1].getEastLine().isBanned() && !TileMap[r-1][c].getNorthLine().isBanned())
                        if(!TileMap[r-1][c].getNorthLine().getStatus())
                        {
                           TileMap[r-1][c].getNorthLine().turnOn();
                           this.addToMoveList(r,c+1,"Top",true);
                        }
                     if(!TileMap[r-1][c-1].getEastLine().isBanned() && TileMap[r-1][c].getNorthLine().isBanned())
                        if(!TileMap[r-1][c-1].getEastLine().getStatus())
                        {
                           TileMap[r-1][c-1].getEastLine().turnOn();
                           this.addToMoveList(r,c,"Right",true);
                        }
                  }
                  if(c > 1 && c < col)
                  {
                     if(TileMap[r-1][c-2].getNorthLine().isBanned() && !TileMap[r-1][c-1].getWestLine().isBanned())
                        if(!TileMap[r-1][c-1].getWestLine().getStatus())
                        {
                           TileMap[r-1][c-1].getWestLine().turnOn();
                           this.addToMoveList(r,c,"Left",true);
                        }
                     if(!TileMap[r-1][c-2].getNorthLine().isBanned() && TileMap[r-1][c-1].getWestLine().isBanned())
                        if(!TileMap[r-1][c-2].getNorthLine().getStatus())
                        {
                           TileMap[r-1][c-2].getNorthLine().turnOn();
                           this.addToMoveList(r,c-1,"Top",true);
                        }
                     if(TileMap[r-1][c].getNorthLine().isBanned() && !TileMap[r-1][c-1].getEastLine().isBanned())
                        if(!TileMap[r-1][c-1].getEastLine().getStatus())
                        {
                           TileMap[r-1][c-1].getEastLine().turnOn();
                           this.addToMoveList(r,c,"Right",true);
                        }
                     if(!TileMap[r-1][c].getNorthLine().isBanned() && TileMap[r-1][c-1].getEastLine().isBanned())   
                        if(!TileMap[r-1][c].getNorthLine().getStatus())
                        {
                           TileMap[r-1][c].getNorthLine().turnOn();
                           this.addToMoveList(r,c+1,"Top",true);
                        }
                  }                  
               }
            }
               
            if(TileMap[r-1][c-1].getEastLine().getStatus())
            {
               if(r > 1 && c < col)
               {
                  if(TileMap[r-1][c-1].getNorthLine().isBanned() && TileMap[r-2][c-1].getEastLine().isBanned() && !TileMap[r-1][c].getNorthLine().isBanned())
                     if(!TileMap[r-1][c].getNorthLine().getStatus())
                     {
                        TileMap[r-1][c].getNorthLine().turnOn();
                        this.addToMoveList(r,c+1,"Top",true);
                     }
                  if(TileMap[r-1][c-1].getNorthLine().isBanned() && !TileMap[r-2][c-1].getEastLine().isBanned() && TileMap[r-1][c].getNorthLine().isBanned())
                     if(!TileMap[r-2][c-1].getEastLine().getStatus())
                     {
                        TileMap[r-2][c-1].getEastLine().turnOn();
                        this.addToMoveList(r-1,c,"Right",true);
                     }
                     
                  if(!TileMap[r-1][c-1].getNorthLine().isBanned() && TileMap[r-2][c-1].getEastLine().isBanned() && TileMap[r-1][c].getNorthLine().isBanned())
                     if(!TileMap[r-1][c-1].getNorthLine().getStatus())
                     {
                        TileMap[r-1][c-1].getNorthLine().turnOn();
                        this.addToMoveList(r,c,"Top",true);
                     }
               }
               
               if(r < row && c < col)
               {
                  if(TileMap[r-1][c-1].getSouthLine().isBanned() && TileMap[r][c-1].getEastLine().isBanned() && !TileMap[r-1][c].getSouthLine().isBanned())
                     if(!TileMap[r-1][c].getSouthLine().getStatus())
                     {
                        TileMap[r-1][c].getSouthLine().turnOn();
                        this.addToMoveList(r,c+1,"Bottom",true);
                     }
                  if(TileMap[r-1][c-1].getSouthLine().isBanned() && !TileMap[r][c-1].getEastLine().isBanned() && TileMap[r-1][c].getSouthLine().isBanned())
                     if(!TileMap[r][c-1].getEastLine().getStatus())
                     {
                        TileMap[r][c-1].getEastLine().turnOn();
                        this.addToMoveList(r+1,c,"Right",true);
                     }
                  if(!TileMap[r-1][c-1].getSouthLine().isBanned() && TileMap[r][c-1].getEastLine().isBanned() && TileMap[r-1][c].getSouthLine().isBanned())
                     if(!TileMap[r-1][c-1].getSouthLine().getStatus())
                     {
                        TileMap[r-1][c-1].getSouthLine().turnOn();
                        this.addToMoveList(r,c,"Bottom",true);
                     }  
               }
               
               if(r == row && c < col)
               {
                  if(TileMap[r-1][c-1].getSouthLine().isBanned() && !TileMap[r-1][c].getSouthLine().isBanned())
                     if(!TileMap[r-1][c].getSouthLine().getStatus())
                     {
                        TileMap[r-1][c].getSouthLine().turnOn();
                        this.addToMoveList(r,c+1,"Bottom",true);
                     }
                  if(!TileMap[r-1][c-1].getSouthLine().isBanned() && TileMap[r-1][c].getSouthLine().isBanned())
                     if(!TileMap[r-1][c-1].getSouthLine().getStatus())
                     {
                        TileMap[r-1][c-1].getSouthLine().turnOn();
                        this.addToMoveList(r,c,"Bottom",true);
                     }  
               }
               
               if(r == 1 && c < col)
               {
                  if(TileMap[r-1][c-1].getNorthLine().isBanned() && !TileMap[r-1][c].getNorthLine().isBanned())
                     if(!TileMap[r-1][c].getNorthLine().getStatus())
                     {
                        TileMap[r-1][c].getNorthLine().turnOn();
                        this.addToMoveList(r,c+1,"Top",true);
                     }
                  if(!TileMap[r-1][c-1].getNorthLine().isBanned() && TileMap[r-1][c].getNorthLine().isBanned())
                     if(!TileMap[r-1][c-1].getNorthLine().getStatus())
                     {
                        TileMap[r-1][c-1].getNorthLine().turnOn();
                        this.addToMoveList(r,c,"Top",true);
                     }  
               }
               
               if(c == col)
               {
                  if(r > 1 && r < row)
                  {
                     if(TileMap[r-1][c-1].getNorthLine().isBanned() && !TileMap[r-2][c-1].getEastLine().isBanned())
                        if(!TileMap[r-2][c-1].getEastLine().getStatus())
                        {
                           TileMap[r-2][c-1].getEastLine().turnOn();
                           this.addToMoveList(r-1,c,"Right",true);
                        }
                     if(!TileMap[r-1][c-1].getNorthLine().isBanned() && TileMap[r-2][c-1].getEastLine().isBanned())
                        if(!TileMap[r-1][c-1].getNorthLine().getStatus())
                        {
                           TileMap[r-1][c-1].getNorthLine().turnOn();
                           this.addToMoveList(r,c,"Top",true);
                        }
                     if(TileMap[r-1][c-1].getSouthLine().isBanned() && !TileMap[r][c-1].getEastLine().isBanned())
                        if(!TileMap[r][c-1].getEastLine().getStatus())
                        {
                           TileMap[r][c-1].getEastLine().turnOn();
                           this.addToMoveList(r+1,c,"Right",true);
                        }
                     if(!TileMap[r-1][c-1].getSouthLine().isBanned() && TileMap[r][c-1].getEastLine().isBanned())
                        if(!TileMap[r-1][c-1].getSouthLine().getStatus())
                        {
                           TileMap[r-1][c-1].getSouthLine().turnOn();
                           this.addToMoveList(r,c,"Bottom",true);
                        }
                  }
                  
                  if(r == 1)
                  {
                     if(!TileMap[r-1][c-1].getNorthLine().getStatus())
                     {
                        TileMap[r-1][c-1].getNorthLine().turnOn();
                        this.addToMoveList(r,c,"Top",true);
                     }
                     
                     if(TileMap[r][c-1].getEastLine().isBanned() && !TileMap[r-1][c-1].getSouthLine().isBanned())
                        if(!TileMap[r-1][c-1].getSouthLine().getStatus())
                        {
                           TileMap[r-1][c-1].getSouthLine().turnOn();
                           this.addToMoveList(r,c,"Bottom",true);
                        }
                     if(!TileMap[r][c-1].getEastLine().isBanned() && TileMap[r-1][c-1].getSouthLine().isBanned())
                        if(!TileMap[r][c-1].getEastLine().getStatus())
                        {
                           TileMap[r][c-1].getEastLine().turnOn();
                           this.addToMoveList(r+1,c,"Right",true);
                        }
                  }
                  
                  if(r == row)
                  {
                     if(!TileMap[r-1][c-1].getSouthLine().getStatus())
                     {
                        TileMap[r-1][c-1].getSouthLine().turnOn();
                        this.addToMoveList(r,c,"Bottom",true);
                     }
                     
                     if(TileMap[r-2][c-1].getEastLine().isBanned() && !TileMap[r-1][c-1].getNorthLine().isBanned())
                        if(!TileMap[r-1][c-1].getNorthLine().getStatus())
                        {
                           TileMap[r-1][c-1].getNorthLine().turnOn();
                           this.addToMoveList(r,c,"Top",true);
                        }
                     if(!TileMap[r-2][c-1].getEastLine().isBanned() && TileMap[r-1][c-1].getNorthLine().isBanned())
                        if(!TileMap[r-2][c-1].getEastLine().getStatus())
                        {
                           TileMap[r-2][c-1].getEastLine().turnOn();
                           this.addToMoveList(r-1,c,"Right",true);
                        }   
                  }
               }
            }
               
            if(c == 1)
               if(TileMap[r-1][c-1].getWestLine().getStatus())
               {
                  if(r > 1 && r < row)
                  {
                     if(TileMap[r-2][c-1].getWestLine().isBanned() && !TileMap[r-1][c-1].getNorthLine().isBanned())
                        if(!TileMap[r-1][c-1].getNorthLine().getStatus())
                        {
                           TileMap[r-1][c-1].getNorthLine().turnOn();
                           this.addToMoveList(r,c,"Top",true);
                        }
                     if(!TileMap[r-2][c-1].getWestLine().isBanned() && TileMap[r-1][c-1].getNorthLine().isBanned())
                        if(!TileMap[r-2][c-1].getWestLine().getStatus())
                        {
                           TileMap[r-2][c-1].getWestLine().turnOn();
                           this.addToMoveList(r-1,c,"Left",true);
                        }
                        
                     if(TileMap[r][c-1].getWestLine().isBanned() && !TileMap[r-1][c-1].getSouthLine().isBanned())
                        if(!TileMap[r-1][c-1].getSouthLine().getStatus())
                        {
                           TileMap[r-1][c-1].getSouthLine().turnOn();
                           this.addToMoveList(r,c,"Bottom",true);
                        }
                     if(!TileMap[r][c-1].getWestLine().isBanned() && TileMap[r-1][c-1].getSouthLine().isBanned())
                        if(!TileMap[r][c-1].getWestLine().getStatus())
                        {
                           TileMap[r][c-1].getWestLine().turnOn();
                           this.addToMoveList(r+1,c,"Left",true);
                        }
                  }  
                  if(r == 1)
                  {
                     if(!TileMap[r-1][c-1].getNorthLine().getStatus())
                     {
                        TileMap[r-1][c-1].getNorthLine().turnOn();
                        this.addToMoveList(r,c,"Top",true);
                     }
                     if(TileMap[r][c-1].getWestLine().isBanned() && !TileMap[r-1][c-1].getSouthLine().isBanned())
                        if(!TileMap[r-1][c-1].getSouthLine().getStatus())
                        {
                           TileMap[r-1][c-1].getSouthLine().turnOn();
                           this.addToMoveList(r,c,"Bottom",true);
                        }
                     if(!TileMap[r][c-1].getWestLine().isBanned() && TileMap[r-1][c-1].getSouthLine().isBanned())
                        if(!TileMap[r][c-1].getWestLine().getStatus())
                        {
                           TileMap[r][c-1].getWestLine().turnOn();
                           this.addToMoveList(r+1,c,"Left",true);
                        }
                  }
                  if(r == row)
                  {
                     if(!TileMap[r-1][c-1].getSouthLine().getStatus())
                     {
                        TileMap[r-1][c-1].getSouthLine().turnOn();
                        this.addToMoveList(r,c,"Bottom",true);
                     }   
                     
                     if(TileMap[r-2][c-1].getWestLine().isBanned() && !TileMap[r-1][c-1].getNorthLine().isBanned())
                        if(!TileMap[r-1][c-1].getNorthLine().getStatus())
                        {
                           TileMap[r-1][c-1].getNorthLine().turnOn();
                           this.addToMoveList(r,c,"Top",true);
                        }
                     if(!TileMap[r-2][c-1].getWestLine().isBanned() && TileMap[r-1][c-1].getNorthLine().isBanned())
                        if(!TileMap[r-2][c-1].getWestLine().getStatus())
                        {
                           TileMap[r-2][c-1].getWestLine().turnOn();
                           this.addToMoveList(r-1,c,"Left",true);
                        }
                  }
               }
                  
            if(r == row)
               if(TileMap[r-1][c-1].getSouthLine().getStatus())
               {
                  if(c > 1 && c < col)
                  {
                     if(TileMap[r-1][c-1].getWestLine().isBanned() && !TileMap[r-1][c-2].getSouthLine().isBanned())
                        if(!TileMap[r-1][c-2].getSouthLine().getStatus())
                        {
                           TileMap[r-1][c-2].getSouthLine().turnOn();
                           this.addToMoveList(r,c-1,"Bottom",true);   
                        }
                     if(!TileMap[r-1][c-1].getWestLine().isBanned() && TileMap[r-1][c-2].getSouthLine().isBanned())
                        if(!TileMap[r-1][c-1].getWestLine().getStatus())
                        {
                           TileMap[r-1][c-1].getWestLine().turnOn();
                           this.addToMoveList(r,c,"Left",true);
                        }
                     
                     if(TileMap[r-1][c-1].getEastLine().isBanned() && !TileMap[r-1][c].getSouthLine().isBanned())
                        if(!TileMap[r-1][c].getSouthLine().getStatus())
                        {
                           TileMap[r-1][c].getSouthLine().turnOn();
                           this.addToMoveList(r,c+1,"Bottom",true);
                        }
                        
                     if(!TileMap[r-1][c-1].getEastLine().isBanned() && TileMap[r-1][c].getSouthLine().isBanned())
                        if(!TileMap[r-1][c-1].getEastLine().getStatus())
                        {
                           TileMap[r-1][c-1].getEastLine().turnOn();
                           this.addToMoveList(r,c,"Right",true);
                        }
                  }
                    
                  if(c == 1)
                  {
                     if(!TileMap[r-1][c-1].getWestLine().getStatus())
                     {
                        TileMap[r-1][c-1].getWestLine().turnOn();
                        this.addToMoveList(r,c,"Left",true);
                     }
                   
                     if(TileMap[r-1][c-1].getEastLine().isBanned() && !TileMap[r-1][c].getSouthLine().isBanned())
                        if(!TileMap[r-1][c].getSouthLine().getStatus())  
                        {
                           TileMap[r-1][c].getSouthLine().turnOn();
                           this.addToMoveList(r,c+1,"Bottom",true);
                        }
                     
                     if(!TileMap[r-1][c-1].getEastLine().isBanned() && TileMap[r-1][c].getSouthLine().isBanned())
                        if(!TileMap[r-1][c-1].getEastLine().getStatus())
                        {
                           TileMap[r-1][c-1].getEastLine().turnOn();
                           this.addToMoveList(r,c,"Right",true);
                        }
                  }
                     
                  if(c == col)
                  {
                     if(!TileMap[r-1][c-1].getEastLine().getStatus())
                     {
                        TileMap[r-1][c-1].getEastLine().turnOn();
                        this.addToMoveList(r,c,"Right",true);
                     }
                     
                     if(TileMap[r-1][c-1].getWestLine().isBanned() && !TileMap[r-1][c-2].getSouthLine().isBanned())
                        if(!TileMap[r-1][c-2].getSouthLine().getStatus())
                        {
                           TileMap[r-1][c-2].getSouthLine().turnOn();
                           this.addToMoveList(r,c-1,"Bottom",true);
                        }
                     
                     if(!TileMap[r-1][c-1].getWestLine().isBanned() && TileMap[r-1][c-2].getSouthLine().isBanned())
                        if(!TileMap[r-1][c-1].getWestLine().getStatus())
                        {
                           TileMap[r-1][c-1].getWestLine().turnOn();
                           this.addToMoveList(r,c,"Left",true);
                        }
                  }
               }
         }
   }
   private void checkForAnyGuarantees()//Doesn't remove any, but checks if there's only a couple left that all have one matching thing
   {
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
         {
            if(TileMap[r-1][c-1].isLocked())
               continue;
               
            boolean[] flags = new boolean[4];
            Arrays.fill(flags, true);//Fill array with all true
            char[] notherarray = new char[4];
            Arrays.fill(notherarray, 't');//Fill array with trash character
            for(int i = TileMap[r-1][c-1].al.size()-1; i >= 0; i--)
            {
               for(int j = 0; j < 4; j++)
                  if(TileMap[r-1][c-1].al.get(i).charAt(j) != notherarray[j])
                     if(notherarray[j] != 't')//Don't match, flag as such
                        flags[j] = false;
                     else notherarray[j] = TileMap[r-1][c-1].al.get(i).charAt(j);
            }
            for(int k = 0; k < 4; k++)
               if(flags[k])
                  switch(k)
                  {
                     case 0:
                        if(notherarray[k] == 'T')
                        {
                           if(!TileMap[r-1][c-1].getNorthLine().getStatus())
                           {
                              TileMap[r-1][c-1].getNorthLine().turnOn();
                              this.addToMoveList(r, c, "Top", true); 
                           }
                        }
                        else 
                        {
                           TileMap[r-1][c-1].getNorthLine().setBanned();
                        }
                        break;
                        
                     case 1:
                        if(notherarray[k] == 'T')
                        {
                           if(!TileMap[r-1][c-1].getEastLine().getStatus())
                           {
                              TileMap[r-1][c-1].getEastLine().turnOn();
                              this.addToMoveList(r, c, "Right", true); 
                           }
                        }
                        else 
                        {
                           TileMap[r-1][c-1].getEastLine().setBanned();
                        }
                        break;
                        
                     case 2:
                        if(notherarray[k] == 'T')
                        {
                           if(!TileMap[r-1][c-1].getWestLine().getStatus())
                           {
                              TileMap[r-1][c-1].getWestLine().turnOn();
                              this.addToMoveList(r, c, "Left", true); 
                           }
                        }
                        else 
                        {
                           TileMap[r-1][c-1].getWestLine().setBanned();                              
                        }
                        break;
                        
                     case 3:
                        if(notherarray[k] == 'T')
                        {
                           if(!TileMap[r-1][c-1].getSouthLine().getStatus())
                           {
                              TileMap[r-1][c-1].getSouthLine().turnOn();
                              this.addToMoveList(r, c, "Bottom", true); 
                           }
                        }
                        else 
                        {
                           TileMap[r-1][c-1].getSouthLine().setBanned();
                        }
                        break;
                        
                     default:
                        break;
                  }   
            
         }
   }
   
   private void removeBadRepsForContLine(Tile t, char direction)
   {//Remove any that can't continue line
      for(int i = (t.al.size()-1); i >= 0; i--)
      {
         switch(direction)
         {
            case 'N':
               if(t.al.get(i).charAt(0) == 'F')
                  t.al.remove(i);
               break;
            case 'E':
               if(t.al.get(i).charAt(1) == 'F')
                  t.al.remove(i);
               break;
            case 'W':
               if(t.al.get(i).charAt(2) == 'F')
                  t.al.remove(i);
               break;
            case 'S':
               if(t.al.get(i).charAt(3) == 'F')
                  t.al.remove(i);
               break;
            default:
               break;
         }
      }
   }
   
   private void removeOneBadRep(Tile t, String rep)
   {
      for(int i = (t.al.size()-1); i >= 0; i--)
         if(t.al.get(i).equals(rep))
            t.al.remove(i);
   }
   
   private void checkForOnlyOneRep()
   {
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
         {
            if(TileMap[r-1][c-1].isLocked())//if this tile needs no checking
               continue;//Skip it!
            TileMap[r-1][c-1].checkLinesForBannedOrTurnedOn();//Reset all lines for banned
            if(TileMap[r-1][c-1].getAllPossibleRepresentations() == 1)//If only one rep
            {
               TileMap[r-1][c-1].setLinesFromOneRep(this,r,c, TileMap[r-1][c-1].al.get(0));//Set the lines
               TileMap[r-1][c-1].banMoreLinesFromAbove(this,r,c,TileMap[r-1][c-1].al.get(0));
               //The above method bans a bunch of lines depending on if the rep is good
            }
         }
   }
    
   private void updateReps()
   {
      checkForMoreBans();
      checkForMoreLines();
   
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
         {
            if(TileMap[r-1][c-1].isLocked())//if this tile needs no checking
               continue;//Skip it!
            TileMap[r-1][c-1].checkLinesForBannedOrTurnedOn();//Reset all lines for banned
         }
   
   }
    
   private boolean areThereTilesWithZeroReps()//Are any tiles now having zero reps -- True = Yes
   {
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
         {
            if(TileMap[r-1][c-1].isLocked())
               continue;
           
            //TileMap[r-1][c-1].checkLinesForBannedOrTurnedOn();
            if(TileMap[r-1][c-1].getAllPossibleRepresentations() == 0)
               return true;
            else 
               continue;
         }
      return false;
      
   }
     
   public boolean isWon()//Win condition for my game
   {
   
      Map.Tile.Line prev = null;//Set the previous line to null
      Map.Tile.Line first = null;//Set the first line to null
      Map.Tile.Line next = null;//Set the next line to null
      boolean flag = true, terminate = false;//Flag is to signal the FIRST check for lines (because there'll be two paths.) Terminate is to get out of first instance of lines
      int newrow = 0, newcol = 0, totallines = 0;//Newrow and Newcol are the row and col; totallines counts the path--how many lines it takes.
      int tempnewrow = 0, tempnewcol = 0;//temporary row and col placeholders
      char whichline = 't';//unused initialized var
      
   
    //Find first instance of "lines"             
      for(int i = 1; i <= row; i++)
      {
         for(int j = 1; j <= col; j++)
         {
            if((TileMap[i-1][j-1].getTileValueLines() == 0)) 
               continue;//if there're no lines on that tile, go to next tile (or new row)
            
            if(flag)//If we found a tile w/ lines
            {
               terminate = true;//Terminate this loop
               if(TileMap[i-1][j-1].getNorthLine().getStatus()) 
               {//Go through this if tree to get ONE starting line; if multiple lines in one tile, South Line will overwrite all having priority.
                  whichline = 'N';
                  first = next = TileMap[i-1][j-1].getNorthLine(); 
               }
               if(TileMap[i-1][j-1].getEastLine().getStatus()) 
               {
                  whichline = 'E';
                  first = next = TileMap[i-1][j-1].getEastLine();
               }
               if(TileMap[i-1][j-1].getWestLine().getStatus()) 
               { 
                  whichline = 'W';
                  first = next = TileMap[i-1][j-1].getWestLine();
               }
               if(TileMap[i-1][j-1].getSouthLine().getStatus()) 
               {
                  whichline = 'S';
                  first = next = TileMap[i-1][j-1].getSouthLine(); 
               }
               newrow = i; 
               newcol = j;
               
            }
            if(terminate)
               break;
         }
         if(terminate) 
            break;
      }
      int testlines = 0;
      do
      { 
         testlines = 0; //reset testline
         switch(whichline)
         {
         
            case 'N'://Case if NorthLine's activated, check rest around that line for path(s).
               if(newrow>1)//If not first row, check row above
               {
                  if(TileMap[newrow-2][newcol-1].getEastLine().getStatus() && (TileMap[newrow-2][newcol-1].getEastLine() != prev)) 
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
                  
                  if(TileMap[newrow-2][newcol-1].getWestLine().getStatus() && (TileMap[newrow-2][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
               }
               
               if(TileMap[newrow-1][newcol-1].getEastLine().getStatus() && (TileMap[newrow-1][newcol-1].getEastLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'E';
               }
               
               if(TileMap[newrow-1][newcol-1].getWestLine().getStatus() && (TileMap[newrow-1][newcol-1].getWestLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'W';
               }  
               
               if(newcol > 1)//If not first col, check column to left
               {
                  if(TileMap[newrow-1][newcol-2].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-2].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'N';
                  }
               }
               
               if(newcol < col)//If not last col, check column to right
               {
                  if(TileMap[newrow-1][newcol].getNorthLine().getStatus() && (TileMap[newrow-1][newcol].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'N';
                  }
               }
               
               break;
            
            case 'E':
               if(newcol<col)
               {
                  if(TileMap[newrow-1][newcol].getNorthLine().getStatus() && (TileMap[newrow-1][newcol].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'N';
                  }
                  
                  if(TileMap[newrow-1][newcol].getSouthLine().getStatus() && (TileMap[newrow-1][newcol].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'S';
                  }
               }
               
               if(newrow>1)
               {
                  if(TileMap[newrow-2][newcol-1].getEastLine().getStatus() && (TileMap[newrow-2][newcol-1].getEastLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
               }
               
               if(newrow < row)
               {
                  if(TileMap[newrow][newcol-1].getEastLine().getStatus() && (TileMap[newrow][newcol-1].getEastLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
               }
               
               if(TileMap[newrow-1][newcol-1].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-1].getNorthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'N';
               }
                  
               if(TileMap[newrow-1][newcol-1].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-1].getSouthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'S';
               }  
            
               break;
               
            case 'W':
            
               if(newcol>1)
               {
                  if(TileMap[newrow-1][newcol-2].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-2].getNorthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'N';
                  }
                  
                  if(TileMap[newrow-1][newcol-2].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-2].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'S';
                  }
               }
               
               if(newrow>1)
               {
                  if(TileMap[newrow-2][newcol-1].getWestLine().getStatus() && (TileMap[newrow-2][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow-1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
               }
               
               if(newrow < row)
               {
                  if(TileMap[newrow][newcol-1].getWestLine().getStatus() && (TileMap[newrow][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
               }
               
               if(TileMap[newrow-1][newcol-1].getNorthLine().getStatus() && (TileMap[newrow-1][newcol-1].getNorthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'N';
               }
                  
               if(TileMap[newrow-1][newcol-1].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-1].getSouthLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'S';
               }  
               break;
               
            case 'S':
            
               if(newrow<row)//If not first row, check row above
               {
                  if(TileMap[newrow][newcol-1].getEastLine().getStatus() && (TileMap[newrow][newcol-1].getEastLine() != prev)) 
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'E';
                  }
                  
                  if(TileMap[newrow][newcol-1].getWestLine().getStatus() && (TileMap[newrow][newcol-1].getWestLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow+1;
                     tempnewcol = newcol;
                     whichline = 'W';
                  }
               }
               
               if(TileMap[newrow-1][newcol-1].getEastLine().getStatus() && (TileMap[newrow-1][newcol-1].getEastLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'E';
               }
               
               if(TileMap[newrow-1][newcol-1].getWestLine().getStatus() && (TileMap[newrow-1][newcol-1].getWestLine() != prev))
               {
                  testlines++;
                  tempnewrow = newrow;
                  tempnewcol = newcol;
                  whichline = 'W';
               }  
               
               if(newcol > 1)//If not first col, check column to left
               {
                  if(TileMap[newrow-1][newcol-2].getSouthLine().getStatus() && (TileMap[newrow-1][newcol-2].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol-1;
                     whichline = 'S';
                  }
               }
               
               if(newcol < col)//If not last col, check column to right
               {
                  if(TileMap[newrow-1][newcol].getSouthLine().getStatus() && (TileMap[newrow-1][newcol].getSouthLine() != prev))
                  {
                     testlines++;
                     tempnewrow = newrow;
                     tempnewcol = newcol+1;
                     whichline = 'S';
                  }
               }
               break;
               
            default:
               break;
         
         }
         if(testlines == 0) //If no new path discovered
            return false; 
         if(testlines > 1 && flag == false)//If more than one path and NOT first
         {
            //System.out.println("WARNING: This board will not generate a solution in the future.\nYou have a diverging path.\n");  
            return false;
         }
         else
         {
            flag = false;//Turn flag off
            newrow = tempnewrow;//Set the row to the temporary placeholder
            newcol = tempnewcol;//Set the col to the temporary placeholder
            prev = next;//Change the one "next" to "prev."
            switch(whichline)
            {
               case 'N':
                  next = TileMap[newrow-1][newcol-1].getNorthLine();
                  break;
               
               case 'E':
                  next = TileMap[newrow-1][newcol-1].getEastLine();
                  break;
               
               case 'W':
                  next = TileMap[newrow-1][newcol-1].getWestLine();
                  break;
               
               case 'S':
                  next = TileMap[newrow-1][newcol-1].getSouthLine();
                  break;
                  
               default:
                  break;
            }
         }
         totallines++;//Increase the total number of lines (in this path)
         
      }while(!(first == next));//Keep going until there's no more paths and got to first line again
      
      if(totallines != countLines())//If the loop encountered does NOT match total # of lines
      {
         //System.out.println(("You've completed a continuous loop, but still have "+(lineNumber-totallines)+" extra lines on the board!\n"));
         return false;
      }
      
      boolean isitok = true; //flag if one tile doesn't have correct amount of lines
      
      for(int i = 1; i <= row; i++)
      {
         for(int j = 1; j <= col; j++)
         {
            if((TileMap[i-1][j-1].getTileValueLines() == 4) && (TileMap[i-1][j-1].getTileVal() != 4)) 
            {
               System.out.println("That little square you did doesn't net you the game, son!\nGet rid of it or make that larger");
               return false;
            }
            if((TileMap[i-1][j-1].getTileVal() != 5))//If has value
            {
               if(((TileMap[i-1][j-1].getTileValueLines()) != TileMap[i-1][j-1].getTileVal())) //If it doesn't equal the amt of lines in, false
               {
                  System.out.println(("Tile ("+i+", "+j+") needs "+TileMap[i-1][j-1].getTileVal()+" line(s) instead of the "+TileMap[i-1][j-1].getTileValueLines()+" line(s) it has now."));
                  isitok=false;//make it false
               }
            }   
         }
      }
      System.out.println();
      if(!isitok)//Are there an equal number of lines total and lines in the path?
         return false;
      return true;//Every constraint satisfied; return correct answer
   }
      
   public void setTileNum(int row, int col, int newnum)
   {
      TileMap[row-1][col-1].setNumSides(newnum);//Set the tile number (Map Method)
   }
   
   public boolean isReset()
   {
      return reset;//Return reset val
   }
   
   public void gameset()//Read the file for the REST of the data; i.e., all of the tile numbers.
   {
      try
      {
         BufferedReader bf = new BufferedReader(new FileReader("TableRead.txt"));   
         StringBuilder sb = new StringBuilder();
         String read = null;
         try
         {
            read = bf.readLine();   //skip row           
            read = bf.readLine();   //skip col            
            read = bf.readLine();   //read the third line first
            if(read != null)   
               do
               {
                  Scanner sc = new Scanner(read).useDelimiter(",");
                  this.setTileNum(sc.nextInt(), sc.nextInt(), sc.nextInt());
                  read = bf.readLine();
               }while(read != null);
         }
         catch(IOException e){System.out.println(e.getMessage());}
            
      }
      catch(FileNotFoundException e){System.out.println(e.getMessage());}
   
   }
   
   public void gameset(String s)//Overload for above to load specific tourney map.
   {
      try
      {
         BufferedReader bf = new BufferedReader(new FileReader(s));   
         StringBuilder sb = new StringBuilder();
         String read = null;
         try
         {
            read = bf.readLine();   //skip row           
            read = bf.readLine();   //skip col            
            read = bf.readLine();   //read the third line first
            if(read != null)   
               do
               {
                  Scanner sc = new Scanner(read).useDelimiter(",");
                  this.setTileNum(sc.nextInt(), sc.nextInt(), sc.nextInt());
                  read = bf.readLine();
               }while(read != null);
         }
         catch(IOException e){System.out.println(e.getMessage());}
            
      }
      catch(FileNotFoundException e){System.out.println(e.getMessage());}
   
   }

   
   public Map copy()//Make a copy of the Map (used for autoAutoMove() to save state!)
   {
      Map m = new Map(this.row, this.col);
      m.setMoveList(this.moveList);//set the move list
      m.setPVal(this.getPVal());
      m.setSVal(this.getSVal());
      m.moveListCount = this.moveListCount;
      if(getPVal() == 4) //set all nums if tourney
         m.gameset(this.getSVal());
      else
      {
      //System.out.println(this.getPVal());
         m.gameset();//set all nums
      }
      for(int r = 1; r <= row; r++)
         for(int c = 1; c <= col; c++)
         {
            if(TileMap[r-1][c-1].getNorthLine().getStatus())//is on?
               m.TileMap[r-1][c-1].getNorthLine().turnOn();
            else if(TileMap[r-1][c-1].getNorthLine().isBanned())//is banned if not on?
               m.TileMap[r-1][c-1].getNorthLine().setBanned();
           
            if(TileMap[r-1][c-1].getEastLine().getStatus())//is on?
               m.TileMap[r-1][c-1].getEastLine().turnOn();
            else if(TileMap[r-1][c-1].getEastLine().isBanned())//is banned if not on?
               m.TileMap[r-1][c-1].getEastLine().setBanned();
           
            if(c == 1)    
               if(TileMap[r-1][c-1].getWestLine().getStatus())//is on?
                  m.TileMap[r-1][c-1].getWestLine().turnOn();
               else if(TileMap[r-1][c-1].getWestLine().isBanned())//is banned if not on?
                  m.TileMap[r-1][c-1].getWestLine().setBanned();
               
            if(r == row)   
               if(TileMap[r-1][c-1].getSouthLine().getStatus())//is on?
                  m.TileMap[r-1][c-1].getSouthLine().turnOn();
               else if(TileMap[r-1][c-1].getSouthLine().isBanned())//is banned if not on?
                  m.TileMap[r-1][c-1].getSouthLine().setBanned();
         
            if(TileMap[r-1][c-1].isLocked())
               m.TileMap[r-1][c-1].setLocked();
               
            m.TileMap[r-1][c-1].al = new ArrayList<String>(TileMap[r-1][c-1].al);
            m.setLineNumber(this.getLineNumber());
         }//Movelist and TileMap line objs copied... 
      return m;
   }
   
   public String toString()
   {//toString() representation of the Map.
      
      String ts = "Col     ";
      for(int j = 0; j < col; j++)
         if((j+1)>9)//If column is greater than 9... make whitespace line up
            ts += ((j+1)+"  ");
         else ts += ((j+1)+"   ");
      ts += '\n';
      for(int i = 0; i < row; i++)
      {
         if(i == 0)
         {//Get first line only for top row, so no repitition
            ts += "      ";
            for(int j = 0; j < col; j++)
            { 
               ts += TileMap[i][j].getFirstLine();
            }
            ts += "+\n";
         }
         if((i+1)>9)//If you go to more than row 9... make it so that it's lined up
            ts += ("Row"+(i+1)+" ");
         else ts += ("Row "+(i+1)+" ");
         for(int j = 0; j < col; j++)
            ts += TileMap[i][j].getSecondLine();
         ts += "\n";
         ts += "      ";
         for(int j = 0; j < col; j++)
            ts += TileMap[i][j].getThirdLine();
         ts += "+\n";
      }
      return ts;
   }
}

