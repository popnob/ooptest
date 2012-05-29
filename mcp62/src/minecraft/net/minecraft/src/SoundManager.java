package net.minecraft.src;

import java.io.File;
import java.io.PrintStream;
import java.util.Random;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

public class SoundManager
{
    /** A reference to the sound system. */
    private static SoundSystem sndSystem;

    /** Sound pool containing sounds. */
    private SoundPool soundPoolSounds;

    /** Sound pool containing streaming audio. */
    private SoundPool soundPoolStreaming;

    /** Sound pool containing music. */
    private SoundPool soundPoolMusic;

    /**
     * The last ID used when a sound is played, passed into SoundSystem to give active sounds a unique ID
     */
    private int latestSoundID;

    /** A reference to the game settings. */
    private GameSettings options;

    /** Set to true when the SoundManager has been initialised. */
    private static boolean loaded = false;

    /** RNG. */
    private Random rand;
    private int ticksBeforeMusic;

    public SoundManager()
    {
        soundPoolSounds = new SoundPool();
        soundPoolStreaming = new SoundPool();
        soundPoolMusic = new SoundPool();
        latestSoundID = 0;
        rand = new Random();
        ticksBeforeMusic = rand.nextInt(12000);
    }

    /**
     * Used for loading sound settings from GameSettings
     */
    public void loadSoundSettings(GameSettings par1GameSettings)
    {
        soundPoolStreaming.isGetRandomSound = false;
        options = par1GameSettings;

        if (!loaded && (par1GameSettings == null || par1GameSettings.soundVolume != 0.0F || par1GameSettings.musicVolume != 0.0F))
        {
            tryToSetLibraryAndCodecs();
        }
    }

    /**
     * Tries to add the paulscode library and the relevant codecs. If it fails, the volumes (sound and music) will be
     * set to zero in the options file.
     */
    private void tryToSetLibraryAndCodecs()
    {
        try
        {
            float f = options.soundVolume;
            float f1 = options.musicVolume;
            options.soundVolume = 0.0F;
            options.musicVolume = 0.0F;
            options.saveOptions();
            SoundSystemConfig.addLibrary(paulscode.sound.libraries.LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", paulscode.sound.codecs.CodecJOrbis.class);
            SoundSystemConfig.setCodec("mus", net.minecraft.src.CodecMus.class);
            SoundSystemConfig.setCodec("wav", paulscode.sound.codecs.CodecWav.class);
            sndSystem = new SoundSystem();
            options.soundVolume = f;
            options.musicVolume = f1;
            options.saveOptions();
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }

        loaded = true;
    }

    /**
     * Called when one of the sound level options has changed.
     */
    public void onSoundOptionsChanged()
    {
        if (!loaded && (options.soundVolume != 0.0F || options.musicVolume != 0.0F))
        {
            tryToSetLibraryAndCodecs();
        }

        if (loaded)
        {
            if (options.musicVolume == 0.0F)
            {
                sndSystem.stop("BgMusic");
            }
            else
            {
                sndSystem.setVolume("BgMusic", options.musicVolume);
            }
        }
    }

    /**
     * Called when Minecraft is closing down.
     */
    public void closeMinecraft()
    {
        if (loaded)
        {
            sndSystem.cleanup();
        }
    }

    /**
     * Adds a sounds with the name from the file. Args: name, file
     */
    public void addSound(String par1Str, File par2File)
    {
        soundPoolSounds.addSound(par1Str, par2File);
    }

    /**
     * Adds an audio file to the streaming SoundPool.
     */
    public void addStreaming(String par1Str, File par2File)
    {
        soundPoolStreaming.addSound(par1Str, par2File);
    }

    /**
     * Adds an audio file to the music SoundPool.
     */
    public void addMusic(String par1Str, File par2File)
    {
        soundPoolMusic.addSound(par1Str, par2File);
    }

    /**
     * If its time to play new music it starts it up.
     */
    public void playRandomMusicIfReady()
    {
        if (!loaded || options.musicVolume == 0.0F)
        {
            return;
        }

        if (!sndSystem.playing("BgMusic") && !sndSystem.playing("streaming"))
        {
            if (ticksBeforeMusic > 0)
            {
                ticksBeforeMusic--;
                return;
            }

            SoundPoolEntry soundpoolentry = soundPoolMusic.getRandomSound();

            if (soundpoolentry != null)
            {
                ticksBeforeMusic = rand.nextInt(12000) + 12000;
                sndSystem.backgroundMusic("BgMusic", soundpoolentry.soundUrl, soundpoolentry.soundName, false);
                sndSystem.setVolume("BgMusic", options.musicVolume);
                sndSystem.play("BgMusic");
            }
        }
    }

    /**
     * Sets the listener of sounds
     */
    public void setListener(EntityLiving par1EntityLiving, float par2)
    {
        if (!loaded || options.soundVolume == 0.0F)
        {
            return;
        }

        if (par1EntityLiving == null)
        {
            return;
        }
        else
        {
            float f = par1EntityLiving.prevRotationYaw + (par1EntityLiving.rotationYaw - par1EntityLiving.prevRotationYaw) * par2;
            double d = par1EntityLiving.prevPosX + (par1EntityLiving.posX - par1EntityLiving.prevPosX) * (double)par2;
            double d1 = par1EntityLiving.prevPosY + (par1EntityLiving.posY - par1EntityLiving.prevPosY) * (double)par2;
            double d2 = par1EntityLiving.prevPosZ + (par1EntityLiving.posZ - par1EntityLiving.prevPosZ) * (double)par2;
            float f1 = MathHelper.cos(-f * 0.01745329F - (float)Math.PI);
            float f2 = MathHelper.sin(-f * 0.01745329F - (float)Math.PI);
            float f3 = -f2;
            float f4 = 0.0F;
            float f5 = -f1;
            float f6 = 0.0F;
            float f7 = 1.0F;
            float f8 = 0.0F;
            sndSystem.setListenerPosition((float)d, (float)d1, (float)d2);
            sndSystem.setListenerOrientation(f3, f4, f5, f6, f7, f8);
            return;
        }
    }

    public void playStreaming(String par1Str, float par2, float par3, float par4, float par5, float par6)
    {
        if (!loaded || options.soundVolume == 0.0F && par1Str != null)
        {
            return;
        }

        String s = "streaming";

        if (sndSystem.playing("streaming"))
        {
            sndSystem.stop("streaming");
        }

        if (par1Str == null)
        {
            return;
        }

        SoundPoolEntry soundpoolentry = soundPoolStreaming.getRandomSoundFromSoundPool(par1Str);

        if (soundpoolentry != null && par5 > 0.0F)
        {
            if (sndSystem.playing("BgMusic"))
            {
                sndSystem.stop("BgMusic");
            }

            float f = 16F;
            sndSystem.newStreamingSource(true, s, soundpoolentry.soundUrl, soundpoolentry.soundName, false, par2, par3, par4, 2, f * 4F);
            sndSystem.setVolume(s, 0.5F * options.soundVolume);
            sndSystem.play(s);
        }
    }

    /**
     * Plays a sound. Args: soundName, x, y, z, volume, pitch
     */
    public void playSound(String par1Str, float par2, float par3, float par4, float par5, float par6)
    {
        if (!loaded || options.soundVolume == 0.0F)
        {
            return;
        }

        SoundPoolEntry soundpoolentry = soundPoolSounds.getRandomSoundFromSoundPool(par1Str);

        if (soundpoolentry != null && par5 > 0.0F)
        {
            latestSoundID = (latestSoundID + 1) % 256;
            String s = (new StringBuilder()).append("sound_").append(latestSoundID).toString();
            float f = 16F;

            if (par5 > 1.0F)
            {
                f *= par5;
            }

            sndSystem.newSource(par5 > 1.0F, s, soundpoolentry.soundUrl, soundpoolentry.soundName, false, par2, par3, par4, 2, f);
            sndSystem.setPitch(s, par6);

            if (par5 > 1.0F)
            {
                par5 = 1.0F;
            }

            sndSystem.setVolume(s, par5 * options.soundVolume);
            sndSystem.play(s);
        }
    }

    /**
     * Plays a sound effect with the volume and pitch of the parameters passed. The sound isn't affected by position of
     * the player (full volume and center balanced)
     */
    public void playSoundFX(String par1Str, float par2, float par3)
    {
        if (!loaded || options.soundVolume == 0.0F)
        {
            return;
        }

        SoundPoolEntry soundpoolentry = soundPoolSounds.getRandomSoundFromSoundPool(par1Str);

        if (soundpoolentry != null)
        {
            latestSoundID = (latestSoundID + 1) % 256;
            String s = (new StringBuilder()).append("sound_").append(latestSoundID).toString();
            sndSystem.newSource(false, s, soundpoolentry.soundUrl, soundpoolentry.soundName, false, 0.0F, 0.0F, 0.0F, 0, 0.0F);

            if (par2 > 1.0F)
            {
                par2 = 1.0F;
            }

            par2 *= 0.25F;
            sndSystem.setPitch(s, par3);
            sndSystem.setVolume(s, par2 * options.soundVolume);
            sndSystem.play(s);
        }
    }
}
