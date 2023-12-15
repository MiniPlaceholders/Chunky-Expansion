package io.github.miniplaceholders.expansion.example.common;

import io.github.miniplaceholders.api.Expansion;

public final class CommonExpansion {
    public static Expansion.Builder builder() {
        return Expansion.builder("example")
                .globalPlaceholder("some_placeholder", (queue, ctx) -> null);
    }
}
