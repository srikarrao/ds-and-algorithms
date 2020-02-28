package com.srikar.ds;

public class SparseSearch {

    public static void main(String[] args) {
        System.out.println(sparseSearch(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball"));
        System.out.println(sparseSearch(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "zebra"));
        System.out.println(sparseSearch(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "zebra"}, "zebra"));
        System.out.println(sparseSearch(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "zebra"}, "at"));
        System.out.println(sparseSearch(new String[]{"at", "", "", "", "", "", ""}, "at"));
        System.out.println(sparseSearch(new String[]{"", "", "", "", "", "", "zebra"}, "zebra"));
        System.out.println(sparseSearch(new String[]{"", "", "hello", "", ""}, "hello"));
        System.out.println(sparseSearch(new String[]{"", "", "", "", ""}, "hello"));
    }

    public static int sparseSearch(String[] strings, String str) {
        return sparseSearch(strings, str, 0, strings.length - 1);
    }

    private static int sparseSearch(String[] strings, String str, int first, int last) {

        if (first > last) {
            return -1;
        }

        int mid = first + (last - first) / 2;

        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;

            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }

                right++;
                left--;
            }
        }

        if (str.equals(strings[mid])) {
            return mid;
        } else if (strings[mid].compareTo(str) < 0) {
            return sparseSearch(strings, str, mid + 1, last);
        } else {
            return sparseSearch(strings, str, first, mid - 1);
        }
    }
}
