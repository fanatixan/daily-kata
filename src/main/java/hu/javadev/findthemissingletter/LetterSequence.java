package hu.javadev.findthemissingletter;

public class LetterSequence {

    public char findMissingLetter(char[] letters) {
        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i + 1] - letters[i] != 1) {
                return (char) (letters[i] + 1);
            }
        }

        throw new IllegalArgumentException();
    }

}
