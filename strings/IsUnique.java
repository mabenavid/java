import java.util.HashMap;

//implement an algorithm to determine if a string has all unique characters, What if you can't use additional data structures?

public class IsUnique{

    /**
     * checks if all chars are unique in a string using a HashMap
     * @param word
     * @return boolean
     */
    static boolean uniqueCharsHashMap(String word){

        int size = word.length();
        if(size == 1){
            return true;
        }
        HashMap <Character, Integer> charsHM = new HashMap <Character, Integer>();
        Integer zero = 0;
        for(int i = 0; i < size; i++){
            Character letter = word.charAt(i);
            
            if(charsHM.containsKey(letter)){
                return false;
            }
            charsHM.put(letter, zero);
        }
        return true;
    }    

    /**
     * checks if all chars are unique using no extra data structure
     * @param word
     * @return boolean
     */
    static boolean uniqueChars(String word){

        int size = word.length();
        if(size == 1){
            return true;
        }
        
        for(int i = 0; i < size; i++){
            char letter = word.charAt(i);
        
            for(int j = i+1; j < size; j++){
                char letter2 = word.charAt(j);
                if(letter == letter2){
                    return false;
                }
            }
        }
        return true;
    }   

    public static void main(String[] args) {
        String word = "abfdertyujb";
        System.out.println(uniqueCharsHashMap(word));
        System.out.println(uniqueChars(word));
    }
}