package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private final static String INITIAL_PLAYER_NAME = "Tommy Vercetti";
    private final static String INITIAL_COMMAND = "Vercetti";

    private MainPlayer mainPlayer;
    private Collection<Player> civilPlayers;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.civilPlayers.add(player);

        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        String output;

        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;

            default:
                return GUN_TYPE_INVALID;

        }

   //     if (gun == null) {
   //         output = GUN_TYPE_INVALID;
   //     } else {
            output = String.format(GUN_ADDED, name, type);
            this.guns.offer(gun);
    //    }

        return output;
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = guns.peek();

        if (gun == null) {
            return GUN_QUEUE_IS_EMPTY;
        }
        if (INITIAL_COMMAND.equals(name)) {
            gun = this.guns.poll();
            this.mainPlayer.getGunRepository().add(gun);

            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), INITIAL_PLAYER_NAME);
        }
        Player player = this.civilPlayers
                .stream()
                .filter(p -> p.getName()
                        .equals(name))
                .findFirst()
                .orElse(null);

        if (player == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        gun = this.guns.poll();
        player.getGunRepository().add(gun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), player.getName());
    }

    @Override
    public String fight() {
        this.neighbourhood.action(this.mainPlayer, this.civilPlayers);

        int deadCivilians = 0;

        for (Player civilPlayer : civilPlayers) {
            if (!civilPlayer.isAlive()){
                deadCivilians++;
            }
        }


        StringBuilder sb = new StringBuilder();

        boolean civilPlayersAlive = false;

        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.getLifePoints() == 50){
                civilPlayersAlive = true;
            }
        }


        if (this.mainPlayer.getLifePoints() == 100 && civilPlayersAlive) {
            sb.append(FIGHT_HOT_HAPPENED);
        } else {
            sb.append(FIGHT_HAPPENED);
            sb.append(System.lineSeparator());
            sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, this.mainPlayer.getLifePoints()));
            sb.append(System.lineSeparator());
            sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadCivilians));
            sb.append(System.lineSeparator());
            sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, this.civilPlayers.size() - deadCivilians));
        }

        return sb.toString().trim();
    }
}
