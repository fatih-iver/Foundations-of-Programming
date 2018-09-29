int[] sort(int[] a) {

  SortedSet<Integer> set = new TreeSet<Integer>();

  for(int val: a)
    set.add(val);

  int size = set.size();

  int[] sorted = new int[size];

  Iterator it = set.iterator();

  int counter = 0;

  while(it.hasNext())
    sorted[counter++] = (int) it.next();

  return sorted;
}
