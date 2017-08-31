#!/bin/bash 

if [ -z "${SPUTNIK}" ]; then
  echo "Error: SPUTNIK evironment variable must point to sputnik repository"
  exit 2
fi

#used in runtest.conf
JAVA_ARGS="-Xmx8G -da -d64 -Dtest.stop.start=false -Dtest.suspend.last.iteration=false -Dtest.count=10 -XX:+UnlockCommercialFeatures -XX:+FlightRecorder"

. ${SPUTNIK}/modules/org.clang.tools.services/test/unit/runtest.conf

#-J-Dclank.slice.on.demand=true -J-Dclank.slices.shift=16 -J-Dclank.raw.sliced=false -J-Dclank.sliced=false -J-Dclank.bytebuffer=false 
#-J-Dtest.E -J-Dorg.clank.statistics=true -J-Dtest.print.stat=true 
#-J-Dclank.sm.local.size=67108864 -J-Dclank.identifiers.size=16777216 - on Level 11 allocate once
#-J-Dclank.page.size=65536 -J-Dclank.max.page.size=262144 -J-Dclang.reuse.charptr=false

eval $JDK_HOME/bin/java $JAVA_ARGS $RUN_PROFILE -version >&2

echo "Compile Test" >&2 
mkdir -p ${SPUTNIK}/modules/org.clang.tools.services/build/test/unit/classes
rm -f ${SPUTNIK}/modules/org.clang.tools.services/build/test/unit/classes/org/clang/tools/services/*.class
$JDK_HOME/bin/javac -d ${SPUTNIK}/modules/org.clang.tools.services/build/test/unit/classes \
-sourcepath ${SPUTNIK}/modules/org.clang.tools.services/test/unit/src \
-classpath ${TEST_CLASSPATH} -g \
${SPUTNIK}/modules/org.clang.tools.services/test/unit/src/org/clang/tools/services/MeasureDeepMacroExpansion.java

echo "Run Test" >&2
$RUN_COLLECT $JDK_HOME/bin/java $JAVA_ARGS $RUN_DEBUG $RUN_PROFILE $RUN_JMC \
-Dnbjunit.workdir=${SPUTNIK}/modules/org.clang.tools.services/build/test/unit/work \
-classpath ${TEST_CLASSPATH} org.clang.tools.services.MeasureDeepMacroExpansion

