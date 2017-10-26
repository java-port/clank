#! /bin/bash
modules_list="modules_for_export";
url="https://github.com/java-port/clank"

while getopts s:d: option
do
 case "${option}"
 in
 s) SPUTNIK=${OPTARG};;
 d) DESTINATION=$OPTARG;;
 esac
done

function usage {
  echo $0 "-s <sputnik_root> -d <destination_root>"
}

if [ -z "$SPUTNIK" ]; then
  usage
  exit 1
fi

if [ -z "$DESTINATION" ]; then
  usage
  exit 1
fi

mkdir "$DESTINATION" 2>/dev/null

cd "${SPUTNIK}/clank.suite"

grep 'project.*=' nbproject/project.properties | awk -F= '{print $2}' > "${modules_list}.swp"
if ! cmp "${modules_list}.txt" "${modules_list}.swp" >/dev/null 2>&1; then
  >&2 echo "Added new module to clank.suite? Update ${modules_list}.txt"
  >&2 echo "with output of the command: " $'grep \'project.*=\' nbproject/project.properties | awk -F= \'{print $2}\''
  diff "${modules_list}.txt" "${modules_list}.swp"
  exit 2
fi

cd ..

while read path; do
  echo "clank.suite/${path}/*"
  hg st --modified --added --clean clank.suite/${path}/* --no-status | xargs -i cp --parents {} "$DESTINATION"
done < "clank.suite/${modules_list}.txt"

echo "clank.suite"
hg st --modified --added --clean clank.suite/* --no-status | xargs -i cp --parents {} "$DESTINATION"

rm "${modules_list}.swp" 2>/dev/null
