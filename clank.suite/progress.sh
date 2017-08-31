#!/bin/bash

SPUTNIK=${SPUTNIK-..}

DECLS_SH=$1/declarations.sh
DONE_SH=$1/done.sh

UNDONE=`cat ${DECLS_SH} | grep -v '^$' | wc -l`
DONE=`cat ${DONE_SH} | grep -v '^$' | wc -l`

#for cls in `cat ${DECLS} | awk '{print $6}'`
#do
#  cls=${cls/'${SPUTNIK}'/${SPUTNIK}}
#  if [ -f "$cls" ]
#  then
#    EXIST=`expr ${EXIST} + 1`
#  fi
#done

echo `expr ${DONE} + ${UNDONE}`
echo ${DONE}
