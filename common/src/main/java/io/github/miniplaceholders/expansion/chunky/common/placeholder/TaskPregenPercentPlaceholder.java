package io.github.miniplaceholders.expansion.chunky.common.placeholder;

import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.popcraft.chunky.Chunky;
import org.popcraft.chunky.GenerationTask;

public final class TaskPregenPercentPlaceholder extends ChunkyPlaceholder {
    public TaskPregenPercentPlaceholder(final Chunky chunky) {
        super(chunky);
    }

    @Override
    public Tag apply(final ArgumentQueue argumentQueue, final Context context) {
        final String world = argumentQueue.popOr("world name required").value();
        final GenerationTask runningTask = chunky.getGenerationTasks().get(world);
        if (runningTask == null) {
            return null;
        } else {
            return Tag.preProcessParsed(Float.toString(runningTask.getProgress().getPercentComplete()));
        }
    }
}
