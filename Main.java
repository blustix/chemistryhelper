import java.util.*;
import java.io.*;
public class Main {

  public static void main(String[] args) throws IOException{
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String indexValue;
    //Initialise some variables
    String txtContents;
    //this initialises "elements.txt" as a file that can be used in our code
    File elementFile = new File("elements.txt");
    //create a linked list
    LinkedList<String> list = new LinkedList<String>();
    
    //try means it tests the code inside the brackets. if it works, great if not, it gets caught by "catch(exception e) and does nothing so that the code doesnt break if there is an Error"
    try {
    //initialise a scanenr that reads each line of the file
    Scanner sc = new Scanner(new File("elements.txt"));
    //while there is another line left in the text file itkeep running.
    while (sc.hasNextLine()){
    //sets a String variable to whatever was on the line on the txt
    txtContents = sc.nextLine();
    //add it to the linkedList
    list.add(txtContents);
    }
    }catch (Exception e) {
    
    }


    String txt2Contents;

    File elementFile2 = new File("elements2.txt");

    LinkedList<String> list2 = new LinkedList<String>();

    try{
      Scanner fl = new Scanner(new File("elements2.txt"));
      while(fl.hasNextLine()){
        txt2Contents = fl.nextLine();
        list2.add(txt2Contents);
      }
    }catch(Exception e){

    }
    




    //splice(in.readLine());
    System.out.println("Please enter in an element or a skeleton equation to balance!");
    
    //while(true) so that code keeps running itself so that the user can input multiple things in
    while(true){

    //read the users input
    String input = in.readLine();
    //make the string all upercase for formatting reasons
    input = input.toUpperCase();

    
      //check if the input has a length of 3 or less, if the user put in an equation it would be longer than 3, if the user inputs an element symbol it will be 3 or less. so in this case if it is less than 3. run the code to output the data
      if(input.length()<=3){
        
        // StringBuilder sb = new StringBuilder();
        
        // for(int i = 0; i < input.length(); i++){
          
        //   char character = input.charAt(i);
        //   sb.append(Character.toUpperCase(i));
        // }

        // String element = sb.toString();
          //runs throught every number to the size of the linked list
          for(int i= 0; i < list.size(); i++){
          
          //make a string equal to i'th index of the linked list
          indexValue = list.get(i);

          if(input.equals(indexValue)){
            //if the input is equal to the line in the linked list output the next few lines
            System.out.println("");
            System.out.println(list.get(i+1));
            System.out.println(list.get(i+2));
            System.out.println(list.get(i+3));
            System.out.println(list.get(i+4));
            System.out.println(list.get(i+5));
            System.out.println(list.get(i+6));
            System.out.println(list.get(i+7));
            System.out.println(list.get(i+8));
           
            System.out.println("");
            

          }else{//else do nothing so nothing happens when indexValue!= list.get(i) and it just runs the for loop again

          }
        }

      //else run the code that balances the equation
    }else if(!input.contains("=")){

      for(int i = 0; i < list2.size(); i++){

        indexValue = list2.get(i);

        if(input.equals(indexValue)){
           System.out.println("");
            System.out.println(list.get(i+1));
            System.out.println(list.get(i+2));
            System.out.println(list.get(i+3));
            System.out.println(list.get(i+4));
            System.out.println(list.get(i+5));
            System.out.println(list.get(i+6));
            System.out.println(list.get(i+7));
            System.out.println(list.get(i+8));
            System.out.println("");
        }else{

        }

      }
    }else{
      //tries all of the code that balances the equation
      try{
        //remove all the spaces  and split at the equals sign into the 2 parts of the euation
      String[] equation = input.replaceAll(" ", "").split("=");
      //splits the first index which is the reactants by "+" 
      String[] reactants = equation[0].split("\\+");
    
    int RE = 0;
    
    //create an arraylist of pairs
    
    ArrayList<ArrayList<Pair>> Reactants = new ArrayList<ArrayList<Pair>>();
    for (int i=0;i<reactants.length;i++)
    {
      Reactants.add(new ArrayList<Pair>());
    }
    
    for (int i=0;i<reactants.length;i++)
    {
      String[] temp = splice(reactants[i]);
      /*for (int j=0;j<temp.length;j++)
      {
        System.out.println(temp[j]);
      }*/
      String element = "";
      int count = 0;

      for(int j=0;j<temp.length;j++)
      {
        if(j%2 == 0){
        element = temp[j];
        RE++;
        }
        else{
        count = Integer.parseInt(temp[j]);
        }
        if(j%2 == 1){
        Reactants.get(i).add(new Pair(element, count));
        }
      }
      
    }

    /*for (int i=0;i<reactants.length;i++)
    {
      for (int j=0;j<Reactants.get(i).size();j++)
      {
        System.out.println(Reactants.get(i).get(j).getElement() + " " + Reactants.get(i).get(j).getCount());
        
      }
    }*/
    int index = 0;
    String[] RElements = new String[RE];
    
    for (int i=0;i<reactants.length;i++)
    {
      for (int j=0;j<Reactants.get(i).size();j++)
      {
        RElements[index] = Reactants.get(i).get(j).getElement();
        index++;
      }
    }
  
    Set<String> UniqueR = new HashSet<String>();
    for (int i=0;i<RElements.length;i++)
    {
      UniqueR.add(RElements[i]);
    }
    //System.out.println(UniqueR.size());
    //System.out.println(UniqueR);
    
    
    String[] products = equation[1].split("\\+");
    int PE = 0;
    ArrayList<ArrayList<Pair>> Products = new ArrayList<ArrayList<Pair>>();
    for (int i=0;i<products.length;i++)
    {
      Products.add(new ArrayList<Pair>());
    }
    
    for (int i=0;i<products.length;i++)
    {
      String[] temp = splice(products[i]);
      /*for (int j=0;j<temp.length;j++)
      {
        System.out.println(temp[j]);
      }*/
      String element = "";
      int count = 0;

      for(int j=0;j<temp.length;j++)
      {
        if(j%2 == 0){
        element = temp[j];
        PE++;
        }
        else{
        count = Integer.parseInt(temp[j]);
        }
        if(j%2 == 1){
        Products.get(i).add(new Pair(element, count));
        }
      }
      
    }
    String[] PElements = new String[PE];
    index = 0;
    for (int i=0;i<products.length;i++)
    {
      for (int j=0;j<Products.get(i).size();j++)
      {
        PElements[index] = Products.get(i).get(j).getElement();
        index++;
      }
    }
    Set<String> UniqueP = new HashSet<String>();
    for (int i=0;i<PElements.length;i++)
    {
      UniqueP.add(PElements[i]);
    }
    //System.out.println(UniqueP.size());
    
    if(UniqueP.size() != UniqueR.size())
    {
      System.out.println("Invalid");
      System.exit(0);
    }
    Iterator<String> itR = UniqueR.iterator();
    Iterator<String> itP = UniqueP.iterator();
    while(itR.hasNext() && itP.hasNext())
    {
      if (!itR.next().equals(itP.next()))
      {
        System.out.println("Invalid");
        System.exit(0);
      }
    }
    
    balance(Reactants, UniqueR, Products, UniqueP);
   

    
    
    
    /*for (int i=0;i<products.length;i++)
    {
      for (int j=0;j<Products.get(i).size();j++)
      {
        System.out.println(Products.get(i).get(j).getElement() + " " + Products.get(i).get(j).getCount());
        
      }
    }*/
    //if the user had improper format we catch NullPointerException e so the code doesnt break 
      }catch(NullPointerException e){
        System.out.println("Invalid Format!");
      }catch(StackOverflowError e){
        //if the code overflows we output not balanceable, once again so the code doesnt break
        System.out.println("Not Balanceable!");
      }catch(NumberFormatException e){
        //improper format
        System.out.println("Invalid Format!");
      }
      catch(Exception e){
        //if there are any other errors just output error
        System.out.println("Error!");

      }
  }
  }
  }

  public static void balance(ArrayList<ArrayList<Pair>> Reactants, Set<String> UniqueR, ArrayList<ArrayList<Pair>> Products, Set<String> UniqueP)
  {
    if(isEqual(Reactants, UniqueR, Products, UniqueP))
    {
      for(int i=0;i<Reactants.size();i++)
      {
        for(int j=0;j<Reactants.get(i).size();j++)
        {
          System.out.print(" "+Reactants.get(i).get(j).getCoef() + "" + Reactants.get(i).get(j).getElement() + "" + Reactants.get(i).get(j).getCount());
        }
        if(i!=Reactants.size()-1)
        {
          System.out.print(" (+)");
        }
      }
      System.out.print(" =");
      for(int i=0;i<Products.size();i++)
      {
        for(int j=0;j<Products.get(i).size();j++)
        {
          System.out.print(" "+Products.get(i).get(j).getCoef() + "" + Products.get(i).get(j).getElement() + "" + Products.get(i).get(j).getCount());
        }
        if(i!=Products.size()-1)
        {
          System.out.print(" (+)");
        }
      }
      //exit so that it only prints the lowest combination and not every combination.
      System.exit(0);
    }
    else{
      int[] diffs = difference(Reactants, UniqueR, Products, UniqueP);
      //System.out.println(Arrays.toString(diffs));
      Iterator<String> iterate = UniqueR.iterator();
      for (int i=0;i<diffs.length;i++)
      {
        String temp = iterate.next();
        if(diffs[i] == 0)
        {
          continue;
        }
        if(diffs[i] > 0)
        {
          for (int j=0;j<Products.size();j++)
          {
            for (int k=0;k<Products.get(j).size();k++)
            {
              if(Products.get(j).get(k).getElement().equals(temp))
              {
                for(int l=0;l<Products.get(j).size();l++)
                {
                  int yes = Products.get(j).get(l).getCoef() + 1;
                  Products.get(j).get(l).setCoef(yes);
                }
                balance(Reactants, UniqueR, Products, UniqueP);
                for(int l=0;l<Products.get(j).size();l++)
                {
                  int yes = Products.get(j).get(l).getCoef() - 1;
                  Products.get(j).get(l).setCoef(yes);
                }
              }
            }
          }
        }
        if(diffs[i] < 0)
        {
          for (int j=0;j<Reactants.size();j++)
          {
            for (int k=0;k<Reactants.get(j).size();k++)
            {
              if(Reactants.get(j).get(k).getElement().equals(temp))
              {
                for(int l=0;l<Reactants.get(j).size();l++)
                {
                  int yes = Reactants.get(j).get(l).getCoef() + 1;
                  Reactants.get(j).get(l).setCoef(yes);
                }
                balance(Reactants, UniqueR, Products, UniqueP);
                for(int l=0;l<Reactants.get(j).size();l++)
                {
                  int yes = Reactants.get(j).get(l).getCoef() - 1;
                  Reactants.get(j).get(l).setCoef(yes);
                }
              }
            }
        }
      }
    }
  }
  }

  public static int[] difference(ArrayList<ArrayList<Pair>> Reactants, Set<String> UniqueR, ArrayList<ArrayList<Pair>> Products, Set<String> UniqueP)
  {
    Iterator<String> itR = UniqueR.iterator();
    Iterator<String> itP = UniqueP.iterator();
    ArrayList<Pair> TotalR = new ArrayList<Pair>();
    int[] ret = new int [UniqueR.size()];
    for(int i=0;i<UniqueR.size();i++)
    {
      TotalR.add(new Pair());
      String r = itR.next();
      TotalR.get(i).setElement(r);
      TotalR.get(i).setCount(0);
    }
    ArrayList<Pair> TotalP = new ArrayList<Pair>();
    for (int i=0;i<UniqueP.size();i++)
    {
      TotalP.add(new Pair());
      String p = itP.next();
      TotalP.get(i).setElement(p);
      TotalR.get(i).setCount(0);
    }
  
    for(int i=0;i<Reactants.size();i++)
    {
      for (int j=0;j<Reactants.get(i).size();j++)
      {
        for (int k=0;k<TotalR.size();k++)
        {
          if(Reactants.get(i).get(j).getElement().equals(TotalR.get(k).getElement()))
          {
            TotalR.get(k).setCount(TotalR.get(k).getCount() + (Reactants.get(i).get(j).getCount() * Reactants.get(i).get(j).getCoef()));
          }
        }
      }
    }

    for(int i=0;i<Products.size();i++)
    {
      for (int j=0;j<Products.get(i).size();j++)
      {
        for (int k=0;k<TotalP.size();k++)
        {
          if(Products.get(i).get(j).getElement().equals(TotalP.get(k).getElement()))
          {
            TotalP.get(k).setCount(TotalP.get(k).getCount() + (Products.get(i).get(j).getCount() * Products.get(i).get(j).getCoef()));
          }
        }
      }
    }
    for (int i=0;i<TotalR.size();i++)
    {
      int diff = TotalR.get(i).getCount() - TotalP.get(i).getCount();
      ret [i] = diff;
    }
    return ret;
  }
  
  
  public static boolean isEqual(ArrayList<ArrayList<Pair>> Reactants, Set<String> UniqueR, ArrayList<ArrayList<Pair>> Products, Set<String> UniqueP)
  {
    boolean flag = true;
    Iterator<String> itR = UniqueR.iterator();
    Iterator<String> itP = UniqueP.iterator();
    ArrayList<Pair> TotalR = new ArrayList<Pair>();
    for(int i=0;i<UniqueR.size();i++)
    {
      TotalR.add(new Pair());
      String r = itR.next();
      TotalR.get(i).setElement(r);
      TotalR.get(i).setCount(0);
    }
    ArrayList<Pair> TotalP = new ArrayList<Pair>();
    for (int i=0;i<UniqueP.size();i++)
    {
      TotalP.add(new Pair());
      String p = itP.next();
      TotalP.get(i).setElement(p);
      TotalR.get(i).setCount(0);
    }
  
    for(int i=0;i<Reactants.size();i++)
    {
      for (int j=0;j<Reactants.get(i).size();j++)
      {
        for (int k=0;k<TotalR.size();k++)
        {
          if(Reactants.get(i).get(j).getElement().equals(TotalR.get(k).getElement()))
          {
            TotalR.get(k).setCount(TotalR.get(k).getCount() + (Reactants.get(i).get(j).getCount() * Reactants.get(i).get(j).getCoef()));
          }
        }
      }
    }

    for(int i=0;i<Products.size();i++)
    {
      for (int j=0;j<Products.get(i).size();j++)
      {
        for (int k=0;k<TotalP.size();k++)
        {
          if(Products.get(i).get(j).getElement().equals(TotalP.get(k).getElement()))
          {
            TotalP.get(k).setCount(TotalP.get(k).getCount() + (Products.get(i).get(j).getCount() * Products.get(i).get(j).getCoef()));
          }
        }
      }
    }
    /*for (int i=0;i<TotalR.size();i++)
    {
      System.out.println(TotalR.get(i).getElement() + " " + TotalP.get(i).getCount());
    }*/
    for (int i=0;i<TotalR.size();i++)
    {
      for (int j=0;j<TotalP.size();j++)
      {
        if(TotalR.get(i).getElement().equals(TotalP.get(j).getElement()))
        {
          if(TotalR.get(i).getCount() != TotalP.get(j).getCount())
          {
            flag = false;
          }
        }
      }
    }
    return flag;

  }
  public static String[] splice(String s)
  {
    int length = 1;
    for (int i=1;i<s.length();i++)
    {
      if (s.charAt(i) >= 65 && s.charAt(i-1) <= 57)
      {
        length++;
      }
    }
    //System.out.println(s.length());
    //System.out.println(length);
    String[] xd = new String [length];
    int index = 0;
    String temp = s.substring(0,1);
    
    for (int i=1;i<s.length();i++)
    {
      temp = temp + s.substring(i,i+1);
      if (s.charAt(i) >= 65 && s.charAt(i-1) <= 57)
      {
        temp = temp.substring(0,temp.length()-1);
        xd[index] = temp;
        index++;
        temp = s.substring(i,i+1);
      }
      if(i==s.length()-1)
      {
        xd[index] = temp;
        index++;
        temp = "";
      }
    }
    //System.out.println(Arrays.toString(xd));

    length = length*2;
    String[] ret = new String[length];
    index = 0;
    for(int i=0;i<xd.length;i++)
    {
      String one = "";
      String two = "";
      for (int j=0;j<xd[i].length();j++)
      {
        
        if (xd[i].charAt(j) >= 65)
        {
          one = one + xd[i].substring(j,j+1);
        }
        else{
          two = two + xd[i].substring(j,j+1);
        }
        
      }
      ret[index] = one;
      index++;
      ret[index] = two;
      index++;
      one = "";
      two = "";
    }

    //System.out.println(Arrays.toString(ret));
    

    return ret;
  }
}