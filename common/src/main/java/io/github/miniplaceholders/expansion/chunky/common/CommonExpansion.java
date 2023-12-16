package io.github.miniplaceholders.expansion.chunky.common;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expansion.chunky.common.placeholder.*;
import org.popcraft.chunky.Chunky;
import org.popcraft.chunky.ChunkyProvider;

public final class CommonExpansion {
    public static Expansion.Builder builder() {
        final Chunky chunky = ChunkyProvider.get();

        final Expansion.Builder builder = Expansion.builder("chunky")
                .globalPlaceholder(placeholder("exists"), new TaskPregenExistsPlaceholder(chunky))
                .globalPlaceholder(placeholder("running"), new TaskPregenRunningPlaceholder(chunky))
                .globalPlaceholder(placeholder("cancelled"), new TaskPregenCancelledPlaceholder(chunky))
                .globalPlaceholder(placeholder("centerx"), new TaskPregenCenterXPlaceholder(chunky))
                .globalPlaceholder(placeholder("centerz"), new TaskPregenCenterZPlaceholder(chunky))
                .globalPlaceholder(placeholder("radiusz"), new TaskPregenRadiusZPlaceholder(chunky))
                .globalPlaceholder(placeholder("count"), new TaskPregenCountPlaceholder(chunky))
                .globalPlaceholder(placeholder("pattern"), new TaskPregenPatternPlaceholder(chunky))
                .globalPlaceholder(placeholder("shape"), new TaskPregenShapePlaceholder(chunky))
                .globalPlaceholder(placeholder("time"), new TaskPregenTimePlaceholder(chunky))
                .globalPlaceholder(placeholder("world"), new TaskPregenWorldPlaceholder(chunky))
                .globalPlaceholder(placeholder("chunks"), new TaskPregenChunksPlaceholder(chunky))
                .globalPlaceholder(placeholder("complete"), new TaskPregenCompletePlaceholder(chunky))
                .globalPlaceholder(placeholder("percent"), new TaskPregenPercentPlaceholder(chunky))
                .globalPlaceholder(placeholder("hours"), new TaskPregenHoursPlaceholder(chunky))
                .globalPlaceholder(placeholder("minutes"), new TaskPregenMinutesPlaceholder(chunky))
                .globalPlaceholder(placeholder("seconds"), new TaskPregenSecondsPlaceholder(chunky))
                .globalPlaceholder(placeholder("rate"), new TaskPregenRatePlaceholder(chunky))
                .globalPlaceholder(placeholder("x"), new TaskPregenXPlaceholder(chunky))
                .globalPlaceholder(placeholder("z"), new TaskPregenZPlaceholder(chunky));

        final var radiusXPlaceholder = new TaskPregenRadiusXPlaceholder(chunky);
        builder.globalPlaceholder(placeholder("radius"), radiusXPlaceholder);
        builder.globalPlaceholder(placeholder("radiusx"), radiusXPlaceholder);

        return builder;
    }

    private static String placeholder(final String name) {
        return "task_pregen_" + name;
    }
}
