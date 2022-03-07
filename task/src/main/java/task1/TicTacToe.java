package task1;

public class TicTacToe {
    public int size;
    public enum Element {X, O, h, v, r, dr}
    public Element[][] map;

    public TicTacToe(int size) {
        this.size = size;
        map = new Element[size][size];
    }

    public void addOrClear(int coordinateX, int coordinateY, Element element) { map[coordinateY-1][coordinateX-1] = element; }

    public int maxLine(Element element, Element way, int x, int y) {
        int nowCount = 0;
        int maxCount = 0;
        int dx = 0;
        int dy = 0;
        if (way == Element.h) { dx = 1; }
        if (way == Element.v) { dy = 1; }
        if (way == Element.r) { dx = 1; dy = 1; }
        if (way == Element.dr) { dx = 1; dy = -1; y = size - 1; }
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
    public int calculateLines(Element element) {
        int result = 0;
        for (int i = 0; i < size; i++) {
            int resultInLineV = maxLine(element, Element.v, i, 0);
            int resultInLineH = maxLine(element, Element.h, 0, i);
            if (resultInLineH > resultInLineV) { resultInLineV = resultInLineH; }
            if (resultInLineV > result) { result = resultInLineV; }
        }
        return result;
    }

    public int largestLine(Element element) {
        int maxLineForVH = calculateLines(element);
        int maxD = maxLine(element, Element.r, 0, 0);
        int maxRD = maxLine(element, Element.dr, 0, 0);
        if (maxLineForVH > maxD) { maxD = maxLineForVH; }
        if (maxD > maxRD) { maxRD = maxD; }
        return maxRD;
    }
}
