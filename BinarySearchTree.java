// BinarySearchTree
// 30 March 2017
// Simphiwe Mchunu


import java.util.*;
import java.io.*;
/**
 * BinarySearchTree class inherits from Comparable, BinaryTree. It basically insert data into
 * BinarySearchTree, traverse in ascending order
 * @author  Simphiwe Mchunu
 */
public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
  /**
    *This method inserts the key and whole data entry into the tree, takes two parameters
    *@param k this parameter of type String takes in the key
    *@param d this parameter of type String takes in the data
  */
   public void insert ( dataType k,dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (k,d, null, null);
      else
         insert (k,d, root);
   }
   /**This method takes in 3 parameters, key, the whole data entry, and the node
    *@param k this parameter of type String takes in the key
    *@param d this parameter of type String takes in the data
    *@param node this parameter of type BinaryTreeNode takes in the data
    */
   public void insert ( dataType k, dataType d, BinaryTreeNode<dataType> node)
   {
      if (k.compareTo (node.key) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (k,d, null, null);
         else
            insert (k,d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (k,d, null, null);
         else
            insert (k,d, node.right);
      }
   }
   /**This method takes in one parameter of type String
    *@param k this parameter of type String takes in the key
    *@return key and root
    */
   public dataType find ( dataType k )
   {
      if (root == null)
         return null;
      else
         return find (k, root);
   }
   /**This method takes in two parameter of types String and traverse through the tree
    * to find a specified entry according to key
    *@param k this parameter of type String takes in the key
    *@param node this parameter of type String takes in the node
    *@return data on the specified node
    *@return specific node, either left or right
    */
   public dataType find ( dataType k, BinaryTreeNode<dataType> node )
   {
      if (k.compareTo (node.key) == 0)
         return node.data;
      else if (k.compareTo (node.key) < 0)
         return (node.left == null) ? null : find (k, node.left);
      else
         return (node.right == null) ? null : find (k, node.right);
   }
   /**
    *
    *
    *This newTree static method allows the insertion of data into the BinarySearchTree from a certain filename
    * it reads each line of the file until there are no items left
    *
    *
    *@return bst, returns BinarySearchTree with data loaded
    * @see IOException
    *
    */
   public static BinarySearchTree<String> newTree(){
 		BinarySearchTree<String> bst = new BinarySearchTree<String>();
 		try{
 		//BufferedReader file = new BufferedReader(new FileReader("testdata")); // no such file or directory ___ NTBLA
 		Scanner file = new Scanner(new FileInputStream("testdata"));
 		String line="";
 		//(line = file.nextLine())!=null
 		while(file.hasNextLine()){
                 line = file.nextLine();
 				String fullname = line.substring((line.lastIndexOf("|"))+1);
                 //System.out.println(strippedname);
 								bst.insert(fullname,line);  //insert method still to be modified~
 		}
 		file.close();
 	}
 	catch(IOException e){
 		System.out.println(e.getLocalizedMessage());
 		}
 	return bst;
 	}
  /**
    *This searchTree static method allows the searching of data from the BinarySearchTree and compare similar entries
    * it reads each line of the queryfile until there are no items left
    * @see IOException
    *
    *
    */
  public static void searchTree(){
      try{Scanner filename = new Scanner(new FileInputStream("queryfile"));
      String line="";
        newTree();

        while(filename.hasNextLine()){
          line = filename.nextLine();
          if(newTree().find(line)!=null){
              //System.out.println("Not found");
              System.out.println(newTree().find(line));
          }
          else{
              System.out.println("Not found");
              //System.out.println(newTree().find(line));
          }
        }
  }
  catch(IOException e){
    System.out.println(e.getLocalizedMessage());
  }
}
}
