package io.github.miniplaceholders.expansion.chunky.common.placeholder;

import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.popcraft.chunky.Chunky;
import org.popcraft.chunky.GenerationTask;

import java.util.Optional;
import java.util.function.BiFunction;

public abstract sealed class ChunkyPlaceholder implements BiFunction<ArgumentQueue, Context, Tag>
        permits TaskPregenCancelledPlaceholder,
                TaskPregenCenterXPlaceholder,
                TaskPregenCenterZPlaceholder,
                TaskPregenChunksPlaceholder,
                TaskPregenCompletePlaceholder,
                TaskPregenCountPlaceholder,
                TaskPregenExistsPlaceholder,
                TaskPregenHoursPlaceholder,
                TaskPregenMinutesPlaceholder,
                TaskPregenPatternPlaceholder,
                TaskPregenPercentPlaceholder,
                TaskPregenRadiusXPlaceholder,
                TaskPregenRadiusZPlaceholder,
                TaskPregenRatePlaceholder,
                TaskPregenRunningPlaceholder,
                TaskPregenSecondsPlaceholder,
                TaskPregenShapePlaceholder,
                TaskPregenTimePlaceholder,
                TaskPregenWorldPlaceholder,
                TaskPregenXPlaceholder,
                TaskPregenZPlaceholder {
    protected final Chunky chunky;

    protected ChunkyPlaceholder(final Chunky chunky) {
        this.chunky = chunky;
    }

    protected Optional<GenerationTask> taskFromArgument(ArgumentQueue queue) {
        final String world = queue.popOr("world name required").value();
        final GenerationTask runningTask = chunky.getGenerationTasks().get(world);
        return Optional.ofNullable(runningTask)
                .or(() -> chunky.getServer().getWorld(world).flatMap(w -> chunky.getTaskLoader().loadTask(w)));
    }

    protected Tag toBooleanTag(Optional<Boolean> optional) {
        return Tag.preProcessParsed(Boolean.toString(optional.orElse(false)));
    }

    protected Tag toDoubleTag(Optional<Double> optional) {
        return Tag.preProcessParsed(Double.toString(optional.orElse(0D)));
    }

    protected Tag toLongTag(Optional<Long> optional) {
        return Tag.preProcessParsed(Long.toString(optional.orElse(0L)));
    }
}
