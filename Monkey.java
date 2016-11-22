import java.util.*;

public class Monkey {

    private int _monkeyNum = 0;

    private int _thisMonkeyNum = 0;
    
    private int _id = -1;

    private Banana _b = null;

    private List<Integer> allPrimeNums = new ArrayList<Integer>();

    /**
     * Get this monkey's number
     * @return int monkey number
     */
    
    public int getMonkeyNum() {
	return _thisMonkeyNum;
    }
    
    /**
     * Getter for id.
     * @return id of monkey
     */
    
    public int getId() throws NoIdException {
	if (_id < 0) {
	    throw new NoIdException();
	} else {
	    return _id;
	}
    }

    /**
     * Return which monkey should get banana next.
     * @return int which monkey should get banana.
     */

    public int nextMonkey(int iteration) {
	if (iteration == 1) {
        if (_thisMonkeyNum % 2 == 0) {
            return _thisMonkeyNum / 2;
        } else {
            return (_thisMonkeyNum * 3) + 1;
        }
    }

    else {
        if(allPrimeNums.contains(_thisMonkeyNum)) {
            int tempIndex = allPrimeNums.indexOf(_thisMonkeyNum);

            if(tempIndex == 0) {
                return 1;
            }
            else {
                return allPrimeNums.get(tempIndex-1);
            }
        }
        else {
            int monkeynum = _thisMonkeyNum-1;

            while(monkeynum > 1) {
                if(allPrimeNums.contains(monkeynum)) {
                    return monkeynum;
                }
                monkeynum--;
            }
        }
    }

    return 0;

    }

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

        //System.out.println(allPrimeNums);
    }

    /**
     * Checks to see if this monkey has a banana
     * @return true if has banana, false otherwise
     */
    
    public boolean hasBanana() {
	return _b != null;
    }

    /**
     * Receive a banana from another monkey
     * @param b - Banana given to this monkey
     */
    
    public void throwBananaTo(Banana b) {
	_b = b;
    }

    /**
     * 
     * @return Banana - the banana this monkey held
     */
    
    public Banana throwBananaFrom() {
	Banana toReturn = _b;
	_b = null;
	return toReturn;
    }
    
    /**
     * Generate a unique ID for this monkey.
     * Note that monkey ID generation must 
     * always return the correct value for
     * a given n (i.e., the id for the first
     * monkey should always be the same).
     * @param int n - monkey number
     * @return int - id for this monkey
     */
    
    public int generateId(int n) {
	return 223492 + n;
    }

    /**
     * Monkey constructor
     */
    
    public Monkey() {
	_thisMonkeyNum = _monkeyNum;
	_monkeyNum++;
	_id = generateId(_thisMonkeyNum);
    }
    
}
