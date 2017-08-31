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

package org.llvm.adt;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import static org.llvm.adt.HashingGlobals.hash_combine_range;


//===--------------------------------------------------------------------===//
/// FoldingSetNodeIDRef - This class describes a reference to an interned
/// FoldingSetNodeID, which can be a useful to store node id data rather
/// than using plain FoldingSetNodeIDs, since the 32-element SmallVector
/// is often much larger than necessary, and the possibility of heap
/// allocation means it requires a non-trivial destructor call.
//<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeIDRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 267,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 268,
 FQN="llvm::FoldingSetNodeIDRef", NM="_ZN4llvm19FoldingSetNodeIDRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm19FoldingSetNodeIDRefE")
//</editor-fold>
public class FoldingSetNodeIDRef implements Native.NativeComparable<FoldingSetNodeIDRef> {
  private /*const*/uint$ptr/*uint P*/ Data;
  private /*size_t*/int Size;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeIDRef::FoldingSetNodeIDRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 272,
   FQN="llvm::FoldingSetNodeIDRef::FoldingSetNodeIDRef", NM="_ZN4llvm19FoldingSetNodeIDRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm19FoldingSetNodeIDRefC1Ev")
  //</editor-fold>
  public FoldingSetNodeIDRef() {
    /* : Data(null), Size(0)*/ 
    //START JInit
    this.Data = null;
    this.Size = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeIDRef::FoldingSetNodeIDRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 273,
   FQN="llvm::FoldingSetNodeIDRef::FoldingSetNodeIDRef", NM="_ZN4llvm19FoldingSetNodeIDRefC1EPKjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm19FoldingSetNodeIDRefC1EPKjj")
  //</editor-fold>
  public FoldingSetNodeIDRef(/*const*/uint$ptr/*uint P*/ D, /*size_t*/int S) {
    /* : Data(D), Size(S)*/ 
    //START JInit
    this.Data = $tryClone(D);
    this.Size = S;
    //END JInit
  }

  
  /// ComputeHash - Compute a strong hash value for this FoldingSetNodeIDRef,
  /// used to lookup the node in the FoldingSetImpl.
  
  //===----------------------------------------------------------------------===//
  // FoldingSetNodeIDRef Implementation
  
  /// ComputeHash - Compute a strong hash value for this FoldingSetNodeIDRef,
  /// used to lookup the node in the FoldingSetImpl.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeIDRef::ComputeHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 30,
   FQN="llvm::FoldingSetNodeIDRef::ComputeHash", NM="_ZNK4llvm19FoldingSetNodeIDRef11ComputeHashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm19FoldingSetNodeIDRef11ComputeHashEv")
  //</editor-fold>
  public /*uint*/int ComputeHash() /*const*/ {
    return ((/*static_cast*//*uint*/int)(hash_combine_range(Data, Data.$add(Size)).$uint()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeIDRef::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 34,
   FQN="llvm::FoldingSetNodeIDRef::operator==", NM="_ZNK4llvm19FoldingSetNodeIDRefeqES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm19FoldingSetNodeIDRefeqES0_")
  //</editor-fold>
  public boolean $eq(FoldingSetNodeIDRef RHS) /*const*/ {
    if (Size != RHS.Size) {
      return false;
    }
    return memcmp(Data, RHS.Data, Size * NativeType.BYTES_IN_UINT) == 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeIDRef::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 281,
   FQN="llvm::FoldingSetNodeIDRef::operator!=", NM="_ZNK4llvm19FoldingSetNodeIDRefneES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm19FoldingSetNodeIDRefneES0_")
  //</editor-fold>
  public boolean $noteq(FoldingSetNodeIDRef RHS) /*const*/ {
    return !(/*Deref*/this.$eq(/*NO_COPY*/RHS));
  }

  
  /// Used to compare the "ordering" of two nodes as defined by the
  /// profiled bits and their ordering defined by memcmp().
  
  /// Used to compare the "ordering" of two nodes as defined by the
  /// profiled bits and their ordering defined by memcmp().
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeIDRef::operator<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 41,
   FQN="llvm::FoldingSetNodeIDRef::operator<", NM="_ZNK4llvm19FoldingSetNodeIDRefltES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm19FoldingSetNodeIDRefltES0_")
  //</editor-fold>
  public boolean $less(FoldingSetNodeIDRef RHS) /*const*/ {
    if (Size != RHS.Size) {
      return $less_uint(Size, RHS.Size);
    }
    return memcmp(Data, RHS.Data, Size * NativeType.BYTES_IN_UINT) < 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeIDRef::getData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 287,
   FQN="llvm::FoldingSetNodeIDRef::getData", NM="_ZNK4llvm19FoldingSetNodeIDRef7getDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm19FoldingSetNodeIDRef7getDataEv")
  //</editor-fold>
  public /*const*/uint$ptr/*uint P*/ getData() /*const*/ {
    return Data;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeIDRef::getSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 288,
   FQN="llvm::FoldingSetNodeIDRef::getSize", NM="_ZNK4llvm19FoldingSetNodeIDRef7getSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm19FoldingSetNodeIDRef7getSizeEv")
  //</editor-fold>
  public /*size_t*/int getSize() /*const*/ {
    return Size;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeIDRef::FoldingSetNodeIDRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 267,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 268,
   FQN="llvm::FoldingSetNodeIDRef::FoldingSetNodeIDRef", NM="_ZN4llvm19FoldingSetNodeIDRefC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm19FoldingSetNodeIDRefC1ERKS0_")
  //</editor-fold>
  public /*inline*/ FoldingSetNodeIDRef(/*const*/ FoldingSetNodeIDRef /*&*/ $Prm0) {
    /* : Data(.Data), Size(.Size)*/ 
    //START JInit
    this.Data = $tryClone($Prm0.Data);
    this.Size = $Prm0.Size;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetNodeIDRef::FoldingSetNodeIDRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 267,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 268,
   FQN="llvm::FoldingSetNodeIDRef::FoldingSetNodeIDRef", NM="_ZN4llvm19FoldingSetNodeIDRefC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm19FoldingSetNodeIDRefC1EOS0_")
  //</editor-fold>
  public /*inline*/ FoldingSetNodeIDRef(JD$Move _dparam, FoldingSetNodeIDRef /*&&*/$Prm0) {
    /* : Data(static_cast<FoldingSetNodeIDRef &&>().Data), Size(static_cast<FoldingSetNodeIDRef &&>().Size)*/ 
    //START JInit
    this.Data = $tryClone($Prm0.Data);
    this.Size = $Prm0.Size;
    //END JInit
  }

  
  public String toString() {
    return "" + "Data=" + Data // NOI18N
              + ", Size=" + Size; // NOI18N
  }
}
