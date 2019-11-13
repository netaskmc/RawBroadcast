
# RawBroadcast
Rich messaging through your Minecraft server console (extra useful for RCON-based online in-game goods shop) 
## /rawbc raw
Typing `/rawbc raw &e&lHey there! &r&6RawBroadcast works!` in your console will result this message:
```
[10:15:30 INFO]: Hey there! RawBroadcast works!
[10:15:30 INFO]: Success!
```
where color codes were formatted and message was shown to the whole server;  `Success!` is only visible to you (to sender).
## config.yml & /rawbc snippet
Typing `/rawbc snippet TestSnippet 1st element!,2nd e, *third element*,4th one...` in your console will result this message:
```
[10:20:30 INFO]: This is a test snippet! 1st element! and 2nd e are first two arguments! 4th one... is a fourth arg; and also *third element* is in fact an argument, but third.
[10:20:30 INFO]: Success!
```
where `TestSnippet` is a snippet that was defined in config.yml:
```
TestSnippet: '&6This is a test snippet! {0} and {1} are first two arguments! {3} is a fourth arg; and also {2} is in fact an argument, but third.'
```

Placeholders were replaced in order in which numbers are increasing.
You can also define your own snippets;
### Values in command are separated by comma only. Leaving a space in both places will result this sucky double-space

`Success!` is only visible to you (to sender).

## DiscordSRV
`DiscordSRVPrefix: ""` is to assign a prefix to broadcast your messages to Discord.
You can use it to mark announcements with an emoji or prefix.
```
## 10:15 AM [BOT] Minecraft Chat: 🔔 Hey there! RawBroadcast works!
```

(`DiscordSRVPrefix: ":bell: "`)
