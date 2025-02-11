package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

//@Slf4j
@RestController
public class LogTestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);
//        log.info("info log with Slf4j annotation = {}", name);
        logger.trace("trace log = {}", name);
        logger.debug("debug log = {}", name);
        logger.info("info log = {}", name);
        logger.warn("warn log = {}", name);
        logger.error("error log = {}", name);

        return "done";
    }

    @GetMapping("/mapping/{userId}")
//    public String mappingPath(@PathVariable String userId) {
    public String mappingPath(@PathVariable("userId") String data) {
        logger.info("MappingPath userId = {}", data);

        return "done";
    }

    @GetMapping("/mapping/users/{userId}/orders/{order}")
    public String mappingPath2(@PathVariable String userId, @PathVariable String order) {
        logger.info("MappingPath userId = {}, order = {}", userId, order);

        return "done";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        logger.info("mappingConsumes");
        return "done";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        logger.info("mappingProduces");
        return "done";
    }
}
