package io.github.miniplaceholders.expansion.chunky.placeholder;

import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.popcraft.chunky.Chunky;
import org.popcraft.chunky.GenerationTask;

public final class TaskPregenCountPlaceholder extends ChunkyPlaceholder {
    public TaskPregenCountPlaceholder(final Chunky chunky) {
        super(chunky);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final Context context) {
        return processTaskLongTag(argumentQueue, GenerationTask::getCount);
    }
}
