#!/bin/bash

function string_to_int () {
    LANG=C
    d=${1##*.}
    if [[ ${#1} -eq ${#d} ]]; then
        d=0
    fi
    e=${1%.*}
    e=${e//,/}
    printf %.0f "$e.$d" 2>/dev/null
}


cd ./forge/mcp/
python ./runtime/recompile.py "$@"
python ./runtime/reobfuscate.py "$@"

mv ~/.minecraft ~/std.minecraft
mv ~/forge.minecraft ~/.minecraft

for file in `grep -R @Init ./src`;
do
	file=$( echo $file | cut -d: -f 1 )


	if [ -f $file ]; then

		path_mod=$(echo $file | sed -e s#/[^/]*java#/#g)
		name_mod=$(echo $file | sed -e s#.*/##g)
		name_mod=$(echo $name_mod | sed -e s#.java##g)
		path_package=$( echo $path_mod | sed -e s#./src/minecraft/##g)

		if [ -f $path_mod"mcmod.info" ]; then

			for img in `find $path_mod -name "*.png"`;
			do
				img2=$(echo $img | sed -e s#src/minecraft#reobf/minecraft#g)
				path=$(echo $img2 | sed -e s#/[^/]*png#/#g)
				mkdir -pv $path
				cp -f $img $img2
			done;

			cd ./reobf/minecraft/

			 version_old=$( grep "\"version" "./../."$path_mod"mcmod.info" | sed s#.*\ \"## | sed s#\",## )
			revision_old=$( grep "\"version" "./../."$path_mod"mcmod.info" | sed s#.*\"[0-9].[0-9].## | sed s#\",## )
			revision_old=$(string_to_int $revision_old)
			    revision=$((revision_old+1))

			rep=$PWD
			cd "./../."$path_mod
			sed -r "s%(\ \ \"version\":\ \"[0-9]*\.[0-9]*\.).*\"%\1$revision\"%" mcmod.info -i
			sed -r "s%(version\ =\ \"[0-9]*\.[0-9]*\.).*\"%\1$revision\"%" $name_mod".java" -i
			cd $rep

			  version=$( grep "\"version" "./../."$path_mod"mcmod.info" | sed s#.*\ \"## | sed s#\",## )
			mcversion=$( grep "\"mcversion" "./../."$path_mod"mcmod.info" | sed s#.*\ \"## | sed s#\",## )

			name_jar_old=$name_mod"-universal-"$version_old"-MC"$mcversion".jar"
			name_jar=$name_mod"-universal-"$version"-MC"$mcversion".jar"

			rm $name_jar_old
			zip -r $name_jar $path_package
			zip -r $name_jar "./../."$path_mod
			zip -j $name_jar "./../."$path_mod"mcmod.info"

			cp $name_jar ~/.minecraft/mods

			if [ ! -d "./../../../../mods" ]; then
				mkdir ./../../../../mods
			fi
			rm ./../../../../mods/$name_jar_old
			cp $name_jar ./../../../../mods/

			cd ./../../
		fi
	fi
	
done;

java -jar ~/Bureau/minecraft.jar

rm -r ~/.minecraft/mods/*

mv ~/.minecraft ~/forge.minecraft
mv ~/std.minecraft ~/.minecraft