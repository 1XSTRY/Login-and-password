public class RegistrationValidator {

    public static void validateRegistration(String login, String password, String confirmPassword) {
        // Определение разрешенных символов
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

        try {
            // Проверка login
            if (login.length() > 20 || !isValidString(login, allowedChars)) {
                throw new WrongLoginException("Wrong login format");
            }

            // Проверка password
            if (password.length() > 20 || !isValidString(password, allowedChars)) {
                throw new WrongPasswordException("Wrong password format");
            }

            // Проверка совпадения password и confirmPassword
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Passwords do not match");
            }

        } catch (WrongLoginException | WrongPasswordException e) {
            // Обработка исключений
            System.err.println("Exception: " + e.getMessage());
        }
    }

    // Вспомогательный метод для проверки строки на разрешенные символы
    private static boolean isValidString(String str, String allowedChars) {
        for (char ch : str.toCharArray()) {
            if (allowedChars.indexOf(ch) == -1) {
                return false;
            }
        }
        return true;
    }
}