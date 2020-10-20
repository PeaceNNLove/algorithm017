package Week_03.homework;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    private List<List<Integer>> lists = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        deepIn(n, k);
        return lists;
    }

    public void deepIn(int num, int k) {
        // 剪枝，如果剩下的数+已经加入列表的已经不足k个，那么没有进行下去的意义
        if (num + list.size() < k) {
            return;
        }
        if (k == list.size()) {
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(num);
        // 加入当前层
        deepIn(num - 1, k);
        // 这里就是移除当前层，无需管进入函数后list的变化，因为里面都有这一句话，所以实际上回来时list的最后一个索引就是当前值
        list.remove(list.size() - 1);
        // 不加入当前层
        deepIn(num - 1, k);
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.combine(4, 2);
    }
}
