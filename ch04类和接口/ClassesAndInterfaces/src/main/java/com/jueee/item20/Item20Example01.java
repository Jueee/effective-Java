package com.jueee.item20;

public class Item20Example01 {
    
    // 代表歌曲的类
    public class Song {}
    // 代表音频的类
    public class AudioClip {}

    // 代表歌手的接口
    public interface Singer {
        AudioClip sing(Song s);
    }

    // 代表作曲家的接口
    public interface Songwriter {
        Song compose(int chartPosition);
    }

    // 在现实生活中，一些歌手也是作曲家。 
    // 因为我们使用接口而不是抽象类来定义这些类型，所以单个类实现歌手和作曲家两个接口是完全允许的。 
    // 事实上，我们可以定义一个继承歌手和作曲家的第三个接口，并添加适合于这个组合的新方法
    public interface SingerSongwriter extends Singer, Songwriter {
        AudioClip strum();  // 弹奏
        void actSensitive();
    }

    
}
