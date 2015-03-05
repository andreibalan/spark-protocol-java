package dev.andreibalan.spark.protocol.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;

public class Server {

    private final static Logger Log = LoggerFactory.getLogger(Server.class.getSimpleName());

    public static class Options {

        private File coreKeysDir;

        public Options(File coreKeysDir) {
            this.coreKeysDir = coreKeysDir;
        }

    }

    private final Options options;

    private final FilenameFilter fileFilter = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return (!dir.isDirectory() && (name.endsWith(".pem") || name.endsWith(".json")));
        }
    };

    public Server() {
        this(new Options(new File("./data")));
    }

    public Server(Options options) {
        Log.debug("Construct");

        this.options = options;
        loadCoreData();
    }

    public void loadCoreData() {
        Log.debug("loadCoreData");

        if(!this.options.coreKeysDir.exists()) {
            Log.debug("Core keys directory didn't exist. Creating %s", this.options.coreKeysDir.toString());
            this.options.coreKeysDir.mkdirs();
        }

        for(final File fileEntry : this.options.coreKeysDir.listFiles(this.fileFilter)) {

        }
    }

    public void saveCoreData() {

    }



}
