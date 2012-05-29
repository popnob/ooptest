package net.minecraft.src;

import java.util.HashSet;

public class WrUpdateState
{
    public ChunkCache chunkcache;
    public RenderBlocks renderblocks;
    public HashSet setOldEntityRenders;
    public int renderPass;
    public int y;
    public boolean flag;
    public boolean hasRenderedBlocks;
    public boolean hasGlList;

    public WrUpdateState()
    {
        chunkcache = null;
        renderblocks = null;
        setOldEntityRenders = null;
        renderPass = 0;
        y = 0;
        flag = false;
        hasRenderedBlocks = false;
        hasGlList = false;
    }
}
