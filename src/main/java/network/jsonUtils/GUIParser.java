package network.jsonUtils;

import gameLogic.invocator.card.CardType;
import gui.GUICard;
import network.Messages;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GUIParser {
    public ArrayList<GUICard> getCardsFromInit(String jsonInit) {
        ArrayList<GUICard> playerCards = new ArrayList<>();
        try {
            JSONObject init = new JSONObject(jsonInit);
            JSONObject gameStat = init.getJSONObject(Messages.JSON_GAMESTATE);
            JSONArray cards = gameStat.getJSONArray(Messages.JSON_TYPE_CARDS);

            for (int c = 0; c < cards.length(); c++) {
                JSONObject card = cards.getJSONObject(c);
                playerCards
                    .add(
                        new GUICard(
                            card.getInt(Messages.JSON_TYPE_CARD_ID),
                            card.getString(Messages.JSON_TYPE_NAME),
                            CardType.getType(card.getString(Messages.JSON_TYPE)),
                            card.getInt(Messages.JSON_TYPE_COST)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return playerCards;
    }
}
