package com.example.quranmajeed;

public class LanguageController {

    public static Boolean surahLanguage = false;
    public static Boolean translationLanguage = false;

    LanguageController()
    {

    }

    LanguageController(Boolean surah, Boolean translation)
    {
        this.surahLanguage = surah;
        this.translationLanguage = translation;
    }

    public void setSurahLanguage(Boolean set)
    {
        this.surahLanguage = set;
    }

    public void setTranslationLanguage(Boolean set)
    {
        this.translationLanguage = set;
    }

    public Boolean getSurahLanguage()
    {
        return this.surahLanguage;
    }

    public Boolean getTranslationLanguage()
    {
        return this.translationLanguage;
    }

}
