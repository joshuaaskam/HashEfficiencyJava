public class HashEfficiency
{
   private static final int DEFAULT_INITIAL_CAPACITY = 20;
   private int[] data;
   
   public HashEfficiency()
   {
      data = new int[DEFAULT_INITIAL_CAPACITY];
   }
   public int hash(int hashCode)
   {
      return hashCode % DEFAULT_INITIAL_CAPACITY;
   }
   
   //using linear probing. 
   public void insert(int value)
   {
      int index = hash(value);
      int i = 1;
      while(data[index] != 0)
      {
         System.out.println("Attempted to insert " + value + " at index " + index + " but value " + data[index] + " was already there.");
         index = hash(value + i);
         i++;
      }
      data[index] = value;
      System.out.println("Value " + value + " was inserted at " + index);
      for(int num: data)
            System.out.print(num + " ");
      System.out.println();
   }
   //started with 10 integers being inserted: Some collisions with small clusters, typically taking up 3 indices and less. 
   //15 integers being inserted: More collisions and the clustering is getting much bigger.
   //20 integers being inserted: A lot more collisions, which leads to even bigger clusters which then leads to more collisions. 
   //Overall for all of the data the collisions tend to increase as there is more data being inserted. 
   public static void main(String[] args)
   {
         HashEfficiency test = new HashEfficiency();
         for(int i = 0; i < 20; i++)
            test.insert((int)(Math.random() * 100 + 1));
   }
}