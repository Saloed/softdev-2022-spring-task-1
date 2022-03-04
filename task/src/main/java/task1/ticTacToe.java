package task1;

public class ticTacToe {
    public int size;
    public String[][] map;

    public ticTacToe(int size) {
        this.size = size;
        map = new String[size][size];
    }

    public void addOrClear(int coordinate, String element) {
        int oY = (coordinate / 10) - 1;
        int oX = (coordinate % 10) - 1;
        map[oY][oX] = element;
    }

    public int maxLine(String element, String way, int x, int y) {
        int nowCount = 0;
        int maxCount = 0;
        int dx = 0;
        int dy = 0;
        if (way.equals("h")) { dx = 1; }
        if (way.equals("v")) { dy = 1; }
        if (way.equals("d")) { dx = 1; dy = 1; }
        if (way.equals("rd")) { dx = 1; dy = -1; y = size - 1; }
        while (x < size && y < size && y >= 0) {
            if (map[y][x] == element) {
                nowCount++;
                if ((x == size-1 || y == size-1) && nowCount > maxCount ) {
                    maxCount = nowCount;
                    nowCount = 0;
                }
            }
            else {
                if (nowCount > maxCount) {
                    maxCount = nowCount;
                    nowCount = 0;
                }
            }
            x+=dx;
            y+=dy;
        }
        return maxCount;
    }
    public int calculateLines(String element) {
        int result = 0;
        for (int i = 0; i < size; i++) {
            int resultInLineV = maxLine(element, "v", i, 0);
            int resultInLineH = maxLine(element, "h", 0, i);
            if (resultInLineH > resultInLineV) { resultInLineV = resultInLineH; }
            if (resultInLineV > result) { result = resultInLineV; }
        }
        return result;
    }

    public int largestLine(String element) {
        int maxLineForVH = calculateLines(element);
        int maxD = maxLine(element, "d", 0, 0);
        int maxRD = maxLine(element, "rd", 0, 0);
        if (maxLineForVH > maxD) { maxD = maxLineForVH; }
        if (maxD > maxRD) { maxRD = maxD; }
        return maxRD;
    }
}
