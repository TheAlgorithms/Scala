# Algorithms Visualization

### All algorithms implemented in Scala (for education)

These are for demonstration purposes only. There are many implementations of sorts in the Scala standard library that are much better for performance reasons.

## Sort Algorithms


### Bubble
![bubble-image](https://camo.githubusercontent.com/40b8099e638526dce298f8dc91246173d56e389a/68747470733a2f2f75706c6f61642e77696b696d656469612e6f72672f77696b6970656469612f636f6d6d6f6e732f7468756d622f382f38332f427562626c65736f72742d6564697465642d636f6c6f722e7376672f32323070782d427562626c65736f72742d6564697465642d636f6c6f722e7376672e706e67)

From [Wikipedia][bubble-wiki]: Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the list to be sorted, compares each pair of adjacent items and swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted.

__Properties__
* Worst case performance	O(n^2)
* Best case performance	O(n)
* Average case performance	O(n^2)

###### View the algorithm in [action](https://www.toptal.com/developers/sorting-algorithms/bubble-sort)



### Insertion
![insertion-image](https://camo.githubusercontent.com/a7657e625281b63ca552a40c099c9331ce79f6a1/68747470733a2f2f75706c6f61642e77696b696d656469612e6f72672f77696b6970656469612f636f6d6d6f6e732f372f37652f496e73657274696f6e736f72742d6564697465642e706e67)

From [Wikipedia][insertion-wiki]: Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.

__Properties__
* Worst case performance	O(n^2)
* Best case performance	O(n)
* Average case performance	O(n^2)

###### View the algorithm in [action](https://www.toptal.com/developers/sorting-algorithms/insertion-sort)

### Quick
![quick-image](https://camo.githubusercontent.com/2499d89bbb30337a5d2d7770cc034b4b71fbfdc6/68747470733a2f2f75706c6f61642e77696b696d656469612e6f72672f77696b6970656469612f636f6d6d6f6e732f362f36612f536f7274696e675f717569636b736f72745f616e696d2e676966)

From [Wikipedia][quick-wiki]: Quicksort (sometimes called partition-exchange sort) is an efficient sorting algorithm, serving as a systematic method for placing the elements of an array in order.

__Properties__
* Worst case performance	O(n^2)
* Best case performance	O(n log n) or O(n) with three-way partition
* Average case performance	O(n^2)

###### View the algorithm in [action](https://www.toptal.com/developers/sorting-algorithms/quick-sort)

### Selection
![selection-image](https://camo.githubusercontent.com/3174db3ca6ed6da3159b4bbc18f73359f0ab33ae/68747470733a2f2f75706c6f61642e77696b696d656469612e6f72672f77696b6970656469612f636f6d6d6f6e732f7468756d622f622f62302f53656c656374696f6e5f736f72745f616e696d6174696f6e2e6769662f32353070782d53656c656374696f6e5f736f72745f616e696d6174696f6e2e676966)

From [Wikipedia][selection-wiki]: The algorithm divides the input list into two parts: the sublist of items already sorted, which is built up from left to right at the front (left) of the list, and the sublist of items remaining to be sorted that occupy the rest of the list. Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist, exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries one element to the right.

__Properties__
* Worst case performance	O(n^2)
* Best case performance	O(n^2)
* Average case performance	O(n^2)

###### View the algorithm in [action](https://www.toptal.com/developers/sorting-algorithms/selection-sort)

----------------------------------------------------------------------------------

## Search Algorithms

### Linear
![linear-image](https://camo.githubusercontent.com/c05ad3f2178af2f16ebe2c04eb122e1e0c6a055b/687474703a2f2f7777772e7475746f7269616c73706f696e742e636f6d2f646174615f737472756374757265735f616c676f726974686d732f696d616765732f6c696e6561725f7365617263682e676966)

From [Wikipedia][linear-wiki]: linear search or sequential search is a method for finding a target value within a list. It sequentially checks each element of the list for the target value until a match is found or until all the elements have been searched.
  Linear search runs in at worst linear time and makes at most n comparisons, where n is the length of the list.

__Properties__
* Worst case performance	O(n)
* Best case performance	O(1)
* Average case performance	O(n)
* Worst case space complexity	O(1) iterative

----------------------------------------------------------------------------------------------------------------------

