package instructors;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class Driver {
    public static void main(String[] args) {
        //n = 5
        int numb = 5;
        Submission a = new Submission("s0", 0, 10);
        Submission b = new Submission("s1", 3, 8);
        Submission c = new Submission("s0", 1, 9);
        Submission d = new Submission("s1", 1, 9);
        Submission e = new Submission("s0",3, 9);
        Submission f = new Submission("s0", 2, 9);
        Submission g = new Submission("s1", 1, 9);
        Submission h = new Submission("s2", 4, 9);
        Submission i = new Submission("s1", 4, 9);
        Submission j = new Submission("s0", 4, 9);
        Submission k = new Submission("s2", 2, 9);
        Submission l = new Submission("s2", 2, 9);
        Submission m = new Submission("s1", 0, 9);
        Submission n = new Submission("s0", 0, 9);

        ArrayList<Submission> submissionList = new ArrayList<Submission>();
        submissionList.add(a);
        submissionList.add(b);
        submissionList.add(c);
        submissionList.add(d);
        submissionList.add(e);
        submissionList.add(f);
        submissionList.add(g);
        submissionList.add(h);
        submissionList.add(i);
        submissionList.add(j);
        submissionList.add(k);
        submissionList.add(l);
        submissionList.add(m);
        submissionList.add(n);


        Map<String, Integer> answer = Teacher.countMissing(numb, submissionList);
        System.out.println(answer);
    }
}
