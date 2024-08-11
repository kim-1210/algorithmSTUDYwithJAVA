package BackJoon;

import java.util.Scanner;
//나중에 한번더 보기
public class Continuous_max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double[] nums = new double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextDouble();
        }

        double maxProduct = findMaxProduct(nums, 0, N - 1);

        System.out.printf("%.3f", maxProduct);
    }

    private static double findMaxProduct(double[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        // 왼쪽 부분에서의 최대 곱
        double leftMax = findMaxProduct(nums, left, mid);
        // 오른쪽 부분에서의 최대 곱
        double rightMax = findMaxProduct(nums, mid + 1, right);
        // 중간을 포함하는 최대 곱
        double crossMax = findMaxCrossingProduct(nums, left, mid, right);

        // 세 값 중 최대값 반환
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private static double findMaxCrossingProduct(double[] nums, int left, int mid, int right) {
        // 왼쪽에서 중간까지 곱의 최대값 찾기
        double leftProduct = 1;
        double maxLeftProduct = Double.NEGATIVE_INFINITY;
        for (int i = mid; i >= left; i--) {
            leftProduct *= nums[i];
            if (leftProduct > maxLeftProduct) {
                maxLeftProduct = leftProduct;
            }
        }

        // 오른쪽에서 중간까지 곱의 최대값 찾기
        double rightProduct = 1;
        double maxRightProduct = Double.NEGATIVE_INFINITY;
        for (int i = mid + 1; i <= right; i++) {
            rightProduct *= nums[i];
            if (rightProduct > maxRightProduct) {
                maxRightProduct = rightProduct;
            }
        }

        // 중간을 포함한 최대 곱 반환
        return maxLeftProduct * maxRightProduct;
    }
}

