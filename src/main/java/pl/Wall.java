package pl;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wall implements Structure{
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (blocks != null) {
            for (Block block : blocks) {
                if (block.color().equals(color)) {
                    return Optional.of(block);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> matchingBlocks = new ArrayList<>();
        outerLoop: for (Block block : blocks ) {
            if (block instanceof CompositeBlock) {
                if (block.material().equals(material)) {
                    if (block.material().equals(material)) {
                        matchingBlocks.add(block);
                    }
                } else {
                    for (Block composite : ((CompositeBlock) block).getBlocks()) {
                        if (composite.material().equals(material)) {
                            matchingBlocks.add(block);
                            break outerLoop;
                        }
                    }
                }

            }else {
                if (block.material().equals(material)) {
                    matchingBlocks.add(block);
                }
            }

        }
        return matchingBlocks;
    }

    @Override
    public int count() {
        return blocks.size();
    }
}
