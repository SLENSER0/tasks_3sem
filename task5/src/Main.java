import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("1---------------------");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println("2--------------------");
        System.out.println(spiderVsFly("H3", "E2",1));
        System.out.println(spiderVsFly("A4", "B2",1));
        System.out.println(spiderVsFly("A4", "C2",1));
        System.out.println("3---------------------");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println("4---------------------");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println("5---------------------");
        System.out.println(sumsUp(new int[] {1, 2, 3, 4, 5}));
        System.out.println(sumsUp(new int[] {1, 2, 3, 7, 9}));
        System.out.println(sumsUp(new int[]  {10, 9, 7, 2, 8}));
        System.out.println(sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7}));
        System.out.println("6---------------------");
        System.out.println(takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[] {"10%"}));
        System.out.println(takeDownAverage(new String[] {"53%", "79%"}));
        System.out.println("7---------------------");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));
        System.out.println("8---------------------");
        System.out.println(setSetup(5,3));
        System.out.println(setSetup(7,3));
        System.out.println("9---------------------");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println("10---------------------");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));

    }

    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }


        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (map.containsKey(char1)) {
                if (map.get(char1) != char2) {
                    return false;
                }
            } else {
                if (map.containsValue(char2)) {
                    return false;
                }
                map.put(char1, char2);
            }
        }

        return true;
    }

    public static String spiderVsFly(String spyPos, String flyPos, double x) {
        Graph graph = new Graph();

        graph.addVertex("A0", Map.of("A1", x, "B1", x, "C1",x,"D1",x,"E1",x,"F1",x,"G1",x,"H1",x));

        graph.addVertex("A1", Map.of("A0", x, "B1", getDistanceBetweenRadials(x,1), "H1", getDistanceBetweenRadials(x,1),"A2",x));
        graph.addVertex("B1", Map.of("A0", x, "A1", getDistanceBetweenRadials(x,1), "C1", getDistanceBetweenRadials(x,1),"B2",x));
        graph.addVertex("C1", Map.of("A0", x,"B1", getDistanceBetweenRadials(x, 1), "D1", getDistanceBetweenRadials(x, 1), "C2", x));
        graph.addVertex("D1", Map.of("A0", x,"C1", getDistanceBetweenRadials(x, 1), "E1", getDistanceBetweenRadials(x, 1), "D2", x));
        graph.addVertex("E1", Map.of("A0", x,"D1", getDistanceBetweenRadials(x, 1), "F1", getDistanceBetweenRadials(x, 1), "E2", x));
        graph.addVertex("F1", Map.of("A0", x,"E1", getDistanceBetweenRadials(x, 1), "G1", getDistanceBetweenRadials(x, 1), "F2", x));
        graph.addVertex("G1", Map.of("A0", x,"F1", getDistanceBetweenRadials(x, 1), "H1", getDistanceBetweenRadials(x, 1), "G2", x));
        graph.addVertex("H1", Map.of("A0", x,"G1", getDistanceBetweenRadials(x, 1), "A1", getDistanceBetweenRadials(x, 1), "H2", x));

        graph.addVertex("A2", Map.of("A1", x, "B2", getDistanceBetweenRadials(x,2), "H2", getDistanceBetweenRadials(x,2),"A3",x));
        graph.addVertex("B2", Map.of("B1", x, "A2", getDistanceBetweenRadials(x,2), "C2", getDistanceBetweenRadials(x,2),"B3",x));
        graph.addVertex("C2", Map.of("C1", x, "B2", getDistanceBetweenRadials(x,2), "D2", getDistanceBetweenRadials(x,2),"C3",x));
        graph.addVertex("D2", Map.of("D1", x, "C2", getDistanceBetweenRadials(x,2), "E2", getDistanceBetweenRadials(x,2),"D3",x));
        graph.addVertex("E2", Map.of("E1", x, "D2", getDistanceBetweenRadials(x,2), "F2", getDistanceBetweenRadials(x,2),"E3",x));
        graph.addVertex("F2", Map.of("F1", x, "E2", getDistanceBetweenRadials(x,2), "G2", getDistanceBetweenRadials(x,2),"F3",x));
        graph.addVertex("G2", Map.of("G1", x, "F2", getDistanceBetweenRadials(x,2), "H2", getDistanceBetweenRadials(x,2),"G3",x));
        graph.addVertex("H2", Map.of("H1", x, "G2", getDistanceBetweenRadials(x,2), "A2", getDistanceBetweenRadials(x,2),"H3",x));

        graph.addVertex("A3", Map.of("A2", x, "B3", getDistanceBetweenRadials(x,3), "H3", getDistanceBetweenRadials(x,3),"A4",x));
        graph.addVertex("B3", Map.of("B2", x, "A3", getDistanceBetweenRadials(x,3), "C3", getDistanceBetweenRadials(x,3),"B4",x));
        graph.addVertex("C3", Map.of("C2", x, "B3", getDistanceBetweenRadials(x,3), "D3", getDistanceBetweenRadials(x,3),"C4",x));
        graph.addVertex("D3", Map.of("D2", x, "C3", getDistanceBetweenRadials(x,3), "E3", getDistanceBetweenRadials(x,3),"D4",x));
        graph.addVertex("E3", Map.of("E2", x, "D3", getDistanceBetweenRadials(x,3), "F3", getDistanceBetweenRadials(x,3),"E4",x));
        graph.addVertex("F3", Map.of("F2", x, "E3", getDistanceBetweenRadials(x,3), "G3", getDistanceBetweenRadials(x,3),"F4",x));
        graph.addVertex("G3", Map.of("G2", x, "F3", getDistanceBetweenRadials(x,3), "H3", getDistanceBetweenRadials(x,3),"G4",x));
        graph.addVertex("H3", Map.of("H2", x, "G3", getDistanceBetweenRadials(x,3), "A3", getDistanceBetweenRadials(x,3),"H4",x));

        graph.addVertex("A4", Map.of("A3", x, "B4", getDistanceBetweenRadials(x,4), "H4", getDistanceBetweenRadials(x,4)));
        graph.addVertex("B4", Map.of("B3", x, "A4", getDistanceBetweenRadials(x,4), "C4", getDistanceBetweenRadials(x,4)));
        graph.addVertex("C4", Map.of("C3", x, "B4", getDistanceBetweenRadials(x,4), "D4", getDistanceBetweenRadials(x,4)));
        graph.addVertex("D4", Map.of("D3", x, "C4", getDistanceBetweenRadials(x,4), "E4", getDistanceBetweenRadials(x,4)));
        graph.addVertex("E4", Map.of("E3", x, "D4", getDistanceBetweenRadials(x,4), "F4", getDistanceBetweenRadials(x,4)));
        graph.addVertex("F4", Map.of("F3", x, "E4", getDistanceBetweenRadials(x,4), "G4", getDistanceBetweenRadials(x,4)));
        graph.addVertex("G4", Map.of("G3", x, "F4", getDistanceBetweenRadials(x,4), "H4", getDistanceBetweenRadials(x,4)));
        graph.addVertex("H4", Map.of("H3", x, "G4", getDistanceBetweenRadials(x,4), "A4", getDistanceBetweenRadials(x,4)));

        DijkstraResult result = dijkstra(graph, spyPos);
        return getShortestPath(result, spyPos, flyPos);
    }

    public static class Graph {
        private Map<String, Map<String, Double>> vertices = new HashMap<>();

        public void addVertex(String name, Map<String, Double> edges) {
            vertices.put(name, edges);
        }

        public Map<String, Double> getEdges(String vertex) {
            return vertices.get(vertex);
        }
    }

    public static class DijkstraResult {
        private Map<String, Double> distances;
        private Map<String, String> previousVertices;

        public DijkstraResult(Map<String, Double> distances, Map<String, String> previousVertices) {
            this.distances = distances;
            this.previousVertices = previousVertices;
        }
        public Map<String, String> getPreviousVertices() {
            return previousVertices;
        }
    }

    public static DijkstraResult dijkstra(Graph graph, String start) {
        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previousVertices = new HashMap<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));


        for (String vertex : graph.vertices.keySet()) {
            if (vertex.equals(start)) {
                distances.put(vertex, 0.0);
            } else {
                distances.put(vertex, Double.MAX_VALUE);
            }
            previousVertices.put(vertex, null);
            priorityQueue.add(vertex);
        }

        while (!priorityQueue.isEmpty()) {
            String currentVertex = priorityQueue.poll();

            for (Map.Entry<String, Double> entry : graph.getEdges(currentVertex).entrySet()) {
                String neighbor = entry.getKey();
                Double weight = entry.getValue();

                Double newDistance = distances.get(currentVertex) + weight;

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    previousVertices.put(neighbor, currentVertex);
                    priorityQueue.remove(neighbor);
                    priorityQueue.add(neighbor);
                }
            }
        }

        return new DijkstraResult(distances, previousVertices);
    }

    public static String getShortestPath(DijkstraResult result, String start, String end) {
        List<String> path = new ArrayList<>();
        String currentVertex = end;

        while (currentVertex != null) {
            path.add(currentVertex);
            currentVertex = result.getPreviousVertices().get(currentVertex);
        }

        Collections.reverse(path);
        return String.join("-", path);
    }
    public static Double getDistanceBetweenRadials(double x, int level) {
        return level*x*0.765367; // 0.765367... = sin(45 deg)/sin(67.5 deg)
    }

    public static int digitsCount(long number) {
        if (Math.abs(number) < 10) {
            return 1;
        }
        return 1 + digitsCount(number / 10);
    }

    public static int totalPoints(String[] guessedWords, String scrambledWord) {
        int totalPoints = 0;

        for (String word : guessedWords) {
            if (isValidWord(scrambledWord, word)) {
                int wordLength = word.length();
                totalPoints += getPointsForWord(wordLength);
            }
        }
        return totalPoints;
    }
    private static boolean isValidWord(String scrambledWord, String guessedWord) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : scrambledWord.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : guessedWord.toCharArray()) {
            if (!charCountMap.containsKey(ch) || charCountMap.get(ch) == 0) {
                return false;
            }
            charCountMap.put(ch, charCountMap.get(ch) - 1);
        }
        return true;
    }

    private static int getPointsForWord(int wordLength) {
        return switch (wordLength) {
            case 3 -> 1;
            case 4 -> 2;
            case 5 -> 3;
            case 6 -> 4 + 50;
            default -> 0;
        };
    }

    public static List<List<Integer>> sumsUp(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == 8) {
                    answer.add(Arrays.asList(Math.min(nums[i], nums[j]), Math.max(nums[i], nums[j])));
                }
            }
        }
        return answer;
    }


    public static String takeDownAverage(String[] percentages) {
        double sum = 0;
        int n = percentages.length;
        for ( String string: percentages) {
            double percentage =Double.parseDouble(string.replaceAll("%", ""));
            sum += percentage;
        }
        double average = sum / n;
        return Math.round((average-5)*(n+1)-sum) + "%";
    }

    public static String caesarCipher(String operation, String message, int shift) {
        message = message.toUpperCase();
        if (operation.equals("encode")) {
            return encrypt(message, shift);
        } else if (operation.equals("decode")) {
            return decrypt(message, shift);
        } else {
            return "Неверный режим работы. Используйте 'encode' или 'decode'.";
        }
    }

    private static String encrypt(String message, int shift) {
        String answer = "";
        int len = message.length();
        for(int x = 0; x < len; x++){
            if (Character.isLetter(message.charAt(x))) {
                char c = (char)(message.charAt(x) + shift);
                if (c > 'z')
                    answer += (char)(message.charAt(x) - (26-shift));
                else
                    answer += (char)(message.charAt(x) + shift);
            }else {
                answer += message.charAt(x);
            }

        }
        return answer;
    }

    private static String decrypt(String message, int shift) {
        String answer = "";
        int len = message.length();
        for(int x = 0; x < len; x++){
            if (Character.isLetter(message.charAt(x))) {
                char c = (char)(message.charAt(x) - shift);
                if (c > 'z')
                    answer += (char)(message.charAt(x) + (26-shift));
                else
                    answer += (char)(message.charAt(x) - shift);
            }else {
                answer += message.charAt(x);
            }

        }
        return answer;

    }

    private static int setSetup(int n, int k) {
        if (n < k) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        return n * setSetup(n - 1, k - 1);
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy HH:mm");
            Date date = sdf.parse(timestamp);

            Map<String, Double> timeOffsets = new HashMap<>();
            timeOffsets.put("Los Angeles", -8.0);
            timeOffsets.put("New York", -5.0);
            timeOffsets.put("Caracas", -4.5);
            timeOffsets.put("Buenos Aires", -3.0);
            timeOffsets.put("London", 0.0);
            timeOffsets.put("Rome", 1.0);
            timeOffsets.put("Moscow", 3.0);
            timeOffsets.put("Tehran", 3.5);
            timeOffsets.put("New Delhi", 5.5);
            timeOffsets.put("Beijing", 8.0);
            timeOffsets.put("Canberra", 10.0);

            double offsetA = timeOffsets.get(cityA);
            double offsetB = timeOffsets.get(cityB);

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.HOUR_OF_DAY, (int) offsetB - (int) offsetA);
            cal.add(Calendar.MINUTE, (int) ((offsetB - offsetA - (int) (offsetB - offsetA)) * 60));

            SimpleDateFormat resultFormat = new SimpleDateFormat("yyyy-M-d HH:mm");
            return resultFormat.format(cal.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNew(int number) {
        String numberStr = String.valueOf(number);

        for (int i = 1; i < number; i++) {
            String currentNumberStr = String.valueOf(i);

            if (isPermutation(numberStr, currentNumberStr)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPermutation(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

}