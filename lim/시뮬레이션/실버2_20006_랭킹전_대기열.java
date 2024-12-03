package lim.시뮬레이션;

import java.util.*;
import java.io.*;

public class 실버2_20006_랭킹전_대기열 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int capacity;
    static Player[] players;

    static class Player implements Comparable<Player> {
        String name;
        int level;

        Player(int level, String name) {
            this.name = name;
            this.level = level;
        }

        boolean inRange(int lowerLevel, int upperLevel) {
            return lowerLevel <= level && level <= upperLevel;
        }

        @Override
        public int compareTo(Player o) {
            return this.name.compareTo(o.name);
        }
    }

    static class Room {
        static final int LEVEL_RANGE = 10;
        int lowerBound, upperBound, capacity;
        ArrayList<Player> players = new ArrayList<>();

        Room(Player host, int capacity) {
            this.lowerBound = host.level - LEVEL_RANGE;
            this.upperBound = host.level + LEVEL_RANGE;
            this.capacity = capacity;
            this.players.add(host);
        }

        boolean isFull() {
            return this.players.size() == capacity;
        }

        boolean canJoin(Player player) {
            return !isFull() && player.inRange(lowerBound, upperBound);
        }

        void addPlayer(Player player) {
            if (player.inRange(lowerBound, upperBound)) {
                this.players.add(player);
            }
        }

        void printPlayers() throws IOException {
            this.players.sort(null);
            for (Player player : this.players) {
                bw.write(player.level + " " + player.name + "\n");
            }
        }
    }

    static void sol() throws IOException {
        ArrayList<Room> rooms = new ArrayList<>();
        for (Player player : players) {
            Room targetRoom = null;
            for (Room room : rooms) {
                if (room.canJoin(player)) {
                    targetRoom = room;
                    break;
                }
            }
            if (targetRoom == null) {
                targetRoom = new Room(player, capacity);
                rooms.add(targetRoom);
            } else {
                targetRoom.addPlayer(player);
            }
        }
        for (Room room : rooms) {
            if (room.isFull()) {
                bw.write("Started!\n");
            } else {
                bw.write("Waiting!\n");
            }
            room.printPlayers();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        capacity = Integer.parseInt(st.nextToken());

        players = new Player[n];
        for (int i = 0; i < players.length; i++) {
            st = new StringTokenizer(br.readLine());
            players[i] = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        sol();
        br.close();
        bw.flush();
        bw.close();
    }
}
