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

package org.clang.edit;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.basic.*;
import org.clang.edit.*;

//<editor-fold defaultstate="collapsed" desc="clang::edit::FileOffset">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*POD*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 19,
 FQN="clang::edit::FileOffset", NM="_ZN5clang4edit10FileOffsetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit10FileOffsetE")
//</editor-fold>
public class FileOffset implements NativePOD<FileOffset>, Native.ComparableLowerGreater {
  private FileID FID;
  private /*uint*/int Offs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::edit::FileOffset::FileOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 23,
   FQN="clang::edit::FileOffset::FileOffset", NM="_ZN5clang4edit10FileOffsetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit10FileOffsetC1Ev")
  //</editor-fold>
  public FileOffset() {
    // : FID(), Offs(0) 
    //START JInit
    this.FID = new FileID();
    this.Offs = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::FileOffset::FileOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 24,
   FQN="clang::edit::FileOffset::FileOffset", NM="_ZN5clang4edit10FileOffsetC1ENS_6FileIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit10FileOffsetC1ENS_6FileIDEj")
  //</editor-fold>
  public FileOffset(FileID fid, /*uint*/int offs) {
    // : FID(fid), Offs(offs) 
    //START JInit
    this.FID = new FileID(fid);
    this.Offs = offs;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::FileOffset::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 26,
   FQN="clang::edit::FileOffset::isInvalid", NM="_ZNK5clang4edit10FileOffset9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZNK5clang4edit10FileOffset9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return FID.isInvalid();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::FileOffset::getFID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 28,
   FQN="clang::edit::FileOffset::getFID", NM="_ZNK5clang4edit10FileOffset6getFIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZNK5clang4edit10FileOffset6getFIDEv")
  //</editor-fold>
  public FileID getFID() /*const*/ {
    return new FileID(FID);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::FileOffset::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 29,
   FQN="clang::edit::FileOffset::getOffset", NM="_ZNK5clang4edit10FileOffset9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZNK5clang4edit10FileOffset9getOffsetEv")
  //</editor-fold>
  public /*uint*/int getOffset() /*const*/ {
    return Offs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::FileOffset::getWithOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 31,
   FQN="clang::edit::FileOffset::getWithOffset", NM="_ZNK5clang4edit10FileOffset13getWithOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZNK5clang4edit10FileOffset13getWithOffsetEj")
  //</editor-fold>
  public FileOffset getWithOffset(/*uint*/int offset) /*const*/ {
    FileOffset NewOffs = new FileOffset(/*Deref*/this);
    NewOffs.Offs += offset;
    return NewOffs;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::edit::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 37,
   FQN="clang::edit::operator==", NM="_ZN5clang4editeqENS0_10FileOffsetES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4editeqENS0_10FileOffsetES1_")
  //</editor-fold>
  public static boolean $eq_FileOffset(FileOffset LHS, FileOffset RHS) {
    return LHS.FID.$eq(RHS.FID) && LHS.Offs == RHS.Offs;
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::edit::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 40,
   FQN="clang::edit::operator!=", NM="_ZN5clang4editneENS0_10FileOffsetES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4editneENS0_10FileOffsetES1_")
  //</editor-fold>
  public static boolean $noteq_FileOffset(FileOffset LHS, FileOffset RHS) {
    return !($eq_FileOffset(/*NO_COPY*/LHS, /*NO_COPY*/RHS));
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::edit::operator<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 43,
   FQN="clang::edit::operator<", NM="_ZN5clang4editltENS0_10FileOffsetES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4editltENS0_10FileOffsetES1_")
  //</editor-fold>
  public static boolean $less_FileOffset(FileOffset LHS, FileOffset RHS) {
//    return $less_tuple$C(std.tie(LHS.FID, LHS.Offs), std.tie(RHS.FID, RHS.Offs));
    if (LHS.FID.$less(RHS.FID)) {
      return true;
    }
    if (RHS.FID.$less(LHS.FID)) {
      return false;
    }
    return Unsigned.$less_uint(LHS.Offs, RHS.Offs);
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::edit::operator>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 46,
   FQN="clang::edit::operator>", NM="_ZN5clang4editgtENS0_10FileOffsetES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4editgtENS0_10FileOffsetES1_")
  //</editor-fold>
  public static boolean $greater_FileOffset(FileOffset LHS, FileOffset RHS) {
    return $less_FileOffset(/*NO_COPY*/RHS, /*NO_COPY*/LHS);
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::edit::operator>=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 49,
   FQN="clang::edit::operator>=", NM="_ZN5clang4editgeENS0_10FileOffsetES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4editgeENS0_10FileOffsetES1_")
  //</editor-fold>
  public static boolean $greatereq_FileOffset(FileOffset LHS, FileOffset RHS) {
    return !($less_FileOffset(/*NO_COPY*/LHS, /*NO_COPY*/RHS));
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::edit::operator<=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 52,
   FQN="clang::edit::operator<=", NM="_ZN5clang4editleENS0_10FileOffsetES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4editleENS0_10FileOffsetES1_")
  //</editor-fold>
  public static boolean $lesseq_FileOffset(FileOffset LHS, FileOffset RHS) {
    return !($less_FileOffset(/*NO_COPY*/RHS, /*NO_COPY*/LHS));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::FileOffset::FileOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 19,
   FQN="clang::edit::FileOffset::FileOffset", NM="_ZN5clang4edit10FileOffsetC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit10FileOffsetC1ERKS1_")
  //</editor-fold>
  public /*inline*/ FileOffset(/*const*/ FileOffset /*&*/ $Prm0) {
    // : FID(.FID), Offs(.Offs) 
    //START JInit
    this.FID = new FileID($Prm0.FID);
    this.Offs = $Prm0.Offs;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::FileOffset::FileOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 19,
   FQN="clang::edit::FileOffset::FileOffset", NM="_ZN5clang4edit10FileOffsetC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit10FileOffsetC1EOS1_")
  //</editor-fold>
  public /*inline*/ FileOffset(JD$Move _dparam, FileOffset /*&&*/$Prm0) {
    // : FID(static_cast<FileOffset &&>().FID), Offs(static_cast<FileOffset &&>().Offs) 
    //START JInit
    this.FID = new FileID(JD$Move.INSTANCE, $Prm0.FID);
    this.Offs = $Prm0.Offs;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::FileOffset::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 19,
   FQN="clang::edit::FileOffset::operator=", NM="_ZN5clang4edit10FileOffsetaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit10FileOffsetaSERKS1_")
  //</editor-fold>
  public /*inline*/ FileOffset /*&*/ $assign(/*const*/ FileOffset /*&*/ $Prm0) {
    this.FID.$assign($Prm0.FID);
    this.Offs = $Prm0.Offs;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::edit::FileOffset::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/FileOffset.h", line = 19,
   FQN="clang::edit::FileOffset::operator=", NM="_ZN5clang4edit10FileOffsetaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/Commit.cpp -nm=_ZN5clang4edit10FileOffsetaSEOS1_")
  //</editor-fold>
  public /*inline*/ FileOffset /*&*/ $assignMove(FileOffset /*&&*/$Prm0) {
    this.FID.$assignMove($Prm0.FID);
    this.Offs = $Prm0.Offs;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "FID=" + FID // NOI18N
              + ", Offs=" + Offs; // NOI18N
  }

  @Override
  @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
  public FileOffset clone() {
    return new FileOffset(this);
  }

  @Override
  public boolean $eq(FileOffset other) {
    return $eq_FileOffset(this, other);
  }

  @Override
  public boolean $less(Object obj) {
    return $less_FileOffset(this, (FileOffset)obj);
  }

  @Override
  public boolean $greater(Object obj) {
    return $greater_FileOffset(this, (FileOffset)obj);
  }
}
