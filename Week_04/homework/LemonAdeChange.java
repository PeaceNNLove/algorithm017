package Week_04.homework;

public class LemonAdeChange {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) {
            return false;
        }
        int five = 1, ten = 0;
        for (int i = 1; i < bills.length; i++) {
            if (bills[i] == 5) {
                five ++;
            } else if (bills[i] == 10) {
                ten ++;
                five--;
                if (five < 0) {
                    return false;
                }
            }
            if (bills[i] == 20) {
                if (ten > 0 && five > 1) {
                    ten --;
                    five --;
                } else if (five > 3) {
                    five = five - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
