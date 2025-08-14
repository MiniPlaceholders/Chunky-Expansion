package io.github.miniplaceholders.expansion.chunky.placeholder;

import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.popcraft.chunky.Chunky;
import org.popcraft.chunky.GenerationTask;

import java.util.Optional;

public final class TaskPregenPercentPlaceholder extends ChunkyPlaceholder {
    public TaskPregenPercentPlaceholder(final Chunky chunky) {
        super(chunky);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final Context context) {
        final Optional<GenerationTask> task = taskFromArgument(argumentQueue);
        if (task.isEmpty()) {
            return null;
        } else {
            return Tag.preProcessParsed(Float.toString(task.get().getProgress().getPercentComplete()));
        }
    }
}
