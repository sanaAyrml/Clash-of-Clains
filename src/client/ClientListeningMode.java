package client;

import java.io.Serializable;

public enum  ClientListeningMode implements Serializable{
    LEADERBOARD_REQ, WARBOARD_REQ, VILAGE_REQ, VILAGE_ATTACK, ATTACKED, MAP_REQ, NUM_REQ, ATTACK_ENDED;
}
