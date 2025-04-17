# AntiCheat Plugin for Minecraft

## Overview

The **AntiCheat** plugin is designed to enhance the security of your Minecraft server by detecting and preventing various cheats and hacks. This plugin includes checks for common cheats such as Speed, Fly, Kill Aura, NoFall, FastPlace, FastBreak, and X-Ray. It alerts server administrators when suspicious activity is detected, helping to maintain a fair and enjoyable gaming environment.

## Features

- **Speed Detection**: Monitors player movement speed and flags excessive speed.
- **Fly Detection**: Detects unauthorized flying by players.
- **Kill Aura Detection**: Identifies players hitting multiple targets in a short time frame.
- **NoFall Detection**: Flags players who take no fall damage.
- **FastPlace Detection**: Monitors block placement speed and flags excessive placements.
- **FastBreak Detection**: Monitors block breaking speed and flags excessive breaks.
- **Alerts**: Sends alerts to online OP players when suspicious activity is detected.

## Installation

1. **Download the Plugin**: Obtain the latest version of the AntiCheat plugin `.jar` file from the releases section.

2. **Place the Plugin**: Move the downloaded `.jar` file into the `plugins` folder of your Minecraft server.

3. **Restart the Server**: Restart your Minecraft server to enable the plugin.

4. **Configuration**: (Optional) Configure the plugin settings in the `plugins/AntiCheat/config.yml` file to customize detection thresholds and alert settings.

## Usage

- The plugin automatically monitors player actions and detects cheats based on predefined checks.
- When a cheat is detected, the plugin will flag the player and send an alert message to all OP players online.
- You can customize the detection thresholds and alert messages in the configuration file.

## Configuration

The configuration file is located at `plugins/AntiCheat/config.yml`. You can modify the following settings:

```yaml
# AntiCheat Configuration
speed_limit: 0.5 # Maximum allowed speed
fly_detection: true # Enable or disable fly detection
kill_aura_detection: true # Enable or disable kill aura detection
nofall_detection: true # Enable or disable no fall detection
fastplace_detection: true # Enable or disable fast place detection
fastbreak_detection: true # Enable or disable fast break detection
xray_detection: false # Enable or disable x-ray detection
alert_message: "ALERT: {message} - Player: {player}" # Customize alert message
