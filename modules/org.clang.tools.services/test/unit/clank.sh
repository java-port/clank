#!/bin/bash

if [ -z "${SPUTNIK}" ]; then
  echo "Error: SPUTNIK evironment variable must point to sputnik repository"
  exit 2
fi

#used in runtest.conf
#by default use clank.as.clang i.e. to emit correct PTH format usable for Clang++
JAVA_ARGS="-Dclank.as.clang=true -Xmx4G -da -d64 -Dtest.stop.start=false -Dtest.suspend.last.iteration=false -Dtest.count=1 -XX:+UnlockCommercialFeatures -XX:+FlightRecorder"

. ${SPUTNIK}/modules/org.clang.tools.services/test/unit/runtest.conf

if [ -z "$CLANK_QUIET" ]; then
  eval $JDK_HOME/bin/java $RUN_PROFILE $JAVA_ARGS -version >&2
fi

if [ -z "$CLANK_NO_COMPILE" ]; then
  echo "export CLANK_NO_COMPILE=true to suppress recompilation" >&2
  echo "Recompile Clank Driver..." >&2 
  mkdir -p ${SPUTNIK}/modules/org.clang.tools.services/build/test/unit/classes
  rm -f ${SPUTNIK}/modules/org.clang.tools.services/build/test/unit/classes/org/clang/tools/services/*.class
  $JDK_HOME/bin/javac  -proc:none -d ${SPUTNIK}/modules/org.clang.tools.services/build/test/unit/classes \
  -sourcepath ${SPUTNIK}/modules/org.clang.tools.services/test/unit/src \
  -classpath ${TEST_CLASSPATH} -g \
  ${SPUTNIK}/modules/org.clang.tools.services/test/unit/src/org/clang/tools/services/MeasureClangInvocation.java
fi

if [ -z "$CLANK_QUIET" ]; then
  echo "Run Clank Compiler as:" >&2
  echo "${LLVM_SRC}/build/bin/clang $COMPILER_ARGS" >&2
fi

$RUN_COLLECT $JDK_HOME/bin/java $JAVA_ARGS $RUN_DEBUG $RUN_PROFILE $RUN_JMC \
-Dnbjunit.workdir=${SPUTNIK}/modules/org.clang.tools.services/build/test/unit/work \
-classpath ${TEST_CLASSPATH} org.clang.tools.services.MeasureClangInvocation $COMPILER_ARGS

