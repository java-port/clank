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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;


/// \brief Typed tracking ref.
///
/// Track refererences of a particular type.  It's useful to use this for \a
/// MDNode and \a ValueAsMetadata.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 100,
 FQN="llvm::TypedTrackingMDRef", NM="_ZN4llvm18TypedTrackingMDRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZN4llvm18TypedTrackingMDRefE")
//</editor-fold>
public class TypedTrackingMDRef</*class*/ T>  implements NativePOD<TypedTrackingMDRef<T>>, NativeMoveable<TypedTrackingMDRef<T>>, Destructors.ClassWithDestructor, Native.NativeComparable<TypedTrackingMDRef<T>> {
  private final TrackingMDRef Ref;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::TypedTrackingMDRef<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 104,
   FQN="llvm::TypedTrackingMDRef::TypedTrackingMDRef<T>", NM="_ZN4llvm18TypedTrackingMDRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZN4llvm18TypedTrackingMDRefC1Ev")
  //</editor-fold>
  public TypedTrackingMDRef() {
    Ref = new TrackingMDRef();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::TypedTrackingMDRef<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 105,
   FQN="llvm::TypedTrackingMDRef::TypedTrackingMDRef<T>", NM="_ZN4llvm18TypedTrackingMDRefC1EPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZN4llvm18TypedTrackingMDRefC1EPT_")
  //</editor-fold>
  public /*explicit*/ TypedTrackingMDRef(T /*P*/ MD) {
    // : Ref(static_cast<Metadata * >(MD)) 
    //START JInit
    this.Ref = new TrackingMDRef(((/*static_cast*/Metadata /*P*/ )(MD)));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::TypedTrackingMDRef<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 107,
   FQN="llvm::TypedTrackingMDRef::TypedTrackingMDRef<T>", NM="_ZN4llvm18TypedTrackingMDRefC1EONS_18TypedTrackingMDRefIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZN4llvm18TypedTrackingMDRefC1EONS_18TypedTrackingMDRefIT_EE")
  //</editor-fold>
  public TypedTrackingMDRef(JD$Move _dparam, final TypedTrackingMDRef<T> /*&&*/X) {
    // : Ref(std::move(X.Ref)) 
    //START JInit
    this.Ref = /*ParenListExpr*/new TrackingMDRef(std.move(X.Ref));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::TypedTrackingMDRef<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 108,
   FQN="llvm::TypedTrackingMDRef::TypedTrackingMDRef<T>", NM="_ZN4llvm18TypedTrackingMDRefC1ERKNS_18TypedTrackingMDRefIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZN4llvm18TypedTrackingMDRefC1ERKNS_18TypedTrackingMDRefIT_EE")
  //</editor-fold>
  public TypedTrackingMDRef(final /*const*/ TypedTrackingMDRef<T> /*&*/ X) {
    // : Ref(X.Ref) 
    //START JInit
    this.Ref = /*ParenListExpr*/new TrackingMDRef(X.Ref);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::operator=">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 109,
   FQN="llvm::TypedTrackingMDRef::operator=", NM="_ZN4llvm18TypedTrackingMDRefaSEONS_18TypedTrackingMDRefIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZN4llvm18TypedTrackingMDRefaSEONS_18TypedTrackingMDRefIT_EE")
  //</editor-fold>
  public TypedTrackingMDRef<T> /*&*/ $assignMove(final TypedTrackingMDRef<T> /*&&*/X) {
    Ref.$assignMove(std.move(X.Ref));
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::operator=">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 113,
   FQN="llvm::TypedTrackingMDRef::operator=", NM="_ZN4llvm18TypedTrackingMDRefaSERKNS_18TypedTrackingMDRefIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZN4llvm18TypedTrackingMDRefaSERKNS_18TypedTrackingMDRefIT_EE")
  //</editor-fold>
  public TypedTrackingMDRef<T> /*&*/ $assign(final /*const*/ TypedTrackingMDRef<T> /*&*/ X) {
    Ref.$assign(X.Ref);
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 118,
   FQN="llvm::TypedTrackingMDRef::get", NM="_ZNK4llvm18TypedTrackingMDRef3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZNK4llvm18TypedTrackingMDRef3getEv")
  //</editor-fold>
  public T /*P*/ get() /*const*/ {
    return (T /*P*/ )Ref.get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::operator type-parameter-0-0 * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 119,
   FQN="llvm::TypedTrackingMDRef::operator type-parameter-0-0 * ", NM="_ZNK4llvm18TypedTrackingMDRefcvPT_Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZNK4llvm18TypedTrackingMDRefcvPT_Ev")
  //</editor-fold>
  public T /*P*/ $T$P() /*const*/ {
    return get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 120,
   FQN="llvm::TypedTrackingMDRef::operator->", NM="_ZNK4llvm18TypedTrackingMDRefptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZNK4llvm18TypedTrackingMDRefptEv")
  //</editor-fold>
  public T /*P*/ $arrow() /*const*/ {
    return get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 121,
   FQN="llvm::TypedTrackingMDRef::operator*", NM="_ZNK4llvm18TypedTrackingMDRefdeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZNK4llvm18TypedTrackingMDRefdeEv")
  //</editor-fold>
  public T /*&*/ $star() /*const*/ {
    return $Deref(get());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 123,
   FQN="llvm::TypedTrackingMDRef::operator==", NM="_ZNK4llvm18TypedTrackingMDRefeqERKNS_18TypedTrackingMDRefIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZNK4llvm18TypedTrackingMDRefeqERKNS_18TypedTrackingMDRefIT_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ TypedTrackingMDRef<T> /*&*/ X) /*const*/ {
    return Native.$eq(Ref, X.Ref);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 124,
   FQN="llvm::TypedTrackingMDRef::operator!=", NM="_ZNK4llvm18TypedTrackingMDRefneERKNS_18TypedTrackingMDRefIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZNK4llvm18TypedTrackingMDRefneERKNS_18TypedTrackingMDRefIT_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ TypedTrackingMDRef<T> /*&*/ X) /*const*/ {
    return Native.$noteq(Ref, X.Ref);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 126,
   FQN="llvm::TypedTrackingMDRef::reset", NM="_ZN4llvm18TypedTrackingMDRef5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZN4llvm18TypedTrackingMDRef5resetEv")
  //</editor-fold>
  public void reset() {
    Ref.reset();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 127,
   FQN="llvm::TypedTrackingMDRef::reset", NM="_ZN4llvm18TypedTrackingMDRef5resetEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZN4llvm18TypedTrackingMDRef5resetEPT_")
  //</editor-fold>
  public void reset(T /*P*/ MD) {
    Ref.reset(((/*static_cast*/Metadata /*P*/ )(MD)));
  }

  
  /// \brief Check whether this has a trivial destructor.
  //<editor-fold defaultstate="collapsed" desc="llvm::TypedTrackingMDRef::hasTrivialDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TrackingMDRef.h", line = 130,
   FQN="llvm::TypedTrackingMDRef::hasTrivialDestructor", NM="_ZNK4llvm18TypedTrackingMDRef20hasTrivialDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZNK4llvm18TypedTrackingMDRef20hasTrivialDestructorEv")
  //</editor-fold>
  public boolean hasTrivialDestructor() /*const*/ {
    return Ref.hasTrivialDestructor();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void $destroy() {
    Ref.$destroy();
  }

  @Override
  public TypedTrackingMDRef<T> clone() {
    return new TypedTrackingMDRef<>(this);
  }

  @Override
  public TypedTrackingMDRef<T> move() {
    return new TypedTrackingMDRef<>(JD$Move.INSTANCE, this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Ref=" + Ref; // NOI18N
  }
}
