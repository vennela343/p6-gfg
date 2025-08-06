class Solution {
    public int romanToDecimal(String s) {
        // code here
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;

        // Traverse the string from left to right
        for (int i = 0; i < s.length(); i++) {
            int value = romanMap.get(s.charAt(i));
            
            // If the current value is smaller than the next value, subtract it
            if (i + 1 < s.length() && value < romanMap.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }

        return result;
    }
}
