package Day5;

import java.util.*;

//create node class for int data type
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {

    Node root;
    //init the root node

    //first method -- find the "depth" of the tree
    private int findDepth(Node node) {
        int treeDepth = 0;
        while (node != null) {
            treeDepth++;
            //move all the way to the left bottom

            node = node.left;
        }
        return treeDepth - 1;
    }

    // get the last node (bottom right)
    public Node getLastNode() {
        int treeDepth = findDepth(root);
        if (treeDepth == 0) {
            return root; //edge case, only one node
        }
        int totalNodes = (int) Math.pow(2, treeDepth + 1) - 1;//get total amount of nodes via ^2 operation
        int lastNodeIndex = totalNodes - ((int) Math.pow(2, treeDepth) - 1); //gets index of the last node

        Node current = root;
        //get the path to the last node
        for(int level = 1; level <= treeDepth; level++) { //traverse levels
            int middle = (int) Math.pow(2, treeDepth - level) / 2;
            if (lastNodeIndex > middle) { //check if bigger or smaller, navigate subtree
                current = current.right;
                lastNodeIndex -= middle + 1;
            } else {
                current = current.left;
            }
        }

        return current;
    }

    //problem 2
    public static List<Character> sortCharsByFrequency(String input) {
        //create hashmap, count frequency of chars
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i < input.toCharArray().length; i++) {
            //add the chars to char array
            frequencyMap.put(input.toCharArray()[i], frequencyMap.getOrDefault(input.toCharArray()[i], 0) + 1);
        }

        // create maxheap, java implementation. get frequency in descending order
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                //compare which one is bigger
                return frequencyMap.get(c2) - frequencyMap.get(c1);
            }
        });

        //add chars to heap
        maxHeap.addAll(frequencyMap.keySet());

        //get the chars based on frequency
        List<Character> sortedCharacters = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            sortedCharacters.add(maxHeap.poll());
        }

        return sortedCharacters;
    }

    //problem 3
    public static String findLongestCommonPrefix(String[] words) {
        if (words == null || words.length == 0) {
            return ""; // edge cases
        }

        // start with trying the first word as a prefix
        String prefix = words[0];
        //iterate
        for(int i = 1; i < words.length; i++) {
            // here we do a while check to see if the word we are iterating through does not have the prefix. if it does, it'll be at 0
            while (words[i].indexOf(prefix) != 0) {
                // shrink the prefix we use by 1 until it works
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    System.out.println("no prefix found, returning the word");
                    return ""; // none found
                }
            }
        }
        return prefix;
    }

    //problem 4
    // use a static class so that we can make tries
    public static class ShortestUniquePrefix {

        // create a "trie" node class instead of built-in one, implementation influenced from online documentation
        public static class TrieNode {
            Map<Character, TrieNode> children;
            int frequency;

            public TrieNode() {
                this.children = new HashMap<>();
                this.frequency = 0;
            }
        }

        //trie class itself with the root
        public static class Trie {
            TrieNode root;

            public Trie() {
                this.root = new TrieNode();
            }

            // inserting words into the trie
            public void insert(String word) {
                TrieNode current = root;
                for(int i = 0; i < word.toCharArray().length; i++) {
                    current = current.children.computeIfAbsent(word.toCharArray()[i], k -> new TrieNode());
                    current.frequency++;
                }
            }

            // finding shortest unique prefix
            public String shortestUniquePrefix(String word) {
                TrieNode current = root;

                StringBuilder prefix = new StringBuilder();

                for(int i = 0; i < word.toCharArray().length; i ++) {
                    prefix.append(word.toCharArray()[i]);
                    current = current.children.get(word.toCharArray()[i]);
                    if (current.frequency == 1) { 
                        //if it only appears once, it is unique
                        return prefix.toString();

                    }
                }
                return prefix.toString(); //if it fails, return the word instead
            }
        }
    }

    public static String[] findShortestUniquePrefixes(String[] words) {
        ShortestUniquePrefix.Trie trie = new ShortestUniquePrefix.Trie();
        for(int i = 0; i < words.length; i++) {

            // System.out.println(words[i]);
            trie.insert(words[i]);
            
        }

        String[] uniquePrefixes = new String[words.length];
        for(int i = 0; i < words.length; i++) {
            uniquePrefixes[i] = trie.shortestUniquePrefix(words[i]);

        }


        return uniquePrefixes;
    }

    public static void main(String[] args) {
        // String input = "open sesame";
        // List<Character> result = sortCharsByFrequency(input);
        // System.out.println(result);



        // String[] words = {"apple", "appetite", "apparatus", "appliance"};
        // String result1 = findLongestCommonPrefix(words);
        // System.out.println("Longest common prefix: " + result1);



        String[] words1 = {"apple", "banana", "cherry", "cranberry", "grape", "grapefruit"};
        String[] prefixes = findShortestUniquePrefixes(words1);
        for(int i = 0; i < prefixes.length; i++) {
            System.out.println(prefixes[i]);
        }
    }
}
