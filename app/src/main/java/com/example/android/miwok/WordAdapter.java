package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {



    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView
        ImageView imageResourceId = listItemView.findViewById(R.id.image_view);

        //check if there's an image
        if (currentWord.hasImage()) {
            imageResourceId.setImageResource(currentWord.getImageResourceId());
            imageResourceId.setVisibility(View.VISIBLE);
        } else {
            imageResourceId.setVisibility(View.GONE);
        }

        // Set the theme color for the textView
        View textContainer1 = listItemView.findViewById(R.id.miwok_text_view);
        // Set the theme color for the textView
        View textContainer2 = listItemView.findViewById(R.id.default_text_view);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer1.setBackgroundColor(color);
        // Set the background color of the text container View
        textContainer2.setBackgroundColor(color);

        /**
         * Playing an audio for the miwok translation
         */


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
