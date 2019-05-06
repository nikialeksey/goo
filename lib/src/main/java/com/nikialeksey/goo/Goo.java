package com.nikialeksey.goo;

import com.nikialeksey.functions.Function0;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Goo {

    private final Function0<Repository, GooException> repo;

    public Goo(final File gitDir) {
        this(
            () -> {
                try {
                    return new FileRepositoryBuilder()
                        .setGitDir(gitDir)
                        .setMustExist(true)
                        .build();
                } catch (IOException e) {
                    throw new GooException(
                        String.format(
                            "Can not build the git repo from git folder: %s",
                            gitDir.getAbsolutePath()
                        ),
                        e
                    );
                }
            }
        );
    }

    public Goo(final Function0<Repository, GooException> repo) {
        this.repo = repo;
    }

    public Origin origin() throws GooException {
        try {
            return new Origin(
                new URL(
                    repo.execute()
                        .getConfig()
                        .getString("remote", "origin", "url")
                )
            );
        } catch (MalformedURLException e) {
            throw new GooException("Can not form the origin url.", e);
        }
    }
}
