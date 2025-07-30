School Project: Data Structure Project

This report evaluates and compare the performance of four data structures
- AVL Tree
- Splay Tree
- Hash Table Chaining
- Hash Table Probing
Each being tested on insertion, search, and deletion performance, using randomly generated data of size 1000, 10,000, and 1,000,000.

Performance: (These time will vary for each test run, but the times are close in comparison to each other)

Insertion Performance:
Data structures:	 	1000 Elements		10,000 Elements	100,000 Elements
--------------------------------------------------------------------------------------------------
AVL Tree 			1.5328 ms		3.5303 ms		35.7191 ms
Splay Tree			0.9302 ms		2.8916 ms		49.4632 ms
Hashtable Chaining  		0.1371 ms		0.6731 ms		5.0482 ms
Hashtable Probing		0.0680 ms		0.3895 ms		3.2752 ms

Search Performance:
Data structures:	 	1000 Elements		10,000 Elements		100,000 Elements
-------------------------------------------------------------------------------------------------
AVL Tree 			0.2997 ms		1.4253 ms		16.6134 ms
Splay Tree			0.5183 ms		1.5871 ms		35.5278  ms
Hashtable Chaining  		0.0680 ms		0.4538 ms		2.8108 ms
Hashtable Probing		0.0699 ms		0.3777 ms		2.6698 ms

Delete Performance:
Data structures:	 	1000 Elements		10,000 Elements		100,000 Elements
-------------------------------------------------------------------------------------------------
AVL Tree 			0.9366 ms		3.7472 ms		33.8955 ms
Splay Tree			0.2354 ms		1.6763 ms		36.8739 ms
Hashtable Chaining  		0.1053 ms		0.4965 ms		2.5700 ms
Hashtable Probing		0.0885 ms		0.3438 ms		2.7675 ms

Analysis:
Hash Tables both the chaining and probing consistently outperform the AVL and Splay trees in all three routines at all three input sizes. Probing is slightly better than chaining in both the insertion and search performance. Both the AVL and Splay tree can somewhat compete in performance when the data size is small but struggles when its a much larger data size.

AVl Tree: best for - keeping data sorted and balanced for quick searches, O(Log N)
Splay Tree: best for - speeding up repeated access to the same values, Amortized O(Log N)
Hash Table Chaining: best for - fast insert/search/delete with flexible data sizes, O(1) average and O(n) worst case
Hash Table Probing: bet for - fast access when data doesn't change much, O(1) average and O(n) worst case
