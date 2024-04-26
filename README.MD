In this project, I am using the data from the worldcities.csv file and applying quicksort and merge sort on it


## Quick Sort
Quick sort is a divide and conquer algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively. This can be done in-place, requiring small additional O(log n) stack space.

## Merge Sort
Merge sort is an efficient, stable, comparison-based, divide and conquer sorting algorithm. Most implementations produce a stable sort, which means that the implementation preserves the input order of equal elements in the sorted output. Merge sort is a divide and conquer algorithm that was invented by John von Neumann in 1945.


## More information about the Main:
- The main function reads the data from the worldcities.csv file and stores it in a list of dictionaries.
- The main function then calls the quicksort and merge sort functions and calculates the time taken by each function to sort the data.
- The main function does not call the merge sort function if the length of the data is less than 1000 as merge sort.
- You need to change the main function to run the mergesort algorithm.
- It also gives you the number of merges in merge sort and the number of comparisons in quicksort.



