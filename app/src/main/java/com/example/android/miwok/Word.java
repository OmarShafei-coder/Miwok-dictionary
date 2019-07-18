package com.example.android.miwok;

import android.widget.ImageView;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /**Audio resource id*/
    private int mAudioResourceId;
    private static final int NO_IMAGE = -1;

    /**The image for the word*/
    private int mImageResourceId = NO_IMAGE;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word(String defaultTranslation, String miwokTranslation,
                int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation   = miwokTranslation;
        mImageResourceId    = imageResourceId;
        mAudioResourceId    = audioResourceId;
    }


    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the image id of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Get the image id of the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    /**
     * if there's an image for this word or not
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE;
    }
}
