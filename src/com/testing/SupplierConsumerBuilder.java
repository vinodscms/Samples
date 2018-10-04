package com.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierConsumerBuilder {
    public static void main(String args[]) {
        Computer comp = null;
        comp = GenericBuilder
                .of(Computer::new)
                .with(Computer::setMake,"Dell")
                .with(Computer::setModel,"XPS")
                .with(Computer::setRam,8)
                .build();
        System.out.println(comp);
    }
}

class Computer {
    private String make;
    private String model;
    private Integer ram;
    public String getMake() {        return make;    }
    public void setMake(String make) {        this.make = make;    }
    public String getModel() {        return model;    }
    public void setModel(String model) {        this.model = model;    }
    public Integer getRam() {        return ram;    }
    public void setRam(Integer ram) {        this.ram = ram;    }
    @Override
    public String toString() {
        return "Computer{" + "make='" + make + '\'' + ", model='" + model + '\'' + ", ram=" + ram + '}';
    }
}

class GenericBuilder<T> {

    private final Supplier<T> instantiator;

    private List<Consumer<T>> instanceModifiers = new ArrayList<>();

    public GenericBuilder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }

    public static <T> GenericBuilder<T> of(Supplier<T> instantiator) {
        return new GenericBuilder<T>(instantiator);
    }

    public <U> GenericBuilder<T> with(BiConsumer<T, U> consumer, U value) {
        Consumer<T> c = instance -> consumer.accept(instance, value);
        instanceModifiers.add(c);
        return this;
    }

    public T build() {
        T value = instantiator.get();
        instanceModifiers.forEach(modifier -> modifier.accept(value));
        instanceModifiers.clear();
        return value;
    }
}
