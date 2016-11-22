import java.util.ArrayList;
import java.util.List;

public class Monkey {

    //private static int monkeyNum = 0;

    private int thisMonkeyNum = 0;
    
    private int id = -1;

    private Banana banana = null;

    private List<Integer> allPrimeNums = new ArrayList<Integer>();

    /**
     * Get this monkey's number.
     * @return int monkey number
     */
    
    public int getMonkeyNum() {
	return thisMonkeyNum;
    }
    
    /**
     * Getter for id.
     * @return id of monkey
     */
    
    public int getId() throws NoIdException {
	if (id < 0) {
	    throw new NoIdException();
	} else {
	    return id;
	}
    }

    /**
     * Return which monkey should get banana next.
     * @return int which monkey should get banana.
     */

    public int nextMonkey(int iteration) {
	if (iteration == 1) {
        if (thisMonkeyNum % 2 == 0) {
            return thisMonkeyNum / 2;
        } else {
            return (thisMonkeyNum * 3) + 1;
        }
    } else {
        if (allPrimeNums.contains(thisMonkeyNum)) {
            int tempIndex = allPrimeNums.indexOf(thisMonkeyNum);

            if (tempIndex == 0) {
                return 1;
            } else {
                return allPrimeNums.get(tempIndex - 1);
            }
        } else {
            int monkeynum = thisMonkeyNum - 1;

            while (monkeynum > 1) {
                if (allPrimeNums.contains(monkeynum)) {
                    return monkeynum;
                }
                monkeynum--;
            }
        }
    }

    return 0;

    }

    /**
     * Returns all prime numbers for a given start monkey number.
     */
    public void prelistAllPrimeNumbers(int monkeynum) {
        int counter = 0;
        for (int i = 2; i <= monkeynum; i++) {
            counter = 0;
            for (int n = 2; n < i; n++) {
                if (i % n == 0) {
                    counter++;
                }
            }
            if (counter == 0) {
                allPrimeNums.add(i);
            }
        }
    }

    /**
     * Checks to see if this monkey has a banana.
     * @return true if has banana, false otherwise.
     */
    
    public boolean hasBanana() {
	return banana != null;
    }

    /**
     * Receive a banana from another monkey.
     * @param paramBanana - Banana given to this monkey.
     */
    
    public void throwBananaTo(Banana paramBanana) {
	banana = paramBanana;
    }

    /**
     * 
     * @return Banana - the banana this monkey held.
     */
    
    public Banana throwBananaFrom() {
	Banana toReturn = banana;
	banana = null;
	return toReturn;
    }
    
    /**
     * Generate a unique ID for this monkey.
     * Note that monkey ID generation must 
     * always return the correct value for
     * a given n (i.e., the id for the first
     * monkey should always be the same).
     * @return int - id for this monkey
     */
    
    public int generateId(int num) {
	return 223492 + num;
    }

    /**
     * Monkey constructor.
     */
    
    public Monkey(int monkeyNumber) {
	thisMonkeyNum = monkeyNumber;
	monkeyNumber++;
	id = generateId(thisMonkeyNum);
    }
    
}
