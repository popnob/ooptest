// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.InputStream;
import java.net.URLConnection;
import paulscode.sound.codecs.CodecJOrbis;

// Referenced classes of package net.minecraft.src:
//            MusInputStream

public class CodecMus extends CodecJOrbis
{

    public CodecMus()
    {
    }

    protected InputStream openInputStream()
    {
        return new MusInputStream(this, url, urlConnection.getInputStream());
    }
}
