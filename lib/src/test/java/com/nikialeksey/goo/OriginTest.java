package com.nikialeksey.goo;

import org.eclipse.jgit.transport.URIish;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class OriginTest {
    @Test
    public void originScpLike() throws Exception {
        Assert.assertThat(
            new Origin(new URIish("git@github.com:nikialeksey/goo.git")).repo(),
            IsEqual.equalTo("goo")
        );
    }

    @Test
    public void originHttpsLike() throws Exception {
        Assert.assertThat(
            new Origin(new URIish("https://github.com/nikialeksey/foo.git"))
                .user(),
            IsEqual.equalTo("nikialeksey")
        );
    }
}