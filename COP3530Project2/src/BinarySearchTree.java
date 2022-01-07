import java.text.*;

/**
* The Binary Search Tree class creates a binary search tree using the csv file that is imported.
* It then manipulates the csv file using many different methods.
* @author Noah Dancu
* @version 7/19/20
*/

public class BinarySearchTree 
{
	
	private Node root;
    Node botNode;
    Node topNode;
    Node[] bot = new Node[10];
    Node[] top = new Node[10];
    int j = 0;
    
	private class Node 
	{
		 String name;
		 double gdpPerCapita;
		 Node leftChild;
		 Node rightChild;
		 
		 public Node(String name, double gdpPerCapita) 
		 {
			this.name = name;
		 	this.gdpPerCapita = gdpPerCapita;
		 }
		 
		 public void printNode() 
		 {
			 System.out.printf("%-25s%,-20.2f\n", name, gdpPerCapita);
		 }
	}
	/**
	* The purpose of this method is create an empty tree
	*
	* @param none
	* @return none
	*/

	public BinarySearchTree()
	{
		root = null;
	}
	/**
	* The purpose of this method is to insert each of the countries into the binary tree.
	*
	* @param name is the name of the country, and gdpPerCapita is the gdp per capita of the country.
	* @return the return value is just to restart the method.
	*/

	public void insert(String name, double gdpPerCapita) 
	{
		if (root == null) 
        {
            root = new Node(name, gdpPerCapita);
            return;
        }

        root = insert(root, new Node(name, gdpPerCapita));
			 
	}
	
	/**
	* The  purpose of this method is to have a recurring method for inserting the countries
	* 
	*
	* @param Current is the current node being used, and node is the new node being used.
	* @return the node return just returns the country, and current returns the current country.
	*/

	private Node insert(Node current, Node node) 
    {
        if (current == null) 
        {
            return node;
        }

        if (node.name.compareTo(current.name) > 0) 
        {
        	current.rightChild = insert(current.rightChild, node);
        } 
        else if (node.name.compareTo(current.name) < 0) 
        {
        	current.leftChild = insert(current.leftChild, node);
        }

        return current;
    }
	/**
	* The purpose of this method is to find a country using the name provided.
	* 
	*
	* @param The parameter is the name provided.
	* @return the return value is either -1 to show the value is not there or the gdp of the name that is requested.
	*/
	 
	public double find(String name)
	{
		int nonLeaf = 0;
		Node node = root;

        if (root == null) 
            return -1;

        while (node != null) 
        {
            if (node.leftChild != null || node.rightChild != null) 
            {
            	nonLeaf++;
            }

            if (name.compareTo(node.name) < 0) 
            {
                node = node.leftChild;
            } 
            else if (name.compareTo(node.name) > 0) 
            {
                node = node.rightChild;
            } 
            else 
            {
                System.out.println(name + " was found with GDP per Capita of " + node.gdpPerCapita + "\n" 
            + nonLeaf + " nodes visited\n");

                return node.gdpPerCapita;
            }
        }

        System.out.println(name + " was not found" + "\n" + nonLeaf + " nodes visited\n");

        return -1;
			 
	}

		 
	/**
	* The purpose of this method is to delete the country that is provided.
	* 
	*
	* @param The parameter is the name of the country.
	* @return the return value is either returning nothing if the country is not there, or returning that the
	* country has been removed.
	*/

	public void delete(String name)
	{
		Node current = root;
		if (root == null)         
            return;

        Node node = root;
        Node parent = root;
        try 
        {
        while (current.name != name)
        {

            if (name.compareTo(node.name) < 0) 
            {
                parent = node;
                node = node.leftChild;
            } 
            else if (name.compareTo(node.name) > 0) 
            {
                parent = node;
                node = node.rightChild;
            } 
            else 
            {
              if (node.rightChild == null)
                {
                    if (name.compareTo(node.name) < 0) 
                    {
                        parent.leftChild = node.leftChild;
                    } 
                    else 
                    {
                        parent.rightChild = node.leftChild;
                    }
                }
                else if (node.leftChild == null) 
                {
                    if (name.compareTo(node.name) < 0) 
                    {
                        parent.leftChild = node.rightChild;
                    } 
                    else 
                    {
                        parent.rightChild = node.rightChild;
                    }
                } 
                else if (node.leftChild == null && node.rightChild == null) 
                {
                    if (name.compareTo(node.name) < 0) 
                    {
                        parent.leftChild = null;
                    } 
                    else 
                    {
                        parent.rightChild = null;
                    }
                } 

                System.out.println(name + " has been deleted");
                break;
            }
        }
        }
        catch(Exception e)
        {
        	
        }
	}
	/**
	* this method calls the recursive method of inorder to print countries in order.
	*
	* @param none.
	* @return none
	*/
	 
	public void printInorder()
	{
        inorder(root); 
	}
	
	/**
	* This method calls the nodes of the tree in in order traversal.
	*
	* @param the parameter is node, which is the specific country.
	* @return the return is just returning if no node is there. 
	*/
	private void inorder(Node node) 
    {
        if (node == null) 
            return;

        Node left = node.leftChild;
        Node right = node.rightChild;
        
        inorder(left);
        node.printNode();
        inorder(right);
    }
	
	/**
	* This method calls the recursive method of preorder.
	*
	* @param none.
	* @return none.
	*/
	public void printPreorder()
	{
        preorder(root);
	}
	
	/**
	* This method prints the countries in pre order traversal.
	*
	* @param Node again is used to show the specific country.
	* @return The return is used if no nodes are present.
	*/
	private void preorder(Node node) 
    {
        if (node == null) 
            return;

        Node left = node.leftChild;
        Node right = node.rightChild;
        
        node.printNode();
        preorder(left);
        preorder(right);
    }
	
	/**
	* This method calls the recursive post order traversal method.
	*
	* @param none
	* @return none
	*/
	public void printPostorder()
	{
        postorder(root);
	}
	
	/**
	* This method prints the countries in post order traversal.
	*
	* @param Nodee is used as the different countries
	* @return The return is used if no nodes are present.
	*/
	private void postorder(Node node) 
    {
        if (node == null) 
            return;
        
        Node left = node.leftChild;
        Node right = node.rightChild;
        
        postorder(left);
        postorder(right);
        node.printNode();
    }
		 
	/**
	* print bottom ten calls the recursive method of bottom to print the lowest gdp countries.
	*
	* @param None
	* @return none
	*/
	public void printBottomTen()
	{
		Node parent = root;
        if (bot[0] == null) 
        	parent = root;
            bot[0] = root;

        bottom(root);
        //botNode.printNode();
        bot[0].printNode();

	}
	
	/**
	* Bottom goes through the different nodes and checks if it is the smallest.
	*
	* @param Nodes represents each country 
	* @return The retturn is used if there are no nodes left.
	*/
	public void bottom(Node node)
	{
		Node parent = root;
		if (node == null)  
            return;
		
        if (node.gdpPerCapita < bot[0].gdpPerCapita) 	
        	bot[0] = node;        		

        bottom(node.leftChild);
        bottom(node.rightChild);
        
	}
		 
	/**
	* Print top ten calls on the recursive top method.
	*
	* @param none
	* @return none
	*/
	public void printTopTen()
	{
        if (top[0] == null) 
        	top[0] = root;

        top(root);
        top[0].printNode();
	}
	
	/**
	* Top is used recursively to find the highest gdp country.
	*
	* @param Node is used to represent the different countries in the tree.
	* @return Return is used if there are no more nodes.
	*/
	private void top(Node node) 
    {
        if (node == null) 
            return;

        
        if (node.gdpPerCapita > top[0].gdpPerCapita)
        	top[0] = node;


        top(node.leftChild);
        top(node.rightChild);
    }
	
}
