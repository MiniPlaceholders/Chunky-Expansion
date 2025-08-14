package io.github.miniplaceholders.expansion.chunky.placeholder;

import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.popcraft.chunky.Chunky;

public final class TaskPregenCompletePlaceholder extends ChunkyPlaceholder {
    public TaskPregenCompletePlaceholder(final Chunky chunky) {
        super(chunky);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final Context context) {
        return processTaskBooleanTag(argumentQueue, task -> task.getProgress().isComplete());
    }
}
