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

package org.clang.basic;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clang.basic.java.ClankAliases;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clank.support.Native.$tryClone;


/// \brief A SourceLocation and its associated SourceManager.
///
/// This is useful for argument passing to functions that expect both objects.
//<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 268,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 267,
 FQN = "clang::FullSourceLoc", NM = "_ZN5clang13FullSourceLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13FullSourceLocE")
//</editor-fold>
public final class FullSourceLoc extends /*public*/ SourceLocation {
  /*friend*//*final *//*const*/ SourceManager /*P*/ SrcMgr;
/*public:*/
  /// \brief Creates a FullSourceLoc where isValid() returns \c false.
  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::FullSourceLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 272,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 271,
   FQN = "clang::FullSourceLoc::FullSourceLoc", NM = "_ZN5clang13FullSourceLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13FullSourceLocC1Ev")
  //</editor-fold>
  public /*explicit*/ FullSourceLoc() {
    /* : SourceLocation(), SrcMgr(null)*/ 
    //START JInit
    super();
    this.SrcMgr = null;
    //END JInit
    trackInstance();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::FullSourceLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 274,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 273,
   FQN = "clang::FullSourceLoc::FullSourceLoc", NM = "_ZN5clang13FullSourceLocC1ENS_14SourceLocationERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13FullSourceLocC1ENS_14SourceLocationERKNS_13SourceManagerE")
  //</editor-fold>
  public /*explicit*/ FullSourceLoc(SourceLocation Loc, /*const*/SourceManager /*&*/ SM) {
    /* : SourceLocation(Loc), SrcMgr(&SM)*/ 
    //START JInit
    super(Loc);
    this.SrcMgr = $AddrOf(SM);
    //END JInit
    trackInstance();
  }
  public /*explicit*/ FullSourceLoc(/*SourceLocation*/int Loc, /*const*/SourceManager /*&*/ SM) {
    /* : SourceLocation(Loc), SrcMgr(&SM)*/ 
    //START JInit
    super(Loc);
    this.SrcMgr = $AddrOf(SM);
    //END JInit
    trackInstance();    
  }

  
  /// \pre This FullSourceLoc has an associated SourceManager.
  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::getManager">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 278,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 277,
   FQN = "clang::FullSourceLoc::getManager", NM = "_ZNK5clang13FullSourceLoc10getManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang13FullSourceLoc10getManagerEv")
  //</editor-fold>
  public /*const*/SourceManager /*&*/ getManager() /*const*/ {
    assert ((SrcMgr != null)) : "SourceManager is NULL.";
    return $Deref(SrcMgr);
  }

  
  //===----------------------------------------------------------------------===//
  // FullSourceLoc
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::getFileID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 80,
   FQN = "clang::FullSourceLoc::getFileID", NM = "_ZNK5clang13FullSourceLoc9getFileIDEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc9getFileIDEv")
  //</editor-fold>
  public FileID getFileID() /*const*/ {
    assert (isValid());
    return SrcMgr.getFileID(/*NO_COPY*//*Deref*/this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::getExpansionLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 86,
   FQN = "clang::FullSourceLoc::getExpansionLoc", NM = "_ZNK5clang13FullSourceLoc15getExpansionLocEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc15getExpansionLocEv")
  //</editor-fold>
  public FullSourceLoc getExpansionLoc() /*const*/ {
    assert (isValid());
    return new FullSourceLoc(SrcMgr.getExpansionLoc(/*NO_COPY*//*Deref*/this), $Deref(SrcMgr));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::getSpellingLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 91,
   FQN = "clang::FullSourceLoc::getSpellingLoc", NM = "_ZNK5clang13FullSourceLoc14getSpellingLocEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc14getSpellingLocEv")
  //</editor-fold>
  public FullSourceLoc getSpellingLoc() /*const*/ {
    assert (isValid());
    return new FullSourceLoc(SrcMgr.getSpellingLoc(/*NO_COPY*//*Deref*/this), $Deref(SrcMgr));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::getExpansionLineNumber">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 96,
   FQN = "clang::FullSourceLoc::getExpansionLineNumber", NM = "_ZNK5clang13FullSourceLoc22getExpansionLineNumberEPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc22getExpansionLineNumberEPb")
  //</editor-fold>
  public /*uint*/int getExpansionLineNumber() /*const*/ {
    return getExpansionLineNumber((bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getExpansionLineNumber(bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    assert (isValid());
    return SrcMgr.getExpansionLineNumber(/*NO_COPY*//*Deref*/this, Invalid);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::getExpansionColumnNumber">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 101,
   FQN = "clang::FullSourceLoc::getExpansionColumnNumber", NM = "_ZNK5clang13FullSourceLoc24getExpansionColumnNumberEPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc24getExpansionColumnNumberEPb")
  //</editor-fold>
  public /*uint*/int getExpansionColumnNumber() /*const*/ {
    return getExpansionColumnNumber((bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getExpansionColumnNumber(bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    assert (isValid());
    return SrcMgr.getExpansionColumnNumber(/*NO_COPY*//*Deref*/this, Invalid);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::getSpellingLineNumber">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 106,
   FQN = "clang::FullSourceLoc::getSpellingLineNumber", NM = "_ZNK5clang13FullSourceLoc21getSpellingLineNumberEPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc21getSpellingLineNumberEPb")
  //</editor-fold>
  public /*uint*/int getSpellingLineNumber() /*const*/ {
    return getSpellingLineNumber((bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getSpellingLineNumber(bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    assert (isValid());
    return SrcMgr.getSpellingLineNumber(/*NO_COPY*//*Deref*/this, Invalid);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::getSpellingColumnNumber">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 111,
   FQN = "clang::FullSourceLoc::getSpellingColumnNumber", NM = "_ZNK5clang13FullSourceLoc23getSpellingColumnNumberEPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc23getSpellingColumnNumberEPb")
  //</editor-fold>
  public /*uint*/int getSpellingColumnNumber() /*const*/ {
    return getSpellingColumnNumber((bool$ptr/*bool P*/ )null);
  }
  public /*uint*/int getSpellingColumnNumber(bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    assert (isValid());
    return SrcMgr.getSpellingColumnNumber(/*NO_COPY*//*Deref*/this, Invalid);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::getCharacterData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 130,
   FQN = "clang::FullSourceLoc::getCharacterData", NM = "_ZNK5clang13FullSourceLoc16getCharacterDataEPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc16getCharacterDataEPb")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCharacterData() /*const*/ {
    return getCharacterData((bool$ptr/*bool P*/ )null);
  }
  public /*const*/char$ptr/*char P*/ getCharacterData(bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    assert (isValid());
    char$ptr Ptr = NativePointer.create_char$ptr();
    Ptr = SrcMgr.getCharacterData_ValidOnly(super.getRawEncoding(), Ptr);
    if (Invalid != null) {
      Invalid.$set(Ptr == NativePointer.$EMPTY);
    }
    return Ptr;
  }

  
  
  /// \brief Return a StringRef to the source buffer data for the
  /// specified FileID.
  
  /// \brief Return a StringRef to the source buffer data for the
  /// specified FileID.
  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::getBufferData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 135,
   FQN = "clang::FullSourceLoc::getBufferData", NM = "_ZNK5clang13FullSourceLoc13getBufferDataEPb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc13getBufferDataEPb")
  //</editor-fold>
  public StringRef getBufferData() /*const*/ {
    return getBufferData((bool$ptr/*bool P*/ )null);
  }
  public StringRef getBufferData(bool$ptr/*bool P*/ Invalid/*= null*/) /*const*/ {
    assert (isValid());
    final MemoryBuffer Buf = SrcMgr.getBuffer(SrcMgr.getFileID(/*NO_COPY*//*Deref*/this), /*Invalid*/(bool$ptr)null);
    if (Invalid != null) {
      Invalid.$set(Buf.isInvalid());
    }
    return Buf.getBuffer();
  }


  
  /// \brief Decompose the specified location into a raw FileID + Offset pair.
  ///
  /// The first element is the FileID, the second is the offset from the
  /// start of the buffer of the location.
  
  /// \brief Decompose the specified location into a raw FileID + Offset pair.
  ///
  /// The first element is the FileID, the second is the offset from the
  /// start of the buffer of the location.
  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::getDecomposedLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 140,
   FQN = "clang::FullSourceLoc::getDecomposedLoc", NM = "_ZNK5clang13FullSourceLoc16getDecomposedLocEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc16getDecomposedLocEv")
  //</editor-fold>
  public std.pairTypeUInt<FileID> getDecomposedLoc() /*const*/ {
    return SrcMgr.getDecomposedLoc(/*Deref*/this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::isInSystemHeader">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 116,
   FQN = "clang::FullSourceLoc::isInSystemHeader", NM = "_ZNK5clang13FullSourceLoc16isInSystemHeaderEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc16isInSystemHeaderEv")
  //</editor-fold>
  public boolean isInSystemHeader() /*const*/ {
    assert (isValid());
    return SrcMgr.isInSystemHeader(/*NO_COPY*//*Deref*/this);
  }

  
  
  /// \brief Determines the order of 2 source locations in the translation unit.
  ///
  /// \returns true if this source location comes before 'Loc', false otherwise.
  
  /// \brief Determines the order of 2 source locations in the translation unit.
  ///
  /// \returns true if this source location comes before 'Loc', false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::isBeforeInTranslationUnitThan">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 121,
   FQN = "clang::FullSourceLoc::isBeforeInTranslationUnitThan", NM = "_ZNK5clang13FullSourceLoc29isBeforeInTranslationUnitThanENS_14SourceLocationE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc29isBeforeInTranslationUnitThanENS_14SourceLocationE")
  //</editor-fold>
  public boolean isBeforeInTranslationUnitThan(SourceLocation Loc) /*const*/ {
    assert (isValid());
    return SrcMgr.isBeforeInTranslationUnit(/*NO_COPY*//*Deref*/this, /*NO_COPY*/Loc);
  }

  
  
  /// \brief Determines the order of 2 source locations in the translation unit.
  ///
  /// \returns true if this source location comes before 'Loc', false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::isBeforeInTranslationUnitThan">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 317,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 316,
   FQN = "clang::FullSourceLoc::isBeforeInTranslationUnitThan", NM = "_ZNK5clang13FullSourceLoc29isBeforeInTranslationUnitThanES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang13FullSourceLoc29isBeforeInTranslationUnitThanES0_")
  //</editor-fold>
  public boolean isBeforeInTranslationUnitThan(FullSourceLoc Loc) /*const*/ {
    assert (Loc.isValid());
    assert (SrcMgr == Loc.SrcMgr) : "Loc comes from another SourceManager!";
    return isBeforeInTranslationUnitThan((SourceLocation)Loc);
  }

  
  /// \brief Comparison function class, useful for sorting FullSourceLocs.
  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::BeforeThanCompare">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 324,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 323,
   FQN = "clang::FullSourceLoc::BeforeThanCompare", NM = "_ZN5clang13FullSourceLoc17BeforeThanCompareE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13FullSourceLoc17BeforeThanCompareE")
  //</editor-fold>
  public static class/*struct*/ BeforeThanCompare extends /*public*/ ClankAliases.StdLessFullSourceLoc {
    //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::BeforeThanCompare::operator()">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 326,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 325,
     FQN = "clang::FullSourceLoc::BeforeThanCompare::operator()", NM = "_ZNK5clang13FullSourceLoc17BeforeThanCompareclERKS0_S3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang13FullSourceLoc17BeforeThanCompareclERKS0_S3_")
    //</editor-fold>
    public boolean $call(/*const*/FullSourceLoc /*&*/ lhs, /*const*/FullSourceLoc /*&*/ rhs) /*const*/ {
      return lhs.isBeforeInTranslationUnitThan(rhs);
    }


    //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::BeforeThanCompare::BeforeThanCompare">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 324,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 323,
     FQN="clang::FullSourceLoc::BeforeThanCompare::BeforeThanCompare", NM="_ZN5clang13FullSourceLoc17BeforeThanCompareC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransformActions.cpp -nm=_ZN5clang13FullSourceLoc17BeforeThanCompareC1ERKS1_")
    //</editor-fold>
    public /*inline*/ BeforeThanCompare(/*const*/ BeforeThanCompare /*&*/ $Prm0) {
      /* : std::binary_function<FullSourceLoc, FullSourceLoc, bool>()*/ 
      //START JInit
      super($Prm0);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::BeforeThanCompare::BeforeThanCompare">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 324,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 323,
     FQN="clang::FullSourceLoc::BeforeThanCompare::BeforeThanCompare", NM="_ZN5clang13FullSourceLoc17BeforeThanCompareC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransformActions.cpp -nm=_ZN5clang13FullSourceLoc17BeforeThanCompareC1EOS1_")
    //</editor-fold>
    public /*inline*/ BeforeThanCompare(JD$Move _dparam, BeforeThanCompare /*&&*/$Prm0) {
      /* : std::binary_function<FullSourceLoc, FullSourceLoc, bool>(static_cast<BeforeThanCompare &&>())*/ 
      //START JInit
      super(JD$Move.INSTANCE, $Prm0);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::BeforeThanCompare::~BeforeThanCompare">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 324,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 323,
     FQN="clang::FullSourceLoc::BeforeThanCompare::~BeforeThanCompare", NM="_ZN5clang13FullSourceLoc17BeforeThanCompareD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransformActions.cpp -nm=_ZN5clang13FullSourceLoc17BeforeThanCompareD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      super.$destroy();
    }

    
    public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
  
  /// \brief Prints information about this FullSourceLoc to stderr.
  ///
  /// This is useful for debugging.
  
  /// \brief Prints information about this FullSourceLoc to stderr.
  ///
  /// This is useful for debugging.
  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::dump">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 126,
   FQN = "clang::FullSourceLoc::dump", NM = "_ZNK5clang13FullSourceLoc4dumpEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang13FullSourceLoc4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    super.dump($Deref(SrcMgr));
  }


  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 336,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 335,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_13FullSourceLocES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clangeqERKNS_13FullSourceLocES2_")
  //</editor-fold>
  public static /*inline*/ boolean $eq_FullSourceLoc$C(/*const*/ FullSourceLoc /*&*/ LHS, /*const*/ FullSourceLoc /*&*/ RHS) {
    return LHS.getRawEncoding() == RHS.getRawEncoding()
       && LHS.SrcMgr == RHS.SrcMgr;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 342,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 341,
   FQN="clang::operator!=", NM="_ZN5clangneERKNS_13FullSourceLocES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clangneERKNS_13FullSourceLocES2_")
  //</editor-fold>
  public static /*inline*/ boolean $noteq_FullSourceLoc$C(/*const*/ FullSourceLoc /*&*/ LHS, /*const*/ FullSourceLoc /*&*/ RHS) {
    return !($eq_FullSourceLoc$C(LHS, RHS));
  }
    
  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::FullSourceLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 268,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 267,
   FQN = "clang::FullSourceLoc::FullSourceLoc", NM = "_ZN5clang13FullSourceLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13FullSourceLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ FullSourceLoc(/*const*/ FullSourceLoc /*&*/ $Prm0)/* throw()*/ {
    /* : SourceLocation(), SrcMgr(.SrcMgr)*/ 
    //START JInit
    super($Prm0);
    this.SrcMgr = $Prm0.SrcMgr;
    //END JInit
    trackInstance(); // MANUAL_SEMANTIC
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::FullSourceLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 268,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 267,
   FQN="clang::FullSourceLoc::FullSourceLoc", NM="_ZN5clang13FullSourceLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13FullSourceLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ FullSourceLoc(JD$Move _dparam, FullSourceLoc /*&&*/$Prm0) {
    /* : SourceLocation(static_cast<FullSourceLoc &&>()), SrcMgr(static_cast<FullSourceLoc &&>().SrcMgr)*/ 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.SrcMgr = $Prm0.SrcMgr;
    //END JInit
    $Prm0.SrcMgr = null;
    trackInstance(); // MANUAL_SEMANTIC
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 268,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 267,
   FQN="clang::FullSourceLoc::operator=", NM="_ZN5clang13FullSourceLocaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13FullSourceLocaSERKS0_")
  //</editor-fold>
  public /*inline*/ FullSourceLoc /*&*/ $assign(/*const*/ FullSourceLoc /*&*/ $Prm0) {
    /*Deref*/super.$assign($Prm0);
    assert(this.SrcMgr == $Prm0.SrcMgr); // MANUAL_SEMANTIC
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FullSourceLoc::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 268,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 267,
   FQN="clang::FullSourceLoc::operator=", NM="_ZN5clang13FullSourceLocaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang13FullSourceLocaSEOS0_")
  //</editor-fold>
  public /*inline*/ FullSourceLoc /*&*/ $assignMove(FullSourceLoc /*&&*/$Prm0) {
    /*Deref*/super.$assignMove($Prm0);
    assert(this.SrcMgr == null || this.SrcMgr == $Prm0.SrcMgr); // MANUAL_SEMANTIC
    this.SrcMgr = $Prm0.SrcMgr;
    $Prm0.SrcMgr = null;
    return /*Deref*/this;
  }
  
  @Override
  public String toString() {
    if (SrcMgr != null) {
      std.string str = super.printToString(SrcMgr);
      return str.toString();
    }
    return super.toString();
  }
  

  @Override
  public SourceLocation clone() {
    return new FullSourceLoc(this);
  }

  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }
  
  public static void clearStatistics() {
    instances = 0;
  }
  // JAVA: pass OS and return some integral value
  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s created:\t", FullSourceLoc.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    NativeTrace.dumpStatisticValue(FullSourceLoc.class.getSimpleName(), instances);
    return instances;
  }  
}
