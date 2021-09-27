package viceCity.models.guns;

public class Rifle extends BaseGun{
    private static final int INITIAL_BULLETS_PER_BARREL = 50;
    private static final int INITIAL_TOTAL_BULLETS = 500;
    private static final int INITIAL_BULLETS_TO_SHOOT = 5;

    public Rifle(String name) {
        super(name, INITIAL_BULLETS_PER_BARREL, INITIAL_TOTAL_BULLETS);
    }

    @Override
    public int fire () {
        if (this.getBulletsPerBarrel() == 0) {
            this.reload();
            if (this.getBulletsPerBarrel() == 0) {
                return 0;
            }
        }
        this.setBulletsPerBarrel(this.getBulletsPerBarrel() - INITIAL_BULLETS_TO_SHOOT);
        return INITIAL_BULLETS_TO_SHOOT;
    }
    private void reload() {
        if (this.getTotalBullets() > 0 ) {
            int restTotalBullets = this.getTotalBullets() - INITIAL_BULLETS_PER_BARREL;
            this.setTotalBullets(restTotalBullets);
            this.setBulletsPerBarrel(INITIAL_BULLETS_PER_BARREL);
        }
    }
}
