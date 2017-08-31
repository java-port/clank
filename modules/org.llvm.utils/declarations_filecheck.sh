# Used directories
mkdir -p ${SPUTNIK}/modules/org.llvm.utils/src/org/llvm/utils/filecheck

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations, Enums
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-imports=${SPUTNIK}/modules/org.llvm.utils/JavaImports ${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp "-file-filter=${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#602;" > ${SPUTNIK}/modules/org.llvm.utils/src/org/llvm/utils/filecheck/CheckString.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-imports=${SPUTNIK}/modules/org.llvm.utils/JavaImports ${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp "-file-filter=${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#75;" > ${SPUTNIK}/modules/org.llvm.utils/src/org/llvm/utils/filecheck/Pattern.java

# Global and static namespaces except excluded: [clang::consumed, clang::serialization, clang::driver::tools, clang::analyze_format_string, clang::driver, clang::sema, clang::edit, clang::thread_safety, llvm, llvm::opt, clang::ento, clang, clang::comments, llvm::cl, clang::arcmt]
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-imports=${SPUTNIK}/modules/org.llvm.utils/JavaImports ${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp "-file-filter=${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#61;" -static-type=Check > ${SPUTNIK}/modules/org.llvm.utils/src/org/llvm/utils/filecheck/Check.java

# Static functions/variables
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-imports=${SPUTNIK}/modules/org.llvm.utils/JavaImports ${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp "-file-filter=${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#39;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#42;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#46;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#50;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#651;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#685;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#690;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#717;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#744;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#758;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#816;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#844;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#965;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#983;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#991;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#1192;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#1197;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#1216;${LLVM_SRC}/llvm/utils/FileCheck/FileCheck.cpp#1221;" -static-type=FileCheckStatics > ${SPUTNIK}/modules/org.llvm.utils/src/org/llvm/utils/filecheck/FileCheckStatics.java

# Global functions/variables

# Global functions/variables for [clang::consumed, clang::serialization, clang::driver::tools, clang::analyze_format_string, clang::driver, clang::sema, clang::edit, clang::thread_safety, llvm, llvm::opt, clang::ento, clang, clang::comments, llvm::cl, clang::arcmt]

# Static functions/variables for [clang::consumed, clang::serialization, clang::driver::tools, clang::analyze_format_string, clang::driver, clang::sema, clang::edit, clang::thread_safety, llvm, llvm::opt, clang::ento, clang, clang::comments, llvm::cl, clang::arcmt]

