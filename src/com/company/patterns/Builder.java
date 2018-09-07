package com.company.patterns;


/**
 * Builds a composite and complex object and client class need not know the complexity of object creation
 * ex: Menu creation, Pizza creation etc
 */
public class Builder
{
    public static void main(String[] args)
    {
        HouseBuilder iglooBuilder = new IglooHouseBuilder();
        Engineer engineer = new Engineer(iglooBuilder);

        engineer.constructHouse();

        House house = engineer.getHouse();

        System.out.println("Building constructed: "+ house);
    }
}

class Engineer {

    private HouseBuilder houseBuilder;

    public Engineer(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House getHouse() {
        return this.houseBuilder.getHouse();
    }

    public void constructHouse() {
        this.houseBuilder.buildBasement();
        this.houseBuilder.buildStructure();
        this.houseBuilder.bulidRoof();
        this.houseBuilder.buildInterior();
    }
}

interface HousePlan{
    public void setBasement(String basement);
    public void setStructure(String structure);
    public void setRoof(String roof);
    public void setInterior(String interior);
}

class House implements HousePlan{
    private String basement;
    private String structure;
    private String roof;
    private String interior;

    public void setBasement(String basement){this.basement = basement;}
    public void setStructure(String structure){this.structure = structure;}
    public void setRoof(String roof){this.roof = roof;}
    public void setInterior(String interior){this.interior = interior;}

    @Override
    public String toString() {
        return "House build: " +basement+structure+roof+interior;
    }
}


interface HouseBuilder{

    public void buildBasement();
    public void buildStructure();
    public void bulidRoof();
    public void buildInterior();

    public House getHouse();
}

class IglooHouseBuilder implements HouseBuilder {
    private House house;

    public IglooHouseBuilder() {
        this.house = new House();
    }

    public void buildBasement() {
        house.setBasement("Ice Lake");
    }
    public void buildStructure() {
        house.setStructure("Ice Blocks");
    }
    public void buildInterior() {
        house.setInterior("Ice Carvings");
    }
    public void bulidRoof() {
        house.setRoof("Ice Dome");
    }

    public House getHouse() {
        return this.house;
    }
}

class WoodenHouseBuilder implements HouseBuilder {
    private House house;

    public WoodenHouseBuilder() {
        this.house = new House();
    }

    public void buildBasement() {
        house.setBasement("Wooden Poles");
    }
    public void buildStructure() {
        house.setStructure("Wood");
    }
    public void buildInterior() {
        house.setInterior("Fire Wood");
    }
    public void bulidRoof() {
        house.setRoof("Wood planks");
    }

    public House getHouse() {
        return this.house;
    }

}




