package io.github.miniplaceholders.expansion.chunky.placeholder;

import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.popcraft.chunky.Chunky;

public final class TaskPregenCenterZPlaceholder extends ChunkyPlaceholder {
    public TaskPregenCenterZPlaceholder(final Chunky chunky) {
        super(chunky);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final Context context) {
        return processTaskDoubleTag(argumentQueue, task -> task.getSelection().centerZ());
    }
}
