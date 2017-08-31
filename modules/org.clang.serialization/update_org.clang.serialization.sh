# Used directories
mkdir -p ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization
mkdir -p ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/llvm

# Global and static Enums
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization14ASTRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ASTRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization8BlockIDsE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/BlockIDs.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization18ControlRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ControlRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization8DeclCodeE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/DeclCode.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization25ExtensionBlockRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ExtensionBlockRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization18OptionsRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/OptionsRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization17PredefinedDeclIDsE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/PredefinedDeclIDs.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization17PredefinedTypeIDsE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/PredefinedTypeIDs.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization23PreprocessorRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/PreprocessorRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization8StmtCodeE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/StmtCode.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization8TypeCodeE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/TypeCode.java

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/MultiplexConsumer.cpp "-nm=_ZN5clang26ASTDeserializationListenerE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ASTDeserializationListener.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang9ASTReaderE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ASTReader.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang17ASTReaderListenerE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ASTReaderListener.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang9ASTWriterE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ASTWriter.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang24ChainedASTReaderListenerE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ChainedASTReaderListener.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp "-nm=_ZN5clang18ContinuousRangeMapE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ContinuousRangeMap.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization18DeclarationNameKeyE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/DeclarationNameKey.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp "-nm=_ZN5clang17GlobalModuleIndexE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/GlobalModuleIndex.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization10ModuleFileE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleFile.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp "-nm=_ZN5clang19ModuleFileExtensionE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleFileExtension.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp "-nm=_ZN5clang27ModuleFileExtensionMetadataE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleFileExtensionMetadata.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp "-nm=_ZN5clang25ModuleFileExtensionReaderE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleFileExtensionReader.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp "-nm=_ZN5clang25ModuleFileExtensionWriterE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleFileExtensionWriter.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serialization13ModuleManagerE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleManager.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang12PCHGeneratorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/PCHGenerator.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang12PCHValidatorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/PCHValidator.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN4llvm12DenseMapInfoIN5clang13serialization18DeclarationNameKeyEEE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/llvm/DenseMapInfo.java

# Global and static namespaces

# Static functions/variables

# Global functions/variables

# Global functions/variables for namespace as packages
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang13serializationL13VERSION_MAJORE;_ZN5clang13serializationL13VERSION_MINORE;_ZN5clang13serializationL20NUM_PREDEF_IDENT_IDSE;_ZN5clang13serializationL20NUM_PREDEF_MACRO_IDSE;_ZN5clang13serializationL23NUM_PREDEF_SELECTOR_IDSE;_ZN5clang13serializationL24NUM_PREDEF_SUBMODULE_IDSE;_ZN5clang13serializationL24NUM_PREDEF_PP_ENTITY_IDSE;_ZN5clang13serializationL19NUM_PREDEF_TYPE_IDSE;_ZN5clang13serializationL17NumSpecialTypeIDsE;_ZN5clang13serializationL19NUM_PREDEF_DECL_IDSE;_ZN5clang13serializationL20LOCAL_REDECLARATIONSE;" -static-type=SerializationGlobals > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/SerializationGlobals.java

# Static functions/variables for namespaces as packages

# Unhandled removed symbols
#[Typedef,clang::serialization::reader::ASTDeclContextNameLookupTable,${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h:277,_ZN5clang13serialization6reader29ASTDeclContextNameLookupTableE]
#[Typedef,clang::serialization::KindDeclIDPair,${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h:65,_ZN5clang13serialization14KindDeclIDPairE]
#[CXXRecord,clang::serialization::DeclContextInfo,${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/Module.h:53,_ZN5clang13serialization15DeclContextInfoE]


