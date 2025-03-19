import java.util.Stack;

public class StockSpan{

    public static int[] calculateStockSpan(int[] prices) {
        int[] spans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            // Pop elements from the stack while the current price is greater
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // Calculate the span
            if (stack.isEmpty()) {
                spans[i] = i + 1; // All previous days are less than or equal
            } else {
                spans[i] = i - stack.peek(); // Span is the difference between current and previous greater day
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return spans;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateStockSpan(prices);

        System.out.print("Spans: ");
        for (int span : spans) {
            System.out.print(span + " ");
        }
        System.out.println(); // New line.
    }
}
