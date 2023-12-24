package test.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ScenarioContext {
    private static final ScenarioContext INSTANCE = new ScenarioContext();

    private final Map<ScenarioKeys, Object> context;

    private ScenarioContext() {
        context = new HashMap<>();
    }

    public static ScenarioContext getInstance() {
        return INSTANCE;
    }

    public void saveData(ScenarioKeys key, Object value) {
        context.put(key, value);
    }

    public <T> T getData(ScenarioKeys key) {
        return (T) context.get(key);
    }

    public void clearContext() {
        context.clear();
    }

    public <T> T getDataOrDefault(ScenarioKeys key, T defaultValue) {
        if (Objects.isNull(context.get(key))) {
            return defaultValue;
        } else {
            return (T) context.get(key);
        }
    }
}
