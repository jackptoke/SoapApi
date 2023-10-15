package dev.toke.capitalsoapapi.services;




import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ComponentService {
    public enum Status { SUCCESS, FAILURE }
    private static List<dev.toke.capitalsoapapi.models.Component> components = new ArrayList<>();
    static {
        dev.toke.capitalsoapapi.models.Component component1 = new dev.toke.capitalsoapapi.models.Component(1, "Component 1", 0.156f);
        dev.toke.capitalsoapapi.models.Component component2 = new dev.toke.capitalsoapapi.models.Component(2, "Component 2", 0.157f);
        dev.toke.capitalsoapapi.models.Component component3 = new dev.toke.capitalsoapapi.models.Component(3, "Component 3", 0.186f);
        dev.toke.capitalsoapapi.models.Component component4 = new dev.toke.capitalsoapapi.models.Component(4, "Component 4", 0.159f);
        dev.toke.capitalsoapapi.models.Component component5 = new dev.toke.capitalsoapapi.models.Component(5, "Component 5", 0.256f);

        components.add(component1);
        components.add(component2);
        components.add(component3);
        components.add(component4);
        components.add(component5);
    }

    public dev.toke.capitalsoapapi.models.Component findById(int partNumber) {
        for(var component: components) {
            if(component.getPartNumber() == partNumber) return component;
        }
        return null;
    }

    public List<dev.toke.capitalsoapapi.models.Component> findAll() {
        return components;
    }

    public Status deleteById(int partNumber) {
        Iterator<dev.toke.capitalsoapapi.models.Component> iterator = components.iterator();

        while(iterator.hasNext()) {
            var component = iterator.next();
            if(component.getPartNumber() == partNumber) {
                components.remove(component);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
}
