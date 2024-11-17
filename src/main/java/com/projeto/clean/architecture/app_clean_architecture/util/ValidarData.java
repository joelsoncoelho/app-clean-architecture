package com.projeto.clean.architecture.app_clean_architecture.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarData {

    private static final String DATA_NASCIMENTO_PATTERN = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
    private static final Pattern pattern = Pattern.compile(DATA_NASCIMENTO_PATTERN);

    public static boolean isValidNascimento(String nascimento) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate d = LocalDate.parse(nascimento, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Returns true if d is in format
    // /dd/mm/yyyy
    public static boolean isValidDate(String d)
    {
        String regex = "^(1[0-2]|0[1-9])/(3[01]" + "|[12][0-9]|0[1-9])/[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }

    // Returns true if d is in format
    // /yyyy-mm-dd.
    public static boolean isValidDataNascimento(String d)
    {
        String regex = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }

}
