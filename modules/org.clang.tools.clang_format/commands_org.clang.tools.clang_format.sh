# Used directories
mkdir -p ${SPUTNIK}/modules/org.clang.tools.clang_format/src/org/clang/tools/clang_format
mkdir -p ${SPUTNIK}/modules/org.clang.tools.clang_format/src/org/clang/tools/clang_format/format

# Global functions/variables
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp "-nm=_Z4main;_ZL10DumpConfig;_ZL10LineRanges;_ZL12PrintVersionv;_ZL12SortIncludes;_ZL13FallbackStyle;_ZL14AssumeFileName;_ZL19ClangFormatCategory;_ZL4Help;_ZL5Style;_ZL6Cursor;_ZL7Inplace;_ZL7Lengths;_ZL7Offsets;_ZL9FileNames;_ZL9OutputXML;" -static-type=ClangFormatGlobals -package=org.clang.tools.clang_format > ${SPUTNIK}/modules/org.clang.tools.clang_format/src/org/clang/tools/clang_format/ClangFormatGlobals.java

# Global functions/variables for namespace as packages
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.tools.clang_format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/clang-format/ClangFormat.cpp "-nm=_ZN5clang6formatL10fillRangesEPN4llvm12MemoryBufferERSt6vectorINS_7tooling5RangeESaIS6_EE;_ZN5clang6formatL14parseLineRangeEN4llvm9StringRefERjS3_;_ZN5clang6formatL18createInMemoryFileEN4llvm9StringRefEPNS1_12MemoryBufferERNS_13SourceManagerERNS_11FileManagerEPNS_3vfs18InMemoryFileSystemE;_ZN5clang6formatL20outputReplacementXMLEN4llvm9StringRefE;_ZN5clang6formatL21outputReplacementsXMLERKSt3setINS_7tooling11ReplacementESt4lessIS3_ESaIS3_EE;_ZN5clang6formatL6formatEN4llvm9StringRefE;" -static-type=FormatGlobals -package=org.clang.tools.clang_format.format > ${SPUTNIK}/modules/org.clang.tools.clang_format/src/org/clang/tools/clang_format/format/FormatGlobals.java

