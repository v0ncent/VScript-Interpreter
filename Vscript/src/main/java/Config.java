public class Config {
    private final String version;
    private final String auth;

    public Config(String version, String auth) {
        this.version = version;
        this.auth = auth;
    }
    public String getAuth() {
        return auth;
    }
    public String getVersion() {
        return version;
    }
}
