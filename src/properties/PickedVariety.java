package properties;

import enums.Variety;

public class PickedVariety {
    private Variety variety;
    private boolean picked;

    public PickedVariety(Variety variety) {
        this.variety = variety;
    }

    public Variety getVariety() {
        return variety;
    }

    public void setVariety(Variety variety) {
        this.variety = variety;
    }

    public boolean isPicked() {
        return picked;
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }
}
