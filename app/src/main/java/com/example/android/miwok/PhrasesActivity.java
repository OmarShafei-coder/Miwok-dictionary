package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //creating an ArrayList of type Word class
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Where are you going?\n" +
                "\n", "minto wuksus\n" + "\n"));
        words.add(new Word("What is your name?\n" +
                "\n", "tinnә oyaase'nә\n" + "\n"));
        words.add(new Word("My name is...\n" +
                "\n", "oyaaset"));
        words.add(new Word("How are you feeling?\n" +
                "\n", "michәksәs?\n" + "\n"));
        words.add(new Word("I’m feeling good.\n" +
                "\n", "kuchi achit\n" + "\n"));
        words.add(new Word("Are you coming?\n" +
                "\n", "әәnәs'aa?\n" + "\n"));
        words.add(new Word("Yes, I’m coming.\n" +
                "\n", "hәә’ әәnәm\n" + "\n"));
        words.add(new Word("I’m coming.\n" +
                "\n", "әәnәm"));
        words.add(new Word("Let’s go.\n" +
                "\n", "yoowutis"));
        words.add(new Word("Come here.\n" +
                "\n", "әnni'nem"));

        WordAdapter adapter = new WordAdapter(this, words);

        //list is the id name of the ListView in the XML file
        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
