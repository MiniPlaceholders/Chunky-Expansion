package io.github.miniplaceholders.expansion.chunky.placeholder;

import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.popcraft.chunky.Chunky;
import org.popcraft.chunky.GenerationTask;

public final class TaskPregenWorldPlaceholder extends ChunkyPlaceholder {
    public TaskPregenWorldPlaceholder(final Chunky chunky) {
        super(chunky);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final Context context) {
        final String world = argumentQueue.popOr("world name required").value();
        final GenerationTask runningTask = chunky.getGenerationTasks().get(world);
        if (runningTask == null) {
            return null;
        } else {
            return Tag.preProcessParsed(runningTask.getProgress().getWorld());
        }
    }
}
