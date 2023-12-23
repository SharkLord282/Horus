
import org.junit.Test;
import pl.Block;
import pl.CompositeBlock;
import pl.Wall;


import java.util.List;
import java.util.Optional;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class WallTest {

    Wall wall = new Wall();

    @Test
    public void findBlockByColorTest() {

      Block mockBlock1 = mock(Block.class);
      Block mockBlock2 = mock(Block.class);

      when(mockBlock1.color()).thenReturn("red");
      when(mockBlock2.color()).thenReturn("blue");

      List<Block> testList = List.of(mockBlock1,mockBlock2);

      wall.setBlocks(testList);

      Optional<Block> result = wall.findBlockByColor("blue");

      assertEquals("blue", result.orElseThrow().color());
    }

    @Test
    public void findBlocksByMaterialTest() {
        Block mockBlock1 = mock(Block.class);
        Block mockBlock2 = mock(Block.class);
        Block mockBlock3 = mock(Block.class);

        when(mockBlock1.material()).thenReturn("wood");
        when(mockBlock2.material()).thenReturn("stone");
        when(mockBlock3.material()).thenReturn("steel");

        CompositeBlock mockCompositeBlock = mock(CompositeBlock.class);
        List<Block> compositeBlocks = List.of(mockBlock1,mockBlock2);

        when(mockCompositeBlock.getBlocks()).thenReturn(compositeBlocks);
        when(mockCompositeBlock.material()).thenReturn("stoneWood");

        List<Block> blocks = List. of(mockBlock1,mockBlock2,mockBlock3,mockCompositeBlock);

        wall.setBlocks(blocks);

        List<Block> result = wall.findBlocksByMaterial("wood");

        assertEquals(2, result.size());
        assertEquals("wood", result.get(0).material());

    }

    @Test
    public void countTest() {
        Block mockBlock1 = mock(Block.class);
        Block mockBlock2 = mock(Block.class);
        Block mockBlock3 = mock(Block.class);
        CompositeBlock mockCompositeBlock = mock(CompositeBlock.class);


        List<Block> blocks = List. of(mockBlock1,mockBlock2,mockBlock3,mockCompositeBlock);
        wall.setBlocks(blocks);

        int result = wall.count();
        assertEquals(4,result);

    }


}
