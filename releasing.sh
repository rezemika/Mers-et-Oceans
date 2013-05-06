#!/bin/bash

# suprimmer les anciens mod
rm -r ./solo/mods/*
rm -r ./serveur/mods/*

cd ./forge/mcp/

# recompile et reobfuscate
python ./runtime/recompile.py "$@"
python ./runtime/reobfuscate.py "$@"

cd ./../../

# release
python ./releasing.py "$1"

# changement de version de minecraft
mv ~/.minecraft ~/std.minecraft
cp -r ./solo/ ~/.minecraft
	
cd ./serveur/

java -Xmx1024M -Xms1024M -jar ./minecraftforge-universal-1.5.1-7.7.1.662.jar & java -jar ~/Bureau/minecraft.jar

cd ./../

# on rétablit la bonne version de minecraft
rm -r ~/.minecraft
mv ~/std.minecraft ~/.minecraft