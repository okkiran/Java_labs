
public class GiftCard {
	
	// data members
	private int cardId;
    private int remainingDay;
    private String[] validStores;
    private int numOfStores = 0;
    private int size;
    private double amount;

    private static int countOfGC = 0;
    
    // constructors
    public GiftCard(int cardId, int remainingDay, int size, double amount) {
        this.cardId = cardId;
        this.remainingDay = remainingDay;
        this.size = size;
        this.amount = amount;
        validStores = new String[this.size];
        countOfGC++;
    }

    // getters and setters
    public int getCardId() {
        return cardId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setRemainingDay(int remainingDay) {
        this.remainingDay = remainingDay;
    }

    public static int getCountOfGC() {
        return countOfGC;
    }
    
    // member methods
    public boolean addStore(String name) {

    	// Way 1:
    	/*
        if (numOfStores < size) {
            validStores[numOfStores++] = name;
            return true;
        } else {
            return false;
        }
        */
        
        // Way 2:
        if (numOfStores < size) {
        	validStores[numOfStores++] = name;
        	return true;
        }
        return false;
    }
    
    // overriding toString method of the Object class to get the modified string
    @Override
    public String toString() {
    	
        String validStoreNames = "";
        for (String validStore : validStores) {
        	validStoreNames += "\n\t" + validStore;
        }
        return "\nGiftCard\n"
	        + "\nCard Id= " + cardId
	        + "\nRemaining Day= " + remainingDay
	        + "\nValid Stores= " + validStoreNames
	        + "\nAmount= " + amount;
    }
    
}
