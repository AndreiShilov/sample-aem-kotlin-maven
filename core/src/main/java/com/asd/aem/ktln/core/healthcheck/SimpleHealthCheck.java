package com.asd.aem.ktln.core.healthcheck;

import org.apache.sling.hc.api.HealthCheck;
import org.apache.sling.hc.api.Result;
import org.apache.sling.hc.util.FormattingResultLog;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = HealthCheck.class, immediate = true, property = {
        HealthCheck.NAME + "=Simple Health Check",
        HealthCheck.TAGS + "=HC",
        HealthCheck.MBEAN_NAME + "=simpleHealthCheck"
})
@Designate(ocd = SimpleHealthCheck.Config.class)
public class SimpleHealthCheck implements HealthCheck {

    //    Hint matcher markdown pattern [text](link)
    private static final String SIMPLE_HINT = "[Simple hint message for health check](https://github.com/AndreiShilov/sample-aem-kotlin-maven)";

    //    Info is a Hint without a link (space instead of a link)
    private static final String SIMPLE_INFO = "[Simple info message for health check]( )";

    @ObjectClassDefinition(name = "Simple Health Check",
            description = "Simple demo for sling health check")
    public static @interface Config {
    }

    @Override
    public Result execute() {
        final FormattingResultLog resultLog = new FormattingResultLog();

        resultLog.info(SIMPLE_INFO);
        resultLog.info(SIMPLE_HINT);

        resultLog.critical("Some critical info = [{}]", "reason");
        resultLog.debug("Some debug info = [{}]", "debug");
        resultLog.warn("Some warn info = [{}]", "warning");
        resultLog.info("Some info = [{}]", "information");

        return new Result(resultLog);
    }

}
