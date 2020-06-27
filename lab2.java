/* The new"Avengers"movie has just been released!There are a lot of people at the cinema box office standing in a huge line.Each of them has a single 100,50 or 25 dollar bill.An"Avengers"ticket costs 25 dollars.

Vasya is currently working as a clerk.He wants to sell a ticket to every single person in this line.

Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets strictly in the order people queue?

Return YES,if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment.Otherwise return NO.

Examples:Line.Tickets(new int[]{25,25,50}) // => YES 
Line.Tickets(new int[]{25,100}) // => NO. Vasya will not have enough money to give change to 100 dollars
Line.Tickets(new int[]{25,25,50,50,100}) // => NO. Vasya w
 */

public class lab2 {
    public static String Tickets(int[] peopleInLine) {
        // Your code is here...
        String result = "NO";
        int change = 25;
        if (peopleInLine[0] != 25) {
            result = "NO";
        }
        for (int i = 1; i < peopleInLine.length; i++) {
            int ticket = peopleInLine[i];
            int balance = ticket - change;
            if (balance <= change) {
                result = "YES";
            } else {
                result = "NO";
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] peopleInLine = { 25, 25, 50 };
        System.out.println(Tickets(peopleInLine));
    }
}