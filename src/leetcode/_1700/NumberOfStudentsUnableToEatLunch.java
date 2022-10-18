package leetcode._1700;

public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length, c = 0;
        boolean[] eaten = new boolean[n];
        int i = 0, j = 0;
        boolean end = true;
        while (c < n && end) {
            int i0 = i;
            while (true) {
                if (!eaten[i] && students[i] == sandwiches[j]) {
                    eaten[i] = true;
                    j++;
                    c++;
                    break;
                }
                i = (i + 1) % n;
                if (i == i0) {
                    end = false;
                    break;
                }
            }
            i = (i + 1) % n;
        }
        return n - c;
    }

    public int countStudents1(int[] students, int[] sandwiches) {
        int s1 = 0, n = students.length;
        for (int stu : students) {
            s1 += stu;
        }
        int s0 = n - s1;
        for (int sw : sandwiches) {
            if (sw == 1 && s1 > 0) {
                s1--;
            } else if (sw == 0 && s0 > 0) {
                s0--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }

    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch ns = new NumberOfStudentsUnableToEatLunch();
//        int[] students = new int[] {1,1,0,0};
//        int[] sandwiches = new int[] {0,1,0,1};
        int[] students = new int[] {1,1,1,0,0,1};
        int[] sandwiches = new int[] {1,0,0,0,1,1};
        System.out.println(ns.countStudents(students, sandwiches));
    }
}
