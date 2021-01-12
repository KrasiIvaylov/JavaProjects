package CustomListSorter;

public class Sorter<T extends Comparable<T>> {
    /*
    BUBBLE SORT METHOD
     */

    public static void sort(CustomList customList){
        for (int i = 0; i < customList.size(); i++) {
            String element = (String) customList.get(i);
            for (int j = i + 1; j < customList.size(); j++) {
                String nextElement = (String) customList.get(j);
                if (element.compareTo(nextElement) > 0){
                    customList.swap(i, j);
                }
            }
        }
    }
}
