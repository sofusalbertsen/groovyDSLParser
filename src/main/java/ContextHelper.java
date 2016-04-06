import groovy.lang.Closure;

public class ContextHelper {
    private ContextHelper() {
    }

    static Object executeInContext(Closure closure, Object context) {
        closure.setDelegate(context);
        closure.setResolveStrategy(Closure.DELEGATE_FIRST);
        return closure.call();
    }
}
