package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //creating an ArrayList of type Word class
        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Where are you going?\n" +
                "\n", "minto wuksus\n" + "\n", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?\n" +
                "\n", "tinnә oyaase'nә\n" + "\n", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...\n" +
                "\n", "oyaaset", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?\n" +
                "\n", "michәksәs?\n" + "\n", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.\n" +
                "\n", "kuchi achit\n" + "\n", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?\n" +
                "\n", "әәnәs'aa?\n" + "\n", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.\n" +
                "\n", "hәә’ әәnәm\n" + "\n", R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.\n" +
                "\n", "әәnәm", R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.\n" +
                "\n", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here.\n" +
                "\n", "әnni'nem", R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        //list is the id name of the ListView in the XML file
        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        /**
         * when the user clicks any item
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }
}
