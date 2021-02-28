# HowTo.UniversalModCore

In this repo I want to give you some basics about [Universal Mod Core (UMC)](https://github.com/TeamOpenIndustry/UniversalModCore).

### Please note

* **This is not a Java tutorial!** To work with Universal Mod Core you should have knowledge in Java programming.
* **UMC does not yet offer by far all the features that [MinecraftForge](https://github.com/MinecraftForge/MinecraftForge) offers.** For example, if you just want to make a small mod that adds some standard blocks and items, I highly recommend you to deal with Forge first, as UMC doesn't offer a proper integration of "normal" blocks yet.

To give a rough overview of the possibilities of UMC, the main developer [cam72cam](https://github.com/cam72cam) has also developed its own mod based on it. This is "[Immersive Railroading](https://github.com/TeamOpenIndustry/ImmersiveRailroading)", which adds a complex railroad system with flexibly placeable rails not limited to the block grid, complex physics and easily expandable with resource packs to add new trains.

So you can program really complex, and well optimized mods that cover many versions, but you have to be prepared for various compromises.

## How to get started

*Take a look at the branches in this repo. Depending on how you want to start, I have provided you with different stands.*

Here you get a completely empty project with which you start from scratch to build your mod.

1. Load the repo into your favorite IDE
2. Open build.gradle and change the following lines to match your mod:
   
   ![](https://i.imgur.com/rPQ5LZX.png)
   
   * ``version`` is the version of the mod which you should upgrade with every public update
   * ``modPackage`` is the main package structure of the mod
   * ``modClass`` is the class in which the individual start events of Minecraft are processed when the mod is started
   * ``modName`` is the name of the mod :P
   * ``modId`` is the unique ID with which the mod is identified in Minecraft. This should consist exclusively of lowercase letters and not contain any special characters
3. Open settings.gradle and enter the mod name there
4. Execute ``./gradlew umc -D umc.loader=1.12.2-forge`` (I always recommend programming in 1.12.2 by default because this Gradle integration of UMC works the most stable. If you want a different version look at the different [branches](https://github.com/TeamOpenIndustry/UniversalModCore/branches/all) of UMC and replace ``1.12.2-forge`` with the name of the branch.)
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

## Automation

If you work with GitHub, this part might be interesting for you.

GitHub offers with [GitHub Actions](https://github.com/features/actions) the possibility to automate various tasks on certain events. This feature is offered for free and without limitation for OpenSource projects. Under [/.github/workflows](https://github.com/MarkenJaden/HowTo.UniversalModCore/tree/Empty-setup/.github/workflows) you can find two examples.

* [``main.yml``](https://github.com/MarkenJaden/HowTo.UniversalModCore/blob/Empty-setup/.github/workflows/main.yml) builds your project every time you do a push to GitHub and make a change in ``src/``. The results of the builds are then automatically uploaded to GitHub. You can then retrieve and download them under the "Actions" tab when you click on the executed action at the very bottom of "Artifacts". This makes it easier for you to build the mod for the different versions you want it to support.
* [``release.yml``](https://github.com/MarkenJaden/HowTo.UniversalModCore/blob/Empty-setup/.github/workflows/release.yml) you have to start manually. You can use this workflow as soon as you want to release your mod. This will automatically build it for all versions you put there and upload it back to GitHub.

Remember to adjust the paths and names in both workflows to your mod, otherwise it won't work!