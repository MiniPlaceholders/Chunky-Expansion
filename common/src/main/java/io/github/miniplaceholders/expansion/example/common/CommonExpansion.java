package io.github.miniplaceholders.expansion.example.common;

import io.github.miniplaceholders.api.Expansion;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.popcraft.chunky.Chunky;
import org.popcraft.chunky.ChunkyProvider;
import org.popcraft.chunky.GenerationTask;
import org.popcraft.chunky.Selection;
import org.popcraft.chunky.iterator.ChunkIterator;

import java.util.Optional;

public final class CommonExpansion {
    public static Expansion.Builder builder() {
        final Chunky chunky = ChunkyProvider.get();

        final Expansion.Builder builder = Expansion.builder("chunky")
                .globalPlaceholder(placeholder("exists"), (queue, ctx) -> {
                    final Optional<GenerationTask> task = taskFromArgument(chunky, queue);
                    return Tag.preProcessParsed(Boolean.toString(task.isPresent()));
                })
                .globalPlaceholder(placeholder("running"), (queue, ctx) -> {
                    final String world = queue.popOr("world name required").value();
                    final GenerationTask runningTask = chunky.getGenerationTasks().get(world);
                    return Tag.preProcessParsed(Boolean.toString(runningTask != null));
                })
                .globalPlaceholder(placeholder("cancelled"), (queue, ctx) -> {
                    final Optional<GenerationTask> task = taskFromArgument(chunky, queue);
                    return toBooleanTag(task.map(GenerationTask::isCancelled));
                })
                .globalPlaceholder(placeholder("centerx"), (queue, ctx) -> {
                    final Optional<GenerationTask> task = taskFromArgument(chunky, queue);
                    return Tag.preProcessParsed(Double.toString(task.map(GenerationTask::getSelection)
                            .map(Selection::centerZ).orElse(0D)));
                })
                .globalPlaceholder(placeholder("radiusz"), (queue, ctx) -> {
                    final Optional<GenerationTask> task = taskFromArgument(chunky, queue);
                    return toDoubleTag(task.map(GenerationTask::getSelection).map(Selection::radiusZ));
                })
                .globalPlaceholder(placeholder("count"), (queue, ctx) -> {
                    final Optional<GenerationTask> task = taskFromArgument(chunky, queue);
                    return toLongTag(task.map(GenerationTask::getCount));
                })
                .globalPlaceholder(placeholder("pattern"), (queue, ctx) -> {
                    final Optional<GenerationTask> task = taskFromArgument(chunky, queue);
                    return Tag.preProcessParsed(task.map(GenerationTask::getChunkIterator)
                            .map(ChunkIterator::name).orElse("pattern"));
                })
                .globalPlaceholder(placeholder("shape"), (queue, ctx) -> {
                    final Optional<GenerationTask> task = taskFromArgument(chunky, queue);
                    return Tag.preProcessParsed(task.map(GenerationTask::getSelection)
                            .map(Selection::shape).orElse("shape"));
                })
                .globalPlaceholder(placeholder("time"), (queue, ctx) -> {
                    final Optional<GenerationTask> task = taskFromArgument(chunky, queue);
                    return toLongTag(task.map(GenerationTask::getTotalTime));
                });

        // TODO: world, chunks, complete, percent, hours, minutes, seconds, rate, x, z placeholders

        for (final String name : new String[]{"radius", "radiusx"}) {
            builder.globalPlaceholder(placeholder(name), (queue, ctx) -> {
                final Optional<GenerationTask> task = taskFromArgument(chunky, queue);
                return toDoubleTag(task.map(GenerationTask::getSelection).map(Selection::centerZ));
            });
        }

        return builder;
    }

    private static Optional<GenerationTask> taskFromArgument(Chunky chunky, ArgumentQueue queue) {
        final String world = queue.popOr("world name required").value();
        final GenerationTask runningTask = chunky.getGenerationTasks().get(world);
        return Optional.ofNullable(runningTask)
                .or(() -> chunky.getServer().getWorld(world).flatMap(w -> chunky.getTaskLoader().loadTask(w)));
    }

    private static String placeholder(final String name) {
        return "task_pregen_" + name;
    }

    private static Tag toBooleanTag(Optional<Boolean> optional) {
        return Tag.preProcessParsed(Boolean.toString(optional.orElse(false)));
    }

    private static Tag toDoubleTag(Optional<Double> optional) {
        return Tag.preProcessParsed(Double.toString(optional.orElse(0D)));
    }

    private static Tag toLongTag(Optional<Long> optional) {
        return Tag.preProcessParsed(Long.toString(optional.orElse(0L)));
    }
}
