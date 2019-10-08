import java.util.HashMap;
import java.util.Iterator;

//Given a string write a function to check if it is a permutation of a palindrome.

public class IsPalindromePermutation{

    /**
     * checks if a word is a permutation of a palindrome
     * @param word
     * @return boolean
     */
    static boolean isPalindromePermutationWord(String word){

        int size = word.length();
        
        if(size == 0){
            return false;
        }
        word = word.toLowerCase();

        char letter;
        HashMap <Character, Integer> hm1 = new HashMap <Character, Integer>();
        Integer zero = 0;
        
        for(int i = 0; i < size; i++){
            letter = word.charAt(i);
            if(letter != ' '){
                hm1.put(letter, hm1.getOrDefault(letter, zero)+1);
            }
        }

        int odd = 0; //there can only be one odd
        boolean isOdd = false;
        for (HashMap.Entry me : hm1.entrySet()) {
            isOdd = isOdd((int)me.getValue());
            if(!isOdd){
                continue;
            }
            if(odd < 1 && isOdd){
                odd++;
            }else{
                return false;
            }
        }

        /* Iterator it = hm1.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
        } */
        return true; 
    }    

    static boolean isOdd(int num){

        if(num % 2 == 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "sator arepo tenet opera rotas";//"No lemon, no melon"; //"Tact Coa";
        System.out.println(isPalindromePermutationWord(word));
    }
}