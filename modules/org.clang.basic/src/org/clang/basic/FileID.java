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

import java.util.Comparator;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.clang.basic.*;


/// \brief An opaque identifier used by SourceManager which refers to a
/// source file (MemoryBuffer) along with its \#include path and \#line data.
///
//<editor-fold defaultstate="collapsed" desc="clang::FileID">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 39,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 39,
 FQN = "clang::FileID", NM = "_ZN5clang6FileIDE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang6FileIDE")
//</editor-fold>
public final class FileID implements Native.NativePOD<FileID>, Native.ComparableLowerGreater, Native.NativeHashable, Comparable<FileID>, Native.ComparableLower {  

  /// \brief A mostly-opaque identifier, where 0 is "invalid", >0 is 
  /// this module, and <-1 is something loaded from another module.
  /*friend*/public int ID;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FileID::FileID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 44,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 44,
   FQN = "clang::FileID::FileID", NM = "_ZN5clang6FileIDC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN5clang6FileIDC1Ev")
  //</editor-fold>
  public FileID() {
    /* : ID(0)*/ 
    //START JInit
    this.ID = 0;
    //END JInit
    trackInstance();
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::FileID::isValid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 46,
   FQN="clang::FileID::isValid", NM="_ZNK5clang6FileID7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang6FileID7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return ID != 0;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::FileID::isValid">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 46,
   FQN="clang::FileID::isValid", NM="_ZNK5clang6FileID7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang6FileID7isValidEv")
  //</editor-fold>
  public static boolean isValid(int ID) /*const*/ {
    return ID != 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileID::isInvalid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 47,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 46,
   FQN = "clang::FileID::isInvalid", NM = "_ZNK5clang6FileID9isInvalidEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang6FileID9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return ID == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileID::isInvalid">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 47,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 46,
   FQN = "clang::FileID::isInvalid", NM = "_ZNK5clang6FileID9isInvalidEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang6FileID9isInvalidEv")
  //</editor-fold>
  public static boolean isInvalid(int ID) /*const*/ {
    return ID == 0;
  }

  public int $ID() {
    return ID;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::FileID::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 49,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 48,
   FQN = "clang::FileID::operator==", NM = "_ZNK5clang6FileIDeqERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang6FileIDeqERKS0_")
  //</editor-fold>
  public boolean $eq(/*const*/FileID /*&*/ RHS) /*const*/ {
    if (RHS == null) {
      return false;
    }
    return ID == RHS.ID;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileID::operator<">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 50,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 49,
   FQN = "clang::FileID::operator<", NM = "_ZNK5clang6FileIDltERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang6FileIDltERKS0_")
  //</editor-fold>
  public boolean $less(/*const*/FileID /*&*/ RHS) /*const*/ {
    return ID < RHS.ID;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileID::operator<=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 51,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 50,
   FQN = "clang::FileID::operator<=", NM = "_ZNK5clang6FileIDleERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang6FileIDleERKS0_")
  //</editor-fold>
  public boolean $lesseq(/*const*/FileID /*&*/ RHS) /*const*/ {    
    return ID <= RHS.ID;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileID::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 52,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 51,
   FQN = "clang::FileID::operator!=", NM = "_ZNK5clang6FileIDneERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang6FileIDneERKS0_")
  //</editor-fold>
  public boolean $noteq(/*const*/FileID /*&*/ RHS) /*const*/ {
    return !(/*Deref*/this.$eq(RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileID::operator>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 53,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 52,
   FQN = "clang::FileID::operator>", NM = "_ZNK5clang6FileIDgtERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang6FileIDgtERKS0_")
  //</editor-fold>
  public boolean $greater(/*const*/FileID /*&*/ RHS) /*const*/ {
    return RHS.$less(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileID::operator>=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 54,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 53,
   FQN = "clang::FileID::operator>=", NM = "_ZNK5clang6FileIDgeERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang6FileIDgeERKS0_")
  //</editor-fold>
  public boolean $greatereq(/*const*/FileID /*&*/ RHS) /*const*/ {
    return RHS.$lesseq(/*Deref*/this);
  }

  @Override
  public FileID clone() {
    return new FileID(this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileID::getSentinel">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 56,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 55,
   FQN = "clang::FileID::getSentinel", NM = "_ZN5clang6FileID11getSentinelEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN5clang6FileID11getSentinelEv")
  //</editor-fold>
  public static FileID getSentinel() {
    return get(-1);
  }
  
  public static int getSentinelID() {
    return -1;
  }
  
  public static int getInvalidID() {
    return 0;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::FileID::getHashValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 57,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 56,
   FQN = "clang::FileID::getHashValue", NM = "_ZNK5clang6FileID12getHashValueEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang6FileID12getHashValueEv")
  //</editor-fold>
  public /*uint*/int getHashValue() /*const*/ {
    return (/*static_cast*//*uint*/int)(ID);
  }

  @Override
  public int $hashcode() {
    return getHashValue();
  }
  
/*private:*/
  /*friend  class SourceManager*/;
  /*friend  class ASTWriter*/;
  /*friend  class ASTReader*/;
  //<editor-fold defaultstate="collapsed" desc="clang::FileID::get">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 64,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 63,
   FQN = "clang::FileID::get", NM = "_ZN5clang6FileID3getEi",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN5clang6FileID3getEi")
  //</editor-fold>
  /*friend*/public/*private*/ static FileID get(int V) {
    FileID F/*J*/= new FileID();
    F.ID = V;
    return F;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileID::getOpaqueValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 69,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 68,
   FQN = "clang::FileID::getOpaqueValue", NM = "_ZNK5clang6FileID14getOpaqueValueEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang6FileID14getOpaqueValueEv")
  //</editor-fold>
  /*friend*/public int getOpaqueValue() /*const*/ {
    return ID;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileID::FileID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 39,
   FQN = "clang::FileID::FileID", NM = "_ZN5clang6FileIDC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN5clang6FileIDC1ERKS0_")
  //</editor-fold>
  public /*inline*/ FileID(/*const*/FileID /*&*/ $Prm0)/* throw()*/ {
    /* : ID(.ID)*/ 
    //START JInit
    this.ID = $Prm0.ID;
    //END JInit
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileID::FileID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 39,
   FQN="clang::FileID::FileID", NM="_ZN5clang6FileIDC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN5clang6FileIDC1EOS0_")
  //</editor-fold>
  public /*inline*/ FileID(JD$Move _dparam, FileID /*&&*/$Prm0) {
    /* : ID(static_cast<FileID &&>().ID)*/ 
    //START JInit
    this.ID = $Prm0.ID;
    //END JInit
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileID::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 39,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 39,
   FQN = "clang::FileID::operator=", NM = "_ZN5clang6FileIDaSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN5clang6FileIDaSERKS0_")
  //</editor-fold>
  public /*inline*/ FileID /*&*/ $assign(/*const*/FileID /*&*/ $Prm0)/* throw()*/ {
    this.ID = $Prm0.ID;
    return /*Deref*/this;
  }
  public /*inline*/ FileID /*&*/ $assign(/*const*//*FileID*/int /*&*/ $Prm0)/* throw()*/ {
    this.ID = $Prm0;
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::FileID::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 39,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 39,
   FQN = "clang::FileID::operator=", NM = "_ZN5clang6FileIDaSEOS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang6FileIDaSEOS0_")
  //</editor-fold>
  public /*inline*/ FileID /*&*/ $assignMove(FileID /*&&*/$Prm0) {
    this.ID = $Prm0.ID;
    return /*Deref*/this;
  }
  public /*inline*/ FileID /*&*/ $assignMove(int /*&&*/$Prm0) {
    this.ID = $Prm0;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final FileID DEFAULT = new FileID();
  
  public static Comparator<FileID> COMPARATOR = new Comparator<FileID>() {
    @Override
    public int compare(FileID o1, FileID o2) {
      return o1.ID-o2.ID;
    }
  };


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "FileID{" + "ID=" + ID + '}';
  }

  @Override
  public boolean $less(Object obj) {
    return $less((FileID)obj);
  }

  @Override
  public boolean $lesseq(Object obj) {
    return $lesseq((FileID)obj);
  }

  @Override
  public boolean $greater(Object obj) {
    return $greater((FileID)obj);
  }

  @Override
  public boolean $greatereq(Object obj) {
    return $greatereq((FileID)obj);
  }
  
  public static FileID getFromRawEncoding(int FID) {
    return new FileID(FID);
  }
  
  private FileID(int FID) {
    this.ID = FID;
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
    out.$out(String.format("%22s created:\t", FileID.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    NativeTrace.dumpStatisticValue(FileID.class.getSimpleName(), instances);
    return instances;
  }  

  @Override
  public int compareTo(FileID other) {
    return this.ID - other.ID;
  }
}
