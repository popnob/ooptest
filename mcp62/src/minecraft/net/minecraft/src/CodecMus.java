package net.minecraft.src;

import java.io.InputStream;
import java.net.URLConnection;
import paulscode.sound.codecs.CodecJOrbis;

public class CodecMus extends CodecJOrbis
{
    public CodecMus()
    {
    }

    protected InputStream openInputStream()
    {
        try
        {
            return new MusInputStream(this, url, urlConnection.getInputStream());
        }
        catch (Throwable t)
        {
            return null;
        }
    }
}
