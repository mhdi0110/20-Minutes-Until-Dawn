package io.github.some_example_name.Model;

public class PlayerData {
    private String username;
    private String password;
    private String security;
    private String securityAnswer;
    private int score;
    private int kills;
    private int level;
    private int timeAlive;

    public void save(Player player) {
        username = player.getUsername();
        password = player.getPassword();
        security = player.getSecurity();
        securityAnswer = player.getSecurityAnswer();
        score = player.getScore();
        kills = player.getKills();
        level = player.getLevel();
        timeAlive = player.getTimeAlive();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSecurity() {
        return security;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public int getScore() {
        return score;
    }

    public int getKills() {
        return kills;
    }

    public int getLevel() {
        return level;
    }

    public int getTimeAlive() {
        return timeAlive;
    }
}
