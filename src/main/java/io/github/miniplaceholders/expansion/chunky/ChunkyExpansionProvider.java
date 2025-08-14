package io.github.miniplaceholders.expansion.chunky;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.api.provider.ExpansionProvider;
import io.github.miniplaceholders.api.provider.LoadRequirement;
import io.github.miniplaceholders.expansion.chunky.placeholder.*;
import org.popcraft.chunky.Chunky;
import org.popcraft.chunky.ChunkyProvider;

public final class ChunkyExpansionProvider implements ExpansionProvider {

    @Override
    public Expansion provideExpansion() {
        final Chunky chunky = ChunkyProvider.get();
        
        final ChunkyRegistrable[] registrables = {
                registrable("exists", new TaskPregenExistsPlaceholder(chunky)),
                registrable("running", new TaskPregenRunningPlaceholder(chunky)),
                registrable("cancelled", new TaskPregenCancelledPlaceholder(chunky)),
                registrable("centerx", new TaskPregenCenterXPlaceholder(chunky)),
                registrable("centerz", new TaskPregenCenterZPlaceholder(chunky)),
                registrable("radiusz", new TaskPregenRadiusZPlaceholder(chunky)),
                registrable("count", new TaskPregenCountPlaceholder(chunky)),
                registrable("pattern", new TaskPregenPatternPlaceholder(chunky)),
                registrable("shape", new TaskPregenShapePlaceholder(chunky)),
                registrable("time", new TaskPregenTimePlaceholder(chunky)),
                registrable("world", new TaskPregenWorldPlaceholder(chunky)),
                registrable("chunks", new TaskPregenChunksPlaceholder(chunky)),
                registrable("complete", new TaskPregenCompletePlaceholder(chunky)),
                registrable("percent", new TaskPregenPercentPlaceholder(chunky)),
                registrable("hours", new TaskPregenHoursPlaceholder(chunky)),
                registrable("minutes", new TaskPregenMinutesPlaceholder(chunky)),
                registrable("seconds", new TaskPregenSecondsPlaceholder(chunky)),
                registrable("rate", new TaskPregenRatePlaceholder(chunky)),
                registrable("x", new TaskPregenXPlaceholder(chunky)),
                registrable("z", new TaskPregenZPlaceholder(chunky)),
                registrable("radius", new TaskPregenRadiusXPlaceholder(chunky))
        };

        final Expansion.Builder builder = Expansion.builder("chunky")
                .version("2.0.0")
                .author("MiniPlaceholders Contributors");

        for (final ChunkyRegistrable registrable : registrables) {
            builder.globalPlaceholder("task_pregen_" + registrable.name, registrable.placeholder);
        }

        return builder.build();
    }

    @Override
    public LoadRequirement loadRequirement() {
        return LoadRequirement.requiredComplement("chunky", "Chunky");
    }

    ChunkyRegistrable registrable(String name, ChunkyPlaceholder placeholder) {
        return new ChunkyRegistrable(name, placeholder);
    }
    
    record ChunkyRegistrable(String name, ChunkyPlaceholder placeholder) {}
}
