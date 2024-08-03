package fr.planandchill.utils.user;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Pattern;

public class TestStringMandatory {

    public static void testStringMandatory(List<String> errorsList, String str, String fieldName, int maxLength, int minLength) {
        String startWord = getStartWord(fieldName);
        if (StringUtils.isEmpty(str)) {
            errorsList.add(startWord + fieldName + " est obligatoire");
        } else {
            if (str.length() > maxLength) {
                errorsList.add(startWord + fieldName + " ne doit pas dépasser " + maxLength + " caracteres");
            }
            if (str.length() < minLength) {
                errorsList.add(startWord + fieldName + " doit avoir au minimum " + minLength + " caracteres");
            }
            if (fieldName.equals("mot de passe")) {
                if (!Pattern.matches(".*[A-Z]*.", str)) {
                    errorsList.add("Le " + fieldName + " doit contenir au moins une lettre majuscule");
                }
                if (!Pattern.matches(".*[a-z]*.+", str)) {
                    errorsList.add("Le " + fieldName + " doit contenir au moins une lettre minuscule");
                }
                if (!Pattern.matches(".*[0-9]*.", str)) {
                    errorsList.add("Le " + fieldName + " doit contenir au moins un chiffre");
                }
                if (!Pattern.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\\\"\\|,.<>/?]*.", str)) {
                    errorsList.add("Le " + fieldName + " doit pas contenir au moins un caractère spécial");
                }
            }
        }
    }

    private static String getStartWord(String fieldName) {
        return fieldName.equals("email") ? "L'" : "Le ";
    }
}
