package server;

import java.io.Serializable;

public enum ServerListeningMode implements Serializable{
    REFRESH_INFO, WARBOARD_REQ, LEADERBOARD_REQ, VILAGE_REQ, VILAGE_ATTACK, MAP_REQ, ATTACKED, ATTACK_ENDED, REFRESH_ATTACK;
}
