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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import static org.clank.support.Native.$tryClone;


/// \brief Wrapper for void* pointer.
/// \tparam PtrTy Either a pointer type like 'T*' or a type that behaves like
///               a pointer.
///
/// This is a very simple POD type that wraps a pointer that the Parser
/// doesn't know about but that Sema or another client does.  The PtrTy
/// template argument is used to make sure that "Decl" pointers are not
/// compatible with "Type" pointers for example.
/*template <class PtrTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 45,
 FQN="clang::OpaquePtr", NM="_ZN5clang9OpaquePtrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang9OpaquePtrE")
//</editor-fold>
public class OpaquePtr</*class*/ PtrTy>  implements NativeCloneable<OpaquePtr>, Native.Native$Bool {
  private PtrTy/*void P*/ Ptr/* = null*/;
  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::OpaquePtr<PtrTy>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 48,
   FQN="clang::OpaquePtr::OpaquePtr<PtrTy>", NM="_ZN5clang9OpaquePtrC1EPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang9OpaquePtrC1EPv")
  //</editor-fold>
  public /*explicit*/ OpaquePtr(Object/*void P*/ Ptr) {
    // : Ptr(Ptr) 
    assert !(Ptr instanceof OpaquePtr) : "copy constructor expected to be called instead";
    //START JInit
    this.Ptr = $tryClone((PtrTy)Ptr);
    //END JInit
  }

  
  /*typedef llvm::PointerLikeTypeTraits<PtrTy> Traits*/
//  public final class Traits extends PointerLikeTypeTraits<PtrTy>{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::OpaquePtr<PtrTy>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 53,
   FQN="clang::OpaquePtr::OpaquePtr<PtrTy>", NM="_ZN5clang9OpaquePtrC1EDn",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang9OpaquePtrC1EDn")
  //</editor-fold>
  public OpaquePtr() {
    this((PtrTy)null);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::make">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 55,
   FQN="clang::OpaquePtr::make", NM="_ZN5clang9OpaquePtr4makeET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang9OpaquePtr4makeET_")
  //</editor-fold>
  public static </*class*/ PtrTy> OpaquePtr<PtrTy> make(PtrTy P) {
    OpaquePtr<PtrTy> OP = new OpaquePtr<>();
    OP.set(P);
    return OP;
  }

  
  /// \brief Returns plain pointer to the entity pointed by this wrapper.
  /// \tparam PointeeT Type of pointed entity.
  ///
  /// It is identical to getPtrAs<PointeeT*>.
  /*template <typename PointeeT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::getPtrTo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 61,
   FQN="clang::OpaquePtr::getPtrTo", NM="Tpl__ZNK5clang9OpaquePtr8getPtrToEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=Tpl__ZNK5clang9OpaquePtr8getPtrToEv")
  //</editor-fold>
  public </*typename*/ PointeeT> PointeeT /*P*/ getPtrTo() /*const*/ {
    return (PointeeT) get();
  }

  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 45)
  public /*inline*/ OpaquePtr<PtrTy> /*&*/ $assign(OpaquePtr<?> /*&&*/$Prm0) {
    this.Ptr = $tryClone((PtrTy)$Prm0.Ptr);
    return /*Deref*/this;
  }
  public /*inline*/ OpaquePtr(OpaquePtr<?> /*&&*/$Prm0) {
    // JAVA: sometimes this ctr is used for new OpaquePtr<>(null) vs OpaquePtr(Object) declared above
    this.Ptr = $Prm0 == null ? null : $tryClone((PtrTy)$Prm0.Ptr);
  }
  
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 45)
  public /*inline*/ OpaquePtr<PtrTy> /*&*/ $assignMove(OpaquePtr<?> /*&&*/$Prm0) {
    assert this != $Prm0;
    this.Ptr = $tryClone((PtrTy)$Prm0.Ptr);
    $Prm0.Ptr = null;
    return /*Deref*/this;
  }
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 45)
  public /*inline*/ OpaquePtr(JD$Move _dparam, OpaquePtr<PtrTy> /*&&*/$Prm0) {
    this.Ptr = $Prm0.Ptr;
    $Prm0.Ptr = null;
  }
  
  /// \brief Returns pointer converted to the specified type.
  /// \tparam PtrT Result pointer type.  There must be implicit conversion
  ///              from PtrTy to PtrT.
  ///
  /// In contrast to getPtrTo, this method allows the return type to be
  /// a smart pointer.
  /*template <typename PtrT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::getPtrAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 71,
   FQN="clang::OpaquePtr::getPtrAs", NM="Tpl__ZNK5clang9OpaquePtr8getPtrAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=Tpl__ZNK5clang9OpaquePtr8getPtrAsEv")
  //</editor-fold>
  public </*typename*/ PtrT> PtrT getPtrAs() /*const*/ {
    return (PtrT) get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 75,
   FQN="clang::OpaquePtr::get", NM="_ZNK5clang9OpaquePtr3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang9OpaquePtr3getEv")
  //</editor-fold>
  public PtrTy get() /*const*/ {
//    return PointerLikeTypeTraits<PtrTy>.getFromVoidPointer(Ptr);
    return $tryClone((PtrTy)Ptr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 79,
   FQN="clang::OpaquePtr::set", NM="_ZN5clang9OpaquePtr3setET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang9OpaquePtr3setET_")
  //</editor-fold>
  public void set(PtrTy P) {
    Ptr = $tryClone(/*PointerLikeTypeTraits<PtrTy>.getAsVoidPointer*/(P));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 83,
   FQN="clang::OpaquePtr::operator bool", NM="_ZNK5clang9OpaquePtrcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang9OpaquePtrcvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return Native.$noteq(Ptr, null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::getAsOpaquePtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 85,
   FQN="clang::OpaquePtr::getAsOpaquePtr", NM="_ZNK5clang9OpaquePtr14getAsOpaquePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang9OpaquePtr14getAsOpaquePtrEv")
  //</editor-fold>
  public Object/*void P*/ getAsOpaquePtr() /*const*/ {
    return $tryClone(Ptr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::getFromOpaquePtr">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 86,
   FQN="clang::OpaquePtr::getFromOpaquePtr", NM="_ZN5clang9OpaquePtr16getFromOpaquePtrEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang9OpaquePtr16getFromOpaquePtrEPv")
  //</editor-fold>
  public static </*class*/ PtrTy> OpaquePtr<PtrTy> getFromOpaquePtr(Object/*void P*/ P) {
    return new OpaquePtr<PtrTy>((PtrTy)P);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public OpaquePtr clone() { 
    return new OpaquePtr(this.Ptr); 
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 75,
   FQN="clang::OpaquePtr::get", NM="_ZNK5clang9OpaquePtrINS_8QualTypeEE3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang9OpaquePtrINS_8QualTypeEE3getEv")
  //</editor-fold>
  public QualType getQualType() /*const*/ {
//    return PointerLikeTypeTraitsQualType.getFromVoidPointer(Ptr);
    assert Ptr instanceof QualType || Ptr == null : "unexpected " + NativeTrace.getIdentityStr(Ptr);
    return Ptr == null ? new QualType() : new QualType((QualType)Ptr);
  }
  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 75,
   FQN="clang::OpaquePtr::get", NM="_ZNK5clang9OpaquePtrINS_12TemplateNameEE3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang9OpaquePtrINS_12TemplateNameEE3getEv")
  //</editor-fold>
  public TemplateName getTemplateName() /*const*/ {
//    return PointerLikeTypeTraitsTemplateName.getFromVoidPointer(Ptr);
    assert Ptr instanceof TemplateName || Ptr == null : "unexpected " + NativeTrace.getIdentityStr(Ptr);
    return Ptr == null ? new TemplateName() : (TemplateName)Ptr;
  }
  //<editor-fold defaultstate="collapsed" desc="clang::OpaquePtr::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Ownership.h", line = 75,
   FQN="clang::OpaquePtr::get", NM="_ZNK5clang9OpaquePtrINS_12DeclGroupRefEE3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZNK5clang9OpaquePtrINS_12DeclGroupRefEE3getEv")
  //</editor-fold>
  public DeclGroupRef getDeclGroupRef() /*const*/ {
//    return PointerLikeTypeTraitsDeclGroupRef.getFromVoidPointer(Ptr);
    assert Ptr instanceof DeclGroupRef || Ptr == null : "unexpected " + NativeTrace.getIdentityStr(Ptr);
    return Ptr == null ? new DeclGroupRef() : (DeclGroupRef)Ptr;
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Ptr=" + Ptr; // NOI18N
  }
}
