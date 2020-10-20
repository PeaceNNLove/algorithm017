package Week_03.homework;

public class PowX {

    /**
     * 方法一：
     * 首次尝试分治
     */
    public double myPow(double x, int n) {
        if (x == 0 || x == 1 || n == 1) {
            return x;
        }
        if (n == 0) {
            return 1.0;
        }
        if (n == -1) {
            return 1 / x;
        }
        double halfPowX = myPow(x, n / 2);
        if (n % 2 == 0) {
            return halfPowX * halfPowX;
        } else {
            if (n > 0) {
                return halfPowX * halfPowX * x;
            } else {
                return halfPowX * halfPowX * (1 / x);
            }
        }
    }

    /**
     * 方法二：
     * 看完答案后的分治,抽象封装
     * 先根据n>0 还是 <0 进行分治
     * 再根据n是奇数还是偶数进行分治
     */
    public double myPow2(double x, int m) {
        return (long) m > 0 ? powX(x, m) : 1.0 / powX(x, -(long) m);
    }

    public double powX(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double halfPowX = powX(x, n / 2);
        return n % 2 == 0 ? halfPowX * halfPowX : halfPowX * halfPowX * x;
    }
}
