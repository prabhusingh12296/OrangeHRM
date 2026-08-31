package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverManager;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static byte[] captureScreenshot() {

        return ((TakesScreenshot)
                DriverManager.getDriver())
                .getScreenshotAs(
                        OutputType.BYTES);
    }

    public static void saveScreenshot(
            String fileName) {

        File source =
                ((TakesScreenshot)
                        DriverManager.getDriver())
                        .getScreenshotAs(
                                OutputType.FILE);

        Path destination = Path.of(
                "screenshots",
                fileName + ".png");

        try {

            Files.createDirectories(
                    destination.getParent());

            Files.copy(
                    source.toPath(),
                    destination);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to save screenshot", e);
        }
    }
}