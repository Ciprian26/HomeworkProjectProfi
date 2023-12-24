package test.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.api.LayoutComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class CustomLoggerConfigurationFactory {

    private static String folderName;

    public static String getFileName() {
        return new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
    }

    public static void updateLogConfig(String scenarioName) {
        folderName = buildDateForFolderName(scenarioName);
        String logsPath = "target/cucumber-logs/";
        Configuration configuration = buildConfiguration(logsPath + folderName + "/" + getFileName() + ".log");
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        context.setConfiguration(configuration);
        context.updateLoggers();
    }

    private static Configuration buildConfiguration(final String filePattern) {
        final ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();
        builder.setStatusLevel(Level.INFO);
        builder.setConfigurationName("Personalized logger");

        AppenderComponentBuilder appenderBuilder = builder.newAppender("consoleLog", "CONSOLE")
                .addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
        LayoutComponentBuilder layout = builder.newLayout("PatternLayout")
                .addAttribute("pattern", "%d [%t] %-5level: %msg%n");
        appenderBuilder.add(layout);
        builder.add(appenderBuilder);

        LayoutComponentBuilder layoutBuilder = builder.newLayout("PatternLayout")
                .addAttribute("pattern", "%d [%t] %-5level: %msg%n");
        builder.add(builder.newAppender("fileAppender", "RollingFile")
                .addAttribute("fileName", filePattern)
                .addAttribute("filePattern", filePattern)
                .add(layoutBuilder)
                .addComponent(builder.newComponent("SizeBasedTriggeringPolicy")
                        .addAttribute("size", "10MB")));

        builder.add(builder.newRootLogger(Level.INFO)
                .add(builder.newAppenderRef("consoleLog"))
                .add(builder.newAppenderRef("fileAppender")));

        return builder.build();
    }

    private static String buildDateForFolderName(String scenarioName) {
        String fileName = getFileName();
        return scenarioName.concat(" - ").concat(fileName);
    }
}