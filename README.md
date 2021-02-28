# HowTo.UniversalModCore

In this repo I want to give you some basics about Universal Mod Core (UMC).

### Please note

* **This is not a Java tutorial!** To work with Universal Mod Core you should have knowledge in Java programming.
* **UMC does not yet offer by far all the features that Forge offers.** For example, if you just want to make a small mod that adds some standard blocks and items, I highly recommend you to deal with Forge first, as UMC doesn't offer a proper integration of "normal" blocks yet.

To give a rough overview of the possibilities of UMC, the developer cam72cam has also developed its own mod based on it. This is "Immersive Railroading", which adds a complex railroad system with flexibly placeable rails not limited to the block grid, complex physics and easily expandable with resource packs to add new trains.

So you can program really complex, but well optimized mods that cover many versions, but you have to be prepared for various compromises.

## How to get started

*Take a look at the branches in this repo. Depending on how you want to start, I have provided you with different stands.*

Here you get a rough basic structure with which one can start well.

1. Load the repo into your favorite IDE
2. Open build.gradle and change the following lines to match your mod:
   
   ![](https://i.imgur.com/rPQ5LZX.png)
   
   * ``version`` is the version of the mod which you should upgrade with every public update
   * ``modPackage`` is the main package structure of the mod
   * ``modClass`` is the class in which the individual start events of Minecraft are processed when the mod is started
   * ``modName`` is the name of the mod :P
   * ``modId`` is the unique ID with which the mod is identified in Minecraft. This should consist exclusively of lowercase letters and not contain any special characters
3. Open settings.gradle and enter the mod name there
4. Execute ``./gradlew umc -D umc.loader=1.12.2-forge`` (I always recommend programming in 1.12.2 by default because this Gradle integration of UMC works the most stable.)
5. The basic structure is generated and now recognized as a Java project. Now open the created "Mod" class under src/main/java/org/example/Mod.java. You will notice that one class is missing. So create under your ``modPackage`` the ``modClass`` you defined in step 2.
   
   This class could look like this:
   ```java
   package org.example;
   
   import cam72cam.mod.ModCore;
   import cam72cam.mod.ModEvent;
   
   public class ExampleMod extends ModCore.Mod {
   
       public static final String MODID = "examplemod";
   
       @Override
       public String modID() {
           return MODID;
       }
   
       @Override
       public void commonEvent(ModEvent event) {
           switch (event) {
               case CONSTRUCT:
                   //Register network packets, blocks, items, guis, and so on here
                   break;
               case INITIALIZE:
                   //Do config stuff here
                   break;
               case SETUP:
                   break;
               case FINALIZE:
                   break;
               case START:
                   break;
               case RELOAD:
                   break;
           }
       }
   
       @Override
       public void clientEvent(ModEvent event) {
           switch (event) {
               case CONSTRUCT:
                   //Register keys as well as the rendering of blocks, items, and so on here
                   break;
               case INITIALIZE:
                   break;
               case SETUP:
                   break;
               case FINALIZE:
                   break;
               case START:
                   break;
               case RELOAD:
                   break;
           }
       }
   
       @Override
       public void serverEvent(ModEvent event) {
           switch (event) {
               case CONSTRUCT:
                   break;
               case INITIALIZE:
                   break;
               case SETUP:
                   break;
               case FINALIZE:
                   break;
               case START:
                   break;
               case RELOAD:
                   break;
           }
       }
   }
   ```
6. The UMC.md file was generated. I recommend to execute the commands mentioned there for a clean setup of the project.
7. Test if everything worked by starting the game e.g. with ``./gradlew runClient`` (for 1.12.2).

If everything has worked, you can now start to program your mod according to your creativity!