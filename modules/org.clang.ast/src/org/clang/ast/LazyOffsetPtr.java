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

package org.clang.ast;

import org.clank.support.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clang.ast.java.AstMemberPointers.*;


/// \brief A lazy pointer to an AST node (of base type T) that resides
/// within an external AST source.
///
/// The AST node is identified within the external AST source by a
/// 63-bit offset, and can be retrieved via an operation on the
/// external AST source itself.
/*template <typename T, typename OffsT, T *(ExternalASTSource::*)(OffsT) Get> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::LazyOffsetPtr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Ptr is either T or Long*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 320,
 FQN="clang::LazyOffsetPtr", NM="_ZN5clang13LazyOffsetPtrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang13LazyOffsetPtrE")
//</editor-fold>
public abstract class/*struct*/ LazyOffsetPtr</*typename*/ T/*, typename OffsT, T* (ExternalASTSource::*Get)(OffsT Offset)*/> implements Native.Native$Bool  {
//public class/*struct*/ LazyOffsetPtr</*typename*/ T, /*typename*/ OffsT, ExternalASTSource$OffsT2T<T> Get>  implements Native.Native$Bool {
  /// \brief Either a pointer to an AST node or the offset within the
  /// external AST source where the AST node can be found.
  ///
  /// If the low bit is clear, a pointer to the AST node. If the low
  /// bit is set, the upper 63 bits are the offset.
  public /*mutable */Object/*T or Long*//*uint64_t*/ Ptr;
  private final ExternalASTSource$OffsT2T<T> GetT;
  private final boolean NullIsTypePointer;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LazyOffsetPtr::LazyOffsetPtr<T, OffsT, Get>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 330,
   FQN="clang::LazyOffsetPtr::LazyOffsetPtr<T, OffsT, Get>", NM="_ZN5clang13LazyOffsetPtrC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang13LazyOffsetPtrC1Ev")
  //</editor-fold>
  protected LazyOffsetPtr(ExternalASTSource$OffsT2T<T> getter, boolean NullIsTypePointer) {
    // : Ptr(0) 
    //START JInit
    this.Ptr = null;
    this.GetT = getter;
    //END JInit
    this.NullIsTypePointer = NullIsTypePointer;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LazyOffsetPtr::LazyOffsetPtr<T, OffsT, Get>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 332,
   FQN="clang::LazyOffsetPtr::LazyOffsetPtr<T, OffsT, Get>", NM="_ZN5clang13LazyOffsetPtrC1EPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang13LazyOffsetPtrC1EPT_")
  //</editor-fold>
  protected /*explicit*/ LazyOffsetPtr(T /*P*/ Ptr, ExternalASTSource$OffsT2T<T> getter, boolean NullIsTypePointer) {
    // : Ptr(reinterpret_cast<uint64_t>(Ptr)) 
    //START JInit
    this.Ptr = /*reinterpret_cast_long*//*uint64_t*/(Ptr);
    this.GetT = getter;
    //END JInit
    this.NullIsTypePointer = NullIsTypePointer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LazyOffsetPtr::LazyOffsetPtr<T, OffsT, Get>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 333,
   FQN="clang::LazyOffsetPtr::LazyOffsetPtr<T, OffsT, Get>", NM="_ZN5clang13LazyOffsetPtrC1Ey",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang13LazyOffsetPtrC1Ey")
  //</editor-fold>
  protected /*explicit*/ LazyOffsetPtr(long/*uint64_t*/ Offset, ExternalASTSource$OffsT2T<T> getter, boolean NullIsTypePointer) {
    // : Ptr((Offset << 1) | 0x01) 
    //START JInit
    this.Ptr = Long.valueOf((Offset << 1) | 0x01L);
    //END JInit
    assert ((Offset << 1 >>> 1) == Offset) : "Offsets must require < 63 bits";
    if (Offset == 0L) {
      Ptr = null;
    }
    this.GetT = getter;
    this.NullIsTypePointer = NullIsTypePointer;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LazyOffsetPtr::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 339,
   FQN="clang::LazyOffsetPtr::operator=", NM="_ZN5clang13LazyOffsetPtraSEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang13LazyOffsetPtraSEPT_")
  //</editor-fold>
  public final LazyOffsetPtr<T/*, OffsT, Get*/> /*&*/ $assign(T /*P*/ Ptr) {
    this.Ptr = /*reinterpret_cast_long*//*uint64_t*/(Ptr);
    return this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LazyOffsetPtr::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 344,
   FQN="clang::LazyOffsetPtr::operator=", NM="_ZN5clang13LazyOffsetPtraSEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZN5clang13LazyOffsetPtraSEy")
  //</editor-fold>
  public final LazyOffsetPtr<T/*, OffsT, Get*/> /*&*/ $assign(long/*uint64_t*/ Offset) {
    assert ((Offset << 1 >>> 1) == Offset) : "Offsets must require < 63 bits";
    if (Offset == 0) {
      Ptr = null;
    } else {
      Ptr = Long.valueOf((Offset << 1) | 0x01L);
    }
    
    return this;
  }

  
  /// \brief Whether this pointer is non-NULL.
  ///
  /// This operation does not require the AST node to be deserialized.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyOffsetPtr::operator bool">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 357,
   FQN="clang::LazyOffsetPtr::operator bool", NM="_ZNK5clang13LazyOffsetPtrcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZNK5clang13LazyOffsetPtrcvbEv")
  //</editor-fold>
  public final boolean $bool() /*const*/ {
    return (NullIsTypePointer && Native.$not(Ptr)) || (Ptr != null);
  }

  
  /// \brief Whether this pointer is non-NULL.
  ///
  /// This operation does not require the AST node to be deserialized.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyOffsetPtr::isValid">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 362,
   FQN="clang::LazyOffsetPtr::isValid", NM="_ZNK5clang13LazyOffsetPtr7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZNK5clang13LazyOffsetPtr7isValidEv")
  //</editor-fold>
  public final boolean isValid() /*const*/ {
    return Ptr != null;
  }

  
  /// \brief Whether this pointer is currently stored as an offset.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyOffsetPtr::isOffset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 365,
   FQN="clang::LazyOffsetPtr::isOffset", NM="_ZNK5clang13LazyOffsetPtr8isOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZNK5clang13LazyOffsetPtr8isOffsetEv")
  //</editor-fold>
  public final boolean isOffset() /*const*/ {
//    return Ptr & 0x01;
    if (Ptr instanceof Long) {
      assert ((((Long)Ptr).longValue() & 0x01L) == 0x01L) : "Must be Long with last bit set: " + Long.toBinaryString((long)Ptr);
      return true;
    } else {
      return false;
    }
  }

  
  /// \brief Retrieve the pointer to the AST node that this lazy pointer
  ///
  /// \param Source the external AST source.
  ///
  /// \returns a pointer to the AST node.
  //<editor-fold defaultstate="collapsed" desc="clang::LazyOffsetPtr::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*should be >>>*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExternalASTSource.h", line = 372,
   FQN="clang::LazyOffsetPtr::get", NM="_ZNK5clang13LazyOffsetPtr3getEPNS_17ExternalASTSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExternalASTSource.cpp -nm=_ZNK5clang13LazyOffsetPtr3getEPNS_17ExternalASTSourceE")
  //</editor-fold>
  public final T /*P*/ get(ExternalASTSource /*P*/ Source) /*const*/ {
    if (isOffset()) {
      assert ((Source != null)) : "Cannot deserialize a lazy pointer without an AST source";
      assert ((((Long)Ptr).longValue() & 0x01L) == 0x01L);
      Ptr = /*reinterpret_cast_long*/(T)/*uint64_t*/(GetT.$call(Source, (((Long)Ptr).longValue() >>> 1)));
    }
    T Out = (T)reinterpret_cast(Object.class /*P*/, Ptr);
    if (Out == null && NullIsTypePointer) {
      Out = (T)create_const_type$const_ptr((Object[])null);
    }
    return Out;
  }

  
  @Override public String toString() {
    return "" + "Ptr=" + Ptr; // NOI18N
  }

  protected LazyOffsetPtr(LazyOffsetPtr $Prm0) {
    this.GetT = $Prm0.GetT;
    this.Ptr = $Prm0.Ptr;
    this.NullIsTypePointer = $Prm0.NullIsTypePointer;
  }
  
  protected final LazyOffsetPtr $assign(LazyOffsetPtr $Prm0) {
    assert (this.GetT == $Prm0.GetT);
    assert (this.NullIsTypePointer == $Prm0.NullIsTypePointer);
    this.Ptr = $Prm0.Ptr;
    return this;
  }

  protected final LazyOffsetPtr $assignMove(LazyOffsetPtr $Prm0) {
    assert this != $Prm0;
    assert (this.GetT == $Prm0.GetT);
    assert (this.NullIsTypePointer == $Prm0.NullIsTypePointer);
    this.Ptr = $Prm0.Ptr;
    $Prm0.Ptr = 0;
    return this;
  }
}
