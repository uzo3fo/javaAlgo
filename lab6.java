/* You live in the city of Cartesia where all roads are laid out in a perfect grid. You arrived ten minutes too early to an appointment, so you decided to take the opportunity to go for a short walk. The city provides its citizens with a Walk Generating App on their phones -- everytime you press the button it sends you an array of one-letter strings representing directions to walk (eg. ['n', 's', 'w', 'e']). You know it takes you one minute to traverse one city block, so create a function that will return true if the walk the app gives you will take you exactly ten minutes (you don't want to be early or late!) and will, of course, return you to your starting point. Return false otherwise. */

public class lab6 {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) {
            return false;
        }

        int northSouthPosition = 0;
        int westEastPosition = 0;

        for (char direction : walk) {
            switch (direction) {
                case 'n':
                    northSouthPosition++;
                    break;
                case 'e':
                    westEastPosition++;
                    break;
                case 's':
                    northSouthPosition--;
                    break;
                case 'w':
                    westEastPosition--;
                    break;
                default:
                    throw new IllegalStateException("Unknown direction: " + direction);
            }
        }

        return northSouthPosition == 0 && westEastPosition == 0;
    }
}