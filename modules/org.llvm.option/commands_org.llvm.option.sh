# Used directories
mkdir -p ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option
mkdir -p ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option/impl

# Global and static Enums
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Option.cpp "-nm=_ZN4llvm3opt10DriverFlagE;" > ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option/DriverFlag.java

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/Arg.cpp "-nm=_ZN4llvm3opt3ArgE;" > ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option/Arg.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp "-nm=_ZN4llvm3opt7ArgListE;" > ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option/ArgList.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp "-nm=_ZN4llvm3opt14DerivedArgListE;" > ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option/DerivedArgList.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp "-nm=_ZN4llvm3opt12InputArgListE;" > ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option/InputArgList.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp "-nm=_ZN4llvm3opt12OptSpecifierE;" > ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option/OptSpecifier.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp "-nm=_ZN4llvm3opt8OptTableE;" > ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option/OptTable.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp ${LLVM_SRC}/llvm/lib/Option/Option.cpp "-nm=_ZN4llvm3opt6OptionE;" > ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option/Option.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp "-nm=_ZN4llvm3opt12arg_iteratorE;" > ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option/arg_iterator.java

# Static functions/variables
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp "-nm=_ZL11matchOptionPKN4llvm3opt8OptTable4InfoENS_9StringRefEb;_ZL17getOptionHelpNameB5cxx11RKN4llvm3opt8OptTableENS0_12OptSpecifierE;_ZL18getOptionHelpGroupRKN4llvm3opt8OptTableENS0_12OptSpecifierE;_ZL19PrintHelpOptionListRN4llvm11raw_ostreamENS_9StringRefERSt6vectorISt4pairINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEPKcESaISD_EE;_ZL7isInputRKN4llvm9StringSetINS_15MallocAllocatorEEENS_9StringRefE;" -static-type=OptTableStatics -package=org.llvm.option.impl > ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option/impl/OptTableStatics.java

# Static functions/variables for namespaces as packages
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp "-nm=_ZN4llvm3optL16StrCmpOptionNameEPKcS2_;_ZN4llvm3optL26StrCmpOptionNameIgnoreCaseEPKcS2_;_ZN4llvm3optltERKNS0_8OptTable4InfoEPKc;_ZN4llvm3optltERKNS0_8OptTable4InfoES4_;" -static-type=OptStatics -package=org.llvm.option.impl > ${SPUTNIK}/modules/org.llvm.option/src/org/llvm/option/impl/OptStatics.java

