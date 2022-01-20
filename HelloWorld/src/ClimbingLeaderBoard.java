import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
// Import the HashMap class
import java.util.HashMap;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
//        List<Integer> playerRank = new ArrayList<>();
//        List<Integer> rankPositions = new ArrayList<>();
//        
//        int position = 1;
//        rankPositions.add(position);
//        for (int i = 1 ; i < ranked.size(); i++)
//        {
//            if (ranked.get(i) != ranked.get(i-1)) {
//                rankPositions.add(rankPositions.get(i-1)+1);
//                System.out.println("Initial Mappings (different) are: " + rankPositions);
//            } else {
//                rankPositions.add(rankPositions.get(i-1));
//                System.out.println("Initial Mappings (same) are: " + rankPositions);
//            }
//        }
//     // Displaying the HashMap
//        System.out.println("Final Mappings are: " + rankPositions);
//   
//        for (int j = 0; j < player.size(); j ++)
//        {
//            int playerScore = player.get(j);
//            if (playerScore > ranked.get(0)) {
//                playerRank.add(1);
//            } else if (playerScore < ranked.get(ranked.size()-1)) {
//                playerRank.add(rankPositions.get(ranked.size()-1) + 1);
//            } else {
//                int index = binarySearch(ranked, playerScore);
//                playerRank.add(rankPositions.get(index));
//            }
//        }
//        
//        return playerRank;
    	
    	List<Integer> result = new ArrayList<Integer>();
        TreeMap<Integer, Integer> rankMap = new TreeMap<Integer, Integer>();
        
        // Assertion: The Ranked List is already sorted in descending order
        // Derive the Rank for each Score and store it in a Sorted Map i.e., TreeMap
        int count=0;
        for(int value : ranked){
            if(!rankMap.containsKey(value)){
                count++;
                rankMap.put(value, count);
            }
        }
        
        //System.out.println(rankMap);
        
        for(int score : player){
            List<Integer> listToRemove = new ArrayList<Integer>();
            
            // Edge Case: When the score is greater than the Leaderboard
            if(score > rankMap.lastKey()){
                result.add(1);
                continue;
            }
                
            for(int value : rankMap.keySet()){
                if(score > value){
                    // If the score is greater than the current value on Rank Map,
                    // then we don't need to compare it anymore for any of the scores that come in future
                    listToRemove.add(value);
                }
                else if(score < value){
                    // If the score is lesser than the curren value on Rank Map,
                    // then increment the rank and add it to the list
                    result.add(rankMap.get(value) + 1);
                    break;
                }
                else{
                    // If the score is equal to the curren value on Rank Map,
                    // then add the current rank to the list
                    result.add(rankMap.get(value));
                    break;
                }
            }
            
            // Remove all the values which are past the current score
            for(int value : listToRemove)
                rankMap.remove(value);
        }
        
        int number = 20, reverse = 0;  
        while(number != 0)   
        {  
        int remainder = number % 10;  
        reverse = reverse * 10 + remainder;  
        number = number/10;  
        }  
        //System.out.println("The reverse of the given number is: " + reverse);  
        
        float num1 = 18;
        float num2 = 6;
        //System.out.println("The division of the given number is: " + num1/num2);
        int beautifulDaysresult = beautifulDays(13, 45, 3);
        //System.out.println(beautifulDaysresult);
        //System.out.println("haha");
        test();
        int k = 2;
        int[] c = {0, 0, 1, 0, 0, 1, 1, 0};
        int energyLvl = 100;
        int i = 0;
        int n = c.length;
       
        do
        {
          energyLvl -= 1;
          if (c[i] == 1)
            energyLvl -= 2;
          i = (i+k) % n;
          
        } while(i != 0);
         System.out.println(energyLvl);
        
        System.out.println("It ends here");
        return result;
    }
    public static void test() {
    	List<Integer> p = new ArrayList<>();
    	p.add(2);
    	p.add(3);
    	p.add(1);
    	int arrayCount = p.size();
        int sqnNo = 1;
        List<Integer> sequentialArray = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> test = (ArrayList) p;
        while (arrayCount != 0)
        {
        	//System.out.println("ArrayCount: " + arrayCount);
            arrayCount--;
            //System.out.println("Test size: " + test.size());
            for (int i = 0; i < test.size(); i++)
            {
            	//System.out.println("test element: " + test.get(i));
                if(sqnNo == test.get(i))
                {
                    sequentialArray.add(++i);
                    //test.remove(i);
                    break;
                }
            }
            //System.out.println("================================");
            sqnNo++;
        }
        for(int j = 0; j < sequentialArray.size(); j++)
        {
        	//System.out.println("sequentialArray element: " + sequentialArray.get(j));
            for(int k = 0; k < p.size(); k++) {
                if(sequentialArray.get(j) == p.get(k))
                {
                    result.add(++k);
                    break;
                }
            }
        }
        for(int j = 0; j < result.size(); j++) {
        	//System.out.println(result.get(j));
        }
    }
    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
           
            int beautifulDays = 0;
            for(int counter = i; counter <= j; counter++)
            {
                StringBuilder day = new StringBuilder(String.valueOf(counter));
                int xReverse = Integer.parseInt(day.reverse().toString());
                
                if(Math.abs(counter-xReverse) % k == 0)
                {
                    beautifulDays++;
                    //System.out.println(beautifulDays);
                }
            }
            return beautifulDays;
        }
private static int binarySearch(List<Integer> a, int key) {

    int lo = 0;
    int hi = a.size() - 1;

    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (a.get(mid) == key) {
            return mid;
        } else if (a.get(mid) < key && key < a.get(mid - 1)) {
            return mid;
        } else if (a.get(mid) > key && key >= a.get(mid + 1)) {
            return mid + 1;
        } else if (a.get(mid) < key) {
            hi = mid - 1;
        } else if (a.get(mid) > key) {
            lo = mid + 1;
        }
    }
    return -1;
}
}

public class ClimbingLeaderBoard {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String[] rankedTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ranked = new ArrayList<>();

        ranked.add(100);
        ranked.add(100);
        ranked.add(50);
        ranked.add(40);
        ranked.add(40);
        ranked.add(20);
        ranked.add(10);
//        for (int i = 0; i < rankedCount; i++) {
//            int rankedItem = Integer.parseInt(rankedTemp[i]);
//            ranked.add(rankedItem);
//        }

//        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String[] playerTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> player = new ArrayList<>();
        player.add(5);
        player.add(25);
        player.add(50);
        player.add(120);
//        for (int i = 0; i < playerCount; i++) {
//            int playerItem = Integer.parseInt(playerTemp[i]);
//            player.add(playerItem);
//        }

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        for (int i = 0; i < result.size(); i++) {
//            bufferedWriter.write(String.valueOf(result.get(i)));
        	System.out.println(String.valueOf(result.get(i)));
            if (i != result.size() - 1) {
//                bufferedWriter.write("\n");
//            	System.out.println("\n");
            }
        }

//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
