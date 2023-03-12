package study.qa.owner.config;

import org.aeonbits.owner.Config;

import java.util.List;

public interface FruitsConfig extends Config {

    @Key("array")
    String[] getFruitsArray();

    @Key("array-default")
    @DefaultValue("orange,apple")
    String[] getFruitsArrayWithDefaultValues();

    @Key("list")
    List<String> getFruitsList();

    @Key("list-separator")
    @Separator(";")
    @DefaultValue("orange;banana")
    List<String> getFruitsListWithSeparator();
}
