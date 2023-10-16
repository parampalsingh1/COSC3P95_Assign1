package COSC3P95_Assign1.Answer5;

/*
 * Name       : Parampal Singh
 * Student no.: 7003114
 */

import java.util.HashSet;
import java.util.Set;

public class DeltaDebugging {

    public DeltaDebugging() {
        Set<String> setStr = new HashSet<>();
        setStr.add("CCDDEExy"); // Adds the input values here

        Set<String> subSetStr = deltaDebugger(setStr);

        if (subSetStr != null) {
            System.out.println("Minimized subset for " + setStr + " is " + subSetStr);
        } else {
            System.out.println("No minimized subset found.");
        }
    }

    // This method uses recursion to find the minimize size of the input that finds the bug.
    public static Set<String> deltaDebugger(Set<String> setStr) {
        if (!ifFails(setStr)) {
            return setStr;
        } else {
            for (String st : new HashSet<>(setStr)) { 
                Set<String> subStr = new HashSet<>(setStr);
                subStr.remove(st);
                if (!ifFails(subStr)) {
                    return deltaDebugger(subStr);
                }
            }
        }
        return null; 
    }

    // This method checks if the bug exists in the input string
    public static boolean ifFails(Set<String> str) {
        boolean fails = false; 
        Set<String> modifiedStr = processString(str);
        
        char char1 = 0;
        char char2 = 0;

        for (int i = 0; i < modifiedStr.size() - 1; i++) { // Iterate over the string
            char1 = ((String) modifiedStr.toArray()[i]).charAt(0); 
            char2 = ((String) modifiedStr.toArray()[i + 1]).charAt(0);
            if (Character.toString(char1).matches("[0-9]")) { // checks if the selected char is numerical or not
                if (char1 == char2) { // If the characters are numerical it verifies if they are same or not
                    fails = true;
                    break;
                }
            }
        }
        return fails;
    }

    // This method processes the input as described in the question
    public static Set<String> processString(Set<String> str) {
        Set<String> outputStr = new HashSet<>();
    
    for (String st : str) {
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (Character.isUpperCase(ch)) {
                outputStr.add(Character.toString(Character.toLowerCase(ch)));
            } else if (Character.isDigit(ch)) {
                outputStr.add(Character.toString(ch) + Character.toString(ch));
            } else {
                outputStr.add(Character.toString(Character.toUpperCase(ch)));
            }
        }
    }
    
    return outputStr;
    }

    public static void main(String[] args) { new DeltaDebugging(); }
}

