# Tamil Verity Voice Chat (MVP)

## Agreed behavior
The first version responds when the player speaks. Automatic event-based commentary can be added later.

## Conversation loop
1. Player activates push-to-talk.
2. The client captures microphone audio locally.
3. Speech recognition transcribes Tamil speech.
4. The game sends the transcript and a small, non-sensitive gameplay context to a backend service.
5. The backend returns a Tamil response.
6. Text-to-speech plays the response in-game.

## Important implementation notes
- Do not put AI provider API keys in the Minecraft mod or public GitHub repository. Keep secrets on the backend.
- Provide a visible microphone state and a mute/stop control.
- Make speech recognition and text-to-speech providers configurable.
- Do not send microphone audio until the player explicitly activates voice input.
- Start with push-to-talk; add optional wake-word or automatic listening only after the basic flow works.

## Build order
1. Verify the Minecraft/Forge toolchain and get the mod loading.
2. Add a keybind for push-to-talk and a microphone permission/error state.
3. Connect speech-to-text.
4. Add a backend chat endpoint with the Tamil Verity character prompt.
5. Play the returned response using text-to-speech.
6. Add game-event context and horror progression after voice chat is stable.

## Example character progression
- Friendly: casual Tamil banter like a gaming friend.
- Uneasy: notices a quiet village or missing villagers.
- Horror: becomes threatening gradually, without abruptly changing every line.
