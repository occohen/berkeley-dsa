package instructors;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

public class Teacher {
    /**
     * For every student who submits at least one assignment, count
     * the number of assignments they missed.  The assignments are
     * numbered from 0 to the numAssignments-1.
     *
     * Inputs:
     *   numAssignmentsGiven: the number of assignments given in the
     *     class
     *   submissions: a list of Submissions, one per student
     *     submission.  Students may submit the same assignment
     *     multiple times.
     *
     * Returns: a map that maps student IDS to the number of assignments missed.
     **/
    public static Map<String, Integer> countMissing(int numAssignmentsGiven,
                            List<Submission> submissions) {

        //sid to assignments done
        Map<String, HashSet<Integer>> assignmentsDone = new HashMap<String, HashSet<Integer>>(); 
        //sid to assignments missed
        Map<String, Integer> answer = new HashMap<String, Integer>();                                
        for(int i = 0; i < submissions.size(); i++){

            //if student doesnt exist, add them and give them an inital value of 0 missed
            if(!answer.containsKey(submissions.get(i).studentID)){
                answer.put(submissions.get(i).studentID, 0);
            }

            if(!assignmentsDone.containsKey(submissions.get(i).studentID)){
                assignmentsDone.put(submissions.get(i).studentID, new HashSet<Integer>());
            }

            if(assignmentsDone.containsKey(submissions.get(i).studentID)){
                if(!assignmentsDone.get(submissions.get(i).studentID).contains(submissions.get(i).assignmentNum)){
                    assignmentsDone.get(submissions.get(i).studentID).add(submissions.get(i).assignmentNum);
                }
            }



        }
        
        for(Map.Entry<String, Integer> entry : answer.entrySet()){
            String sid = entry.getKey();
            answer.put(sid, numAssignmentsGiven - assignmentsDone.get(sid).size());
        }

        System.out.println("assignments done: " + assignmentsDone);
        System.out.println("answer: " + answer);
        // TODO: complete this function
        // Return included to allow the skeleton code to finish.
        return answer;
    }
}