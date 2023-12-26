public record Config(String version, String auth) {

    public String getAuth() {
        return auth;
    }

    public String getVersion() {
        return version;
    }
}
