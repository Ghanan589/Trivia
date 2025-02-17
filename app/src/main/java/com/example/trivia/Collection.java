package com.example.trivia;

import java.util.ArrayList;

public class Collection {
    private ArrayList<Question>arr;
    private int index;//מספר השאלה הבאה בתור
    public  Collection()
    {
        arr=new ArrayList<>();

        Question q1=new Question("1+10","7","11","3","100",2);
        Question q2=new Question("1+2","8","2","3","100",3);
        Question q3=new Question("50+50","9","11","3","100",4);
        Question q4=new Question("1+4","5","11","23","100",1);
        Question q5=new Question("1+0","1","11","9","100",1);

        arr.add(q1);
        arr.add(q2);
        arr.add(q3);
        arr.add(q4);
        arr.add(q5);
    }
    public void initQuestions()
    {
        index =0;
    }
    public Question getNextQuestion()
    {
        //הפעולה מחזירה הפניה לשאלה הבאה
        Question q = arr.get(index);
        index++;
        return q;
    }
    public boolean isNotLastQuestion()
    {
        //הפעולה מחזירה אמת אם אנו בשאלה האחרונה
        return(index<arr.size());//if not at the end of the ArrayList
    }

    public int getIndex()
    {
        return index;


    }





}
