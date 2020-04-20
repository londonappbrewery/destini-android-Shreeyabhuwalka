package com.londonappbrewery.destini;

public class StoryBank {
   private int story_number;
    private int answer_1;
    private int answer_2;


    public StoryBank(int story_no,int ans_1,int ans_2)
    {
        story_number = story_no;
        answer_1= ans_1;
        answer_2= ans_2;

    }

    public int getStory_number() {
        return story_number;
    }

    public void setStory_number(int story_number) {
        this.story_number = story_number;
    }

    public int getAnswer_1() {
        return answer_1;
    }

    public void setAnswer_1(int answer_1) {
        this.answer_1 = answer_1;
    }

    public int getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(int answer_2) {
        this.answer_2 = answer_2;
    }
}
