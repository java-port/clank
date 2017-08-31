# Used directories
mkdir -p ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization
mkdir -p ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl
mkdir -p ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/llvm
mkdir -p ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/llvm/impl
mkdir -p ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/reader/impl

# Global and static Enums
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization14ASTRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ASTRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization8BlockIDsE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/BlockIDs.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization18CommentRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/CommentRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization18ControlRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ControlRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization19CtorInitializerTypeE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/CtorInitializerType.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization8DeclCodeE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/DeclCode.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization15DesignatorTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/DesignatorTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization25ExtensionBlockRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ExtensionBlockRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization20InputFileRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/InputFileRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp "-nm=_ZN5clang13serialization10ModuleKindE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleKind.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization18OptionsRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/OptionsRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization17PredefinedDeclIDsE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/PredefinedDeclIDs.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization17PredefinedTypeIDsE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/PredefinedTypeIDs.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization29PreprocessorDetailRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/PreprocessorDetailRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization23PreprocessorRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/PreprocessorRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization24SourceManagerRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/SourceManagerRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization14SpecialTypeIDsE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/SpecialTypeIDs.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization8StmtCodeE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/StmtCode.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization20SubmoduleRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/SubmoduleRecordTypes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization8TypeCodeE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/TypeCode.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization14DeclUpdateKindE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/DeclUpdateKind.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp "-nm=_ZN12_GLOBAL__N_116IndexRecordTypesE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/IndexRecordTypes.java

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN5clang26ASTDeserializationListenerE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ASTDeserializationListener.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp "-nm=_ZN5clang9ASTReaderE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ASTReader.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang17ASTReaderListenerE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ASTReaderListener.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp "-nm=_ZN5clang15ASTRecordWriterE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ASTRecordWriter.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp "-nm=_ZN5clang9ASTWriterE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ASTWriter.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang24ChainedASTReaderListenerE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ChainedASTReaderListener.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp "-nm=_ZN5clang18ContinuousRangeMapE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ContinuousRangeMap.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp "-nm=_ZN5clang13serialization10DeclOffsetE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/DeclOffset.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang13serialization18DeclarationNameKeyE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/DeclarationNameKey.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp "-nm=_ZN5clang17GlobalModuleIndexE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/GlobalModuleIndex.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang13serialization9InputFileE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/InputFile.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization23LocalRedeclarationsInfoE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/LocalRedeclarationsInfo.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp "-nm=_ZN5clang13serialization10ModuleFileE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleFile.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleFileExtension.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp "-nm=_ZN5clang19ModuleFileExtensionE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleFileExtension.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN5clang27ModuleFileExtensionMetadataE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleFileExtensionMetadata.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleFileExtension.cpp "-nm=_ZN5clang25ModuleFileExtensionReaderE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleFileExtensionReader.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleFileExtension.cpp "-nm=_ZN5clang25ModuleFileExtensionWriterE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleFileExtensionWriter.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp "-nm=_ZN5clang13serialization13ModuleManagerE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ModuleManager.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization18ObjCCategoriesInfoE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/ObjCCategoriesInfo.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GeneratePCH.cpp "-nm=_ZN5clang12PCHGeneratorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/PCHGenerator.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang12PCHValidatorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/PCHValidator.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization14PPEntityOffsetE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/PPEntityOffset.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang19SavedStreamPositionE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/SavedStreamPosition.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN5clang13serialization7TypeIdxE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/TypeIdx.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang13TypeLocReaderE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/TypeLocReader.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serialization26UnsafeQualTypeDenseMapInfoE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/UnsafeQualTypeDenseMapInfo.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN12_GLOBAL__N_129ASTDeclContextNameLookupTraitE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTDeclContextNameLookupTrait.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp "-nm=_ZN5clang13ASTDeclReaderE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTDeclReader.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp "-nm=_ZN5clang13ASTDeclWriterE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTDeclWriter.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang21ASTIdentifierIteratorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTIdentifierIterator.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN12_GLOBAL__N_123ASTIdentifierTableTraitE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTIdentifierTableTrait.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN12_GLOBAL__N_118ASTMethodPoolTraitE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTMethodPoolTrait.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp "-nm=_ZN5clang13ASTStmtReaderE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTStmtReader.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp "-nm=_ZN5clang13ASTStmtWriterE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTStmtWriter.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN5clang13ASTTypeWriterE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTTypeWriter.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN12_GLOBAL__N_125ChainedIdentifierIteratorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ChainedIdentifierIterator.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN12_GLOBAL__N_110DeclIDCompE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/DeclIDComp.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp "-nm=_ZN12_GLOBAL__N_129GlobalIndexIdentifierIteratorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/GlobalIndexIdentifierIterator.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp "-nm=_ZN12_GLOBAL__N_124GlobalModuleIndexBuilderE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/GlobalModuleIndexBuilder.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN12_GLOBAL__N_119HeaderFileInfoTraitE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/HeaderFileInfoTrait.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN12_GLOBAL__N_121HeaderFileInfoVisitorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/HeaderFileInfoVisitor.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp "-nm=_ZN12_GLOBAL__N_126IdentifierIndexReaderTraitE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/IdentifierIndexReaderTrait.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp "-nm=_ZN12_GLOBAL__N_126IdentifierIndexWriterTraitE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/IdentifierIndexWriterTrait.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN12_GLOBAL__N_123IdentifierLookupVisitorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/IdentifierLookupVisitor.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN12_GLOBAL__N_114InputFileEntryE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/InputFileEntry.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp "-nm=_ZN12_GLOBAL__N_135InterestingASTIdentifierLookupTraitE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/InterestingASTIdentifierLookupTrait.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp "-nm=_ZN12_GLOBAL__N_120MergedRedeclIteratorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/MergedRedeclIterator.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp "-nm=_ZN12_GLOBAL__N_114ModuleFileInfoE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ModuleFileInfo.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp "-nm=_ZN5clang13serialization20MultiOnDiskHashTableE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/MultiOnDiskHashTable.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp "-nm=_ZN5clang13serialization29MultiOnDiskHashTableGeneratorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/MultiOnDiskHashTableGenerator.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderStmt.cpp "-nm=_ZN5clang15OMPClauseReaderE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/OMPClauseReader.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterStmt.cpp "-nm=_ZN5clang15OMPClauseWriterE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/OMPClauseWriter.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp "-nm=_ZN12_GLOBAL__N_121ObjCCategoriesVisitorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ObjCCategoriesVisitor.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN12_GLOBAL__N_112PPEntityCompE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/PPEntityComp.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang13serialization21ReadMethodPoolVisitorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ReadMethodPoolVisitor.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN12_GLOBAL__N_118SimplePCHValidatorE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/SimplePCHValidator.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN12_GLOBAL__N_113TypeLocWriterE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/TypeLocWriter.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN4llvm12DenseMapInfoIN5clang13serialization18DeclarationNameKeyEEE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/llvm/DenseMapInfoDeclarationNameKey.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp "-nm=_ZN4llvm14DOTGraphTraitsIN5clang13serialization13ModuleManagerEEE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/llvm/impl/DOTGraphTraitsModuleManager.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp "-nm=_ZN4llvm11GraphTraitsIN5clang13serialization13ModuleManagerEEE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/llvm/impl/GraphTraitsModuleManager.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp "-nm=_ZN5clang13serialization6reader29ASTDeclContextNameLookupTraitE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/reader/impl/ASTDeclContextNameLookupTrait.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang13serialization6reader24ASTIdentifierLookupTraitE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/reader/impl/ASTIdentifierLookupTrait.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang13serialization6reader28ASTIdentifierLookupTraitBaseE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/reader/impl/ASTIdentifierLookupTraitBase.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang13serialization6reader22ASTSelectorLookupTraitE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/reader/impl/ASTSelectorLookupTrait.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp "-nm=_ZN5clang13serialization6reader22DeclContextLookupTableE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/reader/impl/DeclContextLookupTable.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN5clang13serialization6reader19HeaderFileInfoTraitE;" > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/reader/impl/HeaderFileInfoTrait.java

# Static functions/variables
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp "-nm=Tpl__Z14merged_redeclsPT_;Tpl__ZL11assert_castT_;Tpl__ZL11assert_castz;Tpl__ZL18forAllLaterRedeclsPT_T0_;Tpl__ZL30inheritDefaultTemplateArgumentRN5clang10ASTContextEPT_PNS_4DeclE;_ZL12getNamespacePKN5clang19NestedNameSpecifierE;_ZL12isSameEntityPN5clang9NamedDeclES1_;_ZL13newDeclIDListRN5clang10ASTContextEPjRN4llvm15SmallVectorImplIjEE;_ZL15isSameQualifierPKN5clang19NestedNameSpecifierES2_;_ZL17getDeclForMergingPN5clang9NamedDeclEb;_ZL22isConsumerInterestedInPN5clang4DeclEb;_ZL23isSameTemplateParameterPKN5clang9NamedDeclES2_;_ZL27isSameTemplateParameterListPKN5clang21TemplateParameterListES2_;_ZL31inheritDefaultTemplateArgumentsRN5clang10ASTContextEPNS_12TemplateDeclES3_;" -static-type=ASTReaderDeclStatics -package=org.clang.serialization.impl > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTReaderDeclStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=Tpl__ZL15dumpModuleIDMapN4llvm9StringRefERKN5clang18ContinuousRangeMapIT_PT0_XT1_EEE;Tpl__ZL44completeRedeclChainForTemplateSpecializationPN5clang4DeclE;_ZL16addMethodsToPoolRN5clang4SemaEN4llvm8ArrayRefIPNS_14ObjCMethodDeclEEERNS_14ObjCMethodListE;_ZL17SkipCursorToBlockRN4llvm15BitstreamCursorEj;_ZL17getPredefinedDeclRN5clang10ASTContextENS_13serialization17PredefinedDeclIDsE;_ZL17isDiagnosedResultN5clang9ASTReader13ASTReadResultEj;_ZL18checkTargetOptionsRKN5clang13TargetOptionsES2_PNS_17DiagnosticsEngineEb;_ZL20checkLanguageOptionsRKN5clang11LangOptionsES2_PNS_17DiagnosticsEngineEb;_ZL20readASTFileSignatureRN4llvm15BitstreamReaderE;_ZL21markIdentifierFromASTRN5clang9ASTReaderERNS_14IdentifierInfoE;_ZL21updateModuleTimestampRN5clang13serialization10ModuleFileE;_ZL22startsWithASTFileMagicRN4llvm15BitstreamCursorE;_ZL23checkDiagnosticMappingsRN5clang17DiagnosticsEngineES1_bb;_ZL23collectMacroDefinitionsRKN5clang19PreprocessorOptionsERN4llvm9StringMapISt4pairINS3_9StringRefEbENS3_15MallocAllocatorEEEPNS3_15SmallVectorImplIS6_EE;_ZL23isInterestingIdentifierRN5clang9ASTReaderERNS_14IdentifierInfoEb;_ZL23moduleKindForDiagnosticN5clang13serialization10ModuleKindE;_ZL24checkHeaderSearchOptionsRKN5clang19HeaderSearchOptionsEN4llvm9StringRefES4_PNS_17DiagnosticsEngineERKNS_11LangOptionsE;_ZL24checkPreprocessorOptionsRKN5clang19PreprocessorOptionsES2_PNS_17DiagnosticsEngineERNS_11FileManagerERNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEERKNS_11LangOptionsE;_ZL26PassObjCImplDeclToConsumerPN5clang12ObjCImplDeclEPNS_11ASTConsumerE;_ZL27isExtHandlingFromDiagsErrorRN5clang17DiagnosticsEngineE;_ZL28checkDiagnosticGroupMappingsRN5clang17DiagnosticsEngineES1_b;_ZL28moveMethodToBackOfGlobalListRN5clang4SemaEPNS_14ObjCMethodDeclE;_ZL32parseModuleFileExtensionMetadataRKN4llvm15SmallVectorImplIyEENS_9StringRefERN5clang27ModuleFileExtensionMetadataE;_ZL32resolveFileRelativeToOriginalDirRKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEES6_S6_;_ZL7readBitRj;" -static-type=ASTReaderStatics -package=org.clang.serialization.impl > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTReaderStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp "-nm=_ZL14isRequiredDeclPKN5clang4DeclERNS_10ASTContextEb;" -static-type=ASTWriterDeclStatics -package=org.clang.serialization.impl > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTWriterDeclStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=Tpl__ZL18AddLazyVectorDeclsRN5clang9ASTWriterERT_RN4llvm11SmallVectorIyLj64EEE;Tpl__ZL5bytesRKN4llvm15SmallVectorImplIT_EE;Tpl__ZL5bytesRKSt6vectorIT_T0_E;_ZL11EmitBlockIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE;_ZL12EmitRecordIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE;_ZL12getSignaturev;_ZL13AddStmtsExprsRN4llvm15BitstreamWriterERNS_15SmallVectorImplIyEE;_ZL16addExceptionSpecPKN5clang17FunctionProtoTypeERNS_15ASTRecordWriterE;_ZL17shouldIgnoreMacroPN5clang14MacroDirectiveEbRKNS_12PreprocessorE;_ZL18cleanPathForOutputRN5clang11FileManagerERN4llvm15SmallVectorImplIcEE;_ZL18getNumberOfModulesPN5clang6ModuleE;_ZL20CreateSLocFileAbbrevRN4llvm15BitstreamWriterE;_ZL21EmitCXXBaseSpecifiersRN5clang9ASTWriterEN4llvm8ArrayRefINS_16CXXBaseSpecifierEEE;_ZL21getDeclForLocalLookupRKN5clang11LangOptionsEPNS_9NamedDeclE;_ZL21isImportedDeclContextPN5clang9ASTReaderEPKNS_4DeclE;_ZL22CreateSLocBufferAbbrevRN4llvm15BitstreamWriterE;_ZL23EmitCXXCtorInitializersRN5clang9ASTWriterEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE;_ZL25CreateSLocExpansionAbbrevRN4llvm15BitstreamWriterE;_ZL26CreateSLocBufferBlobAbbrevRN4llvm15BitstreamWriterEb;_ZL31adjustFilenameForRelocatableASTPKcN4llvm9StringRefE;" -static-type=ASTWriterStatics -package=org.clang.serialization.impl > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ASTWriterStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/GlobalModuleIndex.cpp "-nm=_GlobalModuleIndex_cpp_Unnamed_enum;_ZL11emitBlockIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE;_ZL12emitRecordIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE;_ZL13IndexFileName;_ZL14CurrentVersion;" -static-type=GlobalModuleIndexStatics -package=org.clang.serialization.impl > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/GlobalModuleIndexStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/Module.cpp "-nm=Tpl__ZL14dumpLocalRemapN4llvm9StringRefERKN5clang18ContinuousRangeMapIT_T0_XT1_EEE;" -static-type=ModuleStatics -package=org.clang.serialization.impl > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/ModuleStatics.java

# Global functions/variables for namespace as packages
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=_ZN5clang13serializationL12DECL_UPDATESE;_ZN5clang13serializationL13VERSION_MAJORE;_ZN5clang13serializationL13VERSION_MINORE;_ZN5clang13serializationL17NumSpecialTypeIDsE;_ZN5clang13serializationL19NUM_PREDEF_DECL_IDSE;_ZN5clang13serializationL19NUM_PREDEF_TYPE_IDSE;_ZN5clang13serializationL20LOCAL_REDECLARATIONSE;_ZN5clang13serializationL20NUM_PREDEF_IDENT_IDSE;_ZN5clang13serializationL20NUM_PREDEF_MACRO_IDSE;_ZN5clang13serializationL23NUM_PREDEF_SELECTOR_IDSE;_ZN5clang13serializationL24NUM_PREDEF_PP_ENTITY_IDSE;_ZN5clang13serializationL24NUM_PREDEF_SUBMODULE_IDSE;" -static-type=SerializationGlobals -package=org.clang.serialization > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/SerializationGlobals.java

# Static functions/variables for namespaces as packages
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp "-nm=Tpl__ZN5clang13serialization10MakeTypeIDERNS_10ASTContextENS_8QualTypeET_;Tpl__ZN5clang13serialization26numberAnonymousDeclsWithinEPKNS_11DeclContextET_;_ZN5clang13serialization11ComputeHashENS_8SelectorE;_ZN5clang13serialization18TypeIdxFromBuiltinEPKNS_11BuiltinTypeE;_ZN5clang13serialization22isRedeclarableDeclKindEj;_ZN5clang13serialization24getDefinitiveDeclContextEPKNS_11DeclContextE;_ZN5clang13serialization31needsAnonymousDeclarationNumberEPKNS_9NamedDeclE;" -static-type=SerializationStatics -package=org.clang.serialization.impl > ${SPUTNIK}/modules/org.clang.serialization/src/org/clang/serialization/impl/SerializationStatics.java

