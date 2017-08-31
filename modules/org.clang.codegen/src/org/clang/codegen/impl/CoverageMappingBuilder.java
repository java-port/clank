/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.profiledata.coverage.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.basic.llvm.DenseMapInfoFileID;


/// \brief Provides the common functionality for the different
/// coverage mapping region builders.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 77,
 FQN="(anonymous namespace)::CoverageMappingBuilder", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilderE")
//</editor-fold>
public class CoverageMappingBuilder implements Destructors.ClassWithDestructor {
/*public:*/
  public final CoverageMappingModuleGen /*&*/ CVM;
  public final SourceManager /*&*/ SM;
  public final /*const*/ LangOptions /*&*/ LangOpts;
/*private:*/
  /// \brief Map of clang's FileIDs to IDs used for coverage mapping.
  private SmallDenseMap<FileID, std.pairUIntType<SourceLocation>> FileIDMapping;
/*public:*/
  /// \brief The coverage mapping regions for this function
  public SmallVector<CounterMappingRegion> MappingRegions;
  /// \brief The source mapping regions for this function.
  public std.vector<SourceMappingRegion> SourceRegions;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::CoverageMappingBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 94,
   FQN="(anonymous namespace)::CoverageMappingBuilder::CoverageMappingBuilder", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilderC1ERN5clang7CodeGen24CoverageMappingModuleGenERNS1_13SourceManagerERKNS1_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilderC1ERN5clang7CodeGen24CoverageMappingModuleGenERNS1_13SourceManagerERKNS1_11LangOptionsE")
  //</editor-fold>
  public CoverageMappingBuilder(final CoverageMappingModuleGen /*&*/ CVM, final SourceManager /*&*/ SM, 
      final /*const*/ LangOptions /*&*/ LangOpts) {
    // : CVM(CVM), SM(SM), LangOpts(LangOpts), FileIDMapping(), MappingRegions(), SourceRegions() 
    //START JInit
    this./*&*/CVM=/*&*/CVM;
    this./*&*/SM=/*&*/SM;
    this./*&*/LangOpts=/*&*/LangOpts;
    this.FileIDMapping = new SmallDenseMap<FileID, std.pairUIntType<SourceLocation>>(DenseMapInfoFileID.$Info(), 8, new std.pairUIntType<SourceLocation>(0, new SourceLocation()));
    this.MappingRegions = new SmallVector<CounterMappingRegion>(32, new CounterMappingRegion());
    this.SourceRegions = new std.vector<SourceMappingRegion>(new SourceMappingRegion());
    //END JInit
  }

  
  /// \brief Return the precise end location for the given token.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::getPreciseTokenLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 99,
   FQN="(anonymous namespace)::CoverageMappingBuilder::getPreciseTokenLocEnd", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder21getPreciseTokenLocEndEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder21getPreciseTokenLocEndEN5clang14SourceLocationE")
  //</editor-fold>
  public SourceLocation getPreciseTokenLocEnd(SourceLocation Loc) {
    // We avoid getLocForEndOfToken here, because it doesn't do what we want for
    // macro locations, which we just treat as expanded files.
    /*uint*/int TokLen = Lexer.MeasureTokenLength(SM.getSpellingLoc(/*NO_COPY*/Loc), SM, LangOpts);
    return Loc.getLocWithOffset(TokLen);
  }

  
  /// \brief Return the start location of an included file or expanded macro.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::getStartOfFileOrMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 108,
   FQN="(anonymous namespace)::CoverageMappingBuilder::getStartOfFileOrMacro", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder21getStartOfFileOrMacroEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder21getStartOfFileOrMacroEN5clang14SourceLocationE")
  //</editor-fold>
  public SourceLocation getStartOfFileOrMacro(SourceLocation Loc) {
    if (Loc.isMacroID()) {
      return Loc.getLocWithOffset(-SM.getFileOffset(/*NO_COPY*/Loc));
    }
    return SM.getLocForStartOfFile(SM.getFileID(/*NO_COPY*/Loc));
  }

  
  /// \brief Return the end location of an included file or expanded macro.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::getEndOfFileOrMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 115,
   FQN="(anonymous namespace)::CoverageMappingBuilder::getEndOfFileOrMacro", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder19getEndOfFileOrMacroEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder19getEndOfFileOrMacroEN5clang14SourceLocationE")
  //</editor-fold>
  public SourceLocation getEndOfFileOrMacro(SourceLocation Loc) {
    if (Loc.isMacroID()) {
      return Loc.getLocWithOffset(SM.getFileIDSize(SM.getFileID(/*NO_COPY*/Loc))
             - SM.getFileOffset(/*NO_COPY*/Loc));
    }
    return SM.getLocForEndOfFile(SM.getFileID(/*NO_COPY*/Loc));
  }

  
  /// \brief Find out where the current file is included or macro is expanded.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::getIncludeOrExpansionLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 123,
   FQN="(anonymous namespace)::CoverageMappingBuilder::getIncludeOrExpansionLoc", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder24getIncludeOrExpansionLocEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder24getIncludeOrExpansionLocEN5clang14SourceLocationE")
  //</editor-fold>
  public SourceLocation getIncludeOrExpansionLoc(SourceLocation Loc) {
    return Loc.isMacroID() ? new SourceLocation(JD$Move.INSTANCE, SM.getImmediateExpansionRange(/*NO_COPY*/Loc).first) : SM.getIncludeLoc(SM.getFileID(/*NO_COPY*/Loc));
  }

  
  /// \brief Return true if \c Loc is a location in a built-in macro.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::isInBuiltin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 129,
   FQN="(anonymous namespace)::CoverageMappingBuilder::isInBuiltin", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder11isInBuiltinEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder11isInBuiltinEN5clang14SourceLocationE")
  //</editor-fold>
  public boolean isInBuiltin(SourceLocation Loc) {
    return strcmp(SM.getBufferName(SM.getSpellingLoc(/*NO_COPY*/Loc)), /*KEEP_STR*/"<built-in>") == 0;
  }

  
  /// \brief Check whether \c Loc is included or expanded from \c Parent.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::isNestedIn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 134,
   FQN="(anonymous namespace)::CoverageMappingBuilder::isNestedIn", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder10isNestedInEN5clang14SourceLocationENS1_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder10isNestedInEN5clang14SourceLocationENS1_6FileIDE")
  //</editor-fold>
  public boolean isNestedIn(SourceLocation Loc, FileID Parent) {
    do {
      Loc.$assignMove(getIncludeOrExpansionLoc(new SourceLocation(Loc)));
      if (Loc.isInvalid()) {
        return false;
      }
    } while (!SM.isInFileID(/*NO_COPY*/Loc, /*NO_COPY*/Parent));
    return true;
  }

  
  /// \brief Get the start of \c S ignoring macro arguments and builtin macros.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::getStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 144,
   FQN="(anonymous namespace)::CoverageMappingBuilder::getStart", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder8getStartEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder8getStartEPKN5clang4StmtE")
  //</editor-fold>
  public SourceLocation getStart(/*const*/ Stmt /*P*/ S) {
    SourceLocation Loc = S.getLocStart();
    while (SM.isMacroArgExpansion(/*NO_COPY*/Loc) || isInBuiltin(new SourceLocation(Loc))) {
      Loc.$assignMove(SM.getImmediateExpansionRange(/*NO_COPY*/Loc).first);
    }
    return Loc;
  }

  
  /// \brief Get the end of \c S ignoring macro arguments and builtin macros.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::getEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 152,
   FQN="(anonymous namespace)::CoverageMappingBuilder::getEnd", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder6getEndEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder6getEndEPKN5clang4StmtE")
  //</editor-fold>
  public SourceLocation getEnd(/*const*/ Stmt /*P*/ S) {
    SourceLocation Loc = S.getLocEnd();
    while (SM.isMacroArgExpansion(/*NO_COPY*/Loc) || isInBuiltin(new SourceLocation(Loc))) {
      Loc.$assignMove(SM.getImmediateExpansionRange(/*NO_COPY*/Loc).first);
    }
    return getPreciseTokenLocEnd(new SourceLocation(Loc));
  }

  
  /// \brief Find the set of files we have regions for and assign IDs
  ///
  /// Fills \c Mapping with the virtual file mapping needed to write out
  /// coverage and collects the necessary file information to emit source and
  /// expansion regions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::gatherFileIDs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 164,
   FQN="(anonymous namespace)::CoverageMappingBuilder::gatherFileIDs", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder13gatherFileIDsERN4llvm15SmallVectorImplIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder13gatherFileIDsERN4llvm15SmallVectorImplIjEE")
  //</editor-fold>
  public void gatherFileIDs(final SmallVectorImplUInt/*&*/ Mapping) {
    SmallSet<FileID> Visited = null;
    try {
      FileIDMapping.clear();
      
      Visited/*J*/= new SmallSet<FileID>(8, FileID.DEFAULT, FileID.COMPARATOR);
      SmallVector<std.pairTypeUInt<SourceLocation>> FileLocs/*J*/= new SmallVector<std.pairTypeUInt<SourceLocation>>(8, new std.pairTypeUInt<SourceLocation>(new SourceLocation(), 0));
      for (final /*const*/ SourceMappingRegion /*&*/ Region : SourceRegions) {
        SourceLocation Loc = Region.getStartLoc();
        FileID File = SM.getFileID(/*NO_COPY*/Loc);
        if (!Visited.insert(File)/*.second*/) {
          continue;
        }
        
        // Do not map FileID's associated with system headers.
        if (SM.isInSystemHeader(SM.getSpellingLoc(/*NO_COPY*/Loc))) {
          continue;
        }
        
        /*uint*/int Depth = 0;
        for (SourceLocation Parent = getIncludeOrExpansionLoc(new SourceLocation(Loc));
             Parent.isValid(); Parent.$assignMove(getIncludeOrExpansionLoc(new SourceLocation(Parent))))  {
          ++Depth;
        }
        FileLocs.push_back(std.make_pair_T_uint(Loc, Depth));
      }
      std.stable_sort(FileLocs.begin(), FileLocs.end(), (pairTypeUInt<SourceLocation> a, pairTypeUInt<SourceLocation> b) -> a.second < b.second);
      
      for (final /*const*/std.pairTypeUInt<SourceLocation> /*&*/ FL : FileLocs) {
        SourceLocation Loc = new SourceLocation(FL.first);
        FileID SpellingFile = new FileID(JD$Move.INSTANCE, SM.getDecomposedSpellingLoc(/*NO_COPY*/Loc).first);
        /*const*/ FileEntry /*P*/ Entry = SM.getFileEntryForID(/*NO_COPY*/SpellingFile);
        if (!(Entry != null)) {
          continue;
        }
        
        FileIDMapping.$at_T1$RR(SM.getFileID(/*NO_COPY*/Loc)).$assignMove(std.make_pair_uint_T(Mapping.size(), Loc));
        Mapping.push_back(CVM.getFileID(Entry));
      }
    } finally {
      if (Visited != null) { Visited.$destroy(); }
    }
  }

  
  /// \brief Get the coverage mapping file ID for \c Loc.
  ///
  /// If such file id doesn't exist, return None.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::getCoverageFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 202,
   FQN="(anonymous namespace)::CoverageMappingBuilder::getCoverageFileID", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder17getCoverageFileIDEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder17getCoverageFileIDEN5clang14SourceLocationE")
  //</editor-fold>
  public OptionalUInt getCoverageFileID(SourceLocation Loc) {
    DenseMapIterator<FileID, std.pairUIntType<SourceLocation>> Mapping = FileIDMapping.find(SM.getFileID(/*NO_COPY*/Loc));
    if (Mapping.$noteq(/*NO_ITER_COPY*/FileIDMapping.end())) {
      return new OptionalUInt(JD$T$C$R.INSTANCE, Mapping.$arrow().second.first);
    }
    return new OptionalUInt(None);
  }

  
  /// \brief Gather all the regions that were skipped by the preprocessor
  /// using the constructs like #if.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::gatherSkippedRegions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair + other */,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 211,
   FQN="(anonymous namespace)::CoverageMappingBuilder::gatherSkippedRegions", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder20gatherSkippedRegionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder20gatherSkippedRegionsEv")
  //</editor-fold>
  public void gatherSkippedRegions() {
    /// An array of the minimum lineStarts and the maximum lineEnds
    /// for mapping regions from the appropriate source files.
    SmallVector<std.pairUIntUInt> FileLineRanges/*J*/= new SmallVector<std.pairUIntUInt>(8, new std.pairUIntUInt());
    FileLineRanges.resize(FileIDMapping.size(), 
        std.make_pair_uint_int2uint(std.numeric_limitsUInt.max(), 0));
    for (final /*const*/ CounterMappingRegion /*&*/ R : MappingRegions) {
      FileLineRanges.$at(R.FileID).first
         = std.min_uint(FileLineRanges.$at(R.FileID).first, R.LineStart);
      FileLineRanges.$at(R.FileID).second
         = std.max(FileLineRanges.$at(R.FileID).second, R.LineEnd);
    }
    
    ArrayRef<SourceRange> SkippedRanges = CVM.getSourceInfo().getSkippedRanges();
    for (final /*const*/ SourceRange /*&*/ I : SkippedRanges) {
      SourceLocation LocStart = I.getBegin();
      SourceLocation LocEnd = I.getEnd();
      assert (SM.isWrittenInSameFile(/*NO_COPY*/LocStart, /*NO_COPY*/LocEnd)) : "region spans multiple files";
      
      OptionalUInt CovFileID = getCoverageFileID(new SourceLocation(LocStart));
      if (!CovFileID.$bool()) {
        continue;
      }
      /*uint*/int LineStart = SM.getSpellingLineNumber(/*NO_COPY*/LocStart);
      /*uint*/int ColumnStart = SM.getSpellingColumnNumber(/*NO_COPY*/LocStart);
      /*uint*/int LineEnd = SM.getSpellingLineNumber(/*NO_COPY*/LocEnd);
      /*uint*/int ColumnEnd = SM.getSpellingColumnNumber(/*NO_COPY*/LocEnd);
      CounterMappingRegion Region = CounterMappingRegion.makeSkipped(CovFileID.$star(), LineStart, ColumnStart, LineEnd, ColumnEnd);
      // Make sure that we only collect the regions that are inside
      // the souce code of this function.
      if ($greatereq_uint(Region.LineStart, FileLineRanges.$at(CovFileID.$star()).first)
         && $lesseq_uint(Region.LineEnd, FileLineRanges.$at(CovFileID.$star()).second)) {
        MappingRegions.push_back(Region);
      }
    }
  }

  
  /// \brief Generate the coverage counter mapping regions from collected
  /// source regions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::emitSourceRegions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 251,
   FQN="(anonymous namespace)::CoverageMappingBuilder::emitSourceRegions", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder17emitSourceRegionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder17emitSourceRegionsEv")
  //</editor-fold>
  public void emitSourceRegions() {
    for (final /*const*/ SourceMappingRegion /*&*/ Region : SourceRegions) {
      assert (Region.hasEndLoc()) : "incomplete region";
      
      SourceLocation LocStart = Region.getStartLoc();
      assert (SM.getFileID(/*NO_COPY*/LocStart).isValid()) : "region in invalid file";
      
      // Ignore regions from system headers.
      if (SM.isInSystemHeader(SM.getSpellingLoc(/*NO_COPY*/LocStart))) {
        continue;
      }
      
      OptionalUInt CovFileID = getCoverageFileID(new SourceLocation(LocStart));
      // Ignore regions that don't have a file, such as builtin macros.
      if (!CovFileID.$bool()) {
        continue;
      }
      
      SourceLocation LocEnd = Region.getEndLoc();
      assert (SM.isWrittenInSameFile(/*NO_COPY*/LocStart, /*NO_COPY*/LocEnd)) : "region spans multiple files";
      
      // Find the spilling locations for the mapping region.
      /*uint*/int LineStart = SM.getSpellingLineNumber(/*NO_COPY*/LocStart);
      /*uint*/int ColumnStart = SM.getSpellingColumnNumber(/*NO_COPY*/LocStart);
      /*uint*/int LineEnd = SM.getSpellingLineNumber(/*NO_COPY*/LocEnd);
      /*uint*/int ColumnEnd = SM.getSpellingColumnNumber(/*NO_COPY*/LocEnd);
      assert ($lesseq_uint(LineStart, LineEnd)) : "region start and end out of order";
      MappingRegions.push_back(CounterMappingRegion.makeRegion(new Counter(Region.getCounter()), CovFileID.$star(), LineStart, ColumnStart, LineEnd, 
              ColumnEnd));
    }
  }

  
  /// \brief Generate expansion regions for each virtual file we've seen.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::emitExpansionRegions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 285,
   FQN="(anonymous namespace)::CoverageMappingBuilder::emitExpansionRegions", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilder20emitExpansionRegionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilder20emitExpansionRegionsEv")
  //</editor-fold>
  public void emitExpansionRegions() {
    for (final /*const*/std.pair<FileID, std.pairUIntType<SourceLocation>> /*&*/ FM : FileIDMapping) {
      SourceLocation ExpandedLoc = new SourceLocation(FM.second.second);
      SourceLocation ParentLoc = getIncludeOrExpansionLoc(new SourceLocation(ExpandedLoc));
      if (ParentLoc.isInvalid()) {
        continue;
      }
      
      OptionalUInt ParentFileID = getCoverageFileID(new SourceLocation(ParentLoc));
      if (!ParentFileID.$bool()) {
        continue;
      }
      OptionalUInt ExpandedFileID = getCoverageFileID(new SourceLocation(ExpandedLoc));
      assert (ExpandedFileID.$bool()) : "expansion in uncovered file";
      
      SourceLocation LocEnd = getPreciseTokenLocEnd(new SourceLocation(ParentLoc));
      assert (SM.isWrittenInSameFile(/*NO_COPY*/ParentLoc, /*NO_COPY*/LocEnd)) : "region spans multiple files";
      
      /*uint*/int LineStart = SM.getSpellingLineNumber(/*NO_COPY*/ParentLoc);
      /*uint*/int ColumnStart = SM.getSpellingColumnNumber(/*NO_COPY*/ParentLoc);
      /*uint*/int LineEnd = SM.getSpellingLineNumber(/*NO_COPY*/LocEnd);
      /*uint*/int ColumnEnd = SM.getSpellingColumnNumber(/*NO_COPY*/LocEnd);
      
      MappingRegions.push_back(CounterMappingRegion.makeExpansion(ParentFileID.$star(), ExpandedFileID.$star(), LineStart, ColumnStart, LineEnd, 
              ColumnEnd));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CoverageMappingBuilder::~CoverageMappingBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 77,
   FQN="(anonymous namespace)::CoverageMappingBuilder::~CoverageMappingBuilder", NM="_ZN12_GLOBAL__N_122CoverageMappingBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_122CoverageMappingBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SourceRegions.$destroy();
    MappingRegions.$destroy();
    FileIDMapping.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "CVM=" + CVM // NOI18N
              + ", SM=" + "[SourceManager]" // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", FileIDMapping=" + FileIDMapping // NOI18N
              + ", MappingRegions=" + MappingRegions // NOI18N
              + ", SourceRegions=" + SourceRegions; // NOI18N
  }
}
