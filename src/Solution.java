import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine(); // bug sur le C (valeur binaire 01000011 et proposée 1000011)
        StringBuilder binaryString = new StringBuilder();
        Map<String, String> convertor = new HashMap<>();
        convertor.put("1","0 0 ");
        convertor.put("11","0 00 ");
        convertor.put("111","0 000 ");
        convertor.put("1111","0 0000 ");
        convertor.put("11111","0 00000 ");
        convertor.put("111111","0 000000 ");
        convertor.put("1111111","0 0000000 ");
        convertor.put("0","00 0 ");
        convertor.put("00","00 00 ");
        convertor.put("000","00 000 ");
        convertor.put("0000","00 0000 ");
        convertor.put("00000","00 00000 ");
        convertor.put("000000","00 000000 ");
        convertor.put("0000000","00 0000000 ");
        StringBuilder result = new StringBuilder();
        System.err.println("MESSAGE= " + MESSAGE);

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        // 1- convert into binary 
        for (char c : MESSAGE.toCharArray()) {
            String binary = Integer.toBinaryString(c);
            binaryString.append(String.format("%7s", binary).replace(' ', '0'));
        }

        // 2- cut binary String into blocks
        char[] charArray = binaryString.toString().toCharArray();
        StringBuilder bloc = new StringBuilder();
        for(int i = 0; i < charArray.length; i++ ){
            if((i != charArray.length-1) && (charArray[i] != charArray[i+1])){
                bloc.append(String.valueOf(charArray[i]));
                result.append(convertor.get(String.valueOf(bloc)));
                bloc = new StringBuilder();
            } else {
                bloc.append(String.valueOf(charArray[i]));
            }
        }

        // Check if there is a remaining bloc to be processed
        if (bloc.length() > 0) {
            result.append(convertor.get(String.valueOf(bloc)).toString().trim());
            bloc = new StringBuilder();
        }

        System.out.println(result.toString());
    }
}