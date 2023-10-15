package dev.toke.capitalsoapapi.models;

public class Component {
    private int partNumber;
    private String description;
    private float weight;

    public Component(int partNumber, String description, float weight) {
        super();
        this.partNumber = partNumber;
        this.description = description;
        this.weight = weight;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Component{" +
                "partNumber=" + partNumber +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                '}';
    }
}
