# TimeTeller
A sample IntelliJ IDEA plugin for telling the current time.

## Building and installation
In order to install the plugin, follow these steps:
1. Clone the repository:
`
    git clone https://github.com/Taikelenn/TimeTeller.git
`
2. Build the plugin by running:
`
    gradlew buildPlugin
`
3. You will find the built plugin as a .zip file under the `
    build/distributions/
`
directory.
4. In IntelliJ IDEA, go to File -> Settings -> Plugins. Select *Install Plugin from Disk* and navigate to the .zip file found in step 3.

## Usage
The plugin adds an entry in the Help menu called "Tell the Time". Press it to display a notification with the current system time. By default, this option is also bound to the keyboard shortcut CTRL+SHIFT+T.

## Gallery
Entry in Help menu:  
![Action entry in Help menu](https://i.imgur.com/ShCl658.png)

Example notification after pressing *Tell the Time*:  
![Example notification](https://i.imgur.com/f8yLPcA.png)
