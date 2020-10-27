package Week_04.homework;

/**
 * 1. 目标基因必须是合法的，目标基因必须属于基因库
 * 2. 起始基因
 */
public class MinMutation {
    public int minMutation(String start, String end, String[] bank) {
        int i;
        for (i = 0;i < bank.length; i++) {
            if (bank[i].equals(end)) {
                break;
            }
        }
        if (i == bank.length) {
            return -1;
        }

        // todo
        return 0;
    }
}
