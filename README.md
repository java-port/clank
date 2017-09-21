# clank (with K)
Clank is a Java-port of popular Clang frontend

https://www.youtube.com/watch?v=EpFJlARXO74

# TODO
Need to prepare build and run instructions

SPUTNIK env variable should point to clone of clank.
LLVM_SRC env variable should point to LLVM39 clone to run tests.
modules/clank.suite can be opened in NetBeans as an entry point for Clank.

There is a script $SPUTNIK/modules/org.clang.tools.services/test/unit/clank.sh which can take the same parameters as native clang binary (and some extra Java specific params i.e. to run in debug mode)
