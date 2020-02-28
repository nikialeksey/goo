package com.nikialeksey.goo;

import org.eclipse.jgit.transport.URIish;

public class Origin {

    private final URIish url;

    public Origin(final URIish url) {
        this.url = url;
    }

    public String user() {
        final String path = url.getPath();
        return path.substring(1, path.lastIndexOf('/'));
    }

    public String repo() {
        final String path = url.getPath();
        return path.substring(path.lastIndexOf('/') + 1, path.length() - 4);
    }
}
