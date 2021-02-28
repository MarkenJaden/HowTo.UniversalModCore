# HowTo.UniversalModCore

In this repo I want to give you some basics about Universal Mod Core (UMC).

### Please note

* This is not a Java tutorial! To work with Universal Mod Core you should have knowledge in Java programming.
* UMC does not yet offer by far all the features that Forge offers. For example, if you just want to make a small mod that adds some standard blocks and items, I highly recommend you to deal with Forge first, as UMC doesn't offer a proper integration of "normal" blocks yet.

To give a rough overview of the possibilities of UMC, the developer cam72cam has also developed its own mod based on it. This is "Immersive Railroading", which adds a complex railroad system with flexibly placeable rails not limited to the block grid, complex physics and easily expandable with resource packs to add new trains.

So you can program really complex, but well optimized mods that cover many versions, but you have to be prepared for various compromises.

## How to get started

*Take a look at the branches in this repo. Depending on how you want to start, I have provided you with different stands.*

Here you get a rough basic structure with which one can start well.

1. Load the repo into your favorite IDE
2. ![](https://i.imgur.com/i5slj7U.png)
3. Execute ``gradle umc -D umc.loader=1.12.2-forge`` (I always recommend programming in 1.12.2 by default because this Gradle integration of UMC works the most stable.)
4. Load gradle changes

I am working on it but it was 2 o'clock in the morning, I needed a break
