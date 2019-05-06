package com.nikialeksey.goo;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class GooTest {
    @Test
    public void currentRepoOriginUrl() throws Exception {
        Assert.assertThat(
            new Goo(new File("../.git")).origin().repo(),
            IsEqual.equalTo("goo")
        );
    }
}