# Used directories
mkdir -p ${SPUTNIK}/modules/org.clang.codegen/src/org/clang/codegen

# Global and static Enums

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp "-nm=_ZN5clang13CodeGenActionE;" > ${SPUTNIK}/modules/org.clang.codegen/src/org/clang/codegen/CodeGenAction.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp "-nm=_ZN5clang28ObjectFilePCHContainerReaderE;" > ${SPUTNIK}/modules/org.clang.codegen/src/org/clang/codegen/ObjectFilePCHContainerReader.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp "-nm=_ZN5clang28ObjectFilePCHContainerWriterE;" > ${SPUTNIK}/modules/org.clang.codegen/src/org/clang/codegen/ObjectFilePCHContainerWriter.java

# Global and static namespaces

# Static functions/variables

# Global functions/variables

# Global functions/variables for namespace as packages

# Static functions/variables for namespaces as packages

