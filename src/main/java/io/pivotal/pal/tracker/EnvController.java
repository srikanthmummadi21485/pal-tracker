package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private final String port;
    private final String memoryLimit;
    private final String cfInstanceIndex;
    private final String cfInstanceAddress;

    public EnvController(
            @Value("${PORT:NOT SET}") String port,
            @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,
            @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfInstanceIndex,
            @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfInstanceAddress
    ) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddress = cfInstanceAddress;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<>();

        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memoryLimit);
        env.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR", cfInstanceAddress);

        return env;
    }


//    String PORT;
//    String MEMORY_LIMIT;
//    String CF_INSTANCE_INDEX;
//    String CF_INSTANCE_ADDR;
//
//    public EnvController (String PORT, String MEMORY_LIMIT, String CF_INSTANCE_INDEX, String CF_INSTANCE_ADDR) {
//        this.PORT = PORT;
//        this.CF_INSTANCE_ADDR = CF_INSTANCE_ADDR;
//        this.CF_INSTANCE_INDEX = CF_INSTANCE_INDEX;
//        this.MEMORY_LIMIT = MEMORY_LIMIT;
//    }
//
//    @GetMapping("/env")
//    public Map<String, String> getEnv() {
//
//        Map<String, String> stringMap = new HashMap<>();
//        stringMap.put("PORT","8080");
//        stringMap.put("CF_INSTANCE_ADDR","123.sesame.street");
//        stringMap.put("CF_INSTANCE_INDEX","34");
//        stringMap.put("MEMORY_LIMIT","12G");
//        return stringMap;
//    }
}
