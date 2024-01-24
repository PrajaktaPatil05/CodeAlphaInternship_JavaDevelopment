package com.prajakta.quizapp;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Quiz q = new Quiz();
        q.logic();
    }

}

class Quiz{
    Scanner sc = new Scanner(System.in);
    int correctAnsCount = 0;

    int wrongAnsCount = 0;
    public void logic() {
        System.out.println("------------------------------");
        System.out.println("\tWelcome to QuizApp ");
        System.out.println("------------------------------");
        Questions q1 = new Questions("Who invented Java Programming?","a) Guido van Rossum","b) James Gosling", "c) Dennis Ritchie","d) Bjarne Stroustrup");
        Questions q2 = new Questions("Which statement is true about Java?","a) Java is a sequence-dependent programming language","b) Java is a code dependent programming language", "c) Java is a platform-dependent programming language", "d) Java is a platform-independent programming language");
        Questions q3 = new Questions("Which component is used to compile, debug and execute the java programs?","a) JRE", "b) JIT", "c) JDK" , "d) JVM");
        Questions q4 = new Questions("Which one of the following is not a Java feature?","a) Object-oriented", "b) Use of pointers", "c) Portable", "d) Dynamic and Extensible");
        Questions q5 = new Questions("Which of these cannot be used for a variable name in Java?","a) identifier & keyword" , "b) identifier" , "c) keyword" , "d) none of the mentioned");
        Questions q6 = new Questions("What is the extension of java code files?","a) .js" , "b) .txt", "c) .class", "d) .java");
        Questions q7 = new Questions("Which environment variable is used to set the java path?","a) MAVEN_Path" ,"b) JavaPATH", "c) JAVA", "d) JAVA_HOME");
        Questions q8 = new Questions("Which of the following is not an OOPS concept in Java?","a) Polymorphism" ,"b) Inheritance", "c) Compilation" , "d) Encapsulation");
        Questions q9 = new Questions("What is not the use of “this” keyword in Java?","a) Referring to the instance variable when a local variable has the same name", "b) Passing itself to the method of the same class", "c) Passing itself to another method", "d) Calling another constructor in constructor chaining");
        Questions q10 = new Questions("Which of the following is a type of polymorphism in Java Programming?","a) Multiple polymorphism","b) Compile time polymorphism", "c) Multilevel polymorphism", "d) Execution time polymorphism");


        Map<Questions,Character> hmap = new HashMap<>();
        hmap.put(q1,'b');
        hmap.put(q2,'d');
        hmap.put(q3,'c');
        hmap.put(q4,'b');
        hmap.put(q5,'c');
        hmap.put(q6,'d');
        hmap.put(q7,'d');
        hmap.put(q8,'c');
        hmap.put(q9,'b');
        hmap.put(q10,'b');

        for(Map.Entry<Questions,Character> map:hmap.entrySet()){
            System.out.println(map.getKey().getQuestion());
            System.out.println(map.getKey().getOption1());
            System.out.println(map.getKey().getOption2());
            System.out.println(map.getKey().getOption3());
            System.out.println(map.getKey().getOption4());

            System.out.println("Enter your answer: ");
            Character ans = sc.next().charAt(0);

            int cans = Character.compare(ans,map.getValue());
            if(cans == 0){
                System.out.println("Correct Answer!!");
                correctAnsCount++;
            }else{
                System.out.println("Wrong Answer");
                wrongAnsCount++;
            }
            System.out.println("________________________________________________________________");
        }
        System.out.println();
        System.out.println();
        System.out.println("-----------Result---------");
        System.out.println("Total Questions: "+hmap.size());
        System.out.println("Correct answered: "+correctAnsCount);
        System.out.println("Wrong answered questions: "+wrongAnsCount);
        int percentage = (100*correctAnsCount)/hmap.size();
        System.out.println("Percentage : "+percentage);

        if(percentage > 95){
            System.out.println("Performance is very GOOD!!!");
        }else if(percentage < 35){
            System.out.println("Performance is very LOW ..");
        }else{
            System.out.println("Performance is MEDIUM");
        }
        System.out.println("-------------------------");
    }
}
