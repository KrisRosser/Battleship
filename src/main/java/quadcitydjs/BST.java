/*maximum nodes per tree is n = 2^h - 1.
a full tree has used its maximum nodes.
a complete tree is where a branch has reached its maximum height. any full tree is by definition complete.
a balanced tree is subjective and might be something along the lines of no branch being having a height difference of more than one.

every tree has a structure component and an order component
Binart Search Tree (BST)
	binary structure (shape of tree)
	BST order property = Left <= Parent <= Right
	
adding and finding are both O(h) efficiency or O(log n). This is only true if tree is balanced.
	this is why balance is SOOOOO importance in trees.
	
the 3 ways we will "look" through a binary search tree are : preorder, in order, postorder
Pre = PLR
In = LPR
Post = LRP

     p
	/ \
   l   r

*/

