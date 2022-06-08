
# RawBroadcast
Rich broadcasting through your Minecraft server console (useful to announce when someone buys a rank in a RCON-based shop) 

## /rawbc raw
Typing `/rawbc raw &e&lHey there! &r&6RawBroadcast works!` in your console will result in this message:
```
[10:15:30 INFO]: Hey there! RawBroadcast works!
[10:15:30 INFO]: Success!
```
where color codes were formatted and message was shown to the whole server.

`Success!` is only visible to the sender.

## config.yml & /rawbc snippet
Snippets are used to define strings that need to be broadcast often. Placeholders like `{0}` will be replaced by the arguments given.

You can define an unlimited amount of your own snippets, but as an example we'll use a default one which comes pre-defined in `config.yml`. You can remove it, the plugin will function properly.

Typing `/rawbc snippet TestSnippet 1st,2nd,3rd,4th` in your console will result in this message:
```
[10:20:30 INFO]: This is a test snippet! 1st and 2nd are first two arguments! 4th is a fourth arg;
                 and also 3rd is in fact an argument, but third.
[10:20:30 INFO]: Success!
```
where `TestSnippet` is a snippet that was pre-defined in config.yml:
```yaml
# config.yml
TestSnippet: '&6This is a test snippet! {0} and {1} are first two arguments! {3} is a fourth arg; 
              and also {2} is in fact an argument, but third.'
```

Placeholders were replaced in order in which numbers are increasing.

Values in command are separated by comma only. Leaving a space in both places will result in double-space.

## DiscordSRV
`DiscordSRVPrefix: ""` is to assign a prefix to broadcast your messages to Discord.

You can use it to mark announcements with an emoji or prefix.
```
## 10:15 AM [BOT] Minecraft Chat: 🔔 Hey there! RawBroadcast works!
```

(`DiscordSRVPrefix: ":bell: "`)
