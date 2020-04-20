package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button ans1;
    private Button ans2;
    private TextView story;
    int index=0;

    private StoryBank[] storyCollection = new StoryBank[]{
            new StoryBank(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new StoryBank(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new StoryBank(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new StoryBank(R.string.T4_End,9,9),
            new StoryBank(R.string.T5_End,9,9),
            new StoryBank(R.string.T6_End,9,9)
    };
    private StoryBank[] mStoryLinks = new StoryBank[]
            {
                    new StoryBank(R.string.T1_Story,2,1),

                    new StoryBank(R.string.T2_Story,2,3),

                    new StoryBank(R.string.T3_Story,5,4)
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        ans1= (Button) findViewById(R.id.buttonTop);
        ans2 = (Button) findViewById(R.id.buttonBottom);
        story = (TextView) findViewById(R.id.storyTextView);
        if(savedInstanceState!=null)
        {
            int i = savedInstanceState.getInt("Index");
            updateQuestion(i);
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                index = mStoryLinks[index].getAnswer_1();

               // Log.i("index:"+index, String.valueOf(storyCollection[index].getStory_number()));
                updateQuestion(index);

            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                index = mStoryLinks[index].getAnswer_2();
                updateQuestion(index);
            }
        });

    }
    public void updateQuestion(int i)
    {
        if(index<=2)
        {
            story.setText(storyCollection[i].getStory_number());
            Log.i("msg", String.valueOf(storyCollection[i].getStory_number()));
            ans1.setText(storyCollection[i].getAnswer_1());
            ans2.setText(storyCollection[i].getAnswer_2());
        }
        else
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Story Over");
            alert.setMessage(storyCollection[i].getStory_number());
            alert.setCancelable(false);
            alert.setPositiveButton("Close Game", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();

        }
    }

    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("Index",index);
    }
}
