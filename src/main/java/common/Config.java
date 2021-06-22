package common;

public class Config {

    /**
     * Specify the browser and platform for test:
     * ChromeDriver(Chrome) for windows
     *
     * GeckoDriver(Mozilla FireFox) for windows
     */
    public static final String BROWSER_AND_PLATFORM = "CHROME_WINDOWS";

    /**
     * Clean browser cookies after each iterations
     */
    public static final Boolean CLEAR_COOKIES = true;

    /**
     * To keep browser open after all scenarios
     */
    public static final Boolean HOLD_BROWSER_OPEN = true;

}
