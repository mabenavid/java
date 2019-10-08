import java.util.HashMap;

//Given 2 strings write a method to decide if one is a permutation of the other

public class IsPermutation{

    /**
     * checks if word2 is a permutation of word1
     * @param word1
     * @param word2
     * @return boolean
     */
    static boolean isPermutationWord(String word1, String word2){

        int size1 = word1.length();
        int size2 = word2.length();

        if(size1 != size2 || size1 == 0){
            return false;
        }
        char letter;
        HashMap <Character, Integer> hm1 = new HashMap <Character, Integer>();
        Integer zero = 0;
        for(int i = 0; i < size1; i++){
            letter = word1.charAt(i);
            hm1.put(letter, hm1.getOrDefault(letter, zero)+1);
        }

        for(int j = 0; j < size1; j++){
            letter = word2.charAt(j);
            Integer letterCount = hm1.get(letter);
            if(letterCount == null){
                return false;
            }
            
            if(letterCount == 1){
                hm1.remove(letter);
                continue;
            }
            hm1.put(letter, letterCount-1);
        }
        return true;
    }    

    public static void main(String[] args) {
        String word1 = "fabce";
        String word2 = "beafc";
        System.out.println(isPermutationWord(word1, word2));
    }
}