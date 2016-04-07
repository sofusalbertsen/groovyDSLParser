public interface Parser {
    Object eval(String key);
    public <T> T eval(String key,String clazz);
    void setup(String input);
}
