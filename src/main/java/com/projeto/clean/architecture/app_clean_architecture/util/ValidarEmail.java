package com.projeto.clean.architecture.app_clean_architecture.util;

import java.util.regex.Pattern;

public class ValidarEmail {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean emailValido(String email) {
          return pattern.matcher(email).matches();
        }

}
