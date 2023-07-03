package com.example.springboot.configuration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Language {
    public static final Map<String, String> languages = new HashMap<>() {{
        put("en", "English");
        put("vi", "Tiếng Việt");
        put("haw", "ʻŌlelo Hawaiʻi");
    }};

    public static void main(String[] args) {
        String[] languages = Locale.getISOLanguages();
        for (String language : languages) {
            System.out.println(language + " - " + new Locale(language).getDisplayLanguage());
        }
    }

//    public static void main(String[] args) {
//        Locale[] availableLocales = Locale.getAvailableLocales();
//
//        for (Locale locale : availableLocales) {
//
//            String country = locale.getDisplayCountry();
//            String countryCode = locale.getCountry();
//            String language = locale.getDisplayLanguage();
//            String languageCode = locale.getLanguage();
//
//            System.out.println(country + " - " + countryCode + " - " + language + " - " + languageCode);
//        }
//    }
}
