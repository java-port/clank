#!/bin/bash 

if [ -z "${SPUTNIK}" ]; then
  echo "Error: SPUTNIK evironment variable must point to sputnik repository"
  exit 2
fi

#used in runtest.conf
JAVA_ARGS="-Xmx2G -da -d64 -Dtest.stop.start=false -Dtest.suspend.last.iteration=false -Dtest.count=1 -XX:+UnlockCommercialFeatures -XX:+FlightRecorder"

. ${SPUTNIK}/modules/org.clang.tools.services/test/unit/runtest.conf

#. ${SPUTNIK}/contrib/JConvert/baseconv

#clank.db=${LLVM_SRC}/nbproject/private/db.out
#clank.dump.db - dump DB into ${clank.db}.dump
#clank.pp - preprocess (true by default)
#clank.print.tokens - false
#clank.keep.comments - false
#clank.print.diagnostics - false
#clank.print.progress - false
#clank.interrupt.counter - undefined
#-J-Dtest.E -J-Dorg.clank.statistics=true -J-Dtest.print.stat=true 


echo "Compile Test" >&2 
mkdir -p ${SPUTNIK}/modules/org.clang.tools.services/build/test/unit/classes
$JDK_HOME/bin/javac -d ${SPUTNIK}/modules/org.clang.tools.services/build/test/unit/classes \
-sourcepath ${SPUTNIK}/modules/org.clang.tools.services/test/unit/src \
-classpath ${TEST_CLASSPATH} -g \
${SPUTNIK}/modules/org.clang.tools.services/test/unit/src/org/clang/tools/services/MeasurePreprocCompilationDB.java

echo "Run Test for TEST_DB=$TEST_DB" >&2
$RUN_COLLECT $JDK_HOME/bin/java $JAVA_ARGS $RUN_DEBUG $RUN_PROFILE $RUN_JMC \
-Dnbjunit.workdir=${SPUTNIK}/modules/org.clang.tools.services/build/test/unit/work \
-classpath ${TEST_CLASSPATH} org.clang.tools.services.MeasurePreprocCompilationDB 

