class Solution {
    public String convertDateToBinary(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        String yearBin = toBinary(year);
        String monthBin = toBinary(month);
        String dayBin = toBinary(day);

        return yearBin + "-" + monthBin + "-" + dayBin;
    }

    private String toBinary(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);   // store remainder
            n /= 2;             // divide by 2
        }
        return sb.reverse().toString();
    }
}
