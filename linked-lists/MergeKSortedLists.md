## Merge k Sorted Lists

### Problem

Merge k sorted linked lists and return it as one sorted list.
Analyze and describe its complexity.

### Constraints

1. if the number of lists == 1, add it to the tail and return

### Ideas

1. use two pointers, iterate the lists, if list == null, delete it;
2. iterate t


### Test Cases
1. 1->2->4, 0->1->3->5  ==>  0->1->1->2->3->4->5
2. null  ==>  null




### Code


