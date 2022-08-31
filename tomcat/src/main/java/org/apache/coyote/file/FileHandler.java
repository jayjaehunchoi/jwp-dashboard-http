package org.apache.coyote.file;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public abstract class FileHandler {

    private String prefix;

    public FileHandler(final String prefix) {
        this.prefix = prefix;
    }

    public String getFileLines(final String path) throws IOException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(prefix + path);
        return new String(Files.readAllBytes(new File(resource.getFile()).toPath()));
    }
}
