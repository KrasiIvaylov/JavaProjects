package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import static viceCity.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player{

   private String name;
   private int lifePoints;
   private Repository <Gun> gunRepository;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.lifePoints = lifePoints;
        this.gunRepository = new GunRepository();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    @Override
    public boolean isAlive() {
        return this.getLifePoints() > 0  ;
    }

    private void setLifePoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = points;
    }

    @Override
    public void takeLifePoints(int points) {
        if (this.getLifePoints() - points >=0) {
            this.setLifePoints(this.getLifePoints() - points);
        } else {
            this.setLifePoints(0);
        }

    }

}
