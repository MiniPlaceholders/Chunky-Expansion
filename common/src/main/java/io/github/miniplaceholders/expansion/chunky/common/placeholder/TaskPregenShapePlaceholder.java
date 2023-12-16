package io.github.miniplaceholders.expansion.chunky.common.placeholder;

import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.popcraft.chunky.Chunky;
import org.popcraft.chunky.GenerationTask;
import org.popcraft.chunky.Selection;

import java.util.Optional;

public final class TaskPregenShapePlaceholder extends ChunkyPlaceholder {
    public TaskPregenShapePlaceholder(final Chunky chunky) {
        super(chunky);
    }

    @Override
    public Tag apply(final ArgumentQueue argumentQueue, final Context context) {
        final Optional<GenerationTask> task = taskFromArgument(argumentQueue);
        return Tag.preProcessParsed(task.map(GenerationTask::getSelection)
                .map(Selection::shape).orElse("shape"));
    }
}
