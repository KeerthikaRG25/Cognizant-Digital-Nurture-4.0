public class FinancialForecasting {

    
    public static double futureValueRecursive(double initialAmount, double growthRate, int years) {
        // Base case
        if (years == 0) {
            return initialAmount;
        }

      
        return futureValueRecursive(initialAmount, growthRate, years - 1) * (1 + growthRate);
    }

 
    public static double futureValueMemo(double initialAmount, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return initialAmount;
        }

        if (memo[years] != 0) {
            return memo[years];
        }

        memo[years] = futureValueMemo(initialAmount, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }

    // Main method to test
    public static void main(String[] args) {
        double initialAmount = 1000.0;     
        double growthRate = 0.10;          
        int years = 5;                     

        double resultRecursive = futureValueRecursive(initialAmount, growthRate, years);
        System.out.printf("📈 Future Value (Recursive): ₹%.2f\n", resultRecursive);

        double[] memo = new double[years + 1];
        double resultMemo = futureValueMemo(initialAmount, growthRate, years, memo);
        System.out.printf("⚡ Future Value (Memoized): ₹%.2f\n", resultMemo);
    }
}
