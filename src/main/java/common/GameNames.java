package common;

public enum GameNames {

    /*
    * Here maintain game categories of the side panel
    * */

    HARRY_BOY("harry-boy"),
    V75("v75"),
    V86("v86"),
    GRAND_SLAM_75("gs75"),
    V4("v4");

    private final String name;

    GameNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
