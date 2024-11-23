import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game {
    public static void main(String[] args) {
        String filePath = "player_test_cases_updated.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Player[] players = parsePlayers(line);
                if (players != null) {
                    Player winner = GameOrchestrator.orchestrateGame(players[0], players[1]);
                    System.out.println("Winner: " + winner.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Player[] parsePlayers(String line) {
        try {
            String[] parts = line.split(";");
            Player playerA = parsePlayer(parts[0].trim().replace("PlayerA:", "").trim());
            Player playerB = parsePlayer(parts[1].trim().replace("PlayerB:", "").trim());
            return new Player[]{playerA, playerB};
        } catch (Exception e) {
            System.err.println("Failed to parse line: " + line);
            return null;
        }
    }

    private static Player parsePlayer(String playerData) {
        String[] attributes = playerData.split(",");
        return Player.builder()
                .name(attributes[0].split(":")[1].trim())
                .health(Integer.parseInt(attributes[1].split(":")[1].trim()))
                .strength(Integer.parseInt(attributes[2].split(":")[1].trim()))
                .attack(Integer.parseInt(attributes[3].split(":")[1].trim()))
                .build();
    }
}