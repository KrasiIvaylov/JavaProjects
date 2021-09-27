package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GunRepository implements Repository<Gun> {

    private Map<String, Gun> models;

    public GunRepository() {
        this.models = new HashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Gun model) {
        if (!models.containsKey(model)) {
            this.models.put(model.getName(), model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        Gun removedGun = models.get(model.getName());
        boolean isRemoved = true;

        if (removedGun == null) {
            isRemoved = false;
        }
        return isRemoved;
    }

    @Override
    public Gun find(String name) {
        return this.models.get(name);
    }
}

