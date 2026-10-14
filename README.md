# The Verity Tamil Voice (Minecraft Forge 1.21.11)

A small client-side horror-audio mod scaffold for Minecraft Java Edition 1.21.11 and Forge. When a configured entity comes within 12 blocks, the client plays a locally stored Tamil voice clip, with a 12-second cooldown.

> **Important:** The entity ID `theverity:verity` is a placeholder. Change it in `VerityVoiceClient.java` to the actual entity registry ID supplied by the The Verity mod you use. This project does not create The Verity entity or include copyrighted game audio.
>
> **Audio note:** GitHub cannot create your recorded voice for you. Add your own licensed/recorded `verity_voice.ogg` at `src/main/resources/assets/verityvoice/sounds/verity_voice.ogg`.

## Requirements

- Windows 10/11
- JDK 21
- Minecraft Java Edition 1.21.11
- Forge 61.2.0 (confirm the matching MDK/version on the official Forge downloads page)
- VS Code with Extension Pack for Java (optional, but helpful)

## Project setup

1. Download the Forge MDK for Minecraft 1.21.11 from https://files.minecraftforge.net/.
2. Use the MDK's Gradle wrapper files (`gradlew`, `gradlew.bat`, and `gradle/wrapper/`) in this project if they are not present.
3. Open the project folder in VS Code.
4. In PowerShell, run `java -version` and confirm Java 21.
5. Run `./gradlew.bat genIntellijRuns` only if you need IDE run configurations; for a basic build, run:
   ```powershell
   .\gradlew.bat build
   ```
6. Find the built JAR under `build/libs/`. Install it into the matching Forge profile's `mods` folder along with any required dependencies.

## Add your Tamil voice

1. Record a Tamil line such as “நீ இங்கே என்ன செய்கிறாய்?” using Audacity or another audio editor.
2. Export as **OGG Vorbis**, preferably mono.
3. Save it as `src/main/resources/assets/verityvoice/sounds/verity_voice.ogg`.
4. Test the sound event in a world:
   ```mcfunction
   /playsound verityvoice:verity_voice master @s
   ```

## Customize the target entity

Open `src/main/java/com/verityvoice/VerityVoiceClient.java` and change:

```java
ResourceLocation.fromNamespaceAndPath("theverity", "verity")
```

to the real namespace and entity ID. The target mod must be installed for proximity detection to work.

## What this starter does

- Registers the `verityvoice:verity_voice` sound event.
- Plays it on the local client when the configured entity is nearby.
- Uses a 12-block radius and a 12-second cooldown.
- Includes a Tamil subtitle string.

This is a starter scaffold, not a verified prebuilt JAR. Build and test against the exact Forge MDK before distributing it.
